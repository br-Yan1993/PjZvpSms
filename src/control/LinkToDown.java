package control;

import java.awt.Desktop;
import java.net.URL;

import model.PathModel;

public class LinkToDown {
	
	String link = PathModel.PATH_LINK_DOWN_ZIP;
	
	public void openAndDownZip(String txt, Integer waitTime) {
	    try {
	    	Thread.sleep(waitTime);
	        Desktop.getDesktop().browse(
	        		new URL(link +
	        txt).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
