package br.ufjf.dcc193.trabalho3.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Itens
 */

 @Entity
 @Data
public class Item {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Qual é o título?")
    private String titulo;

    @OneToMany(mappedBy = "idItem",cascade = CascadeType.ALL)
    private List<Anotacao> idAnotacaos;

    @OneToMany(mappedBy ="idItem",cascade = CascadeType.ALL)
    private List<Etiqueta> idEtiquetas;

    @ManyToMany(mappedBy ="idItem",cascade = CascadeType.ALL)
    private List<Vinculo> idVinculos;

    @OneToOne(mappedBy = "idItemOrigem")
    private Vinculo idVinculoOrigem;

    @OneToOne(mappedBy = "idItemDestino")
    private Vinculo idVinculoDestino;

    public Item(@NotBlank(message = "Qual é o título?") String titulo) {
        this.titulo = titulo;
    }

    public Item() {
    }

 
}