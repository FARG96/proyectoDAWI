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

import com.multillantasvc.multillantasvc.model.TipoVehiculo;
import com.multillantasvc.multillantasvc.service.ITipoVehiculoService;

import jakarta.validation.Valid;

@Controller
public class TipoVehiculoController {
	
	@Autowired
	ITipoVehiculoService tipoVehiculoService;
	
	// Listar tipos de vehículo
	@GetMapping(value = "/vistas/TiposVehiculo/ListarTiposVehiculo")
	public String listarTiposVehiculo(Model model)
	{
		List<TipoVehiculo> tipovehiculos = tipoVehiculoService.getAll();
		model.addAttribute("tipovehiculo", tipovehiculos);
		return "/vistas/TiposVehiculo/ListarTiposVehiculo";
	}
	
	
	// Registrar tipo de vehiculo - GET
	@GetMapping(value = "/vistas/TiposVehiculo/RegistrarTipoVehiculo")
	public String registrarTipoVehiculoGet(Model model)
	{
		TipoVehiculo tipovehiculo = new TipoVehiculo();
		model.addAttribute("tipovehiculo", tipovehiculo);
		return "/vistas/TiposVehiculo/RegistrarTipoVehiculo";
	}
	
	// Registrar tipo de vehiculo - POST
	@PostMapping(value = "/vistas/TiposVehiculo/RegistrarTipoVehiculo")
	public String registrarTipoVehiculoPost(@Valid @ModelAttribute TipoVehiculo tipovehiculo, BindingResult result, Model model, RedirectAttributes ra)
	{
		if (result.hasErrors())
		{
			model.addAttribute("tipovehiculo", tipovehiculo);
			return "/vistas/TiposVehiculo/RegistrarTipoVehiculo";
		}
		tipoVehiculoService.guardarTipoVehiculo(tipovehiculo);
		ra.addFlashAttribute("mensaje", "Tipo de vehículo registrado correctamente.");
		return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
	}
	
	
	// Eliminado físico tipo de vehículo
	@GetMapping(value = "/vistas/TiposVehiculo/eliminarTipoVehiculo/{id}")
	public String eliminarTipoVehiculo(@PathVariable("id") int id_tipovehiculo, Model model, RedirectAttributes ra)
	{
		TipoVehiculo tipovehiculo = null;
		if (id_tipovehiculo > 0)
		{
			tipovehiculo = tipoVehiculoService.buscarTipoVehiculoPorId(id_tipovehiculo);
			
			if (tipovehiculo == null)
			{
				ra.addFlashAttribute("mensaje", "Error. ID incorrecto.");
				return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
			}
		}
			else
			{
				ra.addFlashAttribute("mensaje", "Error.");
				return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
			}
		tipoVehiculoService.eliminarTipoVehiculo(id_tipovehiculo);
		ra.addFlashAttribute("advertencia", "Tipo de vehículo eliminado.");
		return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
	}
	
	
	// Actualizar información del tipo de vehículo
	@GetMapping(value = "/vistas/TiposVehiculo/actualizarTipoVehiculo/{id}")
	public String actualizarTipoVehiculo(@PathVariable("id") int id_tipoVehiculo, Model model, RedirectAttributes ra)
	{
		TipoVehiculo tipovehiculo = null;
		if (id_tipoVehiculo > 0)
		{
			tipovehiculo = tipoVehiculoService.buscarTipoVehiculoPorId(id_tipoVehiculo);
			
			if (tipovehiculo == null)
			{
				ra.addFlashAttribute("mensaje", "Error. ID incorrecto.");
				return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
			}
		}
			else
			{
				ra.addFlashAttribute("mensaje", "Error.");
				return "redirect:/vistas/TiposVehiculo/ListarTiposVehiculo";
			}
		model.addAttribute("tipovehiculo", tipovehiculo);
		return "/vistas/TiposVehiculo/RegistrarTipoVehiculo";
	}

}
