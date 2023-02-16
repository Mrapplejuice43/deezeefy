package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.exception.PlaylistFollowerException;
import formation.sopra.deezeefy.model.PlaylistFollower;
import formation.sopra.deezeefy.repository.PlaylistFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistFollowerService {
    @Autowired private PlaylistFollowerRepository playlistFollowerRepository;

    public PlaylistFollower findById(Integer id) {
        return playlistFollowerRepository.findById(id).orElseThrow(() -> {
           throw new PlaylistFollowerException();
        });
    }

    public List<PlaylistFollower> findall() {
        return playlistFollowerRepository.findAll();
    }

    public PlaylistFollower insert(PlaylistFollower playlistFollower) {
        return playlistFollowerRepository.save(playlistFollower);
    }

    public PlaylistFollower update(PlaylistFollower playlistFollower) {
        return playlistFollowerRepository.save(playlistFollower);
    }

    public void deleteById(Integer id) {
        playlistFollowerRepository.deleteById(id);
    }

    public void delete(PlaylistFollower playlistFollower) {
        deleteById(playlistFollower.getId());
    }
}
