package dev.mrapple.deezeefyback.compte;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrapple.deezeefyback.compte.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
    
}
