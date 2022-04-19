package com.example.core.Servlet.agentesServlet;

import com.example.core.Model.Agente;
import com.example.core.View.AgenteViews.AgentesHTMLCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@WebServlet(value = "/agentes")
public class AgenteServlet extends HttpServlet {
    private AgentesHTMLCreator agentesHTMLCreator = new AgentesHTMLCreator();
    private List<Agente> agentes = new ArrayList<>();

    // LISTAGEM AGENTES
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session.isNew()) {
            out.println(agentesHTMLCreator.getTableHtml(agentes));
        }
        else {
            List<Agente> agentesSession = (List<Agente>) session.getAttribute("agentes");
            this.agentes = Objects.isNull(agentesSession) ? this.agentes : agentesSession;
            out.println(agentesHTMLCreator.getTableHtml(this.agentes));
        }
    }

    // SALVAR AGENTES
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");

        if (validaDuplicado(nome,numero, response)){
            response.sendRedirect("agente-duplicado.html");
        }else {
            if (Objects.isNull(id) || id.length() == 0) {
                System.out.println("doPost: new agente");
                Agente agente = new Agente(UUID.randomUUID().toString(), nome, Integer.valueOf(numero));
                agentes.add(agente);
                session.setAttribute("agentes", agentes);
            } else {
                System.out.println("doPost: " + id);
                for (Agente agente : agentes) {
                    if (agente.getId().equals(id)) {
                        agente.setNome(nome);
                        agente.setMatricula(Integer.valueOf(numero));
                    }
                }
            }
            response.sendRedirect(request.getRequestURI());
        }
    }

    private boolean validaDuplicado(String nome, String matricula, HttpServletResponse response){
        for (Agente agente: agentes){
            if (agente.getNome().equals(nome) && agente.getMatricula().equals(Integer.valueOf(matricula))){
                return true;
            }
        }
        return false;
    }
}
