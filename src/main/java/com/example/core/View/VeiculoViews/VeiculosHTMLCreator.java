package com.example.core.View.VeiculoViews;

import com.example.core.Model.Veiculo;

import java.util.List;

public class VeiculosHTMLCreator {

    public String getTableHtml(List<Veiculo> veiculos){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Veiculos</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                    "<div id=\"button-cadastrar\">" +
                        "<a href=\"veiculo-edit\" class=\"btn btn-primary btn-block mt-5\">Cadastrar veiculo</a>" +
                        "<a href=\"index.html\" class=\"btn btn-primary btn-block mt-5 mx-3\">Home</a>" +
                    "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                    "<table class=\"table\">" +
                        "<thead>" +
                        "<tr>" +
                            "<th scope=\"col\">Id</th>" +
                            "<th scope=\"col\">Placa</th>" +
                            "<th scope=\"col\">Modelo</th>" +
                            "<th scope=\"col\"></th>" +
                            "<th scope=\"col\"></th>" +
                        "</tr>" +
                        "</thead>" +
                "<tbody>";

        String dados = "";
        for (Veiculo veiculo : veiculos) {
            dados +=  "<tr>" +
                        "<td>" + veiculo.getId() + "</td>" +
                        "<td>" + veiculo.getPlaca() + "</td>" +
                        "<td>" + veiculo.getModelo() + "</td>" +
                        "<td><a href=veiculo-edit?id="+ veiculo.getId() +" class=\"fas fa-pencil-alt\"></a></td>" +
                        "<td><a href=veiculo-remove?id="+ veiculo.getId() +" class=\"fas fa-trash-alt\"></a></td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += " <tfoot>\n" +
                "                <tr>\n" +
                "                  <td>Total registros: "+ veiculos.size() +"</td>\n" +
                "                </tr>\n" +
                "            </tfoot>";
        page += "</table>";
        page += "</div>";
        page += "</body>";
        page += "</html>";

        return page;
    }
}
