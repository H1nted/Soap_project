package services;

import javax.jws.WebService;

import Creator.HotelCreator;
import Creator.HotelCreatorImpl;


@WebService(endpointInterface="services.Services")
public class ServicesImpl implements Services {
	
	//Attributes
	private HotelCreator hc ;
	
	//Constructor
	public ServicesImpl() {	
		hc = new HotelCreatorImpl(); 
	}
	
	//Methods
	
	@Override
	public String Show() {
		
		return hc.Show();
	}

	@Override
	public String Booking(int numéro, int year, int month, int day, int yeardep, int monthdep, int daydep) {

		return hc.Booking(numéro, year, month, day, yeardep, monthdep, daydep);
	}

	@Override
	public String ShowReservation(int numéro) {

		return hc.ShowReservation(numéro);
	}

	@Override
	public String SearchByID(String id) {
		
		return hc.SearchByID(id);
	}




	

}
