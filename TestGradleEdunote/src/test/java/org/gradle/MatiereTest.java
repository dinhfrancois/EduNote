package org.gradle;

import static org.junit.Assert.*;

import org.junit.Test;

import composants.Matiere;

public class MatiereTest {

	@Test
	public void canConstructAMatiereWithAName() {
		Matiere mat = new Matiere("Java",1.5f);
        assertEquals("Java", mat.getNom());
        assertEquals(1.5f, mat.getCoefficient(),0);
	}

}
