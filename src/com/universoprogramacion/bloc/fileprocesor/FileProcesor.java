/**
 * 
 */
package com.universoprogramacion.bloc.fileprocesor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Clase FileProcesor: para abrir y guardar archivos.
 * 
 * @author Marcos
 *
 */
public class FileProcesor extends JFrame {

	private String path;
	private JTextArea jTextArea;
	private JButton btnAbrir, btnGuardar;

	public String abrirArchivo() {
		String aux = "";
		String texto = "";

		try {
			/* llamamos el metodo que permite cargar la ventana */
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(this);
			/* abrimos el archivo seleccionado */
			File abre = file.getSelectedFile();

			/**
			 * recorremos el archivo, lo leemos para plasmarlo en el area de texto
			 */
			if (abre != null) {
				FileReader archivos = new FileReader(abre);
				BufferedReader lee = new BufferedReader(archivos);
				while ((aux = lee.readLine()) != null) {
					texto += aux + "\n";
				}
				lee.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "" + "\nNo se ha encontrado el archivo", "Oops",
					JOptionPane.WARNING_MESSAGE);
		}

		return texto;
	}

	public void guardarArchivo(JTextPane area) {
		try {
			String nombre = "";
			JFileChooser file = new JFileChooser();
			file.showSaveDialog(this);
			File guarda = file.getSelectedFile();

			if (guarda != null) {
				FileWriter save = new FileWriter(guarda + ".txt");
				save.write(area.getText());
				save.close();
				JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
