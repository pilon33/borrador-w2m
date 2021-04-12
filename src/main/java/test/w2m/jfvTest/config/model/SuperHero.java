package test.w2m.jfvTest.config.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class SuperHero implements Serializable {

    @Id
    @GeneratedValue
	private int id;

    private String name;
    private String namePower;
    private String superName;
    private String profession;
    private String worldNamebBorn;
    private int age;
    private boolean canFly;

  

	

}