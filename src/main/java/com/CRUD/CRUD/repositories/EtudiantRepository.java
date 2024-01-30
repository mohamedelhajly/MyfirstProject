package com.CRUD.CRUD.repositories;

import com.CRUD.CRUD.models.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {


    @Query("SELECT e FROM Etudiant e  WHERE e.name LIKE %:mc% OR "
            + "e.prenom LIKE %:mc%"
            +" ORDER BY e.id DESC"  //TODO
            )
    Page<Etudiant> searchNewsByMC(@Param("mc") String mc, Pageable pageable);

    //Page<Etudiant> findAll( Pageable pageable);

}
