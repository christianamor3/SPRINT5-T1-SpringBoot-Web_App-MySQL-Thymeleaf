package cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.services.SucursalServiceImpl;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

	@Autowired
	SucursalServiceImpl sucursalServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO) {
		SucursalDTO sucursalDTO1 = sucursalServiceImpl.save(sucursalDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sucursalDTO1);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable int id, @RequestBody SucursalDTO sucursalDTO) {
		SucursalDTO sucursalDTO2 = sucursalServiceImpl.update(id, sucursalDTO);
		
		return ResponseEntity.ok(sucursalDTO2);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSucursal(@PathVariable int id){
		String mensaje = sucursalServiceImpl.delete(id);
		
		return ResponseEntity.ok(mensaje);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<SucursalDTO> getOneSucursal(@PathVariable int id){
		try {
			SucursalDTO sucursalDTO = sucursalServiceImpl.findById(id);
			return ResponseEntity.ok(sucursalDTO);
		} catch (EntityNotFoundException enfe) {
			enfe.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SucursalDTO>> getAll(){
		List<SucursalDTO> sucursales = sucursalServiceImpl.findAll();
		
		if (sucursales.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(sucursales);
		}
	}
	
	
}

