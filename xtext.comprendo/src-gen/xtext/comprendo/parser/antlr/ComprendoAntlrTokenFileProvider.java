/*
* generated by Xtext
*/
package xtext.comprendo.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ComprendoAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("xtext/comprendo/parser/antlr/internal/InternalComprendo.tokens");
	}
}
