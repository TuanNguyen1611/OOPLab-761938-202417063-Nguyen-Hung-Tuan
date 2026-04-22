package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.length <= 0) {
            System.out.println("ERROR: Track cannot be played");
            return;
        }
        System.out.println("Playing Track: " + this.title);
        System.out.println("Track length: " + this.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return this.length == other.length &&
                ((this.title == null && other.title == null) ||
                        (this.title != null && this.title.equals(other.title)));
    }

    @Override
    public String toString() {
        return "Track - " + title + " - " + length;
    }
}