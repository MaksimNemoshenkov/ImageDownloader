import java.security.SecureRandom;

public class LinkGenerator {
    SecureRandom random = new SecureRandom();

    public String linkGenerate(int lengthLink){
        StringBuilder sb = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < lengthLink; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public String linkGenerateWithAllWorld(int lengthLink){
        String allChars = "ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengthLink; i++)
        {
            int randomIndex = random.nextInt(allChars.length());
            sb.append(allChars.charAt(randomIndex));
        }
        return sb.toString();
    }

}
