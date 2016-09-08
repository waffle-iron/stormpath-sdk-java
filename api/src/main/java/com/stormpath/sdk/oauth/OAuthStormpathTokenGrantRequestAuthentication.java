package com.stormpath.sdk.oauth;

/**
 * This class represents a request for Stormpath to authenticate an Account and exchange its ID Site token for a valid
 * OAuth 2.0 access token. Using stormpath_token grant type.
 *
 * @since 1.1.0
 */
public interface OAuthStormpathTokenGrantRequestAuthentication extends OAuthGrantRequestAuthentication {
    String getToken();
}
