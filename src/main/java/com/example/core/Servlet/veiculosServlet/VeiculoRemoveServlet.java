package com.example.core.Servlet.veiculosServlet;

import com.example.core.Model.Veiculo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet( value = "/veiculo-remove")
public class VeiculoRemoveServlet extends HttpServlet {

    private List<Veiculo> veiculos = new ArrayList<>();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        HttpSession session=request.getSession();

        if (Objects.nonNull(session.getAttribute("veiculos"))){
            veiculos = (List<Veiculo>)session.getAttribute("veiculos");
        }

        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/veiculos");

        veiculos = veiculos.stream().filter(veiculo -> !veiculo.getId().equals(id)).collect(Collectors.toList());

        session.setAttribute("veiculos",veiculos);
        response.sendRedirect(request.getContextPath() + "/veiculos");
    }
}
