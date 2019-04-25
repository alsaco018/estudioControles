package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBingo extends JFrame {

	private JPanel contentPane;
	private JLabel lblNumeroSeleccionado;
	private JButton btnManual, btnBoleto;
	private int[] numeros = new int[90], numerosSalidos = new int[90];						//numeros que vamos a tener en el bingo
	private ButtonGroup radios;
	private JRadioButton rdbtnAutomatico, rdbtnManual; 
	private List<JButton> salidos = new ArrayList<JButton>();
	private JFrame frame;
	private int contadorSalidos = 0, nCarton = 1;
	
	
	private List<Carton> cartones = new ArrayList<Carton>();
	private List<FrmBoleto> cartonesActualizados = new ArrayList<FrmBoleto>();
	/**
	 * Create the frame.
	 */
	public FrmBingo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 517);
		
		definirVentana();
		definirEventos();
		
		setVisible(true);
	}
	
	

	
	private void generaCartones() {
		
			Carton carton = new Carton();
			cartones.add(carton);
		
	}




	private void inicializarNumeros() {							//inicializamos el array de numeros
		for(int i = 0; i < 90; ++i) {
			numeros[i] = i+1;
		}
	}
	
	private int generarNumero() {							//método que genera un numero aleatorio entre 1 y 90 y que no hayamos cogido anteriormente en la apuesta.
		int n = 0;
		do{
			n = (int) ((Math.random()*90)+1);
		}while(repetido(n, numerosSalidos));
		return n;
	}


	private boolean repetido(int n, int[] numeros2) {
					//Comprobamos que no esté repetido en los numeros que ya han salido
		if(numeros2[n-1] == n)
			return true;
		return false;
	}


	private void definirVentana() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.cyan);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumeroSeleccionado = new JLabel("");
		lblNumeroSeleccionado.setFont(new Font("Magneto", Font.PLAIN, 48));
		lblNumeroSeleccionado.setBounds(218, 29, 204, 98);
		contentPane.add(lblNumeroSeleccionado);
		
		btnManual = new JButton("Manual");
		btnManual.setBounds(422, 104, 89, 23);
		btnManual.setEnabled(false);
		contentPane.add(btnManual);
		
		radios = new ButtonGroup();
		
		/*rdbtnAutomatico= new JRadioButton("Automático");
		rdbtnAutomatico.setBounds(6, 67, 109, 23);
		rdbtnAutomatico.setBackground(Color.CYAN);
		radios.add(rdbtnAutomatico);
		contentPane.add(rdbtnAutomatico);*/
		
		rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setBounds(6, 104, 109, 23);
		rdbtnManual.setBackground(Color.CYAN);
		radios.add(rdbtnManual);
		contentPane.add(rdbtnManual);
		
		btnBoleto = new JButton("Cartón");
		btnBoleto.setBounds(422, 29, 89, 23);
		contentPane.add(btnBoleto);
		
		int cont = 1, posicionX, posicionY = 144;
		for(int fila = 0; fila < 9; ++fila) {
			posicionX = 5;
			for(int colum = 0; colum < 10; ++colum) {
				JButton btni = new JButton("");//String.valueOf(cont));
				btni.setBounds(posicionX, posicionY, 55 , 35);
				btni.setFont(new Font("Magneto", Font.PLAIN, 13));
				btni.setBackground(Color.white);
				salidos.add(btni);
				contentPane.add(btni);
				++cont;
				posicionX += 55;
			}
			posicionY += 35;
		}
		
		
	}

	private void automatico() {
		
			int posicionNumero = generarNumero();					//generamos un numero cada vez que pulsamos el boton
			numerosSalidos[posicionNumero-1] = posicionNumero;		//actualizamos el array de numeros que ya han salido
			lblNumeroSeleccionado.setText(String.valueOf(posicionNumero));	//Mostramos dicho numero
			salidos.get(posicionNumero-1).setText(String.valueOf(posicionNumero));
			contadorSalidos++;
			
	}
	private void borrarCarton(int[][] carton) {						//borramos el carton que hemos generado para crear uno nuevo
		for(int fila = 0; fila < carton.length; ++fila) {
			for(int colum = 0; colum < carton[fila].length; ++colum) {
				carton[fila][colum] = 0;
			}
		}
		
	}
	

	private void compruebaNumerosSalidos(int[] numerosSalidos, List<Carton> cartones) {
		for(int i = 0; i < cartones.size(); ++i) {	//recorremos el array en busca de los numeros salidos
			Carton cartonActual = cartones.get(i);
			for(int j = 0; j < 90; ++j) {
				if(numerosSalidos[j] != 0) {
					
					cartonActual.actualizarCarton(j+1);
				}
			}
			FrmBoleto cartonActualizado = cartonesActualizados.get(i);
			cartonActualizado.actualizarCarton(cartonActual.getNumerosEnCarton());
		}
		
	}


	private void definirEventos() {
		
		btnBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generaCartones();
				String titulo = "Carton numero "+nCarton;
				Carton carton = cartones.get(nCarton-1);
				FrmBoleto boleto = new FrmBoleto(carton.getCarton(), titulo);
				cartonesActualizados.add(boleto);
				++nCarton;
				
			}

			
		});
		
		/*rdbtnAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnAutomatico.isSelected()) {					//si el radio de automatico esta seleccionado deshabilitamos el boton de manual
					btnManual.setEnabled(false);
					
						try {
							Thread.sleep(3000);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						while(contadorSalidos != 90) {
							automatico();
							
							
						}
							JOptionPane.showMessageDialog(frame, "Ya han salido todos los números.", "TERMINADO",JOptionPane.INFORMATION_MESSAGE);
							contadorSalidos++;
				}
					
				
			}

			
		});*/
		
		rdbtnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnManual.isSelected()) {						//si el radio de manual esta seleccionado habilitamos el boton de manual
					btnManual.setEnabled(true);
				}
			}
		});
		
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contadorSalidos != 90) {
					int posicionNumero = generarNumero();					//generamos un numero cada vez que pulsamos el boton
					numerosSalidos[posicionNumero-1] = posicionNumero;		//actualizamos el array de numeros que ya han salido
					lblNumeroSeleccionado.setText(String.valueOf(posicionNumero));	//Mostramos dicho numero
					lblNumeroSeleccionado.setForeground(Color.RED);
					salidos.get(posicionNumero-1).setText(String.valueOf(posicionNumero));
					compruebaNumerosSalidos(numerosSalidos, cartones);
					contadorSalidos++;
				}else {
					JOptionPane.showMessageDialog(frame, "Ya han salido todos los números.", "TERMINADO",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}

		});
	}
}
