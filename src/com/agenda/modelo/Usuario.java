/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Paulo
 */
@Entity(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String senha;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    private List<Compromisso> compromissos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }
    
    
    
    
    
    
    
}
