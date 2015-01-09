package composants;

import java.io.Serializable;
import java.util.Scanner;

public class Note implements Serializable {
	
	private float coefficient;
	private float nombre;
	
	public Note(float coefficient, float nombre)
	{
		this.coefficient = coefficient;
		this.nombre = nombre;
	}
	
	public void init(){
		Scanner input = new Scanner(System.in);
		System.out.print(" 		Entrez la note : ");
		this.nombre = input.nextFloat();
		System.out.print(" 		Entrez le coefficient de cette note : ");
		this.coefficient = input.nextFloat();
		
		
	}
	
	public Note(){
		
	}
	
	public Note(Note n)
	{
		this.coefficient = n.getCoefficient();
		this.nombre = n.getNombre();
	}
	
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public float getNombre() {
		return nombre;
	}
	public void setNombre(float nombre) {
		this.nombre = nombre;
	}

}
