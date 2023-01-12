package dao;

import model.MusicList;

public class DAOMusicList implements IDAO<MusicList, Integer>{
	static DAOMusicList instance;
	
	public DAOMusicList() {
		// TODO Auto-generated constructor stub
	}
	
	public static DAOMusicList getInstance() {
		if(instance == null) {
			instance = new DAOMusicList();
		}
		
		return instance;
	}

	@Override
	public MusicList findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
