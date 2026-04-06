package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.OcorrenciasDAO;
import model.Ocorrencias;

import javax.swing.JButton;

public class TableAprOc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JButton btnVoltar;



	public TableAprOc() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		setContentPane(contentPane);

		 
	     setTitle("Listagem de Ocorrências e Apreensões");
	        setSize(600, 350);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        // TABELA
	        modelo = new DefaultTableModel(
	            new Object[][]{},
	            new String[]{"ID", "Número OC", "Ano", "Tipo", "Descrição"}
	        );

	        if(OcorrenciasDAO.listar().size() > -1) {
	        	for (Ocorrencias oc : OcorrenciasDAO.listar()) {
	        		modelo.addRow(new Object[]{
	        				modelo.getRowCount() + 1,	
	        				oc.getNumeroOc(),
	        				oc.getAno(),
	        				oc.getApreensoes().getTipo(),
	        				oc.getApreensoes().getDescricao()
	            });
	        	}
	        }else {
        		modelo.addRow(new Object[]{
        				"-",	
        				"-",
        				"-",
        				"-",
        				"Nenhum registro encontrado no momento"
        		});
	        }
	        
	        tabela = new JTable(modelo);
	        JScrollPane scroll = new JScrollPane(tabela);

	        add(scroll, BorderLayout.CENTER);

	        // BOTÃO VOLTAR
	        btnVoltar = new JButton("Voltar");

	        JPanel painelInferior = new JPanel();
	        painelInferior.add(btnVoltar);

	        add(painelInferior, BorderLayout.SOUTH);

	        // AÇÃO DO BOTÃO
	        btnVoltar.addActionListener(e -> {
	            new TelaCadastroOC();
	            dispose();
	        });

	        setVisible(true);
	}

}
