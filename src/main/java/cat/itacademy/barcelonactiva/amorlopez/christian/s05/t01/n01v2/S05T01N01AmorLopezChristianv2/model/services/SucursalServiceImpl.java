package cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	SucursalRepository sucursalRepository;


	@Override
	public SucursalDTO save(SucursalDTO sucursalDTO) {
				
		return SucursalDTO.fromEntity(sucursalRepository.save(SucursalDTO.toEntity(sucursalDTO)));
		
		// Pasamos la entidad que nosotros pasamos a la consulta, a DTO.
	}
	
	@Override
	public SucursalDTO update(int id, SucursalDTO sucursalDTO) {
		Optional <Sucursal> sucursal2 = sucursalRepository.findById(id);
		
		if (sucursal2.isPresent()) {
			sucursal2.get().setNomSucursal(sucursalDTO.getNomSucursal());
			sucursal2.get().setPaisSucursal(sucursalDTO.getPaisSucursal());
			sucursalRepository.save(sucursal2.get());
			
			return SucursalDTO.fromEntity(sucursal2.get());
		} else {
			return null;
		}
		
	}


	@Override
	public String delete(int id) {
		sucursalRepository.deleteById(id);
		return "Se ha eliminado el objeto correctamente";
	}

	@Override
	public SucursalDTO findById(int id) {
		Optional<Sucursal> sucursalOp = sucursalRepository.findById(id);
		if (sucursalOp.isEmpty()) {
			throw new EntityNotFoundException("No se ha encontrado la sucursal de ID " + id);
		} 
		return SucursalDTO.fromEntity(sucursalOp.get());
	
    }

	@Override
	public List<SucursalDTO> findAll() {
		return sucursalRepository.findAll().stream().map(SucursalDTO::fromEntity).collect(Collectors.toList());
	}

}
