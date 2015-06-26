/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dados.Contato;
import Dados.DB;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * GET    use PathParam
 * PUT    in JSON out XML use MatrixParam
 * PUT    out JSON use PathParam
 * POST   in XML use QueryParam
 * DELETE
 * @author lucas
 */
@Path("Contato")
public class WSRestObjetos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSRestObjetos
     */
    public WSRestObjetos() {
    }

    /**
     * Retrieves representation of an instance of Servico.WSRestObjetos
     * @return an instance of java.lang.String
     */
    @GET
    @Path("ListaContato")
    @Produces(MediaType.TEXT_HTML)
    public String getXmlContatos() {
        int i;
        String html, dsContato;
        List<Contato> contatos = new ArrayList<>();
        
        contatos = DB.listaContatos();
        html = "<h1>Lista de Contatos</h1>" + 
                "<ul>";
        
        for (i = 0;  i < contatos.size(); i++)
        {
            Contato c = contatos.get(i);
            dsContato = "<b>Nome: "     + c.getNome()     + " </b><br>"
                      + "<b>Mail: </b>" + c.getEmail()    + " <br>"
                      + "<b>Fone: </b>" + c.getTelefone() + " <br><br>";
            html += "<li>" + dsContato + "</li>";
        }
        html +=  "</ul>";
        return html;
    }
    
    @GET
    @Path("ContatoJson/{NOME}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Contato pegaPessoaJson(@PathParam("NOME") String nome) {
        int codigo = DB.obtemCodigoContato(nome);
        Contato c = DB.pegaContato(codigo);
        
        return c;
    } 
    
//    @GET
//    @Path("json")
//    @Produces("application/json") 
//    public Contato pegaPessoaJson() {
//        Contato tmp = new Contato();
//        
//        tmp.setCodigo(1);
//        tmp.setNome("Rest Web Service");
////        tmp.setAltura(8.76);
//        
//        return tmp;
//    } 
    
//    @GET
//    @Path("xml")
//    @Produces("application/xml") 
//    public Contato pegaContato() {
//        Contato tmp = new Contato();
//        
//        tmp.setCodigo(1);
//        tmp.setNome("Rest Web Service");
//        //tmp.setAltura(8.76);
//        
//        return tmp;
//    } 
//    

//    


    /**
     * PUT method for updating or creating an instance of WSRestObjetos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT    
    public void putXml() {
    }
}
