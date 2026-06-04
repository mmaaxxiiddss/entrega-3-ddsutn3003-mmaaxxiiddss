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
    quejaDTO.setDonadorID(donadorDTO.ID());
    return quejaDTO;
    
  }

  Boolean puedeDonar(String donadorID) throws NoSuchElementException{
     
    
  }

  List<QuejaDTO> obtenerQuejasDe(String donadorID) throws NoSuchElementException{
    
   List<Queja> quejasDeDonador = quejasRepository.obtenerQuejasDe(donadorID);
   List<QuejaDTO> quejasDeDonadorDTO = new ArrayList();
    for(val queja : quejasDeDonador)
     {
         quejasDeDonadorDTO.add(quejasDataMapper.toQuejaDTO(queja));
     }
    
   return quejasDeDonadorDTO;
    
  }
  
}
