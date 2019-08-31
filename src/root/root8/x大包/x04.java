package root.root8.x大包;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.root8.x小包.辅.xdata.xBase链接;



/**
 * Servlet implementation class x03
 */

@WebServlet(name = "root.root8.x大包.x04", urlPatterns = { "/root./root8/x大包/x04" })
public class x04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public x04() {
        super();
        //读取密码的servlet
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String utf_8="utf-8";
		request.setCharacterEncoding(utf_8);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding(utf_8);

		PrintWriter out = response.getWriter();
		out.append(("<html>" + "<head>" + "<meta  charset=\"UTF-8\">" + "<title> 观看数据 </title>" + "<style>"
				+ "#test{ background-color:#C96; text-align:center; line-height:2em;}" + ".over{background-color:#fff;}"
				+ ".out{background-color:#F1F1F1;}" + "</style>" + "<script>" + "window.onload = function(){"
				+ "	//returnColor(\"test\");" + "	setColor(\"test\");" + "}" + "function setColor(id)" + "{"
				+ "	var trs=document.getElementById(id).getElementsByTagName(\"tr\");	\r\n"
				+ "	for(var i=0; i<trs.length; i++)" + "	{" + "		var tds = trs[i].getElementsByTagName(\"td\");"
				+ "		for(var j=0; j<tds.length; j++)" + "		{\r\n" + "			if(j%2==1)\r\n" + "			{"
				+ "				tds[j].className=\"over\";" + "			}" + "			else" + "			{"
				+ "				tds[j].className=\"out\";" + "			}\r\n" + "		}\r\n" + "	}\r\n" + "}\r\n"
				+ "</script>"
				
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
		  
		
		

		//第二部分 数据 
		// String xSQL_wifiConfig_All="select * from wifiConfig";
    		String xSQL_wifiConfig_ssid_psk="select ssid,psk from wifiConfig";
    		File xFileOUT=new File("C:\\Users\\lenovo\\Desktop\\w.vbm");
    		xBase链接 xBase链接=new xBase链接();
    		                 xBase链接.x更换链接(xFileOUT);
    		                 xBase链接.x数据库插入("create table if not exists wifiConfig (hiddenSSID TEXT, GateWay TEXT, Port TEXT, DNS1 TEXT, ssid TEXT, wep_key0 TEXT, Host TEXT, DNS2 TEXT, key_mgmt TEXT, ExclusionList TEXT, IPAddress TEXT, NetworkPrefixLength TEXT, psk TEXT )");

    		StringBuilder x中间数据不含表头=new StringBuilder();
    		                 
    		                 ResultSet x结果集 = xBase链接.x数据库查询(xSQL_wifiConfig_ssid_psk);
				         		ResultSetMetaData x列信息=null; 
	               		           try {
	               					    
										x列信息= x结果集.getMetaData();
	               					    String xColmn[]=new String[x列信息.getColumnCount()];
	               					    
	               					    x中间数据不含表头.append("<tr>");
	               					    for (int i = 1; i <= xColmn.length; i++) {
	               							xColmn[i-1]=x列信息.getColumnName(i);            							
	               							x中间数据不含表头.append("<th>"+x列信息.getColumnName(i)+"</th>");               							
	               						}
	               					    x中间数据不含表头.append("</tr>");
	               					    
	               					             while (x结果集.next()) {
	               					            	 x中间数据不含表头.append("<tr>");
	               							            for (String x列 : xColmn) {
	               								               String x数据 = x结果集.getString(x列);
	               								               if (x数据!=null) {
																x数据=x数据.substring(1, x数据.length()-1);//掐头去尾算法
	               								               }
	               								              x中间数据不含表头.append("<th>"+x数据+"</th>");
	               							             }
	               							            x中间数据不含表头.append("<th><button href=\"#\" width=89px>删除本条数据</button></th></tr>");
	               						           }	       
 
	               					    x结果集.close();
	               				      } catch (SQLException e) {}	
    		out.append("<a>我自己写的表格<br><br><hr></a><br>"
    		+"<table id=\"mytable\" border=1 width=987px>"
    		+ "<tr>"
    		
    		+ "<th class=\"alt\">壹</th>"
    		+ "<th class=\"alt\">贰</th>"
    		+ "<th class=\"alt\">叁</th>"
    		
    		
    		+ "</tr>"
    		+ "</table><br><br><br><table border=1 weight=987px height=55px>"
    		            + x中间数据不含表头
    		+ "</table>");
    		
    		
    		
		          		       
		               	    
		
		out.append("</table>");
		
		
		xBase链接.close();
		
		//以前是 '第一部分 数据  ' 现在是最后
				out.append("<a>应该是那部分是读数据的怎么回事啊?疑问"+
						"<br>真是的,改自己写的代码真的是讨厌,一直有一个空指针,不想弄了,自己的烂摊子真讨厌!<br>这一行就是搞笑的<br></a>"+
						"<a>昨天晚上终于找到原因,数据库代码是依赖 sqlite.jar,"
						+ "谁知道汤姆猫服务器编译Java代码,对引用的包是放在 WEB-INF/lib/里面<br> "+
						"我一直是放在/lib/下面就以为没事,现在才明白,一个servlet 项目中是有两个互不干扰的模块,一 Java程序,二 HTML网页,三 其它<br>"
						+""
						+ "</a>");
		
		out.append("</body>"
				+"<html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
