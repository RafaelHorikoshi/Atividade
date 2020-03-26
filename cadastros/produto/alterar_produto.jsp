<%@page import="modelo.Situacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto"); 

        %>

        <form action="/padraocommand/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Alterar"/>

            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="<%= objproduto.getDescricao()%>"/>
            </div>
            
              <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="<%= objproduto.getQuantidade()%>"/>
            </div>
            
            <div>
                <label>Situação</label>
                <select name='cmbsituacao'>
                    <%
                        String selecionado = "";
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrsituacao) {
                            if (obj.getId() == objproduto.getSituacao().getId()) {
                                selecionado = "selected=selected"; 
                            } else {
                                selecionado = ""; 
                            }
                    %>
                    <option <%= selecionado%> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div>
                <label>Situacao</label>
                <lable><b><%= objproduto.getSituacao().getDescricao()%></b></lable>
            </div>    

            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>

        </form>

    </body>
</html>
