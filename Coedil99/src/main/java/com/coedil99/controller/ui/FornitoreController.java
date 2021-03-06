package com.coedil99.controller.ui;

import com.coedil99.dominio.builder.Builder;
import com.coedil99.modello_di_dominio.*;
import com.coedil99.modello_di_dominio.dao.*;
import com.coedil99.ui.MainApplication;
import com.coedil99.utilita.Log;
import com.coedil99.utilita.UtilitaManager;
import com.coedil99.utilita.impl.UtilitaManagerPrototipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javassist.runtime.Desc;
import org.orm.PersistentException;

import java.net.URL;
import java.util.*;

public class FornitoreController implements Initializable {

    @FXML
    private TableView<Fornitore> tblFornitore;
    @FXML
    private TableColumn<Fornitore, String> tc_nomeFornitore;

    @FXML
    private TableView<DescrizionePezzo> tblPezzi;
    @FXML
    private TableColumn<DescrizionePezzo, String> tc_nome, tc_peso, tc_diametro;

    protected Log log;


    protected Fornitore currentFornitore;
    protected DescrizionePezzo currentPezzo;

    public void setAction(int action) {

    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        UtilitaManager gsp = UtilitaManagerPrototipo.getGestoreServizi();
        log = (Log) gsp.getServizio("LogStdout");
        tblFornitore.setEditable(true);
        tblPezzi.setEditable(true);
        refreshListaFornitori();
    }

    private void clearListaPezzi() {
        tblPezzi.getSelectionModel().selectedIndexProperty()
                .removeListener(changeListenerPezzi);

        ArrayList<DescrizionePezzo> pezzi = new ArrayList<DescrizionePezzo>();
        loadPezziTable(pezzi);

        tblPezzi.getSelectionModel().selectedIndexProperty()
                .addListener(changeListenerPezzi);
    }

    private void refreshListaPezzi(Fornitore fornitore) {
        tblPezzi.getSelectionModel().selectedIndexProperty()
                .removeListener(changeListenerPezzi);

        loadPezziTable(getPezzi(currentFornitore));

        tblPezzi.getSelectionModel().selectedIndexProperty()
                .addListener(changeListenerPezzi);
    }

    private void nuovoFornitore() {
        Fornitore fornite = new Builder.FornitoreBuilder().setNome("Nuovo fornitore").build();

        refreshListaFornitori();
        tblFornitore.getSelectionModel().selectLast();
        tblFornitore.scrollTo(fornite);
    }

    private void nuovoPezzo() {
        DescrizionePezzo pezzo = new Builder.DescrizionePezzoBuilder().setNome("Nuovo pezzo").setDiametro(0).setPeso(0).setFornitore(currentFornitore).build();

        refreshListaPezzi(currentFornitore);
        tblPezzi.getSelectionModel().selectLast();
        tblPezzi.scrollTo(pezzo);
    }

