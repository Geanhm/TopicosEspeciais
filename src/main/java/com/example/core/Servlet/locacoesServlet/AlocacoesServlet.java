package com.example.core.Servlet.locacoesServlet;


import com.example.core.Model.Alocacao;
import com.example.core.View.AlocacaoViews.AlocacoesHTMLCreator;

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

@WebServlet( value = "/alocacoes")
public class AlocacoesServlet extends HttpServlet {

    private List<Alocacao> alocacoes = new ArrayList<>();
    private AlocacoesHTMLCreator alocacoesHTMLCreator = new AlocacoesHTMLCreator();

//  PAGE ALOCACOES
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: alocacoes");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<Alocacao> locacoesSession = (List<Alocacao>) session.getAttribute("alocacoes");
        this.alocacoes = Objects.isNull(locacoesSession) ? this.alocacoes : locacoesSession;
        out.println(alocacoesHTMLCreator.getTableHtml(alocacoes));
    }
}
