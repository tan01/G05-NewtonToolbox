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

		//all operators
		Operator leftParen = new Operator("(");
		Operator rightParen = new Operator(")");
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Operator times = new Operator("*");
		Operator divide = new Operator("/");
		Operator equals = new Operator("=");
		
		// new units
		Unit gram = new Unit("gram");
		Unit meter = new Unit("meter");
		Unit liter = new Unit("liter");
		Unit second = new Unit("second");
		Unit meterPerSecond = new Unit("meter per second");
		
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
		
		//unit - meter per second
		meterPerSecond.setInfo("The units of velocity.");
		meterPerSecond.setTypicalForm("m/s");
		
		//new variables
		Variable v_av = new Variable("v_(av)");
		Variable x_1 = new Variable("x_(1)");
		Variable x_2 = new Variable("x_(2)");
		Variable t_1 = new Variable("t_(1)");
		Variable t_2 = new Variable("t_(2)");

		//term - average velocity
		Term avVelTerm_v_av = new Term(1, v_av, 1, meterPerSecond);
		Term avVelTerm_x_1 = new Term(1, x_1, 1, meter);
		Term avVelTerm_x_2 = new Term(1, x_2, 1, meter);
		Term avVelTerm_t_1 = new Term(1, t_1, 1, second);
		Term avVelTerm_t_2 = new Term(1, t_2, 1, second);

		//new formulas to put in ArrayList of formulas
		Formula avVelForm = new Formula();

		//formula - average velocity
		//v_av = ( x_2 - x_1 ) / ( t_2 - t_1 )
		avVelForm.setName("Average Velocity");
		avVelForm.setInfo("Average velocity of a particle during a certain time period.");
		avVelForm.addTerm(avVelTerm_v_av);
		avVelForm.add(equals);
		avVelForm.add(leftParen);
		avVelForm.addTerm(avVelTerm_x_2);
		avVelForm.add(minus);
		avVelForm.addTerm(avVelTerm_x_1);
		avVelForm.add(rightParen);
		avVelForm.add(divide);
		avVelForm.add(leftParen);
		avVelForm.addTerm(avVelTerm_t_2);
		avVelForm.add(minus);
		avVelForm.addTerm(avVelTerm_t_1);
		avVelForm.add(rightParen);
		
		//formula tags - average velocity
		avVelForm.addTag("average");
		avVelForm.addTag("velocity");
		avVelForm.addTag("x_1");
		avVelForm.addTag("x_2");
		avVelForm.addTag("t_1");
		avVelForm.addTag("t_2");
		avVelForm.addTag("x");
		avVelForm.addTag("t");
		avVelForm.addTag("meters");
		avVelForm.addTag("per");
		avVelForm.addTag("second");

		someFormulas.add(avVelForm);

		FormulaDatabase Base = new FormulaDatabase();
		// FormulaDatabase Res = new FormulaDatabase();

		Base.AddFormula(avVelForm);
		
		//Base.AddFormula(newFormula);
		//Base.AddFormula(newFormula2);
		//Base.AddFormula(newFormula3);

		SaveForms(Base);

		Base = null;

		//Res = (FormulaDatabase) LoadForms();

		for(int i=0; i<=someFormulas.size(); i++){
			Formula x = ((ArrayList<Formula>) LoadForms()).get(i);
			System.out.println(x.getName() + " " + x + " " + x.getInfo() + " " + x.getAllTags() );
		}
	}  

}
