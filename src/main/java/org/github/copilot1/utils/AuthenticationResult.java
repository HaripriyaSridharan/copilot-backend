package org.github.copilot1.utils;

import org.github.copilot1.models.User;

public class AuthenticationResult {
        private final boolean authenticated;
        private final User user;

        public AuthenticationResult(boolean authenticated, User user) {
            this.authenticated = authenticated;
            this.user = user;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public User getUser() {
            return user;
        }
    }
