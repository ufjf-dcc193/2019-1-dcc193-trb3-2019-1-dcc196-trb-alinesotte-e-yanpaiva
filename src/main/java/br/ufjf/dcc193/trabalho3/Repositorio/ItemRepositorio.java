package br.ufjf.dcc193.trabalho3.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho3.Modelo.Item;

/**
 * ItemRepositorio<
 */
@Repository
public interface ItemRepositorio extends JpaRepository<Item,Long> {
    @Query("SELECT i FROM Item i WHERE i.id NOT IN(:param)")
    List<Item> buscaItemDiferenteDe(@Param("param") Long id);
    
}