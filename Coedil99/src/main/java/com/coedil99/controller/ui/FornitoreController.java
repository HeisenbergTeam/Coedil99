package com.coedil99.controller.ui;

import com.coedil99.controller.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.FornitoreDAO;
import com.coedil99.modello_di_dominio.dao.OrdineDAO;
import com.coedil99.modello_di_dominio.dao.RDADAO;
import com.coedil99.ui.MainApplication;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.Parsers;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.net.URL;
import java.util.*;

public class FornitoreController implements Initializable {

    @FXML
    private TableView<Fornitore> tblFornitore;
    @FXML
    private TableColumn<Fornitore, String> tc_nomeFornitore;

    protected Log log;

    protected Fornitore currentFornitore;

    public void setAction(int action) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tblFornitore.setEditable(true);
        refreshListaFornitori();
    }

    private void nuovoFornitore() {
        Fornitore fornite = new Builder.FornitoreBuilder().setNome("").build();

        refreshListaFornitori();
        tblFornitore.getSelectionModel().selectLast();
        tblFornitore.scrollTo(fornite);
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

    final private ChangeListener changeListener = new ChangeListener<Object>() {

        @Override
        public void changed(ObservableValue<? extends Object> arg0,
                            Object arg1, Object arg2) {

            Integer index = (Integer)arg2;
            if (index >= 0 ) {
                Fornitore forn = getFornitori().get(index);
                currentFornitore = forn;
                System.out.print("current fornitore"+currentFornitore.getNome()+" id "+currentFornitore.getID());
            }
        }
    };

    protected void loadFornitoriTable(List<Fornitore> fornitori) {

        // TODO Auto-generated method stub
        tc_nomeFornitore
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Fornitore, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Fornitore, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();

                        if (arg0.getValue() == null) {
                            s.set("?");
                        } else {
                            s.set(arg0.getValue().getNome());
                        }
                        return s;
                    }
                });

        tc_nomeFornitore.setCellFactory(TextFieldTableCell.forTableColumn());
        tc_nomeFornitore.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Fornitore, String>>() {

                    @Override
                    public void handle(TableColumn.CellEditEvent<Fornitore, String> t) {
                        System.out.print(t.getNewValue());

                        Fornitore fornitoreCorrente = ((Fornitore) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        );

                        fornitoreCorrente.setNome(t.getNewValue());

                        try {

                            DAOFactory.getDAOFactory().getFornitoreDAO().save(fornitoreCorrente);
                        } catch (PersistentException e) {
                            e.printStackTrace();
                        } finally {
                            refreshListaFornitori();
                        }

                    }
                }
        );
        tc_nomeFornitore.setEditable(true);

        ObservableList<Fornitore> list = FXCollections.observableList(fornitori);
        tblFornitore.setItems(list);
    }

    protected void refreshListaFornitori(){
        tblFornitore.getSelectionModel().selectedIndexProperty()
                .removeListener(changeListener);

        loadFornitoriTable(getFornitori());

        tblFornitore.getSelectionModel().selectedIndexProperty()
                .addListener(changeListener);
    }

    @FXML
    protected void goBack()
    {
        MainApplication.getInstance().goBack();
    }

    @FXML
    protected void aggiungiFornitore()
    {
        nuovoFornitore();
    }

    @FXML
    protected void rimuoviFornitore()
    {
        try {
            DescrizionePezzo[] arrayDescPezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().listDescrizionePezzoByQuery("FornitoreID = "+currentFornitore,null);
            System.out.print(arrayDescPezzo.length);
            for (int i = 0; i < arrayDescPezzo.length; i++) {
                if (arrayDescPezzo[i].getFornitore().getID() == currentFornitore.getID()) {
                    System.out.print("deleting descrizione pezzo " + arrayDescPezzo[i].getID());

                    Pezzo[] arrayPezzo = DAOFactory.getDAOFactory().getPezzoDAO().listPezzoByQuery("DescrizionePezzoID = "+arrayDescPezzo[i],null);
                    System.out.print(arrayPezzo.length);
                    for (int j = 0; j < arrayPezzo.length; j++) {
                        if (arrayPezzo[j].getDescrizionePezzo().getID() == arrayDescPezzo[i].getID()) {
                            System.out.print("deleting pezzo " + arrayPezzo[j].getID());

                            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery("PezzoID = "+arrayPezzo[j],null);
                            for (int k = 0; k < arrayRigaRDA.length; k++) {
                                if (arrayRigaRDA[k].getPezzo().getID() == arrayPezzo[j].getID()) {
                                    System.out.print("deleting rigarda " + arrayRigaRDA[k].getID());
                                    DAOFactory.getDAOFactory().getRigaRDADAO().deleteAndDissociate(arrayRigaRDA[k]);
                                }
                            }


                            DAOFactory.getDAOFactory().getPezzoDAO().deleteAndDissociate(arrayPezzo[j]);
                        }
                    }

                    DAOFactory.getDAOFactory().getDescrizionePezzoDAO().deleteAndDissociate(arrayDescPezzo[i]);
                }
            }

            DAOFactory.getDAOFactory().getFornitoreDAO().deleteAndDissociate(currentFornitore);
        } catch (PersistentException e) {
            e.printStackTrace();
        } finally {
            refreshListaFornitori();
        }
    }

    @FXML
    protected void aggiungiPezzo()
    {

    }

    @FXML
    protected void rimuoviPezzo()
    {

    }

}
