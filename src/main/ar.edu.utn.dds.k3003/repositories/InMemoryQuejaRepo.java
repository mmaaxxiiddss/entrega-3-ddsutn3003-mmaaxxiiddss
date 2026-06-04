package ar.edu.utn.dds.k3003.repositories;

import java.util.List;

public class InMemoryQuejaRepo implements QuejasRepository{

  private List<Queja> quejas;
  private AtomicLong idSecuencial = new AtomicLong(1);

  public InMemoryQuejaRepo() {
    this.donadores = new ArrayList<>();
  }

   
   @Override
   Optional<Queja> findById(String id){
       return this.quejas.stream().filter(q -> q.getId().equals(id)).findFirst();
   }

  
}
