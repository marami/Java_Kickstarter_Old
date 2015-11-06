public class Division{
	static String visualization = "";

	public static void main(String[] args) {
		String myExample = "12/42";
		myDivide(myExample);		
		System.out.println(visualization);	
		
		String myExample2 = "12/63";
		myDivide(myExample2);	
		System.out.println(visualization);	
		
		String myExample3 = "85/63";
		myDivide(myExample3);	
		System.out.println(visualization);	
		
		String myExample4 = "85/0";
		myDivide(myExample4);	
		System.out.println(visualization);	
	}
	
	public static float myDivide(String exampleStr) {
		String[] exampleArr = exampleStr.split("/");				
		int dividentInteger = Integer.valueOf(exampleArr[0]);
		int divisorInteger = Integer.valueOf(exampleArr[1]);
		return myDivide(dividentInteger, divisorInteger);
	}	
	
	public static float myDivide(int divident, int divisor) {		
		visualization = "";	
		String indent = "";			
		int dividentInteger = divident;
		int divisorInteger = divisor;		
		Float result = (float)dividentInteger/(float)divisorInteger;				
		char[] resultListChar = result.toString().toCharArray();	
		int line1 = dividentInteger;	
		int line2 = divisorInteger*Character.getNumericValue(resultListChar[2]);	
		
		if (divisor == 0) {			
			visualization = indent + "  " + dividentInteger + " |" + divisorInteger + "\n" + "Division by zero";			
			return 0;
		}
		
		//printFirstLine		
		visualization += indent + "  " + dividentInteger + " |" + divisorInteger + "\n";
	
		//printSecondLine
		if(dividentInteger < divisorInteger) {	
			line1 = line1 * 10;	
			indent += " ";			
			visualization += indent + "-" + line2 + " |" + result + "\n" + indent + " " + "---" + "\n";
		} else {			
			visualization += "The divident must be less than the divisor for this task";		
			return 0;
		}

		//printOthersLines
		for (int i = 3; i < resultListChar.length - 1; i++) {			
			if (Character.getNumericValue(resultListChar[i]) != 0) {
				indent +=" ";		
				line1 = (line1 - line2)*10;
				line2  = divisorInteger*Character.getNumericValue(resultListChar[i]);			
				visualization += indent + " " + line1 + "\n" + indent + "-" + line2 + "\n" + indent + " " + "---"  + "\n";
				
			} else {
				indent +="  ";		
				line1 = (line1 - line2)*100;
				line2  = divisorInteger*Character.getNumericValue(resultListChar[++i]);				
				visualization += indent + " " + line1 + "\n" + indent + "-" + line2 + "\n" + indent + " " + "---" + "\n";
			}			
		}
		
		//printLastLine
		line1 = (line1 - line2);	
		visualization += indent + " " + line1  + "\n";	
		return result;
	}		

}
