package mainCLi;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
	public static String SERVICE_WSDL_URL;
	public static final String QUIT = "0";
	
	protected void setTestServiceWSDLUrl (BufferedReader inputReader) throws IOException{
		System.out.println("Please provide the URL to the web service to consume: ");
		SERVICE_WSDL_URL =inputReader.readLine();
		
		while(!validServiceWSDLUrl()) {
			System.err.println("ERROR : "+SERVICE_WSDL_URL +" isn't a valid web server. Please try again.");
			SERVICE_WSDL_URL =inputReader.readLine();
		}
	}
	
	protected abstract boolean validServiceWSDLUrl();
	
	protected abstract void menu();
}
