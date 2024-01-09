
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
    
    public Connection connectDB(){
        Connection conn = null;
        String password =  "";
        String user = "root";
        
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         String encpassword = "";
             try{
             encpassword = URLEncoder.encode(password, "UTF-8");
         }catch(Exception e){System.out.println("failed to encode connectuon url: "+e);}
             
         String url = "jdbc:mysql://localhost/uc11?user="+user+"&password="+encpassword+"&useTimezone=true&serverTimezone=UTC&useSSL=false";
         
         conn = DriverManager.getConnection(url); 
         
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar: driver mysql nao encontrado");
        }
        return conn;
    }
    
}
