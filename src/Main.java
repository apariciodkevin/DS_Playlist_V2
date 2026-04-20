/* In order to play music I will need to download Java Awt
desktop api.

It lets the java program interact with the desktop to open files,
browse, etc...

java.io.File is how it represents pathfile on the disk
 */
import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== Play THAT LIST =====");
        System.out.println("      == WELCOME! ==");
        System.out.println();
        System.out.println("My Library:");

        showLibrary();
        System.out.println();
        menu();






        // Program sets up the music library

       /* File mp3File = new File("audio/20 Cigarettes--Morgan Wallen.mp3");
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                try {
                    desktop.open(mp3File); // This actually opens the mp3 using default application
                } catch (Exception e) {
                    e.printStackTrace(); // object that describes what went wrong if something went wrong.
                }
            }
        } */

    }

    // Set up libraries that hold song information [indexed]
    static String [] librarySong = {"20 Cigarettes", "All the Love", "American Girls", "E85",
            "Hooligan", "Risk it All", "Seeing Someone", "So Easy", "Saint James Infirmary",
            "Turista"};

    static String [] libraryArtist = {"Morgan Wallen", "Ye", "Harry Styles", "Don Toliver",
            "BTS", "Bruno Mars", "Luke Combs", "Olivia Dean", "Louis Armstrong",
            "Bad Bunny" };

    static String [] libraryPath = {"audio/20 Cigarettes--Morgan Wallen.mp3", "audio/All the Love--Ye.mp3",
            "audio/American Girls--Harry Styles.mp3", "audio/E85--Don Toliver.mp3",
            "audio/Hooligan--BTS.mp3", "audio/Risk it All--Bruno Mars.mp3",
            "audio/Seeing Someone--Luke Combs.mp3", "audio/SoEasy--Olivia Dean.mp3",
            "audio/song1.mp3", "audio/Turista--Bad Bunny.mp3"};

    public static void showLibrary(){
        int counter = 1;
        for (int i = 0; i < librarySong.length; i++){
            System.out.println(counter + ". " + librarySong[i] + " - " + libraryArtist[i]);
            counter++;
        }
    }

    public static void menu(){
        // initialize scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MENU ===");
        System.out.println("1. Add Song");
        System.out.println("2. Remove Song");
        System.out.println("3. Play");
        System.out.println("4. Exit");

        int choice = sc.nextInt();
        // Validate user input
        while (choice < 1 || choice > 4){
            System.out.println("INVALID INPUT");
            System.out.println("Choose from the options below:");
            System.out.println();

            System.out.println("=== MENU ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play");
            System.out.println("4. Exit");
            choice = sc.nextInt();

        }
    }
}