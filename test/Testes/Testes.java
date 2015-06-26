/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Dados.Contato;
import Dados.DB;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class Testes {
    
    public Testes() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testeObjetoDB() {
        /**
         * DB.listaContatos()
         */
        System.out.println("Lista de Contatos: ");
        
        List<Contato> contatos = new ArrayList<>();
        contatos = DB.listaContatos();
        String dsContato;
        for (int i = 0;  i < contatos.size(); i++)
        {
            Contato cl = contatos.get(i);
            dsContato = "Nome: " + cl.getNome()     + "\n"
                      + "Mail: " + cl.getEmail()    + "\n"
                      + "Fone: " + cl.getTelefone() + "\n";
            System.out.println(dsContato);
        }        
        
        /**
         * DB.pegaContato(codigo)
         */        
        System.out.println("/-----------------------------------/");
        System.out.println("Pega um contato pelo código.");
        System.out.println("Exemplo, o contato '1':");
        
        Contato cp = DB.pegaContato(1);
        dsContato = "Nome: " + cp.getNome()     + "\n"
                  + "Mail: " + cp.getEmail()    + "\n"
                  + "Fone: " + cp.getTelefone() + "\n";
        System.out.println(dsContato);
        
        /**
         * DB.inserirContato(c);
         */        
        System.out.println("/-----------------------------------/");
        System.out.println("Insere um novo contato: ");
        Contato ci = new Contato();
        ci.setNome("Marcelo Rebonatto");
        ci.setEmail("rebonatto@upf.br");
        ci.setTelefone("(54)9912-2345");
        if (DB.inserirContato(ci))
            System.out.println("Pessoa inserida!!");
        
        /**
         * DB.alterarContato(c);
         */        
        System.out.println("/-----------------------------------/");
        System.out.println("Altera um dado de um contato com o nome 'Marcelo':");
        int codigoAlterar = DB.obtemCodigoContato("Marcelo");
        
        Contato ca = DB.pegaContato(codigoAlterar);
        ca.setTelefone("Alterado");
        
        if (DB.alterarContato(ca))
        {
            System.out.println("Pessoa Alterada: ");
            ca = DB.pegaContato(codigoAlterar);
            dsContato = "Nome: " + ca.getNome()     + "\n"
                      + "Mail: " + ca.getEmail()    + "\n"
                      + "Fone: " + ca.getTelefone() + "\n";
            System.out.println(dsContato);
        }
        
         /**
         * DB.alterarContato(c);
         */        
        System.out.println("/-----------------------------------/");
        System.out.println("Exclui um contato com o nome 'Marcelo':");
        int codigoExcluir = DB.obtemCodigoContato("Marcelo");
        
        Contato ce = DB.pegaContato(codigoExcluir);
        String nomeExcluido = ce.getNome();
        
        if (DB.excluirContato(codigoExcluir))
        {
            System.out.println("Pessoa Excluida: ");
            System.out.println("Nome: " + nomeExcluido);
        }
        
        
        /**
         * DB.listaContatos()
         */
        System.out.println("Lista de Contatos: ");
        for (int i = 0;  i < contatos.size(); i++)
        {
            Contato cl = contatos.get(i);
            dsContato = "Nome: " + cl.getNome()     + "\n"
                      + "Mail: " + cl.getEmail()    + "\n"
                      + "Fone: " + cl.getTelefone() + "\n";
            System.out.println(dsContato);
        }
     }
}
