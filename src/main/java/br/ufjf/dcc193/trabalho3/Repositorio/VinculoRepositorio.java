package br.ufjf.dcc193.trabalho3.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query("delete FROM Vinculo v WHERE ((idItemOrigem =:origem) AND (idItemDestino =:destino)) OR ((idItemOrigem =:destino) AND (idItemDestino =:origem)) ")
    void deleteVinculoPorIdItemOrigemEIdItemDestino(@Param("origem") Item origem, @Param("destino")Item destino);
    
}