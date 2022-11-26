package gui.view.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import exception.HandlerException;
import gui.view.co.CoCadastrarAutor;
import gui.view.co.CoCadastrarLivro;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GuiCadastrarAutor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeAutor;
	CoCadastrarAutor co;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GuiCadastrarAutor(CoCadastrarAutor co) {
		this.co = co;
		setTitle("Novo Autor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 354, 0, 0};
		gbl_contentPane.rowHeights = new int[]{58, 0, 0, 23, 0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label labelApresentacao = new Label("Novo Autor");
		labelApresentacao.setAlignment(Label.CENTER);
		GridBagConstraints gbc_labelApresentacao = new GridBagConstraints();
		gbc_labelApresentacao.insets = new Insets(0, 0, 5, 5);
		gbc_labelApresentacao.gridx = 1;
		gbc_labelApresentacao.gridy = 0;
		contentPane.add(labelApresentacao, gbc_labelApresentacao);
		
		textFieldNomeAutor = new JTextField();
		textFieldNomeAutor.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textFieldNomeAutor = new GridBagConstraints();
		gbc_textFieldNomeAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeAutor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomeAutor.gridx = 1;
		gbc_textFieldNomeAutor.gridy = 1;
		contentPane.add(textFieldNomeAutor, gbc_textFieldNomeAutor);
		textFieldNomeAutor.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrar(textFieldNomeAutor.getText());
				} catch (SQLException | HandlerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 3;
		contentPane.add(btnCadastrar, gbc_btnCadastrar);
	}
	
	public void cadastrar(String nome) throws SQLException, HandlerException {
		this.co.cadastrar(nome);
	}

}
