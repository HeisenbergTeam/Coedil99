import java.util.Date;

import modello_di_dominio.Commessa;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.Distinta;
import modello_di_dominio.Ordine;

import org.orm.PersistentException;

import ui.VisualizzaOrdine;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		System.out.println("Start");

		VisualizzaOrdine.start(args);

		Date date = new Date();
		Ordine ordine = new Ordine();

		ordine.setDataCreazione(date);
		ordine.creaCommessa();
		Commessa commessa = ordine.getCommesse().toArray()[0];
		commessa.setDataCreazione(date);
		commessa.creaDistinta();
		Distinta distinta = commessa.getDistinta();
		distinta.setDataInizio(date);

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

	}

}
