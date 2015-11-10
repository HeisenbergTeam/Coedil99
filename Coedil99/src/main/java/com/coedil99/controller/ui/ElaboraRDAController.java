package com.coedil99.controller.ui;

import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.modello_di_dominio.dao.RigaRDADAO;
import com.coedil99.servizi.GestoreServizi;
import com.coedil99.servizi.Log;
import com.coedil99.servizi.Sessione;
import com.coedil99.servizi.impl.GestoreServiziPrototipo;
import com.coedil99.ui.MainApplication;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.orm.PersistentException;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ElaboraRDAController implements Initializable {

    @FXML public TableColumn<RigaRDA,String> cl_indicazione;
    @FXML public TableColumn<RigaRDA,String> cl_quantita;
    @FXML public TableView<RigaRDA> tbl_righeRDA;
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
    @FXML private Button btn_rimuoviPezzo;

    @FXML private Label lbl_codice_pezzo;
    @FXML private Label lbl_pezzo_quantita;
    
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

    private Map<String,Label> rdaLabels;
    private Map<String,TextField> rdaTextFields;
    private Map<String, TextField> rdaDDTTextFields;
    private Map<String,Object> rigaRDATextFields;
    
    private RigaRDA rigaSelezionata = null;
    private RDA rda;
    
    private RDADAO rdaDAO;
    private RigaRDADAO rigaRDADAO;
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
    private Map<String,Label> rdaDDTLabels;
    private boolean modificandoDDTRDA;
    @FXML private Button modificaDDTButton;
    private boolean modificandoNoteRDA;


    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

        text_area_rda.setDisable(true);

        modificandoDatiRDA = false;

		salvaDistButton.setDisable(true);
		//modificaPezzoButton.setDisable(true);
		btn_rimuoviPezzo.setDisable(true);

		//Caricamento servizi
		GestoreServizi gsp = GestoreServiziPrototipo.getGestoreServizi();
		ordineDao = DAOFactory.getDAOFactory().getOrdineDAO();
        rigaRDADAO = DAOFactory.getDAOFactory().getRigaRDADAO();
        rdaDAO = DAOFactory.getDAOFactory().getRDADAO();

        try {
            rda = rdaDAO.getRDAByORMID(1);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        log = (Log) gsp.getServizio("LogStdout");
		session = (Sessione) gsp.getServizio("SessionePrototipo");
		
		refreshTable();
		refreshRDA();

	    
	    rdaLabels = new HashMap<String,Label>();
        rdaLabels.put("ordine",lbl_ordine_rda);
        rdaLabels.put("fornitore",lbl_fornitore_rda);
        rdaLabels.put("consegna_prevista",lbl_data_consegna_prevista_rda);
        rdaLabels.put("consegna_effittiva",lbl_data_consegna_effettiva_rda);
        rdaLabels.put("giorni_ritardo",lbl_ritardo_rda);

        rdaDDTLabels = new HashMap<String, Label>();
        rdaDDTLabels.put("numero",lbl_numero_ddt);
        //rdaDDTLabels.put("data_ddt",lbl_data_ddt);
        rdaDDTLabels.put("codice_colata",lbl_codice_colata_ddt);

        tbl_righeRDA.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Object>() {

                    @Override
                    public void changed(ObservableValue<? extends Object> arg0,
                                        Object arg1, Object arg2) {


                        if((Integer) arg2 < rda.righeRDA.size())
                        {
                            ElaboraRDAController.this.rigaSelezionata = rda.righeRDA.toArray()[(Integer)arg2];
                            ElaboraRDAController.this.btn_rimuoviPezzo.setDisable(false);

                            ElaboraRDAController.this.lbl_codice_pezzo.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getNome());
                            ElaboraRDAController.this.lbl_pezzo_quantita.setText(String.valueOf(rigaSelezionata.getPezzo().getQuantita()));
                        }

                    }
                });
	    
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

        Set<Map.Entry<String, Label>> insieme = rdaLabels.entrySet();
        Iterator<Map.Entry<String, Label>> iterator = insieme.iterator();

        rdaTextFields = new HashMap<String, TextField>();

        while(iterator.hasNext() != false){

            Map.Entry<String, Label> entry = iterator.next();

            Parent p = entry.getValue().getParent();
            TextField tf = new TextField();
            tf.setText(entry.getValue().getText());
            Pane tps = (Pane) p;
            tps.getChildren().remove(entry.getValue());
            tps.getChildren().add(tf);

            rdaTextFields.put(entry.getKey(), tf);
        }

        String current_date = lbl_data_consegna_effettiva_rda.getText();
        Parent datePickParent = lbl_data_consegna_prevista_rda.getParent();

        /*final String pattern = "dd-MM-yyyy";

        datePicker.setPromptText(pattern.toLowerCase());

        datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        String[] split = current_date.split("-");
        LocalDate ld = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]));
        //	new LocalDate(getNumber(split[0]),getNumber(split[1]),getNumber(split[2]))
        datePicker.setValue(ld);

        Pane tps = (Pane) datePickParent;
        tps.getChildren().remove(lbl_data);
        tps.getChildren().add(datePicker);
        datePicker.setMaxWidth(Double.MAX_VALUE);
        */
        //Flag
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

        //listPezziDistinta.getSelectionModel().getSelectedItem();

        Set<Map.Entry<String, TextField>> insieme = rdaTextFields.entrySet();
        Iterator<Map.Entry<String, TextField>> iterator = insieme.iterator();

        while(iterator.hasNext()){

            Map.Entry<String, TextField> entry = iterator.next();
            Parent p = entry.getValue().getParent();

            Pane tps = (Pane) p;
            System.out.println(entry.toString());
            tps.getChildren().remove(entry.getValue());
            rdaLabels.get(entry.getKey()).setText(entry.getValue().getText());

            tps.getChildren().add(rdaLabels.get(entry.getKey()));

        }

        Parent datePickParent = datePicker.getParent();
        LocalDate ld = datePicker.getValue();
        /*
        Pane tps = (Pane) datePickParent;
        tps.getChildren().remove(datePicker);
        tps.getChildren().add(lbl_data);

        Calendar cal = Calendar.getInstance();
        cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
        Date dt = cal.getTime();
        */

        if(modificandoDatiRDA != true){
            refreshRDA();
            return;
        }

        //TODO: Aggiornare l'rda anche sul db amico

        refreshRDA();

        modificandoDatiRDA = false;
        modificaDistButton.setText("Modifica");
        modificaDistButton.setDisable(false);
	}
	
	private void refreshCommonDataRDA() {
		
	}
	
	private void refreshRDA() {
		
		refreshCommonDataRDA();

        lbl_ordine_rda.setText("PROSSIME ITERAZIONI");
        text_area_rda.setText(rda.getDescrizione());
	    
	}
	
	private void refreshTable() {
        cl_indicazione
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RigaRDA, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<RigaRDA, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();
                        s.set(arg0.getValue().getIndicazione());
                        return s;
                    }
                });

        cl_quantita
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RigaRDA, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<RigaRDA, String> arg0) {


                        SimpleStringProperty simpleStringProperty = new SimpleStringProperty(String.valueOf(arg0.getValue().getPezzo()
                                .getQuantita()));
                        return simpleStringProperty;
                    }
                });


        ObservableList<RigaRDA> list = FXCollections.observableList(Arrays.asList(rda.righeRDA.toArray()));
        tbl_righeRDA.setItems(list);
	}


