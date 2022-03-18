/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.DAO;

import agenda.presistencia.BaseDAO;
import com.agenda.modelo.Compromisso;
import com.agenda.modelo.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Paulo
 */
public class UsuarioDAO extends BaseDAO {

    public Usuario obterPeloNome(String nome) {
        if(nome==null ){
            return null;
        }
        if(nome.equals("..."))return null;
        
        
            ab();
            Query q = c.createQuery("Select e From usuario e where e.nome = ?1");
            q.setParameter(1, nome);
            List<Usuario> li =  q.getResultList();
            co();
        if(li!=null && !li.isEmpty()){
            return li.get(0);
        }
        
        return null;

        
        
    }

    public List<Usuario> obterTodos() {
        List<Usuario> lista = new LinkedList<Usuario>();
        try {
            ab();
            Query q = c.createQuery("Select e From usuario e");

            lista = (List<Usuario>) q.getResultList();
            co();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void inserirUsuario(Usuario us) {
        
            ab();

            c.persist(us);

            co();
        
            
        
    }
    
    public void atualizar(){
        ab();
        c.flush();
        co();
    }

    public void apagarUsuario(Usuario temp) {
        try {
            ab();

            temp = c.find(Usuario.class, temp.getId());
            c.remove(temp);

            co();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean nomeValido(String nome) {
        
        
            ab();
            Query query = c.createQuery("Select u From usuario u where u.nome =?1");
            query.setParameter(1, nome);
            List<Usuario> li =  query.getResultList();
            co();

        
            if(li!=null && !li.isEmpty()){
                return false;
            }
        

        return true;
    }

    public Usuario inserirCompromisso(Usuario us, Compromisso novo) {
        try {
            ab();
            us = c.find(Usuario.class, us.getId());
            novo.setAtivo("Sim");
            us.getCompromissos().add(novo);
            

            co();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
    
    public Usuario apagarCompromisso(Usuario us, Compromisso com){
        try {
            ab();
            us = c.find(Usuario.class, us.getId());
            Compromisso temp = null;
            for(Compromisso comp: us.getCompromissos()){
                if(comp.getId()==com.getId()){
                    temp = comp;
                }
            }
            
            if(temp!=null){
                temp.setAtivo("Nao");
            }
            c.flush();
            c.remove(temp);
            

            co();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
}
