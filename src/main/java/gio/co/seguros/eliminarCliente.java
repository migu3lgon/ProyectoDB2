/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebServlet("/eliminarCliente")

/**
 *
 * @author C.V
 */
public class eliminarCliente extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public eliminarCliente() {
        super();
        
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String poliza;
		poliza = request.getParameter("poliza").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collClientes.collclientes();
                        try {
                            BasicDBObject document = new BasicDBObject();
                            document.put("_id", new ObjectId(poliza));
                            coll.deleteOne(document);
                            //coll.deleteOne(new Document("_id", new ObjectId(poliza)));
                        
                        response.sendRedirect(String.format("exitoAdminC.jsp"));
                        
                        
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                        }
	}
    
}










