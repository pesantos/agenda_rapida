/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda.presistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Paulo
 */
public class Fabrica {
    private static EntityManagerFactory fabrica;
    private static EntityManager em;
    
    public static EntityManager obter(){
        if(fabrica==null)construir();
        if(em==null || !em.isOpen())construirEm();
        return em;
    }
    
    private static void construir(){
      fabrica = Persistence.createEntityManagerFactory("AgendaRapidaPU");
        
    }

    private static void construirEm() {
        if(fabrica!=null){
            em = fabrica.createEntityManager();
        }else{
            construir();
            em = fabrica.createEntityManager();
        }
    }
    
    public static void fecharFabrica(){
        if(fabrica!=null && fabrica.isOpen()){
            fabrica.close();
        }
        
    }
}
