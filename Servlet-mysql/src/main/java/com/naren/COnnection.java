package com.naren;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/COnnection")
public class COnnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public COnnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out = response.getWriter();
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=rootjdbc:mysql://127.0.0.1:3306/?user=root","root","Narenadmin@25");
			Statement st = con.createStatement();
			String email  = request.getParameter("email");
			String sql = "SELECT * FROM naren_db.users";
		
			ResultSet rs = st.executeQuery(sql);
			
		
			out.println("E-mails");
			while (rs.next()) {
				
				
				out.println("<br/>"+rs.getString("email"));
				
			}
			
			
		
		} catch (Exception e) {
			
			out.print(e);
		}
		
		
		
		
		
		
	}
}
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
