package ar.edu.utn.dds.k3003;
package ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;


import java.util.List;

public class FachadaDonadores implements FachadaDonadoresYEntidades {

  private NecesidadMaterialRepository necesidadMaterialRepository;
  private QuejaRepository quejaRepository;
  
  private EntidadBeneficaRepository entidadRepository;
  private DonadorRepository donadorRepository;

  
  private NecesidadMaterialDataMapper necesidadMaterialDataMapper;
  private QuejaDataMapper quejaDataMapper;

  private FachadaIncentivos fachadaIncentivos;
  
  
  public FachadaDonadoresYEntidades(){
       super();
       necesidadMaterialRepository = new InMemoryNecesidadMaterialRepo();
       necesidadMaterialDataMapper = new NecesidadMaterialDataMapper();
       quejaRepository = new InMemoryQuejaRepo();
       quejaDataMapper = new QuejaDataMapper();
       donadorRepository = new InMemoryDonadorRepo();
  }
  
  @Override
  public NecesidadMaterialDTO registrarNecesidad(NecesidadMaterialDTO necesidadMaterialDTO){
     
    
    val necesidad = this.necesidadDataMapper.toNecesidad(necesidadMaterialDTO);
    val necesidadGuardada = this.necesidadRepository.save(necesidad);
    return this.necesidadDataMapper.toNecesidadDTO(necesidadGuardada);

    
  }

  @Override
  QuejaDTO agregarQueja(QuejaDTO quejaDTO) throws NoSuchElementException{

    val queja = this.quejasDataMapper.toQueja(quejaDTO);
    val quejaGuardada = this.quejasRepository.save(queja);
    
    return this.quejasDataMapper.toQuejaDTO(quejaGuardada);
    
  }

  @Override
  Boolean puedeDonar(String donadorID) throws NoSuchElementException{
     
    
  }

  @Override
  List<QuejaDTO> obtenerQuejasDe(String donadorID) throws NoSuchElementException{
    
   val quejasDeDonador = quejasRepository.findAll().stream().filter(q -> q.getDonadorId().equals(donadorID)).collect(Collectors.toList());
   List<QuejaDTO> quejasDeDonadorDTO = new ArrayList();
    for(val queja : quejasDeDonador)
     {
         quejasDeDonadorDTO.add(quejasDataMapper.toQuejaDTO(queja));
     }
    
   return quejasDeDonadorDTO;
    
  }

  @Override
  DonadorDTO modificarEstado(String donadorID, EstadoDonadorEnum estado)
      throws NoSuchElementException{

          DonadorDTO donadorDTO = buscarDonadorPorId(donadorID);
          if(obtenerQuejasDe(donadorID).size >= 5 && estado == EstadoDonadorEnum.VERIFICADO)
          donador.setEstado(EstadoDonadorEnum.SOSPECHOSO);
          if(obtenerQuejasDe(donadorID).size >= 10 && estado == EstadoDonadorEnum.SOSPECHOSO)
          donador.setEstado(EstadoDonadorEnum.BANEADO);
        
          return donadorDTO;
        
    }

    @Override
    DonadorDTO modifcarCategoria(String donadorID,String categoria) throws NoSuchElementException
    {
        DonadorDTO donadorDTO = buscarDonadorPorID(donadorID);
        if(categoria == "VERIFICADO" )
           
           val donaciones = 
           
           for(val donacion : donaciones) 
           {
           ProductoDTO productoDTO = this.fachadaDonacion.buscarProductoPorID(donacion.getProductoID());
           
           }
           
           List<CategoriaDTO> categoriasFiltradasDTO = eliminarDuplicados(categoriasRepetidasDTO);
           if(categoriasFiltradasDTO.size >= 3){
                 donadorDTO.setCategoria("COLABORADOR");
           }
      
      return donadorDTO;
    
    }
  
   @Override
   List<NecesidadMaterialDTO> obtenerNecesidadesInsatisfechasDe(String productoSolicitadoID)
    {
        
        val necesidades = necesidadRepository.findAll().stream().filter(n -> n.getProductoSolicitadoID().equals(productoSolicitadoID)).collect(Collectors.toList());
        List<NecesidadMaterialDTO> necesidadesDTO = new ArrayList<>();
        for(val necesidad : necesidades)
           {
               if(necesidad.getCantidadObjetivo() >= 0)
               necesidadesDTO.add(necesidadDataMapper.toNecesidadDTO(necesidad));
           }
      
        return necesidadesDTO;
      
    }


    @Override
    NecesidadMaterialDTO satisfacerNecesidad(String necesidadID, Integer cantidad)
      throws NoSuchElementException{
        
          val necesidad = this.necesidadRepository.findById(necesidadID);
          int cantAnt = necesidad.getCantidadObjetivo();
          if(cantidad <= cantAnt && cantidad >= 0)
          {
             necesidad.setCantidadObjetivo(cantAnt-cantidad);
          }
        
          return this.necesidadDataMapper.toNecesidadDTO(necesidad);
      }
  
  @Override
  DonadorStatsDTO estadisticasDonador(String donadorID){
        
       DonadorDTO donadorDTO = buscarDonadorPorID(donadorID);
       DonadorStatsDTO donadorStatsDTO = new donadorStatsDTO();
       donadorStatsDTO.setEstado(donadorDTO.getEstado());
       donadorStatsDTO.setCategoria(donadorDTO.getCategoria());
       
       List<InsigniaDTO> insigniasDTO = this.fachadaIncentivos.getInsigniasDeDonador(donadorID);
       List<String> insigniasID = insigniasDTO.stream().map(Insignia::getID).collect(Collectors.toList());
       MisionDTO misionDTO = this.fachadaIncentivos.getMisionEnCursoDeDonador(donadorID);

       donadorStatsDTO.setInsigniasID(insigniasID);
       donadorStatsDTO.setMisionActualID(misionDTO.getID());

       return donadorStatsDTO;
  }

  @Override
  void setFachadaIncentivos(FachadaIncentivos fachadaIncentivos){

       this.fachadaIncentivos = fachadaIncentivos;
  }

}
