
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Validacao {
    
    public static boolean validarCamposVazios(String ... args){
        for (String arg : args){
            if(arg.trim().isEmpty()){
            return false;  }
        }
        return true;
    }
    
    public static boolean validarNumero(String _num){
        try{
        int num = Integer.parseInt(_num);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}


