package main;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.SyntheticRepository;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.BindingDescriptor;
import adb.backend.LocationDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.bcel.AspectAttribute;
import adb.backend.bcel.Attribute;
import adb.backend.bcel.FieldLineNumberAttribute;
import adb.backend.bcel.JoinPointDescriptor;
import adb.backend.bcel.AspectAttribute.AspectAttributeReader;
import adb.backend.bcel.CrossCuttingAttribute;
import adb.backend.bcel.CrossCuttingAttribute.CrossCuttingAttributeReader;
import adb.backend.bcel.FieldLineNumberAttribute.FieldLineNumberAttributeReader;
import adb.backend.bcel.ShadowAttribute;
import adb.backend.bcel.ShadowAttribute.ShadowAttributeReader;
import adb.backend.bcel.SourceLineContainingAttributeReader.LineInformation;

public class AttributeTester {

	private String adviceTypeToString(int type)
	{
		String s = null;
		switch(type)
		{
		case 1:
			s = "AFTER";
			break;
		case 2:
			s = "AROUND";
			break;
		case 4:
			s = "BEFORE";
			break;
		default:
			s = "unknown " + type;		
		}
		
		return s;		
	}
	
	String perTypeToString(int perType)
	{
		String s = null;
		
		switch(perType)
		{
		case 1:
			s = "PER SINGLETON";
			break;
		case 2:
			s = "PER CFLOW";
			break;
		case 3:
			s = "PER OBJECT";
			break;
		case 4:
			s = "PER FROMSUPER";
			break;
		case 5:
			s = "PER PERTYPEWITHIN";
			break;
		default:
			s = "Unkown " + perType;
					
		}
		
		return s;
	}
	
	private void dumpAspectAttribute(AspectAttribute aspectAttr)
	{
		System.out.println("[AspectAttribute BEGIN]");
		
		System.out.println("per = " + perTypeToString(aspectAttr.getPer())); 
		System.out.println("mech = " + aspectAttr.getMechName()); 
		System.out.println("start line = " + aspectAttr.getSlnr().path
				+ ", " + aspectAttr.getSlnr().file + ", " + aspectAttr.getSlnr().lnr);
		System.out.println("end line = " + aspectAttr.getElnr().path
				+ ", " + aspectAttr.getElnr().file + ", " + aspectAttr.getElnr().lnr);
				
		List<AdviceDescriptor> allAdvice = aspectAttr.getAdvices();
		System.out.println("******* allAdvice " + allAdvice.size());
		for(AdviceDescriptor adv : allAdvice)
		{
			System.out.println("******* advice " + adv);
			System.out.println("aspect  " + (adv.getAspect() != null ? adv.getAspect() : "<none>"));
			System.out.println("kind " + adviceTypeToString(adv.getType()));
			
			System.out.println("effect type " + adv.getEffectType());
			
			
			System.out.print("ArgIndices [" + adv.getArgIndices().length + "] ");
			for(int index : adv.getArgIndices())
			{
				System.out.print(index + " ");
			}			
			System.out.println("");
			
			System.out.print("ArgNames [" + adv.getArgNames().length + "] ");			
			for(String name : adv.getArgNames())
			{
				System.out.print(name + " ");
			}			
			System.out.println("");
			
			System.out.println("Bindings [" + adv.getBindings().length + "] ");	
			for(BindingDescriptor binding : adv.getBindings())
			{
				System.out.println(binding.getName() + ", location = " + 
						binding.getLocation().getElnr() + " " +
						binding.getLocation().getInfile() + " " +
						binding.getLocation().getSlnr() + 											
						", pointcut = " + binding.getPointcut());
			}		
			
			System.out.println("container class " + 
					((adv.getContainer().getClazz() != null) ? adv.getContainer().getClazz() : "<none>") + 
					" name  = " + adv.getContainer().getMethodname() + 
					" sig = " + adv.getContainer().getMethodsig());  
									
			System.out.println("location = " + 
					adv.getLocation().getElnr() + " " +
					adv.getLocation().getInfile() + " " +
					adv.getLocation().getSlnr());
						
			System.out.println("");
			System.out.println("[AspectAttribute END]");
		}		
	}
	
