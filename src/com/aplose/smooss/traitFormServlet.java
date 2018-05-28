package com.aplose.smooss;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class traitFormServlet
 */
@WebServlet(
		urlPatterns = { "/traitFormServlet" }, 
		initParams = { 
				@WebInitParam(name = "testInitParam", value = "valeur")
		})
public class traitFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public traitFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Je passe dans init >>>>>>>");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Je passe dans destory >>>>>>>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pseudo = request.getParameter("pseudo");
		String passWord = request.getParameter("passWord");
		String confirPassWord = request.getParameter("confirPassWord");
		
		response.getWriter().append("<h1 style='color:orange;'>Coucou "+pseudo+"</h1><h3>Ton mot de passe est "+passWord+"</h3>").append(request.getContextPath());
		response.getWriter().append("HOLAAAAA !!! >>>>> Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
