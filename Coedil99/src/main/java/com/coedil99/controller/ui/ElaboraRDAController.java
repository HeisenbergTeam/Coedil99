package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.servizi.GestoreServizi;
import com.coedil99.servizi.Log;
import com.coedil99.servizi.Sessione;
import com.coedil99.servizi.impl.GestoreServiziPrototipo;
import com.coedil99.utilita.FilesOp;
import com.coedil99.utilita.Parsers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.orm.PersistentException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ElaboraRDAController implements Initializable {
	
    //@FXML private ListView<RigaRDA> listPezziRDA;
    @FXML private Label lbl_ordine_rda;
    @FXML private Label lbl_fornitore_rda;
    @FXML private Label lbl_data_consegna_prevista_rda;
    @FXML private Label lbl_data_consegna_effettiva_rda;
    @FXML private Label lbl_ritardo_rda;
    
    @FXML private Label lbl_numero_ddt;
    @FXML private Label lbl_data_ddt;
    @FXML private Label lbl_codice_colata_ddt;

    @FXML private Button modificaDistButton;
    @FXML private Button salvaDistButton;
    @FXML private Button aggiungiPezzoButton;
    @FXML private Button modificaPezzoButton;
    @FXML private Button rimuoviPezzoButton;
    @FXML private Button btn_aggiungi_sagoma;
    @FXML private Button btn_modifica_sagoma;
    @FXML private Button btn_rimuovi_sagoma;
    
    @FXML private TitledPane righe_rda;
    @FXML private TitledPane informazioni_rda;
    
    @FXML private DatePicker datePicker = new DatePicker();
    @FXML private DatePicker dateConsegnaPicker = new DatePicker();

    private String pathSagoma="";

    private Map<String,Label> rdaLabels;
    private Map<String,TextField> rdaTextFields;
    private Map<String,Object> rigaRDANodes;
    private Map<String,Object> rigaRDATextFields;
    
    //private RigaRDA rigaSelezionata;
    
    //private RDADAO rdaDAO;
    //private RigaRDADAO rigaRDADAO;
    private OrdineDAO ordineDao;

    private Log log;
    private Sessione session;
    
    Ordine ordine;
    Commessa[] commesse;
    //RDA rda;
    //RigaRDA[] righeRDA;
    
    private Boolean modificandoRDA = false;
    private Boolean modificandoRigaRDA = false;

    private int oldIndex = -1;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		salvaDistButton.setDisable(true);
		modificaPezzoButton.setDisable(true);
		rimuoviPezzoButton.setDisable(true);

		//Caricamento servizi
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		ordineDao = DAOFactory.getDAOFactory().getOrdineDAO();

		//rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
		//rigaRDADAO = DAOFactory.getDAOFactory().getRigaRDADAO();

		log = (Log) gsp.getServizio("LogStdout");
		session = (Sessione) gsp.getServizio("SessionePrototipo");
		
		refreshList();
		
		refreshRDA();
	    
	    //rda labels
	    
	    rdaLabels = new HashMap<String,Label>();
	    //rdaLabels.put("modulo",lbl_modulo);
	    //rdaLabels.put("data",lbl_data);
	    //rdaLabels.put("cliente",lbl_cliente);
	    //rdaLabels.put("cartellino",lbl_cartellino);
	    
	    //rigaRDA nodes
	    
	    //rigaRDANodes = new HashMap<String,Object>();
	    //rigaRDANodes.put("codice", lbl_codice_pezzo);
	    
	}
	
/**
 * modificaDatiRDA
 */
	@FXML
	protected void modificaDatiRDA(){

	}
/**
 * 
 */
	@FXML
	protected void modificaRigaRDA(){
		
	}

    @FXML
    protected void rimuoviPezzo(){

    }
/**
 * 
 */
	@FXML 
	protected void salvaDatiRDA(){
		
	}
	
	private void refreshCommonDataRDA() {
		
	}
	
	private void refreshRDA() {
		
		refreshCommonDataRDA();

        lbl_ordine_rda.setText("PROSSIME ITERAZIONI");
	    
	}
	
	private void refreshList() {
	}

	protected void aggiornaCampiRigaRDA() {

	}


/**
 *  aggiungiPezzo
 */
	@FXML 
	protected void aggiungiPezzo(){

	}

}
