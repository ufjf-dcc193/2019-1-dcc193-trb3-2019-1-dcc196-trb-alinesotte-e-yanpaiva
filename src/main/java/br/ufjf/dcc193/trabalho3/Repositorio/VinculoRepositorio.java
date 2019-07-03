package br.ufjf.dcc193.trabalho3.Repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.ufjf.dcc193.trabalho3.Modelo.*;

/**
 * ItemRepositorio<
 */
@Repository
public interface VinculoRepositorio extends JpaRepository<Vinculo,Long> {
    List<Vinculo> findVinculoByidItemOrigem(Item item);
    List<Vinculo> findVinculoByidItemDestino(Item item);
    
    @Modifying
    @Transactional
    @Query("delete from Vinculo v where v.idItemOrigem =:item")
    void deleteVinculoByidItemOrigem(@Param("item") Item item);
    @Query("delete from Vinculo v where v.idItemDestino =:item")
    void deleteVinculoByidItemDestino(@Param("item") Item item);
    
}