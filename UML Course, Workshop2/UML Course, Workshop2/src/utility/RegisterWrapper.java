package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Register;
/*
 * This is a wrapperclass to be able to Export and Import registers to and from .XML files.
 */
public class RegisterWrapper {

	
	public static void saveRegister(Register reg) throws JAXBException{		
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		//m.marshal(reg, System.out);

		// Write to File
		m.marshal(reg, new File("register.xml"));
	}
	public static Register loadRegister(FileInputStream f) throws FileNotFoundException, JAXBException{
		
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Unmarshaller um = context.createUnmarshaller();
		Register reg = (Register) um.unmarshal(f);

		return reg;
	}
}
