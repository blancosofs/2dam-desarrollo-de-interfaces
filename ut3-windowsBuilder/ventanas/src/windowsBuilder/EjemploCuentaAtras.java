package windowsBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
/*Es este (el de swing)*/
import javax.swing.Timer;

public class EjemploCuentaAtras {

	private JFrame frame;
	/**/
	Timer intervalo;
	int i = 4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploCuentaAtras window = new EjemploCuentaAtras();
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
	public EjemploCuentaAtras() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Rockwell Condensed", Font.PLAIN, 14));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_contador = new JLabel("");
		lbl_contador.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 40));
		lbl_contador.setBounds(121, 113, 50, 51);
		frame.getContentPane().add(lbl_contador);

		JLabel lbl_mensaje = new JLabel("¡ FELIZ PUENTE :p !");
		lbl_mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mensaje.setOpaque(true);
		lbl_mensaje.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lbl_mensaje.setForeground(new Color(0, 0, 0));
		lbl_mensaje.setBackground(new Color(153, 204, 255));
		lbl_mensaje.setBounds(32, 25, 245, 77);
		frame.getContentPane().add(lbl_mensaje);
		/**/
		lbl_mensaje.setVisible(false);

		JButton btn_start = new JButton("START");
		btn_start.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btn_start.setBounds(286, 178, 123, 51);
		frame.getContentPane().add(btn_start);
		
		JButton btn_exit = new JButton("x");
		btn_exit.setBorder(null);
		btn_exit.setBackground(new Color(255, 0, 0));
		btn_exit.setBounds(383, 25, 26, 23);
		frame.getContentPane().add(btn_exit);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**/
				
			frame.dispose();//liberas todo lo que has cargado
			System.exit(0);
			}
		});
		btn_exit.setEnabled(false);
		
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 lbl_mensaje.setVisible(false); i=4;
				 */
				intervalo.start();
			}
		});

		/**/
		intervalo = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				i--;
				lbl_contador.setText(String.valueOf(i));
				if (i == 0) {
					intervalo.stop();
					lbl_mensaje.setVisible(true);
					btn_start.setEnabled(false);
					btn_exit.setEnabled(true);
				}

			}
		});

	}
}
