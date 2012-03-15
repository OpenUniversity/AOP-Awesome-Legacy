package awesome.ide.model.manifests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractManifest {
	
	private BufferedReader reader;
	public AbstractManifest(String contents) {
		reader = new BufferedReader(new StringReader(contents));
	}
	public List<ManifestEntry> getEntries() throws IOException {
		String line;
		List<ManifestEntry> result = new LinkedList<ManifestEntry>();
		while( (line = reader.readLine()) != null ) {
			String key = line.split(":")[0];
			String value = line.split(":")[1].trim();
			ManifestEntry entry = getEntryByKey(key);
			entry.setKey(key);
			entry.setValue(value);
			result.add(entry);
		}
		return result;
	}
	protected abstract ManifestEntry getEntryByKey(String key);	
}
