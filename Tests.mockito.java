package ar.edu.utn.dds.k3003;

  
import java.util.List;

import static org.mockito.Mockito.*;

import ar.edu.utn.dds.k3003.Fachada;
import ar.edu.utn.dds.k3003.catedra.ClassFinder;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.*;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.InsigniaDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.MisionDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.TipoMisionEnum;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaIncentivos;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@EnabledIf("ar.edu.utn.dds.k3003.catedra.donadoresyentidades.DonadoresTest#condicion")
public class DonadoresTest{


  FachadaDonadoresYEntidades instancia;
  @Mock FachadaIncentivos fachadaIncentivos;

  DonadorDTO donadorEjemplo;
  EntidadBeneficaDTO entidadEjemplo;
  NecesidadMaterialDTO necesidadEjemplo;

  @SneakyThrows
  @BeforeEach
  void setUp() {

    var clazz = ClassFinder.findClass();
    instancia = (FachadaDonadoresYEntidades) clazz.getDeclaredConstructor().newInstance();

    instancia.setFachadaIncentivos(fachadaIncentivos);

    donadorEjemplo =
        new DonadorDTO(
            null,
            "donador1",
            "donador1",
            5,
            "donador1",
            "donador1",
            "donador1",
            EstadoDonadorEnum.VERIFICADO,
            "donador1");
    entidadEjemplo = new EntidadBeneficaDTO(null, "entidad1", "entidad1", "entidad1", "entidad1");
    necesidadEjemplo =
        new NecesidadMaterialDTO(
            null,
            "entidad1",
            5,
            "necesidad1",
            5,
            "producto1",
            TipoNecesidadMaterialEnum.EXTRAORDINARIA);
  }

  static boolean condicion() {

    return FachadaDonadoresYEntidades.class.isAssignableFrom(Fachada.class);
           }

  @Test
  void testMisionCompletitud(){
    
      Assertions.assertEquals(setCategorias,3);
      Assertions.assertEquals(donadorDTO.getCategoria(),"COLABORADOR");
  
  }
  
}
