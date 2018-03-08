package MVC;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;



public class View extends VBox {
    private Model model;
    private FindField findField = new FindField();
    private ListView listView = new ListView();

    public View(Model model) {
        this.model = model;

        ObservableList<DialogListViewItem> items = FXCollections.observableArrayList();
        for(Dialog d : model.currentDialogs){
            items.add(new DialogListViewItem(d));
        }
        listView.setItems(items);

        model.currentDialogs.addListener(new ListChangeListener<Dialog>() {
            @Override
            public void onChanged(Change<? extends Dialog> c) {
                listView.getItems().clear();
                ObservableList<DialogListViewItem> items =
                        FXCollections.observableArrayList();

                for (Dialog d : model.currentDialogs){
                    items.add(new DialogListViewItem(d));
                }

                listView.setItems(items);
            }
        });

        getChildren().addAll(findField, listView);
    }

    public TextField getFindBoxField() {
        return findField.getField();
    }

    public Button getFindBoxClearButton() {
        return findField.getClearBtn();
    }

    public String findFieldVale() {
        return findField.getValue();
    }

    public ObservableList<DialogListViewItem> getItems() {
        return listView.getItems();
    }

    public void load(ObservableList<DialogListViewItem> found) {
        listView.setItems(found);
    }


}
