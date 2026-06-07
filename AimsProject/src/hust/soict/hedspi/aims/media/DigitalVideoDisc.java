package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {
        super();
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title) {
        super();
        setId(++nbDigitalVideoDiscs);
        setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, null, 0);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, director, 0);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director, length);
        setId(++nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title) {
        if (title == null || getTitle() == null) {
            return false;
        }
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}