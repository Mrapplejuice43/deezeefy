package formation.sopra.deezeefy.controller;

import formation.sopra.deezeefy.model.PlaylistFollower;
import formation.sopra.deezeefy.repository.PlaylistFollowerRepository;
import formation.sopra.deezeefy.service.PlaylistFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/playlistFollower")
public class PlaylistFollowerController {

    @Autowired private PlaylistFollowerService playlistFollowerService;

    private PlaylistFollowerRepository playlistFollowerRepository;

    @GetMapping("/{id}")
    public PlaylistFollower getById(@PathVariable Integer id) {
        return playlistFollowerService.findById(id);
    }

    @GetMapping("")
    public List<PlaylistFollower> getAll() {
        return playlistFollowerService.findall();
    }

    @PostMapping("")
    public PlaylistFollower insert(@RequestBody PlaylistFollower playlistFollower) {
        return playlistFollowerService.insert(playlistFollower);
    }

    @PutMapping("/{id}")
    public PlaylistFollower update(@RequestBody PlaylistFollower playlistFollower, @PathVariable Integer id) {
        if(playlistFollower.getId() == null || !playlistFollower.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return playlistFollowerService.update(playlistFollower);
    }
}
