package ar.edu.utn.dds.k3003;

import java.util.List;

public class ImplFachadaLogistica{

  @Override
  void setAlgoritmoMM(String depositoID, TipoAlgoritmoEnum tipoAlgoritmo){

      DepositoDTO depositoDTO = buscarDepositoPorID(depositoID);
      
    
  }

  @Override
  AsignacionDTO ejecutarMatchmaking(
      String depositoID, PaqueteDTO paqueteDTO, List<NecesidadMaterialDTO> necesidades){
      
  }
  
  @Override
  void reportarEntrega(PaqueteDTO paqueteDTO){
       
  }
  
}
