package root.root7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class x02
 */
@WebServlet(name = "root.root7.x02",urlPatterns = {"/root/root7/x02"})
public class x02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public x02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String utf_8="utf-8";
		request.setCharacterEncoding(utf_8);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding(utf_8);
		
		String xstring = request.getParameter("me");
		//request.
		//response.
		System.out.println("mmmm"+xstring);
		response.getWriter().append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>x02 处理</title>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>"+
			   "</boby>"+
			   "<a>  你的输入是"+xstring+"</a>"+
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
