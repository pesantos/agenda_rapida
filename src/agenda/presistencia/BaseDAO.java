/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda.presistencia;

import javax.persistence.EntityManager;

/**
 *
 * @author Paulo
 */
public class BaseDAO {
    public EntityManager c;
    public BaseDAO(){
        c = Fabrica.obter();
    }
    
    public void ab(){
        if(c.getTransaction().isActive())co();
        c.getTransaction().begin();
    }
    
    public void co(){
        if(!c.getTransaction().isActive())ab();
        c.getTransaction().commit();
        
    }
}
