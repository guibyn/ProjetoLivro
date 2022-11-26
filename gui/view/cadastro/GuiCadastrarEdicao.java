package gui.view.cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.db.Conexao;
import exception.HandlerException;
import gui.view.co.CoCadastrarEdicao;

import java.awt.Label;
import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.vo.*;

public class GuiCadastrarEdicao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEdicao;
	private JTextField textFieldAno;
	ArrayList<VoLivro> listaDeLivros;
	Choice choiceLivro;
	CoCadastrarEdicao co;
	Conexao conexao;

	
	public GuiCadastrarEdicao(Conexao conexao, CoCadastrarEdicao co,ArrayList<VoLivro> lista) {
		this.co = co;
		this.conexao = conexao;
		this.listaDeLivros = lista;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{65, 314, 0, 0};
		gbl_contentPane.rowHeights = new int[]{22, 22, 20, 22, 20, 22, 20, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label label = new Label("Adicionar Edição");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		Label label_1 = new Label("Livro");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		contentPane.add(label_1, gbc_label_1);
		
		choiceLivro = new Choice();
		for (VoLivro livro : listaDeLivros) {
			choiceLivro.add(livro.getTitulo());
		}
		
		GridBagConstraints gbc_choiceLivro = new GridBagConstraints();
		gbc_choiceLivro.anchor = GridBagConstraints.NORTH;
		gbc_choiceLivro.fill = GridBagConstraints.HORIZONTAL;
		gbc_choiceLivro.insets = new Insets(0, 0, 5, 5);
		gbc_choiceLivro.gridx = 1;
		gbc_choiceLivro.gridy = 2;
		contentPane.add(choiceLivro, gbc_choiceLivro);
		
		Label label_2 = new Label("Edicao");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		contentPane.add(label_2, gbc_label_2);
		
		textFieldEdicao = new JTextField();
		GridBagConstraints gbc_textFieldEdicao = new GridBagConstraints();
		gbc_textFieldEdicao.anchor = GridBagConstraints.NORTH;
		gbc_textFieldEdicao.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEdicao.gridx = 1;
		gbc_textFieldEdicao.gridy = 4;
		contentPane.add(textFieldEdicao, gbc_textFieldEdicao);
		textFieldEdicao.setColumns(10);
		
		Label label_3 = new Label("Ano");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.NORTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 5;
		contentPane.add(label_3, gbc_label_3);
		
		textFieldAno = new JTextField();
		GridBagConstraints gbc_textFieldAno = new GridBagConstraints();
		gbc_textFieldAno.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAno.anchor = GridBagConstraints.NORTH;
		gbc_textFieldAno.gridx = 1;
		gbc_textFieldAno.gridy = 6;
		contentPane.add(textFieldAno, gbc_textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String edicao = textFieldEdicao.getText();
			String ano = textFieldAno.getText();
			try {
				cadastrar(edicao,ano);
			} catch (SQLException | HandlerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 8;
		contentPane.add(btnCadastrar, gbc_btnCadastrar);
	}
	
	public int getChosenId() {
		return choiceLivro.getSelectedIndex();
	}
	
	public void cadastrar(String edicao, String ano) throws SQLException, HandlerException {
		co.cadastrar(edicao,ano);
	}
}
