package javaMail;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EmailVentana {

	private JFrame frame;
	private JTextField textField_destinatario;
	private JPanel panel;
	private JTextArea textArea_cuerpo; 
	private JTextArea textArea_asunto;
	private JButton btn_enviar;
	private JLabel lbl_asunto;
	private JLabel lbl_cuerpo;
	private JLabel lbl_destinatario;
	private JLabel lbl_titulo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailVentana window = new EmailVentana();
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
	public EmailVentana() {
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
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 444, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textArea_cuerpo = new JTextArea();
		textArea_cuerpo.setBounds(39, 153, 371, 41);
		panel.add(textArea_cuerpo);
		
		lbl_asunto = new JLabel("Asunto:");
		lbl_asunto.setBounds(39, 81, 46, 14);
		panel.add(lbl_asunto);
		
		lbl_cuerpo = new JLabel("Cuerpo:");
		lbl_cuerpo.setBounds(39, 138, 46, 14);
		panel.add(lbl_cuerpo);
		
		textArea_asunto = new JTextArea();
		textArea_asunto.setBounds(39, 95, 371, 23);
		panel.add(textArea_asunto);
		
		btn_enviar = new JButton("Enviar");
		btn_enviar.setBounds(188, 216, 89, 23);
		panel.add(btn_enviar);
		btn_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String fromEmail = "sofiablanco.cal@gmail.com"; 
				final String password = "fvtr pbjr czbk jylm"; 
				final String toEmail=textField_destinatario.getText();
				
				Properties props = new Properties();
	
				props.put("mail.smtp.host", "smtp.gmail.com"); 
				props.put("mail.smtp.socketFactory.port", "465");  
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", "465"); 
				Authenticator auth = new Authenticator() {		
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};		
				Session session = Session.getDefaultInstance(props, auth);
			    sendEmail(session, toEmail,textArea_asunto.getText(), textArea_cuerpo.getText());
			}
		});
		
		textField_destinatario = new JTextField();
		textField_destinatario.setBounds(39, 50, 371, 20);
		panel.add(textField_destinatario);
		textField_destinatario.setColumns(10);
		
		lbl_destinatario = new JLabel("Destinatario");
		lbl_destinatario.setBounds(39, 36, 90, 14);
		panel.add(lbl_destinatario);
		
		lbl_titulo = new JLabel("EMAIL");
		lbl_titulo.setBounds(39, 11, 46, 14);
		panel.add(lbl_titulo);
	}

		public static void sendEmail(Session session, String toEmail, String subject, String body){
			try{
		      MimeMessage msg = new MimeMessage(session);

		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");
		      msg.setFrom(new InternetAddress("no_reply@example.com", "SOFIA"));      	      
		      msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));	      
		      msg.setSubject(subject, "UTF-8");
		      msg.setText(body, "UTF-8");
		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));	   

		      Transport.send(msg);

		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		}
	
}
