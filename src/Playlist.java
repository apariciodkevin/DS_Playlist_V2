public class Playlist {

    private SongNode head;
    private SongNode tail;
    private int size;
    private SongNode playing;

    public Playlist(){ // Constructor
        head = null;
        tail = null;
        size = 0;
        playing = null;
    }

    // Methods

    public int getSize(){
        return size;
    }
    public void addSong(SongNode song){
        if (size == 0){ // if the list is empty
            head = song;
            playing = song;
            tail = song;
            size++;
        } else {
            song.setPrev(tail);
            tail.setNext(song);
            tail = song;
            size++;
        }
    }
    public void displayPlaylist(){
        if (size == 0){ // If there are no songs in the playlist
            System.out.println("Playlist is EMPTY");
        } else {
            SongNode song = head;
            int counter = 1;
            while (song != null){
                String title = song.getSongName();
                String artist = song.getArtist();
                System.out.println(counter + ". " + title + " - " + artist);
                counter++;
                song = song.getNext();

            }
        }
    }

    public SongNode getPlaying(){
        return playing;
    }

    public SongNode nextSong(){
        if (size == 0){
            return null;
        }
        else if (playing.getNext() != null) {
            playing = playing.getNext();
        } else {
                playing = head;
            }
        return playing;
    }
    public SongNode prevSong(){
        if (size == 0){
            return null;
        }
        else if (playing.getPrev() != null){
            playing = playing.getPrev();
        } else {
            playing = tail;
        }
        return playing;

    }
    public void removeSong(){

    }


}
