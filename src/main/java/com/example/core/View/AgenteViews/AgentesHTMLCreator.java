package com.example.core.View.AgenteViews;

import com.example.core.Model.Agente;

import java.util.List;

public class AgentesHTMLCreator {

    public String getTableHtml(List<Agente> agentes){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Agentes</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                    "<div id=\"button-cadastrar\">" +
                        "<a href=\"agente-edit\" class=\"btn btn-primary btn-block mt-5\">Cadastrar agente</a>" +
                        "<a href=\"index.html\" class=\"btn btn-primary btn-block mt-5 mx-3\">Home</a>" +
                    "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                    "<table class=\"table\">" +
                        "<thead>" +
                        "<tr>" +
                            "<th scope=\"col\">Id</th>" +
                            "<th scope=\"col\">Nome</th>" +
                            "<th scope=\"col\">Matricula</th>" +
                            "<th scope=\"col\"></th>" +
                            "<th scope=\"col\"></th>" +
                        "</tr>" +
                        "</thead>" +
                "<tbody>";

        String dados = "";
        for (Agente agente : agentes) {
            dados +=  "<tr>" +
                        "<td>" + agente.getId() + "</td>" +
                        "<td>" + agente.getNome() + "</td>" +
                        "<td>" + agente.getMatricula() + "</td>" +
                        "<td><a href=agente-edit?id="+ agente.getId() +" class=\"fas fa-pencil-alt\"></a></td>" +
                        "<td><a href=agente-remove?id="+ agente.getId() +" class=\"fas fa-trash-alt\"></a></td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += " <tfoot>\n" +
                "                <tr>\n" +
                "                  <td>Total registros: "+ agentes.size() +"</td>\n" +
                "                </tr>\n" +
                "            </tfoot>";
        page += "</table>";
        page += "</div>";
        page += "</body>";
        page += "</html>";

        return page;
    }
}
