package MVC;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.format.DateTimeFormatter;

public class DialogListViewItem extends GridPane {
    private Label userName = new Label("user");
    private Label time = new Label("time");
    private Label body = new Label("body");

    {
        add(userName, 1,1);
        add(time, 2, 1);
        add(body, 1, 2);
    }

    public DialogListViewItem(Dialog dialog) {
        userName.setText(dialog.user);
        time.setText(dialog.time.format(DateTimeFormatter.ofPattern("hh:mm")));
        body.setText(dialog.body.split("\n")[0]); //only first line
    }

    public String getUserName() {
        return userName.getText();
    }

}
