package es.florida.util;
import java.io.File;
import java.io.FilenameFilter;

public class FilterExtencions implements FilenameFilter{
	String extension;
	public FilterExtencions(String extension){
		this.extension=extension;
	}
	public boolean accept(File dor, String name) {
		return name.endsWith(extension);
	}
	

}
