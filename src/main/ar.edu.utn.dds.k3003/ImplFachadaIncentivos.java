package ar.edu.utn.dds.k3003;

import java.util.List;

public class ImplFachadaIncentivos{

      private MisionRepository misionRepo;
      private MisiinDataMapper misionDataMapper;
  
  
      @Override
      void asignarMisionADonador(String donadorID, MisionDTO misionDTO) throws NoSuchElementException
       {
            
            val mision = this.misionDataMapper.toMision(misionDTO);
            mision.setDonadorId(donadorID);
            val misionGuardada = this.misionRepository.save(mision);
            
       }

}
