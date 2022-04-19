package com.example.core.View.Relatorios;

import com.example.core.Model.Agente;
import com.example.core.Model.Alocacao;
import com.example.core.Model.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class RelatorioViewCreator {

    public String getTableHtml(List<Agente> agentes, List<Veiculo> veiculos, List<Alocacao> alocacoes){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Agentes</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                "<div id=\"button-cadastrar\">" +
                "<a href=\"index.html\" class=\"btn btn-primary btn-block mt-5\">Home</a>" +
                "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                "<h2 class=\"mx-auto\" style=\"width: 200px;\">\n" +
                "            Agentes\n" +
                "        </h2>" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id</th>" +
                "<th scope=\"col\">Nome</th>" +
                "<th scope=\"col\">Matricula</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        String dados = "";
        for (Agente agente : agentes) {
            dados +=  "<tr>" +
                    "<td>" + agente.getId() + "</td>" +
                    "<td>" + agente.getNome() + "</td>" +
                    "<td>" + agente.getMatricula() + "</td>" +
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

        page += getTableVeiculos(veiculos);
        
        page += getTableAlocacoes(alocacoes);

        page += "</div>";
        page += "</body>";
        page += "</html>";

        return page;
    }

    public String getTableVeiculos(List<Veiculo> veiculos){
        String page =
                "<h2 class=\"mx-auto\" style=\"width: 200px;\">\n" +
                        "            Viaturas\n" +
                        "        </h2>" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id viatura</th>" +
                "<th scope=\"col\">Placa</th>" +
                "<th scope=\"col\">Modelo</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        String dados = "";
        for (Veiculo veiculo : veiculos) {
            dados +=  "<tr>" +
                    "<td>" + veiculo.getId() + "</td>" +
                    "<td>" + veiculo.getPlaca() + "</td>" +
                    "<td>" + veiculo.getModelo() + "</td>" +
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

        return page;
    }
    
    
    public String getTableAlocacoes(List<Alocacao> alocacoes){
        String page = 
        		"<h2 class=\"mx-auto\" style=\"width: 200px;\">\n" +
                        "            Alocados\n" +
                        "        </h2>" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id</th>" +
                "<th scope=\"col\">Agente</th>" +
                "<th scope=\"col\">Matricula</th>" +
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
                    "<td>" + locacao.getAgente().getMatricula() + "</td>" +
                    "<td>" + locacao.getVeiculo().getModelo() + "</td>" +
                    "<td>" + locacao.getVeiculo().getPlaca() + "</td>" +
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
