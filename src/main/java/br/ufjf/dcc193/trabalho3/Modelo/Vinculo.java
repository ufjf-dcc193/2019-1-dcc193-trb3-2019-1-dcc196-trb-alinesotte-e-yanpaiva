package br.ufjf.dcc193.trabalho3.Modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    
    private Item idItem;

    private Item idItem2;

    private List<Etiqueta> idEtiquetas;

    private List<Anotacao> idAnotacaos;
    
}