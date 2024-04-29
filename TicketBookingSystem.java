package miniproject;
import java.sql.*;
import java.util.Scanner;
class Flight1
{
	String query;
	void prn_Status() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight", "root", "darshan3009");
		query="select status from  Ticket_Reservation where id=?";
		System.out.println("Enter the id");
		int id=sc.nextInt();
		PreparedStatement ps =  conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet  rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " +rs.getString(2)+" ");
		}
	}
	void Ticketreservartion() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight", "root", "darshan3009");
		query="insert into  Ticket_Reservation( id, name,address,contanct,price) values(?,?,?,?,?)";
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the address ");
		String address=sc.next();
		System.out.println("Enter the contanct");
		Long contanct=sc.nextLong();
		System.out.println("Enter the price");
		Double price=sc.nextDouble();
		PreparedStatement p = conn.prepareStatement(query);
		p.setInt(1, id);
		p.setString(2, name);
		p.setString(3, address);
		p.setLong(4, contanct);
		p.setDouble(5,price);
		int i = p.executeUpdate();
    	if(i>0)
    	{
    		System.out.println("Ticket successfully reservation");
    	}
    	else
    	{
    		System.out.println("Ticket is Not reservation");
    	}
	}
}
public class TicketBookingSystem 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		int choice;
		Flight1 f=new Flight1();
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Check pnr Status");
			System.out.println("2.Ticket Reservation");
			System.out.println("Enter the option[1-2]");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				f.prn_Status();
				break;
			case 2:
				f.Ticketreservartion();
				break;	
			}
		}while(choice<2);
	}
}