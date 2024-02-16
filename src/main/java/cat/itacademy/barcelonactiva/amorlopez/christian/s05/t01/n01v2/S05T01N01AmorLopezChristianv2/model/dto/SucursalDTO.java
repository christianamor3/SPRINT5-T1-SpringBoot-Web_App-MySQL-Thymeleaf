package cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.dto;

import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.amorlopez.christian.s05.t01.n01v2.S05T01N01AmorLopezChristianv2.model.domain.Sucursal;

public class SucursalDTO {

	private int pk_SucursalID;
	
	private String nomSucursal;
	
	private String paisSucursal;
	
	private String tipusSucursal;
	
	
	public SucursalDTO() {}
	
	public SucursalDTO(int pk_SucursalID, String nomSucursal, String paisSucursal, String tipusSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = tipusSucursal;
	}

	private static final List<String> paisos = Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia", "República de Xipre", "República Txeca", "Dinamarca", "Estònia", "Finlàndia", "França", "Alemanya", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia", "Lituània", "Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal", "Romania", "Eslovàquia", "Eslovènia", "Espanya", "Suècia");

	public int getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}
	
	public static SucursalDTO fromEntity(Sucursal sucursal) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		
		sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
		
		if (paisos.contains(sucursal.getPaisSucursal())){
			sucursalDTO.setTipusSucursal("UE");
		} else {
			sucursalDTO.setTipusSucursal("Fora UE");
		}
		
		return sucursalDTO;
	}
	
	public static Sucursal toEntity(SucursalDTO sucursalDTO) {
		Sucursal sucursal = new Sucursal();
		
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		
		return sucursal;
	}
	
	
}
