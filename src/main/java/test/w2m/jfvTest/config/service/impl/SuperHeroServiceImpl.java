package test.w2m.jfvTest.config.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import test.w2m.jfvTest.config.model.SuperHero;
import test.w2m.jfvTest.config.repository.SuperHeroRepository;
import test.w2m.jfvTest.config.service.SuperHeroService;
import test.w2m.jfvTest.exceptions.NonExistingSuperHeroException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	
	
	@Autowired
    private SuperHeroRepository repository;
    
  
    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

	@Override
	public SuperHero findById(int id) {

		return repository.findById(id)
				.orElseThrow(() -> new NonExistingSuperHeroException("** Superhero not found for id :: " + id));
	}

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(int id, SuperHero superHero) {
    	repository.findById(id).orElseThrow(() -> new NonExistingSuperHeroException("** Superhero not found for id :: " + id));
    	superHero.setId(id);
        return repository.save(superHero);
    }

    @Override
    public void delete(int id) {
       repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
    }


	@Override
	public List<SuperHero> getSuperHeroNameLike(String name) {
		List<SuperHero> superHeroes = new ArrayList<>();
		List<SuperHero> list = repository.findAll();
		for (SuperHero superHero : list) {
			if (superHero.getSuperName().contains(name))
				superHeroes.add(superHero);
		}
		return superHeroes;
	}
}
