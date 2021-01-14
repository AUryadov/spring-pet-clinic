package auryadov.springframework.springpetclinic.bootstrap;

import auryadov.springframework.springpetclinic.model.Owner;
import auryadov.springframework.springpetclinic.model.Vet;
import auryadov.springframework.springpetclinic.services.OwnerService;
import auryadov.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alexander");
        owner1.setLastName("Uryadov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Timur");
        owner2.setLastName("Mammadov");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Leyla");
        vet2.setLastName("Veterinary");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
