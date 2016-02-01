package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.DescrizionePezzo;
import com.coedil99.modello_di_dominio.Pezzo;
import org.glassfish.jersey.client.ClientConfig;
import org.orm.PersistentException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * Created by Igor on 20/01/2016.
 */
public class Main {

    public static void main(String args[]) throws PersistentException {

        Pezzo pezzo = DAOFactory.getRestDAOFactory().getPezzoDAO().getPezzoByORMID(1);
        System.out.println(pezzo);
        try {

            DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO()
                    .getDescrizionePezzoByORMID(1);
            Pezzo pezzo1 = DAOFactory.getDAOFactory().getPezzoDAO().createPezzo();
            pezzo1.setDescrizionePezzo(descrizionePezzo);
            DAOFactory.getDAOFactory().getPezzoDAO().save(pezzo1);
            //target.path("pezzo").request().accept(MediaType.APPLICATION_JSON)
            //        .put(Entity.entity(pezzo1,MediaType.APPLICATION_JSON_TYPE));

            //System.out.println(Entity.entity(pezzo1,MediaType.APPLICATION_JSON_TYPE).toString());

        } catch (PersistentException e) {
            e.printStackTrace();
        }





    }
}
