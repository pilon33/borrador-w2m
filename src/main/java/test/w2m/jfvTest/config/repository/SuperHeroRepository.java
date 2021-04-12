package test.w2m.jfvTest.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.w2m.jfvTest.config.model.SuperHero;
@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {

}


