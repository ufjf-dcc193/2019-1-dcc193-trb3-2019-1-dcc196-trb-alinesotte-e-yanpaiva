package br.ufjf.dcc193.trabalho3.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho3.Modelo.Etiqueta;
import java.util.List;

import br.ufjf.dcc193.trabalho3.Repositorio.EtiquetaRepositorio;

/**
 * EtiquetaControlador
 */

@Controller
@RequestMapping("/etiqueta")
public class EtiquetaControlador {

    @Autowired
    private EtiquetaRepositorio repositorio;

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView atividadeIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("etiqueta-index.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Etiqueta> etiquetas = repositorio.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lista-etiquetas.html");
        mv.addObject("etiquetas", etiquetas);
        return mv;

    }

    @PostMapping("/nova.html")
    public ModelAndView criar(@Valid Etiqueta etiqueta, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("etiqueta-adicionar.html");
            mv.addObject("etiqueta", etiqueta);
            return mv;
        }

        repositorio.save(etiqueta);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("etiqueta-adicionar.html");
        mv.addObject("etiqueta", new Etiqueta("titulo", "descricaoTextual", "url"));
        return mv;
    }

    @GetMapping(value = { "/editar{id}" })
    public ModelAndView editar(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        Etiqueta etiqueta = repositorio.findById(id).get();
        mv.addObject("etiqueta", etiqueta);
        mv.setViewName("etiqueta-form-edit.html");
        return mv;
    }

    @PostMapping("/editar{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Etiqueta etiqueta, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("etiqueta-form-edit.html");
            mv.addObject("etiqueta", etiqueta);
            return mv;
        }
        repositorio.save(etiqueta);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(value = { "/excluir.html" })
    public ModelAndView excluir(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        repositorio.deleteById(id);
        mv.setViewName("redirect:/etiqueta/listar.html");
        return mv;
    }

}
