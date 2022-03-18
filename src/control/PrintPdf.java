package control;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import model.FileModel;

public class PrintPdf {
		
		public void printFileEtiqueta(Integer waitTime) throws InterruptedException {
			
			FileModel file = new FileModel();
			String caminhoArquivo = file.getFl3().toString();
			
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
