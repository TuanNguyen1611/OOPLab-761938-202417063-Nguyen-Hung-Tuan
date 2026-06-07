package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();

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

        // DVD này dùng để test PlayerException
        // Vì length = 0 nên khi bấm Play sẽ báo lỗi
        store.addMedia(new DigitalVideoDisc(
                "Test Invalid DVD",
                "Test",
                "Unknown",
                0,
                1.0f
        ));

        store.addMedia(new Book("The Hunger Games", "Novel", 5.5f));
        store.addMedia(new Book("Catching Fire", "Novel", 4.9f));
        store.addMedia(new Book("Mockingjay", "Novel", 5.1f));

        ViewStoreController controller = new ViewStoreController(store, cart);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"
        ));
        loader.setController(controller);

        Scene scene = new Scene(loader.load());
        stage.setTitle("AIMS Store");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}