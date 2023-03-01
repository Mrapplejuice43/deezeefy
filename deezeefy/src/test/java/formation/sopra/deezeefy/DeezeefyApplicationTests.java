package formation.sopra.deezeefy;

import formation.sopra.deezeefy.model.Admin;
import formation.sopra.deezeefy.model.Abonnement;
import formation.sopra.deezeefy.model.Artiste;
import formation.sopra.deezeefy.model.Genre;
import formation.sopra.deezeefy.model.Musique;
import formation.sopra.deezeefy.repository.AdminRepository;
import formation.sopra.deezeefy.model.Utilisateur;
import formation.sopra.deezeefy.repository.ArtistRepository;
import formation.sopra.deezeefy.repository.MusiqueRepository;
import formation.sopra.deezeefy.repository.UtilisateurRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeezeefyApplicationTests {

	@Autowired
	private MusiqueRepository musiqueRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Autowired 
	private ArtistRepository artistRepository;
	

	@Autowired 
	private UtilisateurRepository utilisateurRepository;
	
	@Test
	void preloadBase() {
		Byte[] b = {0xF};
		Musique m = new Musique("Experience", 363, b, Genre.CLASSIQUE);
		musiqueRepository.save(m);
		Musique m2 = new Musique("Beyond", 345, b, Genre.ELECTRONIQUE);
		musiqueRepository.save(m2);
		Musique m3 = new Musique("Take Me Back", 285, b, Genre.RAP);
		m3 = musiqueRepository.save(m3);
		
		Artiste a3 = new Artiste("Jackson", "Michael");
		a3 = artistRepository.save(a3);
		m3.setAuteur(a3);
		musiqueRepository.save(m3);
		Admin ad1 = new Admin("JD1","easy","jd@deezeefy.com","Doe","John","Jdoe");
		adminRepository.save(ad1);
		Admin ad2 = new Admin("DS","beatles","ds@deezeefy.com","Smith","Dave","Sdev");
		adminRepository.save(ad2);
		Admin ad3 = new Admin("SC","robot","sc@deezeefy.com","Connor","Sarah","Sarah31");
		adminRepository.save(ad3);
		
		
		
		
		Artiste a1 = new Artiste("ari","ari","ariana@gmail.fr","Ariana","Grande","ariri",0,"hello I'm Ariana");
		a1=  artistRepository.save(a1);
		
		Artiste a2 = new Artiste("dua","dua","dua@gmail.fr","Dua","Lipa","duaa",0,"hello I'm Dua Lipa");
		a2=  artistRepository.save(a2);
		
		Utilisateur u1 = new Utilisateur("didi","didi","didi@gmail.fr","Didier","Deschamps","didi",Abonnement.ETUDIANT,23);
		u1=  utilisateurRepository.save(u1);
		
	}
	
	


	@Test
	void contextLoads() {
	}

}
