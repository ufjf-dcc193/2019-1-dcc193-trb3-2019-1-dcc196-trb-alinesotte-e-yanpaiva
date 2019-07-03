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
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String nomeItemOrigem;
    @NotBlank
    private String nomeItemDestino;
    @OneToOne
    private Item idItemOrigem;

    @OneToOne
    private Item idItemDestino;

    @OneToMany(mappedBy = "idVinculo")
    private List<Etiqueta> idEtiquetas;

    @OneToMany(mappedBy = "idVinculo")
    private List<Anotacao> idAnotacaos;
    
    public Vinculo() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getIdItemOrigem() {
        return idItemOrigem;
    }

    public void setIdItemOrigem(Item idItemOrigem) {
        this.idItemOrigem = idItemOrigem;
    }

    public Item getIdItemDestino() {
        return idItemDestino;
    }

    public void setIdItemDestino(Item idItemDestino) {
        this.idItemDestino = idItemDestino;
    }

    public List<Etiqueta> getIdEtiquetas() {
        return idEtiquetas;
    }

    public void setIdEtiquetas(List<Etiqueta> idEtiquetas) {
        this.idEtiquetas = idEtiquetas;
    }

    public List<Anotacao> getIdAnotacaos() {
        return idAnotacaos;
    }

    public void setIdAnotacaos(List<Anotacao> idAnotacaos) {
        this.idAnotacaos = idAnotacaos;
    }

    public String getNomeItemOrigem() {
        return nomeItemOrigem;
    }

    public void setNomeItemOrigem(String nomeItemOrigem) {
        this.nomeItemOrigem = nomeItemOrigem;
    }

    public String getNomeItemDestino() {
        return nomeItemDestino;
    }

    public void setNomeItemDestino(String nomeItemDestino) {
        this.nomeItemDestino = nomeItemDestino;
    }

    public Vinculo(@NotBlank String nomeItemOrigem, @NotBlank String nomeItemDestino, Item idItemOrigem,
            Item idItemDestino, List<Etiqueta> idEtiquetas, List<Anotacao> idAnotacaos, List<Item> idItem) {
        this.nomeItemOrigem = nomeItemOrigem;
        this.nomeItemDestino = nomeItemDestino;
        this.idItemOrigem = idItemOrigem;
        this.idItemDestino = idItemDestino;
        this.idEtiquetas = idEtiquetas;
        this.idAnotacaos = idAnotacaos;
    }



}