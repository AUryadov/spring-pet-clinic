package auryadov.springframework.springpetclinic.repositories;

import auryadov.springframework.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
