package track_fitness;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private Hyperlink githubLink;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        githubLink.setOnAction(event -> {
            try {
                URI uri = new URI(githubLink.getText());
                openWebpage(uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    private void openWebpage(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Desktop is not supported. Cannot open the URL.");
        }
    }
}
