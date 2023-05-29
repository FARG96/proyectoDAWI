package com.multillantasvc.multillantasvc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.multillantasvc.multillantasvc.model.CategoriaLubricante;
import com.multillantasvc.multillantasvc.service.ICategoriaLubricanteService;

@Controller
@RequestMapping(value = "/vistas/CategoriaLubricantes")
public class CategoriaLubricanteController {

	
	@Autowired
	private ICategoriaLubricanteService categoriaservice;
	
	// PARA LISTAR
		@GetMapping(value = "/")
		public String listarLubricante(Model model) {
			List<CategoriaLubricante> listaCategoria = categoriaservice.listarcategoria();
			CategoriaLubricante categorialubricante = new CategoriaLubricante();
			
			model.addAttribute("titulo", "LISTADO >>> CATEGORIA DE LUBRICANTES");
			model.addAttribute("categoria", listaCategoria);
			model.addAttribute("categoriaLubri", categorialubricante);
			return "/vistas/CategoriaLubricantes/ListadoCategoria";
		}
		@GetMapping(value = "/CrearCategoria")
		public String CrearCategoria(Model model) {
			
			List<CategoriaLubricante> listaCategoria = categoriaservice.listarcategoria();
			CategoriaLubricante catlubricante = new CategoriaLubricante();
			model.addAttribute("titulo", "FORMULARIO: REGISTRO DE LUBRICANTES");
			model.addAttribute("categorias", listaCategoria);
			model.addAttribute("categoriaLubri", catlubricante);
			
			return "/vistas/CategoriaLubricantes/CrearCat";
		}
		@PostMapping(value="/save")
		public String guardar(@ModelAttribute CategoriaLubricante categoriaLubricante, BindingResult result,Model model,RedirectAttributes attribute) {
				
			
			List<CategoriaLubricante> listaCategoria = categoriaservice.listarcategoria();
		
				model.addAttribute("titulo", "FORMULARIO NUEVO CLIENTE");
			model.addAttribute("categoriaLubri", categoriaLubricante);
				model.addAttribute("categoria", listaCategoria);
				System.out.println("EXISTIERON ERRORES EN EL FORMULARIO ");
				categoriaservice.guardar(categoriaLubricante);
				return "redirect:/vistas/CategoriaLubricantes/";
		}

}
