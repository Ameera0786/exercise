package inClass;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class Controller {
    private FileChooser fileChooser = new FileChooser();
    @FXML
    private ImageView imageView;

    @FXML
    private void open(){
        //fileChooser.showOpenDialog(null);
        File file = fileChooser.showOpenDialog(imageView.getScene().getWindow());
//        try {
//            Image image = ImageUtil.readImage(file.toPath());
//        } catch (IOException e) {
//
//        }
    }

    @FXML
    private void close(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("Exiting...");
        alert.showAndWait();
        Platform.exit();
    }


}
