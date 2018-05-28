package com.aplose.smooss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.aplose.smooss.action.Action;

/**
 * Servlet implementation class Controler
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF = "/WEB-INF/conf.txt";

	private HashMap<String, String> error = new HashMap<String, String>();
	private HashMap<String, Action> actions = new HashMap<String, Action>();
	private HashMap<String, String> success = new HashMap<String, String>();

	@Override
	public void init() throws ServletException {
		super.init();
		try {

			ServletContext context = getServletContext();
			InputStream is = context.getResourceAsStream(CONF);
			if (is != null) {
				BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
				for (String line = bfr.readLine(); line != null; line = bfr.readLine()) {
					if (line.trim().startsWith("#")) {
						continue;
					}
					String[] confLine = line.split(";");
					if (confLine.length == 4) {
						// premier element est le nom de l'action
						String actionName = confLine[0];
						// chargement de l'action
						actions.put(actionName, (Action) Class.forName(confLine[1]).newInstance());
						success.put(actionName, confLine[2]);
						error.put(actionName, confLine[3]);
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Action action;
		String pAction = request.getParameter("actionName");
		if (null == pAction) {
			pAction ="login.do";
		}
		action= actions.get(pAction);
		
		if (null!= action){
				boolean executeSuccess = action.execute(request, response);
				RequestDispatcher dispatcher = null;
				String url = null;
				if (executeSuccess) {
					url =  success.get(pAction);
				}else {
					url = error.get(pAction);
				}
				dispatcher = getServletContext().getRequestDispatcher(url);
				
				if( dispatcher != null) {
					dispatcher.forward(request, response);
			}
			
		}
		
		//ICI ON TRAVAIL 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
