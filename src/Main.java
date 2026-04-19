/* In order to play music I will need to download Java Awt
desktop api.

It lets the java program interact with the desktop to open files,
browse, etc...

java.io.File is how it represents pathfile on the disk
 */
import java.awt.Desktop;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File mp3File = new File("audio/20 Cigarettes--Morgan Wallen.mp3");
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                try {
                    desktop.open(mp3File); // This actually opens the mp3 using default application
                } catch (Exception e) {
                    e.printStackTrace(); // object that describes what went wrong if something went wrong.
                }
            }
        }
    }
}