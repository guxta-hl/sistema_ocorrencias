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

import dao.ApreensoesDAO;
import dao.OcorrenciasDAO;
import model.Apreensoes;
import model.Ocorrencias;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroApr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipo;
    private JTextField txtDescricao;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    
    
	public TelaCadastroApr(TelaCadastroOC telaOC, String numero, String ano) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


	        setTitle("Cadastro de Apreensões");
	        setSize(400, 250);
	        getContentPane().setLayout(new GridLayout(4, 2));

	        getContentPane().add(new JLabel("Tipo:"));
	        txtTipo = new JTextField();
	        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyTyped(java.awt.event.KeyEvent evt) {
	                char c = evt.getKeyChar();

	                if (Character.isDigit(c)) {
	                    evt.consume();
	                }
	            }
	        });
	        getContentPane().add(txtTipo);

	        getContentPane().add(new JLabel("Descrição:"));
	        txtDescricao = new JTextField();
	        getContentPane().add(txtDescricao);

	        btnCadastrar = new JButton("Cadastrar Apr");
	        
	        btnVoltar = new JButton("Voltar");
	        btnVoltar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        	}
	        });

	        getContentPane().add(btnVoltar);
	        getContentPane().add(btnCadastrar);

	        btnCadastrar.addActionListener(e -> {
	        	
	        
	        	if(validarDados(txtTipo.getText(), txtDescricao.getText())) {

	        		Ocorrencias oc = new Ocorrencias();
	        		Apreensoes apr = new Apreensoes();
	        		apr.setTipo(txtTipo.getText());
	        		apr.setDescricao(txtDescricao.getText());
	        		
	        		oc.setNumeroOc(Integer.parseInt(numero.trim()));
	        		oc.setAno(Integer.parseInt(ano.trim()));
	        		oc.setApreensoes(apr);
	        		
	        		Integer idOc = OcorrenciasDAO.inserir(oc);
	        		
	        		
	        		if(idOc != null) {
		        		ApreensoesDAO aprDao = new ApreensoesDAO();
		        		aprDao.inserir(apr, idOc);
		        		new TableAprOc();
		        		telaOC.dispose();
		        		dispose();
	        		}
	            	JOptionPane.showMessageDialog(null, "Ocorrência e apreensão cadastrada!");
	        	}else {
	        		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!");
	        	}
	        });
	        
	

	        
	        setVisible(true);
	
	}
	public boolean validarDados(String tipo, String descricao) {
		try{
			if ((tipo == null || tipo.trim().isEmpty()) 
					|| (descricao == null || descricao.trim().isEmpty()))  {
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
