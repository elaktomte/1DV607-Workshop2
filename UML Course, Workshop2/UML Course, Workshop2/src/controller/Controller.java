package controller;
import java.io.File;
import utility.ErrorHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.*;
import utility.RegisterWrapper;
import view.View;

public class Controller {
	public static View view = new View();
	public static Register register;
	private static FileInputStream file;
	public static RegisterWrapper rw;
	private static ErrorHandler eh = new ErrorHandler();

	public static void startMenu() throws JAXBException{		// functions for the start menu
		/*		
		System.out.println("Welcome!");
		System.out.println("1. Manage members");
		System.out.println("2. List members/boats");
		System.out.println("9. Exit without saving");
		System.out.println("0. Save and exit");
		 */

		String selection = view.startMenu();		// gets the choice made from the user
		while (!eh.isInteger(selection))
			selection = view.startMenu();
		int choice = Integer.parseInt(selection);

		if (choice == 1){
			memberMenu(); // Sends user to the member menu
		}
		else if(choice == 2){
			listMenu();			//sends user to the list menu
		}
		else if (choice == 9){	//terminates the program without saving register

		}
		else if (choice == 0){		//saves register and terminates
			rw.saveRegister(register);
		}
		else {			//if user enter anything besides the options lister, user is sent back to main menu again.
			startMenu();		
		}
	}
	public static void listMenu() throws JAXBException{
		/* 		
		System.out.println("1. Simple list");
		System.out.println("2. Expanded list");
		System.out.println("0. Return to main menu");
		 */
		String selection = view.listMenu();
		while (!eh.isInteger(selection))
			selection = view.listMenu();
		int choice = Integer.parseInt(selection);
		if (choice == 1){ // Simple / “Compact List”; name, member id and number of boats
			register.printCompactList();
			startMenu();
		}
		else if(choice==2){ //Detailed / verbose list
			//“Verbose List”; name, personal number, member id and boats with boat information
			register.printVerboseList();
			startMenu();

		}
		else if(choice == 0){
			startMenu();
		}
		else{
			listMenu();
		}

	}
	public static void memberMenu() throws JAXBException{		// functions for the member menu
		/*
		System.out.println("1. Add member.");
		System.out.println("2. Update member");
		System.out.println("3. Remove member");
		System.out.println("0. Return to main menu");
		 */
		String selection = view.memberMenu();
		while (!eh.isInteger(selection))
			selection = view.memberMenu();
		int choice = Integer.parseInt(selection);

		if(choice == 1){								//add member command is entered
			Member new_member = view.addMemberMenu();
			register.addMember(new_member);
			memberMenu();			//Returns to the member menu if user wants to add multiple members.

		}
		else if(choice == 2){		//Update member menu



			System.out.println("Which member do you want to edit?");
			/*
			System.out.println("1. Update name");
			System.out.println("2. Update personal number");
			System.out.println("3. Add a boat");
			System.out.println("4. Edit boats");
			System.out.println("5. Remove boat");
			System.out.println("0. Return to main menu");
			 */
			for (int i = 0; i< register.register.size(); i++){				//Prints the names of the members in the list
				System.out.println(i+" "+ register.register.get(i).getName());	
			}
			Scanner sc = new Scanner(System.in);

			int selected_member = sc.nextInt();


			if (selected_member>register.register.size() || selected_member <0){ //Sends user back to member menu if the user enters a faulty ID.
				memberMenu();
			}
			register.printMemberInfo(selected_member);
			String selection2 = view.updateMemberMenu();
			while (!eh.isInteger(selection2))
				selection2 = view.updateMemberMenu();
			choice = Integer.parseInt(selection2);



			if (choice == 1){		//update name option
				sc.nextLine();	// State issue unless writing an empty sc.nextline.
				System.out.println("Enter the new name: ");
				String name = sc.nextLine();
				register.register.get(selected_member).setName(name);
				memberMenu();

			}
			else if (choice == 2){		//update personal number option
				sc.nextLine();
				System.out.println("Enter the new personal number: ");
				String number = sc.nextLine();
				register.register.get(selected_member).setPnr(number);
				memberMenu();
			}
			else if (choice == 3){		//add boat option
				sc.nextLine();	// State issue unless writing an empty sc.nextline.
				System.out.println("Enter the type of boat: ");
				String type = sc.nextLine();
				System.out.println("Enter the length of the boat in meters: ");
				int length = sc.nextInt();
				register.register.get(selected_member).addBoat(type, length);
				memberMenu();
			}
			else if (choice == 4){			//edit boats option
				/*
				System.out.println("1. Change type");
				System.out.println("2. Change length");
				System.out.println("0. Return to previous menu");
				 */
				sc.nextLine();	// State issue unless writing an empty sc.nextline.
				System.out.println("Which boat do you want to update?  ");
				for (int i = 0; i<register.register.get(selected_member).getRegisteredBoats().size(); i++){		//prints out registered boats
					System.out.println(i+" "+register.register.get(selected_member).getRegisteredBoats().get(i).getType() + "  Length: " +register.register.get(selected_member).getRegisteredBoats().get(i).getLength() );
				}
				int selected_boat = sc.nextInt();
				//error handling if user enters a faulty ID.
				if (selected_boat > register.register.get(selected_member).getRegisteredBoats().size() || selected_boat < 0 ){
					memberMenu();
				}

				String options  = view.editBoatMenu();
				while (!eh.isInteger(options))
					options = view.editBoatMenu();
				int option = Integer.parseInt(options);
				if (option == 1){		//change the type
					sc.nextLine();	// State issue unless writing an empty sc.nextline.
					System.out.println("Enter the new Type: ");
					String type = sc.nextLine();
					register.register.get(selected_member).getRegisteredBoats().get(selected_boat).setType(type);
					System.out.println("Type edited");
					memberMenu();
				}
				else if (option == 2){		//change the length
					sc.nextLine();	// State issue unless writing an empty sc.nextline.
					System.out.println("Enter the new length in Meters: ");
					int length = sc.nextInt();
					register.register.get(selected_member).getRegisteredBoats().get(selected_boat).setLength(length);
					System.out.println("Length edited.");
					memberMenu();

				}
				else if (option == 0){
					memberMenu();
				}
				else {
					memberMenu();
				}





			}		
			else if(choice == 5){	// removing boats option
				register.register.get(selected_member).printBoatList();
				sc.nextLine();	// State issue unless writing an empty sc.nextline.
				System.out.println("Which boat do you want to delete?  ");


				int selected_boat = sc.nextInt();
				//error handling if user enters a faulty ID.
				if (selected_boat > register.register.get(selected_member).getRegisteredBoats().size() || selected_boat < 0 ){
					memberMenu();
				}
				register.register.get(selected_member).deleteBoat(selected_boat);
				System.out.println("Boat deleted! ");
				memberMenu();
			}
			else if (choice == 0){
				startMenu();
			}
			else {
				memberMenu();
			}
		}

		else if(choice == 3){				//User wants to delete a member
			/*		
			System.out.println("Enter the id of the member you want to remove.");
			System.out.println("Write 000 to return to the main menu.");
			 */
			register.deleteMemberPrint();
			selection = view.removeMemberMenu();
			while (!eh.isInteger(selection))
				selection = view.removeMemberMenu();
			choice = Integer.parseInt(selection);
			if(choice == 000){
				startMenu();

			}
			else if (choice > register.register.size() || choice < 0){
				memberMenu();
			}
			else {
				register.deleteMember(choice);
				memberMenu();
			}
		}
		else if(choice == 0){		//user selects to go back to the start menu
			startMenu();
		}
		else { 
			memberMenu();			//Loops user for faulty input.
		}






	}




}
