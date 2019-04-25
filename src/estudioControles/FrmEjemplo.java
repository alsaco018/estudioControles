package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEjemplo extends JFrame {

	private JPanel Panel;
	private JLabel lblTitulo, lblAutor, lblEditorial; 
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditorial;
	private JButton btnAceptar;
	private JLabel lblMostrar;
	/**
	 * Create the frame.
	 */
	public FrmEjemplo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Panel.setLayout(new BorderLayout(0, 0));
		setContentPane(Panel);
		
		Panel.setLayout(null);
		definirVentana();
		definirEventos();
		setVisible(true);
		
	}

	private void definirEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMostrar.setText(textTitulo.getText());
			}
		});
	}

	private void definirVentana() {
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblTitulo.setBounds(26, 43, 46, 14);
		Panel.add(lblTitulo);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblAutor.setBounds(26, 68, 46, 14);
		Panel.add(lblAutor);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblEditorial.setBounds(26, 93, 46, 14);
		Panel.add(lblEditorial);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(96, 40, 86, 20);
		Panel.add(textTitulo);
		textTitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(96, 65, 86, 20);
		Panel.add(textAutor);
		textAutor.setColumns(10);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(96, 90, 86, 20);
		Panel.add(textEditorial);
		textEditorial.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(93, 137, 89, 23);
		Panel.add(btnAceptar);
		
		lblMostrar = new JLabel("");
		lblMostrar.setBounds(236, 43, 188, 207);
		Panel.add(lblMostrar);
	}
}
