import java.awt.Desktop;
import java.net.*;

public class URLLauncher {
    public static void main(String[] args) {
        String url = "https://www.google.com";

        try {
            URI uri = new URI(url);

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                desktop.browse(uri);
            } else {
                System.out.println("Desktop is not supported. Unable to open the browser.");
            }
        } catch (Exception e) {
            System.err.println("Error opening the browser: " + e.getMessage());
        }
    }
}
