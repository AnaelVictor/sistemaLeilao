
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    static String user = "";
    static String password = "";
    
    public boolean setupPassword(){
        user = JOptionPane.showInputDialog("Informe o usuario da base de dados");
        password = JOptionPane.showInputDialog("Informe a senha da base de dados");
        if (this.connectDB() == null) return false;
        else return true;
    }

    public Connection connectDB(){
        
        Connection conn = null;
        
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         String encpassword = this.encrypt(password);
         String url = "jdbc:mysql://localhost/uc11?user="+user+"&password="+encpassword+"&useTimezone=true&serverTimezone=UTC&useSSL=false";
         
         conn = DriverManager.getConnection(url); 
         
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + erro.getMessage());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar: driver mysql nao encontrado");
        }
        return conn;
    }
    
    public String encrypt(String str){
         String enc = "";
         try{
             enc = URLEncoder.encode(str, "UTF-8");
         }catch(Exception e){System.out.println("failed to encode connectuon url: "+e);}
         return enc;
    }
   
}