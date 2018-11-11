package general;

public class ConfigFileManager {

	private ConfigFileReader config;
	private static ConfigFileManager fileReadManager = new ConfigFileManager();

	private ConfigFileManager(){ }
	
	public static ConfigFileManager getInstance(){
		return fileReadManager;
	}

	public ConfigFileReader getConfiguration(){
		return (config==null)? new ConfigFileReader():config;
	}
}
