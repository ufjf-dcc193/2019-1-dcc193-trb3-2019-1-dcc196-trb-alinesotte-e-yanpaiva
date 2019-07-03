package br.ufjf.dcc193.trabalho3.Controlador;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho3.Modelo.Usuario;
import br.ufjf.dcc193.trabalho3.Repositorio.UsuarioRepositorio;

/**
 * LoginControlador
 */

 @Controller
 public class LoginControlador {
    
    @Autowired
    UsuarioRepositorio repositorio;

    @PostMapping(value="/login.html")
    public ModelAndView login(String email, String senha){
            ModelAndView mv = new ModelAndView();
            Usuario usuario= repositorio.getOne(
                repositorio.getIdByEmailAndSenha(email, senha)); 
            mv.addObject("usuario", usuario);
            mv.setViewName("redirect:usuario-login.html");
            return mv;
    }

    @GetMapping(value="/login.html")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
       Usuario usuario= new Usuario();
        mv.addObject("usuario", usuario);
        mv.setViewName("usuario-login.html");
        return mv;
    }


}