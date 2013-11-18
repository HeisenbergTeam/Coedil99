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

import ui.VisualizzaDistinta;


public class Main {
	
	public static void main(String args[]){
		System.out.println("Start");
		
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
		distinta.setElementoStrutturale("Cardine porta");
		
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
		}

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
		
		VisualizzaDistinta.start(args);
		
	}
	
}
