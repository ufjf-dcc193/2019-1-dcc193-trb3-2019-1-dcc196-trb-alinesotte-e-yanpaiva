package br.ufjf.dcc193.trabalho3.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.ufjf.dcc193.trabalho3.Modelo.*;

/**
 * ItemRepositorio<
 */
@Repository
public interface VinculoRepositorio extends JpaRepository<Vinculo,Long> {
    List<Vinculo> findByIdItemOrigem(Item item);
    List<Vinculo> findByIdItemDestino(Item item);
    
    
}