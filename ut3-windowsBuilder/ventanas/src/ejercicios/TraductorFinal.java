package ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TraductorFinal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraductorFinal window = new TraductorFinal();
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
	public TraductorFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel_eng = new JPanel();
		panel_eng.setBackground(new Color(147, 112, 219));
		panel_eng.setForeground(new Color(0, 0, 0));
		panel_eng.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_eng);
		panel_eng.setLayout(null);
		
		JPanel panel_esp = new JPanel();
		panel_esp.setBackground(new Color(152, 251, 152));
		panel_esp.setForeground(new Color(255, 255, 255));
		panel_esp.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_esp);
		panel_esp.setLayout(null);
		panel_esp.setVisible(false);
		
		JButton btn_exitEng = new JButton("x");
		btn_exitEng.setBounds(399, 11, 25, 25);
		btn_exitEng.setEnabled(false);
		btn_exitEng.setBorder(null);
		btn_exitEng.setBackground(Color.RED);
		panel_eng.add(btn_exitEng);
		btn_exitEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			System.exit(0);
			}
		});
		btn_exitEng.setEnabled(false);
		
		JLabel lbl_bienvenida = new JLabel("BIENVENIDO AL TRADUCTORl");
		lbl_bienvenida.setBounds(144, 106, 154, 35);
		panel_eng.add(lbl_bienvenida);
		
		JButton btnEngEsp = new JButton("ENG/ESP");
		btnEngEsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_esp.setVisible(true);
			}
		});
		btnEngEsp.setBounds(255, 180, 169, 31);
		panel_eng.add(btnEngEsp);
		
		JButton btnEspEng = new JButton("ESP/ENG");
		btnEspEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_esp.setVisible(true);
			}
		});
		btnEspEng.setBounds(24, 180, 169, 31);
		panel_eng.add(btnEspEng);
		
		JButton btn_exitEsp = new JButton("x");
		btn_exitEsp.setBounds(403, 11, 21, 21);
		btn_exitEsp.setEnabled(false);
		btn_exitEsp.setBorder(null);
		btn_exitEsp.setBackground(Color.RED);
		panel_esp.add(btn_exitEsp);
		btn_exitEsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			System.exit(0);
			}
		});
		btn_exitEsp.setEnabled(false);
		
		JPanel panel_inicio = new JPanel();
		panel_inicio.setBackground(new Color(135, 206, 250));
		panel_inicio.setForeground(new Color(255, 255, 255));
		panel_inicio.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_inicio);
	}
}
