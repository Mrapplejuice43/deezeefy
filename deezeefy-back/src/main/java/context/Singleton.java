package context;

import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOContenuJDBC;
import dao.jdbc.DAOMusicList;

public class Singleton {
	
	private DAOCompteJDBC daoCompte = new DAOCompteJDBC();
	private DAOContenuJDBC daoContenu = new DAOContenuJDBC();
	private DAOMusicList daoMusicList = new DAOMusicList();
	
	private static Singleton instance;
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}

	public DAOCompteJDBC getDaoCompte() {
		return daoCompte;
	}

	public DAOContenuJDBC getDaoContenu() {
		return daoContenu;
	}

	public DAOMusicList getDaoMusicList() {
		return daoMusicList;
	}
	
	
}
