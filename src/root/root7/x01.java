package root.root7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class x01
 */
@WebServlet(name = "root.root7.x01_目的未知",urlPatterns = {"/root/root7/x01"})
public class x01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public x01() {
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
		
		
		//PrintWriter out = response.getWriter();
		
		
		//request 域对象
		//request.setAttribute("username", "USERNAME");
		
		
		//request.getRequestDispatcher(arg0) 分派器
		
		
		//reuest forward 转发
		//表示使用转发的方法 把 request response 对象传递给下一个servlet
		request.getRequestDispatcher("/x请求转发/x02").forward(request, response);
		//response.sendRedirect(arg0);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
