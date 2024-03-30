package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import core.Gramatica;
import core.ProcessarGramatica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Main() {
		setTitle("Validar gramática");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 385);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserirGramatica = new JLabel("Inserir gramática:");
		lblInserirGramatica.setBounds(20, 10, 110, 15);
		contentPane.add(lblInserirGramatica);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 30, 225, 80);
		contentPane.add(scrollPane);
		
		JTextArea textAreaInserirGramatica = new JTextArea();
		scrollPane.setViewportView(textAreaInserirGramatica);
		
		JSeparator separator01 = new JSeparator();
		separator01.setBounds(15, 157, 235, 5);
		contentPane.add(separator01);
		
		JSeparator separator02 = new JSeparator();
		separator02.setOrientation(SwingConstants.VERTICAL);
		separator02.setBounds(260, 10, 5, 300);
		contentPane.add(separator02);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(275, 10, 90, 15);
		contentPane.add(lblResultado);
		
		JTextArea textAreaResultado = new JTextArea();
		textAreaResultado.setBounds(275, 30, 459, 80);
		contentPane.add(textAreaResultado);
		
		JSeparator separator01_1 = new JSeparator();
		separator01_1.setBounds(275, 150, 475, 5);
		contentPane.add(separator01_1);
		
		JLabel lblExemplo1 = new JLabel("Exemplo 01:");
		lblExemplo1.setBounds(20, 170, 80, 15);
		contentPane.add(lblExemplo1);
		
		JLabel lblGramaticaExemplo01 = new JLabel("S=abA|ab;A=a|b");
		lblGramaticaExemplo01.setBounds(20, 189, 200, 15);
		contentPane.add(lblGramaticaExemplo01);
		
		JTextArea textAreaExemplo01 = new JTextArea();
		textAreaExemplo01.setBounds(20, 220, 225, 110);
		contentPane.add(textAreaExemplo01);
		
		JLabel lblExemplo2 = new JLabel("Exemplo 02:");
		lblExemplo2.setBounds(275, 170, 80, 15);
		contentPane.add(lblExemplo2);
		
		JLabel lblGramaticaExemplo02 = new JLabel("S=aA;A=?|aB|bC|cC;B=aA;C=bC|cC|?");
		lblGramaticaExemplo02.setBounds(275, 189, 273, 15);
		contentPane.add(lblGramaticaExemplo02);
		
		JTextArea textAreaExemplo02 = new JTextArea();
		textAreaExemplo02.setBounds(275, 215, 225, 110);
		contentPane.add(textAreaExemplo02);
		
		JSeparator separator02_1 = new JSeparator();
		separator02_1.setOrientation(SwingConstants.VERTICAL);
		separator02_1.setBounds(510, 160, 5, 165);
		contentPane.add(separator02_1);
		
		JLabel lblExemplo3 = new JLabel("Exemplo 03:");
		lblExemplo3.setBounds(525, 170, 80, 15);
		contentPane.add(lblExemplo3);
		
		JLabel lblGramaticaExemplo03 = new JLabel("S=aS|bB;B=bB|bc;C=cC|?");
		lblGramaticaExemplo03.setBounds(525, 189, 209, 15);
		contentPane.add(lblGramaticaExemplo03);
		
		JTextArea textAreaExemplo03 = new JTextArea();
		textAreaExemplo03.setBounds(525, 215, 225, 110);
		contentPane.add(textAreaExemplo03);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaInserirGramatica.setText("");
				textAreaExemplo01.setText("");
				textAreaExemplo02.setText("");
				textAreaExemplo03.setText("");
				textAreaResultado.setText("");
			}
		});
		btnLimpar.setBounds(20, 121, 90, 25);
		contentPane.add(btnLimpar);
		
		JButton btnProcessar = new JButton("Processar");
		btnProcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaExemplo01.setText(new ProcessarGramatica(new Gramatica(lblGramaticaExemplo01.getText())).getResultado().toString());
					textAreaExemplo02.setText(new ProcessarGramatica(new Gramatica(lblGramaticaExemplo02.getText())).getResultado().toString());
					textAreaExemplo03.setText(new ProcessarGramatica(new Gramatica(lblGramaticaExemplo03.getText())).getResultado().toString());
					if(textAreaInserirGramatica.getText().length() > 0) {
						textAreaResultado.setText(new ProcessarGramatica(new Gramatica(textAreaInserirGramatica.getText())).getResultado().toString());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnProcessar.setBounds(145, 120, 100, 25);
		contentPane.add(btnProcessar);
	}
}