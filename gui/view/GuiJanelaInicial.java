package gui.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import exception.HandlerException;
import gui.view.cadastro.*;
import gui.view.co.*;
import model.vo.VoPesquisa;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class GuiJanelaInicial {

	 JFrame JanelaInicial;
	 public JTable Tabela;
	 private DefaultTableModel tabelaInicial;
	 private CoJanelaInicial co;
	
	public GuiJanelaInicial(DefaultTableModel tabelaInicial, CoJanelaInicial co) {
		this.co = co;
		this.tabelaInicial = tabelaInicial;
		initialize();
	}

	
	private void initialize() {
		JanelaInicial = new JFrame();
		JanelaInicial.setResizable(false);
		JanelaInicial.setBounds(100, 100, 600, 600);
		JanelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JPanel();
		JanelaInicial.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Cadastro de Livros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 600, 30);
		painel.add(lblNewLabel);
		
		
		
		
		
		Tabela = new JTable();
		Tabela.setFillsViewportHeight(true);
		Tabela.setColumnSelectionAllowed(false);
		Tabela.setRowSelectionAllowed(true);
		this.setJTable(tabelaInicial);
		Tabela.setBounds(10,10,400,600);
		
		
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 50, 400, 500);
		painel.add(scrollPane);
		scrollPane.add(Tabela);
		
		JButton btnNovoLivro = new JButton("Novo Livro");
		btnNovoLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							try {
								criarJanelaNovoLivro();
							} catch (Exception a) {
								a.printStackTrace();
							}
						}
					});
				
			
		;
		btnNovoLivro.setBounds(425, 490, 125, 25);
		painel.add(btnNovoLivro);
		
		JButton btnShowLivros = new JButton("Todos Livros");
		btnShowLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarTodos();
				} catch (HandlerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowLivros.setBounds(425, 50, 125, 25);
		painel.add(btnShowLivros);
		
		JButton btnShowAutores = new JButton("Todos Autores");
		btnShowAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					co.showAutores();
				} catch (HandlerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowAutores.setBounds(425, 85, 125, 25);
		painel.add(btnShowAutores);
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPesquisa.setBounds(418, 140, 150, 287);
		painel.add(panelPesquisa);
		panelPesquisa.setLayout(null);
		
		Label lbPesquisa = new Label("Pesquisa");
		lbPesquisa.setBounds(46, 1, 58, 22);
		panelPesquisa.add(lbPesquisa);
		
		Label lbTitulo = new Label("Titulo");
		lbTitulo.setBounds(56, 28, 39, 22);
		panelPesquisa.add(lbTitulo);
		
		TextField textFieldTitulo = new TextField();
		textFieldTitulo.setBounds(10, 55, 130, 22);
		panelPesquisa.add(textFieldTitulo);
		
		Label lbAutor = new Label("Autor");
		lbAutor.setBounds(55, 82, 41, 22);
		panelPesquisa.add(lbAutor);
		
		TextField textFieldAutor = new TextField();
		textFieldAutor.setBounds(10, 109, 130, 22);
		panelPesquisa.add(textFieldAutor);
		
		Label lbAno = new Label("Intervalo de datas");
		lbAno.setBounds(25, 136, 100, 22);
		panelPesquisa.add(lbAno);
		
		TextField textFieldAnoInicial = new TextField();
		textFieldAnoInicial.setBounds(10, 163, 130, 22);
		panelPesquisa.add(textFieldAnoInicial);
		
		TextField textFieldAnoFinal = new TextField();
		textFieldAnoFinal.setBounds(10, 190, 130, 22);
		panelPesquisa.add(textFieldAnoFinal);
		
		Button btPesquisa = new Button("Pesquisar");
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String titulo = textFieldTitulo.getText();
				String autor = textFieldAutor.getText();
				String aInicio = textFieldAnoInicial.getText();
				String aFim = textFieldAnoFinal.getText();
				VoPesquisa pesquisa = new VoPesquisa(titulo, autor, aInicio,aFim);
				try {
					pesquisar(pesquisa);
				} catch (HandlerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btPesquisa.setBounds(44, 252, 62, 22);
		panelPesquisa.add(btPesquisa);
		
		JButton btnNovoAutor = new JButton("Novo Autor");
		btnNovoAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						criarJanelaNovoAutor();
					} catch (HandlerException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					};
				
			}
		);
		btnNovoAutor.setBounds(425, 525, 125, 25);
		painel.add(btnNovoAutor);
		
		JButton btnNovaEdicao = new JButton("Nova Edicao");
		btnNovaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					criarJanelaNovaEdicao();
				} catch (HandlerException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNovaEdicao.setBounds(425, 454, 125, 25);
		painel.add(btnNovaEdicao);
		
	
		JanelaInicial.setVisible(true);
	}
	

		
		
	
	public void setJTable(DefaultTableModel m) {
		
		this.Tabela.setModel(m);
		Tabela.getTableHeader().setResizingAllowed(true);
		
		for (int count = 0; count < Tabela.getColumnCount(); count ++) {
			Tabela.getColumnModel().getColumn(count).setMinWidth(100);
		}
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(m);
		Tabela.setRowSorter(sorter);
		
		
		
	}
	public void pesquisar(VoPesquisa pesquisa) throws HandlerException, SQLException {
				co.pesquisa(pesquisa);
		}
	
	public void mostrarTodos() throws HandlerException, SQLException {
		co.mostrarTodosLivros();
	}
	
	
	private void	criarJanelaNovoLivro() throws HandlerException, SQLException {
		co.criarJanelaNovoLivro();
}
	
	private void	criarJanelaNovoAutor() throws HandlerException, SQLException {
		co.criarJanelaNovoAutor();
}
	
	private void criarJanelaNovaEdicao() throws HandlerException, SQLException {
		co.criarJanelaNovaEdicao();
	}
}
