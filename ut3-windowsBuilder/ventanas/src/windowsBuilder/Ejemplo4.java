package windowsBuilder;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ejemplo4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo4 window = new Ejemplo4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejemplo4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		/* Ruta relativa */
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ejemplo4.class.getResource("/kirbyIcon.png")));
		frame.setBounds(100, 100, 900, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Añadir panel Connection imagen */
		frame.getContentPane().add(buscarImagen());
	}

	private Component buscarImagen() {
		BufferedImage fondo = null;
		/* Cargar la imagen */
		try {
			fondo = ImageIO.read(new File("SRC/fondoKirby.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* Asignar la imagen a un jpanel */
	    final Image foto = fondo;
		JPanel panelConFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 900, 560, null);
			}
		};

		return panelConFondo;
	}

}
