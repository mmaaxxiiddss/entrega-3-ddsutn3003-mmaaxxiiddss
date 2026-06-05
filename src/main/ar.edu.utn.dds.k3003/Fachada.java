package ar.edu.utn.dds.k3003;
package ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;


import java.util.List;

public class Fachada implements FachadaDonadoresYEntidades {

  private NecesidadRepository necesidadRepository;
  private QuejaRepository quejasRepository;
  private ProdSoliRepository prodSoliRepository;
  private EntidadBeneficaRepository entidadRepository;

  private NecesidadDataMapper necesidadDataMapper;
  private QuejaDataMapper quejasDataMapper;
  
  
  public FachadaDonadoresYEntidades(){
       super();
       necesidadRepository = new InMemoryNecesidadRepo();
       necesidadDataMapper = new NecesidadDataMapper();
       quejasRepository = new InMemoryQuejaRepo();
       quejasDataMapper = new QuejaDataMapper();
  
  }
  
  @Override
  public NecesidadMaterialDTO registrarNecesidad(NecesidadMaterialDTO necesidadMaterialDTO){
     
    
    val necesidad = this.necesidadDataMapper.toNecesidad(necesidadMaterialDTO);
    val necesidadGuardada = this.necesidadRepository.save(necesidad);
    return this.necesidadDataMapper.toNecesidadDTO( necesidadGuardada);

    
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
    
   List<Queja> quejasDeDonador = quejasRepository.findAll().stream().filter(q -> q.getDonadorId().equals(donadorID)).collect(Collectors.toList());
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
    DonadorDTO modifcarCategoria(String donadorID,CategoriaDonadorEnum categoria) throws NoSuchElementException
    {
        DonadorDTO donadorDTO = buscarDonadorPorID(donadorID);
        if(categoria == CategoriaDonadorEnum.OCASIONAL )
           
           List<DonacionDTO> donacionesDTO = buscarDonaciones(donadorDTO);
           List<ProductoDTO> productosDTO = filtrarProductos(donacionesDTO);
           List<CategoriaDTO> categoriasRepetidasDTO = filtrarCategorias(productosDTO);
           List<CategoriaDTO> categoriasFiltradasDTO = eliminarDuplicados(categoriasRepetidasDTO);
           if(categoriasFiltradasDTO.size >= 3){
                 donadorDTO.setCategoria(CategoriaDonadorEnum.COLABORADOR);
           }
      
      return donadorDTO;
    
    }
  
   @Override
   List<NecesidadMaterialDTO> obtenerNecesidadesInsatisfechasDe(String productoSolicitadoID)
    {
        ProductoSolicitadoDTO productoDTO = buscarSolicitacionPorId(productoSolicitadoID);
        List<NecesidadMaterial> necesidades = necesidadRepository.findAll().stream().filter(n -> n.getProductoSolicitadoID().equals(productoSolicitadoID)).collect(Collectors.toList());
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
        
          NecesidadMaterial necesidad = this.necesidadRepository.findById(necesidadID);
          int cantAnt = necesidad.getCantidadObjetivo();
          if(cantidad <= cantAnt && cantidad >= 0)
          {
             necesidad.setCantidadObjetivo(cantAnt-cantidad);
          }
        
          return this.necesidadDataMapper.toNecesidadDTO( necesidad);
      }
  
  @Override
  DonadorStatsDTO estadisticasDonador(String donadorID){
        
       DonadorDTO donadorDTO = buscarDonadorPorID(donadorID);
       DonadorStatsDTO donadorStatsDTO = buscarDonadorStatsPorDonadorID(donadorID);
       donadorStatsDTO.setEstado(donadorDTO.getEstado());

       MisionDTO misionDTO = buscarMisionPorId(donadorStatsDTO.getMisionID());


  
  }

  @Override
  void setFachadaIncentivos(FachadaIncentivos fachadaIncentivos){

       this.fachadaIncentivos = fachadaIncentivos;
  }

}
