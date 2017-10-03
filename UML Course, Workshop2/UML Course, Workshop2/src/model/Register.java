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

	public Register(){
		this.register = new ArrayList<Member>();
	}

	/*void addMember(Member m){
		register.add(m);
		members++;
	}
	void deleteMember(Member m){
		register.remove(m);
		members--;
	}
	
	*/
}
