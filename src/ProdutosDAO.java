/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){

        conn = new conectaDAO().connectDB();
         try{
            PreparedStatement ps = conn.prepareStatement("insert into produtos values(0,?,?,?)");
            ps.setString(1, produto.getNome()); 
            ps.setInt(2, produto.getValor()); 
            ps.setString(3,produto.getStatus());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso! :D");
            } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao adicionar o produto :(");
            System.out.println(e);
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        conn = new conectaDAO().connectDB();
        try{
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("Select * from produtos");
         while( rs.next() ){
             ProdutosDTO prod = new ProdutosDTO();
             prod.setId(rs.getInt("id"));
             prod.setNome(rs.getString("nome"));
             prod.setValor(rs.getInt("valor"));
             prod.setStatus(rs.getString("status"));
             listagem.add(prod);
         }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao adicionar o produto :(");
            System.out.println(e);
        }

        System.out.println(listagem.get(0));

        return listagem;
    }
    
    
    
        
}

