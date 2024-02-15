package mainCLi;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

public abstract class ComplexUserInputProcessor<T> {
	
	//Attributes
	protected BufferedReader inputReader;
	protected Predicate<String> isValid;
	protected Method parser;
	protected T parameter;
	
	//Constructor
	public ComplexUserInputProcessor(BufferedReader inputReader) {
		this.inputReader = inputReader;
		setValidityCriterion();
		setParser();
	}

	//Methods

	protected abstract void setValidityCriterion();
	protected abstract void setParser();

	@SuppressWarnings("unchecked")
	public T process() throws IOException {
		String userInput = inputReader.readLine();
		while (!isValid.test(userInput)) {
			System.err.println("Sorry, wrong input. Please try again .");
			userInput = inputReader.readLine();
		}
		try {
			parameter = (T) parser.invoke(null, userInput);
		} catch (SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return parameter;
		
	}

}
