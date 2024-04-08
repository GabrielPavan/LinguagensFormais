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
		setBounds(100, 100, 780, 375);
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
		separator02.setBounds(260, 10, 5, 325);
		contentPane.add(separator02);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(275, 10, 90, 15);
		contentPane.add(lblResultado);
		
		JSeparator separator01_1 = new JSeparator();
		separator01_1.setBounds(275, 157, 475, 5);
		contentPane.add(separator01_1);
		
		JLabel lblExemplo1 = new JLabel("Exemplo 01:");
		lblExemplo1.setBounds(20, 170, 80, 15);
		contentPane.add(lblExemplo1);
		
		JLabel lblGramaticaExemplo01 = new JLabel("S=aSb|Ab;A=a|b");
		lblGramaticaExemplo01.setBounds(20, 189, 200, 15);
		contentPane.add(lblGramaticaExemplo01);
		
		JLabel lblExemplo2 = new JLabel("Exemplo 02:");
		lblExemplo2.setBounds(275, 170, 80, 15);
		contentPane.add(lblExemplo2);
		
		JLabel lblGramaticaExemplo02 = new JLabel("S=aA;A=?|aB|bC|cC;B=aA;C=bC|cC|?");
		lblGramaticaExemplo02.setBounds(275, 189, 273, 15);
		contentPane.add(lblGramaticaExemplo02);
		
		JSeparator separator02_1 = new JSeparator();
		separator02_1.setOrientation(SwingConstants.VERTICAL);
		separator02_1.setBounds(510, 170, 5, 160);
		contentPane.add(separator02_1);
		
		JLabel lblExemplo3 = new JLabel("Exemplo 03:");
		lblExemplo3.setBounds(525, 170, 80, 15);
		contentPane.add(lblExemplo3);
		
		JLabel lblGramaticaExemplo03 = new JLabel("S=aS|bB;B=bB|bc;C=cC|?");
		lblGramaticaExemplo03.setBounds(525, 189, 209, 15);
		contentPane.add(lblGramaticaExemplo03);
		
		JScrollPane scrollPane02 = new JScrollPane();
		scrollPane02.setBounds(20, 215, 225, 110);
		contentPane.add(scrollPane02);
		
		JTextArea textAreaExemplo01 = new JTextArea();
		scrollPane02.setViewportView(textAreaExemplo01);
		
		JScrollPane scrollPane03 = new JScrollPane();
		scrollPane03.setBounds(275, 215, 225, 110);
		contentPane.add(scrollPane03);
		
		JTextArea textAreaExemplo02 = new JTextArea();
		scrollPane03.setViewportView(textAreaExemplo02);
		
		JScrollPane scrollPane04 = new JScrollPane();
		scrollPane04.setBounds(525, 215, 225, 110);
		contentPane.add(scrollPane04);
		
		JTextArea textAreaExemplo03 = new JTextArea();
		scrollPane04.setViewportView(textAreaExemplo03);
		
		JScrollPane scrollPane05 = new JScrollPane();
		scrollPane05.setBounds(275, 30, 225, 110);
		contentPane.add(scrollPane05);
		
		JTextArea textAreaResultado = new JTextArea();
		scrollPane05.setViewportView(textAreaResultado);
		
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
					ProcessarGramatica processarGramatica = new ProcessarGramatica();
					Gramatica gramatica = new Gramatica();
					
					gramatica.createGramatica(lblGramaticaExemplo01.getText());
					processarGramatica.geraSentenca('S', gramatica);
					textAreaExemplo01.setText(processarGramatica.getOrdemResultado());
					processarGramatica.resetVariaveis();
					
					gramatica.createGramatica(lblGramaticaExemplo02.getText());
					processarGramatica.geraSentenca('S', gramatica);
					textAreaExemplo02.setText(processarGramatica.getOrdemResultado());
					processarGramatica.resetVariaveis();
					
					gramatica.createGramatica(lblGramaticaExemplo03.getText());
					processarGramatica.geraSentenca('S', gramatica);
					textAreaExemplo03.setText(processarGramatica.getOrdemResultado());
					processarGramatica.resetVariaveis();
					
					if(textAreaInserirGramatica.getText().length() > 0) {
						gramatica.createGramatica(textAreaInserirGramatica.getText());
						processarGramatica.geraSentenca('S', gramatica);
						textAreaResultado.setText(processarGramatica.getOrdemResultado());
						processarGramatica.resetVariaveis();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (StackOverflowError e2) {
					JOptionPane.showMessageDialog(null, "Gramatica incorreta, gerou um loop infinito.");
				}
			}
		});
		btnProcessar.setBounds(145, 120, 100, 25);
		contentPane.add(btnProcessar);
		
		JLabel lblApresentacao = new JLabel("Trabalho de linguagens formais 6° Fase");
		lblApresentacao.setBounds(525, 10, 225, 130);
		contentPane.add(lblApresentacao);
	}
}