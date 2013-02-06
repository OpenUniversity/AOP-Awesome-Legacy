package awesome.ide.model;

import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.gen.WeavingInfoCollectorGen;
import awesome.ide.gen.WeavingInfoGen;

public class SrcDevFolder extends SrcFolder {
	public final static String FOLDER_NAME = "src-dev";
	private String packageName;

	public SrcDevFolder(String packageName) {
		super(FOLDER_NAME, packageName);
		this.packageName = packageName;
	}
	@Override
	public void commit(IJavaProject project) {
		super.commit(project);
		addCompilationUnit("WeavingInfo.java", new WeavingInfoGen().generate(packageName));
		addCompilationUnit("WeavingInfoCollector.aj", new WeavingInfoCollectorGen().generate(packageName));
	}
}
