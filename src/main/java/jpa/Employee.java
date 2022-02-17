package jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Log4j2
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = false)
    private Long id;

    @Setter
    @Column(name = "nev", length = 100, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "nick_names", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "nick_name")
    private Set<String> nickNames;

    @ElementCollection
    @CollectionTable(name = "vacations", joinColumns = @JoinColumn(name = "emp_id"))
    @AttributeOverride(name = "startTime", column = @Column(name = "start_time"))
    @AttributeOverride(name = "days", column = @Column(name = "vacation_days"))
    private Set<Vacation> vacations;

    @ElementCollection
    @CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "emp_id"))
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_number")
    private Map<String, String> phonesNumbers;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private WorkTimeType workTimeType;

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    private void prePersist() {
        log.info(name + " before persist");
    }

    @PostPersist
    private void postPersist() {
        log.info(name + " after persist");
    }

    @PreRemove
    private void preRemove() {
        log.info(name + " will be removed");
    }

    @PostRemove
    private void postRemove() {
        log.info(name + " was removed");
    }

    @PreUpdate
    private void preUpdate() {
        log.info(name + " before persist");
    }

    @PostUpdate
    private void postUpdate() {
        log.info(name + " after update");
    }

    @PostLoad
    private void postLoad() {
        log.info(name + " after load");
    }
}
