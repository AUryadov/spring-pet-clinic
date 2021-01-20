package auryadov.springframework.springpetclinic.services.springdatajps;

import auryadov.springframework.springpetclinic.model.Owner;
import auryadov.springframework.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final long ID = 1L;
    final String LAST_NAME = "Smith";
    Owner returnOwner;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(ID);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnOwner);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> foundSet = service.findAll();

        assertNotNull(foundSet);
        assertEquals(1, foundSet.size());
    }

    @Test
    void findByIdSuccess() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(ID);

        assertNotNull(owner);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(ID);

        assertNull(owner);

        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(ID);

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner saveOwner = service.save(ownerToSave);

        assertNotNull(saveOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(ID);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}