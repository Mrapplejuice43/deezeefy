package dao;

import java.util.List;

import model.Playlist;

public interface IPlaylistRepository extends IRepository<Playlist>{

	public List<Playlist> findByPays(String pays);
	
}
