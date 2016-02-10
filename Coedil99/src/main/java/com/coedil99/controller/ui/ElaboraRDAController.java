package com.coedil99.controller.ui;

import com.coedil99.dominio.builder.Builder;
import com.coedil99.dominio.builder.Editor;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.PezzoDAO;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.modello_di_dominio.dao.RigaRDADAO;
import com.coedil99.utilita.Parsers;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Sessione;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import com.coedil99.ui.MainApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.hibernate.Transaction;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import java.net.URL;
import java.text.ParseException;
import java.util.*;

public class ElaboraRDAController implements Initializable {

    @FXML private TitledPane title_fornitore_rda_txt;

    @FXML public TableColumn<RigaRDA,String> cl_indicazione;
    @FXML public TableColumn<RigaRDA,String> cl_quantita;
    @FXML public TableView<RigaRDA> tbl_righeRDA;

    @FXML private TextField txt_ordine_rda;
    @FXML private TextField txt_fornitore_rda;
    @FXML private TextField txt_data_consegna_prevista_rda;
    @FXML private TextField txt_data_consegna_effettiva_rda;
    @FXML private TextField txt_ritardo_rda;

    @FXML private TextField txt_numero_ddt;
    @FXML private TextField txt_data_ddt;
    @FXML private TextField txt_codice_colata_ddt;

    @FXML private Button modificaDistButton;
    @FXML private Button salvaDistButton;
    @FXML private Button aggiungiPezzoButton;
    @FXML private Button btn_rimuoviPezzo;
    
    @FXML private TextField txt_codice_pezzo;
    @FXML private TextField txt_pezzo_quantita;
    
    @FXML private TitledPane righe_rda;
    @FXML private TitledPane informazioni_rda;
    @FXML private Button salvaDDTButton;

    @FXML private TextArea text_area_rda;
    @FXML private Button btn_salvaNote;
    @FXML private Button btn_modificaNote;

    @FXML private DatePicker datePicker = new DatePicker();
    @FXML private DatePicker dateConsegnaPicker = new DatePicker();

    private String pathSagoma="";
    private boolean modificandoDatiRDA;
    
    private RigaRDA rigaSelezionata = null;
    private RDA rda;
    
    private RDADAO rdaDAO;
    private PezzoDAO pezzoDAO;
    private RigaRDADAO rigaRDADAO;
    private OrdineDAO ordineDao;

    private Log log;
    private Sessione session;

    Ordine ordine;
    
    private Boolean modificandoRDA = false;
    private Boolean modificandoRigaRDA = false;

    private int oldIndex = -1;
    private Map<String,Label> rdaDDTLabels;
    private boolean modificandoDDTRDA;
    @FXML private Button modificaDDTButton;
    private boolean modificandoNoteRDA;

    private boolean nuovaRda = false;

