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

import com.multillantasvc.multillantasvc.model.Llanta;
import com.multillantasvc.multillantasvc.model.TipoVehiculo;
import com.multillantasvc.multillantasvc.service.ILlantaService;
import com.multillantasvc.multillantasvc.service.ITipoVehiculoService;

import jakarta.validation.Valid;

@Controller
public class LlantaController {
	
	@Autowired
	ITipoVehiculoService tipoVehiculoService;
	
	@Autowired
	ILlantaService llantaService;

	
	// Listar Llantas
	@GetMapping(value = "/vistas/Llantas/ListarLlantas")
	public String llanta(Model model) {
		List<Llanta> llantas = llantaService.getAll();
		List<TipoVehiculo> tipovehiculos = tipoVehiculoService.getAll();
		model.addAttribute("llanta", llantas);
		model.addAttribute("tipovehiculo", tipovehiculos);
		return "/vistas/Llantas/ListarLlantas";
	}
	
	// Registrar llanta - GET
	@GetMapping(value = "/vistas/Llantas/RegistrarLlanta")
	public String registrarLlanta(Model model) {
		Llanta llantas = new Llanta();
		List<TipoVehiculo> tipovehiculos = tipoVehiculoService.getAll();
		
		model.addAttribute("llanta", llantas);
		model.addAttribute("tipovehiculo", tipovehiculos);
		return "/vistas/Llantas/RegistrarLlanta";
	}
	
	// Registar llanta - POST
	@PostMapping(value = "/vistas/Llantas/RegistrarLlanta")
	public String saveLlanta(@Valid @ModelAttribute Llanta llanta,
								BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes
								) {
		List<TipoVehiculo> tipovehiculos = tipoVehiculoService.getAll();
		if(result.hasErrors()) {
			model.addAttribute("llantas", llanta);
			model.addAttribute("tipovehiculo", tipovehiculos);
			return "/vistas/Llantas/RegistrarLlanta";
		}
		
		llantaService.save(llanta);
		redirectAttributes.addFlashAttribute("mensaje", "Llanta registrada exitosamente.");
		
		return "redirect:/vistas/Llantas/ListarLlantas";
	}
	
	// Eliminar llanta
	@GetMapping("/vistas/Llantas/eliminarLlanta/{id}")
	public String eliminarLlanta(@PathVariable("id") int id_llanta, Model model, RedirectAttributes attribute) {
		
		Llanta llanta = null;
		if (id_llanta > 0)
		{
			llanta = llantaService.buscarLlantaPorId(id_llanta);
					
			// validacion a nivel de la URL
				if (llanta == null) {

				attribute.addFlashAttribute("error", "El ID no existe.");
				return "redirect:/vistas/Llantas/ListarLlantas";
				}
		} else 
			{
				attribute.addFlashAttribute("error", "Error.");
				return "redirect:/vistas/Llantas/ListarLlantas";
			}	
				
		llantaService.elminarLlanta(id_llanta);
		attribute.addFlashAttribute("warning","Llanta eliminada.");
		return "redirect:/vistas/Llantas/ListarLlantas";
	}
	
	
	@GetMapping("/vistas/Llantas/editarLlanta/{id}")
	public String editarLlanta(@PathVariable("id") int id_llanta, Model model, RedirectAttributes attribute) {

		Llanta llanta = null;
		if (id_llanta > 0) {
			llanta = llantaService.buscarLlantaPorId(id_llanta);

			// validacion a nivel de la URL
			if (llanta == null) {

				attribute.addFlashAttribute("error", "Error. El ID no existe.");
				return "redirect:/vistas/Llantas/ListarLlantas";
				} 
			
			} else {
				attribute.addFlashAttribute("error", "Error.");
				return "redirect:/vistas/Llantas/ListarLlantas";
			}
		
		List<TipoVehiculo> tipovehiculos = tipoVehiculoService.getAll();
		model.addAttribute("llanta", llanta);
		model.addAttribute("tipovehiculo", tipovehiculos);
		return "/vistas/Llantas/RegistrarLlanta";
	}
	
}
