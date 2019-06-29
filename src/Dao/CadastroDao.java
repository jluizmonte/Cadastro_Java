package Dao;


import java.util.List;

import entidade.Cadastro;

public interface CadastroDao {
	public void salvar(Cadastro cadastro);
	public void alterar(Cadastro cadastro);
	public void remover(Cadastro cadastro);
	public Cadastro pesquisar(String nome);
	public List<Cadastro> recuperarTodos();
}




/*
import factory.ConnectionFactory;
import Model.Cadastro;
import java.sql.*;
import java.sql.PreparedStatement;
public class CadastroDao { 
    private ConnectionFactory acesso;
    private PreparedStatement st;
    int id;
    String nome;
    String email;
    String telefone;
    public CadastroDao(){ 
        acesso = new ConnectionFactory();
    } 
    public boolean addCadastro(Cadastro cadastro) throws SQLException{ 
        acesso.conectar();
        st = acesso.getConect().prepareStatement(
                "INSERT INTO usuario(nome,email,telefone) VALUES(?,?,?,?)");
        try {
            
            st.setString(1,cadastro.getNome());
            st.setString(2, cadastro.getEmail());
            st.setString(3, cadastro.getTelefone());
            st.executeUpdate();
            st.close();
            return true;
        } 
        catch (SQLException u) { 
            System.err.println("Erro, Insert não realizado");
            return false;
            
       }finally{
            acesso.desconectar();
        }
        
    } 
    
    public void UpCad(Cadastro cadastro) throws SQLException{
        acesso.conectar();
        String sql = "UPDATE CADASTRO SET NOME = ?, EMAIL=?,SENHA=?,TELEFONE=? WHERE NOME ="+cadastro.getNome();
        
        st = acesso.conectar().prepareStatement(sql);
        st.setString(1,cadastro.getNome());
        st.setString(2,cadastro.getEmail());
        st.setString(3,cadastro.getSenha());
        st.setString(4,cadastro.getTelefone());
        
        st.executeUpdate();
        acesso.desconectar();
    }
    
    public void pesCad(Cadastro cadastro) throws SQLException{
        acesso.conectar();
        String sql = "SELECT CADASTRO SET NOME = ?, EMAIL=?,SENHA=?,TELEFONE=? WHERE NOME ="+cadastro.getNome();
        
        st = acesso.conectar().prepareStatement(sql);
        st.setString(1,cadastro.getNome());
        st.setString(2,cadastro.getEmail());
        st.setString(3,cadastro.getSenha());
        st.setString(4,cadastro.getTelefone());
        
        st.execute();
        System.out.println("Cadastro: "+cadastro.getNome()+ " - "+cadastro.getEmail()+" - "+cadastro.getTelefone()+" - "+cadastro.getSenha());
        acesso.desconectar();
    }
    
    public void LitCadastro() throws SQLException{
        acesso.conectar();
        String sql = "SELECT cadastro.NOME, cadastro.EMAIL, cadastro.SENHA, cadastro.TELEFONE FROM CADASTRO cadastro";
        PreparedStatement ps = acesso.getConect().prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        
        while(res.next()){
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(res.getString("NOME"));
            cadastro.setEmail(res.getString("EMAIL"));
            cadastro.setSenha(res.getString("SENHA"));
            cadastro.setTelefone(res.getNString("TELEFONE"));
            System.out.println("Cadastro: "+cadastro.getNome()+ " - "+cadastro.getEmail()+" - "+cadastro.getTelefone()+" - "+cadastro.getSenha());
        }
        acesso.desconectar();
    }
    
    public void DeletCadastro() throws SQLException{
        String sql = "DELETE FROM CADASTRO WHERE nome =" +nome;
        st = acesso.conectar().prepareStatement(sql);
        st.executeUpdate();
    }
    
}*/
