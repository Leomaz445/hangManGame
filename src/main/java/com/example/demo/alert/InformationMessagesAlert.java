package com.example.demo.alert;

import com.example.demo.Messages;
import com.example.demo.enums.InformationCode;
import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.function.Consumer;


public class InformationMessagesAlert {

    private final static Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    private final HashMap<InformationCode, Consumer<Messages>> mapOfInformation = new HashMap<InformationCode, Consumer<Messages>>() {{
        put(InformationCode.YOU_WIN_OR_LOSE, msg -> createAlert(msg));
        put(InformationCode.THANK_YOU_FOR_PLAYING, msg -> createAlert(msg));
    }};

    public void getAlert(InformationCode alertCode, Messages messages) {
        mapOfInformation.get(alertCode).accept(messages);
    }


    private void createAlert(Messages messages) {
        alertInformation.setTitle(messages.getTitle());
        alertInformation.setHeaderText(messages.getHeader());
        alertInformation.setContentText(messages.getContent());
        alertInformation.showAndWait();
    }

    public void showResultOfTheGame(InformationCode informationCode, String title, String header, String content) {
        getAlert(informationCode, new Messages.MessagesBuilder()
                .setTitle(title)
                .setHeader(header)
                .setContent(content)
                .build());
    }
}
