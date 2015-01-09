package org.gradle;

import static org.junit.Assert.*;

import org.junit.Test;

import personnes.Etudiant;

public class EtudiantTest {

	@Test
	public void test() {
		Etudiant etu=new Etudiant("Dinh","Livio");
		assertEquals("Dinh", etu.getNom());
		assertEquals("Livio", etu.getPrenom());
	}

}
