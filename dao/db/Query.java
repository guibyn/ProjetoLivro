package dao.db;
import java.sql.*;

public class Query {
	private Connection c;
	private ResultSet result;
	private String erro = "ErroQry";
	private String sql;
	private boolean state;
	private PreparedStatement statement = null;
	
	
	public Query (Connection c, PreparedStatement statement) {
		this.c = c;
		this.statement = statement;
		this.run();
	}


	public Query (Connection c, String sql) throws SQLException {
		this.c = c;
		this.sql = sql;
		this.statement = c.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}
	
	public void run() {
		try {
			this.result = statement.executeQuery();
			this.state = true;
			} catch (Exception e) {
				System.out.println(erro);
				e.printStackTrace();
				this.state = false;
			}	
		}
	
	public ResultSet returnResult() {
		return this.result;
		}
	
	public ResultSet getResult() throws SQLException {
		Query a = new Query(c,statement);
		
		return a.returnResult();
	}
		

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
	
	public boolean isState() {
		return state;
	}
	
	public PreparedStatement getStatement() {
		return statement;
	}

	public void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}
	
}
	
	
