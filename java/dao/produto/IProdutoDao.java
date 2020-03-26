package dao.produto;

import java.util.ArrayList;
import modelo.Produto;

public interface IProdutoDao {

    public ArrayList<Produto> listar(Produto produto);

    public void buscar(Produto produto);

    public boolean alterar(Produto produto);

    public boolean excluir(Produto produto);

    public boolean cadastrar(Produto produto);
}
