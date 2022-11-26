package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.db.*;
import exception.HandlerException;
import model.vo.VoAutor;
import model.vo.VoEdicao;
import model.vo.VoLivro;
import model.vo.VoPesquisa;

public class DAO {
	
	Query query;
	Update update;
	VoLivro livro;
	ResultSet result = null;
	PreparedStatement statement = null;
	String selects = "livro.titulo , autor.nome, edicao.edicao,edicao.ano";

	public DAO(Conexao conexao) throws HandlerException, SQLException {
		String sql = "SELECT livro.id,livro.titulo, autor.nome,edicao.edicao, edicao.ano from livro\r\n"
				+ "\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "on livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro;";
		Query query = new Query(conexao.getConexao(),sql);
		query.run();
		result =  query.returnResult();
	}
	
	public DAO(Conexao conexao, String sql) throws HandlerException, SQLException {
		Query query = new Query(conexao.getConexao(),sql);
		query.run();
		result =  query.returnResult();
	}


	public boolean cadastrar(Conexao conexao,VoLivro livro, VoAutor autor) throws HandlerException, SQLException {
		String sql = "BEGIN TRANSACTION\r\n"
				+ "	INSERT INTO livro (titulo) VALUES (?)\r\n"
				+ "	INSERT INTO edicao(edicao) VALUES (?)\r\n"
				+ "	INSERT INTO livrosautor(idlivro,idautor) values (?,?)\r\n"
				+ "COMMIT;	";
		
		Update update = new Update(conexao.getConexao(),sql);
		PreparedStatement statement = update.getStatement();
		statement.setString(1,livro.getTitulo());
		statement.setString(2,livro.getEdicao());
		statement.setInt(3,livro.getId());
		statement.setInt(4,autor.getId());
		update.setStatement(statement);
		update.run();
		
		return update.isState();
	}



	public ResultSet consultar(Conexao conexao) throws HandlerException, SQLException {
		String sql = "SELECT livro.id,livro.titulo, autor.nome,edicao.edicao, edicao.ano from livro\r\n"
				+ "\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "on livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro;";
		
		Query query = new Query(conexao.getConexao(),sql);
		query.run();
		return query.getResult();
	}


	public DAO(Conexao conexao ,int aInicial, int aFinal) throws HandlerException, SQLException {
		String sql = "SELECT "+ selects + "  from livro\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "ON livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
				+ "WHERE edicao.ano >= ? and edicao.ano <= ?;";
		Query query = new Query(conexao.getConexao(),sql);
		PreparedStatement statement = query.getStatement();
		statement.setInt(1, aInicial);
		statement.setInt(2, aFinal);
		query.setStatement(statement);
		query.run();
		result = query.getResult();
	}
	
	
	public DAO(Conexao conexao, VoPesquisa pesquisa) throws HandlerException, SQLException {
	
		boolean titulo = pesquisa.getTitulo().equals("NULL");
		boolean autor = pesquisa.getAutor().equals("NULL");
		
		if(!titulo && !autor) {
		String sql = "SELECT "+ selects + "  from livro\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "ON livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
				+ "WHERE livro.titulo = ? AND autor.nome = ? AND edicao.ano >= ? AND edicao.ano <= ?;";
		Query query = new Query(conexao.getConexao(),sql);
		PreparedStatement statement = query.getStatement();
		statement.setString(1, pesquisa.getTitulo());
		statement.setString(2, pesquisa.getAutor());
		statement.setInt(3, pesquisa.getaInicio());
		statement.setInt(4, pesquisa.getaFim());
		query.setStatement(statement);
		query.run();
		result = query.getResult();
		}
		
		else if(!autor) {
			String sql = "SELECT "+ selects + "  from livro\r\n"
					+ "LEFT JOIN livrosAutor\r\n"
					+ "ON livro.id = livrosautor.idlivro\r\n"
					+ "LEFT JOIN autor\r\n"
					+ "ON livrosautor.idautor = autor.id\r\n"
					+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
					+ "WHERE autor.nome = ? AND edicao.ano >= ? AND edicao.ano <= ?;";
			Query query = new Query(conexao.getConexao(),sql);
			PreparedStatement statement = query.getStatement();
			statement.setString(1, pesquisa.getAutor());
			statement.setInt(2, pesquisa.getaInicio());
			statement.setInt(3, pesquisa.getaFim());
			query.setStatement(statement);
			query.run();
			result = query.getResult();
			//code
		}
		
		else if(!titulo) {
			String sql = "SELECT "+ selects + "  from livro\r\n"
					+ "LEFT JOIN livrosAutor\r\n"
					+ "ON livro.id = livrosautor.idlivro\r\n"
					+ "LEFT JOIN autor\r\n"
					+ "ON livrosautor.idautor = autor.id\r\n"
					+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
					+ "WHERE livro.titulo = ? AND edicao.ano >= ? AND edicao.ano <= ?;";
			Query query = new Query(conexao.getConexao(),sql);
			PreparedStatement statement = query.getStatement();
			statement.setString(1, pesquisa.getTitulo());
			statement.setInt(2, pesquisa.getaInicio());
			statement.setInt(3, pesquisa.getaFim());
			query.setStatement(statement);
			query.run();
			result = query.getResult();
			//code
		}
		
		else {
			String sql = "SELECT "+ selects + "  from livro\r\n"
					+ "LEFT JOIN livrosAutor\r\n"
					+ "ON livro.id = livrosautor.idlivro\r\n"
					+ "LEFT JOIN autor\r\n"
					+ "ON livrosautor.idautor = autor.id\r\n"
					+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
					+ "WHERE edicao.ano >= ? AND edicao.ano <= ?;";
			Query query = new Query(conexao.getConexao(),sql);
			PreparedStatement statement = query.getStatement();
			statement.setInt(1, pesquisa.getaInicio());
			statement.setInt(2, pesquisa.getaFim());
			query.setStatement(statement);
			query.run();
			result = query.getResult();
			//code
		}
	
		}
		
		
	


