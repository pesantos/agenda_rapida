/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.modelo;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Paulo
 */
@Entity
public class Compromisso implements Serializable,Comparable{
    @Id
    @GeneratedValue
    private long id;
    @Resolvable(colName = "Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dia;
    @Resolvable(colName = "Dias de Aviso")
    private int aviso;
    @Resolvable(colName = "Descrição")
    private String descricao;
    private String ativo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAviso() {
        return aviso;
    }

    public void setAviso(int aviso) {
        this.aviso = aviso;
    }

    @Override
    public int compareTo(Object o) {
        Compromisso outro = (Compromisso)o;
        if(this.dia.getTime()>outro.getDia().getTime()){
            return 1;
        }else if(this.dia.getTime()<outro.getDia().getTime()){
            return -1;
        }else{
            return 0;
        }
    }
    
    
}
