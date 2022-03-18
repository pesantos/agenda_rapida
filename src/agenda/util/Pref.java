/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class Pref {
    
    public static String load(String atributo){
        Properties prop = new Properties();
        InputStream input = null;
        String valor ="";
        File f = new File(CONS.USUARIOS);
        System.out.println(""+f.getAbsolutePath());
        try{
            input = new FileInputStream(CONS.USUARIOS);
            prop.load(input);
            valor = prop.getProperty(atributo);
            prop.remove(atributo);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(input!=null){
                try{
                input.close();
                }catch(Exception e){
                    e.printStackTrace();
                    
                }
            }
        }
        return valor;
    }
    
    public static void save(String atributo, String valor){
        OutputStream output = null;
        InputStream input = null;
        File arq = new File(CONS.USUARIOS);
        try{
            Properties prop = new Properties();
            if(arq.exists()){
                input = new FileInputStream(arq);
                prop.load(input);
            }
            output = new FileOutputStream(CONS.USUARIOS);
            prop.setProperty(atributo, valor);
            
            prop.store(output,null);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            if(output!=null){
                try{
                output.close();
                
                }catch(Exception e){
                    e.printStackTrace();
                    
                }
            }
            if(input!=null){
                try{
                input.close();
                
                }catch(Exception e){
                    e.printStackTrace();
                    
                }
            }
        }
    }
    
}
