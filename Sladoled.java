package sladoledi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
public class Sladoled {
	
	public class UkusMili {
		private Ukus ukus;
		private int mili;
		public Ukus getUkus() {
			return ukus;
		}
		public void setUkus(Ukus ukus) {
			this.ukus = ukus;
		}
		public int getMili() {
			return mili;
		}
		public void setMili(int mili) {
			this.mili = mili;
		}
		public void addMili(int mili) {
			this.mili += mili;
		}
		public UkusMili(Ukus ukus, int mili) {
			this.ukus = ukus;
			this.mili = mili;
		}
	};
	private ArrayList<UkusMili> ukusMili;
	private int cupSize;
	public  Sladoled(int cupSize) {
		this.ukusMili = new ArrayList<>();
		this.cupSize = cupSize;
	}
	public void addUkusMili(Ukus ukus, int kolicina) {
		int filledSoFar = this.filledSoFar();
		if (filledSoFar == cupSize)
			return;
		int biceDodato = kolicina;
		if (filledSoFar + kolicina >= cupSize) 
			biceDodato = cupSize - filledSoFar;
		/*for (int i = 0; i < this.ukusMili.size(); i++) {
			if (this.ukusMili.get(i).getUkus().equals(ukus)) {
				this.ukusMili.get(i).addMili(biceDodato);
				return;
			}
		}*/
		ukusMili.add(new UkusMili(ukus, biceDodato));
	}
	public int filledSoFar() {
		int total = 0;
		for (int i = 0; i < this.ukusMili.size(); i++) {
			total += this.ukusMili.get(i).getMili();
		}
		return total;
	}
	
	public String toString() {
		ArrayList<UkusMili> ukusi = new ArrayList<>();
		for (int i = 0; i < ukusMili.size(); i++) {
			boolean isInUkusi = false;
			for (int j = 0; !isInUkusi && j < ukusi.size(); j++) {
				if (ukusi.get(j).getUkus().equals(ukusMili.get(i).getUkus())) {
					ukusi.get(j).addMili(ukusMili.get(i).getMili());
					isInUkusi = true;
				}
			}
			if (! isInUkusi) {
				ukusi.add(new UkusMili(ukusMili.get(i).getUkus(), ukusMili.get(i).getMili()));
			}
		}
		String str = "";
		for (int i = 0; i < ukusi.size(); i++) {
			str += ukusi.get(i).getMili();
			str += "ml";
			str += ukusi.get(i).getUkus();
		}
		return str;
	}

	public  static void main (String[] args) {
		Sladoled s = new Sladoled(200);
		s.addUkusMili(new Ukus("chocolate", Color.WHITE), 40);
		s.addUkusMili(new Ukus("chocolate", Color.WHITE), 70);
		System.out.println(s.toString());
		s.addUkusMili(new Ukus("jagoda", Color.RED), 1000);
		System.out.println(s.toString());
		s.addUkusMili(new Ukus("banana", Color.YELLOW), 1000);
	}
	public boolean ukusExists(Ukus ukus) {
		for (int i = 0; i < this.ukusMili.size(); i++) {
			UkusMili um = this.ukusMili.get(i);
			if (um.getUkus().equals(ukus))
				return true;
		}
		return false;
	}
	public ArrayList<UkusMili> getUkusMili() {
		return this.ukusMili;
	}
	public int getCupSize() {
		return this.cupSize;
	}
	public void prodaj() {
		ukusMili.clear();
	}
}

