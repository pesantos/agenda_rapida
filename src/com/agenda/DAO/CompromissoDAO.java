/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.DAO;

import agenda.presistencia.BaseDAO;
import com.agenda.modelo.Compromisso;


/**
 *
 * @author Paulo
 */
public class CompromissoDAO extends BaseDAO{
    public void atualizaCompromisso(Compromisso comp){
        try{
            ab();
            Compromisso temp = null;
            temp = c.find(Compromisso.class, comp.getId());
            copiaBean(comp,temp);
            
            co();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void copiaBean(Compromisso origem,Compromisso destino){
        destino.setDia(origem.getDia());
        destino.setDescricao(origem.getDescricao());
    }
    
    
    
}
