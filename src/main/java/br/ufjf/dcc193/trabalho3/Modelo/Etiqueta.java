package br.ufjf.dcc193.trabalho3.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}