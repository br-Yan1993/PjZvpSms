import java.io.File;

public class DeleteFiles {
	
	File fl1 = new File("C:\\Users\\Master\\Desktop\\DownZip\\etiquetas.zip");
	File fl2 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Controle.pdf");
	File fl3 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.pdf");
	File fl4 = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.txt");
	
	public void deleteFile() {
		if(fl1.exists() == true && fl2.exists() == true && fl3.exists() == true && fl4.exists() == true) {
			try {
			fl1.delete();
			fl2.delete();
			fl3.delete();
			fl4.delete();
			}
			catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

}
