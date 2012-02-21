package storage;

import internalformatting.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class saves and loads the formula database
 * @author Clayven Anderson
 *
 */


public class FormulaSaver
{
	public static void SaveForms(FormulaDatabase Forms){
		try{
			File dir = new File("data");
			dir.mkdir();
			File store = new File("data/" ,"FormulaDatabase.ntb" );
			FileOutputStream fs = new FileOutputStream(store);
			ObjectOutputStream os = new ObjectOutputStream(fs);

			os.writeObject(Forms);
			os.close();

		}catch (IOException ex){
			ex.printStackTrace();
		}      
	}

	public static  Object LoadForms(){
		FormulaDatabase Database = new FormulaDatabase(); 
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("data/FormulaDatabase.ntb"));
			Database = (FormulaDatabase) is.readObject();

		} catch(Exception ex){
			ex.printStackTrace();
		}

		return Database;
	}

	public static void main(String[] args){

		////May's default formulas
		// new formula ArrayList for all formulas and stuff
		ArrayList<Formula> someFormulas = new ArrayList<Formula>();

		// new units
		Unit gram = new Unit("gram");
		Unit meter = new Unit("meter");
		Unit liter = new Unit("liter");
		Unit second = new Unit("second");
		
		//unit - gram
		gram.setInfo("The units of mass.");
		gram.setTypicalForm("kg");
		
		//unit - meter
		meter.setInfo("The units of length.");
		meter.setTypicalForm("m");
		
		//unit - liter
		liter.setInfo("The units of volume.");
		liter.setTypicalForm("l");
		
		//unit - second
		second.setInfo("The units of time.");
		second.setTypicalForm("s");
		
		//new variable - x
		Variable newVar = new Variable("x");

		//new terms to put in formulas
		Term newTerm = new Term(5, newVar, 2, null); //5x^2
		Term newTerm2 = new Term(6, newVar, 3, null); //6x^3
		Term newTerm3 = new Term(7, newVar, 4, null); //7x^4
		Term newTerm4 = new Term(8, newVar,5,null); //8x^5

		//new formulas to put in ArrayList of formulas
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		Formula newFormula3 = new Formula();

		//formula 1 tags: random, mass, happy
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.addTerm(newTerm);
		newFormula.addTag("random");
		newFormula.addTag("mass");
		newFormula.addTag("happy");

		//formula 2 tags: blah, mass
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.addTerm(newTerm2);
		newFormula2.addTerm(newTerm3);
		newFormula2.addTag("blah");
		newFormula2.addTag("mass");

		//formula 3 tags: notMass
		newFormula3.setName("No Mass Formula");
		newFormula3.setInfo("No mass info");
		newFormula3.addTerm(newTerm4);
		newFormula3.addTag("notMass");


		someFormulas.add(newFormula); // 5x^2
		someFormulas.add(newFormula2); // 6x^3 + 7x^4
		someFormulas.add(newFormula3); // 8x^5 

		FormulaDatabase Base = new FormulaDatabase();
		// FormulaDatabase Res = new FormulaDatabase();

		Base.AddFormula(newFormula);
		Base.AddFormula(newFormula2);
		Base.AddFormula(newFormula3);

		SaveForms(Base);

		Base = null;

		//Res = (FormulaDatabase) LoadForms();

		for(int i=0; i<=2; i++){
			Formula x = ((ArrayList<Formula>) LoadForms()).get(i);
			System.out.println(x.getName() + " " + x + " " + x.getInfo() + " " + x.getAllTags() );
		}
	}  

}
