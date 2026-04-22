import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String [] songLibrary  = {
                "20 Cigarettes", "All the Love", "American Girls",
                "E85", "Hooligan", "Risk it All", "Seeing Someone",
                "So Easy", "Saint James Infirmary", "Turista"
        };

        String [] artistLibrary = {
                "Morgan Wallen", "Ye", "Harry Styles", "Don Toliver",
                "BTS", "Bruno Mars", "Luke Combs", "Olivia Dean",
                "Louis Armstrong", "Bad Bunny"
        };

        String [] filePathLibrary = {"audio/20 Cigarettes--Morgan Wallen.wav",
                "audio/All the Love--Ye.wav", "audio/American Girls--Harry Styles.wav",
                "audio/E85--Don Toliver.wav", "audio/Hooligan--BTS.wav",
                "audio/Risk it All--Bruno Mars.wav", "audio/Seeing Someone--Luke Combs.wav",
                "audio/So Easy--Olivia Dean.wav", "audio/song1.wav",
                "audio/Turista--Bad Bunny.wav"
        };

        System.out.println("=====JAMATKEV 3000======");
        System.out.println();
        System.out.println("   ===Your Playlist===");
        Playlist playlist = new Playlist();

        for (int i = 0; i < songLibrary.length; i++){
            SongNode song = new SongNode(songLibrary[i], artistLibrary[i], filePathLibrary[i]);
            playlist.addSong(song);
        }

        playlist.displayPlaylist();
        Player musicPlayer = new Player();

        System.out.println();

        menu(playlist, musicPlayer);

    }

    public static void menu(Playlist playlist, Player musicPlayer){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 9){
            // Menu layout
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Skip");
            System.out.println("4. Prev");
            System.out.println("5. Resume");
            System.out.println("6. Add");
            System.out.println("7. Remove");
            System.out.println("8. List Playlist");
            System.out.println("9. Exit");

            if (!sc.hasNextInt()){
                System.out.println("Enter a VALID NUMBER ONLY");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            while (choice < 1 || choice > 9){
                System.out.println("Please choose a VALID option");
                System.out.println("Options 1 - 9");
                choice = sc.nextInt();
            }


        }
        System.out.println("Program Is Now Closed");

    }
}