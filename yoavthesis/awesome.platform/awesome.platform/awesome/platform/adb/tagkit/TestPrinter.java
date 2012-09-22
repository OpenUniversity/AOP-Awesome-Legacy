package awesome.platform.adb.tagkit;

import org.aspectj.weaver.ast.And;
import org.aspectj.weaver.ast.Call;
import org.aspectj.weaver.ast.FieldGetCall;
import org.aspectj.weaver.ast.HasAnnotation;
import org.aspectj.weaver.ast.ITestVisitor;
import org.aspectj.weaver.ast.Instanceof;
import org.aspectj.weaver.ast.Literal;
import org.aspectj.weaver.ast.Not;
import org.aspectj.weaver.ast.Or;
import org.aspectj.weaver.internal.tools.MatchingContextBasedTest;

public class TestPrinter implements ITestVisitor
{
	private String printedTest = "";
	
	public String getPrinted()
	{
		return printedTest;
	}
	
	
	@Override
	public void visit(And e) 
	{		
		TestPrinter left = new TestPrinter();
		e.getLeft().accept(left);
		
		TestPrinter right = new TestPrinter();
		e.getRight().accept(right);
		
		printedTest = left.getPrinted() + " && " + right.getPrinted();
		
	}

	@Override
	public void visit(Instanceof i) 
	{
		printedTest = i.toString();		
	}

	@Override
	public void visit(Not not) 
	{
		TestPrinter notTest = new TestPrinter();	
		printedTest = "!" + notTest.getPrinted();
	}

	@Override
	public void visit(Or or) 
	{
		TestPrinter left = new TestPrinter();
		or.getLeft().accept(left);
		
		TestPrinter right = new TestPrinter();
		or.getRight().accept(right);
		
		printedTest = left.getPrinted() + " || " + right.getPrinted();		
	}

	@Override
	public void visit(Literal literal) 
	{
		printedTest = literal.toString();	
		
	}

	@Override
	public void visit(Call call) 
	{
		printedTest = call.getMethod().getName() + "(...)"; //TODO add arguments
		
	}

	@Override
	public void visit(FieldGetCall fieldGetCall) {
		printedTest = fieldGetCall.getMethod() + "(...)"; //TODO add arguments
		
	}

	@Override
	public void visit(HasAnnotation hasAnnotation) {
		printedTest = hasAnnotation.toString();
		
	}

	@Override
	public void visit(MatchingContextBasedTest matchingContextTest) {
		printedTest = matchingContextTest.toString();
		
	}

}
