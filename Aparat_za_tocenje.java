package sladoledi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Aparat_za_tocenje extends Panel {
	
	protected Button dugme_prodaj = new Button("Prodaj");
	private Label labelaPrikaz = new Label("Sladoled: ", Label.LEFT);
	protected Label opis = new Label("                                          ");
	Panel levi_deo = new Panel(new BorderLayout());
	Panel desni_deo = new Panel(new GridLayout(2,1));
	Mesto_za_tocenje mesto = new Mesto_za_tocenje(this);
	
	public Aparat_za_tocenje() {
		super(new BorderLayout());
		Panel southPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel content = new Panel(new GridLayout(1,2));
	//	levi_deo.setPreferredSize(new Dimension(400,300));
		desni_deo.setPreferredSize(new Dimension(200, 300));
		dugme_prodaj.setEnabled(false);
		desni_deo.add(dugme_prodaj);
		desni_deo.add(mesto);
		levi_deo.setBackground(Color.decode("#D9D9D9"));
		labelaPrikaz.setFont(new Font("Arial", Font.BOLD, 16));
		southPanel.add(labelaPrikaz);
		southPanel.add(opis);
		southPanel.setBackground(Color.decode("#C0C0C0"));
		
		add(levi_deo, BorderLayout.CENTER);
		add(desni_deo, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		
		// Test
		
		Frame frame = new Frame();
		frame.setLocation(700, 200);
		frame.setSize(540,440);
		Aparat_za_tocenje a1 = new Aparat_za_tocenje();
		frame.add(a1);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.dispose();
			}
		});
		frame.setVisible(true); 
	}

}
