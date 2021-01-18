package auryadov.springframework.springpetclinic.bootstrap;

import auryadov.springframework.springpetclinic.model.*;
import auryadov.springframework.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alexander");
        owner1.setLastName("Uryadov");
        owner1.setAddress("12 Y.Seferov");
        owner1.setCity("Baku");
        owner1.setTelephone("123456");

        Pet alexPet = new Pet();
        alexPet.setName("Seven");
        alexPet.setPetType(savedDogPetType);
        alexPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(alexPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Timur");
        owner2.setLastName("Mammadov");
        owner2.setAddress("34 H.Aliyev");
        owner2.setCity("Ganja");
        owner2.setTelephone("022-566-43-44");

        Pet timaCat = new Pet();
        timaCat.setName("Yulka");
        timaCat.setPetType(savedCatPetType);
        timaCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(timaCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(timaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Leyla");
        vet2.setLastName("Veterinary");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
