package dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	private Connection c;
	private String erro = "Erro";
	private String sql;
	private boolean state;
	private PreparedStatement statement = null;

	public Update (Connection c, String sql) throws SQLException {
		this.state = false;
		this.sql = sql;
		this.c = c;
		this.statement = c.prepareStatement(sql);
	}

	public void run() {
		try {
			statement.executeUpdate();
			this.state = true;
			} catch (Exception e) {
				System.out.println(erro);
				this.state = false;
			}	
		}

	public String getSql() {
		return sql;
	}

	public PreparedStatement getStatement() {
		return statement;
	}

	public void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}

		
	
	public boolean isState() {
		return state;
	}
		}	
