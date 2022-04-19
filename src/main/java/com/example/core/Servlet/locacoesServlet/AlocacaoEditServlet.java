package com.example.core.Servlet.locacoesServlet;

import com.example.core.Model.Agente;
import com.example.core.Model.Alocacao;
import com.example.core.Model.Veiculo;
import com.example.core.View.AlocacaoViews.AlocacaoHTMLCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@WebServlet( value = "/alocacao-edit")
public class AlocacaoEditServlet extends HttpServlet {

    private AlocacaoHTMLCreator alocacaoHTMLCreator = new AlocacaoHTMLCreator();
    private static Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    // EDIT LOCACAO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = String.valueOf(request.getParameter("id"));
        Alocacao locacao = new Alocacao();

        List<Agente> agentes = (List<Agente>)session.getAttribute("agentes");
        List<Veiculo> veiculos = (List<Veiculo>)session.getAttribute("veiculos");
        List<Alocacao> alocacoesSession = (List<Alocacao>) session.getAttribute("alocacoes");

        if(pattern.matcher(id).matches() && Objects.nonNull(alocacoesSession)) {
        	locacao = alocacoesSession.stream().filter(alo -> alo.getId().equals(id)).findFirst().orElse(null);
        }
        out.println(alocacaoHTMLCreator.getPageHtml(locacao, veiculos,agentes));
    }
}
