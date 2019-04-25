package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTablaMultiplicar2 extends JFrame {

	private JPanel contentPane;
	private int n, nCompletadas = 0, nAciertos;
	private boolean[] completado = new boolean[11];
	private List<JLabel> etiquetas = new ArrayList<JLabel>();
	private List<JTextField> textos = new ArrayList<JTextField>(); 
	private JButton btnCorregir, btnNuevaTabla;
	private JLabel lblNumeroDeAciertos;
	private JLabel lblTablaDeMultiplicar;
	/**
	 * Create the frame.
	 */
	public FrmTablaMultiplicar2() {
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
			
			setVisible(true);	
	}

	private void definirEventos() {
		btnCorregir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nAciertos = corregir(n);
				lblNumeroDeAciertos.setText("Numero de aciertos: "+nAciertos);
			}
		});
		
		btnNuevaTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				completado[n] = true;
				nCompletadas++;
				nAciertos = 0;
				n = (int) (Math.random()*10);
				nuevaTabla(n);
				borrar();
			}

			
		});
	}

	private void borrar() {
		for(int i = 0; i <= 10; ++i) {
			
			switch(i) {
			case 0:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;
			case 1:
				textos.get(i).setBackground(Color.white); textos.get(i).setText("");break;	
			case 2:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;	
			case 3:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;	
			case 4:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;
			case 5:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;
			case 6:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;
			case 7:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;
			case 8:
				textos.get(i).setBackground(Color.white); textos.get(i).setText(""); break;

			case 9:
				textos.get(i).setBackground(Color.white); textos.get(i).setText("");break;
			case 10:
				textos.get(i).setBackground(Color.white); textos.get(i).setText("");lblNumeroDeAciertos.setText("");break;
			}
		}
		
	}
	private void nuevaTabla(int n) {
		if(!completado[n]) {
			etiquetas.get(0).setText(n+"x 0 = ");
			etiquetas.get(1).setText(n+"x 1 = ");
			etiquetas.get(2).setText(n+"x 2 = ");
			etiquetas.get(3).setText(n+"x 3 = ");
			etiquetas.get(4).setText(n+"x 4 = ");
			etiquetas.get(5).setText(n+"x 5 = ");
			etiquetas.get(6).setText(n+"x 6 = ");
			etiquetas.get(7).setText(n+"x 7 = ");
			etiquetas.get(8).setText(n+"x 8 = ");
			etiquetas.get(9).setText(n+"x 9 = ");
			etiquetas.get(10).setText(n+"x 10 = ");
		}else {
			if(nCompletadas <= 11) {
				this.n = (int) (Math.random()*10);
				this.nuevaTabla(this.n);
			}else {
				//cerrarVentana();
			}
		}
	}

	private void definirVentana() {
		int n = (int) (Math.random()*10);
		String[] tabla = crearTabla(n);
		int posicionY = 43, posicionX = 26;
		
		for(int i= 0; i < tabla.length; ++i) {
			JLabel lbli = new JLabel(tabla[i]);
			lbli.setFont(new Font("Verdana", Font.PLAIN, 12));
			lbli.setBounds(26, posicionY, 60, 14);
			etiquetas.add(lbli);
			contentPane.add(lbli);
			JTextField texti = new JTextField();
			texti = new JTextField();
			texti.setBounds((posicionX +55), posicionY, 86, 20);
			texti.setColumns(10);
			textos.add(texti);
			contentPane.add(texti);
			posicionY += 25;
		}
		
		btnCorregir = new JButton("Corregir");
		btnCorregir.setBounds(418, 84, 89, 23);
		contentPane.add(btnCorregir);
		
		btnNuevaTabla = new JButton("Nueva tabla");
		btnNuevaTabla.setBounds(418, 211, 100, 23);
		contentPane.add(btnNuevaTabla);
		
		lblNumeroDeAciertos = new JLabel("");
		lblNumeroDeAciertos.setBounds(381, 340, 137, 14);
		contentPane.add(lblNumeroDeAciertos);
		
		lblTablaDeMultiplicar = new JLabel("Tablas de multiplicar");
		lblTablaDeMultiplicar.setForeground(Color.BLUE);
		lblTablaDeMultiplicar.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblTablaDeMultiplicar.setBounds(233, 11, 215, 51);
		contentPane.add(lblTablaDeMultiplicar);
	}



	private String[] crearTabla(int n) {
		String[] tabla = new String[11];
		for(int i = 0; i < tabla.length; i++) {
			if(i < 10) {
				tabla[i] = n+" x "+i+"   = ";
			}else {
				tabla[i] = n+" x "+i+" = ";
			}
		}
		return tabla;
	}
	
	private int corregir(int n) {
		String[] resultados = new String[11];	//guardamos los resultados escritos por el usuario
		int[] correctos = new int[11];			//guardamos los resultados reales
		int nAciertos = 0;
		String escrito = "";
		
		for(int i = 0; i <= 10; ++i) {
			escrito = textos.get(i).getText();    //primero obtenemos los resultados escritos en los distintos campos de texto
			switch(i) {
			case 0:
				resultados[i] =  escrito ;break;
			case 1:
				resultados[i] = escrito;break;
			case 2:
				resultados[i] = escrito;break;
			case 3:
				resultados[i] = escrito;break;
			case 4:
				resultados[i] = escrito;break;
			case 5:
				resultados[i] = escrito;break;
			case 6:
				resultados[i] = escrito;break;
			case 7:
				resultados[i] = escrito;break;
			case 8:
				resultados[i] = escrito;break;
			case 9:
				resultados[i] = escrito;break;
			case 10:
				resultados[i] = escrito;break;
			}
		}
		
		for(int i = 0; i <= 10; ++i) {		//ahora obtenemos los resultados reales
			correctos[i] = n * i;
		}
		
		for(int i = 0; i <= 10; ++i) {		//comprobamos los resultados, si estan bien aumentamos el contador de aciertos y ponemos correcto en las etiquetas de resultado
			int res = 0;
			try{
				res = Integer.parseInt(resultados[i]);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contentPane, "Debe escribir un valor numerico", "ATENCION",JOptionPane.INFORMATION_MESSAGE);
			}
			if(res == correctos[i]) {
				switch(i) {
				case 0:
					textos.get(i).setBackground(Color.GREEN);++nAciertos;break;
				case 1:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;	
				case 2:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;	
				case 3:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;	
				case 4:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 5:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 6:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 7:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 8:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 9:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				case 10:
					textos.get(i).setBackground(Color.GREEN); ++nAciertos;break;
				}
			}else {
				switch(i) {
				case 0:
					textos.get(i).setBackground(Color.red); break;
				case 1:
					textos.get(i).setBackground(Color.red); break;	
				case 2:
					textos.get(i).setBackground(Color.red); break;	
				case 3:
					textos.get(i).setBackground(Color.red); break;	
				case 4:
					textos.get(i).setBackground(Color.red); break;
				case 5:
					textos.get(i).setBackground(Color.red); break;
				case 6:
					textos.get(i).setBackground(Color.red); break;
				case 7:
					textos.get(i).setBackground(Color.red); break;
				case 8:
					textos.get(i).setBackground(Color.red); break;
				case 9:
					textos.get(i).setBackground(Color.red); break;
				case 10:
					textos.get(i).setBackground(Color.red); break;
				}
			}
			
		}
		
		return nAciertos;
	}
}
