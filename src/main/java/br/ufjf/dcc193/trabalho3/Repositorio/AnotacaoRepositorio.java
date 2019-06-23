package br.ufjf.dcc193.trabalho3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho3.Modelo.Anotacao;

/**
 * ItemRepositorio<
 */
@Repository
public interface AnotacaoRepositorio extends JpaRepository<Anotacao,Long> {

    
    
}