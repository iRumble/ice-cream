package sladoledi;

import java.awt.Color;

public class Ukus {
	private String naziv;
	private Color color;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Ukus(String naziv, Color c ) {
		this.naziv = naziv;
		this.color = c;
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Ukus)) {
			return false;
		}
		
		Ukus u = (Ukus)obj;
		return this.getNaziv().equals(u.getNaziv());
	}
	
	public String toString() {
		return "[" + this.getNaziv() + "]";
	}
	
}
