package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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