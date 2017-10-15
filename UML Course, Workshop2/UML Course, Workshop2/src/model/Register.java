package model;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Register")
@XmlAccessorType(XmlAccessType.FIELD)

public class Register {
	@XmlElement(name = "register")
	public ArrayList<Member> register;
	public int members;
	public int memberid;

	public Register(){
		this.register = new ArrayList<Member>();
	}

	public void printCompactList(){		//Prints a compact version of the register
		for (int i = 0; i < register.size(); i++){
			System.out.println("Name: "+register.get(i).getName());
			System.out.println("ID: "+register.get(i).getId());
			System.out.println("Boats: "+register.get(i).getBoats());
			System.out.println("");	// creates a distance between the members
		}
		System.out.println("");//creates distance between the list and the menu
		System.out.println("");

	}
	public void printVerboseList(){
		//“Verbose List”; name, personal number, member id and boats with boat information
		for (int i = 0; i < register.size(); i++){
			System.out.println("Name: "+register.get(i).getName());
			System.out.println("Personal number: "+register.get(i).getPnr());
			System.out.println("ID: "+register.get(i).getId());
			System.out.println("Boats: "+register.get(i).getBoats());
			for (int j = 0; j <register.get(i).getRegisteredBoats().size(); j++){
				System.out.println("Boat type: "+register.get(i).getRegisteredBoats().get(j).getType());
				System.out.println("Boat Length: "+register.get(i).getRegisteredBoats().get(j).getLength());	
			}
			System.out.println(""); // creates a distance between the members in the list.
		}
		System.out.println("");//creates distance between the list and the menu
		System.out.println("");
	}
	public void addMember(Member M){		//Adding a member to the register
		M.setId(memberid);		//sets the correct ID for the user
		register.add(M);
		memberid++;		// always increasing to ensure unique ID for the user.
		members++;	
	}
	public void printMemberInfo(int i){		//printing member information
		System.out.println("Name: "+ register.get(i).getName());
		System.out.println("Personal number: " +register.get(i).getPnr());
		System.out.println("Boats: "+ register.get(i).getBoats());

	}
	public void printBoats(){			//printing the users boats
		for (int j = 0; j< register.size(); j++){
			register.get(j).printBoatList();
		}
	}
	public void deleteMember(int i){	//deletes a member in the register
		register.remove(i);
		members--;
		
	}
	public void deleteMemberPrint(){		//prints out the members in the registers when selecting the delete member option
		for (int i = 0; i< register.size(); i++){				//Prints the names of the members in the list
			System.out.println(i+" "+ register.get(i).getName());			
		}
	}
}
