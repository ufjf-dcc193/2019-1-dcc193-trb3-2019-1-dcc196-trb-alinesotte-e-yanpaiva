package br.ufjf.dcc193.trabalho3.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "Título obrigatório.")
    private String Titulo;

    @NotBlank(message ="Descrição Textual Obrigatória")
    private String decricaoTextual;

    
    private String url;

    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioid;
    
    @ManyToOne (cascade = CascadeType.ALL)
    private Item idItem;

    @ManyToOne (cascade = CascadeType.ALL)
    private Vinculo idVinculo;

    @OneToOne(mappedBy = "idAnotacao") 
    private Usuario idUsuario;
}