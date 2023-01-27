package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ICompteRepository;
import dao.IContenuRepository;
import dao.IPlaylistRepository;
import dao.repositoryJPA.CompteRepositoryJPA;
import dao.repositoryJPA.ContenuRepositoryJPA;
import dao.repositoryJPA.PlaylistRepositoryJPA;

public class Application {

	private static Application instance = null;
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("deezeefy");
	
	private final ICompteRepository compteRepo = new CompteRepositoryJPA();
	private final IContenuRepository contenuRepo = new ContenuRepositoryJPA();
	private final IPlaylistRepository musicListRepo = new PlaylistRepositoryJPA();
	
	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}
		return instance;
	}
	
	
	private Application() {
		
	}

	public ICompteRepository getCompteRepo() {
		return compteRepo;
	}


	public IContenuRepository getContenuRepo() {
		return contenuRepo;
	}


	public IPlaylistRepository getMusicListRepo() {
		return musicListRepo;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	

}
