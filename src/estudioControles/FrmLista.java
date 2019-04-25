package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrmLista extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane, scrollPane_1;
	private DefaultListModel modelo, modelo2;
	private JList listDiasSemana, listMes;
	private JButton btnAgregar;
	private JTextField textField;
	private String[] meses = new String[12];
	private int[] años = new int[5];
	private JComboBox comboBox, comboBox2;
	private DefaultComboBoxModel modelo3;
	private JComboBox comboBox_1;
	/**
	 * Create the frame.
	 */
	public FrmLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		inicializarMeses();
		inicializarAños();
		definirVentana();
		definirEventos();
		setVisible(true);
	}
	private void inicializarMeses() {
		for(int i = 0; i < meses.length; ++i) {
			switch(i) {
			case 0: meses[i] = "Enero";break;
			case 1: meses[i] = "Febrero";break;
			case 2: meses[i] = "Marzo";break;
			case 3: meses[i] = "Abril";break;
			case 4: meses[i] = "Mayo";break;
			case 5: meses[i] = "Junio";break;
			case 6: meses[i] = "Julio";break;
			case 7: meses[i] = "Agosto";break;
			case 8: meses[i] = "Septiembre";break;
			case 9: meses[i] = "Octubre";break;
			case 10: meses[i] = "Noviembre";break;
			case 11: meses[i] = "Diciembre";break;
			}
		}
	}
	
	private void inicializarAños() {
		for(int i = 0; i < años.length; ++i) {
			switch(i) {
			case 0: modelo3.addElement(2019);break;
			case 1: modelo3.addElement(2020);break;
			case 2: modelo3.addElement(2021);break;
			case 3: modelo3.addElement(2022);break;
			case 4: modelo3.addElement(2023);break;
			
			}
		}
	}
	
	private void definirEventos() {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(textField.getText());
				textField.setText("");
			}
		});
	}
	private void definirVentana() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 29, 91, 83);
		contentPane.add(scrollPane);
		
		modelo = new DefaultListModel();
		listDiasSemana = new JList(modelo);
		listDiasSemana.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo.addElement("Lunes");modelo.addElement("Martes");modelo.addElement("Miercoles"); modelo.addElement("Jueves"); modelo.addElement("Viernes"); modelo.addElement("Sabado"); modelo.addElement("Domingo");
		scrollPane.setViewportView(listDiasSemana);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(268, 29, 91, 83);
		contentPane.add(scrollPane_1);
		
		modelo2 = new DefaultListModel();
		listMes = new JList(modelo2);
		listMes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(int i = 0; i < meses.length; ++i) {
			modelo2.addElement(meses[i]);
		}
		scrollPane_1.setViewportView(listMes);
		
		JLabel lblDiasSemana = new JLabel("Dias de la semana");
		lblDiasSemana.setBounds(48, 4, 119, 14);
		contentPane.add(lblDiasSemana);
		
		JLabel lblDiasDelMes = new JLabel("Dias del mes");
		lblDiasDelMes.setBounds(268, 4, 91, 14);
		contentPane.add(lblDiasDelMes);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(156, 227, 89, 23);
		contentPane.add(btnAgregar);
		
		textField = new JTextField();
		textField.setBounds(159, 196, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		comboBox = new JComboBox(modelo3);
		comboBox.setBounds(50, 170, 91, 23);
		
		
		contentPane.add(comboBox);
		
		JLabel lblAnno = new JLabel("Año");
		lblAnno.setBounds(51, 145, 90, 14);
		contentPane.add(lblAnno);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(52, 204, 89, 23);
		contentPane.add(btnAceptar);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(268, 171, 91, 22);
		contentPane.add(comboBox2);
	}
}
