package br.ufjf.dcc193.trabalho3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho3.Modelo.Usuario;

/**
 * ItemRepositorio<
 */

 @Repositorys
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    
    
}