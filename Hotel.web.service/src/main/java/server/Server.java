package server;

import javax.xml.ws.Endpoint;

import services.ServicesImpl;

public class Server {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/HotelService", new ServicesImpl());
		System.out.println();
		System.out.println();
		System.err.println("~~~~~ WEB Service is ready to GO !!! ~~~~~");

	}
}
