
public class Main {
    private int imageCount = 10000;
    private String soursPrnt = "https://prnt.sc/";
    private String soursImgur = "https://i.imgur.com/";
    private String look = "https://look.com.ua/pic/201610/2560x1440/look.com.ua-";
    private static int lookCounter = 181750;
    private final ImageDownloader downloader = new ImageDownloader();
    private final PageDownloader pageDownloader = new PageDownloader();
    private final LinkGenerator linkGenerator = new LinkGenerator();
    private final String strPath = "C:\\Users\\kater\\OneDrive\\Bilder\\";
    private final int buffSize = 1024;



    public static void main(String[] args) {
        System.out.println("Start program");
        new ThreadLook().start();

       //new ThreadPrnt().start();

       //new ThreadImgur().start();
    }

    public synchronized void downloadLook() {
        while (true){
            int i = ++ lookCounter;
            System.out.println("image number: " + i);
            downloader.downloadFiles(look + i + ".jpg", strPath+"look\\" + i + ".jpg", buffSize);
        }
    }

    public void downloadPrnt(){
        for(int i = 0; i<imageCount; i++) {
            System.out.println("image number: " + i);
            String link = linkGenerator.linkGenerate(6);
            System.out.println(link);

            String page = pageDownloader.getPage(soursPrnt + link);
            if(!page.contains("image_url="))
                continue;
            page = page.substring(page.indexOf("image_url="));
            String imageUrl = page.substring(10, page.indexOf(".png") + 4);

            downloader.downloadFiles(imageUrl,strPath+"prnt\\" + link + ".png",buffSize);
            System.out.println("image: " + link + " download");
        }
    }

    public void downloadImgur(){
        for(int i = 0; i<imageCount; i++) {
            System.out.println("imgur image number: " + i);
            String link = linkGenerator.linkGenerateWithAllWorld(6)+ ".jpg";

            System.out.println(soursImgur + link);

            downloader.downloadFiles(soursImgur + link,strPath+"imgur\\" + link ,buffSize);
            System.out.println("image: " + link + " download");
        }
    }


}