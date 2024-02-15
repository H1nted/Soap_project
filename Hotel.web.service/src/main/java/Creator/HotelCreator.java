package Creator;



public interface HotelCreator {
	
	String Show() ;
	
	String Booking(int numéro, int year, int month, int day,int yeardep, int monthdep, int daydep);
	
	String ShowReservation(int numéro);
	
	String SearchByID(String id);
	
}
