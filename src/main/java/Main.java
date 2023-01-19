
public class Main {
    int imageCount = 10000;
    String soursPrnt = "https://prnt.sc/";
    String soursImgur = "https://i.imgur.com/";
    ImageDownloader downloader = new ImageDownloader();
    PageDownloader pageDownloader = new PageDownloader();
    LinkGenerator linkGenerator = new LinkGenerator();


    public static void main(String[] args) {
        System.out.println("Start program");
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();
        new ThreadPrnt().start();


/*
        new ThreadImgur().start();
        new ThreadImgur().start();
        new ThreadImgur().start();
        new ThreadImgur().start();
*/

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

            downloader.downloadFiles(imageUrl,"temp/" + link + ".png",1);
            System.out.println("image: " + link + " download");
        }
    }

    public void downloadImgur(){
        for(int i = 0; i<imageCount; i++) {
            System.out.println("imgur image number: " + i);
            String link = linkGenerator.linkGenerateWithAllWorld(6)+ ".jpg";

            System.out.println(soursImgur + link);

            downloader.downloadFiles(soursImgur + link,"imgur/" + link ,1);
            System.out.println("image: " + link + " download");
        }
    }

}