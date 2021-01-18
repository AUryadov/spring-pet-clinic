package auryadov.springframework.springpetclinic.repositories;

import auryadov.springframework.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
