package com.stormpath.sdk.impl.oauth;

import com.stormpath.sdk.resource.Resource;

/**
 * @since 1.1.0
 */
public interface OAuthStormpathTokenGrantAuthenticationAttempt extends Resource {
    /**
     * Method used to set the Authentication Grant Type that will be used for the token exchange request.
     * @param grantType the Authentication Grant Type that will be used for the token exchange request.
     */
    void setGrantType(String grantType);

    /**
     * Method used to set the JWT Token from ID Site.
     * @param token the JWT Token
     */
    void setToken(String token);
}
