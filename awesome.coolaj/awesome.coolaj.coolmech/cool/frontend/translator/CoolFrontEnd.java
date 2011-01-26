package cool.frontend.translator;

import cool.frontend.ast.COOLParser;
import java.io.*;

public class CoolFrontEnd {

	public static void main(String[] args) throws Exception {
		if (args == null || args.length == 0)
			return;
		String outDir = getOutputDir(args);
		String[] fileNames = getFileNames(args);
		CoolTranslator translator = new CoolTranslator();
		for (String fileName : fileNames) {
			COOLParser parser;
			FileInputStream fis;
			try {
				fis = new java.io.FileInputStream(fileName);
			} catch (java.io.FileNotFoundException e) {
				System.out.println("COOL Front-end:  file " + args[0]
						+ " not found.");
				continue;
			}
			try {
				parser = new COOLParser(fis);
			} catch (Exception ee) {
				System.out.println("COOL parser exception: " + ee.getMessage());
				continue;
			}

			StringBuffer coordClass = translator.translate(parser
					.CoordinatorDecl());
			String packageName = translator.getPackageName();
			String className = translator.getCoordinatorClassName();
			try{
			  writeFile(outDir, packageName, className, coordClass);	
			} catch (Exception e) {
				System.out.print("Error writing target Java class "+className+":"+e.getMessage());
			}
		}
	}
	
	static String getOutputDir(String[] args) {
		for (int i=0;i<args.length;i++)
			if (args[i].equals("-out"))
				return args[i+1];
		return null;
	}
	
	static String[] getFileNames(String[] args) {
		int firstPos =0;
		for (int i=0;i<args.length;i++)
			if (args[i].startsWith("-"))
				firstPos = i+2;
		int filesNum = args.length-firstPos;
		String[] result = new String[filesNum];
		for(int i=0;i<filesNum;i++) 
			result[i]=args[i+firstPos];
		return result;
	}
	
	static void writeFile(String outDir, String packageName, String className, StringBuffer content) throws IOException {
		if (packageName==null || packageName.equals("default")) 
			packageName = "";
		File tgtFile = getFile(outDir, packageName.replace(".", "/"), className+".java");
		System.out.println("Generating "+tgtFile.getAbsolutePath());
		PrintStream outStream = new PrintStream(tgtFile);
		outStream.print(content.toString());
		outStream.flush();
		outStream.close();
	}
	
	static File getFile(String outDir, String packageName, String fileName) {
		String workingDir = System.getProperty("user.dir");
		if (outDir==null) {
			outDir = workingDir;
		} else if (!outDir.startsWith("/") || outDir.startsWith("\\")) {
			if (workingDir!=null) outDir = workingDir+"/"+outDir;
		}
		String packageDir = packageName.replace(".","/");
		File outDirFile = new File(outDir, packageDir);
		if (!outDirFile.exists())
			outDirFile.mkdirs();
		return new File(outDirFile, fileName);
	}
}
