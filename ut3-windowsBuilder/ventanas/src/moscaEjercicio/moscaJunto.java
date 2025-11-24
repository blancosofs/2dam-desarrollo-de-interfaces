package moscaEjercicio;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class moscaJunto {

	private JFrame frame;
	private JLabel lbl_mosca;
	private JLabel lbl_msgLbl_mosca;
	private JLabel lbl_msgCursor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moscaJunto window = new moscaJunto();
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
	public moscaJunto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Random rand = new Random();
		frame = new JFrame();
		frame.getContentPane().setLayout(null); //importante
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(buscarImagen());
		
		lbl_msgCursor = new JLabel("");
		lbl_msgCursor.setBounds(43, 508, 333, 14);
		frame.getContentPane().add(lbl_msgCursor);
		
		lbl_msgLbl_mosca = new JLabel("");
		lbl_msgLbl_mosca.setBounds(441, 508, 309, 14);
		frame.getContentPane().add(lbl_msgLbl_mosca);
		/*
		 * SOL POSIBLES pillar la xey del raton pillar xey de la imagen si se igualan
		 * cambia la xey de la imagen
		 * 
		 * -- tienes que tener tmb una zona de seguridad restas la zoa a xey de la
		 * imagen si se acerca cambias su xey
		 */
		frame.addMouseMotionListener(new MouseMotionAdapter() { // clase adaptadora
			@Override // sobreeescribes pero no te hace falta que sea todo
			public void mouseMoved(MouseEvent e) {
				/* posicion raton (sacas donde esta el cursor)*/
				int ratonX = e.getX();
				int ratonY = e.getY();
				lbl_msgCursor.setText("POSICION CURSOR: "+" en x --> "+ratonX+" , "+" en y --> "+ratonY);

				/* posicion imagen */
				int labelX = lbl_mosca.getX();
				int labelY = lbl_mosca.getY();
				lbl_msgLbl_mosca.setText("POSICION IMAGEN: "+" en x --> "+labelX+" , "+" en y --> "+labelY);
				
				/* anchoAlto de la imagen */
				int labelW = lbl_mosca.getWidth();
				int labelH = lbl_mosca.getHeight();

				/* limite del marco */
				int distanEnX = Math.abs(ratonX - labelX);
				int distanEnY = Math.abs(ratonY - labelY);
				int limite = 75;

				/* zona seguridad */
				if (distanEnX < limite || distanEnY < limite) {
					
					/*nueva posicion donde se va a mover*/
					int moverX = rand.nextInt(101) - 50; //el 101 es el rango que puedes pillar
					int moverY = rand.nextInt(101) - 50;
					
					/*nuevas coordenadas donde se va a mover, comprobadas*/
					int nuevoX=Math.max(0, Math.min(labelX+moverX, frame.getWidth()-2*labelW));
					int nuevoY=Math.max(0, Math.min(labelY+moverY, frame.getHeight()-2*labelH));
					//nueva coordenada en x e y 
					//el maximo entre 0  y te mueves entre si vas a salir del frame (donde estas mas el valor)
					//2*labelW esto es para que no se quede en la mitad cuando llegue al borde
					//Math abs es para que no meta negativos
					
					/*que salte*/
					lbl_mosca.setLocation(nuevoX, nuevoY);
				}

			}
		});

	}

	private Component buscarImagen() {
		BufferedImage fondo = null;
		/* Cargar la imagen */
		try {
			fondo = ImageIO.read(new File("SRC/moscaFinal.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* Asignar la imagen a un jpanel */
		final Image foto = fondo;
		lbl_mosca = new JLabel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 100, 100, null);
			}

		};
		/*nuevos limites de lbl (la imagen)*/
		lbl_mosca.setBounds(0, 0, 100, 100); //esto es pque ahora que lo tienes absolute y se puede ir donde sea le teines qeu decir que vuelva
		return lbl_mosca;
	}

}
