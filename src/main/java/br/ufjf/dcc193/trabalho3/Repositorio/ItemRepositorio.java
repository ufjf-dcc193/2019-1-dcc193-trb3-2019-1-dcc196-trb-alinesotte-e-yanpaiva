package br.ufjf.dcc193.trabalho3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trabalho3.Modelo.Item;

/**
 * ItemRepositorio<
 */
public interface ItemRepositorio extends JpaRepository<Item,Long> {

    
    
}