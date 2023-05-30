package sladoledi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sladoleddzinica extends Frame {

	private Aparat_za_tocenje aparat_za_tocenje;
	private Panel donjiPanel = new Panel(new FlowLayout()); 
	public static int PoRedu = 0;
	
	public Sladoleddzinica() {
		super();
	
		
		Aparat_za_tocenje aparat_za_tocenje = new Aparat_za_tocenje();
		add(aparat_za_tocenje, BorderLayout.CENTER);
		Label Naziv = new Label("Naziv: ");
		TextField nazivfield = new TextField(10);
		Label Boja = new Label("Boja: ");
		TextField bojafield = new TextField(8);
		Naziv.setFont(new Font("Arial", Font.BOLD, 16));
		Boja.setFont(new Font("Arial", Font.BOLD, 16));
		Button DodajUkus = new Button("Dodaj ukus");
		donjiPanel.add(Naziv);
		donjiPanel.add(nazivfield);
		donjiPanel.add(Boja);
		donjiPanel.add(bojafield);
		donjiPanel.add(DodajUkus);
		donjiPanel.setBackground(Color.decode("#00E5FF"));
		add(donjiPanel, BorderLayout.SOUTH);
		setLocation(700, 200);
		setSize(540,440);
		aparat_za_tocenje.mesto.sladoled = new Sladoled(200);
		DodajUkus.addActionListener((ae)-> {
			aparat_za_tocenje.dugme_prodaj.setEnabled(true);
			aparat_za_tocenje.dugme_prodaj.addActionListener((ae2) -> {
				aparat_za_tocenje.mesto.sladoled.prodaj();
				aparat_za_tocenje.opis.setText("                                          ");
				aparat_za_tocenje.mesto.repaint();
			});
			Color boja = Color.white;
			try {
				boja = Color.decode("#" + bojafield.getText());
			} catch (NumberFormatException e) {
			}
			Ukus u = new Ukus(nazivfield.getText(), boja);
			for (int i = 0; i < aparat_za_tocenje.levi_deo.getComponentCount(); i++) {
				Component comp = aparat_za_tocenje.levi_deo.getComponent(i);
				if (comp instanceof Button) {
					Button ukusButton = (Button)comp;
					if (ukusButton.getLabel().equals(u.getNaziv()))
						return;
				}
			}
			//	aparat_za_tocenje.mesto.icecream = new Sladoled(200);
			//	aparat_za_tocenje.mesto.icecream.AddUkus(u, 20);
			Button noviUkus =  new Button(nazivfield.getText());
			try {
				noviUkus.setBackground(boja);
			} catch (NumberFormatException e) {
				noviUkus.setBackground(Color.BLACK);
			}
			noviUkus.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {			
						
						//aparat_za_tocenje.mesto.sladoled.addUkusMili(u, 20);
						
						aparat_za_tocenje.mesto.startPuni(u);
					//	System.out.println("Kliknuto da se puni.");
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						aparat_za_tocenje.mesto.stopPuni();
					//	System.out.println("Pusteno da se puni.");
					}
				}
			);
			aparat_za_tocenje.levi_deo.add(noviUkus);
			setVisible(false);
			setVisible(true);
			if (PoRedu == 0) {
				aparat_za_tocenje.levi_deo.setLayout(new GridLayout(2,0));
			} else if (PoRedu >= 1) {
				aparat_za_tocenje.levi_deo.setLayout(new GridLayout(0,2));
			}
			PoRedu += 1;
			/*else if (PoRedu > 1) {
				aparat_za_tocenje.levi_deo.add(new Button("UKUS"));
				setVisible(false);
				setVisible(true);
				aparat_za_tocenje.levi_deo.setLayout(new GridLayout(2,0));
				PoRedu += 1;
			}*/


		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new Sladoleddzinica();
	}
	
}
