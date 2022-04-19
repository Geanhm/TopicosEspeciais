package com.example.core.Servlet.agentesServlet;

import com.example.core.Model.Agente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet( value = "/agente-remove")
public class AgenteRemoveServlet extends HttpServlet {

    private List<Agente> agentes = new ArrayList<>();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        HttpSession session=request.getSession();

        if (Objects.nonNull(session.getAttribute("agentes"))){
            agentes = (List<Agente>)session.getAttribute("agentes");
        }

        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/agentes");

        agentes = agentes.stream().filter(agente -> !agente.getId().equals(id)).collect(Collectors.toList());

        session.setAttribute("agentes",agentes);
        response.sendRedirect(request.getContextPath() + "/agentes");
    }
}
