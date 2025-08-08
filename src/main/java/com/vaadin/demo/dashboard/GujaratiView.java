package com.vaadin.demo.dashboard;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Simple view to practice Gujarati phrases.
 */
public class GujaratiView extends VerticalLayout implements View {

    public GujaratiView() {
        setMargin(true);
        setSpacing(true);

        Label title = new Label("Gujarati Practice");
        title.addStyleName("h1");
        addComponent(title);

        addPhrase("Hello", "નમસ્તે");
        addPhrase("How are you?", "કેમ છો?");
        addPhrase("Thank you", "આભાર");
    }

    private void addPhrase(String english, String gujarati) {
        Button b = new Button(english + " - " + gujarati);
        b.addClickListener(event -> {
            String js = "var msg = new SpeechSynthesisUtterance('" + gujarati.replace("'", "\\'") + "');" +
                    "msg.lang='gu-IN';window.speechSynthesis.speak(msg);";
            Page.getCurrent().getJavaScript().execute(js);
        });
        addComponent(b);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // No actions needed on view change
    }
}
