/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author lucas
 */
@Path("Cotacao2")
public class Cotacao2 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Cotacao2Resource
     */
    public Cotacao2() {
    }

    /**
     * Retrieves representation of an instance of Servico.Cotacao2
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{MO}/{MD}")
    @Produces(MediaType.TEXT_PLAIN)
    public String CotacaoPathParam(@PathParam("MO") String mo, @PathParam("MD") String md){
        Random r = new Random();
        int gerado = r.nextInt(1000);
        
        if ((mo.compareToIgnoreCase("Real")) == 0 || (md.compareToIgnoreCase("Real")) == 0){
            gerado = -1;
        }
                
        return "PathParam " + mo + " to " + md + " = " + String.valueOf(gerado);
        //return String.valueOf(gerado);
    }
    
    @GET
    @Path("/CotacaoMatrix")
    @Produces(MediaType.TEXT_PLAIN)
    public String CotacaoMatrixParam(@MatrixParam("MO") String mo, @MatrixParam("MD") String md){
        Random r = new Random();
        int gerado = r.nextInt(1000);
        
        if ((mo.compareToIgnoreCase("Real")) == 0 || (md.compareToIgnoreCase("Real")) == 0){
            gerado = -1;
        }
                
        return "MatrixParam " + mo + " to " + md + " = " + String.valueOf(gerado);
        //return String.valueOf(gerado);
    }
    
    @GET
    @Path("/CotacaoQuery")
    @Produces(MediaType.TEXT_PLAIN)
    public String CotacaoQueryParam(@QueryParam("MO") String mo, @QueryParam("MD") String md){
        Random r = new Random();
        int gerado = r.nextInt(1000);
        
        if ((mo.compareToIgnoreCase("Real")) == 0 || (md.compareToIgnoreCase("Real")) == 0){
            gerado = -1;
        }
        if (mo == md)
            gerado = 1;
                
        return "QueryParam " + mo + " to " + md + " = " + String.valueOf(gerado);
    }

    /**
     * PUT method for updating or creating an instance of Cotacao2
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
