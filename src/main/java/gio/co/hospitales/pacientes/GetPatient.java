package gio.co.hospitales.pacientes;

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
 * Servlet implementation class GetPatient
 */
@WebServlet("/GetPatient")
public class GetPatient extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static String hospitalNum = "2";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatient() {
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
            String parPId = request.getParameter("pId");
            if ((parPId != null) && !(parPId.equals(""))) {
                int pId = Integer.parseInt(request.getParameter("pId"));
                url = "http://localhost:8080/proyectoDB2-Hospital1/restP/patient/getPatient?pId=" + pId;
            } else {
                url = "http://localhost:8080/proyectoDB2-Hospital1/restP/patient/getPatient";
            }
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response2 = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response2.append(inputLine);
            }
            if(true){
                int num = 0;
                int res = num *100;
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

