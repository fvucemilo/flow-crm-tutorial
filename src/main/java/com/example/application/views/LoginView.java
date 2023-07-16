package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/**
 * The login view for the Vaadin CRM application.
 * This view displays a login form where users can authenticate themselves.
 */
@AnonymousAllowed
@PageTitle("Login | Vaadin CRM")
@Route("login")
public class LoginView extends VerticalLayout implements BeforeEnterListener {

    private final LoginForm login = new LoginForm();

    /**
     * Constructs a new LoginView, setting up the login form.
     * The login form is centered vertically and horizontally within the layout.
     */
    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");

        add(
                new H1("Vaadin CRM"),
                login
        );
    }

    /**
     * Handles the "before enter" event for the login view.
     * If the URL query parameters contain the "error" parameter,
     * the login form's error state is set to true to display an error message.
     *
     * @param beforeEnterEvent The BeforeEnterEvent triggered before entering the view.
     */
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }

}
