package services;




import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface Services {

	@WebMethod
	String Show() ;
	
	@WebMethod
	String Booking(int numéro, int year, int month, int day,int yeardep, int monthdep, int daydep);
	
	@WebMethod
	String ShowReservation(int numéro);
	
	@WebMethod
	String SearchByID(String id);
}

