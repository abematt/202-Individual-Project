package fileTypes;

public class FileCreators {

	public static FileType makeFile(String fileType) {
		
		if (fileType.contains(".csv")) {
			System.out.println("WE IN CSV");
            return new CsvFile();
		}
			
        else if (fileType.contains(".xml")) {
        	System.out.println("WE IN XML");
        	return new XmlFile();	
        }
        else if (fileType.contains(".json")) {
        	System.out.println("WE IN JSON");
        	return new JsonFile();
        }
            
        else
            return null;
	}
}
