package br.ufjf.dcc193.trabalho3.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @OneToOne(mappedBy = "idItemOrigem")
    private Vinculo idVinculoOrigem;

    @OneToOne(mappedBy = "idItemDestino")
    private Vinculo idVinculoDestino;

    public Item(@NotBlank(message = "Qual é o título?") String titulo) {
        this.titulo = titulo;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Anotacao> getIdAnotacaos() {
        return idAnotacaos;
    }

    public void setIdAnotacaos(List<Anotacao> idAnotacaos) {
        this.idAnotacaos = idAnotacaos;
    }

    public List<Etiqueta> getIdEtiquetas() {
        return idEtiquetas;
    }

    public void setIdEtiquetas(List<Etiqueta> idEtiquetas) {
        this.idEtiquetas = idEtiquetas;
    }

    public Vinculo getIdVinculoOrigem() {
        return idVinculoOrigem;
    }

    public void setIdVinculoOrigem(Vinculo idVinculoOrigem) {
        this.idVinculoOrigem = idVinculoOrigem;
    }

    public Vinculo getIdVinculoDestino() {
        return idVinculoDestino;
    }

    public void setIdVinculoDestino(Vinculo idVinculoDestino) {
        this.idVinculoDestino = idVinculoDestino;
    }

 
}