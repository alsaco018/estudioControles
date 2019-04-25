package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class FrmCajasTexto extends JFrame {

	private JPanel panel;
	private JButton btnCalcular;
	private JLabel lblInformacion;
	private JTextField textImporte;
	private JTextField textDescuento;
	private JTextField textTotal;
	private JLabel lblTeclado;
	private JLabel lblPropiedades;
	private JFormattedTextField formattedTextField;
	private int importe;
	/**
	 * Create the frame.
	 */
	public FrmCajasTexto() {
		super("Demostración de JTextField");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		definirVentana();
		definirEventos();
		this.setVisible(true);
		
	}

	private void definirEventos() {
		textImporte.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				lblInformacion.setText(e.getActionCommand());
				try {
					Integer x = 0;
					importe = x.parseInt(e.getActionCommand());
					textDescuento.requestFocus();
				}catch(Exception e2) {
					lblInformacion.setText("Introduzca un valor correcto");
					textImporte.setText("");
				}
			}
		});
		
		textDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblTeclado.setText("Caracter: "+e.getKeyChar()+" Codigo: "+e.getKeyCode());
				System.out.println("KeyPressed");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				lblTeclado.setText("Caracter: "+e.getKeyChar()+" Codigo: "+e.getKeyCode());
				System.out.println("KeyReleased");
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("KeyTyped");
				char caracter = e.getKeyChar();
				
				if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != 44)) {
					e.consume();
				}
				lblTeclado.setText("Caracter: "+e.getKeyChar()+" Codigo: "+e.getKeyCode());
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInformacion.setText("");
				double importe, total; int iva;
				try {
					importe = Double.parseDouble(textImporte.getText());
					iva = Integer.parseInt(textDescuento.getText());
					double iv = importe * iva / 100;
					total = importe + iv;
					textTotal.setText(Double.toString(total));
					lblPropiedades.setText(formattedTextField.getText());
		
				}catch(Exception e2) {
					lblInformacion.setText("Introduzca un valor correcto");
				}
			}
		});
		
		
	}

	private void definirVentana() {
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setBounds(10,34,73,78);
		panel.setLayout(new GridLayout(0, 1));
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblImporte);
		
		JLabel lblDescuento = new JLabel("Iva:");
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblDescuento);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblTotal);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(52,124,89,23);
		getContentPane().add(btnCalcular);
		
		lblInformacion = new JLabel("************");
		lblInformacion.setBounds(225,34,194,14);
		getContentPane().add(lblInformacion);
		
		textImporte = new JTextField();
		textImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		textImporte.setBounds(93,34,86,20);
		getContentPane().add(textImporte);
		textImporte.setColumns(10);
		
		textDescuento = new JTextField();
		textDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		textDescuento.setBounds(93,65,86,20);
		getContentPane().add(textDescuento);
		textDescuento.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotal.setBounds(93,92,86,20);
		getContentPane().add(textTotal);
		textTotal.setColumns(10);
		
		lblTeclado = new JLabel("Evento de teclado");
		lblTeclado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTeclado.setBounds(233,71,141,14);
		getContentPane().add(lblTeclado);
		
		lblPropiedades = new JLabel("Dni");
		lblPropiedades.setBounds(230,192,144,14);
		getContentPane().add(lblPropiedades);
		
		JLabel lblFormateo = new JLabel("Formateo");
		lblFormateo.setBounds(233,223,60,14);
		getContentPane().add(lblFormateo);
		
		MaskFormatter maskDNI;
		try {
			//maskDNI = new MaskFormatter("*@*.com");
			maskDNI = new MaskFormatter("##.###.###-?");
			MaskFormatter mascara = new MaskFormatter();
			formattedTextField = new JFormattedTextField(maskDNI);
			formattedTextField.setBounds(289,220,89,23);
			getContentPane().add(formattedTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
