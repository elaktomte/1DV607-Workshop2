package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Testfile {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
	/*	Member kalle = new Member(1,"Kalle Kula","841212-6512");
		kalle.addBoat("Other", 3);
		Member Olle = new Member(1,"Olle Bjarne","842341-6512");
		kalle.addBoat("Motorsailor", 12);
		
		Register reg = new Register();
		reg.addMember(kalle);
		reg.addMember(Olle);
		saveRegister(reg);
		loadRegister();
		*/
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