/**
 *  aggiungiPezzo
 */
	@FXML 
	protected void aggiungiPezzo() throws PersistentException {
        log.i("Aggiungi pezzo");

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = null;
        try {
            root = FXMLLoader.load(MainApplication.class.getResource("fxml/aggiungi_riga_rda.fxml"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        popupStage.setScene(scene);

        //blocking
        popupStage.showAndWait();

        Pezzo pezzoSelezionato = (Pezzo) session.get(AggiungiRigaRdaController.PEZZO_RIGA_RDA);
        String indicazione = (String) session.get(
                AggiungiRigaRdaController.INDICAZIONE_RIGA_RDA
        );
        float quantita = (Float) session.get(AggiungiRigaRdaController.QUANTITA_RIGA_RDA);
        if (pezzoSelezionato!=null && quantita!=0 && indicazione!=null) {

            RigaRDA rigaRDA = rigaRDADAO.createRigaRDA();
            rigaRDA.setIndicazione(indicazione);
            rigaRDA.setPezzo(pezzoSelezionato);
            rigaRDA.setRda(rda);
            rigaRDADAO.save(rigaRDA);

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
            return;
        }

        Set<Map.Entry<String, Label>> insieme = rdaDDTLabels.entrySet();
        Iterator<Map.Entry<String, Label>> iterator = insieme.iterator();

        rdaDDTTextFields = new HashMap<String, TextField>();

        while(iterator.hasNext() != false){

            Map.Entry<String, Label> entry = iterator.next();

            Parent p = entry.getValue().getParent();
            TextField tf = new TextField();
            tf.setText(entry.getValue().getText());
            Pane tps = (Pane) p;
            tps.getChildren().remove(entry.getValue());
            tps.getChildren().add(tf);

            rdaDDTTextFields.put(entry.getKey(), tf);
        }

        String current_date = lbl_data_ddt.getText();
        Parent datePickParent = lbl_data_ddt.getParent();

        final String pattern = "dd-MM-yyyy";

        datePicker.setPromptText(pattern.toLowerCase());

        datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        String[] split = current_date.split("-");
        LocalDate ld = LocalDate.now();

        //	new LocalDate(getNumber(split[0]),getNumber(split[1]),getNumber(split[2]))
        datePicker.setValue(ld);

        Pane tps = (Pane) datePickParent;
        tps.getChildren().remove(lbl_data_ddt);
        tps.getChildren().add(datePicker);
        datePicker.setMaxWidth(Double.MAX_VALUE);


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

        //listPezziDistinta.getSelectionModel().getSelectedItem();

        Set<Map.Entry<String, TextField>> insieme = rdaDDTTextFields.entrySet();
        Iterator<Map.Entry<String, TextField>> iterator = insieme.iterator();

        while(iterator.hasNext()){

            Map.Entry<String, TextField> entry = iterator.next();
            Parent p = entry.getValue().getParent();

            Pane tps = (Pane) p;
            System.out.println(entry.toString());
            tps.getChildren().remove(entry.getValue());
            rdaDDTLabels.get(entry.getKey()).setText(entry.getValue().getText());

            tps.getChildren().add(rdaDDTLabels.get(entry.getKey()));

        }

        Parent datePickParent = datePicker.getParent();
        LocalDate ld = datePicker.getValue();

        Pane tps = (Pane) datePickParent;
        tps.getChildren().remove(datePicker);
        tps.getChildren().add(lbl_data_ddt);

        Calendar cal = Calendar.getInstance();
        cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
        Date dt = cal.getTime();


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

        rigaRDADAO.deleteAndDissociate(rigaSelezionata);
        rda = rdaDAO.getRDAByORMID(1);
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
