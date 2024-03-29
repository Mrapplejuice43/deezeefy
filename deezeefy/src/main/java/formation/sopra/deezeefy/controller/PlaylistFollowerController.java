package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.PlaylistFollower;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.PlaylistFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/playlistFollower")
public class PlaylistFollowerController {

    @Autowired private PlaylistFollowerService playlistFollowerService;

    @GetMapping("/{id}")
    @JsonView(Views.ViewPlaylistFollower.class)
    public PlaylistFollower getById(@PathVariable Integer id) {
        return playlistFollowerService.findById(id);
    }

    @GetMapping("")
    @JsonView(Views.ViewPlaylistFollower.class)
    public List<PlaylistFollower> getAll() {
        return playlistFollowerService.findall();
    }

    @PostMapping("")
    @JsonView(Views.ViewPlaylistFollower.class)
    public PlaylistFollower insert(@RequestBody PlaylistFollower playlistFollower) {
        return playlistFollowerService.insert(playlistFollower);
    }

    @PutMapping("/{id}")
    @JsonView(Views.ViewPlaylistFollower.class)
    public PlaylistFollower update(@RequestBody PlaylistFollower playlistFollower, @PathVariable Integer id) {
        if(playlistFollower.getId() == null || !playlistFollower.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return playlistFollowerService.update(playlistFollower);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Integer id) {
        if(!playlistFollowerService.existById(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        playlistFollowerService.deleteById(id);
    }
}
