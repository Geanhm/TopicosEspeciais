package com.example.core.View.VeiculoViews;

import com.example.core.Model.Veiculo;

import java.util.Objects;

public class VeiculoHTMLCreator {

    public String getPageHtml(Veiculo veiculo){
        String page = "<html lang=\"en\"> " +
                "<head> <meta charset=\"UTF-8\"> " +
                "<title>Novo Veiculo</title> " +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "</head> " +
                "<body>" +
                "<div class=\"container\">" +
                "       <div class=\"row\">" +
                "           <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">" +
                "               <div class=\"card border-0 shadow rounded-3 my-5\">" +
                "                   <div class=\"card-body p-4 p-sm-5\">" +
                "                       <form action=\"veiculos\" method=\"POST\">" +
                "                           <div class=\"form-floating mb-3\">" +
                "                             <input type=\"text\" class=\"form-control\" " + formatId(veiculo.getId()) + " id=\"floatingid\" readonly name=\"id\" placeholder=\"id\">" +
                "                             <label for=\"floatingid\">id</label>" +
                "                           </div>" +
                "                           <div class=\"form-floating mb-3\">" +
                "                               <input type=\"text\" " +
                "                                       class=\"form-control\" "
                                                        + formatPlaca(veiculo.getPlaca()) +
                                                        " id=\"floatingveiculo\" " +
                "                                       name=\"placa\" " +
                "                                       placeholder=\"ABC-1234\" " +
                "                                       minlength=\"7\" " +
                "                                       required " +
                "                                       maxlength=\"10\" >" +
                "                               <label for=\"floatingveiculo\">Placa</label>" +
                "                           </div>" +
                "                           <div class=\"form-floating mb-3\">" +
                "                               <input type=\"text\" " +
                "                                       class=\"form-control\" " +
                "                                       id=\"floatingModelo\" " +
                                                        formatModelo(veiculo.getModelo()) +
                "                                       name=\"modelo\" " +
                "                                       placeholder=\"Modelo\" " +
                "                                       required"+
                "                                       minlength=\"2\" >" +
                "                               <label for=\"floatingModelo\">Modelo</label>" +
                "                          </div>" +
                "                          <div class=\"d-grid\">" +
                "                               <button class=\"btn btn-primary btn-login text-uppercase fw-bold\" type=\"submit\">Salvar</button>" +
                "                           </div>" +
                "                       </form>" +
                "                   </div>" +
                "               </div>" +
                "           </div>" +
                "       </div>" +
                "   </div> " +
                "</body> " +
                "</html> ";
        return page;
    }
    private String formatId(String uuid){
        String value = Objects.isNull(uuid) ? "\"\"" : uuid;
        return "value=".concat(value);
    }

    private String formatPlaca(String placa){
        String value = Objects.isNull(placa) ? "\"\"" : placa;
        return "value=".concat(value);
    }

    private String formatModelo(String modelo){
        String value = Objects.isNull(modelo) ? "\"\"" : modelo;
        return "value=".concat(value);
    }
}
