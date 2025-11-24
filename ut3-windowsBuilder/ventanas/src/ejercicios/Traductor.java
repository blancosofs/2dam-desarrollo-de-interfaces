package ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import extraerPalabra.TraductorLibrerias2;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Traductor {

	private JFrame frame;
	private JTextField textField_esp;
	private JLabel lbl_esp;
	private JTextField textField_eng;
	private JLabel lbl_error;
	private JLabel lbl_errorNulo;
	private JButton btn_exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traductor window = new Traductor();
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
	public Traductor() {
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

		JLabel lbl_msgBienvenida = new JLabel("Hola! \r\n Bienvenido al traductor!!");
		lbl_msgBienvenida.setBounds(34, 30, 273, 34);
		frame.getContentPane().add(lbl_msgBienvenida);

		textField_esp = new JTextField();
		textField_esp.setBounds(81, 87, 86, 20);
		frame.getContentPane().add(textField_esp);
		textField_esp.setColumns(10);

		lbl_esp = new JLabel("Español: ");
		lbl_esp.setBounds(35, 90, 74, 14);
		frame.getContentPane().add(lbl_esp);

		JLabel lbl_eng = new JLabel("Ingles: ");
		lbl_eng.setBounds(262, 90, 46, 14);
		frame.getContentPane().add(lbl_eng);
		lbl_eng.setVisible(false);

		textField_eng = new JTextField();
		textField_eng.setColumns(10);
		textField_eng.setBounds(299, 87, 86, 20);
		frame.getContentPane().add(textField_eng);
		textField_eng.setVisible(false);

		lbl_error = new JLabel("ERROR. PALABRA INVALIDA, CARACTERES DE A-Z");
		lbl_error.setForeground(Color.RED);
		lbl_error.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_error.setBounds(20, 189, 227, 14);
		frame.getContentPane().add(lbl_error);
		lbl_error.setVisible(false);

		JButton btn_traducir = new JButton("TRADUCIR");
		btn_traducir.setBounds(148, 145, 129, 23);
		frame.getContentPane().add(btn_traducir);
		
		btn_exit = new JButton("x");
		btn_exit.setEnabled(false);
		btn_exit.setBorder(null);
		btn_exit.setBackground(Color.RED);
		btn_exit.setBounds(399, 11, 25, 25);
		frame.getContentPane().add(btn_exit);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			System.exit(0);
			}
		});
		btn_exit.setEnabled(false);

		btn_traducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String esp = textField_esp.getText();
					lbl_errorNulo.setVisible(false);
					lbl_error.setVisible(false);
					if (validarString(esp)) {
						String web = "https://www.spanishdict.com/translate/" + esp;
						Document doc = Jsoup.connect(web).get();
						Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);

						String resultado = palabra.html().toUpperCase();

						lbl_eng.setVisible(true);
						textField_eng.setVisible(true);

						textField_eng.setText(resultado);
						textField_eng.setEnabled(false);
					} else {
						lbl_error.setVisible(true);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public static boolean validarString(String esp) {
		// ^ --> principio, $ --> final, [a-zA-Z] --> solo esos caracteres , + --> que te repita el filtro por cada caracter
		Pattern pattern = Pattern.compile("^([a-zA-Z]+)$");
		Matcher matcher = pattern.matcher(esp);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

}
