package test.w2m.jfvTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import test.w2m.jfvTest.config.model.SuperHero;
import test.w2m.jfvTest.config.repository.SuperHeroRepository;
import test.w2m.jfvTest.config.service.SuperHeroService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
	public class JfvTestApplicationTests {	
	@LocalServerPort
    private int port;
	 

	@Autowired
    private SuperHeroService service;

    /**
     * Create a mock implementation of the WidgetRepository
     */
    @MockBean
    private SuperHeroRepository repository;


	
	@Test
	@DisplayName("Test Create Super Hero")
	void testSave() {
		// Setup our mock repository
		SuperHero superHero = new SuperHero(1, "clark", "hombre acero", "superman", "periodista", "marte", 22, true);
		doReturn(superHero).when(repository).save(any());

		// Execute the service call
		SuperHero returnedSuperHero = service.save(superHero);

		// Assert the response
		Assertions.assertNotNull(returnedSuperHero, "The saved Super Hero should not be null");
		Assertions.assertEquals(1, returnedSuperHero.getId(), "The version should be incremented");
	}

	@Test
	@DisplayName("Test findAll Super Hero")
	void testFindAll() {
		// Setup our mock repository
		SuperHero superHeroOne = new SuperHero(1, "clark", "hombre acero", "superman", "periodista", "marte", 22, true);
		SuperHero superHeroTwo = new SuperHero(2, "clark", "hombre araña", "spiderman", "fotografo", "tierra", 20, false);
		doReturn(Arrays.asList(superHeroOne, superHeroTwo)).when(repository).findAll();

		// Execute the service call
		List<?> superHero = service.findAll();

		// Assert the response
		Assertions.assertEquals(2, superHero.size(), "findAll should return 2 superHero");
	}
	
	}


