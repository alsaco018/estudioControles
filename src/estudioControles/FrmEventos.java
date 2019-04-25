package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEventos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnReenviar, btnEnviar;
	private JLabel lblEtiqueta;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEventos frame = new FrmEventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FrmEventos() {
		this.definirVentana();
		this.definirEventos();
		
	}

	private void definirEventos() {
		btnEnviar.addActionListener(this);			//los eventos de accion los va a controlar el propio objeto, en este caso el formulario.
		
		btnReenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEtiqueta.setText("Ha pulsado el boton REENVIAR");
			}
		});
	}

	private void definirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 98);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 405, 59);
		contentPane.add(panel);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setActionCommand("enviar"); 				//su nombre en clave cuando pulse enviar es enviar
		btnReenviar = new JButton("Reenviar");
		
		
		lblEtiqueta = new JLabel();
		
		panel.add(btnEnviar);
		panel.add(btnReenviar);
		panel.add(lblEtiqueta);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		//la clase actionEvent contiene informacion sobre el objeto que ha provocado el evento
		/*if(e.getSource() == btnEnviar) {
			lblEtiqueta.setText("Ha pulsado el boton ENVIAR");
		}*/
		
		if(e.getActionCommand().equals("enviar")) {
			lblEtiqueta.setText("Ha pulsado el boton ENVIAR");
		}
		
	}
}
