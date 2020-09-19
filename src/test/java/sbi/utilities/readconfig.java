package sbi.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readconfig {
	
    Properties prop=new Properties();
	
	public  readconfig(){
	
	try {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/configuration/config.properties");
		prop.load(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public String getbrowser()
	{
		String browser=prop.getProperty("iepath");
		return browser;
	}
	public String getapplicationurl()
	{
		String url=prop.getProperty("baseurl");
		return url;
	}
	public String getloginid()
	{
		String loginid=prop.getProperty("loginid");
		return loginid;
	}
	public String getpassword()
	{
		String pwd=prop.getProperty("password");
		return pwd;
	}
	
}

