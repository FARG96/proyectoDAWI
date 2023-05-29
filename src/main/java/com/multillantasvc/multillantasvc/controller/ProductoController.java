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

import com.multillantasvc.multillantasvc.model.Categoria;
import com.multillantasvc.multillantasvc.model.Producto;
import com.multillantasvc.multillantasvc.service.ICategoriaService;
import com.multillantasvc.multillantasvc.service.IProductoService;

import jakarta.validation.Valid;



@Controller
public class ProductoController {
	
	@Autowired
	IProductoService iProductoService;
	
	@Autowired
	ICategoriaService iCategoriaService;
	
	// READ Productos
	@GetMapping(value = "/views/Productos/Productos")
	public String Productos(Model model) {
		List<Producto> productos = iProductoService.obtenerProductos();
		List<Categoria> categorias = iCategoriaService.obtenerCategorias();
		
		model.addAttribute("producto", productos);
		model.addAttribute("categoria", categorias);
		return "/views/Productos/Productos";
	}
	
	// CREATE Productos - GET
	@GetMapping(value = "/Views/Productos/Registrar")
	public String registrarProductos(Model model) {
		Producto productos = new Producto();
		List<Categoria> categorias = iCategoriaService.obtenerCategorias();
			
		model.addAttribute("producto", productos);
		model.addAttribute("categoria", categorias);
		return "/Views/Productos/Registrar";
	}
	
	// CREATE Productos - POST
	@PostMapping(value = "/Views/Productos/Registrar")
	public String registrarProductos(@Valid @ModelAttribute Producto productos,
								BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes
								) {
		List<Categoria> categorias = iCategoriaService.obtenerCategorias();
		if(result.hasErrors()) {
			model.addAttribute("producto", productos);
			model.addAttribute("categoria", categorias);
			return "/Views/Productos/Registrar";
		}
		
		iProductoService.guardarProducto(productos);
		redirectAttributes.addFlashAttribute("mensaje", "Producto registrado exitosamente.");
		
		return "redirect:/views/Productos/Productos";
	}
	
	// UPDATE Productos
	@GetMapping("/View/Productos/Editar/{cod_producto}")
	public String actualizarProductos(@PathVariable("cod_producto") int cod_producto, Model model, RedirectAttributes attribute) {

		Producto productos = null;
		if (cod_producto > 0) {
			productos = iProductoService.buscarProductoPorId(cod_producto);

			// validacion a nivel de la URL
			if (productos == null) {

				attribute.addFlashAttribute("error", "Error. El ID no existe.");
				return "redirect:/views/Productos/Productos";
				} 
			
			} else {
				attribute.addFlashAttribute("error", "Error.");
				return "redirect:/views/Productos/Productos";
			}
		
		List<Categoria> categorias = iCategoriaService.obtenerCategorias();
		model.addAttribute("producto", productos);
		model.addAttribute("categoria", categorias);
		return "/Views/Productos/Registrar";
	}

}
