package inClass;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A hyperlink in javafx contains a link and can add functionality
 */
public class HyperLink extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Hyperlink hyperlink = new Hyperlink("Click me!");
        hyperlink.setOnAction(event -> {
            System.out.println("Hyperlink clicked");
        });

        hyperlink.setOnAction(event -> {
            try {
                HostServices hostServices = getHostServices();
                hostServices.showDocument("https://www.google.com");
                //hostServices.showDocument(hyperlink.getText());
            } catch (Exception e) {
                System.err.println(e);
            }
        });

        hyperlink.setStyle("-fx-text-fill: red;" +
                " -fx-font-size: 20;" +
                "-fx-font-weight: bold;" +
                "-fx-underline: true");

        //Disable hyperlink
        // hyperlink.setDisable(true);

        VBox root = new VBox(hyperlink);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Hyperlink");
        stage.show();
    }
}
