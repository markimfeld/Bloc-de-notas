/**
 * 
 */
package com.universoprogramacion.bloc.clases;

import javax.swing.JFrame;

/**
 * Clase MainFrame: es la ventana principal.
 * 
 * @author Marcos
 *
 */
public class MainFrame extends JFrame {

	private static final int width = 500;
	private static final int heigth = 450;

	public MainFrame() {
		setTitle("Bloc");
		setBounds(700, 300, width, heigth);
		MainPanel mainPanel = new MainPanel();
		add(mainPanel);
	}
}
