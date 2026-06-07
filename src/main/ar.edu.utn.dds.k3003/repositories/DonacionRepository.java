package ar.edu.utn.dds.k3003.repositories;


import java.util.List;
import java.util.Optional;


public interface DonacionRepository{

   Optional<Donacion> findById(String id);

   Donacion save(Donacion donacion);

   Donacion deleteById(String id);

   List<Donacion> findAll();

}
