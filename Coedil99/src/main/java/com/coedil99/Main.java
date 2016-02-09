package com.coedil99;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.dominio.builder.Builder;
import org.orm.PersistentException;

import java.util.Date;


public class Main {
	
	public static void main(String args[]){
        //TEST IntelliJ IDEA
		System.out.println("Start");



		Date date = new Date();

		Destinazione dest = new Builder.DestinazioneBuilder().setVia("Via Garibaldi").build();

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
		pezzo.setQuantitaOrdinate(5);

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
		rigaDistinta.setQuantitaRigaDistinta(3);
		
		try {
			DAOFactory.getDAOFactory().getOrdineDAO().save(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RDA rda = DAOFactory.getDAOFactory().getRDADAO().createRDA();
		rda.setFornitore(fornitore);
		rda.setDescrizione("descizione rda");
		rda.setDataArrivoEffettiva(date);
		rda.setDataArrivoPrevista(date);
		rda.setDataCreazione(date);

		try {
			DAOFactory.getDAOFactory().getRDADAO().save(rda);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RigaRDA rigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().createRigaRDA();
		rigaRDA.setIndicazione("indicazione riga rda");
		rigaRDA.setPezzo(pezzo);
		//rigaRDA.setQuantitaPezziOrdinati(10);
		rigaRDA.setRda(rda);

		try {
			DAOFactory.getDAOFactory().getRigaRDADAO().save(rigaRDA);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date dateNow = new Date();
		int quantitaOrdinate = 0;
		int quantitaArrivate = 0;
		int quantitaUtilizzate = 0;
		int quantitaDisponibili = 0;
		try {
			RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery("PezzoID = 1",null);
			for (int i = 0; i < arrayRigaRDA.length; i++) {
				quantitaOrdinate = quantitaOrdinate + arrayRigaRDA[i].getPezzo().getQuantitaOrdinate();

				RDA rdaQuantita = arrayRigaRDA[i].getRda();
				if (rdaQuantita.getDataArrivoEffettiva().compareTo(dateNow) <= 0) {
					quantitaArrivate = quantitaArrivate + arrayRigaRDA[i].getPezzo().getQuantitaOrdinate();
				}
			}

			RigaDistinta[] arrayRigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().listRigaDistintaByQuery("PezzoID = 1",null);
			for (int i = 0; i < arrayRigaDistinta.length; i++) {
				quantitaUtilizzate = quantitaUtilizzate + arrayRigaDistinta[i].getQuantitaRigaDistinta();
			}

			quantitaDisponibili = quantitaArrivate - quantitaUtilizzate;

			System.out.print("Quantità ordinate: "+quantitaOrdinate+" - Quantità arrivate: "+quantitaArrivate+" - Quantità utilizzate: "+quantitaUtilizzate+" - Quantità disponibili: "+quantitaDisponibili);

		} catch (PersistentException e) {
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
