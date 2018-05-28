package com.aplose.smooss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(urlPatterns=("*.upload"))
@MultipartConfig(location ="C:\\Users\\julie\\Desktop", fileSizeThreshold = 1000* 1000, maxFileSize = 1000*1000)
public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
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
		getServletContext().getRequestDispatcher("/uploadFile.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Collection<Part> parts = request.getParts();
		for (Iterator iterator = parts.iterator(); iterator.hasNext();) {
			Part part = (Part) iterator.next();
			printPart(part, out);
		}
		out.write("<h2>Total parts :" + parts.size() + "</h2>");

		Part part = request.getPart("file");
		System.out.println("File name = " + getFileName(part));
		printPart(part, out);
		String fileName = getFileName(part);
		part.write(fileName);

		// doGet(request, response);
	}

	private void printPart(Part part, PrintWriter pw) {
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("Name : ").append(part.getName());
		sb.append("<br>");
		sb.append("Content Type :").append(part.getContentType());
		sb.append("<br>");
		sb.append("Size :").append(part.getSize());
		sb.append("<br>");
		
		for(String header : part.getHeaderNames()) {
			sb.append(header).append(" : ").append(part.getHeader(header));
			sb.append("<br>");
			
		}
		sb.append("</p>");
		pw.write(sb.toString());


	}

	private String getFileName(Part part) {
		//String partHeader = part.getHeader("content-disposition");
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String result = cd.substring(cd.indexOf('=')+ 1).trim()
						.replace("\"", "");
				result = result.substring(result.lastIndexOf("\\")+1);
				return result;
			}
		}
			
		return null;
	}


}
