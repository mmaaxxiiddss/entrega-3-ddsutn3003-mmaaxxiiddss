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
            
            DonadorStatsDTO donadorStatsDTO = this.fachadaDonador.estadisticasDonador(donadorID);
            val donadorStats = this.fachadaDonador.getDataMapper().toDonadorStats(donadorStatsDTO);
             donadorStats.setMisionActualID(misionDTO.getID());
            val donadorStatsGuardado = this.fachadaDonador.getRepo().save(donadorStats);
       }

      @Override
      void asignarInsigniaADonador(String donadorID, InsigniaDTO insigniaDTO)
      throws NoSuchElementException{

          DonadorStatsDTO donadorStatsDTO = this.fachadaDonador.estadisticasDonador(donadorID);
          val donadorStats = this.fachadaDonador.getDataMapper().toDonadorStats(donadorStatsDTO);
          donadorStats.getInsigniasID().add(insigniaDTO.ID());
            val donadorStatsGuardado = this.fachadaDonador.getRepo().save(donadorStats);
            
            
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
