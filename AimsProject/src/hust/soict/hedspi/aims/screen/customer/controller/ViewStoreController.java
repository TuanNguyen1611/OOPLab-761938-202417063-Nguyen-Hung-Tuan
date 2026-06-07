package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart;

    public ViewStoreController() {
        this.store = new Store();
        this.cart = new Cart();

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

        store.addMedia(new Book("The Hunger Games", "Novel", 5.5f));
        store.addMedia(new Book("Catching Fire", "Novel", 4.9f));
        store.addMedia(new Book("Mockingjay", "Novel", 5.1f));
    }

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        int column = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml"
                ));

                Node item = loader.load();

                ItemController itemController = loader.getController();
                itemController.setData(media, cart);

                gridPane.add(item, column, row);

                column++;
                if (column == 3) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"
            ));

            loader.setController(new CartController(cart, store));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("AIMS Cart");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}