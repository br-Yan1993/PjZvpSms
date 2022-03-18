package control;

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

import model.FileModel;

public class ConvertTxtToZvp {
    
	public void convertIntoPdf(Integer waitTime) throws IOException, InterruptedException {
	FileModel filePath = new FileModel();
	Path path = Paths.get(filePath.getFl4().toString());
		
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
	    File file = new File(filePath.getFl3().toString()); // change file name for PNG images
	    Files.write(file.toPath(), body);
	} else {
	    String errorMessage = new String(body, StandardCharsets.UTF_8);
	    System.out.println(errorMessage);
	}
	}
	public static void main(String[] args) {
		ConvertTxtToZvp c = new ConvertTxtToZvp();
		try {
			c.convertIntoPdf(0);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
