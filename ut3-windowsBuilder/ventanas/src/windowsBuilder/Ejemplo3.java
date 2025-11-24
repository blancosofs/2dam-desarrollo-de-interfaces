package windowsBuilder;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo3 {
private JPanel panel_rosa;
private JPanel panel_verde;
private JPanel panel_morado;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo3 window = new Ejemplo3();
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
	public Ejemplo3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) monitor.getHeight();
		int width = (int) monitor.getWidth();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocation((width/2-frame.getWidth()/2),(height/2-frame.getHeight()/2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(layeredPane);
		
		/***********************************/
		panel_verde = new JPanel();
		panel_verde.setBackground(new Color(0, 153, 153));
		panel_verde.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_verde);
		panel_verde.setLayout(null);
		

		JButton btnVerde_Morado = new JButton("Cambiar panel Morado");
		btnVerde_Morado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_verde.setVisible(false);
				panel_morado.setVisible(true);
			}
		});
		
		btnVerde_Morado.setBounds(20, 41, 169, 31);
		panel_verde.add(btnVerde_Morado);

		JButton btnVerde_Rosa = new JButton("Cambiar panel Rosa");
		btnVerde_Rosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_verde.setVisible(false);
				panel_rosa.setVisible(true);
			}
		});
		
		btnVerde_Rosa.setBounds(237, 41, 187, 31);
		panel_verde.add(btnVerde_Rosa);
		
		/***********************************/
		panel_morado = new JPanel();
		panel_morado.setBackground(new Color(102, 102, 204));
		panel_morado.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_morado);
		panel_morado.setLayout(null);
		panel_morado.setVisible(false);


		JButton btnMorado_Rosa = new JButton("Cambiar panel Rosa");
		btnMorado_Rosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_morado.setVisible(false);
				panel_rosa.setVisible(true);
			}
		});
		
		btnMorado_Rosa.setBounds(21, 123, 187, 36);
		panel_morado.add(btnMorado_Rosa);

		JButton btnMorado_Verde = new JButton("Cambiar panel Verde");
		btnMorado_Verde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_morado.setVisible(false);
				panel_verde.setVisible(true);
			}
		});
		
		btnMorado_Verde.setBounds(241, 125, 183, 33);
		panel_morado.add(btnMorado_Verde);
		
		/***********************************/
		panel_rosa = new JPanel();
		panel_rosa.setBackground(new Color(255, 204, 255));
		panel_rosa.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_rosa);
		panel_rosa.setLayout(null);
		panel_rosa.setVisible(false);


		JButton btnRosa_Verde = new JButton("Cambiar panel Verde");
		btnRosa_Verde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_rosa.setVisible(false);
				panel_verde.setVisible(true);
			}
		});
		
		btnRosa_Verde.setBounds(23, 204, 183, 33);
		panel_rosa.add(btnRosa_Verde);

		JButton btnRosa_Morado = new JButton("Cambiar panel Morado");
		btnRosa_Morado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_rosa.setVisible(false);
				panel_morado.setVisible(true);
			}
		});
		
		btnRosa_Morado.setBounds(240, 205, 169, 31);
		panel_rosa.add(btnRosa_Morado);
	}
}
