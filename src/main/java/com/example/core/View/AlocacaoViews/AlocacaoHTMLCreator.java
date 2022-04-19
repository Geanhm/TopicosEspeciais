package com.example.core.View.AlocacaoViews;

import com.example.core.Model.Agente;
import com.example.core.Model.Alocacao;
import com.example.core.Model.Veiculo;

import java.util.List;
import java.util.Objects;

public class AlocacaoHTMLCreator {

    public String getPageHtml(Alocacao alocacao, List<Veiculo> veiculos, List<Agente> agentes){
        String page = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Novo Agente</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n" +
                "            <div class=\"card border-0 shadow rounded-3 my-5\">\n" +
                "                <div class=\"card-body p-4 p-sm-5\">\n" +
                "                    <form action=\"alocacao\" method=\"POST\">\n" +
                "                        <div class=\"form-floating mb-3\">\n" +
                "                            <input type=\"text\" class=\"form-control\" "+ formatId(alocacao.getId())+" id=\"floatingid\" readonly name=\"id\" placeholder=\"id\">\n" +
                "                            <label for=\"floatingid\">id</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"form-floating mb-3\">\n" +
                "                            <select pattern=\"[^a-zA-Z0-9]\" class=\"form-control\" name=\"agente\" id=\"floatingAgente\" required >\n" +
                "                                   <option value=\"\">Selecione o agente</option>"+
                                                    generateOptionAgente(alocacao,agentes) +
                "                            </select>\n" +
                "                            <label for=\"floatingAgente\">Agente</label>\n" +
                "                        </div>\n" + 
                "                        <div class=\"form-floating mb-3\">\n" +
                "                            <select pattern=\"[^a-zA-Z0-9]\" class=\"form-control\" name=\"veiculo\" id=\"floatingVeiculo\" required >\n" +
                "                                   <option value=\"\">Selecione o veiculo</option>"+
                                                    generateOptionVeiculo(alocacao,veiculos) +
                "                            </select>\n" +
                "                            <label for=\"floatingVeiculo\">Agente</label>\n" +
                "                        </div>\n" + 
                "                        <div class=\"d-grid\">\n" +
                "                            <button class=\"btn btn-primary btn-login text-uppercase fw-bold\"\n" +
                "                                    type=\"submit\">Registrar\n" +
                "                            </button>\n" +
                "                            <a href=\"index.html\" class=\"btn btn-secondary btn-login text-uppercase fw-bold mt-5\"\n" +
                "                                    type=\"submit\">Home\n" +
                "                            </a>\n" +
                "                        </div>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return page;
    }
    private String formatId(String uuid){
        String value = Objects.isNull(uuid) ? "\"\"" : uuid;
        return "value=".concat(value);
    }

    private String generateOptionAgente(Alocacao alocacao,List<Agente> agentes){
        String dados = "";
        for (Agente agente : agentes) {
            dados +=  "<option value="+agente.getId()+" " +selectedAgente(alocacao, agente)+ ">"+
                    agente.getMatricula() + " - "+
                    agente.getNome()+"</option>\n";
        }
        return dados;
    }

    private String selectedAgente(Alocacao alocacao, Agente agente){
        if (Objects.nonNull(agente.getId())) {
            if (null != alocacao.getAgente() && agente.getId().equals(alocacao.getAgente().getId())) {
                return "selected";
            }
        }
        return null;
    }
    
    private String generateOptionVeiculo(Alocacao alocacao,List<Veiculo> veiculos){
        String dados = "";
        for (Veiculo veiculo : veiculos) {
            dados +=  "<option value="+veiculo.getId()+" " +selectedVeiculo(alocacao, veiculo)+ ">"+
            		veiculo.getModelo() + " - "+
            		veiculo.getPlaca()+"</option>\n";
        }
        return dados;
    }

    private String selectedVeiculo(Alocacao alocacao, Veiculo veiculo){
        if (Objects.nonNull(veiculo.getId())) {
            if (null != alocacao.getVeiculo() && veiculo.getId().equals(alocacao.getVeiculo().getId())) {
                return "selected";
            }
        }
        return null;
    }
}
