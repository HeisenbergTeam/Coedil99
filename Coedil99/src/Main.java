

import modello_di_dominio.LavorazionePezzo;
import modello_di_dominio.Pezzo;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Main {
	
	public static void main(String[] args){
		
		try {
			PersistentTransaction t = modello_di_dominio.Coedil99PersistentManager.instance().getSession().beginTransaction();
			
			modello_di_dominio.DAOFactory lDAOFactory = modello_di_dominio.DAOFactory.getDAOFactory();
			
			LavorazionePezzo p = lDAOFactory.getLavorazionePezzoDAO().createLavorazionePezzo();
			p.setDescrizione("Ciao");
			lDAOFactory.getLavorazionePezzoDAO().save(p);
			
			t.commit();
			
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
