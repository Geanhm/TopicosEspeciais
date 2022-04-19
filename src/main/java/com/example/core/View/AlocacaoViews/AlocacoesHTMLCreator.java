package com.example.core.View.AlocacaoViews;

import com.example.core.Model.Alocacao;

import java.util.List;

public class AlocacoesHTMLCreator {

    public String getTableHtml(List<Alocacao> alocacoes){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Agentes</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                "<div id=\"button-cadastrar\">" +
                	"<a href=\"alocacao\" class=\"btn btn-primary btn-block mt-5\">Cadastrar alocacoes</a>" +
                    "<a href=\"index.html\" class=\"btn btn-primary btn-block mt-5 mx-3\">Home</a>" +
                "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id</th>" +
                "<th scope=\"col\">Agente</th>" +
                "<th scope=\"col\">Veiculo</th>" +
                "<th scope=\"col\">Placa</th>" +
                "<th scope=\"col\"></th>" +
                "<th scope=\"col\"></th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        String dados = "";
        for (Alocacao locacao : alocacoes) {
            dados +=  "<tr>" +
                    "<td>" + locacao.getId() + "</td>" +
                    "<td>" + locacao.getAgente().getNome() + "</td>" +
                    "<td>" + locacao.getVeiculo().getModelo() + "</td>" +
                    "<td>" + locacao.getVeiculo().getPlaca() + "</td>" +
                    "<td><a href=alocacao-edit?id="+ locacao.getId() +" class=\"fas fa-pencil-alt\"></a></td>" +
                    "<td><a href=alocacao-remove?id="+ locacao.getId() +" class=\"fas fa-trash-alt\"></a></td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += " <tfoot>\n" +
                "                <tr>\n" +
                "                  <td>Total registros: "+ alocacoes.size() +"</td>\n" +
                "                </tr>\n" +
                "            </tfoot>";
        page += "</table>";
        page += "</div>";
        page += "</body>";
        page += "</html>";

        return page;
    }
}
