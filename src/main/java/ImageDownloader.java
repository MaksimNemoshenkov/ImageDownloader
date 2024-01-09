import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader {

    public void downloadFiles(String strURL, String strPath, int buffSize)  {
        try {
            URL connection = new URL(strURL);
            HttpURLConnection urlconn;
            urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = null;
            in = urlconn.getInputStream();

            File file = new File(strPath);

            if(!file.exists()) {
                //Создаем его.
                file.createNewFile();
            }
            OutputStream writer = new FileOutputStream(file);

            byte[] buffer = new byte[buffSize];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            System.out.println("image "+ strPath + " downloaded");
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
