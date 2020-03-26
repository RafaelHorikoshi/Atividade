package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Produto;

public class ListarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<Produto> arr = new ArrayList<Produto>();

        Produto produto = new Produto();

        produto.setDescricao("");
        
        ProdutoDao produtoDao = new ProdutoDao();

        arr = produtoDao.listar(produto);

        HttpSession session = request.getSession();

        session.setAttribute("arrproduto", arr);

        return "/cadastros/produto/lista_produto.jsp";

    }

}
