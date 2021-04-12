package test.w2m.jfvTest.config.service;


import java.util.List;

import test.w2m.jfvTest.config.model.SuperHero;

public interface SuperHeroService {

    List<?> findAll();
    
	List<SuperHero> getSuperHeroNameLike(String name);

    SuperHero findById(int id);

    SuperHero save(SuperHero superHero);

    SuperHero update(int id, SuperHero superHero);

    void delete(int id);
}
