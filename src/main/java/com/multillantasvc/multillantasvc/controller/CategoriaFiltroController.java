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
import com.multillantasvc.multillantasvc.service.ICategoriaFiltroService;

import jakarta.validation.Valid;

@Controller
public class CategoriaFiltroController {
    @Autowired
    private ICategoriaFiltroService categoriaFiltroService;

    // -------------------------------------------------------------------------------------------------------
    // PARA LISTAR
    @GetMapping(value = "/vistas/CategoriaFiltros/ListadoCategoria")
    public String listarCategoriaFiltros(Model model) {
        List<CategoriaFiltro> categoriafiltros = categoriaFiltroService.getAll();
        model.addAttribute("categoriafiltro", categoriafiltros);
        return "/vistas/CategoriaFiltros/ListadoCategoria";
    }

    // -------------------------------------------------------------------------------------------------------
    // Registrar categoria de filtro - GET
    @GetMapping(value = "/vistas/CategoriaFiltros/RegistrarCategoriaFiltro/")
    public String registrarCategoriaFiltroGet(Model model) {
        CategoriaFiltro categoriafiltro = new CategoriaFiltro();
        model.addAttribute("categoriafiltro", categoriafiltro);
        return "/vistas/CategoriaFiltros/RegistrarCategoriaFiltro/";
    }

    // -------------------------------------------------------------------------------------------------------
    // Registrar categoria de filtro - POST
    @PostMapping(value = "/vistas/CategoriaFiltros/ListarCategoriaFiltro")
    public String registrarCategoriaFiltroPost(
            @Valid @ModelAttribute CategoriaFiltro categoriafiltro,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("categoriafiltro", categoriafiltro);
            return "/vistas/CategoriaFiltros/RegistrarCategoriaFiltro/";
        }
        categoriaFiltroService.guardarCategoriaFiltro(categoriafiltro);
        redirectAttributes.addFlashAttribute("mensaje", "Categoria de Filtro registrado correctamente.");
        return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
    }

    // -------------------------------------------------------------------------------------------------------
    // Eliminar
    @GetMapping(value = "/vistas/CategoriaFiltros/eliminarCategoriaFiltro/{id}")
    public String eliminarCategoriaFiltro(
            @PathVariable("id") int id_categoriafiltro,
            Model model,
            RedirectAttributes redirectAttributes) {
        CategoriaFiltro categoriaFiltro = null;
        if (id_categoriafiltro > 0) {
            categoriaFiltro = categoriaFiltroService.buscarCategoriaFiltroPorID(id_categoriafiltro);
            if (categoriaFiltro == null) {
                redirectAttributes.addFlashAttribute("mensaje", "Error. ID incorrecto.");
                return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Error.");
                return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
            }
        }
        categoriaFiltroService.eliminarCategoriaFiltro(id_categoriafiltro);
        redirectAttributes.addFlashAttribute("advertencia", "Categoria eliminada.");
        return "redirect:/vistas/CategoriaFiltros/ListasCategoriaFiltro";
    }

    // -------------------------------------------------------------------------------------------------------
    // Actualizar
    @GetMapping(value = "/vistas/CategoriaFiltros/actualizarCategoriaFiltro/{id}")
    public String actualizarCategoriaFiltro(
            @PathVariable("id") int id_tipoVehiculo,
            Model model,
            RedirectAttributes redirectAttributes) {
        CategoriaFiltro categoriaFiltro = null;
        if (id_tipoVehiculo > 0) {
            categoriaFiltro = categoriaFiltroService.buscarCategoriaFiltroPorID(id_tipoVehiculo);

            if (categoriaFiltro == null) {
                redirectAttributes.addFlashAttribute("mensaje", "Error. ID incorrecto.");
                return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "Error.");
                return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
            }
        }
        model.addAttribute("tipovehiculo", categoriaFiltro);
        return "redirect:/vistas/CategoriaFiltros/ListarCategoriaFiltro";
    }
}
