package root.root8.x小包.主;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import root.root8.x小包.辅.xdata.xBase链接;


public class 测试8 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		String xSQL_wifiConfig_All="select * from wifiConfig";
   		// String xSQL_wifiConfig_ssid_psk="select ssid,psk from wifiConfig";
   		xBase链接 xBase链接=new xBase链接();
   		File xFileOUT=new File("C:\\Users\\lenovo\\Desktop\\w.vbm");
		xBase链接.x更换链接(xFileOUT);
   		//xBase链接.x数据库插入("create table if not exists wifiConfig (hiddenSSID TEXT, GateWay TEXT, Port TEXT, DNS1 TEXT, ssid TEXT, wep_key0 TEXT, Host TEXT, DNS2 TEXT, key_mgmt TEXT, ExclusionList TEXT, IPAddress TEXT, NetworkPrefixLength TEXT, psk TEXT )");		               		
   				ResultSet tmpresultset = xBase链接.x数据库查询(xSQL_wifiConfig_All);		               		           
   		           ResultSetMetaData metadata=null; 
   		           try {
   					    metadata= tmpresultset.getMetaData();
   					    String xColmn[]=new String[metadata.getColumnCount()];
   					    for (int i = 1; i <= xColmn.length; i++) {
   							xColmn[i-1]=metadata.getColumnName(i);
   							//out.append("<td>"  +  xColmn[i-1]   +  "</td>");
   							System.out.print(xColmn[i-1]+"     ");
   						}
   					    while (tmpresultset.next()) {
   					    	//out.append("<tr>");
   					    	System.out.println();
   							for (String string : xColmn) {
   								Object obj = tmpresultset.getObject(string);
   								//out.append("<td>"  +  obj   +  "</td>");
   								System.out.print(obj+"     ");
   							   }
   						}	               					    
   					    tmpresultset.close();
   				      } catch (SQLException e) {}	               		       
   	    xBase链接.close();
	}

}
