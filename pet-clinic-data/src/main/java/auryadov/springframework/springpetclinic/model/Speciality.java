package auryadov.springframework.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
    private String description;
}
