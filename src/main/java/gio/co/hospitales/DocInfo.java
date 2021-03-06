package gio.co.hospitales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class DocInfo
 */
@WebServlet("/DocInfo")
public class DocInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static int hospitalNum = JavaConnectDb.getHospNum();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Generar jsons
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Obtener # del hospital
            getInfoCookies(request,response);
            //Conexion con db oracle
            Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
            //Response info
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            try{
                //var query sql
                String sql;
                sql = "select * from usuario where tipo_usuario_id = 4 order by usuario_id";
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                //Array jsons
                JSONArray jArray = new JSONArray();
                int i = 0;
                while(rs.next()){
                    //obtener parametros
                    String id = rs.getString("usuario_id");
                    String name = rs.getString("Nombre");
                    String lastN = rs.getString("Apellido");
                    String idType = rs.getString("tipo_usuario_id");
                    String especialidadId = rs.getString("especialidad_id");
                    String tel = rs.getString("telefono");
                    //Crear objeto json
                    JSONObject arrayObj = new JSONObject();
                    arrayObj.put("id",id);
                    arrayObj.put("name",name+" "+lastN);
                    arrayObj.put("idType",idType);
                    arrayObj.put("especialidadId",especialidadId);
                    arrayObj.put("tel",tel);
                    //insertar objeto a array jsons
                    jArray.add(i,arrayObj);
                    i++;
                }
                rs.close ();
                pst.close ();
                conn.close();
                out.print(jArray);
            }catch(Exception e){
                System.err.println(e);
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
        
        protected void getInfoCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            Cookie[] cookiesInf = request.getCookies();
            if(cookiesInf !=null){
                for(Cookie cookie : cookiesInf){
                    if(cookie.getName().equals("hospNum")){
                        hospitalNum = Integer.parseInt(cookie.getValue());
                    }
                }
            }
        }
}
