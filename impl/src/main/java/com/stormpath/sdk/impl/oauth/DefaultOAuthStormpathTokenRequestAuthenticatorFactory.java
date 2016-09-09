package com.stormpath.sdk.impl.oauth;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.impl.application.DefaultApplication;
import com.stormpath.sdk.oauth.OAuthStormpathTokenGrantRequestAuthenticator;
import com.stormpath.sdk.oauth.OAuthStormpathTokenRequestAuthenticatorFactory;

/**
 * @since 1.1.0
 */
public class DefaultOAuthStormpathTokenRequestAuthenticatorFactory implements OAuthStormpathTokenRequestAuthenticatorFactory {
    @Override
    public OAuthStormpathTokenGrantRequestAuthenticator forApplication(Application application) {
        return ((DefaultApplication) application).createStormpathTokenGrantAuthenticator();
    }
}
