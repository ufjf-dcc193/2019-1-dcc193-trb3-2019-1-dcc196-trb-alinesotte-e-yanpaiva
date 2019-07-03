package br.ufjf.dcc193.trabalho3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho3.Modelo.Usuario;

/**
 * ItemRepositorio<
 */
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 @Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    @Query("SELECT u.id FROM Usuario u WHERE u.email =:email and u.codigoAcesso =:codigoAcesso")
    Long getIdByEmailAndSenha(@Param("email") String email,
     @Param("codigoAcesso") String codigoAcesso);
}