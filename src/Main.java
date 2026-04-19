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
        SongNode song1 = new SongNode("20 Cigaretttes", "Morgan Wallen", "../audio/20 Cigarettes--Morgan Wallen.mp3");
        SongNode song2 = new SongNode("All the Love", "Ye", "../audio/All the love--Ye.mp3");
        SongNode song3 = new SongNode("American Girls", "Harry Styles", "../audio/American Girls--Harry Styles.mp3");
        SongNode song4 = new SongNode("E85", "Don Toliver", "../audio/E85--Don Toliver.mp3");
        SongNode song5 = new SongNode("Hooligan", "BTS", "../audio/Hooligan--BTS.mp3");
        SongNode song6 = new SongNode("Risk it All", "Bruno Mars", "../audio/Risk it all--Bruno Mars.mp3");
        SongNode song7 = new SongNode("Seeing Someong", "Luke Combs", "../audio/Seeing Someone--Luke Combs.m-3");
        SongNode song8 = new SongNode("So Easy", "Olivia Dean", "../audio/SoEasy--Olivia Dean.mp3");
        SongNode song9 = new SongNode("Saint James Infirmary", "Louis Armstrong", "../audio/song1.mp3");
        SongNode song10 = new SongNode("Turista", "BadBunny", "../audio/Turista--Bad Bunny.mp3");



        Playlist playlist = new Playlist();
        playlist.displayPlaylist();
        playlist.addSong(song1);
        playlist.displayPlaylist();
        playlist.addSong(song4);
        playlist.addSong(song7);
        playlist.displayPlaylist();
        playlist.addSong(song2);
        playlist.getPlaying();
        System.out.println(playlist.getSize());
        System.out.println(playlist.getPlaying().getSongName());
        playlist.nextSong();
        System.out.println(playlist.getPlaying().getSongName());
        playlist.nextSong();
        playlist.nextSong();
        System.out.println(playlist.getPlaying().getSongName());
        playlist.prevSong();
        System.out.println(playlist.getPlaying().getSongName());







    }
}