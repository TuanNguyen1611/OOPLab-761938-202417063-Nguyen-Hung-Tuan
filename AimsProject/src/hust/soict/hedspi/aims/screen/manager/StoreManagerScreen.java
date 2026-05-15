package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class StoreManagerScreen extends JFrame {

    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS");
        setSize(1024, 768);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });

        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(viewStore);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));

        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            MediaStore cell = new MediaStore(store.getItemsInStore().get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {

        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Philosopher's Stone (2001)",
                "Fantasy",
                "Chris Columbus",
                152,
                3.0f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Chamber of Secrets (2002)",
                "Fantasy",
                "Chris Columbus",
                161,
                3.5f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Prisoner of Azkaban (2004)",
                "Fantasy",
                "Alfonso Cuaron",
                142,
                5.0f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Goblet of Fire (2005)",
                "Fantasy",
                "Mike Newell",
                157,
                4.5f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Fetch the Bolt Cutters",
                "Music",
                "Fiona Apple",
                60,
                10.39f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Future Nostalgia",
                "Music",
                "Dua Lipa",
                45,
                9.6f
        ));

        store.addMedia(new Book(
                "The Hunger Games",
                "Novel",
                5.5f
        ));

        store.addMedia(new Book(
                "Catching Fire",
                "Novel",
                4.9f
        ));

        store.addMedia(new Book(
                "Mockingjay",
                "Novel",
                5.1f
        ));

        new StoreManagerScreen(store);
    }
}