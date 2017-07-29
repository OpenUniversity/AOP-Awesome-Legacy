/*
 * generated by Xtext
 */
package xtext.cool.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import xtext.cool.cool.CoordinatorDeclaration
import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import xtext.cool.cool.CondVar
import xtext.cool.cool.OrdVar
import java.util.Set
import java.util.HashSet
import xtext.cool.cool.OrExpression
import xtext.cool.cool.AndExpression
import xtext.cool.cool.Guard

class CoolGenerator implements IGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		fsa.generateFile("MethodState.java", generateMethodState)
		for(e: resource.allContentsIterable.filter(typeof(CoordinatorDeclaration))) {
            fsa.generateFile(
            	getSimpleName(e.className) + "Coord.java",
                e.compile)
        }
	}
	def compile(CoordinatorDeclaration coord) '''
	import org.aspectj.lang.annotation.*;
	import awesome.platform.annotations.AwAspectMechanism;
	
	@Aspect«IF coord.granularity != null»("perthis(«coord.className».new(..))")«ENDIF»
	@AwAspectMechanism(id="cool")
	public class «getSimpleName(coord.className)»Coord {
		«FOR condvar : coord.body.condVars»
		«condvar.compile»
		«ENDFOR»
		«FOR ordvar : coord.body.ordVars»
		«ordvar.compile»
		«ENDFOR»
		«FOR method : coord.getAllMethods»
		private MethodState lock_«method» = new MethodState();
		«ENDFOR»
		
		«FOR method : coord.getAllMethods»
		«generateLockAndUnlockAdvice(method, coord)»
		«ENDFOR»
		
		«FOR guard : coord.body.guards»
		«FOR method : guard.methods»
		«generateGuardMethod(guard, method)»
		«ENDFOR»«ENDFOR»
	}
	'''
	
	def generateGuardMethod(Guard guard, String method)'''
	private boolean requires_«method»() {
		return («guard.requires.andExpression.print»);
	}
	'''
	
	def print(AndExpression exp)'''
		«FOR orexp : exp.orExpressions»«orexp.print»«IF !orexp.equals(exp.orExpressions.get(exp.orExpressions.size-1))» && «ENDIF»«ENDFOR»'''
	
	def print(OrExpression exp)'''
		«FOR basicexp : exp.basicExpressions»
		«IF basicexp.negated»!«ENDIF»«basicexp.expr.name»«IF !basicexp.equals(exp.basicExpressions.get(exp.basicExpressions.size-1))» || «ENDIF»«ENDFOR»'''
	
	def generateLockAndUnlockAdvice(String method, CoordinatorDeclaration coord) '''
	@Before("execution(* «coord.className».«method»(..))")
	public synchronized void meth_«method»_lock() {
		while(«IF isInSelfex(coord, method)»lock_«method».isBusyByOtherThread() ||«ENDIF»
			«FOR partner : getMutexPartners(coord, method)»
			lock_«partner».isBusyByOtherThread() ||
			«ENDFOR»
			«IF(hasRequires(method, coord))»!requires_«method»()«ELSE»false«ENDIF»)
				try { wait(); } catch (InterruptedException e) {}
	
		lock_«method».in();
	}
	@After("execution(* «coord.className».«method»(..))")
	public synchronized void meth_«method»_unlock() {
	    lock_«method».out();
	    notifyAll();
	}
	'''
	
	def boolean hasRequires(String method, CoordinatorDeclaration coord) {
		for(guard : coord.body.guards) {
			if(guard.methods.contains(method))
				return true;
		}
		return false;
	}
	
	// return all the methods that appear either in selfex or in mutex
	def Set<String> getAllMethods(CoordinatorDeclaration coord) {
		val mySet = new HashSet<String>()
		for(method : coord.body.selfexMethods)
			mySet.add(method)
		for(mutex : coord.body.mutexSets)
			for(method : mutex.methods)
				mySet.add(method)
		
		return mySet
	}
	def isInSelfex(CoordinatorDeclaration coord, String method) {
		for(m : coord.body.selfexMethods)
			if(m.equals(method))
				return true;
				
		return false;
	}
	def Set<String> getMutexPartners(CoordinatorDeclaration coord, String method) {
		val result = new HashSet<String>()
		for(mutex : coord.body.mutexSets) {
			if(mutex.methods.contains(method))
				result.addAll(mutex.methods)
		}
		result.remove(method)
		return result
	}
	
	def compile(CondVar condvar) '''
	private boolean «condvar.name» = «condvar.value»;
	'''
	
	def compile(OrdVar ordvar) '''
	private int «ordvar.name» = «ordvar.value»;
	'''	
	
	def generateSelfexAdvice(String method, String className) '''
	@Before("execution(* «className».«method»(..))")
	public synchronized void meth_«method»_lock() {
		while(lock_«method».isBusyByOtherThread())
			try { wait(); } catch (InterruptedException e) {}
	
		lock_«method».in();
	}
	@After("execution(* «className».«method»(..))")
	public synchronized void meth_«method»_unlock() {
	    lock_«method».out();
	    notifyAll();
	}
	'''
	def getSimpleName(String qualifiedName) {
		qualifiedName.split("\\.").get(qualifiedName.split("\\.").size-1)
	}
	def generateMethodState() '''
import java.util.List;
import java.util.ArrayList;

public class MethodState {

	private List<Thread> threads = new ArrayList<Thread>();

	public synchronized void in() {
		threads.add(Thread.currentThread());
	}

	public synchronized void out() {
		threads.remove(Thread.currentThread());
	}

	/**
	 * 
	 * @return true if the method is currently being executed by other threads,
	 *         and is not executed by this thread. false, if the method is
	 *         executed by no thread, or if this method is executed by several
	 *         threads, including the current one.
	 */
	public synchronized boolean isBusyByOtherThread() {
		return (!isFree() && !threads.contains(Thread.currentThread()));
		/*
		 * Thread currentThread = Thread.currentThread(); for (Thread t:threads)
		 * if (t!=currentThread) return true; return false;
		 */
	}

	/**
	 * 
	 * @return true, if no thread is executing this method.
	 */
	public synchronized boolean isFree() {
		return threads.size()==0;
	}
}
	
	'''
		
}