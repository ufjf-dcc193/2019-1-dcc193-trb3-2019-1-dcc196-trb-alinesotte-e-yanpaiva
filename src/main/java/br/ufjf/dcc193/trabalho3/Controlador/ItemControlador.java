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
import br.ufjf.dcc193.trabalho3.Modelo.Item;

import java.util.List;


import br.ufjf.dcc193.trabalho3.Repositorio.ItemRepositorio;

/**
 * ItemControlador
 */

 @Controller
 @RequestMapping("/item")
public class ItemControlador {

    @Autowired
    private ItemRepositorio repositorio;

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView atividadeIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item-index.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Item> itens = repositorio.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lista-item.html");
        mv.addObject("itens", itens);
        return mv;

    }

    @PostMapping("/nova.html")
    public ModelAndView criar(@Valid Item item, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("item-adicionar.html");
            mv.addObject("Item", item);
            return mv;
        }

        repositorio.save(item);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item-adicionar.html");
        mv.addObject("item", new Item("titulo"));
        return mv;
    }

    @GetMapping(value = { "/editar{id}" })
    public ModelAndView editar(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        Item item = repositorio.findById(id).get();
        mv.addObject("item", item);
        mv.setViewName("item-form-edit.html");
        return mv;
    }

    @PostMapping("/editar{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Item item, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("item-form-edit.html");
            mv.addObject("item", item);
            return mv;
        }
        repositorio.save(item);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(value = { "/excluir.html" })
    public ModelAndView excluir(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        repositorio.deleteById(id);
        mv.setViewName("redirect:/item/listar.html");
        return mv;
    }
}