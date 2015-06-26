/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author lucas
 */
@Path("Cotacao")
public class Cotacao {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Cotacao
     */
    public Cotacao() {
    }

    /**
     * Retrieves representation of an instance of Servico.Cotacao
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<h1>Hello World</h1>");
        return html.toString();
    }

    @GET
    @Path("Dolar2Real")
    @Produces(MediaType.TEXT_XML)
    public String getCotacaoDolar2Real() {
        StringBuilder html = new StringBuilder();
        html.append("<cotacao>3.20</cotacao>");
        return html.toString();
    }
    
    @GET
    @Path("Euro2Real")
    @Produces(MediaType.TEXT_XML)
    public String getCotacaoEuro2Real() {
        StringBuilder html = new StringBuilder();
        html.append("<cotacao>3.51</cotacao>");
        return html.toString();
    }
    
    
    /**
     * PUT method for updating or creating an instance of Cotacao
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
