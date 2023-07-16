package com.example.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The SecurityService class for managing user authentication and logout in the Vaadin CRM application.
 * This class provides methods to retrieve the authenticated user details and to perform a logout operation.
 */
@Component
public class SecurityService {

    private final AuthenticationContext authenticationContext;

    /**
     * Constructs a new SecurityService with the provided AuthenticationContext.
     *
     * @param authenticationContext The AuthenticationContext used for user authentication.
     */
    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    /**
     * Retrieves the authenticated user details from the AuthenticationContext.
     *
     * @return The UserDetails of the authenticated user, or null if no user is authenticated.
     */
    public UserDetails getAuthenticatedUser() {
        Optional<UserDetails> userDetailsOptional = authenticationContext.getAuthenticatedUser(UserDetails.class);

        return userDetailsOptional.orElse(null);
    }

    /**
     * Performs a logout operation using the AuthenticationContext.
     * The authenticated user will be logged out after calling this method.
     */
    public void logout() {
        authenticationContext.logout();
    }

}
