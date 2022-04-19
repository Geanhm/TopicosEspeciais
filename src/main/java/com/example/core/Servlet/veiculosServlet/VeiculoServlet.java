package com.example.core.Servlet.veiculosServlet;

import com.example.core.Model.Veiculo;
import com.example.core.View.VeiculoViews.VeiculosHTMLCreator;

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


@WebServlet(value = "/veiculos")
public class VeiculoServlet extends HttpServlet {
    private VeiculosHTMLCreator veiculosHTMLCreator = new VeiculosHTMLCreator();
    private List<Veiculo> veiculos = new ArrayList<>();

    // LISTAGEM VEICULOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session.isNew()) {
            out.println(veiculosHTMLCreator.getTableHtml(veiculos));
        }
        else {
            List<Veiculo> veiculosSession = (List<Veiculo>) session.getAttribute("veiculos");
            this.veiculos = Objects.isNull(veiculosSession) ? this.veiculos : veiculosSession;
            out.println(veiculosHTMLCreator.getTableHtml(this.veiculos));
        }
    }

    // SALVAR VEICULOS
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = request.getParameter("id");
        String placa = request.getParameter("placa");
        String modelo = request.getParameter("modelo");

        if (validaDuplicado(placa, response)){
            response.sendRedirect("veiculo-duplicado.html");
        }else {
            if (Objects.isNull(id) || id.length() == 0) {
                System.out.println("doPost: new veiculo");
                Veiculo veiculo = new Veiculo(UUID.randomUUID().toString(), placa, modelo);
                veiculos.add(veiculo);
                session.setAttribute("veiculos", veiculos);
            } else {
                System.out.println("doPost: " + id);
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getId().equals(id)) {
                        veiculo.setPlaca(placa);
                        veiculo.setModelo(modelo);
                    }
                }
            }
            response.sendRedirect(request.getRequestURI());
        }
    }

    private boolean validaDuplicado(String placa, HttpServletResponse response){
        for (Veiculo veiculo: veiculos){
            if (veiculo.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }
}
