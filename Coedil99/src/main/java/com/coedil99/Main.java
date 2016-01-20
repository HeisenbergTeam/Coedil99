package com.coedil99;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import org.orm.PersistentException;

import java.util.Date;


public class Main {
	
	public static void main(String args[]){
        //TEST IntelliJ IDEA
		System.out.println("Start");



		Date date = new Date();
		
		Destinazione dest = new Destinazione();
		dest.setVia("Via Strinella, 37");
		
		Ordine ordine = DAOFactory.getDAOFactory().getOrdineDAO().createOrdine();
		ordine.setDataCreazione(date);
		ordine.setDestinazione(dest);
		
		Date dateCommessa = new Date();
		
		Commessa commessa = DAOFactory.getDAOFactory().getCommessaDAO().createCommessa();
		commessa.setOrdine(ordine);
		commessa.setPriorita(10);
		commessa.setDataCreazione(dateCommessa);
		
		Distinta distinta = DAOFactory.getDAOFactory().getDistintaDAO().createDistinta();
		distinta.setDataInizio(date);
		distinta.setCommessa(commessa);
		distinta.setModello("H17DCH");
		distinta.setRevisione(2);
		distinta.setElementoStrutturale("Porta");

		Fornitore fornitore = DAOFactory.getDAOFactory().getFornitoreDAO().createFornitore();
		fornitore.setNome("ItalTubi");

		try {
			DAOFactory.getDAOFactory().getFornitoreDAO().save(fornitore);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().createDescrizionePezzo();
		descrizionePezzo.setNome("Tubo alluminio");
		descrizionePezzo.setPeso(1.0f);
		descrizionePezzo.setDiametro(0.020f);
		//TODO: fornitore come classe
		descrizionePezzo.setFornitore(fornitore);

		try {
			DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(descrizionePezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sagoma sagoma =  DAOFactory.getDAOFactory().getSagomaDAO().createSagoma();
		sagoma.setImg("path/img.jpg");
		
		LavorazionePezzo lavorazionePezzo = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().createLavorazionePezzo();
		lavorazionePezzo.setDescrizione("Non lavorato");
		lavorazionePezzo.setMisuraDiTaglio(15.0f);
		lavorazionePezzo.setPeso(1.0f);
		lavorazionePezzo.setSagoma(sagoma);
		
		Date dateArrivo = new Date();
		
		Pezzo pezzo = DAOFactory.getDAOFactory().getPezzoDAO().createPezzo();
		pezzo.setDescrizionePezzo(descrizionePezzo);
		//pezzo.setDataArrivo(dateArrivo);
		pezzo.setQuantita(5);

		try {
			DAOFactory.getDAOFactory().getPezzoDAO().save(pezzo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RigaDistinta rigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().createRigaDistinta();
		rigaDistinta.setDistinta(distinta);
		rigaDistinta.setIndicazione("Tubo porta");
		rigaDistinta.setPezzo(pezzo);
		rigaDistinta.setLavorazionePezzo(lavorazionePezzo);
		
		
		try {
			DAOFactory.getDAOFactory().getOrdineDAO().save(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		/*
		try {
			System.out.print(DAOFactory.getDAOFactory().getOrdineDAO()
					.getOrdineByORMID(ordine.getID()).getDataCreazione()
					.toString() + "\n");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.print(DAOFactory.getDAOFactory().getCommessaDAO()
					.getCommessaByORMID(commessa.getID()).getDataCreazione()
					.toString() + "\n");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.print(DAOFactory.getDAOFactory().getCommessaDAO()
					.getCommessaByORMID(commessa.getID()).getDataCreazione()
					.toString() + "\n");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
				
		//TEST CREAZIONE CON GESTORI
		UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
		//GestoreDistinta gestoreDistinta = (GestoreDistinta) gsp.getServizio("GestoreDistintaDAO");
		//GestoreRigaDistinta gestoreRigaDistinta = (GestoreRigaDistinta) gsp.getServizio("GestoreRigaDistintaDAO");
		//GestorePezzi gestorePezzi = (GestorePezzi) gsp.getServizio("GestorePezziDAO");
		Log log = (Log) gsp.getServizio("LogStdout");
		Sessione session = (Sessione) gsp.getServizio("SessionePrototipo");

		
	}
	
}
