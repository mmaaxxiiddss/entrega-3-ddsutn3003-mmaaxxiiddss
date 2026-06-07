package ar.edu.utn.dds.k3003;


import java.util.List;


public class ImplFachadaIncentivos{
      
      private MisionRepository misionRepo;
      private MisionDataMapper misionDataMapper;
      private InsigniaRepository insigniaRepo;
      private InsigniaDataMapper insigniaDataMapper;
      
      
      private FachadaDonacion fachadaDonacion;
      private FachadaDonador fachadaDonador;
      private FachadaLogistica fachadaLogistica;
      
      public ImplFachadaIncentivos()
      {
           super();
           this.misionRepo = new InMemoryMisionRepo();
           this.misionDataMapper = new MisionDataMapper();
           this.fachadaLogistica = new FachadaLogistica();
           
      }

      
      @Override
      void asignarMisionADonador(String donadorID, MisionDTO misionDTO) throws NoSuchElementException
       {
            List<String> donacionesID = this.fachadaDonacion.buscar();
            DonacionDTO donacionDTO = buscarDonacionPorId();
            List<NecesidadMaterial> necesidades = 
            DepositoDTO depositoDTO = buscarDepositoPorId();
            PaqueteDTO paqueteDTO = 
            AsignacionDTO asignacionDTO = this.fachadaLogistica.ejecutarMatchmaking();
            DonadorStatsDTO donadorStatsDTO = this.fachadaDonador.estadisticasDonador(donadorID);
            donadorStatsDTO.setMisionActualID(misionDTO.getID());
            
       }

      @Override
      void asignarInsigniaADonador(String donadorID, InsigniaDTO insigniaDTO)
      throws NoSuchElementException{

          
            
      }

      @Override
      void procesarDonador(String donadorID) throws NoSuchElementException{


            
      }
      

       @Override
       void setFachadaDonaciones(FachadaDonaciones fachadaDonaciones){
           this.fachadaDonacion = fachadaDonaciones;
       }

      @Override
      void setFachadaDonadoresYEntidades(FachadaDonadoresYEntidades fachadaDonadoresYEntidades){
           this.fachadaDonador = fachadaDonadores;

      }
      
}
