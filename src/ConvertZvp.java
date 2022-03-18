import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.print.PrintException;

public class ConvertZvp {
	
//	Path path = Paths.get("C:\\Users\\Note\\Desktop\\Etiqueta de envio.txt");
	Path path = Paths.get("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.txt");
 
        
    
	public void start() throws IOException, InterruptedException, PrintException {
		
	Thread.sleep(3000);
	String content = Files.readString(path);
	// adjust print density (8dpmm), label width (4 inches), label height (6 inches), and label index (0) as necessary
	URI uri = URI.create("http://api.labelary.com/v1/printers/8dpmm/labels/4x6/0/");
	HttpRequest request = HttpRequest.newBuilder(uri)
	    .header("Accept", "application/pdf") // omit this line to get PNG images back
	    .POST(BodyPublishers.ofString(content))
	    .build();
	HttpClient client = HttpClient.newHttpClient();
	HttpResponse<byte[]> response = client.send(request, BodyHandlers.ofByteArray());
	byte[] body = response.body();
	

	if (response.statusCode() == 200) {
	    File file = new File("C:\\Users\\Master\\Desktop\\Etiquetas\\Etiqueta de envio.pdf"); // change file name for PNG images
	    Files.write(file.toPath(), body);
	} else {
	    String errorMessage = new String(body, StandardCharsets.UTF_8);
	    System.out.println(errorMessage);
	}
	
	
	
//	DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
//    PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
//    patts.add(Sides.DUPLEX);
//    PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
//    if (ps.length == 0) {
//        throw new IllegalStateException("No Printer found");
//    }
//
////    System.out.println("Available printers: " + Arrays.asList(ps));
//
//    PrintService myService = null;
//    for (PrintService printService : ps) {
//        if (printService.getName().equals("TESTE")) {
//            myService = printService;
//            break;
//        }
//    }
//
//    if (myService == null) {
//        throw new IllegalStateException("Printer not found");
//    }
//
//    FileInputStream fis = new FileInputStream("C:\\Users\\Super Moto Shop\\Desktop\\Capturar.JPG");
//    Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
//    DocPrintJob printJob = myService.createPrintJob();
//    printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
//    fis.close();
//	
	}
	}
