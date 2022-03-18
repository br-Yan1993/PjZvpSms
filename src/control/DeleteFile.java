package control;

import model.FileModel;

public class DeleteFile {
	
	public void deleteFile() {
		FileModel fm = new FileModel();
		try {
		if(fm.getFl1().exists() == true && fm.getFl2().exists() == true 
				&& fm.getFl3().exists() == true && fm.getFl4().exists() == true) {
			fm.getFl1().delete();
			fm.getFl2().delete();
			fm.getFl3().delete();
			fm.getFl4().delete();
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		}

}
