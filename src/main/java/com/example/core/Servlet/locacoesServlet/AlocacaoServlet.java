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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@WebServlet( value = "/alocacao")
public class AlocacaoServlet extends HttpServlet {

	private List<Alocacao> alocacoes = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Agente> agentes = new ArrayList<>();
    private AlocacaoHTMLCreator alocacaoHTMLCreator = new AlocacaoHTMLCreator();

//  PAGE 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: alocacao");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<Agente> agentesSession = (List<Agente>) session.getAttribute("agentes");
        this.agentes = Objects.isNull(agentesSession) ? this.agentes : agentesSession;
        
        List<Veiculo> veiculosSession = (List<Veiculo>) session.getAttribute("veiculos");
        this.veiculos = Objects.isNull(veiculosSession) ? this.veiculos : veiculosSession;
        
        List<Alocacao> locacoesSession = (List<Alocacao>) session.getAttribute("alocacoes");
        this.alocacoes = Objects.isNull(locacoesSession) ? this.alocacoes : locacoesSession;

        if(agentes.isEmpty()) { 
        	response.sendRedirect("sem-agentes.html");
        }
        else if (veiculos.isEmpty()) {
        	response.sendRedirect("sem-veiculos.html");
        }
        else {
        	out.println(alocacaoHTMLCreator.getPageHtml(new Alocacao(), veiculos, agentes));
        }
    }

//  SALVAR ALOCACAO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        String id = request.getParameter("id");
        String agenteID = request.getParameter("agente");
        String veiculoID = request.getParameter("veiculo");
        
        if (agenteID.isEmpty()) {
        	response.sendRedirect("agentes");
        }else if(veiculoID.isEmpty()) {
        	response.sendRedirect("veiculos");
        }

        try {
        	if (Objects.nonNull(session.getAttribute("alocacoes"))){
                this.alocacoes =(List<Alocacao>) session.getAttribute("alocacoes");
            }
            if (Objects.nonNull(session.getAttribute("veiculos"))){
                veiculos = (List<Veiculo>)session.getAttribute("veiculos");
            }

            if (Objects.nonNull(session.getAttribute("agentes"))){
                agentes = (List<Agente>)session.getAttribute("agentes");
            }

            Agente _agente = agentes.stream().filter(can -> can.getId().equals(agenteID)).findFirst().orElse(null);
            Veiculo _veiculo = veiculos.stream().filter(can -> can.getId().equals(veiculoID)).findFirst().orElse(null);
            
            if (Objects.isNull(_agente)) response.sendRedirect("agentes");
            if (Objects.isNull(_veiculo)) response.sendRedirect("veiculos");
            
            if (Objects.isNull(id) || id.isEmpty()) {
                System.out.println("doPost: new Alocacao");
                Alocacao alocacao = new Alocacao(UUID.randomUUID().toString(), _veiculo, _agente);
                alocacoes.add(alocacao);
            }
            else{
                System.out.println("doPost Alocacao: "+ id);
                for(Alocacao alocacao : alocacoes){
                    if (alocacao.getId().equals(id)){
                    	alocacao.setAgente(_agente);
                    	alocacao.setVeiculo(_veiculo);
                    }
                }
            }
            session.setAttribute("alocacoes", alocacoes);
        }catch (Exception e){
            response.sendRedirect("registro-error.html");
        }
        response.sendRedirect("registro-success.html");
    }
}
