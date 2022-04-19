package com.example.core.Servlet.agentesServlet;

import com.example.core.Model.Agente;
import com.example.core.View.AgenteViews.AgenteHTMLCreator;

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

@WebServlet( value = "/agente-edit")
public class AgenteEditServlet extends HttpServlet {

    private AgenteHTMLCreator agenteHTMLCreator = new AgenteHTMLCreator();
    private static Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    // EDIT AGENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = String.valueOf(request.getParameter("id"));
        Agente agente = new Agente();

        List<Agente> agentes = (List<Agente>)session.getAttribute("agentes");
        if(pattern.matcher(id).matches() && Objects.nonNull(agentes)) {
            agente = agentes.stream().filter(cand -> cand.getId().equals(id)).findFirst().orElse(null);
        }
        out.println(agenteHTMLCreator.getPageHtml(agente));
    }
}
