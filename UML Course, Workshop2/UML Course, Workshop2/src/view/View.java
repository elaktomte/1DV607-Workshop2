package view;
import java.util.*;
import model.*;

public class View {
	Scanner sc = new Scanner(System.in);

	public int startMenu(){
		System.out.println("Welcome!");
		System.out.println("1. Manage members");
		System.out.println("2. List members/boats");
		System.out.println("9. Exit without saving");
		System.out.println("0. Save and exit");
		int choice = sc.nextInt();
		
		return choice;
	}
	public int memberMenu(){
		System.out.println("1. Add member.");
		System.out.println("2. Update member");
		System.out.println("3. Remove member");
		System.out.println("0. Return to main menu");
		int choice = sc.nextInt();
		
		return choice;
	}
	public Member addMemberMenu(){
		sc.nextLine();
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter personal number: ");
		String pnr = sc.nextLine();	
		
		return new Member(name, pnr);
		
	}
	public int updateMemberMenu(){
		System.out.println("1. Update name");
		System.out.println("2. Update personal number");
		System.out.println("3. Add a boat");
		System.out.println("4. Edit boats");
		System.out.println("5. Remove boat");
		System.out.println("0. Return to main menu");
		
		int choice = sc.nextInt();
		
		return choice;
	}
	public int removeMemberMenu(){
		System.out.println("Enter the id of the member you want to remove.");
		System.out.println("Write 000 to return to the main menu.");
		int choice = sc.nextInt();
		
		return choice;
		
	}
	public int listMenu(){
		System.out.println("1. Simple list");
		System.out.println("2. Expanded list");
		System.out.println("0. Return to main menu");
		int choice = sc.nextInt();
		
		return choice;
		
	}
	public int editBoatMenu(){
		System.out.println("1. Change type");
		System.out.println("2. Change length");
		System.out.println("0. Return to previous menu");
		int choice = sc.nextInt();
		return choice;
	}
}
