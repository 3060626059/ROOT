package root.root8.x大包;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class x05
 */
@WebServlet(name ="x05" ,urlPatterns= {"/root/root8/x大包/x05"} )
public class x05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public x05() {
        super();
        //网页分页
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

		String xcount = request.getParameter("xcounts");
		int x页数=0;
		if (xcount!=null) {
			String xcount2 = request.getParameter("xcount2");
			int x页数2=0;
			if (xcount2!=null) {
				x页数2=Integer.parseInt(xcount2);
			}
			
			if (xcount.equals("shan")) {
				x页数=x页数2-1;
			}
			if (xcount.equals("xia")) {
				x页数=x页数2+1;
			}
		}
		
		
		System.out.println(x页数);
		PrintWriter out = response.getWriter();
		out.append(("<html>" + "<head>" + "<meta  charset=\"UTF-8\">" 
		+ "<title> 无效分页!   无效更新!</title>" 
				+"<style type=\"text/css\">"
				            + "body {font: normal 11px auto sans-serif; color: #4f6b72; background: #E6EAE9; }"
				            + "a { color: #c75f3e; }"
				            + "#mytable {width: 700px;padding: 0;  margin: 0; }"
				            + "caption { padding: 0 0 5px 0;width: 700px;  text-align: right; }"
				            + " th {color: #4f6b72; border-right: 1px solid #C1DAD7; border-bottom: 1px solid #C1DAD7;  border-top: 1px solid #C1DAD7; letter-spacing: 2px; text-transform: uppercase;text-align: left; padding: 6px 6px 6px 12px; background: #CAE8EA; } "
				            + "th.nobg {  border-top: 0;   border-left: 0;  border-right: 1px solid #C1DAD7;  background: none; }"
				            + "td { border-right: 1px solid #C1DAD7;border-bottom: 1px solid #C1DAD7;  background: #fff; font-size:11px; padding: 6px 6px 6px 12px; color: #4f6b72;} "
				            + "td.alt {  background: #F5FAFA; color: #797268; } "
				            + "th.spec { border-left: 1px solid #C1DAD7;border-top: 0;background: #fff;}"
				            + "th.specalt {border-left: 1px solid #C1DAD7;  border-top: 0;  background: #f5fafa; color: #797268; }"
				            +"/*---------for IE 5.x bug*/html>"
				            + "body td{ font-size:11px;}"
				            + "</style>  "
				
				+ "</head>" + "<body>" + ""));
		
		
		out.append("<a>无效消息 :  </7a>"
				+ "<br><hr><a href=\"?xcounts=shan&xcount2="+x页数+"\"><上一页></a>"
				+ "<br><hr><a href=\"?xcounts=xia&xcount2="+x页数+"\"><下一页></a>"
				+ "<br><hr><a>最后</a>"
				+ "<br><hr><a>最前</a>"
				+ "<br><hr><a>当前是 : "+x页数+"</a>"				
				);
		
		out.append("<br><hr><a>无效更新! 0000-001</a><hr>"
				+ "<br><hr><a>未知效果! 0000-023</a><hr></body>"
				+"<html>");
		out.close();
		
		System.out.println("无效更新! 0000-002");
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
