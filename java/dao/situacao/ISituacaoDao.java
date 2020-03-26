package dao.situacao;

import java.util.ArrayList;
import modelo.Situacao;

public interface ISituacaoDao {
     public ArrayList<Situacao> listar(Situacao situacao);

    public void buscar(Situacao situacao);

    public boolean alterar(Situacao situacao);

    public boolean excluir(Situacao situacao);
    
    public boolean cadastrar(Situacao situacao);
}
