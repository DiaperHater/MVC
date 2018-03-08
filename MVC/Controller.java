package MVC;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getFindBoxField().setOnAction(this::onFind);
        view.getFindBoxField().setOnKeyReleased(this::onFind);
        view.getFindBoxClearButton().setOnAction(this::onClear);
    }

    private void onClear(ActionEvent event) {
        view.getFindBoxField().clear();
        find();
    }

    private void onFind(KeyEvent keyEvent) {
        find();
    }
    private void onFind(ActionEvent event) {
        find();
    }
    private void find() {
        String findText = view.findFieldVale();

        if (findText.isEmpty()){
            model.currentDialogs.setAll(model.originalDialogs);
        }

        model.foundByNameDialogs.clear();

        for (Dialog d : model.originalDialogs){
            if (d.user.toLowerCase().contains(findText.toLowerCase())){
                model.foundByNameDialogs.add(d);
            }
        }

        model.currentDialogs.setAll(model.foundByNameDialogs);
    }


}
