package dao;

import model.Contenu;

public class DAOContenu implements IDAO<Contenu, Integer>{
	static DAOContenu instance;
	
	public DAOContenu() {
		// TODO Auto-generated constructor stub
	}
	
	public static DAOContenu getInstance() {
		if(instance == null) {
			instance = new DAOContenu();
		}
		
		return instance;
	}

	@Override
	public Contenu findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
