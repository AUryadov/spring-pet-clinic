package auryadov.springframework.springpetclinic.services.springdatajps;

import auryadov.springframework.springpetclinic.model.Owner;
import auryadov.springframework.springpetclinic.repositories.OwnerRepository;
import auryadov.springframework.springpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}