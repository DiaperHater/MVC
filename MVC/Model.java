package MVC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Model {

    ObservableList<Dialog> currentDialogs;
    ObservableList<Dialog> originalDialogs;
    ObservableList<Dialog> foundByNameDialogs;

    public Model(List<Dialog> dialogs) {
        this.currentDialogs = FXCollections.observableArrayList();
        this.originalDialogs = FXCollections.observableArrayList();
        this.foundByNameDialogs = FXCollections.observableArrayList();

        originalDialogs.setAll(dialogs);
        currentDialogs.setAll(originalDialogs);

    }

    public void setDialog(Dialog dialog) {
        if (originalDialogs.contains(dialog)){
            return;
        }

        originalDialogs.add(dialog);
        currentDialogs.add(dialog);
    }

    public void removeDialog(Dialog dialog) {
        originalDialogs.remove(dialog);
        currentDialogs.remove(dialog);
    }
}
