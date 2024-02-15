package mainCLi;

import java.io.BufferedReader;

public class IntegerInputProcessor extends ComplexUserInputProcessor<Integer>{

	public IntegerInputProcessor(BufferedReader inputReader) {
		super(inputReader);
		
	}



	@Override
	protected void setValidityCriterion() {
		isValid = str -> {
			try {
				Integer value = Integer.parseInt(str);
				return value instanceof Integer;
			} catch (NumberFormatException e) {
				return false;
			}
		};
		
	}

	@Override
	protected void setParser() {
		try {
			parser = Integer.class.getMethod("parseInt", String.class);
		} catch(SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	

}
