package model.bo;

import exception.HandlerException;
import java.io.Serializable;

/**
 *
 * @author dlnotari
 */
public interface I_BO extends Serializable{
    public boolean cadastrar() throws HandlerException;
    public boolean excluir() throws HandlerException;
    public boolean consultar() throws HandlerException;
    public boolean validar() throws HandlerException;
}
