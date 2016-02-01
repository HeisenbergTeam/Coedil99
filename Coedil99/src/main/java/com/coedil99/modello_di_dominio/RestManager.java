package com.coedil99.modello_di_dominio;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by Igor on 31/01/2016.
 */
public class RestManager {
    private static RestManager _instance;
    private WebTarget target;

    private RestManager()
    {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        target = client.target(UriBuilder.fromUri("http://localhost:8080/Coedil99Server/webapi").build());
    }

    public static RestManager instance()
    {

        if (_instance == null) {
            _instance = new RestManager();
        }

        return _instance;
    }

    public WebTarget getTarget() {
        return target;
    }
}
