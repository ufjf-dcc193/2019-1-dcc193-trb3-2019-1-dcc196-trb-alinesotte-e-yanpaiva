package br.ufjf.dcc193.trabalho3.Modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * Vinculo
 */
@Entity
@Data
 public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Item idItemOrigem;

    @OneToOne
    private Item idItemDestino;

    @OneToMany(mappedBy = "idVinculo")
    private List<Etiqueta> idEtiquetas;

    @OneToMany(mappedBy = "idVinculo")
    private List<Anotacao> idAnotacaos;
    
    @ManyToMany
    @JoinTable(name="ITEM_VINCULO",joinColumns={@JoinColumn(name="idItem")},
    inverseJoinColumns={@JoinColumn(name="idVinculo")})
    private List<Item> idItem;

}