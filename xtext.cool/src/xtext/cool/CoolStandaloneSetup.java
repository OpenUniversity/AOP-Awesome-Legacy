
package xtext.cool;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CoolStandaloneSetup extends CoolStandaloneSetupGenerated{

	public static void doSetup() {
		new CoolStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

