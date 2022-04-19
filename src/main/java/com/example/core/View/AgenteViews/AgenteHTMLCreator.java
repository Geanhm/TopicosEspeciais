package com.example.core.View.AgenteViews;

import com.example.core.Model.Agente;

import java.util.Objects;

public class AgenteHTMLCreator {

    public String getPageHtml(Agente agente){
        String page = "<html lang=\"en\"> " +
                "<head> <meta charset=\"UTF-8\"> " +
                "<title>Novo Agente</title> " +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "</head> " +
                "<body>" +
                "<div class=\"container\">" +
                "       <div class=\"row\">" +
                "           <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">" +
                "               <div class=\"card border-0 shadow rounded-3 my-5\">" +
                "                   <div class=\"card-body p-4 p-sm-5\">" +
                "                       <form action=\"agentes\" method=\"POST\">" +
                "                           <div class=\"form-floating mb-3\">" +
                "                             <input type=\"text\" class=\"form-control\" " + formatId(agente.getId()) + " id=\"floatingid\" readonly name=\"id\" placeholder=\"id\">" +
                "                             <label for=\"floatingid\">id</label>" +
                "                           </div>" +
                "                           <div class=\"form-floating mb-3\">" +
                "                               <input type=\"text\" " +
                "                                       class=\"form-control\" "
                                                        + formatNome(agente.getNome()) +
                                                        " id=\"floatingagente\" " +
                "                                       name=\"nome\" " +
                "                                       placeholder=\"Nome\" " +
                "                                       minlength=\"3\" " +
                "                                       required " +
                "                                       maxlength=\"255\" >" +
                "                               <label for=\"floatingagente\">Nome agente</label>" +
                "                           </div>" +
                "                           <div class=\"form-floating mb-3\">" +
                "                               <input type=\"number\" " +
                "                                       class=\"form-control\" " +
                "                                       id=\"floatingNumero\" " +
                                                        formatMatricula(agente.getMatricula()) +
                "                                       name=\"numero\" " +
                "                                       placeholder=\"Matricula\" " +
                "                                       required"+
                "                                       pattern=\"[0-9]\" " +
                "                                       min=\"00001\" " +
                "                                       max=\"99999\">" +
                "                               <label for=\"floatingNumero\">Matricula</label>" +
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

    private String formatNome(String nome){
        String value = Objects.isNull(nome) ? "\"\"" : nome;
        return "value=".concat(value);
    }

    private String formatMatricula(Integer matricula){
        String value = Objects.isNull(matricula) ? "\"\"" : String.valueOf(matricula);
        return "value=".concat(value);
    }
}
