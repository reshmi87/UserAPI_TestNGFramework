package Commons;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = new Properties();
	private String username;
	private String password;
	
	public String getbaseurl() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String baseurl = prop.getProperty("baseurl");
		return baseurl;
	}
	
	public String getusername() throws IOException {
	prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
	username = prop.getProperty("username");
	return username;
	}
	
	public String getpassword() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		password = prop.getProperty("password");
		return password;
		}
	
	public String getpostendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String postendpoint = prop.getProperty("postendpoint");
		return postendpoint;
		}
	
	public String getdeletebyusernameendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String deletebyusernameendpoint = prop.getProperty("deletebyusernameendpoint");
		return deletebyusernameendpoint;
		}
	
	public String getdeletebyidendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String deletebyuseridendpoint = prop.getProperty("deletebyuseridendpoint");
		return deletebyuseridendpoint;
		}
	
	public String get_getbyusernameendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String getbyusernameendpoint = prop.getProperty("getbyusernameendpoint");
		return getbyusernameendpoint;
		}
	
	public String get_getbyuseridendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String getbyuseridendpoint = prop.getProperty("getbyuseridendpoint");
		return getbyuseridendpoint;
		}
	
	public String getpatchendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String patchendpoint = prop.getProperty("patchendpoint");
		return patchendpoint;
		}
	
	public String getputendpoint() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String putendpoint = prop.getProperty("putendpoint");
		return putendpoint;
		}
	
	public String getalluser() throws IOException {
		prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("configuration.properties"));
		String getalluserendpoint = prop.getProperty("getalluserendpoint");
		return getalluserendpoint;
		}
	
	
	
}
