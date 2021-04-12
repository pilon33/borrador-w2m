package test.w2m.jfvTest.config.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import test.w2m.jfvTest.config.model.SuperHero;
import test.w2m.jfvTest.config.service.SuperHeroService;

import java.util.List;

@RestController
@RequestMapping("/super-heroes")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping("all")
    public ResponseEntity<List<?>> findAll() {
        List<?> list = superHeroService.findAll();
        System.out.println("=============================GET ALL============================");
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    @Cacheable(value = "superHeros",key="#id")
    public ResponseEntity<?> findById(@PathVariable int id) {
        SuperHero superHero = superHeroService.findById(id);
        System.out.println("=============================GET ID============================");
        return ResponseEntity.ok().body(superHero);
    }
    
	// get Student by first name %LIKE%
	@GetMapping("/name-like/{name}")
	public ResponseEntity<List<?>> getSuperHeroNameLike(@PathVariable String name) {
		 List<?> list = superHeroService.getSuperHeroNameLike(name);
		 return ResponseEntity.ok().body(list);
	}


	@PostMapping("create")
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {
        SuperHero savedSuperHero = superHeroService.save(superHero);
        return ResponseEntity.ok().body(savedSuperHero);
    }


    @PutMapping("update/{id}")
    @CachePut(value = "superHeros",key = "#superHero.id")
   public ResponseEntity<?> update(@PathVariable int id, @RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(id, superHero);
        System.out.println("=============================UPDATE ID============================");

        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("delete/{id}")
    @CacheEvict(value = "superHeros",allEntries = false,key = "#id")
    public ResponseEntity<?> delete(@PathVariable int id) {
        superHeroService.delete(id);
        System.out.println("=============================DELETE ID============================");
        return ResponseEntity.ok().body("Deleted Super Heroe successfully...!");
    }
}