	public DAO(Conexao conexao, VoEdicao ed) {
		// TODO Auto-generated constructor stub
	}

	public ResultSet consultarTitulo(Conexao conexao,String titulo) throws HandlerException, SQLException {
		String sql = "SELECT "+ selects + "  from livro\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "ON livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
				+ "WHERE livro.titulo = ?";
		Query query = new Query(conexao.getConexao(),sql);
		PreparedStatement statement = query.getStatement();
		statement.setString(1, titulo);
		query.setStatement(statement);
		query.run();
		return query.getResult();
	}


	public ResultSet consultarAutor(Conexao conexao,String autor) throws HandlerException, SQLException {
		String sql = "SELECT "+ selects + "  from livro\r\n"
				+ "LEFT JOIN livrosAutor\r\n"
				+ "ON livro.id = livrosautor.idlivro\r\n"
				+ "LEFT JOIN autor\r\n"
				+ "ON livrosautor.idautor = autor.id\r\n"
				+ "LEFT JOIN edicao on livro.id = edicao.idlivro\r\n"
				+ "WHERE autor.nome = ?";
		Query query = new Query(conexao.getConexao(),sql);
		PreparedStatement statement = query.getStatement();
		statement.setString(1, autor);
		query.setStatement(statement);
		query.run();
		return query.getResult();
	}


	public boolean excluir(VoLivro livro) throws HandlerException {
		// TODO Auto-generated method stub
		return false;
	}


	public ResultSet getResult() {
		return result;
	}

	
	public void cadastrarLivro(Conexao conexao,String titulo, int idlivro, int idautor) throws SQLException, HandlerException {
		String sql = "INSERT INTO livro(titulo) VALUES(?)";
		Update update = new Update(conexao.getConexao(),sql);
		PreparedStatement statement = update.getStatement();
		statement.setString(1,titulo);
		update.setStatement(statement);
		update.run();
		
		sql = "INSERT INTO livrosautor(idlivro,idautor) VALUES(?,?)";
		update = new Update(conexao.getConexao(),sql);
		statement = update.getStatement();
		statement.setInt(1, idlivro+1);
		statement.setInt(2, idautor+1);
		update.setStatement(statement);
		update.run();
				
	}
	
	public void cadastrarAutor(Conexao conexao,String a) throws SQLException, HandlerException {
		String sql = "INSERT INTO autor(nome) VALUES(?)";
		Update update = new Update(conexao.getConexao(),sql);
		PreparedStatement statement = update.getStatement();
		statement.setString(1,a);
		update.setStatement(statement);
		update.run();
	}

	public void cadastrar(Conexao conexao, VoLivro a) {
		
		
	}

	public void cadastrarEdicao(Conexao conexao, VoEdicao ed) throws SQLException, HandlerException {
		String sql = "INSERT INTO edicao(idlivro,edicao,ano) VALUES(?,?,?)";
		Update update = new Update(conexao.getConexao(),sql);
		PreparedStatement statement = update.getStatement();
		statement.setInt(1,ed.getIdLivro()+1);
		statement.setInt(2,ed.getEdicao());
		statement.setInt(3,ed.getAno());
		update.setStatement(statement);
		update.run();
		
	}


}
