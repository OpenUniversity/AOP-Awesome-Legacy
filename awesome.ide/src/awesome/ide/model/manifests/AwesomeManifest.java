package awesome.ide.model.manifests;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import awesome.ide.model.MechanismProject;

public abstract class AwesomeManifest {
	
	private BufferedReader reader;
	protected MechanismProject project = null;
	private boolean dirty = false; 
	
	/**
	 * This constructor is for testing purposes only
	 * @param contents
	 */
	public AwesomeManifest(String contents) {
		reader = new BufferedReader(new StringReader(contents));
	}
	public AwesomeManifest(MechanismProject project) {
		this.project = project;
		dirty = true;
	}
	public List<ManifestEntry> getEntries() throws Exception {
		// if the content of the file was changed, we update reader
		if(dirty) {
			InputStream is = ResourcesPlugin.getWorkspace().getRoot().getProject(project.getProjectName()).getFile(getPath()).getContents();
			reader = new BufferedReader(new InputStreamReader(is));
			dirty = false;
		}
			
		String line;
		List<ManifestEntry> result = new LinkedList<ManifestEntry>();
		while( (line = reader.readLine()) != null ) {
			String key = line.split(":")[0];
			String value = line.split(":")[1].trim();
			ManifestEntry entry = new ManifestEntry();
			entry.setKey(key);
			entry.setValue(value);
			result.add(entry);
		}
		return result;
	}
	public ManifestEntry getEntry(String key) throws Exception {
		List<ManifestEntry> entries = getEntries();
		
		for(ManifestEntry entry : entries)
			if(entry.getKey().equals(key))
				return entry;
		
		return null;
	}
	public void addEntry(String key, String value) throws Exception {
		if(keyIsNotKnown(key))
			throw new Exception("Provided key " + key + " is unknown");
		// add the new entry to the manifest file
		IProject proj = ResourcesPlugin.getWorkspace().getRoot().getProject(project.getProjectName());
		IFile manifest = proj.getFile(getPath());
		manifest.appendContents(toInputStream(key + ": " + value), true, false, null);
		// mark that the content of the file is modified
		dirty = true;
	}

	private InputStream toInputStream(String str) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(str.getBytes("UTF-8"));
	}
	/**
	 * Return true if the given entry key is unknown
	 * @param key
	 * @return
	 */
	protected abstract boolean keyIsNotKnown(String key);
	
	/**
	 * Returns the path of the manifest relative to the containing project
	 * @return
	 */
	public abstract IPath getPath();
}
