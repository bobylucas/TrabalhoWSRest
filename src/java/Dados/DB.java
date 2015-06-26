/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebParam;
import Dados.Contato;

/**
 *
 * @author lucas
 */
public class DB {
    /**
     * Monta uma consulta em toda a tabela "contato" e alimeta um array.
     * @return Retorna um array List<Contato> com todos os Contatos encontrados.
     */
    public static List<Contato> listaContatos() {
        String sql;
        List<Contato> object = new ArrayList<>();
        
        try {
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "SELECT * FROM contato";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Contato c = new Contato();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                object.add(c);
            }
            st.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println("Erro de consulta: " + e.getMessage());
        }
        
        return object;
    }
    
    /**
     * Monta uma consulta de um contato específico da tabela "contato".
     * @param codigo Código do contato a ser encontrado
     * @return Retorna um objeto Pessoa com o contato encontrado
     */
    public static Contato pegaContato(int codigo) {
        String sql;
        Contato c = new Contato();
        
        try {
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "SELECT * FROM contato WHERE codigo = " + codigo + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
        return c;
    }
    
    /**
     * Monta uma consulta de um código de um contato 
     * específico da tabela "contato".
     * @param nome Nome do contato a ser encontrado
     * @return Retorna um int "codigo" do contato encontrado
     */
    public static int obtemCodigoContato(String nome) {
        String sql;
        int codigo = 0;
        
        try {
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "SELECT codigo FROM contato WHERE nome ~* '" + nome + "' LIMIT 1;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                codigo = rs.getInt("codigo");
            }
            
            st.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
        return codigo;
    }
    
    /**
     * Monta um Insert com os dados do objeto Contato repassado 
     * e insere na tabela contato
     * @param c Objeto Contato com os dados a serem inseridos
     * @return Boolean se efetuou a inserção ou o erro
     */
    public static boolean inserirContato(Contato c) {        
        String sql;
        System.out.println("Inserindo pessoa: "+ c.getNome());
        try 
        {
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "INSERT INTO contato (nome, email, telefone) VALUES (?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3, c.getTelefone());            
            st.execute();
            
            st.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    /**
     * Monta um Update com os dados do objeto Contato repassado
     * @param c Objeto com os dados a serem alterados
     * @return Boolean se efetuou a alteração ou o erro
     */
    public static boolean alterarContato(Contato c) {        
        String sql;
        
        try 
        {
            System.out.println("Alterando contato: "+ c.getNome());
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "UPDATE contato SET nome = ?, email = ?, telefone = ? WHERE codigo = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3, c.getTelefone());
            st.setInt(4, c.getCodigo());
            st.execute();
            
            st.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    /**
     * Monta um Delete com os dados do código repassado
     * @param codigo Código do contato que será excluido
     * @return Boolean se efetuou a exclusão ou o erro
     */
    public static boolean excluirContato(int codigo) {
        String sql;
        
        try 
        {            
            Connection con = new ConnectionFactory().getConnection();
            
            sql = "DELETE FROM contato WHERE codigo = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigo); 
            st.execute();
            
            st.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
}
