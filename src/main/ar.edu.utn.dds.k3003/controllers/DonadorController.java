package ar.edu.utn.dds.k3003.controllers;

import ar.edu.utn.dds.k3003.Fachada;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.DonacionDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.EstadoDonacionEnum;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.IdentificadorDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.ProductoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Donadores", description = "API de gestión de donadores")
public class DonadorController {

  private final Fachada fachada;

  public DonadorController(Fachada fachada) {
    this.fachada = fachada;
  }

  @Operation(summary = "Agregar un nuevo donador")
  @PostMapping("/donadores")
  public ResponseEntity<DonadorDTO> agregarDonador(@RequestBody DonadorDTO donadorDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(fachada.agregarDonador(donadorDTO));
  }

  @Operation(summary = "Buscar donadores por donador y fecha")
  @GetMapping("/donadores")
  public ResponseEntity<List<DonadorDTO>> buscarDonadores() {
    return ResponseEntity.ok(
        fachada.buscarDonadores());
  }

  @Operation(summary = "Buscar donador por ID")
  @GetMapping("/donadores/{id}")
  public ResponseEntity<DonadorDTO> buscarDonadorPorID(@PathVariable String id) {
    return ResponseEntity.ok(fachada.buscarDonadorPorID(id));
  }
  
  @Operation(summary = "Agregar queja en un donador")
  @PostMapping("/donador/{id}/quejas")
  public ResponseEntity<DonadorDTO> agregarQueja(
      @PathVariable String donadorID, @RequestBody String descripcion) {
    return ResponseEntity.ok(fachada.agregarQuejaEnDonador(donadorID, descripcion));
  }


  }
