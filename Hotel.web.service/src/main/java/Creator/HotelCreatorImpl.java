package Creator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import body.Chamber;
import body.Hotel;
import body.Reservation;
import body.Stars;

public class HotelCreatorImpl implements HotelCreator {
	//Attributes
	
	private ArrayList<Chamber> chambers = new ArrayList<Chamber>();
	private Hotel hotel;
	
	//constructor
	public HotelCreatorImpl() {
		chambers.addAll(Arrays.asList(
				new Chamber(1,2,60),
				new Chamber(2,1,30),
				new Chamber(3,1,30),
				new Chamber(4,2,60),
				new Chamber(5,1,30),
				new Chamber(6,2,60),
				new Chamber(7,1,30),
				new Chamber(8,2,60),
				new Chamber(9,2,60),
				new Chamber(10,3,90),
				new Chamber(11,3,90),
				new Chamber(12,3,90),
				new Chamber(13,1,30),
				new Chamber(14,3,90),
				new Chamber(15,3,90)
				));
		hotel = new Hotel("Prime Hotel",Stars.E4,this.chambers);
	}
	
	//Methods

	@Override
	public String Show() {

		String complete = "";
		String s = "\n\n~~~~~~The Hotel '"+ hotel.getName()+" ("+hotel.getStar()+ " *)' contains these rooms : \n\n";
		for(Chamber c : hotel.getChambers()){
			if( c.getReservation().size() == 0) {
			s += ("**Room number : (" +c.getNumber()+ ") | N° Beds : "+c.getBeds() +" | Price : "+c.getPrice() +" $ | Available.\n");
			}
			
			else if( c.getReservation().size() == 3) {
			s += ("**Room number : (" +c.getNumber()+ ") | N° Beds : "+c.getBeds() +" | Price : "+c.getPrice() +" $ | Full.\n");
				}
			
			else {
				int i = 1 ;
				for(Reservation r : c.getReservation()) {					
					complete += "\n\tReservation -"+ i + "- Starts : "+r.getDateArv()+ " / Ends : "+r.getDateDep();
					i++;
				}
				
			s += ("**Room number : (" +c.getNumber()+ ") | N° Beds : "+c.getBeds() +" | Price : "+c.getPrice() +" $ | Booked dates : " +complete+"\n");	
			}
		}
		return s;
		
	}
	
	@Override
	public String Booking(int numéro, int year, int month, int day,int yeardep, int monthdep, int daydep) {
		
		String s ="";
		Reservation r = new Reservation(year,month,day,yeardep,monthdep,daydep);
		String uniqueID = UUID.randomUUID().toString();
		r.setid(uniqueID);

		if (LocalDate.of(year,month,day).isAfter(LocalDate.of(yeardep,monthdep,daydep))) {
			return "Please enter valid booking dates (Date of arrival first) !!\n";
		}
		else if (numéro > this.hotel.getChambers().size()) {
			return "Room number ("+ numéro + ") Doesn't exist, please check the catalogue again.\n";
		}
		else {
			for (Chamber c : this.hotel.getChambers()) {
				if(c.getNumber() == numéro) {
					if(c.getReservation().size() == 0 ) {
						c.getReservation().add(r);
						s += "=>Room number (" + numéro + "), has been booked for the date : "+ r.getDateArv() 
						+" \n\t\t\t\t\t   Until : "+r.getDateDep() + " \n\t\t\t  your reservation id is : " + r.getid()+"\n";
														}
					else if (c.getReservation().size() == 3) {
					 s += "Room number (" + numéro + ") cannot be booked. Please check the catalogue for more available rooms.\n";
															 }
					else {
						if (LocalDate.of(year, month, day).isBefore(c.getReservation().get(c.getReservation().size()-1).getDateDep())){
							
							s += "Booking date of : "+ LocalDate.of(year, month, day)+" For room number ("+numéro+") coincides before the last booking departure of: "+
									c.getReservation().get(c.getReservation().size()-1).getDateDep()+"\n";
																																	  }
						else {
							c.getReservation().add(r);
							s += "=>Room number (" + numéro + "), has been booked for the date : "+ r.getDateArv() 
							+" \n\t\t\t\t\t   Until : "+r.getDateDep() + " \n\t\t\t  your reservation id is : " + r.getid()+"\n";
							 }
						 }
											}							
														}
			}
		return s;
	}

	@Override
	public String ShowReservation(int numéro) {
		String status = "";
		String arg = "";
		String full = "";
		if (numéro > this.hotel.getChambers().size()) {
			return ("Room number : ("+ numéro + ") Doesn't exist, please check the catalogue again.\n");
													  }
		else for (Chamber c : this.hotel.getChambers()) {
			if (c.getNumber() == numéro) {
				if (c.getReservation().size() == 0) {
					status += "\nThe room number ("+numéro+") Available ! \n\n";
					full += status;
										 }
				else if (c.getReservation().size() == 3) {
					status += "\nThe room number ("+numéro+") is completely booked :\n";
					int i = 1;
					for (Reservation r : c.getReservation()) {
						arg += "\t> Reservation number -"+i+"- starts : "+r.getDateArv()+"\n\t\t\t\t   ends : "+r.getDateDep()+"\n" ;
						i ++;									 }
					full += status + arg;
														}
					else {
						int i = 1;
						status +="\nThe room number ("+numéro+") Has the following reservations : \n";
						for(Reservation r : c.getReservation()) {
							arg += "\t> Reservation number -"+i+"- starts : "+r.getDateArv()+"\n\t\t\t\t   ends : "+r.getDateDep()+"\n" ;
							i++;
																}
						full += status +arg;	
						}
										 }
												   }
		return full;
	}

	@Override
	public String SearchByID(String id) {
		String full = "";
		for (Chamber  c : this.hotel.getChambers()) {
			for (Reservation r : c.getReservation()) {
				if (r.getid().equals(id)) {
					return "Showing reservation of id : "+id+"\n\t      Room number : ("+c.getNumber()+")\n\t\t  Arrival : "+r.getDateArv()+"\n\t\tDeparture : "+r.getDateDep()+"\n";
				}
				else {
					return "No reservation under the id : "+id+"\n";
				}
			}
		}
		return full;
	}
		
	

}


	

