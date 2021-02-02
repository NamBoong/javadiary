package com.codechobo.filter;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginAction() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
			
		if(id.equals("nam") && pwd.equals("1234")) {
			HttpSession session = request.getSession();
			
			session.setAttribute("id", "value");
			
			System.out.println("���� ���� " + (String)session.getAttribute("id"));

			// ** ��ǥ : �ϵ� �ڵ� �ٲٱ�
			response.sendRedirect(goPage());  
		}
		else {
			request.setAttribute("msg", "ID �Ǵ� PWD�� Ʋ���ϴ�.");
			RequestDispatcher reqDis = request.getRequestDispatcher("loginForm.jsp"); 
			reqDis.forward(request, response);
		}
	}
	
	String goPage() {
		// ���⿡ ���� board.jsp�� ���;���
		return "board.jsp";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
