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
import br.ufjf.dcc193.trabalho3.Modelo.Vinculo;

import java.util.List;


import br.ufjf.dcc193.trabalho3.Repositorio.ItemRepositorio;
import br.ufjf.dcc193.trabalho3.Repositorio.VinculoRepositorio;

/**
 * ItemControlador
 */

 @Controller
 @RequestMapping("/vinculo")
public class VinculoControlador {

    @Autowired
    private VinculoRepositorio vinculoRepositorio;
    @Autowired
    private ItemRepositorio itemRepositorio;

    @RequestMapping({ "", "/", "/index.html" })
    public ModelAndView atividadeIndex(@RequestParam Long idItem) {
        ModelAndView mv = new ModelAndView();
        Item i = itemRepositorio.getOne(idItem);
        List<Vinculo> todosVinculosDoItem = vinculoRepositorio.findByIdItemOrigem(i);
        todosVinculosDoItem.addAll(vinculoRepositorio.findByIdItemDestino(i));
        if(todosVinculosDoItem.size()==0){
            mv.addObject("naoPossuiVinculo", true);
        }else{
            mv.addObject("vinculos", todosVinculosDoItem);
            mv.addObject("naoPossuiVinculo", true);       
        }
        mv.setViewName("vinculo-index.html");
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

        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        Vinculo v = new Vinculo();
        mv.addObject("vinculo", v);
        mv.setViewName("vinculo-adicionar.html");
        return mv;
    }

    @GetMapping(value = { "/editar{id}" })
    public ModelAndView editar(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        Vinculo vinculo = vinculoRepositorio.findById(id).get();
        mv.addObject("vinculo", vinculo);
        mv.setViewName("vinculo-form-edit.html");
        return mv;
    }

    @PostMapping("/editar{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Vinculo vinculo, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("vinculo-form-edit.html");
            mv.addObject("vinculo", vinculo);
            return mv;
        }
        vinculoRepositorio.save(vinculo);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(value = { "/excluir.html" })
    public ModelAndView excluir(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView();
        vinculoRepositorio.deleteById(id);
        mv.setViewName("redirect:/listar.html");
        return mv;
    }
}