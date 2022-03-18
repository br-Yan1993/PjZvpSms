import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ImprimeDesk {
	
	String caminhoArquivo = "C:\\Users\\Super Moto Shop\\Desktop\\Etiquetas\\Etiqueta de envio.pdf";
	
	public void imprimeDesktop() throws InterruptedException {
		
		Thread.sleep(3000);
		
		Desktop desk = Desktop.getDesktop();
		
		try {
			File arquivo = new File(caminhoArquivo);
			desk.print(arquivo);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}