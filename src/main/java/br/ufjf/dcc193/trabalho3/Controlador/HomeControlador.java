package br.ufjf.dcc193.trabalho3.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeControlador
 */
@Controller
public class HomeControlador {

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home-index.html");
        return mv;
    }
}