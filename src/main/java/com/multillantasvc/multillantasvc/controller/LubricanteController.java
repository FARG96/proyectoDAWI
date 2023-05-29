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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multillantasvc.multillantasvc.model.CategoriaLubricante;
import com.multillantasvc.multillantasvc.model.Lubricante;
import com.multillantasvc.multillantasvc.service.ICategoriaLubricanteService;
import com.multillantasvc.multillantasvc.service.ILubricantesService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/vistas/lubricantes")
public class LubricanteController {

	// services
	@Autowired
	private ILubricantesService lubricanteservice;
	@Autowired
	private ICategoriaLubricanteService categoriaservice;

	// PARA LISTAR
	@GetMapping(value = "/")
	public String listarLubricante(Model model) {
		List<Lubricante> listadoLubricante = lubricanteservice.listartodos();

		model.addAttribute("titulo", "LISTADO DE LUBRICANTES");
		model.addAttribute("lubricantes", listadoLubricante);
		return "/vistas/lubricantes/ListarLubricante";
	}

	// para mostrar la vista crear
	@GetMapping(value = "/CrearLubricante")
	public String crearLubri(Model model) {
		
		List<CategoriaLubricante> listaCategoria = categoriaservice.listarcategoria();
		Lubricante lubricante = new Lubricante();
		model.addAttribute("titulo", "FORMULARIO: REGISTRO DE LUBRICANTES");
		model.addAttribute("categorias", listaCategoria);
		model.addAttribute("lubricante", lubricante);
		
		return "vistas/lubricantes/CrearLubricante";
	}

	// para el boton guardar
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Lubricante lubricante, BindingResult result, Model model,
			RedirectAttributes attribute) {

		List<CategoriaLubricante> listaCategoria = categoriaservice.listarcategoria();
		if (result.hasErrors()) {
			model.addAttribute("titulo", "FORMULARIO NUEVO CLIENTE");
			model.addAttribute("lubricante", lubricante);
			model.addAttribute("categorias", listaCategoria);
			System.out.println("EXISTIERON ERRORES EN EL FORMULARIO ");
			return "/vistas/lubricantes/CrearLubricante";
		}
		lubricanteservice.guardar(lubricante);
		attribute.addFlashAttribute("succes", "LUBRICANTE REGISTRADO CON EXITO !!");
		return "redirect:/vistas/lubricantes/";
	}

	// editar
	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable("id") int idLubricante, Model model, RedirectAttributes attribute) {

		Lubricante lubricante = null;
		if (idLubricante > 0) {
			lubricante = lubricanteservice.BuscarporId(idLubricante);

			// validacion a nivel de la URL
			if (lubricante == null) {

				attribute.addFlashAttribute("error", "ATENCION : EL ID DEL LUBRICANTE NO EXISTE !!");
				return "redirect:/vistas/lubricantes/";
				} 
			
			} else {
				attribute.addFlashAttribute("error", "ATENCION : ERROR CON EL CLIENTE");
				return "redirect:/vistas/lubricantes/";
			}

		
		
		List<CategoriaLubricante> listacategoria = categoriaservice.listarcategoria();
		model.addAttribute("titulo", "EDITAR CLIENTE");
		model.addAttribute("lubricante", lubricante);
		model.addAttribute("categorias", listacategoria);
		return "vistas/lubricantes/CrearLubricante";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String Eliminar(@PathVariable("id") int idLubricante, Model model, RedirectAttributes attribute) {
		
		Lubricante lubricante = null;
		if (idLubricante > 0) {
			lubricante = lubricanteservice.BuscarporId(idLubricante);

			// validacion a nivel de la URL
				if (lubricante == null) {

				attribute.addFlashAttribute("error", "ATENCION : EL ID DEL LUBRICANTE NO EXITE !!");
				return "redirect:/vistas/lubricantes/";
				}
			} else {
				attribute.addFlashAttribute("error", "ATENCION : ERROR CON EL CLIENTE");
				return "redirect:/vistas/lubricantes/";
			}
			
				
		lubricanteservice.eliminar(idLubricante);
		attribute.addFlashAttribute("warning","ATENCION: Registro eliminado con exito !!!");
		return "redirect:/vistas/lubricantes/";
	}
	
	

}
