package formation.sopra.deezeefy;

import formation.sopra.deezeefy.model.*;
import formation.sopra.deezeefy.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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

	@Autowired private ContenuPlaylistRepository contenuPlaylistRepository;

	@Autowired private PlaylistRepository playlistRepository;


	
	@Test
	void preloadBase() {
		Admin ad1 = new Admin("admin","admin","jd@deezeefy.com","Doe","John","Jdoe");
		adminRepository.save(ad1);
		
		Artiste a1 = new Artiste("ari","ari","ariana@gmail.fr","Ariana","Grande","ariri",0,"hello I'm Ariana");
		a1=  artistRepository.save(a1);

		for (int i = 0; i < 10; i++) {
			Byte[] b = {0xF};
			Musique m = new Musique("exemple_" + a1.getPseudo() + "_" + i, 1, b, Genre.CLASSIQUE);
			m.setAuteur(a1);
			musiqueRepository.save(m);
		}
		
		Artiste a2 = new Artiste("dua","dua","dua@gmail.fr","Dua","Lipa","duaa",0,"hello I'm Dua Lipa");
		a2=  artistRepository.save(a2);

		for (int i = 0; i < 10; i++) {
			Byte[] b = {0xF};
			Musique m = new Musique("exemple_" + a2.getPseudo() + "_" + i, 1, b, Genre.RAP);
			m.setAuteur(a2);
			musiqueRepository.save(m);
		}
		
		Utilisateur u1 = new Utilisateur("didi","didi","didi@gmail.fr","Didier","Deschamps","didi",Abonnement.ETUDIANT,23);
		u1=  utilisateurRepository.save(u1);

		Playlist p1 = new Playlist("titre_playlist", 0, LocalDate.now(), 0, TypePlaylist.PLAYLIST);
		p1 = playlistRepository.save(p1);

		ContenuPlaylist cp1 = new ContenuPlaylist(LocalDate.now());
		cp1.setPlaylistAssociee(p1);
		cp1.setContenuAssocie(musiqueRepository.findById(2).get());
		contenuPlaylistRepository.save(cp1);
	}
	
	


	@Test
	void contextLoads() {
	}

}
