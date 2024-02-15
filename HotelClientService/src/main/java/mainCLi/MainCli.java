package mainCLi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import ClientOfHotel.Services;
import ClientOfHotel.ServicesImplService;

public class MainCli extends AbstractMain{
	
	 
	
	
	public static IntegerInputProcessor inputProcessor;
	public static void main(String[] args) {
		
		MainCli main = new MainCli();
		Services proxy = null ;
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			main.setTestServiceWSDLUrl(inputReader);
			proxy = getProxy();
		
		do {
			main.menu();
			userInput = inputReader.readLine();
			main.processUserInput(inputReader, userInput, proxy);
			Thread.sleep(3000);
		}
		while (!userInput.equals(QUIT));
	} catch (MalformedURLException e) {
		System.err.println(SERVICE_WSDL_URL+" isn't a valid web server. Please try again.");
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}	
	}
	@Override
	protected boolean validServiceWSDLUrl() {
		
		return SERVICE_WSDL_URL.equals("http://localhost:8080/HotelService?wsdl");
	}
	
	private static Services getProxy() 
			throws MalformedURLException {			
		return new ServicesImplService(new URL(SERVICE_WSDL_URL)).getServicesImplPort();
	}
	
	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit");
		builder.append("\n1. Show catalogue of the hotel.");
		builder.append("\n2. Book a hotel room.");
		builder.append("\n3. Show a room's reservations.");
		builder.append("\n4. Show a reservation by ID.");
		System.out.println(builder);		
	}
	
	private void processUserInput(BufferedReader inputReader, String userInput, Services proxy) {
		try {
			switch(userInput) {
			case "1" :
				System.out.println(proxy.show());
				break;
				
				
			case "2" :
				inputProcessor = new IntegerInputProcessor(inputReader);
				System.out.println("Choose a room number : ");
				int number = inputProcessor.process();
				
				System.out.println("Choose the year of arrival : ");
				int yearAr = inputProcessor.process();
				while (yearAr <1990 || yearAr>2050) {
					System.err.println("Choose a VALID year of arrival (1990 < Year < 2050) : ");
					yearAr = inputProcessor.process();
				}
				
				System.out.println("Choose the month of arrival : ");
				int monthAr = inputProcessor.process();
				while (monthAr <1 || monthAr >12) {
					System.err.println("Choose a VALID month : ");
					monthAr = inputProcessor.process();
				}
				
				System.out.println("Choose the day of arrival : ");
				int dayAr = inputProcessor.process();
				
				ArrayList<Integer> thirtyone = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
				ArrayList<Integer> thirty = new ArrayList<>(Arrays.asList(4, 6, 9, 11));
				
				if (thirtyone.contains(monthAr)) {
					while (dayAr <1 || dayAr>31) {
					System.err.println("Choose a VALID day : ");
					dayAr = inputProcessor.process();
					}
				}
				else if (thirty.contains(monthAr)){
						while (dayAr <1 || dayAr>30) {
						System.err.println("Choose a VALID day : ");
						dayAr = inputProcessor.process();
						}
												}
				else 
					while (dayAr <1 || dayAr>28) {
						System.err.println("Choose a VALID day for february : ");
						dayAr = inputProcessor.process();
						}
				
				System.out.println("Choose the year of departure : ");
				int yearDep = inputProcessor.process();
				while (yearDep <1990 || yearAr>2050) {
					System.err.println("Choose a VALID year of arrival (1990 < Year < 2050) : ");
					 yearDep = inputProcessor.process();
				}
				
				System.out.println("Choose the month of departure : ");
				int monthDep = inputProcessor.process();
				while (monthDep <1 || monthDep >12) {
					System.err.println("Choose a VALID month : ");
					monthDep = inputProcessor.process();
				}
				System.out.println("Choose the day of departure : ");
				int dayDep = inputProcessor.process();
				if (thirtyone.contains(monthDep)) {
					while (dayDep <1 || dayDep>31) {
					System.err.println("Choose a VALID day : ");
					dayDep = inputProcessor.process();
					}
				}
				else if (thirty.contains(monthDep)){
						while (dayDep <1 || dayDep>30) {
						System.err.println("Choose a VALID day : ");
						dayDep = inputProcessor.process();
						}
												}
				else 
					while (dayDep <1 || dayDep>28) {
						System.err.println("Choose a VALID day for february : ");
						dayDep = inputProcessor.process();
						}
				
				System.out.println(proxy.booking(number, yearAr, monthAr, dayAr, yearDep, monthDep, dayDep));
				break;
				
				
			case "3" :
				inputProcessor = new IntegerInputProcessor(inputReader);
				System.out.println("Room number : ");
				number =inputProcessor.process();
				System.out.println(proxy.showReservation(number));
				break;
				
				
			case "4" :
				System.out.println("Please enter your reservation ID : ");
				String id = inputReader.readLine();
				System.out.println(proxy.searchByID(id));
				break;
				
				
			case QUIT :
				System.out.println("Thank you for visiting our hotel. Until next time.");
				return;
				
				
			default :
				System.out.println("Sorry, wrong input. Please try again.");
				return;		
				
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

	}




}
