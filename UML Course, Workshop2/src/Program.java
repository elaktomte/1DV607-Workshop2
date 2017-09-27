import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.*;
import view.View;

public class Program {
	public static View view = new View();
	public static Register register;
	
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
	register = loadRegister();
	startMenu();


		
	}
	
	public static void startMenu() throws JAXBException{		// functions for the start menu
		
		int choice = view.startMenu();		// gets the choice made from the user
		if (choice == 1){
			memberMenu(); // Sends user to the member menu
		}
		else if(choice == 2){
			listMenu();			//sends user to the list menu
		}
		else if (choice == 9){	//terminates the program without saving register
		
		}
		else if (choice == 0){		//saves register and terminates
			saveRegister(register);
		}
		else {			//if user enter anything besides the options lister, user is sent back to main menu again.
			startMenu();		
		}
	}
	public static void listMenu() throws JAXBException{
		int choice = view.listMenu();
		if (choice == 1){
			//Skapa funktion för enkel lista
		}
		else if(choice==2){
			//Skapa funktion för detaljerad lista
		}
		else if(choice == 0){
			startMenu();
		}
		else{
			listMenu();
		}
		
	}
	public static void memberMenu() throws JAXBException{		// functions for the member menu
		int choice = view.memberMenu();
		if(choice == 1){								//add member command is entered
			Member new_member = view.addMemberMenu();
			new_member.setId(register.members+1);		//sets the correct ID for the user
			register.register.add(new_member);
			register.members++;					//increases the registered amount of users.
			memberMenu();			//Returns to the member menu if user wants to add multiple members.
			
		}
		else if(choice == 2){
			for (int i = 0; i< register.register.size(); i++){				//Prints the names of the members in the list
				System.out.println(i+" "+ register.register.get(i).getName());			
			}
			
			//funktion för att uppdatera member
		}
		else if(choice == 3){				//User wants to delete a member
			for (int i = 0; i< register.register.size(); i++){				//Prints the names of the members in the list
				System.out.println(i+" "+ register.register.get(i).getName());			
			}
			int selection = view.removeMemberMenu();
			if(selection == 000){
				startMenu();
				
			}
			else {
				register.register.remove(selection);
				memberMenu();
			}
		}
		else if(choice == 0){
			startMenu();
		}
		else { 
			memberMenu();
		}
	}
	
	public static void saveRegister(Register reg) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(reg, System.out);

		// Write to File
		m.marshal(reg, new File("C://temp/register.xml"));
	}
	public static Register loadRegister() throws FileNotFoundException, JAXBException{
		JAXBContext context = JAXBContext.newInstance(Register.class);
		System.out.println("Output from our XML File: ");
		Unmarshaller um = context.createUnmarshaller();
		Register reg = (Register) um.unmarshal(new FileReader("C://temp/register.xml"));

		return reg;
	}

}
