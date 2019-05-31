import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

	public void downloadFileFromURL(String url, String filePathName, 
			int readTimeoutInSeconds) 
			throws MalformedURLException, IOException{
				
			//create connection, setting a timeout
			URLConnection urlConn = new URL(url).openConnection();
			if(readTimeoutInSeconds>0)
				urlConn.setReadTimeout(readTimeoutInSeconds*1000);
				
			//create the stream
			BufferedInputStream in=new BufferedInputStream(urlConn.getInputStream());
			FileOutputStream fos = new FileOutputStream(filePathName);

			//read the file
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] data = new byte[1024];
			int x=0;
			while((x=in.read(data,0,1024))>=0){
				bout.write(data,0,x);
			}
			bout.close();
			in.close();
		}	
	
}
