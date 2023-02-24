package formation.sopra.deezeefy;

import formation.sopra.deezeefy.model.Genre;
import formation.sopra.deezeefy.model.Musique;
import formation.sopra.deezeefy.repository.MusiqueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeezeefyApplicationTests {

	@Autowired
	private MusiqueRepository musiqueRepository;

	@Test
	void preloadBase() {
		Byte[] b = {0xF};
		Musique m = new Musique("Experience", 363, b, Genre.CLASSIQUE);
		musiqueRepository.save(m);
		Musique m2 = new Musique("Beyond", 345, b, Genre.ELECTRONIQUE);
		musiqueRepository.save(m2);
		Musique m3 = new Musique("Take Me Back", 285, b, Genre.RAP);
		musiqueRepository.save(m3);
	}


	@Test
	void contextLoads() {
	}

}
