package ar.edu.utn.dds.k3003.repositories;

import java.util.List;

public interface QuejasRepository{

   Queja findById(String id);

   Queja save(Queja queja);

   List<Queja> findAll();

}
