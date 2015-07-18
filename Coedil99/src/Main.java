import java.util.Date;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.DescrizionePezzo;
import modello_di_dominio.Destinazione;
import modello_di_dominio.Distinta;
import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Ordine;
import modello_di_dominio.Pezzo;
import modello_di_dominio.RigaDistinta;
import modello_di_dominio.Sagoma;

import org.orm.PersistentException;

import controller.ui.LoginController;

import servizi.GestoreDistinta;
import servizi.GestoreOrdine;
import servizi.GestorePezzi;
import servizi.GestoreRigaDistinta;
import servizi.GestoreServizi;
import servizi.Log;
import servizi.Sessione;
import servizi.impl.GestoreServiziPrototipo;
import ui.MainApplication;
import ui.VisualizzaDistinta;


public class Main {
	
	public static void main(String args[]){
        //TEST IntelliJ IDEA
		System.out.println("Start");
		/*
		Date date = new Date();
		
		Destinazione dest = new Destinazione();
		dest.setVia("Via Strinella, 37");
		
		Ordine ordine = new Ordine();
		ordine.setDataCreazione(date);
		ordine.setDestinazione(dest);
		
		Date dateCommessa = new Date();
		
		Commessa commessa = ordine.creaCommessa();
		commessa.setPriorita(10);
		commessa.setDataCreazione(dateCommessa);
		
		Distinta distinta = new Distinta();
		distinta.setDataInizio(date);
		distinta.setCommessa(commessa);
		distinta.setModello("H17DCH");
		distinta.setRevisione(2);
		distinta.setElementoStrutturale("Porta");
		
		DescrizionePezzo descrizionePezzo = new DescrizionePezzo();
		descrizionePezzo.setNome("Tubo alluminio");
		descrizionePezzo.setPeso(1.0f);
		descrizionePezzo.setDiametro(0.020f);
		//TODO: fornitore come classe
		descrizionePezzo.setFornitore("ItalSystem");
		
		Sagoma sagoma = new Sagoma();
		sagoma.setImg("path/img.jpg");
		
		LavorazionePezzo lavorazionePezzo = new LavorazionePezzo();
		lavorazionePezzo.setDescrizione("Non lavorato");
		lavorazionePezzo.setMisuraDiTaglio(15.0f);
		lavorazionePezzo.setPeso(1.0f);
		lavorazionePezzo.setSagoma(sagoma);
		
		Date dateArrivo = new Date();
		
		Pezzo pezzo = new Pezzo();
		pezzo.setDescrizionePezzo(descrizionePezzo);
		pezzo.setDataArrivo(dateArrivo);
		pezzo.setQuantita(5);
		
		RigaDistinta rigaDistinta = new RigaDistinta();
		rigaDistinta.setDistinta(distinta);
		rigaDistinta.setIndicazione("Tubo porta");
		rigaDistinta.setPezzo(pezzo);
		rigaDistinta.setLavorazionePezzo(lavorazionePezzo);
		
		
		try {
			DAOFactory.getDAOFactory().getOrdineDAO().save(ordine);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
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
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		GestoreOrdine gestoreOrdine = (GestoreOrdine) gsp.getServizio("GestoreOrdineDAO");
		GestoreDistinta gestoreDistinta = (GestoreDistinta) gsp.getServizio("GestoreDistintaDAO");
		GestoreRigaDistinta gestoreRigaDistinta = (GestoreRigaDistinta) gsp.getServizio("GestoreRigaDistintaDAO");
		GestorePezzi gestorePezzi = (GestorePezzi) gsp.getServizio("GestorePezziDAO");
		Log log = (Log) gsp.getServizio("LogStdout");
		Sessione session = (Sessione) gsp.getServizio("SessionePrototipo");
		
		Destinazione dest2 = gestoreOrdine.creaDestinazione("Via Strinella, 371");
		
		Ordine ordine2 = gestoreOrdine.creaOrdine(dest2,new Date());
		
		Commessa commessa2 = gestoreOrdine.creaCommessa(ordine2, 10, new Date());
		
		Distinta distinta2 = gestoreDistinta.creaDistinta(new Date(), commessa2, 2, "Modello Prova es PORTONE3AE4K", "Elemento strutturale prova es Portone");
		
		DescrizionePezzo descrizionePezzo2 = gestorePezzi.creaDescrizionePezzo("Tubo alluminioz", 1.0f, 0.020f, "ItalSystemz");
		
		Pezzo pezzo2 = gestorePezzi.creaPezzo(descrizionePezzo2, new Date(), 4);
		
		Sagoma sagoma2 = gestoreRigaDistinta.creaSagoma("pathImgZ");
		
		LavorazionePezzo lavorazionePezzo2 = gestoreRigaDistinta.creaLavorazionePezzo("Non lavoratoz", 15.0f, 1.0f, sagoma2);
		
		RigaDistinta rigaDistinta2 = gestoreRigaDistinta.creaRigaDistinta(pezzo2, distinta2, lavorazionePezzo2, "Tubo portaz");
				
		
		//TEST CANCELLAZIONE CON GESTORI
		
		//IT WORKS
		//gestoreOrdine.cancellaOrdine(ordine2);
		
		//IT WORKS
		//gestoreDistinta.cancellaDistinta(distinta2);
				
		//IT WORKS
		//gestoreRigaDistinta.cancellaRigaDistinta(rigaDistinta2);
		
		//TODO: FIX since it doesn't work because of no deleteAndDisassociate (because of model mistake), RigaDistinta, LavorazionePezzo,DescrizionePezzo,Sagoma,RigaDistinta
		//gestorePezzi.cancellaPezzo(pezzo2);
		
		
		
		//MainApplication mainGUI = new MainApplication();
		//mainGUI.main(args);
		
		VisualizzaDistinta.start(args);
		
	}
	
}
