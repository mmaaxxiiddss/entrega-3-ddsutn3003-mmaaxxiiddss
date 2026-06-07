package ar.edu.utn.dds.k3003;


import java.util.List;


public class ImplFachadaIncentivos{
      
      private MisionRepository misionRepo;
      private MisionDataMapper misionDataMapper;
      private InsigniaRepository insigniaRepo;
      private InsigniaDataMapper insigniaDataMapper;
      
      
      private FachadaDonaciones fachadaDonaciones;
      private FachadaDonadores fachadaDonadores;
      
      public ImplFachadaIncentivos()
      {
           super();
           this.misionRepo = new InMemoryMisionRepo();
           this.misionDataMapper = new MisionDataMapper();

      }

      
      @Override
      void asignarMisionADonador(String donadorID, MisionDTO misionDTO) throws NoSuchElementException
       {
            AsignacionDTO asignacionDTO = 
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
           this.fachadaDonaciones = fachadaDonaciones;
       }

      @Override
      void setFachadaDonadoresYEntidades(FachadaDonadoresYEntidades fachadaDonadoresYEntidades){
           this.fachadaDonadores = fachadaDonadores;

      }
      
}
