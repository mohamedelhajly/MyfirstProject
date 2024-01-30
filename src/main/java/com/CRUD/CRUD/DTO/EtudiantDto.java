package com.CRUD.CRUD.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {

    private Long id;
    private String name;
    private String prenom;
    private int age;
    private Integer note;
    private Set<CoursesDto> courses;
    private EcoleDto ecole;
    private PassportDto passport;

}
