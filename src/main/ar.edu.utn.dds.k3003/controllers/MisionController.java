package ar.edu.utn.dds.k3003.controllers;


import ar.edu.utn.dds.k3003.Fachada;


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
@Tag(name = "Misiones", description = "API de gestión de misiones")
public class MisionController {

  private final Fachada fachadamisiones;

  public MisionController(Fachada fachadamisiones) {
    this.fachada = fachada;
  }

  @Operation(summary = "Agregar una nueva mision")
  @PostMapping("/misiones")
  public ResponseEntity<MisionDTO> agregarMision(@RequestBody MisionDTO misionDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(fachadamisiones.agregarMision(misionDTO));
  }

}
