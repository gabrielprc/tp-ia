package main.java.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Sistema Experto Odontológico");
        stage.setScene(createScene(loadMainPane()));
        stage.setWidth(1000);
        stage.setHeight(600);
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        VistaNavigator.MAIN
                )
        );

        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.CREATE_PATIENT_VIEW);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
