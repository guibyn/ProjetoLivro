package dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.HandlerException;


public class Conexao {
	private String URL = "jdbc:postgresql://localhost:5432/postgres";
	private String User = "postgres";
	private String Pass = "postgres";
	private Connection conexao;
	
	
		public Conexao() throws SQLException, HandlerException{
			this.conectar();
		}
			
		
		public void conectar() throws SQLException, HandlerException{ 
			Connection c = null;
			try {
			c = DriverManager.getConnection(URL, User, Pass);
			System.out.println("Sucess");
			this.conexao =  c;
			} catch (SQLException e) {
				e.printStackTrace();
				}
			
		}
		
		public void desconectar() throws SQLException {
	        conexao.close();
	    }
		
		private Connection returnConexao() {
			return this.conexao;
		}
		
		public Connection getConexao() throws SQLException, HandlerException {
			Conexao a = new Conexao();
			return a.returnConexao();
		}
		




}

