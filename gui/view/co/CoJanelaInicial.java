package gui.view.co;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import dao.DAO;
import dao.ResultAdapter;
import dao.db.Conexao;
import exception.HandlerException;
import gui.view.GuiJanelaInicial;
import model.vo.VoPesquisa;

public class CoJanelaInicial {
	GuiJanelaInicial GuiInicio;
	Conexao conexaoCo;
	DefaultTableModel model;
	DAO DAO;
	CoCadastrarLivro coCadastrarLivro;
	CoCadastrarAutor coCadastrarAutor;
	CoCadastrarEdicao coCadastrarEdicao;
	
	
	public CoJanelaInicial(Conexao conexao) throws SQLException, HandlerException {
		this.conexaoCo = conexao;
		this.inicializar();
		
	}
	
	
	private void inicializar() throws SQLException, HandlerException {
			this.DAO = new DAO(conexaoCo);
			GuiJanelaInicial a = new GuiJanelaInicial(ResultAdapter.buildTableModel(DAO.getResult()),this);
			this.GuiInicio = a;

	}
	
	public void listarLivros() throws SQLException {
		this.GuiInicio.setJTable(ResultAdapter.buildTableModel(DAO.getResult()));
		}
	
	public void setJTable(DefaultTableModel model) {
		this.GuiInicio.setJTable(model);
		
     
        }
	


	public GuiJanelaInicial getGuiInicio() {
		return this.GuiInicio;
	}


	public DefaultTableModel getModel() {
		return this.model;
	}


	public void showDataTeste(int aInicio, int aFim) throws HandlerException, SQLException {
		this.DAO = new DAO(conexaoCo, aInicio,aFim);
		this.GuiInicio.setJTable(ResultAdapter.buildTableModel(DAO.getResult()));
	}

		
	public void pesquisa(VoPesquisa pesquisa) throws HandlerException, SQLException {
		this.DAO = new DAO(conexaoCo,pesquisa);
		this.GuiInicio.setJTable(ResultAdapter.buildTableModel(DAO.getResult()));
		
	}


	public void mostrarTodosLivros() throws HandlerException, SQLException {
		this.DAO = new DAO(conexaoCo);
		this.listarLivros();
	}


	public void showAutores() throws HandlerException, SQLException {
		String sql = "SELECT * from autor";
		this.DAO = new DAO(conexaoCo,sql);
		this.GuiInicio.setJTable(ResultAdapter.buildTableModel(DAO.getResult()));
		
	}


	public void criarJanelaNovoLivro() throws HandlerException, SQLException {
		coCadastrarLivro = new CoCadastrarLivro(this,conexaoCo);
		
	}
	
	public void criarJanelaNovoAutor() throws HandlerException, SQLException {
		coCadastrarAutor = new CoCadastrarAutor(conexaoCo);
		
	}
	
	public void criarJanelaNovaEdicao() throws HandlerException, SQLException {
		coCadastrarEdicao = new CoCadastrarEdicao(conexaoCo);
		
	}
	
}
	

