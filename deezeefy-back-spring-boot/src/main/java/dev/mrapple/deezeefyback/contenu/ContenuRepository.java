package dev.mrapple.deezeefyback.contenu;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrapple.deezeefyback.contenu.model.Contenu;

public interface ContenuRepository extends JpaRepository<Contenu, Integer>{
    
}
