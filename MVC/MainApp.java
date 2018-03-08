package MVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        LocalDateTime time = LocalDateTime.now();
        List<Dialog> dialogs = new ArrayList<>();
        dialogs.add(new Dialog("Valery", time, "Hello"));
        dialogs.add(new Dialog("Snoop", time, "Hello World"));

        Model model = new Model(dialogs);
        View view = new View(model);
        Controller controller = new Controller(model, view);

        model.setDialog(new Dialog());
        model.removeDialog(dialogs.get(0));

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
