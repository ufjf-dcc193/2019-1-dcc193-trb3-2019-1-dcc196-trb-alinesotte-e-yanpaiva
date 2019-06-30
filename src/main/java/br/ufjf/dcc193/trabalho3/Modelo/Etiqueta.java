package br.ufjf.dcc193.trabalho3.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


import lombok.Data;

/**
 * Etiqueta
 */
@Entity
@Data
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    @NotBlank(message = "Faça a descrição da Etiqueta.")
    private String descricaoTextual;

    @NotBlank(message = "Qual é a url?")
    private String url;

    @ManyToOne (cascade = CascadeType.ALL)
    private Item idItem;

    @ManyToOne (cascade = CascadeType.ALL)
    private Vinculo idVinculo;

    public Etiqueta(@NotBlank(message = "O título é obrigatório.") String titulo,
            @NotBlank(message = "Faça a descrição da Etiqueta.") String descricaoTextual,
            @NotBlank(message = "Qual é a url?") String url) {
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
        this.url = url;
    }

   public Etiqueta(){}
    
    

}