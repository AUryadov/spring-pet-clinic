package auryadov.springframework.springpetclinic.repositories;

import auryadov.springframework.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
