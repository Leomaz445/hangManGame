package com.example.demo.alert;

import com.example.demo.Messages;
import com.example.demo.enums.InformationCode;

import javafx.scene.control.Alert;

import java.util.Map;
import java.util.function.Consumer;


public class InformationMessagesAlert {

    private final static Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    private final Map<InformationCode, Consumer<Messages>> mapOfInformation = Map.of(
            InformationCode.YOU_WIN_OR_LOSE, this::createAlert,
            InformationCode.THANK_YOU_FOR_PLAYING, this::createAlert
    );

    public void getAlert(InformationCode alertCode, Messages messages) {
        mapOfInformation.get(alertCode).accept(messages);
    }


    private void createAlert(Messages messages) {
        alertInformation.setTitle(messages.getTitle());
        alertInformation.setHeaderText(messages.getHeader());
        alertInformation.setContentText(messages.getContent());
        alertInformation.showAndWait();
    }
}
