package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;
import modelo.Situacao;

public class AlterarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();

        produto.setDescricao(request.getParameter("txtdescricao"));
        produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));

        produto.setId(Integer.parseInt(request.getParameter("id")));

        Situacao situacao = new Situacao(); 
        situacao.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
        produto.setSituacao(situacao); 

        ProdutoDao produtodao = new ProdutoDao();

        produtodao.alterar(produto);

        return "/ControleProduto?acao=Listar";

    }

}
