package ar.edu.utn.dds.k3003.catedra.fachadas;


import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.*;
import java.util.List;
import java.util.NoSuchElementException;


public interface FachadaDonadoresYEntidades {

  DonadorDTO agregarDonador(DonadorDTO donadorDTO);

  DonadorDTO buscarDonadorPorId(String donador_Id) throws NoSuchElementException;
  
  EntidadBeneficaDTO agregarEntidad(EntidadBeneficaDTO entidadBeneficaDTO);

  DonadorDTO agregarQuejaEnDonador(DonadorDTO donadorDTO,QuejaDTO quejaDTO);
  
  EntidadBeneficaDTO buscarEntidadPorID(String entidad_ID) throws NoSuchElementException;

  Boolean puedeDonar(DonadorDTO donadorDTO, EntidadBeneficaDTO entidadBeneficaDTO,DonacionDTO donacionDTO) throws NoSuchElementException;

  DonadorDTO modificarEstado(String donador_ID, EstadoDonadorEnum estado)
      throws NoSuchElementException;

  DonadorDTO modificarCategoria(String donador_ID, String categoria) throws NoSuchElementException;

  DonadorStatsDTO estadisticasDonador(String donador_ID);

  List<QuejaDTO> obtenerQuejasDeDonador(String donador_Id);
    
  void setFachadaIncentivos(FachadaIncentivos fachadaIncentivos);
    
}
