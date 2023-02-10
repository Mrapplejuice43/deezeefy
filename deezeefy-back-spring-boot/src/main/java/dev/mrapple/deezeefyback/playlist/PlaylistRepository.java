package dev.mrapple.deezeefyback.playlist;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrapple.deezeefyback.playlist.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{
    
}
