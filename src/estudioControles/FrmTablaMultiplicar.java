package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class FrmTablaMultiplicar extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnCorregir_1, btnNuevaTabla;
	private JLabel lblX, lblX_1, lblX_2, lblX_3, lblX_4, lblX_5, lblX_6, lblX_7, lblX_8, lblX_9;
	private JLabel lblNaciertos;
	private int n, nCompletadas = 0, nAciertos;
	private boolean[] completado = new boolean[11];
	
	/**
	 * Create the frame.
	 */
	public FrmTablaMultiplicar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for(int i = 0; i < 11; ++i) {				//recorremos el vector de boolean y lo inicializamos a false
			completado[i] = false;
		}
		
		n = (int) (Math.random()*10);
			this.definirVentana();
			this.nuevaTabla(n);
			this.definirEventos();
			//this.borrar();
			setVisible(true);	
		
		
		
		
		
		
		
		
	}



	private void borrar() {
		for(int i = 0; i < 10; ++i) {
			switch(i) {
			case 0:
				textField.setBackground(Color.white); textField.setText(""); break;
			case 1:
				textField_1.setBackground(Color.white); textField_1.setText("");break;	
			case 2:
				textField_2.setBackground(Color.white); textField_2.setText(""); break;	
			case 3:
				textField_3.setBackground(Color.white); textField_3.setText(""); break;	
			case 4:
				textField_4.setBackground(Color.white); textField_4.setText(""); break;
			case 5:
				textField_5.setBackground(Color.white); textField_5.setText(""); break;
			case 6:
				textField_6.setBackground(Color.white); textField_6.setText(""); break;
			case 7:
				textField_7.setBackground(Color.white); textField_7.setText(""); break;
			case 8:
				textField_8.setBackground(Color.white); textField_8.setText(""); break;
			case 9:
				textField_9.setBackground(Color.white); textField_9.setText(""); lblNaciertos.setText("");break;
			}
		}
	}
	
	public void cerrarVentana() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}



	private void nuevaTabla(int n) {
		if(!completado[n]) {
			lblX.setText(n+"x 1 = ");
			lblX_1.setText(n+"x 2 = ");
			lblX_2.setText(n+"x 3 = ");
			lblX_3.setText(n+"x 4 = ");
			lblX_4.setText(n+"x 5 = ");
			lblX_5.setText(n+"x 6 = ");
			lblX_6.setText(n+"x 7 = ");
			lblX_7.setText(n+"x 8 = ");
			lblX_8.setText(n+"x 9 = ");
			lblX_9.setText(n+"x 10 = ");
		}else {
			if(nCompletadas <= 11) {
				this.n = (int) (Math.random()*10);
				this.nuevaTabla(this.n);
			}else {
				cerrarVentana();
			}
		}
		
	}



	private void definirVentana() {
		
		
		lblX = new JLabel(n+"x 1 = ");
		lblX.setBounds(23, 42, 46, 14);
		contentPane.add(lblX);
		
		lblX_1 = new JLabel(n+"x 2 =");
		lblX_1.setBounds(23, 67, 46, 14);
		contentPane.add(lblX_1);
		
		lblX_2 = new JLabel(n+"x 3 =");
		lblX_2.setBounds(23, 92, 46, 14);
		contentPane.add(lblX_2);
		
		lblX_3 = new JLabel(n+"x 4 = ");
		lblX_3.setBounds(23, 117, 46, 14);
		contentPane.add(lblX_3);
		
		lblX_4 = new JLabel(n+"x 5 =");
		lblX_4.setBounds(23, 142, 46, 14);
		contentPane.add(lblX_4);
		
		lblX_5 = new JLabel(n+"x 6 =");
		lblX_5.setBounds(333, 42, 46, 14);
		contentPane.add(lblX_5);
		
		lblX_6 = new JLabel(n+"x 7 =");
		lblX_6.setBounds(333, 67, 46, 14);
		contentPane.add(lblX_6);
		
		lblX_7 = new JLabel(n+"x 8 = ");
		lblX_7.setBounds(333, 92, 46, 14);
		contentPane.add(lblX_7);
		
		lblX_8 = new JLabel(n+"x 9 = ");
		lblX_8.setBounds(333, 117, 46, 14);
		contentPane.add(lblX_8);
		
		lblX_9 = new JLabel(n+"x 10 = ");
		lblX_9.setBounds(333, 145, 46, 14);
		contentPane.add(lblX_9);
		
		textField = new JTextField();
		textField.setBounds(77, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 64, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(77, 89, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(77, 114, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(77, 139, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(380, 36, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(380, 64, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(380, 89, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(380, 114, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(380, 142, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		btnCorregir_1 = new JButton("Corregir");
		btnCorregir_1.setActionCommand("corregir");
		btnCorregir_1.setBounds(105, 283, 89, 23);
		contentPane.add(btnCorregir_1);
		
		
		
		lblNaciertos = new JLabel("");
		lblNaciertos.setBounds(295, 213, 171, 63);
		contentPane.add(lblNaciertos);
		
		btnNuevaTabla = new JButton("Nueva tabla");
		btnNuevaTabla.setBounds(392, 337, 133, 23);
		btnNuevaTabla.setActionCommand("nueva tabla");
		contentPane.add(btnNuevaTabla);
		
	}



	private void definirEventos() {
		btnCorregir_1.addActionListener(this);
		btnNuevaTabla.addActionListener(this);
		
	}



	/*private void definirVentana2() {
		int n = (int) (Math.random()*10);
		String[] tabla = crearTabla(n);
		for(int i= 0; i < tabla.length; ++i) {
			JLabel lbli = new JLabel(tabla[i]);
			lbli.setFont(new Font("Verdana", Font.PLAIN, 12));
			lbli.setBounds(26, 43, 46, 14);
			contentPane.add(lbli);
			JTextField texti = new JTextField();
			texti = new JTextField();
			texti.setBounds(96, 40, 86, 20);
			contentPane.add(texti);
			texti.setColumns(10);
		}
		
		JButton btnCorregir = new JButton("Corregir");
		contentPane.add(btnCorregir);
		
	}



	private String[] crearTabla(int n) {
		String[] tabla = new String[11];
		for(int i = 0; i < tabla.length; i++) {
			tabla[i] = n+" x "+i+" = ";
		}
		return tabla;
	}
*/


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("corregir")) {
			nAciertos = corregir(n);
			lblNaciertos.setText("Numero de aciertos: "+nAciertos);
		}
		if(e.getActionCommand().equals("nueva tabla")) {
			completado[n] = true;
			nCompletadas++;
			nAciertos = 0;
			this.n = (int) (Math.random()*10);
			this.nuevaTabla(this.n);
			this.borrar();
			
		}
		
	}



	



	private int corregir(int n) {
		String[] resultados = new String[10];	//guardamos los resultados escritos por el usuario
		int[] correctos = new int[10];			//guardamos los resultados reales
		int nAciertos = 0;
		
		for(int i = 0; i < 10; ++i) {			//primero obtenemos los resultados escritos
			switch(i) {
			case 0:
				resultados[i] = textField.getText();break;
			case 1:
				resultados[i] = textField_1.getText();break;
			case 2:
				resultados[i] = textField_2.getText();break;
			case 3:
				resultados[i] = textField_3.getText();break;
			case 4:
				resultados[i] = textField_4.getText();break;
			case 5:
				resultados[i] = textField_5.getText();break;
			case 6:
				resultados[i] = textField_6.getText();break;
			case 7:
				resultados[i] = textField_7.getText();break;
			case 8:
				resultados[i] = textField_8.getText();break;
			case 9:
				resultados[i] = textField_9.getText();break;
			}
		}
		
		for(int i = 0; i < 10; ++i) {		//ahora obtenemos los resultados reales
			correctos[i] = n * (i+1);
		}
		
		for(int i = 0; i < 10; ++i) {		//comprobamos los resultados, si estan bien aumentamos el contador de aciertos y ponemos correcto en las etiquetas de resultado
			int res = 0;
			try{
				res = Integer.parseInt(resultados[i]);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contentPane, "Debe escribir un valor numerico", "ATENCION",JOptionPane.INFORMATION_MESSAGE);
			}
			if(res == correctos[i]) {
				switch(i) {
				case 0:
					textField.setBackground(Color.GREEN);++nAciertos;break;
				case 1:
					textField_1.setBackground(Color.GREEN); ++nAciertos;break;	
				case 2:
					textField_2.setBackground(Color.GREEN); ++nAciertos;break;	
				case 3:
					textField_3.setBackground(Color.GREEN); ++nAciertos;break;	
				case 4:
					textField_4.setBackground(Color.GREEN); ++nAciertos;break;
				case 5:
					textField_5.setBackground(Color.GREEN); ++nAciertos;break;
				case 6:
					textField_6.setBackground(Color.GREEN); ++nAciertos;break;
				case 7:
					textField_7.setBackground(Color.GREEN); ++nAciertos;break;
				case 8:
					textField_8.setBackground(Color.GREEN); ++nAciertos;break;
				case 9:
					textField_9.setBackground(Color.GREEN); ++nAciertos;break;
				}
			}else {
				switch(i) {
				case 0:
					textField.setBackground(Color.red); break;
				case 1:
					textField_1.setBackground(Color.red); break;	
				case 2:
					textField_2.setBackground(Color.red); break;	
				case 3:
					textField_3.setBackground(Color.red); break;	
				case 4:
					textField_4.setBackground(Color.red); break;
				case 5:
					textField_5.setBackground(Color.red); break;
				case 6:
					textField_6.setBackground(Color.red); break;
				case 7:
					textField_7.setBackground(Color.red); break;
				case 8:
					textField_8.setBackground(Color.red); break;
				case 9:
					textField_9.setBackground(Color.red); break;
				}
			}
			
		}
		
		return nAciertos;
	}
}
