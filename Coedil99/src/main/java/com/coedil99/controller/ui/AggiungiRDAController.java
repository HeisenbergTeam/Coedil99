package com.coedil99.controller.ui;

import com.coedil99.controller.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.Fornitore;
import com.coedil99.modello_di_dominio.dao.FornitoreDAO;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.RigaDistintaDAO;
import com.coedil99.utilita.*;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.*;

public class AggiungiRDAController implements Initializable {
/**
 * 
 */
    @FXML protected Pane listaFornitoreParent;
	@FXML private ListView<Fornitore> listaFornitore;
	@FXML private TextField dataRichiesta;
    @FXML private TextField dataPrevista;
    @FXML private TextField dataEffettiva;
	@FXML private Button aggiungiRDA;
    @FXML private AnchorPane ancora;
    private Log log;
	private Sessione sessione;
    private UtilitaManager gsp;
    private FornitoreDAO fornitoreDAO;

    private String dataR;
    private String dataP;
    private String dataE;

    private String oldString = null;

    private Fornitore[] fornitore;
    private ObservableList<Fornitore> obsFornitore;

    public void setAction(int action) {

    }

    /**
 * 
 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
        String nowStr = Parsers.printItalianDate(new Date());
        dataR = nowStr;
        dataP = nowStr;
        dataE = nowStr;

        dataRichiesta.setText(dataR);
        dataEffettiva.setText(dataE);
        dataPrevista.setText(dataP);

        aggiungiRDA.setDisable(true);

        gsp = UtilitaManagerPrototipo.getGestoreServizi();
        fornitoreDAO = DAOFactory.getDAOFactory().getFornitoreDAO();
		log = (Log) UtilitaManager.getGestoreServizi().getServizio("LogStdout");
		sessione = (Sessione) UtilitaManager.getGestoreServizi().getServizio("SessionePrototipo");

        refreshListaFornitore();
		
	}

    protected void loadFornitori(List<Fornitore> fornitori) {

        listaFornitore.setCellFactory(new Callback<ListView<Fornitore>,
                                              ListCell<Fornitore>>() {
                                          @Override
                                          public ListCell<Fornitore> call(ListView<Fornitore> list) {
                                              return new FornitoreCell();
                                          }
                                      }
        );

        listaFornitore.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fornitore>() {

            @Override
            public void changed(ObservableValue<? extends Fornitore> arg0,
                                Fornitore arg1, Fornitore arg2) {

                aggiungiRDA.setDisable(false);

            }
        });

        ObservableList<Fornitore> list = FXCollections.observableList(fornitori);
        listaFornitore.setItems(list);


    }

    public ArrayList<Fornitore> getFornitori() {
        FornitoreDAO fornitoreDAO = DAOFactory.getDAOFactory().getFornitoreDAO();
        ArrayList<Fornitore> fornitori = new ArrayList<Fornitore>();
        try {
            fornitori = new
                    ArrayList<Fornitore>(Arrays.asList(fornitoreDAO.listFornitoreByQuery(null, null)));
        } catch (PersistentException e) {}
        return fornitori;
    }

    private void refreshListaFornitore()
    {

        //Parent listaFornitoreParent = listaFornitore.getParent();

        Pane tps = (Pane) listaFornitoreParent;
            tps.getChildren().remove(listaFornitore);



        loadFornitori(getFornitori());

        tps.getChildren().add(listaFornitore);

        //listaFornitore.setItems(obsFornitore);


    }

/**
 * 
 */
	@FXML
	public void onAggiungiRDA(){
		
		log.i("Fornitore aggiunto");
		
		//Fornitore scelto
		Fornitore fornitoreScelto = listaFornitore.getSelectionModel().getSelectedItem();

		//Sagoma sagoma = rigaDistintaDAO.creaSagoma(pathSagoma);

        dataR = dataRichiesta.getText();
        dataE = dataEffettiva.getText();
        dataP = dataPrevista.getText();

        boolean blocca1 = false;
        boolean blocca2 = false;
        boolean blocca3 = false;
        boolean blocca4 = false;
        Date dataRR = null;
        try {
            dataRR = Parsers.italianDateStringToDate(dataR);
            blocca1 = false;
        } catch (ParseException e) {
            dataRichiesta.setStyle("-fx-border-color: red");
            dataRichiesta.setPromptText("Data non valida");
            blocca1 = true;
        }
        Date dataEE = null;
        try {
            dataEE = Parsers.italianDateStringToDate(dataE);
            blocca2 = false;

        } catch (ParseException e) {
            dataEffettiva.setStyle("-fx-border-color: red");
            dataEffettiva.setPromptText("Data non valida");
            blocca2 = true;
        }
        Date dataPP = null;
        try {
            dataPP = Parsers.italianDateStringToDate(dataP);
            blocca3 = false;
        } catch (ParseException e) {
            dataPrevista.setStyle("-fx-border-color: red");
            dataPrevista.setPromptText("Data non valida");
            blocca3 = true;
        }

        if (fornitoreScelto == null) {
            blocca4 = true;

        } else {
            blocca4 = false;
        }

        if (blocca1 && blocca2 && blocca3 && blocca4) {
            sessione.set("fornitore_selezionato",fornitoreScelto);
            sessione.set("data_prevista",dataPP);
            sessione.set("data_effettiva",dataEE);
            sessione.set("data_richiesta",dataRR);
            //Chiudo la finestra
            ((Stage) ancora.getScene().getWindow()).close();
        } else {

        }
	}
/**
 * 
 * @author mw
 *
 */
	static class FornitoreCell extends ListCell<Fornitore> {
        @Override
        public void updateItem(Fornitore item, boolean empty) {
            super.updateItem(item, empty);
            if(item != null){
            	setText(item.getNome());
            }
        }
    }

}
