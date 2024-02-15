package mainCLi;

import java.net.MalformedURLException;
import java.net.URL;

import ClientOfHotel.Services;
import ClientOfHotel.ServicesImplService;

public class MainTest {

	public static void main(String[] args) {
		try {
			URL url  = new URL("http://localhost:8080/HotelService?wsdl");
			ServicesImplService serviceImpl = new ServicesImplService(url);
			Services clone = serviceImpl.getServicesImplPort();
			
			System.out.println(clone.show());
			System.out.println(clone.booking(1, 2022, 11, 17, 2022, 12, 20));
			System.out.println(clone.booking(1, 2022, 12, 21, 2023, 1, 1));
			System.out.println(clone.booking(1, 2022, 2, 20, 2023, 3, 20));
			System.out.println(clone.booking(1, 2023, 2, 20, 2023, 3, 20));
			System.out.println(clone.booking(2, 2023, 1, 1, 2023, 1, 4));
			System.out.println(clone.booking(2, 2023, 1, 5, 2023, 1, 11));
			
			System.out.println(clone.show());
			System.out.println(clone.showReservation(1));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
