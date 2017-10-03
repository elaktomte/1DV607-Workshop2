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


@XmlType(propOrder = {"type", "length"})
@XmlRootElement(name = "Boat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boat {
	private String type;
	private int length;

	public Boat(String t, int l){
		this.type = t;
		this.length = l;
	}
	public Boat(){
		
	}


	public void setLength(int len){
		this.length=len;
	}
	public int getLength(){
		return this.length;
	}
	public void setType(String T){
		this.type = T;
	}
	public String getType(){
		return this.type;
	}
}


