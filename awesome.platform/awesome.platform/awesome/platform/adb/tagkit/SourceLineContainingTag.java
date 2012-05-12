package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.aspectj.weaver.AjAttribute;

/**
 * Base class for all attributes that contain references 
 * to source file lines
 * 
 *
 */
public abstract class SourceLineContainingTag extends AjAttribute 
{
	private Map<String,Integer> paths = new TreeMap<String,Integer>();

	private List<String> files = new ArrayList<String>(1);
	
	private boolean statefull;
	
	int lastID = -1,maxId = 0;
	public SourceLineContainingTag(boolean statefull){
		this.statefull = statefull;
	}
	
	public String getLinePart(String file,String path,int lnr){
		if(!statefull)
			return getFileId(file,path)+":" +lnr;
		else{
			int fid = getFileId(file,path); 
			if(lastID == fid){
				return ""+lnr;
			}else{
				lastID = fid;
				return getFileId(file,path)+":" +lnr;
			}
		}
	}
	
	private int getFileId(String file,String path) {
		Integer out = (Integer) paths.get(path);
		if(out == null){
			int id = files.size();
			files.add(file);
			paths.put(path, new Integer(id));
			return id;
		}
		
		return out.intValue();
	}
	
	protected abstract String getValue();
	public abstract String getNameString();
	
	@Override
	protected void write(DataOutputStream s) throws IOException 
	{
		String JS = getValue();
		
		StringBuffer buf = new StringBuffer();

		if (files.size() > 0) {
			buf.append(filesSection());
		}
		buf.append(JS);
		
		
		s.write(buf.toString().getBytes());		

	}

	private Object filesSection() {
		
		StringBuffer buf = new StringBuffer();
		buf.append("*F\n");
		
		for(Iterator<String> it = paths.keySet().iterator();it.hasNext();){
			String path =  it.next();
			Integer i =  paths.get(path);
			String file = files.get(i.intValue());
			
			if(path.equals(file))
				buf.append(i.toString() + " " + file + "\n");
			else{
				buf.append("+ " + i.toString() + " " + file + "\n");
				buf.append(path +"\n");
			}
				
		}
		buf.append("*B\n");
		
		return buf.toString();
	}
	
	

}
