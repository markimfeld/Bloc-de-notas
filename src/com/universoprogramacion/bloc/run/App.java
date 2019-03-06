/**
 * 
 */
package com.universoprogramacion.bloc.run;

import javax.swing.JFrame;

import com.universoprogramacion.bloc.clases.MainFrame;

/**
 * Clase para iniciar el programa.
 * 
 * @author Marcos
 * @version 1.0
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame w = new MainFrame();
		w.setVisible(true);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
