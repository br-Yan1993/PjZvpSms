package control;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import model.FileModel;
import model.PathModel;
 
public class ExtrairZipEtiqueta {
 
	private static final int BUFFER = 2048;
 
	public void extrateZip(Integer waitTime) {
		
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
		FileModel fl = new FileModel();
		String zipFile = fl.getFl1().toString();
		String pastaDestino = PathModel.PATH_ETIQUETA;
			try {
			File file = new File(pastaDestino);
			if (file.exists() == false) {
				file.mkdirs();
			}
			
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				int count;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new FileOutputStream(pastaDestino + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} 
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}