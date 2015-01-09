package org.gradle;

import static org.junit.Assert.*;

import org.junit.Test;

import personnes.Professeur;

public class ProfesseurTest {

	@Test
	public void test() {
		Professeur prof=new Professeur("Dinh","Livio");
		assertEquals("Dinh", prof.getNom());
		assertEquals("Livio", prof.getPrenom());
	}


}
