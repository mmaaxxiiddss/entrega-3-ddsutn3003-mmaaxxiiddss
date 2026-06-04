package ar.edu.utn.dds.k3003;

import java.util.List;

public class Fachada{


  NecesidadMaterialDTO registrarNecesidad(NecesidadMaterialDTO necesidadMaterialDTO){
     
    EntidadBeneficaDTO entidadDTO = buscarEntidadPorID(entidadID);
    entidadDTO.getNecesidades().add(necesidadMaterialDTO);
    return necesidadMaterialDTO;
    
  }

  QuejaDTO agregarQueja(QuejaDTO quejaDTO) throws NoSuchElementException{

    DonadorDTO donadorDTO = buscarDonadorPorID(donadorID);
    
  }
  
}
