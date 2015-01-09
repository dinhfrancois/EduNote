package org.gradle;

import static org.junit.Assert.*;

import org.junit.Test;

import composants.Note;

public class NoteTest {

	@Test
	public void canConstructANoteWithAName() {
		Note note=new Note(1.5f,15f);
		  assertEquals(1.5f, note.getCoefficient(),0);
		  assertEquals(15f, note.getNombre(),0);
	}

}
