package com.stormpath.sdk.impl.oauth;

import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.oauth.OAuthStormpathTokenGrantRequestAuthentication;

/**
 * @since 1.1.0
 */
public class DefaultOAuthStormpathTokenGrantRequestAuthentication implements OAuthStormpathTokenGrantRequestAuthentication {
    private final static String grant_type = "stormpath_token";

    private String token;

    public DefaultOAuthStormpathTokenGrantRequestAuthentication(String token) {
        Assert.hasText(token, "token cannot be null or empty.");
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getGrantType() {
        return grant_type;
    }
}
