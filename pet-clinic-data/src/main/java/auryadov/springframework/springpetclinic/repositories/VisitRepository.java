package auryadov.springframework.springpetclinic.repositories;

import auryadov.springframework.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
