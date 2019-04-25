package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCompleto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JPanel panelDatosPersonales, panelEstadoCivil, panelLenguajes;
	private JLabel lblNombre, lblApellidos, lblDireccion, lblTelefono, lblPoblacion, lblExperienciaProfesional;
	private JComboBox comboBox;
	private ButtonGroup radios, lenguajes;
	private JRadioButton rdbtnSeparado, rdbtnViudo, rdbtnCasado, rdbtnSoltero;
	private JCheckBox chckbxJava, chckbxC, chckbxPython;
	private JScrollPane scrollPane;
	private JList listSO;
	private DefaultListModel modelo, modelo2;
	private JList listBD;
	private JButton btnAceptar;
	private String curriculum;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	/**
	 * Create the frame.
	 */
	public FrmCompleto() {
		setTitle("Curriculum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 515);
		definirVentana();
		definirEvento();
		
		setVisible(true);
	}




	private void definirEvento() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				curriculum = "- Nombre: \n"+textFieldNombre.getText() + "\n";
				curriculum += "\n- Apellidos: \n"+ textFieldApellidos.getText()+"\n";
				curriculum += "\n- Dirección: \n"+textFieldDireccion.getText()+"\n";
				curriculum += "\n- Teléfono: \n"+textFieldTelefono.getText()+"\n";
				curriculum += "\n- Población: \n"+comboBox.getSelectedItem()+"\n";
				switch(radioSeleccionado()) {
				case 1: curriculum += "\n- Estado Civil: \nSoltero.\n";break;
				case 2: curriculum += "\n- Estado Civil: \nCasado.\n";break;
				case 3: curriculum += "\n- Estado Civil: \nViudo.\n";break;
				case 4: curriculum += "\n- Estado Civil: \nSeparado.\n";break;
				}
				curriculum += "\n- Lenguajes de programación que conoce: \n";
				if(chckbxC.isSelected())
					curriculum += "C++\n";
				if(chckbxJava.isSelected())
					curriculum += "Java\n";
				if(chckbxPython.isSelected())
					curriculum += "Python\n";
				curriculum += "\n- Sistema Operativo que utiliza:\n" + listSO.getSelectedValue()+"\n";
				curriculum += "\n- Gestor de Base de datos que utiliza: \n"+ listBD.getSelectedValue()+"\n";
				curriculum += "\n- Experiencia profesional: \n";
				curriculum += textArea.getText();
				
				FrmResultadoCompleto nuevoFrm = new FrmResultadoCompleto(curriculum);

				
			}

			
		});
	}



	private int radioSeleccionado() {
		if(rdbtnSoltero.isSelected())
			return 1;
		else if(rdbtnCasado.isSelected())
			return 2;
		else if(rdbtnViudo.isSelected())
			return 3;
		else if(rdbtnSeparado.isSelected())
			return 4;
		return 0;
	}

	private void definirVentana() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDatosPersonales= new JPanel();
		panelDatosPersonales.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosPersonales.setToolTipText("Datos personales");
		panelDatosPersonales.setBounds(10, 47, 257, 155);
		contentPane.add(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 22, 54, 14);
		panelDatosPersonales.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(74, 19, 115, 20);
		panelDatosPersonales.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 47, 60, 14);
		panelDatosPersonales.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(74, 44, 173, 20);
		panelDatosPersonales.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 72, 60, 14);
		panelDatosPersonales.add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(74, 69, 173, 20);
		panelDatosPersonales.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(10, 97, 54, 14);
		panelDatosPersonales.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(74, 94, 173, 20);
		panelDatosPersonales.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		lblPoblacion = new JLabel("Población: ");
		lblPoblacion.setBounds(10, 122, 97, 14);
		panelDatosPersonales.add(lblPoblacion);
		
		comboBox = new JComboBox();
		comboBox.setBounds(74, 118, 115, 22);
		comboBox.addItem("Jerez de la frontera"); comboBox.addItem("El Puerto de Sta. María"); comboBox.addItem("Trebujena");
		panelDatosPersonales.add(comboBox);
		
		
		
		panelEstadoCivil = new JPanel();
		panelEstadoCivil.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Estado Civil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEstadoCivil.setBounds(10, 227, 103, 127);
		contentPane.add(panelEstadoCivil);
		panelEstadoCivil.setLayout(null);
		
		radios = new ButtonGroup();
		
		rdbtnSoltero = new JRadioButton("Soltero");
		rdbtnSoltero.setBounds(6, 22, 91, 23);
		panelEstadoCivil.add(rdbtnSoltero);
		radios.add(rdbtnSoltero);
		
		rdbtnCasado = new JRadioButton("Casado");
		rdbtnCasado.setBounds(6, 48, 91, 23);
		panelEstadoCivil.add(rdbtnCasado);
		radios.add(rdbtnCasado);

		
		rdbtnViudo = new JRadioButton("Viudo");
		rdbtnViudo.setBounds(6, 74, 91, 23);
		panelEstadoCivil.add(rdbtnViudo);
		radios.add(rdbtnViudo);

		
		rdbtnSeparado = new JRadioButton("Separado");
		rdbtnSeparado.setBounds(6, 97, 91, 23);
		panelEstadoCivil.add(rdbtnSeparado);
		radios.add(rdbtnSeparado);

		
		panelLenguajes = new JPanel();
		panelLenguajes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lenguajes programación", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLenguajes.setBounds(123, 252, 163, 102);
		contentPane.add(panelLenguajes);
		panelLenguajes.setLayout(null);
		
		chckbxJava = new JCheckBox("Java");
		chckbxJava.setBounds(6, 21, 97, 23);
		panelLenguajes.add(chckbxJava);
		
		chckbxC = new JCheckBox("C++");
		chckbxC.setBounds(6, 47, 97, 23);
		panelLenguajes.add(chckbxC);
		
		chckbxPython = new JCheckBox("Python");
		chckbxPython.setBounds(6, 73, 97, 23);
		panelLenguajes.add(chckbxPython);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 57, 131, 72);
		contentPane.add(scrollPane);
		
		modelo = new DefaultListModel();
		
		listSO = new JList(modelo);
		modelo.addElement("Windows 7"); modelo.addElement("Linux"); modelo.addElement("Windows Server"); modelo.addElement("Android");
		scrollPane.setViewportView(listSO);
		
		modelo2 = new DefaultListModel();
		listBD = new JList(modelo2);
		listBD.setBounds(296, 252, 71, 102);
		modelo2.addElement("MySql"); modelo2.addElement("Oracle"); modelo2.addElement("Access");
		contentPane.add(listBD);
		
		lblExperienciaProfesional = new JLabel("Experiencia Profesional:");
		lblExperienciaProfesional.setBounds(377, 199, 193, 14);
		contentPane.add(lblExperienciaProfesional);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 389, 89, 23);
		contentPane.add(btnAceptar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 227, 291, 238);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
	}
}
