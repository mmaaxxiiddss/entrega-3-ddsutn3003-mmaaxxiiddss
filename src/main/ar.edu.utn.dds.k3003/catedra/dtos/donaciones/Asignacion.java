package ar.edu.utn.dds.k3003.catedra.dtos.logistica;

import java.time.LocalDate;

public record AsignacionDTO(
    String id,
    String paqueteID,
    String necesidadID,
    LocalDateTime fecha,
    EstadoAsginacionEnum estado) {}
