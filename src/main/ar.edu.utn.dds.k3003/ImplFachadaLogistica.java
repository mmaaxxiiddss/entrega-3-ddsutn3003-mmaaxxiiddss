package ar.edu.utn.dds.k3003;


import java.util.List;


public class ImplFachadaLogistica{

  private AsignacionRepository asignacionRepo;
  private AsignacionDataMapper asignacionDataMapper;
  private DepositoRepository depositoRepo;
  private DepositoDataMapper depositoDataMapper;

  public class ImplFachadaLogistica(){
       super();
       this.depositoRepo = new InMemoryDepositoRepo();
  }
  
  @Override
  void setAlgoritmoMM(String depositoID, TipoAlgoritmoEnum tipoAlgoritmo){

      DepositoDTO depositoDTO = buscarDepositoPorID(depositoID);
      depositoDTO.setAlgoritmo(tipoAlgoritmo);
      
  }

  @Override
  AsignacionDTO ejecutarMatchmaking(
      String depositoID, PaqueteDTO paqueteDTO, List<NecesidadMaterialDTO> necesidades){

      
  }
  
  @Override
  void reportarEntrega(PaqueteDTO paqueteDTO){
      
        
  }

  @Override
  void setFachadaDonadoresYEntidades(FachadaDonadoresYEntidades fachadaDonadoresYEntidades){


      
  }
  
  @Override
  void setFachadaDonaciones(FachadaDonaciones fachadaDonaciones){

      
  }
  
  
}
