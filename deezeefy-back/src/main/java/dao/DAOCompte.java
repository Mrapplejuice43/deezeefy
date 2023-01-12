package dao;

import model.Compte;

public class DAOCompte implements IDAO<Compte, Integer> {
	static DAOCompte instance;

	private DAOCompte() {
		// TODO Auto-generated constructor stub
	}
	
	public static DAOCompte getInstance() {
		if(instance == null) {
			instance = new DAOCompte();
		}
		
		return instance;
	}

	@Override
	public Compte findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
