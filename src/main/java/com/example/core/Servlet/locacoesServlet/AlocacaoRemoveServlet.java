package com.example.core.Servlet.locacoesServlet;

import com.example.core.Model.Alocacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(value = "/alocacao-remove")
public class AlocacaoRemoveServlet extends HttpServlet {

    private List<Alocacao> alocacoes = new ArrayList<>();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        HttpSession session=request.getSession();

        if (Objects.nonNull(session.getAttribute("alocacoes"))){
        	alocacoes = (List<Alocacao>)session.getAttribute("alocacoes");
        }

        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/viaturas");

        alocacoes = alocacoes.stream().filter(locacao -> !locacao.getId().equals(id)).collect(Collectors.toList());

        session.setAttribute("alocacoes",alocacoes);
        response.sendRedirect(request.getContextPath() + "/alocacoes");
    }
}
