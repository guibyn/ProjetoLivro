package gui.view.cadastro;

import java.awt.Choice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.HandlerException;
import gui.view.co.CoCadastrarLivro;
import model.vo.VoAutor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GuiCadastrarLivro extends JFrame {

	private JPanel contentPane;
	private Choice choiceAutor;
	private CoCadastrarLivro co;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GuiCadastrarLivro(CoCadastrarLivro co,ArrayList<VoAutor> listaDeAutores) {
		this.co = co;
		setTitle("Novo Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 354, 0, 0};
		gbl_contentPane.rowHeights = new int[]{58, 10, 45, 26, -8, 20, 22, 22, 22, 22, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label labelApresentacao = new Label("Novo Livro");
		labelApresentacao.setAlignment(Label.CENTER);
		GridBagConstraints gbc_labelApresentacao = new GridBagConstraints();
		gbc_labelApresentacao.insets = new Insets(0, 0, 5, 5);
		gbc_labelApresentacao.gridx = 1;
		gbc_labelApresentacao.gridy = 0;
		contentPane.add(labelApresentacao, gbc_labelApresentacao);
		
		Label labelT = new Label("Titulo");
		labelT.setAlignment(Label.CENTER);
		GridBagConstraints gbc_labelT = new GridBagConstraints();
		gbc_labelT.insets = new Insets(0, 0, 5, 5);
		gbc_labelT.gridx = 1;
		gbc_labelT.gridy = 2;
		contentPane.add(labelT, gbc_labelT);
		
		TextField textFieldTitulo = new TextField();
		GridBagConstraints gbc_textFieldTitulo = new GridBagConstraints();
		gbc_textFieldTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitulo.gridx = 1;
		gbc_textFieldTitulo.gridy = 3;
		contentPane.add(textFieldTitulo, gbc_textFieldTitulo);
		
		Label labelA = new Label("Autor");
		labelA.setAlignment(Label.CENTER);
		GridBagConstraints gbc_labelA = new GridBagConstraints();
		gbc_labelA.insets = new Insets(0, 0, 5, 5);
		gbc_labelA.gridx = 1;
		gbc_labelA.gridy = 4;
		contentPane.add(labelA, gbc_labelA);
		
		choiceAutor = new Choice();
		for (VoAutor autor : listaDeAutores) {
			choiceAutor.add(autor.getnome());
		}
		
		GridBagConstraints gbc_choiceAutor = new GridBagConstraints();
		gbc_choiceAutor.anchor = GridBagConstraints.NORTH;
		gbc_choiceAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_choiceAutor.insets = new Insets(0, 0, 5, 5);
		gbc_choiceAutor.gridx = 1;
		gbc_choiceAutor.gridy = 5;
		contentPane.add(choiceAutor, gbc_choiceAutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrar(textFieldTitulo.getText());
				} catch (SQLException | HandlerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 11;
		contentPane.add(btnCadastrar, gbc_btnCadastrar);
	}
	public int getChosenId() {
		return choiceAutor.getSelectedIndex();
	}
	
	public void cadastrar(String titulo) throws SQLException, HandlerException {
		co.cadastrar(titulo);
	}
		// TODO Auto-generated constructor stub
	}