    public void setAction(int action) {
        if (action == DefineControllerUi.ELABORA_RDA_NUOVA) {
            nuovaRda = true;

        } else {

            try {
                rda = DAOFactory.getDAOFactory().getRDADAO().getRDAByORMID(action);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
    }

    private void enableTextEdit() {
        //modificandoDatiRDA = false;
        modificaDatiRDA();
    }

    private void disableTextEdit() {

    }

    public void setTextEdit(TextField txtField, Boolean enabled){
        log.i(txtField.toString());
        txtField.setStyle("-fx-background-color: #EEEEEE;");
        txtField.setAlignment(Pos.CENTER);

        if(enabled) {
            txtField.setEditable(true);
        }else{
            txtField.setEditable(false);
        }
    }

    public void  refreshCampi()
    {
        setTextEdit(txt_ordine_rda,false);
        setTextEdit(txt_fornitore_rda,false);
        setTextEdit(txt_data_consegna_prevista_rda,false);
        setTextEdit(txt_data_consegna_effettiva_rda,false);
        setTextEdit(txt_ritardo_rda,false);

        setTextEdit(txt_codice_pezzo,false);
        setTextEdit(txt_pezzo_quantita,false);

        txt_fornitore_rda.setText(rda.getFornitore().getNome());
        txt_data_consegna_prevista_rda.setText(Parsers.printItalianDate(rda.getDataArrivoPrevista()));
        txt_data_consegna_effettiva_rda.setText(Parsers.printItalianDate(rda.getDataArrivoEffettiva()));
        txt_ritardo_rda.setText((rda.getDataArrivoEffettiva().getTime()-rda.getDataArrivoPrevista().getTime())/ 24 / 3600 / 1000+" giorni");
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
        UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
        log = (Log) gsp.getServizio("LogStdout");

        text_area_rda.setDisable(true);
        modificandoDatiRDA = false;
		salvaDistButton.setDisable(true);
		btn_rimuoviPezzo.setDisable(true);

        refreshCampi();

        setTextEdit(txt_numero_ddt,false);
        txt_numero_ddt.setText("PROSSIMA ITERAZIONE");
        setTextEdit(txt_data_ddt,false);
        txt_data_ddt.setText("PROSSIMA ITERAZIONE");
        setTextEdit(txt_codice_colata_ddt,false);
        txt_codice_colata_ddt.setText("PROSSIMA ITERAZIONE");
        modificaDDTButton.setDisable(true);
        salvaDDTButton.setDisable(true);
		//Caricamento servizi

		ordineDao = DAOFactory.getDAOFactory().getOrdineDAO();
        rigaRDADAO = DAOFactory.getDAOFactory().getRigaRDADAO();
        rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();


		session = (Sessione) gsp.getServizio("SessionePrototipo");

        tbl_righeRDA.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Object>() {

                    public void changed(ObservableValue<? extends Object> arg0,
                                        Object arg1, Object arg2) {


                        if((Integer) arg2 >= 0 && (Integer) arg2 < rda.righeRDA.size())
                        {
                            ElaboraRDAController.this.rigaSelezionata = rda.righeRDA.toArray()[(Integer)arg2];
                            ElaboraRDAController.this.btn_rimuoviPezzo.setDisable(false);

                            ElaboraRDAController.this.txt_codice_pezzo.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getNome());
                            ElaboraRDAController.this.txt_pezzo_quantita.setText(""+String.valueOf(rigaSelezionata.getPezzo().getQuantitaOrdinate()));
                        }

                    }
                });

        if (!nuovaRda && rda != null) {
            refreshTable();
            refreshRDA();
        } else {
            enableTextEdit();
        }

	}
	
/**
 * modificaDatiRDA
 */
	@FXML
	protected void modificaDatiRDA(){
        log.i("Modifica dei dati della RDA");



        //Check
        if(modificandoDatiRDA != false){
            modificandoDatiRDA = false;
            modificaDistButton.setText("Modifica");
            salvaDatiRDA();
            return;
        }
        setTextEdit(txt_data_consegna_prevista_rda,true);
        setTextEdit(txt_data_consegna_effettiva_rda,true);


        modificandoDatiRDA = true;

        modificaDistButton.setText("Annulla");
        //Abilito il salvataggio
        salvaDistButton.setDisable(false);
	}
/**
 * 
 */
	@FXML
	protected void modificaRigaRDA(){
		
	}

	@FXML 
	protected void salvaDatiRDA(){
        log.i("Salvataggio dati distinta");

        salvaDistButton.setDisable(true);


        if(modificandoDatiRDA != true){
            refreshRDA();
            return;
        }

        try {
            new Editor().modificaRDA(rda,null,null,Parsers.italianDateStringToDate(txt_data_consegna_effettiva_rda.getText()),Parsers.italianDateStringToDate(txt_data_consegna_prevista_rda.getText()),null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        refreshRDA();

        modificandoDatiRDA = false;
        modificaDistButton.setText("Modifica");
        modificaDistButton.setDisable(false);
	}
	
	private void refreshCommonDataRDA() {
		refreshCampi();
	}
	
	private void refreshRDA() {
		
		refreshCommonDataRDA();

        txt_ordine_rda.setText("PROSSIME ITERAZIONI");
        text_area_rda.setText(rda.getDescrizione());
	    
	}
	
	private void refreshTable() {

        ElaboraRDAController.this.txt_codice_pezzo.setText("");
        ElaboraRDAController.this.txt_pezzo_quantita.setText("");

        cl_indicazione
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RigaRDA, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<RigaRDA, String> arg0) {

                        SimpleStringProperty s = new SimpleStringProperty();
                        s.set(arg0.getValue().getIndicazione());
                        return s;
                    }
                });

