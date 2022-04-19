package com.example.core.Servlet.veiculosServlet;

import com.example.core.Model.Veiculo;
import com.example.core.View.VeiculoViews.VeiculoHTMLCreator;

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

@WebServlet( value = "/veiculo-edit")
public class VeiculoEditServlet extends HttpServlet {

    private VeiculoHTMLCreator veiculoHTMLCreator = new VeiculoHTMLCreator();
    private static Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    // EDIT VEICULO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = String.valueOf(request.getParameter("id"));
        Veiculo veiculo = new Veiculo();

        List<Veiculo> veiculos = (List<Veiculo>)session.getAttribute("veiculos");
        if(pattern.matcher(id).matches() && Objects.nonNull(veiculos)) {
            veiculo = veiculos.stream().filter(cand -> cand.getId().equals(id)).findFirst().orElse(null);
        }
        out.println(veiculoHTMLCreator.getPageHtml(veiculo));
    }
}
