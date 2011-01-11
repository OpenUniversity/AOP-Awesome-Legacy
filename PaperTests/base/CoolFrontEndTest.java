package base;

import cool.frontend.translator.CoolFrontEnd;

/*
import cool.frontend.ast.ASTCoordinatorDecl;
import cool.frontend.ast.COOLParser;
import cool.frontend.ast.ParseException;
*/
public class CoolFrontEndTest {
    public static void main(String[] args) throws Exception {
    	CoolFrontEnd.main(new String[]{"aspects/cool/BoundedStack.cool"});
    	
    	//testByBoundedStack();
    }
    /*
	public static void testByBoundedStack() {
		COOLParser parser;
	      try {
	          parser = new COOLParser(new java.io.FileInputStream("aspects/cool/BoundedStack.cool"));
	        } catch (java.io.FileNotFoundException e) {
	          System.out.println("Source COOL file is not found:"+e);
	          return;
	        }
	        try {
	            ASTCoordinatorDecl program = parser.CoordinatorDecl();
	            program.dump("");
	            System.out.println("COOL Parser:  COOL program parsed successfully.");
	          } catch (ParseException e) {
	            System.out.println("COOL Parser:  Encountered errors during parse."+e);
	          }
	} */
}