	static void dumpMethodIdentifier(MethodIdentifier mi)
	{
		if(mi == null)
		{
			System.out.println("<null>");
			return;
		}
		
		System.out.print(" Method name = " + mi.getMethodname() != null ? mi.getMethodname() : "<none>");
		System.out.print(" Method sig = " + mi.getMethodsig());
		System.out.println(" Class = " + mi.getClazz());				
	}
	
	static private void dumpShadowAttribute(ShadowAttribute shadowAttr)
	{
		System.out.println("[ShadowAttribute BEGIN]");
		
		MethodIdentifier mi = shadowAttr.getRangeMethod();
		System.out.println("Method name = " + mi.getMethodname());
		System.out.println("Method sig = " + mi.getMethodsig());
		System.out.println("Class = " + mi.getClazz());		
		
		Map<Integer, LocationDescriptor> locs = shadowAttr.getLocations();
		Set<Integer> uids = locs.keySet();
		for(int uid : uids )
		{
			System.out.print("UID = " + uid + " location = " );
			dumpLocationDesc(locs.get(uid));			
		}
		
		System.out.println("[ShadowAttribute BEGIN]");
	}
	
	static private void dumpLocationDesc(LocationDescriptor lc)
	{
		System.out.println(" elnr " + lc.getElnr() +
				" end code index " + lc.getEndCodeIndex() + 
				" InFile " + lc.getInfile() + 
				" slnr " + lc.getSlnr() + 
				" start code index " + lc.getStartCodeIndex());		
	}
	
	private void dumpCrosscuttingAttribute(CrossCuttingAttribute cctAttr)
	{
		System.out.println("[CrosscuttingAttribute BEGIN]");
		
		List<JoinPointDescriptor> jpds = cctAttr.getJoinPoints();
		for(JoinPointDescriptor jpd : jpds)
		{
			System.out.println("******* JoinPointDescriptor " + jpd);
			System.out.println("ID " + jpd.getUid());
			
			LocationDescriptor range = jpd.getRange();
			System.out.println("## Range = ");
			dumpLocationDesc(range);
			
			System.out.print("Method = ");
			dumpMethodIdentifier(range.getMethod());
			
			System.out.print("## Target  = ");
			LocationDescriptor target = jpd.getTarget();
			dumpLocationDesc(target);
			dumpMethodIdentifier(target.getMethod());
			
			System.out.println("Type = " + jpd.getType());
			
			List<AdviceApplicationDescriptor> advs = jpd.getAdvice();
			for(AdviceApplicationDescriptor adv : advs)
			{
				System.out.println("************** advice " + adv);
				dumpMethodIdentifier(adv.getAdvice());
				System.out.println("binding name = " + adv.getBindingName());
				System.out.println("residue = " + adv.getResidue());
				System.out.println("join point " + adv.getJoinpoint());						
			}			
		}
		
		System.out.println("length " + cctAttr.getLength());
		System.out.println("tag " + cctAttr.getTag());
		
		System.out.println("[CrosscuttingAttribute END]");
	}
	
	private void dumpFieldLineNumberAttribute(FieldLineNumberAttribute fnAttr)
	{
		Set<String> fieldNames = fnAttr.getFields();
		for(String fieldName : fieldNames)
		{
			LineInformation li = fnAttr.getInfoFor(fieldName);
			System.out.println("field " + fieldName + " file " + li.file + " lnr " + li.lnr + " path " + li.path);			
		}
			
		
	}
	
