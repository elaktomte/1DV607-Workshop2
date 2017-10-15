import java.io.File;
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
import view.View;
import controller.Controller;
import utility.RegisterWrapper;

public class Main {
	public static RegisterWrapper rw = new RegisterWrapper();

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		Controller controller = new Controller();
		if (!new File("Register.xml").exists()){
			Register newReg = new Register();
			controller.register = newReg;
		}
		else{
		FileInputStream file = new java.io.FileInputStream("register.xml");
		
		controller.register = rw.loadRegister(file);
		}
		controller.startMenu();
		
	}



}
