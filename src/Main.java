import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("=====JAMATKEV 3000======");
        System.out.println();
        System.out.println("   ===Your Playlist===");

        // Creates a new playlist object
        Playlist playlist = new Playlist();

        // Loads songs from libary arrays into the playlist
        for (int i = 0; i < songLibrary.length; i++){
            SongNode song = new SongNode(songLibrary[i], artistLibrary[i], filePathLibrary[i]);
            playlist.addSong(song);
        }

        // Displays all the songs in playlist
        playlist.displayPlaylist();

        // Creates a music player object
        Player musicPlayer = new Player();

        System.out.println();

        // Starts the menu interface
        menu(playlist, musicPlayer);

    }

    public static void menu(Playlist playlist, Player musicPlayer){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 9){
            // Menu layout
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Resume");
            System.out.println("4. Prev");
            System.out.println("5. Skip");
            System.out.println("6. Add");
            System.out.println("7. Remove");
            System.out.println("8. List Playlist");
            System.out.println("9. Exit");

            // Makes sure input is an integer
            if (!sc.hasNextInt()){
                System.out.println("Enter a VALID NUMBER ONLY");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            // Makes sure choice is within range
            while (choice < 1 || choice > 9){
                System.out.println("Please choose a VALID option");
                System.out.println("Options 1 - 9");
                choice = sc.nextInt();
            }

            // Choice 1: Play current song
            if (choice == 1){
                SongNode current = playlist.getPlaying(); // Gets current song
                if (current == null){
                    System.out.println("Playlist is Empty");
                } else {
                    System.out.println("Now Playing: " + current.getSongName() + " - " + current.getArtist());
                    musicPlayer.play(current.getFilePath());
                    musicPlayer.play(current.getFilePath()); // Plays audio file

                }

            }
            // Option 2: Pauses song
            else if (choice == 2){
                System.out.println("Music Pause..");
                musicPlayer.pause();
            }
            //Option 3: Resumes song
            else if (choice == 3){
                musicPlayer.resume();
            }
            //Option 4: Goes to previous song
            else if (choice == 4){
                SongNode prev = playlist.prevSong();
                if (prev == null){
                    System.out.println("Playlist is Empty");
                } else {
                    System.out.println("Now Playing: " + prev.getSongName() + " - "
                    + prev.getArtist());
                }

            }
            //Option 5: Skips to next song
            else if (choice == 5){
                SongNode skip = playlist.nextSong();

                if (skip == null){
                    System.out.println("Playlist is empty");
                } else {
                    System.out.println("Now Playing: " + skip.getSongName() + " - "
                            + skip.getArtist());
                }
            }
            //Option 6: Adds a song from library to playlist
            else if (choice == 6){
                System.out.print("Enter song title to add from library: ");
                String title = sc.nextLine().trim();

                boolean find = false;
                
                // Searches for song in library
                for (int i = 0; i < songLibrary.length; i++){
                    if (songLibrary[i].equalsIgnoreCase(title)){
                        SongNode newSong = new SongNode(songLibrary[i], artistLibrary[i], filePathLibrary[i]);
                        playlist.addSong(newSong);
                        System.out.println("Added: " + songLibrary[i] + " - " + artistLibrary[i]);
                        find = true;
                        break;
                    }
                }
                // If song isnt found in library
                if (!find){

                    System.out.println("Song \"" + title + "\" is not in the library.");
                }
            }
            // Option 7: Removes a song from playlist
            else if (choice == 7){
                System.out.println("Enter song to remove: ");
                String songname = sc.nextLine().trim();
                playlist.removeSong(songname);
            }
            // Option 8: Displays current playlist
            else if (choice == 8){
                System.out.println();
                System.out.println("===Your Current Playlist===");
                System.out.println();
                playlist.displayPlaylist();
                System.out.println();
            }


        }
        System.out.println("Program Is Now Closed");

    }
    // Song titles available 
    static String [] songLibrary  = {
            "20 Cigarettes", "All the Love", "American Girls",
            "E85", "Hooligan", "Risk it All", "Seeing Someone",
            "So Easy", "Saint James Infirmary", "Turista"
    };
    // Corresponding artists for each song
    static String [] artistLibrary = {
            "Morgan Wallen", "Ye", "Harry Styles", "Don Toliver",
            "BTS", "Bruno Mars", "Luke Combs", "Olivia Dean",
            "Louis Armstrong", "Bad Bunny"
    };
    // File paths for audio files
    static String [] filePathLibrary = {"audio/20 Cigarettes--Morgan Wallen.wav",
            "audio/All the Love--Ye.wav", "audio/American Girls--Harry Styles.wav",
            "audio/E85--Don Toliver.wav", "audio/Hooligan--BTS.wav",
            "audio/Risk it All--Bruno Mars.wav", "audio/Seeing Someone--Luke Combs.wav",
            "audio/So Easy--Olivia Dean.wav", "audio/song1.wav",
            "audio/Turista--Bad Bunny.wav"
    };

}
