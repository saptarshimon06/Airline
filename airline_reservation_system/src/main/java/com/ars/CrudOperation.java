package com.ars;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketGenerationPdf;
import com.ars.model.AdminDTO;
import com.ars.model.AirlineDTO;
import com.ars.model.FlightDTO;
import com.ars.model.PassengerDTO;
import com.ars.model.TicketBookingDTO;
import com.ars.service.AdminService;
import com.ars.service.AirlineService;
import com.ars.service.FlightService;
import com.ars.service.PassengerService;
import com.ars.service.TicketService;
import com.ars.serviceImpl.AdminServiceImpl;
import com.ars.serviceImpl.AirlineServiceImpl;
import com.ars.serviceImpl.FlightServiceImpl;
import com.ars.serviceImpl.PassengerServiceImpl;
import com.ars.serviceImpl.TicketServiceImpl;

public class CrudOperation {

	static AdminService aService=new AdminServiceImpl();
	static AirlineService airService=new AirlineServiceImpl();
	static PassengerService pService=new PassengerServiceImpl();
	static FlightService fService=new FlightServiceImpl();
	static TicketService tService=new TicketServiceImpl();
	static Scanner sc=new Scanner(System.in);
	
	//this method is responsible for CRUD of admin
	public static void crudAdmin()
	{
		String xx;
		while(true)
		{
			System.out.println("=====================================================");
			System.out.println("Press r for read admin \nPress u for update admin \nPress d for delete admin \nPress q for quit");
			xx=JOptionPane.showInputDialog("Enter choice","type here");
			switch(xx)
			{
			case "r":
				try 
				{
					AdminDTO aDto=aService.getAdminById(Integer.parseInt(JOptionPane.showInputDialog("Enter admin ID:","type here")));
					System.out.println("Admin details:");
					System.out.println("ID: "+aDto.getId());
					System.out.println("Name: "+aDto.getAName());
					System.out.println("Email: "+aDto.getEmail());
				}catch (Exception e) 
				{
					System.out.println(e);
				}break;
				
			case "u":
				Admin admin =new Admin();
				String name=JOptionPane.showInputDialog("Enter name","type here");
				String email=JOptionPane.showInputDialog("Enter email","type here");
				String username=JOptionPane.showInputDialog("Enter username","type here");
				String password=JOptionPane.showInputDialog("Enter Password","type here");
				admin.setAName(name);
				admin.setEmail(email);
				admin.setUserName(username);
				admin.setPassword(password);
				AdminDTO upAdmin=aService.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id to update")), admin);
				System.out.println("Admin updated successfully");
				break;
				
			case "d":
				try
				{
					aService.deleteAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter Admin ID to delete","type here")));
				}catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}break;
			
			case "q":
				AdminOperation();
				break;
				
			}//end of switch
		}//end of while		
	}//end of CRUD admin
	
	//this method is responsible for CRUD of passenger	
	public static void crudPassenger()
	{
		String xy;
		while(true)
		{
			System.out.println("=====================================================");
			System.out.println("Press r for read passenger \nPress u for update passenger \nPress d for delete passenger\nPress q for quit");
			xy=JOptionPane.showInputDialog("Enter choice","type here");
			
			switch(xy)
			{
			case "r":
				try
				{
					PassengerDTO pDto=pService.getPassengerById(Integer.parseInt(JOptionPane.showInputDialog("Enter Passenger ID","type here")));
					System.out.println("Passenger Details:");
					System.out.println("ID: "+pDto.getId());
					System.out.println("Name: "+pDto.getName());
					System.out.println("Phone No.: "+pDto.getPhno());
					System.out.println("Email: "+pDto.getEmail());
					
				}catch (Exception e) {
					System.out.println(e);
				}break;
				
			case "u":
				Passenger passenger=new Passenger();
				String name=JOptionPane.showInputDialog("Enter name","type here");
				String email=JOptionPane.showInputDialog("Enter email","type here");
				String phno=JOptionPane.showInputDialog("Enter Phone number","type here");
				String username=JOptionPane.showInputDialog("Enter username","type here");
				String password=JOptionPane.showInputDialog("Enter Password","type here");
				passenger.setName(name);
				passenger.setEmail(email);
				passenger.setPhno(phno);
				passenger.setUserName(username);
				passenger.setPassword(password);
				PassengerDTO upPass=pService.updatePassenger(Integer.parseInt(JOptionPane.showInputDialog("Enter passenger ID for update")), passenger);
				System.out.println("passenger updated successfylly");
				break;
			
			case "d":
				try {
				pService.deletePassenger(Integer.parseInt(JOptionPane.showInputDialog("Enter passenger ID to delete","type here")));
				}catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}break;
				
			case "q":
				crudOperation();
				 break;
			}//end of switch			
		}//end of while
	}// end of CRUD passenger
	
	//this method is responsible for CRUD flight
	public static void crudFlight()
	{
		String xy;
		while(true)
		{
			System.out.println("=====================================================");
			System.out.println("Press c. for create Flight details\n Press r.for read Flight details\n Press u.for update Flight details\nPress d.for delete flight details\nPress q for quit");
			xy=JOptionPane.showInputDialog("Enter choice","type here");
			
			switch(xy)
			{
			case "c":
				Flight flight=new Flight();
				System.out.println("Enter available seats: ");
				int aseat=sc.nextInt();
				System.out.println("Enter Total seats: ");
				int tseat=sc.nextInt();
				sc.nextLine();
				System.out.println("Enetr traveller class: ");
				String tclass=sc.nextLine();
				System.out.println("Enter the time: ");
				String t=sc.nextLine();
				System.out.println("Enter the date: ");
				String d=sc.nextLine();
				LocalDate date1=LocalDate.parse(d);
				System.out.println("Enter the Source: ");
				String fSource=sc.nextLine();
				System.out.println("Enter destination: ");
				String fDestination=sc.nextLine();
				
				flight.setAvailalbleSeats(tseat);
				flight.setTotalSeats(tseat);
				flight.setTravellerClass(tclass);
				flight.setTime(t);
				flight.setDate(date1);
				flight.setSource(fSource);
				flight.setDestination(fDestination);
				fService.saveFlight(flight);
				
				System.out.println("Flight created successfully");
				
			case "r":
				try
				{
					int id;
					System.out.println("Enter flight ID: ");
					id=sc.nextInt();
					FlightDTO fDto=fService.getFlight(id);
					System.out.println("Flight details:");
					System.out.println("Flight ID: "+fDto.getFlightId());
					System.out.println("Available seats: "+fDto.getAvailableSeats());
					System.out.println("Total Seats: "+fDto.getTotalSeats());
					System.out.println("Date: "+fDto.getDate());
					System.out.println("Time: "+fDto.getTime());
					System.out.println("Source: "+fDto.getSource());
					System.out.println("Destination: "+fDto.getDestination());
					System.out.println("Traveller class: "+fDto.getTravellerClass());
					System.out.println("Airline id: "+fDto.getAirline());
					
					
				}catch (Exception e) {
					System.out.println(e);
				}break;
				
			case "u":
				Flight flight1=new Flight();
				int aSeat=Integer.parseInt((JOptionPane.showInputDialog("Enter available seats")));
				int tSeat=Integer.parseInt(JOptionPane.showInputDialog("Enter Total seats","type here"));
				String date=JOptionPane.showInputDialog("Enter Date","type here");
				String time=JOptionPane.showInputDialog("Enter Time","type here");
				String fsource=JOptionPane.showInputDialog("Enter Source","type here");
				String fdestination=JOptionPane.showInputDialog("Enter Destination","type here");
				String tClass=JOptionPane.showInputDialog("Enter Traveller Class","type here");
				LocalDate date2=LocalDate.parse(date);
				flight1.setAvailalbleSeats(aSeat);
				flight1.setTravellerClass(tClass);
				flight1.setDate(date2);
				flight1.setSource(fsource);
				flight1.setDestination(fdestination);
				flight1.setTime(time);
				flight1.setTotalSeats(tSeat);
				
				
				FlightDTO upFlight=fService.updateFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID")), flight1);
				System.out.println("Flight updated successfully");
				break;
				
			case "d":
				try
				{
					fService.deleteFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID to delete","type here")));
					
				}catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}break;
			
			case "q":
				AdminOperation();
				break;
			}//end of switch
	}//end of loop	
}//end of crud flight
	
	//this method is responsible for assign flight to airline
	public static void assignAirlineToFlight()
	{
		System.out.println("Enter flight ID: ");
		int fId=sc.nextInt();
		System.out.println("Enter airline ID: ");
		int airId=sc.nextInt();
		airService.assignAirlineToFlight(fId, airId);
		System.out.println("Flight assigned to Airline successfully");
	}
	
	//this method is responsible for performing CRUD operation of airline
	public static void crudAirline()
	{
		String in;
		
		while(true)
		{
			System.out.println("===============================================");
			System.out.println("Press c.for add Airline\nPress r for get airline details\npress u for update airline\npress d for delete airline\npress q for quit");
			System.out.println("===============================================");
			in=sc.nextLine();
			switch(in)
			{
			case "c":
				Airline airline=new Airline();
				System.out.println("Enter the airline name: ");
				String a_name=sc.nextLine();
				System.out.println("Enter the fare: ");
				float a_fare=sc.nextFloat();
				airline.setAirName(a_name);;
				airline.setAirFare(a_fare);
				airService.registerAirline(airline);
				System.out.println("Airline saved successfully");
				break;
				
			case "r":
				try {
					String name;
					System.out.println("Enter Airline Name :- ");
					name=sc.nextLine();
					AirlineDTO aDto=airService.getAirlineByName(name);
					System.out.println("Airline details: ");
					System.out.println("Airline Name :- "+aDto.getAirName());
					System.out.println("Fare :- "+aDto.getAirFare());
					System.out.println("Airline Id :- "+aDto.getAirId());
			        
				}
				catch (Exception e) {
					System.out.println(e);
				}
				break;
				
			case "u":
				Airline airline_up=new Airline();
				System.out.println("Enter the airline name: ");
				String au_name=sc.nextLine();
				System.out.println("Enter the fare: ");
				float au_fare=sc.nextFloat();
				airline_up.setAirName(au_name);
				airline_up.setAirFare(au_fare);
				AirlineDTO upairline=airService.updateAirlineById(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to update","type here")),airline_up);
				System.out.println("Flight updated successfully");
				break;
			
			case "d":
				try {
					airService.deleteAirline(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to delete","type here")));
					JOptionPane.showMessageDialog(null, "Airline is deleted");
				} catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case "q":
				AdminOperation();
				break;
			}//end of switch			
		}//end of loop			
	}//end of CRUD airline
	
	//this method if responsible for book flights
	public static void bookFlight()
	{
		List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter from","type here"), JOptionPane.showInputDialog("Enter to","type here"), LocalDate.parse(JOptionPane.showInputDialog("Enter Date","type here")));
		System.out.println("Flight id:\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
		for(Flight flight:flights)
		{
			System.out.println(flight.getFlightId()+"\t\t"+flight.getAirline().getAirName()
					+"\t\t"+flight.getSource()+"\t\t"+flight.getDestination()+"\t\t"+flight.getTime()+"\t\t"+flight.getDate());
		}
		System.out.println("For booking press Yes");
		String choice=JOptionPane.showInputDialog("Enter here","type here");
		
		if(choice.equalsIgnoreCase("yes"))
		{
			int flight_id=Integer.parseInt(JOptionPane.showInputDialog("Enter flight Id","type here"));
			int no_of_passenger=Integer.parseInt(JOptionPane.showInputDialog("Enter number of passenger","type here"));
			LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("enter date","type here"));
			String pEmail=JOptionPane.showInputDialog("Enter passenger email","type here");
			String airName=JOptionPane.showInputDialog("Enter airline Name","Type here");
			TicketBookingDTO ticketDTO=tService.bookFlight(flight_id, date, pEmail, no_of_passenger, airName);
			System.out.println("Your booking has done successfully");
			TicketGenerationPdf.ticketGeneration(ticketDTO);
		}//end of if
	}//end of bookFlight
	
	public static void boardingPass()
	{
		System.out.println();
		TicketBookingDTO tDto=tService.getTicket(Integer.parseInt(JOptionPane.showInputDialog("enter ticket id","type here")));
		System.out.println("=========================================================");
		System.out.println("Airways: "+tDto.getAid().getAirName()+"\t\tBOARDING PASS");
		System.out.println("Ticket No: "+tDto.getTicketId());
		System.out.println("Name: "+tDto.getPid().getName()+"\tNo_of_passengers "+tDto.getNo_of_passenger());
		System.out.println("from "+tDto.getFid().getSource()+"\t\t To: "+tDto.getFid().getDestination());
		System.out.println("Flight: "+tDto.getFid().getFlightId()+"\t\tDate: "+tDto.getFid().getDate());
		System.out.println("=========================================================");
	}//end of boarding pass
	
	public static void checkFlights()
	{
		List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter from","type here"), JOptionPane.showInputDialog("Enter to","type here"), LocalDate.parse(JOptionPane.showInputDialog("Enter Date","type here")));
		System.out.println("Flight id:\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
		for(Flight flight:flights)
		{
			System.out.println(flight.getFlightId()+"\t\t"+flight.getAirline().getAirName()
					+"\t\t"+flight.getSource()+"\t\t"+flight.getDestination()+"\t\t"+flight.getTime()+"\t\t"+flight.getDate());
		}		
	}//end of check flights
	
	public static void crudOperation()
	{
		int input;
		while(true)
		{
			System.out.println("=====================================");
			System.out.println("1. passenger details\n2.Check flights"
					+ "\n3.Book flights\n4.Cancel booking\n5.get boarding pass\n6.quit");
			input=Integer.parseInt(JOptionPane.showInputDialog("enter choice","type here"));
			System.out.println("=====================================");
			switch(input)
			{
			case 1:
				crudPassenger();
				break;
			case 2:
				checkFlights();
				break;
			case 3:
				bookFlight();
				break;
			case 4:
				System.out.println("enter your ticket id: ");
				int id=sc.nextInt();
				tService.cancelBooking(id);
				JOptionPane.showMessageDialog(null, "object is deleted");
				break;
			case 5:
				boardingPass();
				break;
			case 6:
				App.mainMenu();
			}//end of switch
		}//end of loop
		}//end of crud operation
	
	public static void AdminOperation()
	{
		int input;
		while(true)
		{
			System.out.println("============================================");
			System.out.println("1.Flight details\n2.Airline details\n3.add flight to airline\n4.admincrud\n5.quit");
			input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","type here"));
			System.out.println("============================================");
			switch(input)
			{
			case 1:
				crudFlight();
				break;
			case 2:
				crudAirline();
				break;
			case 3:
				assignAirlineToFlight();
				break;
			case 4:
				crudAdmin();
				break;
			case 5:
				App.mainMenu();
				break;
			}//end of switch
			
		}//end of loop
		}//end of Admin operation
}
