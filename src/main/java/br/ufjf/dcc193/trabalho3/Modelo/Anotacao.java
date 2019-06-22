package br.ufjf.dcc193.trabalho3.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import java.util.Date;

/**
 * Anotacao
 */
@Entity
@Data
 public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String decricaoTextual;

    private String url;

    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioid;
    
}