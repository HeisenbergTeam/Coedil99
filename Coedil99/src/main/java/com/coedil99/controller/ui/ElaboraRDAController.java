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
import org.orm.PersistentException;

import java.net.URL;
import java.text.ParseException;
import java.util.*;

public class ElaboraRDAController implements Initializable {

    @FXML private TitledPane title_fornitore_rda_txt;

    @FXML public TableColumn<RigaRDA,String> cl_indicazione;
    @FXML public TableColumn<RigaRDA,String> cl_quantita;
    @FXML public TableView<RigaRDA> tbl_righeRDA;
    //@FXML private ListView<RigaRDA> listPezziRDA;

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

    //private Map<String,Label> rdaLabels;
    //private Map<String,TextField> rdaTextFields;
    //private Map<String, TextField> rdaDDTTextFields;
    //private Map<String,TextField> rigaRDATextFields;
    
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
            System.out.println("id rda:"+action);
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
        System.out.println(txtField.toString());
        if(enabled) {
            txtField.setStyle("-fx-background-color: #FFFFFF;");
            txtField.setAlignment(Pos.CENTER);
            txtField.setEditable(true);
        }else{
            txtField.setStyle("-fx-background-color: #EEEEEE;");
            txtField.setAlignment(Pos.CENTER);
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
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

        text_area_rda.setDisable(true);

        modificandoDatiRDA = false;

		salvaDistButton.setDisable(true);
		//modificaPezzoButton.setDisable(true);
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
		UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
		ordineDao = DAOFactory.getDAOFactory().getOrdineDAO();
        rigaRDADAO = DAOFactory.getDAOFactory().getRigaRDADAO();
        rdaDAO = DAOFactory.getDAOFactory().getRDADAO();
        pezzoDAO = DAOFactory.getDAOFactory().getPezzoDAO();

        log = (Log) gsp.getServizio("LogStdout");
		session = (Sessione) gsp.getServizio("SessionePrototipo");
/*
	    rdaLabels = new HashMap<String,Label>();
        //rdaLabels.put("ordine",txt_ordine_rda);
        rdaLabels.put("fornitore",txt_fornitore_rda);
        rdaLabels.put("consegna_prevista",txt_data_consegna_prevista_rda);
        rdaLabels.put("consegna_effittiva",txt_data_consegna_effettiva_rda);
        rdaLabels.put("giorni_ritardo",txt_ritardo_rda);

        rdaDDTLabels = new HashMap<String, Label>();
        rdaDDTLabels.put("numero",txt_numero_ddt);
        //rdaDDTLabels.put("data_ddt",txt_data_ddt);
        rdaDDTLabels.put("codice_colata",txt_codice_colata_ddt);

        rdaTextFields = new HashMap<String,TextField>();
        //rdaTextFields.put("ordine",txt_ordine_rda);
        rdaTextFields.put("fornitore",txt_fornitore_rda);
        rdaTextFields.put("consegna_prevista",txt_data_consegna_prevista_rda);
        rdaTextFields.put("consegna_effittiva",txt_data_consegna_effettiva_rda);
        rdaTextFields.put("giorni_ritardo",txt_ritardo_rda);
        //txt_ritardo_rda.setEditable(false);
        //txt_data_consegna_effettiva_rda.setDisable(true);
        //txt_data_consegna_effettiva_rda.setManaged(false);

        rigaRDATextFields = new HashMap<String, TextField>();
        rigaRDATextFields.put("numero",txt_numero_ddt);
        //rigaRDATextFields.put("data_ddt",txt_data_ddt);
        rigaRDATextFields.put("codice_colata",txt_codice_colata_ddt);
        */
/*
        Set<Map.Entry<String, Label>> insieme = rdaLabels.entrySet();
        Set<Map.Entry<String, TextField>> insieme2 = rdaTextFields.entrySet();
        Iterator<Map.Entry<String, Label>> iterator = insieme.iterator();
        Iterator<Map.Entry<String, TextField>> iterator2 = insieme2.iterator();

        while(iterator.hasNext() != false && iterator2.hasNext() != false){

            Map.Entry<String, Label> entryLabel = iterator.next();
            Map.Entry<String, TextField> entryTextField = iterator2.next();
            //entryTextField.getValue().setText(entryLabel.getValue().getText());
            entryTextField.getValue().setVisible(false);
            //entryTextField.getValue().setManaged(false);
            entryLabel.getValue().setVisible(true);
            //entryLabel.getValue().setManaged(true);
        }
*/
        //title_fornitore_rda_txt.setVisible(false);
        //title_fornitore_rda_txt.setManaged(false);
        //title_fornitore_rda_lbl.setVisible(true);
        //title_fornitore_rda_lbl.setManaged(true);

        tbl_righeRDA.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Object>() {

                    @Override
                    public void changed(ObservableValue<? extends Object> arg0,
                                        Object arg1, Object arg2) {


                        if((Integer) arg2 < rda.righeRDA.size())
                        {
                            ElaboraRDAController.this.rigaSelezionata = rda.righeRDA.toArray()[(Integer)arg2];
                            ElaboraRDAController.this.btn_rimuoviPezzo.setDisable(false);

                            ElaboraRDAController.this.txt_codice_pezzo.setText(rigaSelezionata.getPezzo().getDescrizionePezzo().getNome());
                            //ElaboraRDAController.this.txt_pezzo_quantita.setText(String.valueOf(rigaSelezionata.getPezzo().getQuantita()));
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

        //setTextEdit(txt_fornitore_rda,true);
        setTextEdit(txt_data_consegna_prevista_rda,true);
        setTextEdit(txt_data_consegna_effettiva_rda,true);

/*
        Set<Map.Entry<String, Label>> insieme = rdaLabels.entrySet();
        Set<Map.Entry<String, TextField>> insieme2 = rdaTextFields.entrySet();
        Iterator<Map.Entry<String, Label>> iterator = insieme.iterator();
        Iterator<Map.Entry<String, TextField>> iterator2 = insieme2.iterator();

        while(iterator.hasNext() != false && iterator2.hasNext() != false){
            Map.Entry<String, Label> entryLabel = iterator.next();
            Map.Entry<String, TextField> entryTextField = iterator2.next();
            entryTextField.getValue().setText(entryLabel.getValue().getText());
            entryLabel.getValue().setVisible(false);
            //entryLabel.getValue().setManaged(false);
            entryTextField.getValue().setVisible(true);
            //entryTextField.getValue().setManaged(true);
        }
        txt_fornitore_rda.setVisible(true);
        //txt_fornitore_rda.setManaged(true);
       */

        //title_fornitore_rda_lbl.setVisible(false);
        //title_fornitore_rda_lbl.setManaged(false);
        //title_fornitore_rda_txt.setVisible(true);
        //title_fornitore_rda_txt.setManaged(true);


        String current_date = txt_data_consegna_effettiva_rda.getText();
        Parent datePickParent = txt_data_consegna_prevista_rda.getParent();

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
        tps.getChildren().remove(txt_data);
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
/*
        Set<Map.Entry<String, TextField>> insieme = rdaTextFields.entrySet();
        Iterator<Map.Entry<String, TextField>> iterator = insieme.iterator();

        while(iterator.hasNext()){

            Map.Entry<String, TextField> entry = iterator.next();
            Parent p = entry.getValue().getParent();

            Pane tps = (Pane) p;
            //System.out.println(entry.toString());
            tps.getChildren().remove(entry.getValue());
            rdaLabels.get(entry.getKey()).setText(entry.getValue().getText());

            tps.getChildren().add(rdaLabels.get(entry.getKey()));

        }

        Parent datePickParent = datePicker.getParent();
        LocalDate ld = datePicker.getValue();

        //rda.setDataCreazione();
        //rda.setDescrizione();
*/
        /*
        Pane tps = (Pane) datePickParent;
        tps.getChildren().remove(datePicker);
        tps.getChildren().add(txt_data);

        Calendar cal = Calendar.getInstance();
        cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
        Date dt = cal.getTime();
        */

        if(modificandoDatiRDA != true){
            refreshRDA();
            return;
        }

        //TODO: Aggiornare l'rda anche sul db amico
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
/*
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
*/
        if (rda.righeRDA.size() != 0) {
            ObservableList<RigaRDA> list = FXCollections.observableList(Arrays.asList(rda.righeRDA.toArray()));
            tbl_righeRDA.setItems(list);
        }
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
            //fx:controller="com.coedil99.controller.ui.AggiungiRigaRdaController"
            //root = FXMLLoader.load(MainApplication.class.getResource("fxml/aggiungi_riga_rda.fxml"));
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

        //blocking
        popupStage.showAndWait();

        Pezzo pezzoSelezionato = (Pezzo) session.get(AggiungiRigaRdaController.PEZZO_RIGA_RDA);
        String indicazione = (String) session.get(
                AggiungiRigaRdaController.INDICAZIONE_RIGA_RDA
        );
        float quantita = (Float) session.get(AggiungiRigaRdaController.QUANTITA_RIGA_RDA);
        if (pezzoSelezionato!=null && quantita!=0 && indicazione!=null) {

            RigaRDA rigaRDA = new Builder.RigaRDABuilder().setRda(rda).setIndicazione(indicazione).setPezzo(pezzoSelezionato).build();
            /*
            RigaRDA rigaRDA = rigaRDADAO.createRigaRDA();
            rigaRDA.setIndicazione(indicazione);
            rigaRDA.setPezzo(pezzoSelezionato);
            rigaRDA.setRda(rda);
            //pezzoSelezionato.setRigaRDA(rigaRDA);
            rigaRDA.setPezzo(pezzoSelezionato);

            pezzoDAO.save(pezzoSelezionato);
            rigaRDADAO.save(rigaRDA);
            */
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
/*
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

        String current_date = txt_data_ddt.getText();
        Parent datePickParent = txt_data_ddt.getParent();

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
        tps.getChildren().remove(txt_data_ddt);
        tps.getChildren().add(datePicker);
        datePicker.setMaxWidth(Double.MAX_VALUE);
*/

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
/*
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
        tps.getChildren().add(txt_data_ddt);

        Calendar cal = Calendar.getInstance();
        cal.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth()); //year is as expected, month is zero based, date is as expected
        Date dt = cal.getTime();
*/
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
