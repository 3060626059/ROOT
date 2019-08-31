package root.root8.x小包.主;

import java.io.File;
import java.util.ArrayList;

import root.root8.x小包.辅.xdata.xBase链接;
import root.root8.x小包.辅.xdb.xData;
import root.root8.x小包.辅.xtool.xFild;

public class 测试6_8 {

	static File xFileOUT = new File("C:\\Users\\lenovo\\Desktop\\w.vbm");
	//写入模块

	public static void main(String[] args) {


		String xSQL_wifiConfig="select * from wifiConfig";
				
		ArrayList<File> xarray = xFild.xFileS1(
				new File("C:\\Users\\lenovo\\Desktop\\手机备份\\HuaweiBackup\\backupFiles\\"), 
				"wifiConfig");					
		xData xData=new xData();	
		xBase链接 xBase链接=new xBase链接();	
		       //遍历文件
				for (int i = 0; i < xarray.size(); i++) {
					File xfile = xarray.get(i);
					xBase链接.x更换链接(xfile);
					xData.xAddResultSet结果追加( xBase链接.x数据库查询(xSQL_wifiConfig) );
				}
				//更换数据库,把数据写入
				xBase链接.x更换链接(xFileOUT);
				xBase链接.x数据库插入("create table if not exists wifiConfig (hiddenSSID TEXT, GateWay TEXT, Port TEXT, DNS1 TEXT, ssid TEXT, wep_key0 TEXT, Host TEXT, DNS2 TEXT, key_mgmt TEXT, ExclusionList TEXT, IPAddress TEXT, NetworkPrefixLength TEXT, psk TEXT )");
				xData.xRemoveDuplicate重复移除(xBase链接.x数据库查询(xSQL_wifiConfig));
				xBase链接.x数据库插入(xData.xSQL语法("wifiConfig"));
				xBase链接.close();
	}

}
