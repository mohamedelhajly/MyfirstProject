package com.CRUD.CRUD.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Etudiant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)  //JPA annotation
    @Id                                                  //JPA annotation
    private Long id;

    @NotEmpty                                                                         //Validation Annotation
    @Size(min = 3, max = 50, message = "Le nom doit avoir entre 3 et 50 caractères") //Validation Annotation
    private String name;

    @NotBlank(message = "ne doit pas etre blank") //Validation Annotation
    private String prenom;

    @NotNull(message = "age ne doit pas etre null")   //Validation Annotation
    private int age;

    //@Column(unique = true, nullable = false)    //JPA annotation
    private Integer note;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Etudiant_course",
            joinColumns = @JoinColumn(name = "Etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Courses> courses;

    @ManyToOne(cascade = CascadeType.ALL) //fetch = FetchType.LAZY
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

}
