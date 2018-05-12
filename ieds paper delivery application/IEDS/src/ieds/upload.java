package ieds;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
public class upload {

	public static int uploadFile(File binaryFile,String url) throws IOException {
		String charset = "UTF-8";
		String param = "value";
		String boundary = Long.toHexString(System.currentTimeMillis()); 
		String CRLF = "\r\n";
		URLConnection connection = new URL(url).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

		try (
		    OutputStream output = connection.getOutputStream();
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
		) {
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\"binaryFile\"; filename=\"" + binaryFile.getName() + "\"").append(CRLF);
		    writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
		    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
		    writer.append(CRLF).flush();
		    Files.copy(binaryFile.toPath(), output);
		    output.flush();
		    writer.append(CRLF).flush();
		    writer.append("--" + boundary + "--").append(CRLF).flush();
		}
		int responseCode = ((HttpURLConnection) connection).getResponseCode();
		System.out.println(responseCode); // Should be 200
		return responseCode;
	}

}
