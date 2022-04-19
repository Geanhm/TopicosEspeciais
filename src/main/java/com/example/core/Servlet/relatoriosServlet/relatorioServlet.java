package com.example.core.Servlet.relatoriosServlet;

import com.example.core.Model.Agente;
import com.example.core.Model.Alocacao;
import com.example.core.Model.Veiculo;
import com.example.core.View.Relatorios.RelatorioViewCreator;

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

@WebServlet( value = "/relatorios")
public class relatorioServlet extends HttpServlet {

	private List<Alocacao> alocacoes = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Agente> agentes = new ArrayList<>();
    private RelatorioViewCreator relatorioViewCreator = new RelatorioViewCreator();

    //  PAGE VIATURAS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: relatorios");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        List<Alocacao> alocacoesSession = (List<Alocacao>) session.getAttribute("alocacoes");
        this.alocacoes = Objects.isNull(alocacoesSession) ? this.alocacoes : alocacoesSession;

        List<Veiculo> veiculosSession = (List<Veiculo>) session.getAttribute("veiculos");
        this.veiculos = Objects.isNull(veiculosSession) ? this.veiculos : veiculosSession;

        List<Agente> agentesSession = (List<Agente>) session.getAttribute("agentes");
        this.agentes = Objects.isNull(agentesSession) ? this.agentes : agentesSession;

        out.println(relatorioViewCreator.getTableHtml(agentes, veiculos, alocacoes));
    }
}
