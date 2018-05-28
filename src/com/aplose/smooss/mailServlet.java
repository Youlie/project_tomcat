package com.aplose.smooss;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailServlet
 */
@WebServlet("/mailServlet")
public class mailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email= request.getParameter("email");
		String subject= request.getParameter("subject");
		String mailContent = request.getParameter("mailContent");
		
		try {
			Context InitialContext = new InitialContext();
			Context envContext = (Context)InitialContext.lookup("java:com/env");
			Session mailSession =  (Session)envContext.lookup("mail/Session");
			
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("contact@smooss.fr"));
			
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress("email");
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("subject");
			message.setContent("mailContent", "text/plain");
			Transport.send(message);
			
		} catch (NamingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		
//	}

}
