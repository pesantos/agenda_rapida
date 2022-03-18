package com.agenda.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-08T13:32:31")
@StaticMetamodel(Compromisso.class)
public class Compromisso_ { 

    public static volatile SingularAttribute<Compromisso, String> ativo;
    public static volatile SingularAttribute<Compromisso, Long> id;
    public static volatile SingularAttribute<Compromisso, Date> dia;
    public static volatile SingularAttribute<Compromisso, Integer> aviso;
    public static volatile SingularAttribute<Compromisso, String> descricao;

}