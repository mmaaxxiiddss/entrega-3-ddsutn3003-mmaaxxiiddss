package ar.edu.utn.dds.k3003;


import java.util.List;


public class ImplFachadaLogistica{

  private AsignacionRepository asignacionRepo;
  private AsignacionDataMapper asignacionDataMapper;
  private DepositoRepository depositoRepo;
  private DepositoDataMapper depositoDataMapper;

  private FachadaDonacion fachadaDonacion;
  private FachadaDonadoresYEntidades fachadaDonadores;
  
  
  public class ImplFachadaLogistica(){
       super();
       this.depositoRepo = new InMemoryDepositoRepo();
       this.asignacionRepo = new InMemoryAsignacionRepo();
 
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
      DepositoDTO depositoDTO = buscarDepositoPorID(paqueteDTO.getDepositoID());
      if(depositoDTO.getCantidadMaxima() == depositoDTO.getStockActual().size())
      {
          depositoNuevoDTO = new DepositoDTO();
          depositoNuevoDTO.setID(depositoDTO.getID()+1);
          depositoNuevoDTO.setAlgoritmo(depositoDTO.getAlgoritmo());
          depositoNuevoDTO.setNombre(depositoDTO.getNombre());
          depositoNuevoDTO.setDireccion(depositoDTO.getDireccion());
          depositoNuevoDTO.setCapacidadMaxima(depositoDTO.getCapacidadMaxima());
          depositoNuevoDTO.setStockActual(new ArrayList<>());
      }
    
      this.depositoRepository.save(this.depositoDataMapper.toDeposito(depositoDTO));
      
    
  }

  @Override
  void setFachadaDonadoresYEntidades(FachadaDonadoresYEntidades fachadaDonadoresYEntidades){

      this.fachadaDonadores = fachadaDonadoresYEntidades;

      
  }
  
  @Override
  void setFachadaDonaciones(FachadaDonaciones fachadaDonaciones){
      
      this.fachadafachadaDonacion = fachadaDonaciones;

    
  }
  
  
}
