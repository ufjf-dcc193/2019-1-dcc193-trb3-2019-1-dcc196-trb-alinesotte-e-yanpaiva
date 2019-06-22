package br.ufjf.dcc193.trabalho3.Modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String titulo;

    
    private List<Anotacao> idAnotacaos;

    private List<Etiqueta> idEtiquetas;

    private List<Vinculo> idVinculos;

    
    


}