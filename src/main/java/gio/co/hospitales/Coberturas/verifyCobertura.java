/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales.Coberturas;

import gio.co.hospitales.JavaConnectDb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author migue
 */
@WebServlet("/verifyCobertura")
public class verifyCobertura extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int hospitalNum = JavaConnectDb.getHospNum(); 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyCobertura() {
        super();
        
    }

    // Generar jsons
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response info
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url;
            String dpi = request.getParameter("dpi");
            String servicio = request.getParameter("servicio");
            int hospital = hospitalNum;
            url = "http://localhost:8082/proyectoDB2-seguro/restAuth/auth/verify?dpi=" + dpi + "&servicio=" + servicio + "&hospital=" + hospital;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response2 = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response2.append(inputLine);
            }
            in.close();
            //print in String
            out.println(response2.toString());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }
}
