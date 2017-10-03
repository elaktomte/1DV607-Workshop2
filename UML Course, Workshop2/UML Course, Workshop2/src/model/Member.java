package model;
import java.util.*;
import javax.xml.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.JAXB;


@XmlRootElement(name = "Member")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "id","pnr","boats","registeredBoats"})
public class Member {
	private int id;
	private String name;
	private String pnr;
	private int boats;
	@XmlElement private ArrayList<Boat> registeredBoats = new ArrayList<Boat>();
	
	public Member(String n, String pnr){		//Constructor for the class
		this.id = id;
		this.name = n;
		this.pnr = pnr;
	}
	public Member(){
		
	}
	//setters and getters for the class.
	public int getId(){  	
		return this.id;
	}
	public void setId(int i){
		this.id= i;
	}
	public void setName(String n){
		this.name = n;
	}
	public String getName(){
		return this.name;
		
	}
	public void setPnr(String p){
		this.pnr = p;
	}
	public String getPnr(){
		return this.pnr;
	}
	public void setBoats(int b){
		this.boats = b;
	}
	public int getBoats(){
		return this.boats;
	}
	public ArrayList<Boat> getRegisteredBoats(){		//ArrayList to keep track of the members boats.
		return this.registeredBoats;
	}
	
	public void addBoat(String t, int l){
		registeredBoats.add(new Boat(t,l));
		this.boats++;		
	}
	public void deleteBoat(int i){
		registeredBoats.remove(i);
		boats--;
	}
	
}


