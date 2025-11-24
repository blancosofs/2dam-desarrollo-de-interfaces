package windowsBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
/*newwwwwwwwwwwwwwwwww*/
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Ejemplo2 {

	private JFrame frame;
	private JTextField textField;
	/**/
	private int contador=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 window = new Ejemplo2();
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
	public Ejemplo2() {
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
		frame.setBounds(100, 100, 660, 460);
		/*centrar ventana*/
		//no es lo que toca pero funciona
		//frame.setLocationRelativeTo(null);
		//(resolucion_x/2)-(miVentana_x/2),(resolucion_y/2)-(miVentana_y/2)
		frame.setLocation((width/2-frame.getWidth()/2),(height/2-frame.getHeight()/2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 102));
		frame.getContentPane().add(panel, "name_13536983937000");
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 255));
		frame.getContentPane().add(panel_1, "name_13536972418200");
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 153, 255));
		frame.getContentPane().add(panel_2, "name_13536958674000");
		panel_2.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(39, 365, 89, 23);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Next");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(523, 365, 89, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("¡¡ GRACIAS !!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel_1.setBounds(173, 148, 302, 95);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("NEXT ->");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(491, 366, 116, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<- VOLVER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(36, 366, 116, 23);
		panel_1.add(btnNewButton_3);
		
		
		
		JButton btnNewButton = new JButton("+ CLICK +");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contador++;
				textField.setText(Integer.toString(contador));
			}
		});
		btnNewButton.setBounds(192, 194, 89, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(331, 195, 121, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NÚMERO DE CLICKS");
		lblNewLabel.setBounds(331, 172, 121, 20);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("NEXT  -->");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(516, 372, 106, 23);
		panel.add(btnNewButton_1);
	}
}
