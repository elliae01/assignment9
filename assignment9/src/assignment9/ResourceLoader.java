package assignment9;

import java.io.InputStream;

public class ResourceLoader {

	
	public InputStream load (String str){
		InputStream input = ResourceLoader.class.getResourceAsStream(str);
		if(input ==null){
			input = ResourceLoader.class.getResourceAsStream(str);
		}
		
		
		return input;
		
	}
}
