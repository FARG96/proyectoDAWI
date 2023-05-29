package com.multillantasvc.multillantasvc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multillantasvc.multillantasvc.model.Bateria;
import com.multillantasvc.multillantasvc.model.TipoVehiculo;
import com.multillantasvc.multillantasvc.repository.IBateriaRepository;
import com.multillantasvc.multillantasvc.repository.ITipoVehiculoRepository;

@Controller
@RequestMapping(value = "/vistas/Bateria")
public class BateriaController {

	//repositorio 
	@Autowired
	private ITipoVehiculoRepository tipovehiculorepo;
	@Autowired 
	private IBateriaRepository bateriarepo;
	//Listado
	@GetMapping(value="/")
	public String listarbaterias(@RequestParam Map<String, Object> params,Model model) {
		
		
		//paginacion 
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		PageRequest pageRequest  = PageRequest.of(page, 6);
		Page<Bateria> pageBateria = bateriarepo.findAll(pageRequest);
		int totalpaginas = pageBateria.getTotalPages();
		if(totalpaginas > 0 ) {
			List<Integer> pages = IntStream.rangeClosed(1, totalpaginas).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		
		//List<Bateria> listarbaterias = bateriarepo.findAll();
		
		model.addAttribute("titulo", "LSITADO DE BATERIAS");
		//model.addAttribute("baterias", listarbaterias);
		model.addAttribute("baterias",pageBateria.getContent());
		
		return "/vistas/Bateria/ListarBateria";
	}
	//editar vista
	@GetMapping(value = "/CrearBateria")
	public String crearLubri(Model model) {
		
		List<TipoVehiculo> listatipovehiculo = tipovehiculorepo.findAll();
		Bateria bateria = new Bateria();
		model.addAttribute("titulo", "FORMULARIO: REGISTRO DE LUBRICANTES");
		model.addAttribute("categorias", listatipovehiculo);
		model.addAttribute("lubricante", bateria);
		
		return "vistas/lubricantes/CrearLubricante";
	}
	//
}
