package sladoledi;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Mesto_za_tocenje extends Canvas {

	private Aparat_za_tocenje aparat;
	protected Sladoled sladoled;
	private Thread threadPunjenje = null;
	public Mesto_za_tocenje(Aparat_za_tocenje a) {
		aparat = a;
	}
	public Sladoled getSladoled() {
		return sladoled;
	}
	
	public void startPuni(Ukus ukus) {
		if(threadPunjenje != null)
			threadPunjenje.interrupt();
		threadPunjenje = new Thread(() -> {
			try {
				while (true) {
					//synchronized (sladoled) {
						sladoled.addUkusMili(ukus, 20);
					//}
						aparat.opis.setText(sladoled.toString());
					this.repaint();
					//System.out.println("Puni se! " + sladoled);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				threadPunjenje = null;
			}
		});
		threadPunjenje.start();
	}
	
	public void stopPuni() {
		if (threadPunjenje != null)
			threadPunjenje.interrupt();
	}
	
	@Override
	public void paint(Graphics g) {
		//synchronized (sladoled) {
			int base = 0;
			for (int i = 0; i < sladoled.getUkusMili().size(); i++) {
				g.setColor(sladoled.getUkusMili().get(i).getUkus().getColor());
				int height = sladoled.getUkusMili().get(i).getMili() * this.getHeight() 
						/ sladoled.getCupSize();
				g.fillRect(0, this.getHeight() - base - height, this.getWidth(), height);
				base += height;
			}
		//}
	}
}