        cl_quantita
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RigaRDA, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<RigaRDA, String> arg0) {

                        SimpleStringProperty s = new SimpleStringProperty();
                        s.set(""+arg0.getValue().getPezzo().getQuantitaOrdinate());
                        return s;
                    }
                });

        if (rda.righeRDA.size() >= 0) {
            ObservableList<RigaRDA> list = FXCollections.observableList(Arrays.asList(rda.righeRDA.toArray()));
            tbl_righeRDA.setItems(list);
        }
	}

	@FXML 
	protected void aggiungiPezzo() throws PersistentException {
        log.i("Aggiungi pezzo");

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = null;
        try {

            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("fxml/aggiungi_riga_rda.fxml"));
            AggiungiRigaRdaController controller = new AggiungiRigaRdaController();
            loader.setController(controller);
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        popupStage.setScene(scene);

        popupStage.showAndWait();

        DescrizionePezzo descrizionePezzo = (DescrizionePezzo) session.get(AggiungiRigaRdaController.PEZZO_RIGA_RDA);
        String indicazione = (String) session.get(AggiungiRigaRdaController.INDICAZIONE_RIGA_RDA);

        float quantita = (Float) session.get(AggiungiRigaRdaController.QUANTITA_RIGA_RDA);
        if (descrizionePezzo!=null && quantita!=0 && indicazione!=null) {
            PersistentTransaction t = Coedil99PersistentManager.instance().getSession().beginTransaction();
            Pezzo pezzo = new Builder.PezzoBuilder().setDescrizionePezzo(descrizionePezzo)
                    .setQuantitaOrdinate(Math.round(quantita)).build();
            new Builder.RigaRDABuilder().setRda(rda).setIndicazione(indicazione).setPezzo(pezzo).build();
            t.commit();
        }

        refreshTable();

	}

    @FXML
    protected void goBack()
    {
        MainApplication.getInstance().goBack();
    }

    @FXML
    protected void modificaDatiDDT()
    {
        log.i("Modifica dei dati della RDA");

        //Check
        if(modificandoDDTRDA != false){
            modificandoDDTRDA = false;
            modificaDDTButton.setText("Modifica");
            salvaDatiRDA();
            salvaDatiDDT();
            return;
        }

        //Flag
        modificandoDDTRDA = true;
        modificaDDTButton.setText("Annulla");

        //Abilito il salvataggio
        salvaDDTButton.setDisable(false);
    }

    @FXML
    protected void salvaDatiDDT()
    {

        log.i("Salvataggio dati ddt rda");

        salvaDDTButton.setDisable(true);

        if(modificandoDDTRDA != true){
            refreshRDA();
            return;
        }

        //TODO: Aggiornare l'rda anche sul db amico

        refreshRDA();

        modificandoDDTRDA = false;
        modificaDDTButton.setText("Modifica");
        modificaDDTButton.setDisable(false);

    }

    @FXML
    protected void rimuoviPezzo() throws PersistentException {

        rda.righeRDA.remove(rigaSelezionata);
        rigaRDADAO.deleteAndDissociate(rigaSelezionata);

        rigaSelezionata = null;
        btn_rimuoviPezzo.setDisable(true);

        refreshTable();

    }

    @FXML
    protected void modificaNoteRDA() throws PersistentException {
        if(modificandoNoteRDA != false){
            modificandoNoteRDA  = false;
            btn_modificaNote.setText("Modifica");
            salvaNoteRDA();
            return;
        }

        btn_modificaNote.setText("Annulla");

        text_area_rda.setDisable(false);
        btn_salvaNote.setDisable(false);

        modificandoNoteRDA = true;
    }

    @FXML
    protected void salvaNoteRDA() throws PersistentException {

        rda.setDescrizione(text_area_rda.getText());
        rdaDAO.save(rda);

        btn_modificaNote.setText("Modifica");

        text_area_rda.setDisable(true);
        btn_salvaNote.setDisable(true);

        modificandoNoteRDA = false;

    }


}
