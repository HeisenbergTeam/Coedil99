package servizi;
/**
 * 
 */
import servizi.impl.GestoreServiziPrototipo;
import modello_di_dominio.DAOFactory;
import modello_di_dominio.DAOFactoryImpl;
/**
 * 
 * @author mw
 *
 */
public abstract class GestoreServizi {
/**
 * 
 */
	private static GestoreServizi _instance = new GestoreServiziPrototipo();
/**
 * getGestoreServizi
 * @return
 */
	public static GestoreServizi getGestoreServizi() {
		return _instance;
	}
/**
 * getServizio
 * @param classname
 * @return
 */
	public abstract Servizio getServizio(String classname);

}