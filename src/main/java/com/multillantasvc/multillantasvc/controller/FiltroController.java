package com.multillantasvc.multillantasvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multillantasvc.multillantasvc.model.CategoriaFiltro;
import com.multillantasvc.multillantasvc.model.Filtro;
import com.multillantasvc.multillantasvc.service.ICategoriaFiltroService;
import com.multillantasvc.multillantasvc.service.IFiltroService;

import jakarta.validation.Valid;

@Controller
public class FiltroController {
    // --------------------------------------------------------------------
    // Services
    @Autowired
    IFiltroService filtroService;
    @Autowired
    ICategoriaFiltroService categoriaFiltroService;

    // --------------------------------------------------------------------
    // Para Listar
    @GetMapping(value = "/vistas/filtros/ListarFiltros")
    public String filtro(Model model) {
        List<Filtro> filtros = filtroService.getAll();
        List<CategoriaFiltro> categoriafiltros = categoriaFiltroService.getAll();
        model.addAttribute("filtro", filtros);
        model.addAttribute("categoriafiltros", categoriafiltros);
        return "/vistas/filtros/ListarFiltros";
    }

    // --------------------------------------------------------------------
    // Para registrar filtro - GET
    @GetMapping(value = "/vistas/filtros/AgregarFiltro")
    public String registrarFiltro(Model model) {
        Filtro filtros = new Filtro();
        List<CategoriaFiltro> categoriafiltros = categoriaFiltroService.getAll();
        model.addAttribute("filtro", filtros);
        model.addAttribute("categoriafiltro", categoriafiltros);
        return "/vistas/filtros/AgregarFiltro";
    }

    // --------------------------------------------------------------------
    // Para registrar filtro - POST
    @PostMapping(value = "/vistas/filtros/AgregarFiltro")
    public String saveFiltro(
            @Valid @ModelAttribute Filtro filtro,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        List<CategoriaFiltro> categoriafiltros = categoriaFiltroService.getAll();
        if (result.hasErrors()) {
            model.addAttribute("filtros", filtro);
            model.addAttribute("categoriafiltro", categoriafiltros);
            return "/vistas/filtros/AgregarFiltro";
        }
        filtroService.save(filtro);
        redirectAttributes.addFlashAttribute("mensaje", "Filtro registrado con Exito!");
        return "redirect:/vistas/filtros/";
    }

    // --------------------------------------------------------------------
    // Editar
    @GetMapping("/vistas/filtros/editarFiltro/{id}")
    public String editarFiltro(
            @PathVariable("id") int id_filtro,
            Model model,
            RedirectAttributes redirectAttributes) {
        Filtro filtro = null;
        if (id_filtro > 0) {
            filtro = filtroService.buscarFiltroPorID(id_filtro);

            // Validación a nivl de la URL
            if (filtro == null) {
                redirectAttributes.addFlashAttribute("error", "Error. El ID no existe.");
                return "redirect:/vistas/filtros/ListarFiltros";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Error.");
            return "redirect:/vistas/filtros/ListarFiltros";
        }
        List<CategoriaFiltro> categoriafiltros = categoriaFiltroService.getAll();
        model.addAttribute("filtro", filtro);
        model.addAttribute("categoriafiltro", categoriafiltros);
        return "/vistar/filtros/AgregarFiltro";
    }

    // --------------------------------------------------------------------
    // Eliminar
    @GetMapping("/vistas/filtros/eliminarFiltro/{id}")
    public String eliminarFiltro(
            @PathVariable("id") int id_filtro,
            Model model,
            RedirectAttributes redirectAttributes) {
        Filtro filtro = null;
        if (id_filtro > 0) {
            filtro = filtroService.buscarFiltroPorID(id_filtro);
            // validación a nivel de la URL
            if (filtro == null) {
                redirectAttributes.addFlashAttribute("error", "El ID no existe.");
                return "redirect:/vistas/filtros/ListarFiltros";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Error.");
            return "redirect:/vistas/filtros/ListarFiltros";
        }
        filtroService.eliminarFiltro(id_filtro);
        redirectAttributes.addFlashAttribute("warning", "Filtro eliminado.");
        return "redirect:/vistas/filtros/ListarFiltros";
    }

}
