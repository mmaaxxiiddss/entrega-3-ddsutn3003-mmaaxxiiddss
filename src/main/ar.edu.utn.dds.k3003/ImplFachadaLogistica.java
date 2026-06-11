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
  AsignacionDTO buscarAsignacionPorPaqueteID(String paqueteID) throws NoSuchElementException
  {
       val asignacion = this.asignacionRepo.findAll().stream().filter(a -> a.getPaqueteID().equals( paqueteID)).findFirst(); 
       return this.asignacionDataMapper.toAsignacionDTO(asignacion);
  }
    
  @Override
  DepositoDTO gestionarDonacion(
      String depositoID, String donacionID, String productoID, Integer cantidad)
      throws NoSuchElementException
  {
      
    
  }

  @Override
  void setAlgoritmoMM(String depositoID, TipoAlgoritmoEnum tipoAlgoritmo){

      DepositoDTO depositoDTO = buscarDepositoPorID(depositoID);
 val deposito = = this.depositoDataMapper.toDeposito(depositoDTO);
      deposito.setAlgoritmo(tipoAlgoritmo);
      val depositoGuardado = this.depositoRepo.save(deposito);
    
  }

  @Override
  AsignacionDTO ejecutarMatchmaking(
      String depositoID, PaqueteDTO paqueteDTO, List<NecesidadMaterialDTO> necesidades){

      
      AsignacionDTO asignacionDTO = buscarAsignacionPorID(paqueteDTO.ID());
      DepositoDTO depositoDTO = buscarDepositoPorID(paqueteDTO.getDepositoID());
  val deposito = this.depositoDataMapper.toDeposito(depositoDTO);
  val asignacion = this.asignacionDataMapper.toAsignacion(asignacionDTO);
      int cantidadDonada = 0;
      List<Necesidad_Resto> restoCantidad = new ArrayList<>();
      for(val paquete : deposito.getStockActual())
      {
          cantidadDonada = cantidadDonada + paquete.getCantidad();
      }
    
      for(val necesidad : necesidades)
      {
          if(necesidad.getCantidadObjetivo())
          {
             restoCantidad.add(cantidadDonada-necesidad.getCantidadObjetivo());
             
          }
      }
    
      
      int menorResto = 0;
      menorResto = Collections.min(restoCantidad);
      Necesidad_Resto ne_R = restoCantidad.stream().filter(rc -> rc.getResto().equals(menorResto)).findFirst();
      asignacion.setNecesidadID(ne_R.getNecesidadID());
      val asignacionGuardada = this.asignacionRepository.save(asignacion);
      
      return this.asignacionDataMapper.toAsignacionDTO(asignacionGuardada);
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
          depositoNuevoDTO.getStockActual().add(PaqueteDTO);
          this.depositoRepository.save(this.depositoDataMapper.toDeposito(depositoNuevoDTO));
          AsignacionDTO asignacionDTO = buscarAsignacionPorPaqueteID(paqueteDTO.getID());
          NecesidadMaterialDTO necesidadMaterialDTO = this.fachadaDonadores.satisfacerNecesidad(asignacionDTO.getNecesidadID(),paqueteDTO.getCantidad());
          val necesidad = this.fachadaDonadores.getNecesidadDataMapper().toNecesidad(necesidadMaterialDTO);
          val necesidadGuardada = this.fachadaDonadores.getNecesidadMaterialRepository().save(necesidad);
          
      }else{
      
      depositoDTO.getStockActual().add(PaqueteDTO);
      this.depositoRepository.save(this.depositoDataMapper.toDeposito(depositoDTO));
      AsignacionDTO asignacionDTO = buscarAsignacionPorPaqueteID(paqueteDTO.getID());
      NecesidadMaterialDTO necesidadMaterialDTO = this.fachadaDonadores.satisfacerNecesidad(asignacionDTO.getNecesidadID(),paqueteDTO.getCantidad());
      val necesidad = this.fachadaDonadores.getNecesidadDataMapper().toNecesidad(necesidadMaterialDTO);
      val necesidadGuardada = this.fachadaDonadores.getNecesidadMaterialRepository().save(necesidad);
      
      }
    
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
