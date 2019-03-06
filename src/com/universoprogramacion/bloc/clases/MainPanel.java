/**
 * 
 */
package com.universoprogramacion.bloc.clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import com.universoprogramacion.bloc.fileprocesor.FileProcesor;

/**
 * Clase MainPanel: es la lamina base.
 * 
 * @author Marcos
 *
 */
public class MainPanel extends JPanel {
	private JMenu fuente, estilo, tamanio;
	private JTextPane areaTexto;
	private Font font;
	private JTextField fontVisor, styleVisor, sizeVisor;
	private JToolBar barra;

	public MainPanel() {
		Color amarillo = new Color(241, 196, 15);
		Color rojo = new Color(231, 76, 60);
		Color azul = new Color(52, 152, 219);

		setLayout(new BorderLayout());
		// Text Pane
		areaTexto = new JTextPane();
		areaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
		add(areaTexto, BorderLayout.CENTER);

		JMenuBar menuBarPrincipal = new JMenuBar();
		// Font
		fuente = new JMenu("Fuente");
		configura_menu("Arial", "fuente", "Arial", 9, 1, null);
		configura_menu("Monospaced", "fuente", "Monospaced", 9, 1, null);
		configura_menu("Verdana", "fuente", "Verdana", 9, 1, null);
		// Style
		estilo = new JMenu("Estilo");
		configura_menu("Bold", "estilo", "", Font.BOLD, 1, "bin/com/universoprogramacion/bloc/src/icon_bold.png");
		configura_menu("Italic", "estilo", "", Font.ITALIC, 1, "bin/com/universoprogramacion/bloc/src/icon_italic.png");

		tamanio = new JMenu("Tamaño");
		ButtonGroup grupo = new ButtonGroup();
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 12));
		tamanio.add(doce);
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 16));
		tamanio.add(dieciseis);
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 24));
		tamanio.add(veinticuatro);
		JRadioButtonMenuItem cuarenta = new JRadioButtonMenuItem("40");
		cuarenta.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 40));
		tamanio.add(cuarenta);

		grupo.add(doce);
		grupo.add(dieciseis);
		grupo.add(veinticuatro);
		grupo.add(cuarenta);

		menuBarPrincipal.add(fuente);
		menuBarPrincipal.add(estilo);
		menuBarPrincipal.add(tamanio);

		menuBarPrincipal.add(fuente);
		menuBarPrincipal.add(estilo);
		menuBarPrincipal.add(tamanio);

		JPopupMenu popup = new JPopupMenu();
		JMenuItem item1 = new JMenuItem("Bold", new ImageIcon("bin/com/universoprogramacion/bloc/src/icon_bold.png"));
		item1.addActionListener(new StyledEditorKit.BoldAction());
		JMenuItem item2 = new JMenuItem("Italic",
				new ImageIcon("bin/com/universoprogramacion/bloc/src/icon_italic.png"));
		item2.addActionListener(new StyledEditorKit.ItalicAction());
		popup.add(item1);
		popup.add(item2);
		areaTexto.setComponentPopupMenu(popup);
		// -------------------------------------------//
		add(menuBarPrincipal, BorderLayout.NORTH);
		// ----------------------------------------------------------------------------------------------------//
		barra = new JToolBar();

		// bold
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_bold.png")
				.addActionListener(new StyledEditorKit.BoldAction());
		// italic
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_italic.png")
				.addActionListener(new StyledEditorKit.ItalicAction());
		// underline
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_underline.png")
				.addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		// align center
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_align_center.png")
				.addActionListener(new StyledEditorKit.AlignmentAction("align text", StyleConstants.ALIGN_CENTER));
		// align left
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_align_left.png")
				.addActionListener(new StyledEditorKit.AlignmentAction("align text", StyleConstants.ALIGN_LEFT));
		// align right
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_align_right.png")
				.addActionListener(new StyledEditorKit.AlignmentAction("align text", StyleConstants.ALIGN_RIGHT));
		// align justify
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_align_justify.png")
				.addActionListener(new StyledEditorKit.AlignmentAction("align text", StyleConstants.ALIGN_JUSTIFIED));
		barra.addSeparator();
		// color azul
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_azul.png")
				.addActionListener(new StyledEditorKit.ForegroundAction("cambia color", azul));
		// color rojo
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_rojo.png")
				.addActionListener(new StyledEditorKit.ForegroundAction("cambia color", rojo));
		// color amarillo
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_amarillo.png")
				.addActionListener(new StyledEditorKit.ForegroundAction("cambia color", amarillo));

		barra.addSeparator();
		// color amarillo
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_save.png").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileProcesor procesador = new FileProcesor();
				procesador.guardarArchivo(areaTexto);
			}
		});
		configure_bar("bin/com/universoprogramacion/bloc/src/icon_open.png").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileProcesor procesador = new FileProcesor();
				areaTexto.setText(procesador.abrirArchivo());
			}
		});
		barra.setOrientation(SwingConstants.VERTICAL);
		add(barra, BorderLayout.WEST);
	}

	public JButton configure_bar(String path) {
		JButton button = new JButton(new ImageIcon(path));
		barra.add(button);
		return button;
	}

	public void configura_menu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String path) {
		JMenuItem itemMenu = new JMenuItem(rotulo, new ImageIcon(path));

		if (menu == "fuente") {
			fuente.add(itemMenu);
			if (tipoLetra.equals("Arial")) {
				itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambio letra", "Arial"));
			} else if (tipoLetra.equals("Monospaced")) {
				itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambio letra", "Monospaced"));
			} else if (tipoLetra.equals("Verdana")) {
				itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambio letra", "Verdana"));
			}
		} else if (menu == "estilo") {
			estilo.add(itemMenu);
			if (estilos == Font.BOLD) {
				/*
				 * setAccelerator: es para establecer un atajo del teclado. Recibe un KeyStroke
				 */
				itemMenu.setAccelerator(
						KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				itemMenu.addActionListener(new StyledEditorKit.BoldAction());
			} else if (estilos == Font.ITALIC) {
				itemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				itemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		} else if (menu == "tamanio") {
			tamanio.add(itemMenu);
			itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam));
		}
	}
}
