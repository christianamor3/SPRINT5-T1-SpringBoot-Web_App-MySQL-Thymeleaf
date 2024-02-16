package cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.services;
import java.util.List;

import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.dto.SucursalDTO;

public interface SucursalService {
	
	SucursalDTO save (SucursalDTO sucursalDTO);
	
	SucursalDTO update (int id, SucursalDTO sucursalDTO);

	String delete (int id);
	
	SucursalDTO findById (int id);
	
	List<SucursalDTO> findAll ();
}

