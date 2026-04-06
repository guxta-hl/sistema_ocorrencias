package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class TelaCadastroOC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	   private JTextField txtNumero;
	    private JTextField txtAno;
	    private JButton btnCadastrar;
	    private JButton btnListar;


	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroOC frame = new TelaCadastroOC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public TelaCadastroOC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		   

		        setTitle("Cadastro de Ocorrência");
		        setSize(400, 250);
		        getContentPane().setLayout(new GridLayout(4, 2));

		        getContentPane().add(new JLabel("Número OC:"));
		        txtNumero = new JTextField();
		        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyTyped(java.awt.event.KeyEvent evt) {
		                char c = evt.getKeyChar();

		                if (!Character.isDigit(c)) {
		                    evt.consume(); // bloqueia caractere
		                }
		            }
		        });
		        getContentPane().add(txtNumero);

		        getContentPane().add(new JLabel("Ano:"));
		        txtAno = new JTextField();
		        txtAno.setText(String.valueOf(LocalDate.now().getYear())); 
		        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyTyped(java.awt.event.KeyEvent evt) {
		                char c = evt.getKeyChar();

		                if (!Character.isDigit(c)) {
		                    evt.consume(); // bloqueia caractere
		                }
		            }
		        });
		        getContentPane().add(txtAno);

		        btnCadastrar = new JButton("Cadastrar OC");
		        btnListar = new JButton("Listar OC's");
		        btnListar.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		new TableAprOc();
		        		dispose();
		        	}
		        });

		        getContentPane().add(btnCadastrar);
		        getContentPane().add(btnListar);

		        btnCadastrar.addActionListener(e -> {
		        	String numero = txtNumero.getText();
		        	String ano = txtAno.getText();
		        	if(validarDados(numero, ano)) {
		        		new TelaCadastroApr(this, numero, ano);
		        	}else {
		        		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!");
		        	}
		        });

		        setVisible(true);
		    
	}

	public boolean validarDados(String numero, String ano) {
		try{
			if ((numero == null || numero.trim().isEmpty()) 
					|| (ano == null || ano.trim().isEmpty())  
					|| (numero.contains(" ")) || (ano.contains(" "))) {
				JOptionPane.showMessageDialog(null, "Campos vazios");
				return false;
			}else {
				return true;
			}
		}catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			return false;
		}	
	}
}