    public ArrayList<DescrizionePezzo> getPezzi(Fornitore currentFornitore) {
        DescrizionePezzoDAO pezzoDAO = DAOFactory.getDAOFactory().getDescrizionePezzoDAO();
        ArrayList<DescrizionePezzo> pezzi = new ArrayList<DescrizionePezzo>();
        try {
            pezzi = new
                    ArrayList<DescrizionePezzo>(Arrays.asList(pezzoDAO.listDescrizionePezzoByQuery("FornitoreID="+currentFornitore, null)));
        } catch (PersistentException e) {}
        return pezzi;
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

    final private ChangeListener changeListenerPezzi = new ChangeListener<Object>() {

        public void changed(ObservableValue<? extends Object> arg0,
                            Object arg1, Object arg2) {

            Integer index = (Integer)arg2;
            if (index >= 0 ) {
                DescrizionePezzo pezzoC = getPezzi(currentFornitore).get(index);
                currentPezzo = pezzoC;
                log.i("current pezzo"+currentPezzo.getNome()+" id "+currentPezzo.getID());

            }
        }
    };

    final private ChangeListener changeListener = new ChangeListener<Object>() {

        public void changed(ObservableValue<? extends Object> arg0,
                            Object arg1, Object arg2) {

            Integer index = (Integer)arg2;
            if (index >= 0 ) {
                Fornitore forn = getFornitori().get(index);
                currentFornitore = forn;
                refreshListaPezzi(currentFornitore);
            }
        }
    };


    protected void loadPezziTable(List<DescrizionePezzo> pezzi) {

        // TODO Auto-generated method stub
        tc_nome
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DescrizionePezzo, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            CellDataFeatures<DescrizionePezzo, String> arg0) {
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

        tc_nome.setCellFactory(TextFieldTableCell.<DescrizionePezzo>forTableColumn());
        tc_nome.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<DescrizionePezzo, String>>() {

                    public void handle(TableColumn.CellEditEvent<DescrizionePezzo, String> t) {

                        DescrizionePezzo pezzoCorrente = ((DescrizionePezzo) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        );

                        pezzoCorrente.setNome(t.getNewValue());

                        try {

                            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(pezzoCorrente);
                        } catch (PersistentException e) {
                            e.printStackTrace();
                        } finally {
                            refreshListaPezzi(currentFornitore);
                        }

                    }
                }
        );
        tc_nome.setEditable(true);

        tc_peso
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DescrizionePezzo, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            CellDataFeatures<DescrizionePezzo, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();

                        if (arg0.getValue() == null) {
                            s.set("?");
                        } else {
                            s.set(arg0.getValue().getPeso()+"");
                        }
                        return s;
                    }
                });

        tc_peso.setCellFactory(TextFieldTableCell.<DescrizionePezzo>forTableColumn());
        tc_peso.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<DescrizionePezzo, String>>() {

                    public void handle(TableColumn.CellEditEvent<DescrizionePezzo, String> t) {

                        DescrizionePezzo pezzoCorrente = ((DescrizionePezzo) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        );

                        pezzoCorrente.setPeso(Float.parseFloat(t.getNewValue()));

                        try {

                            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(pezzoCorrente);
                        } catch (PersistentException e) {
                            e.printStackTrace();
                        } finally {
                            refreshListaPezzi(currentFornitore);
                        }

                    }
                }
        );
        tc_peso.setEditable(true);

        tc_diametro
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DescrizionePezzo, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            CellDataFeatures<DescrizionePezzo, String> arg0) {
                        // TODO Auto-generated method stub
                        SimpleStringProperty s = new SimpleStringProperty();

                        if (arg0.getValue() == null) {
                            s.set("?");
                        } else {
                            s.set(arg0.getValue().getDiametro()+"");
                        }
                        return s;
                    }
                });

        tc_diametro.setCellFactory(TextFieldTableCell.<DescrizionePezzo>forTableColumn());
        tc_diametro.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<DescrizionePezzo, String>>() {

                    public void handle(TableColumn.CellEditEvent<DescrizionePezzo, String> t) {

                        DescrizionePezzo pezzoCorrente = ((DescrizionePezzo) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        );
                        pezzoCorrente.setDiametro(Float.parseFloat(t.getNewValue()));
                        try {

                            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(pezzoCorrente);
                        } catch (PersistentException e) {
                            e.printStackTrace();
                        } finally {
                            refreshListaPezzi(currentFornitore);
                        }

                    }
                }
        );
        tc_diametro.setEditable(true);

        ObservableList<DescrizionePezzo> list = FXCollections.observableList(pezzi);
        tblPezzi.setItems(list);
    }

    protected void loadFornitoriTable(List<Fornitore> fornitori) {

        tc_nomeFornitore
                .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Fornitore, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(
                            CellDataFeatures<Fornitore, String> arg0) {
                        SimpleStringProperty s = new SimpleStringProperty();

                        if (arg0.getValue() == null) {
                            s.set("?");
                        } else {
                            s.set(arg0.getValue().getNome());
                        }
                        return s;
                    }
                });

        tc_nomeFornitore.setCellFactory(TextFieldTableCell.<Fornitore>forTableColumn());
        tc_nomeFornitore.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Fornitore, String>>() {

                    public void handle(TableColumn.CellEditEvent<Fornitore, String> t) {

                        Fornitore fornitoreCorrente = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());

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

            for (int i = 0; i < arrayDescPezzo.length; i++) {
                if (arrayDescPezzo[i].getFornitore().getID() == currentFornitore.getID()) {
                    log.i("deleting descrizione pezzo " + arrayDescPezzo[i].getID());

                    Pezzo[] arrayPezzo = DAOFactory.getDAOFactory().getPezzoDAO().listPezzoByQuery("DescrizionePezzoID = "+arrayDescPezzo[i].getID(),null);

                    for (int j = 0; j < arrayPezzo.length; j++) {
                        if (arrayPezzo[j].getDescrizionePezzo().getID() == arrayDescPezzo[i].getID()) {
                            log.i("deleting pezzo " + arrayPezzo[j].getID());

                            RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery("PezzoID = "+arrayPezzo[j].getID(),null);
                            for (int k = 0; k < arrayRigaRDA.length; k++) {
                                if (arrayRigaRDA[k].getPezzo().getID() == arrayPezzo[j].getID()) {
                                    log.i("deleting rigarda " + arrayRigaRDA[k].getID());
                                    DAOFactory.getDAOFactory().getRigaRDADAO().deleteAndDissociate(arrayRigaRDA[k]);
                                }
                            }

                            RigaDistinta[] arrayRigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().listRigaDistintaByQuery("PezzoID = "+arrayPezzo[j].getID(),null);

                            for (int k = 0; k < arrayRigaDistinta.length; k++) {
                                if (arrayRigaDistinta[k].getPezzo().getID() == arrayPezzo[j].getID()) {
                                    log.i("deleting rigadistinta " + arrayRigaDistinta[k].getID()+"\n");
                                    DAOFactory.getDAOFactory().getRigaDistintaDAO().deleteAndDissociate(arrayRigaDistinta[k]);
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
            clearListaPezzi();
        }
    }

    @FXML
    protected void aggiungiPezzo()
    {
        nuovoPezzo();
    }

    @FXML
    protected void rimuoviPezzo()
    {
        try {

            Pezzo[] arrayPezzo = DAOFactory.getDAOFactory().getPezzoDAO().listPezzoByQuery("DescrizionePezzoID = "+currentPezzo.getID(),null);
            log.i(arrayPezzo.length+"\n");
            for (int j = 0; j < arrayPezzo.length; j++) {
                if (arrayPezzo[j].getDescrizionePezzo().getID() == currentPezzo.getID()) {
                    log.i("deleting pezzo " + arrayPezzo[j].getID()+"\n");

                    RigaRDA[] arrayRigaRDA = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery("PezzoID = "+arrayPezzo[j].getID(),null);
                    log.i(arrayRigaRDA.length+"\n");
                    for (int k = 0; k < arrayRigaRDA.length; k++) {
                        if (arrayRigaRDA[k].getPezzo().getID() == arrayPezzo[j].getID()) {
                            log.i("deleting rigarda " + arrayRigaRDA[k].getID()+"\n");
                            DAOFactory.getDAOFactory().getRigaRDADAO().deleteAndDissociate(arrayRigaRDA[k]);
                        }
                    }

                    RigaDistinta[] arrayRigaDistinta = DAOFactory.getDAOFactory().getRigaDistintaDAO().listRigaDistintaByQuery("PezzoID = "+arrayPezzo[j].getID(),null);
                    log.i(arrayRigaDistinta.length+"\n");
                    for (int k = 0; k < arrayRigaDistinta.length; k++) {
                        if (arrayRigaDistinta[k].getPezzo().getID() == arrayPezzo[j].getID()) {
                            log.i("deleting rigadistinta " + arrayRigaDistinta[k].getID()+"\n");
                            DAOFactory.getDAOFactory().getRigaDistintaDAO().deleteAndDissociate(arrayRigaDistinta[k]);
                        }
                    }
                    DAOFactory.getDAOFactory().getPezzoDAO().deleteAndDissociate(arrayPezzo[j]);
                }
            }
            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().deleteAndDissociate(currentPezzo);

        } catch (PersistentException e) {
            e.printStackTrace();
        } finally {
            refreshListaPezzi(currentFornitore);
        }
    }

}
