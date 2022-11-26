package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import exception.HandlerException;
import model.vo.VoAutor;
import model.vo.VoLivro;

/**
 *
 * @author dlnotari
 */
public interface I_DAO {
    public boolean cadastrar(VoLivro livro, VoAutor autor) throws HandlerException, SQLException;
    public boolean excluir(VoLivro livro) throws HandlerException, SQLException;
    public ResultSet consultar() throws HandlerException, SQLException;
    public ResultSet consultar(int aInicial, int aFinal) throws HandlerException, SQLException;
    public ResultSet consultarTitulo(String titulo) throws HandlerException, SQLException;
    public ResultSet consultarAutor(String autor) throws HandlerException, SQLException;
}
