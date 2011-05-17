
package xtext.comprendo;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ComprendoStandaloneSetup extends ComprendoStandaloneSetupGenerated{

	public static void doSetup() {
		new ComprendoStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

