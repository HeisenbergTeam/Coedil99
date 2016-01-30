package com.coedil99.rest;

import com.coedil99.modello_di_dominio.Pezzo;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * Created by Igor on 20/01/2016.
 */
public class Main {
    public static void main(String args[])
    {


        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8080/Coedil99Server/webapi").build());

        Pezzo pezzo = target.path("pezzo").path("1").
                request().
                accept(MediaType.APPLICATION_JSON).
                get(Pezzo.class);


        System.out.println(pezzo);


    }
}
