package ProjetoLivro;
import java.sql.SQLException;

import dao.db.Conexao;
import exception.HandlerException;
import gui.view.co.CoJanelaInicial;


public class ProjetoLivro {
	
	public static Conexao conexaoPrincipal;
	public static CoJanelaInicial co;
	
	public ProjetoLivro() throws SQLException, HandlerException {
		ProjetoLivro.conexaoPrincipal = new Conexao();
	}
	
	private void conectar() {
        try {
            conexaoPrincipal.conectar();
        } catch (HandlerException | SQLException ex) {
            // houve erro
            ex.printStackTrace();
        	System.exit(-1);
        }
    }
	
	private void desconectar() {
		try {
			conexaoPrincipal.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	private void iniciar() throws SQLException, HandlerException {
		this.co = new CoJanelaInicial(conexaoPrincipal);
	}
	
	public Conexao getMainConexao() {
		return this.conexaoPrincipal;
	}
	
	public CoJanelaInicial getCoJanelaInicial() {
		return this.co;
	}
	

	public static void main(String[] args) throws SQLException, HandlerException {
		ProjetoLivro pl = new ProjetoLivro();
		
		//pl.conectar();
		pl.iniciar();
		//pl.desconectar();
		
		
		}
		;
	}
	