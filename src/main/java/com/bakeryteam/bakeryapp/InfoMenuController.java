package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.AbstractTableController;
import com.bakeryteam.bakeryapp.sql.SQLUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class InfoMenuController {
    //Панель информации
    @FXML
    private Label serverConnection;
    @FXML
    private ListView<String> activeOrdersListView;
    @FXML
    private Label activeOrders;

    @FXML
    public void onUpdateButtonClick() {
        try {
            if(SQLUtils.isServerConnected()) {
                serverConnection.setText("Хорошо");
            } else {
                SQLUtils.updateConnection();
                serverConnection.setText("Нет подключения");
            }
        } catch (Exception e) {
            serverConnection.setText("Ошибка");
        }

    }


}
