package cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.services.SucursalServiceImpl;

@Controller
@RequestMapping("/sucursales")
public class WebSucursalController {
	
	@Autowired
	SucursalServiceImpl sucursalServiceImpl;

	@GetMapping({"", "/"})
	public String listAllSucursales(Model modelo) {
		modelo.addAttribute("sucursales", sucursalServiceImpl.findAll());
		return "sucursales"; 
	}
	
	@GetMapping("/add")
	public String getSucursalForm(Model modelo) {
		modelo.addAttribute("sucursalDTO", new SucursalDTO());		
		return "crear_sucursal"; 
	}
	
	@PostMapping("/add")
	    public String addSucursal(@ModelAttribute SucursalDTO sucursalDTO) {

	            try {
	                sucursalServiceImpl.save(sucursalDTO);
	                return "redirect:/sucursales";

	            } catch (RuntimeException e) {
	                return "crear_sucursal";
	            }
	        
	    }
	
	@GetMapping("/search")
	public String getSucursal(@RequestParam String id, Model modelo) { // RequestParam por que el boton genera un enlace largo. String por que verifico si es null
	
		try {
			if (id!=null) {
				SucursalDTO sucursalDTO = sucursalServiceImpl.findById(Integer.parseInt(id));
		
				modelo.addAttribute("sucursales", sucursalDTO);
				return "sucursales";
			
		    } else {
		    	modelo.addAttribute("mensaje", "No se ha especificado ningun ID");
		    	return "sucursales";
		    }
		} catch (Exception e) {
	    	modelo.addAttribute("mensaje", "No se ha encontrado ninguna sucursal");
			return "sucursales";
		}
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateForm(@PathVariable int id, Model modelo) {
		SucursalDTO sucursalDTO = sucursalServiceImpl.findById(id);
		
		if (sucursalDTO != null) {
			modelo.addAttribute("sucursalDTO", sucursalDTO);
			return "editar_sucursal";
		} else {
			return "redirect:/error";
		}
		
	}
	
	@PostMapping("/update/{id}")
	public String updateSucursal(@PathVariable int id, @ModelAttribute("sucursalDTO") SucursalDTO sucursalDTO) {
		try {
			sucursalServiceImpl.update(id, sucursalDTO);
			return "redirect:/sucursales";
		} catch (Exception e) {
			e.printStackTrace();		
			return "redirect:/error";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSucursal(@PathVariable int id) {
		sucursalServiceImpl.delete(id);
		return "redirect:/sucursales";		
	}
	
	
}
