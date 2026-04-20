public class Playlist {

    private SongNode head;
    private SongNode tail;
    private int size;
    private SongNode playing;

    public Playlist(){ // Constructor
        // setting default values
        head = null;
        tail = null;
        size = 0;
        playing = null;
    }


    // Methods

    public int getSize(){
        return size;  // returns how many songs are in the playlist.
    }
    public void addSong(SongNode song){
        if (size == 0){ // if the list is empty assign the song to the head/tail since it is the only song in the playlist.
            head = song;
            playing = song;
            tail = song;
            size++; // increase the size of the list since we added a song
        } else {
            song.setPrev(tail); // if the list is not empty add it to the end of the list. Last in structure
            tail.setNext(song);
            tail = song;
            size++; // increase the size of the list since we added a song
        }
    }
    public void displayPlaylist(){
        if (size == 0){ // If there are no songs in the playlist
            System.out.println("Playlist is EMPTY");
        } else {
            SongNode song = head; // set pointer to the head of the list and iterate through
            int counter = 1; // counter is used for display purposes to have a numbered list output
            while (song != null){ // iterate through the playlist

                String title = song.getSongName(); // Save each songs artis and song name to these variables
                String artist = song.getArtist();
                System.out.println(counter + ". " + title + " - " + artist); // formatted list output
                counter++; // increment counter so it is ordered
                song = song.getNext(); // go to the next song

            }
        }
    }

    public SongNode getPlaying(){
        return playing; // tells you which song in the playlist is currently being listened to.
    }

    public SongNode nextSong(){
        if (size == 0){
            return null; // if the playlist is empty there is no where to point next to, therefore/null.
        }
        else if (playing.getNext() != null) {
            playing = playing.getNext(); // traverse to the next song
        } else {
                playing = head; // if there is nowhere else to point to then loop the playlist back to the start
            }
        return playing;
    }
    public SongNode prevSong(){
        if (size == 0){
            return null; // same as next song. Can't point to anything if the list is empty.
        }
        else if (playing.getPrev() != null){
            playing = playing.getPrev(); // Traverses back in the playlist.
        } else {
            playing = tail;
        }
        return playing;

    }

    public void removeSong(String songName) {
        // Check if the playlist is empty
        if (size == 0) {
            System.out.println("There are no songs in your playlist to remove");
            return;
        }

        SongNode search = head; // start at the head and search in order
        // Search for the song
        while (search != null){ // iterates th rough the songs
            if (search.getSongName().equals(songName)){ // compares the user input to the song node title
                break; // once it find the correct song exit the loop
            }

            search = search.getNext(); // makes sure to go to the next node if none of the cases are satisfied.
        }
        if (search == null){ // if the song isn't in your playlist
            System.out.println("Song: " + songName + ", is not in your Playlist");
            return;
        }
        // If the song that is deleted is the song that is playing this case will run.
        if (search == playing){
            if (playing.getNext() != null){ // the song pointing to the song that is playing will skip to the next song.
                playing = playing.getNext();
            } else {
                playing = playing.getPrev(); // if it is the last song in the list, the previous song will start to play.
            }
        }

        if (size == 1){ // if there is only one song in the playlist
            // resets values since the list becomes empty
            head = null;
            tail = null;
            playing = null;
            size--; // list is empty therefore, size is now 0
        }
        else if (search == head && size > 1){ // if the song to delete is = to the head
            head = head.getNext();
            head.setPrev(null);
            size--;


        }
        else if (search == tail && size > 1){ // if the song to delete is = to the tail
            tail = tail.getPrev();
            tail.setNext(null);
            size--;

        } else { // if the song to delete is in the middle of the  linked list.
             search.getNext().setPrev(search.getPrev());
             search.getPrev().setNext(search.getNext());
             size--;

        }

    }


}