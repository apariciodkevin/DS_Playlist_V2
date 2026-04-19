

public class SongNode {
    // Variables that make up a song in the playlist.
    private String artist;
    private String songName;
    private String filePath;
    private SongNode next;
    private SongNode prev;

    public SongNode(String songName, String artist, String filePath){
        this.songName = songName;
        this.artist = artist;
        this.filePath = filePath;
        this.next = null;
        this.prev = null;
    }

    // Getters and Setters to access data.

    public String getArtist(){
        return artist;
    }
    public String getSongName(){
        return songName;
    }
    public String getFilePath(){
        return filePath;
    }
    public SongNode getNext(){
        return next;
    }
    public SongNode getPrev(){
        return prev;
    }
    public void setNext(SongNode next){
        this.next = next;
    }
    public void setPrev(SongNode prev){
        this.prev = prev;
    }



}