	void dumpMethodAttributes(JavaClass clazz)
	{
		for(Method m : clazz.getMethods())
		{
			
			System.out.println("found method " + m.getName());
			
			System.out.println("local var table " + m.getLocalVariableTable());;
			
			org.apache.bcel.classfile.Attribute as[] = m.getAttributes(); 
			for(org.apache.bcel.classfile.Attribute a : as)
			{
				//System.out.println("attribute name " + 
				//		a.getConstantPool().getConstant(a.getNameIndex()).toString());
				
				
				if(a instanceof Code)
				{
					//System.out.println("attribute name " + 
					//		a.getConstantPool().getConstant(a.getNameIndex()).toString());
					
					org.apache.bcel.classfile.Attribute[] codeAttributes =  ((Code)a).getAttributes();
					for (org.apache.bcel.classfile.Attribute attribute2 : codeAttributes) 
					{
						System.out.println("attribute2 name " + 
								a.getConstantPool().getConstant(attribute2.getNameIndex()).toString());
						
						if(attribute2 instanceof Attribute)
						{
							Attribute at = (Attribute) attribute2;
							if(at instanceof CrossCuttingAttribute)
							{
								System.out.println("found attribute " + at.getName());							
								dumpCrosscuttingAttribute((CrossCuttingAttribute) at);						
							}
							
							if(at instanceof ShadowAttribute)
							{
								System.out.println("found attribute " + at.getName());							
								dumpShadowAttribute((ShadowAttribute) at);						
							}
						} 												
					}
				}
			}
		}
	}
	
	private void testAttributes(String classPath, String clazzname)
	{			
		JavaClass clazz;
		try 
		{
			Repository.setRepository(SyntheticRepository.getInstance(new ClassPath(classPath)));
			
			System.out.println("*** START CLASS REPORT ***");
			System.out.println("My class path: " + Repository.getRepository().getClassPath());

			AspectAttributeReader ar = new AspectAttributeReader();
			org.apache.bcel.classfile.Attribute.addAttributeReader(ar.getName(),ar);
			
			ShadowAttributeReader sr = new ShadowAttributeReader();
			org.apache.bcel.classfile.Attribute.addAttributeReader(sr.getName(),sr);
			
			CrossCuttingAttributeReader cr = new CrossCuttingAttributeReader();
			org.apache.bcel.classfile.Attribute.addAttributeReader(cr.getName(),cr);
			
			FieldLineNumberAttributeReader flr = new FieldLineNumberAttributeReader();
			org.apache.bcel.classfile.Attribute.addAttributeReader(flr.getName(), flr);
						
			System.out.println("Looking for class " + clazzname);
			
			clazz = Repository.lookupClass(clazzname);
					
			System.out.println("found class " + clazz.getClassName());
			
			Map<String,Attribute> attMap = new HashMap<String, Attribute>();
			org.apache.bcel.classfile.Attribute[] ats = clazz.getAttributes();
			System.out.println("found " + ats.length + " attributes ");
			for (org.apache.bcel.classfile.Attribute attribute : ats) 
			{								
				
				if(attribute instanceof Attribute)
				{					
					Attribute at = (Attribute) attribute;
					System.out.println("found attribute " + at.getName());
					
					if(at instanceof AspectAttribute)
					{
						dumpAspectAttribute((AspectAttribute) at);						
					}					
					
					if(at instanceof FieldLineNumberAttribute)
					{
						dumpFieldLineNumberAttribute((FieldLineNumberAttribute) at);						
					}					
				}		
				
			}
			
			dumpMethodAttributes(clazz);
			
			System.out.println("done " + clazz.getClassName());
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		if(args.length != 1 && args.length != 2)
		{
			System.out.println("Usage:\n" +
					"AttributeTester <jarpath> <classname>: prints a report to the standard output\n" +
					"containing the attributes found in jarpath/classname.\n" +
					"AttributeTester <jarpath> [outfile] : prints a report to the standard output\n" +
					"about the attributes of all classes found in jarpath.\n");
			return;
		}
		
		if(args.length == 2) {
			// handle the case of a single report
			AttributeTester tester = new AttributeTester();
			tester.testAttributes(args[0], args[1]);
			return;
		} else if(args.length == 1) {
			// here we print a report for all classes found in the jarfile
			JarFile jarFile = new JarFile(args[0]);
			Enumeration<JarEntry> entries = jarFile.entries();
			JarEntry entry;
			while(entries.hasMoreElements()) {
				entry = entries.nextElement();
				if(entry.getName().endsWith(".class")) {
					AttributeTester tester = new AttributeTester();
					tester.testAttributes(args[0], entry.getName().split(".class")[0]); 					
				}
			}
			return;
		}
	
		//String workingDir = System.getProperty("user.dir");
		
	}

}
