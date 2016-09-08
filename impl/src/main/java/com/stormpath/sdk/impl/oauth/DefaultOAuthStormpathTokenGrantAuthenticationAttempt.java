package com.stormpath.sdk.impl.oauth;

import com.stormpath.sdk.impl.ds.InternalDataStore;
import com.stormpath.sdk.impl.resource.AbstractResource;
import com.stormpath.sdk.impl.resource.Property;
import com.stormpath.sdk.impl.resource.StringProperty;

import java.util.Map;

/**
 * @since 1.1.0
 */
public class DefaultOAuthStormpathTokenGrantAuthenticationAttempt extends AbstractResource implements OAuthStormpathTokenGrantAuthenticationAttempt {

    static final StringProperty GRANT_TYPE = new StringProperty("grant_type");
    static final StringProperty TOKEN = new StringProperty("token");

    private static final Map<String, Property> PROPERTY_DESCRIPTORS = createPropertyDescriptorMap(GRANT_TYPE, TOKEN);

    public DefaultOAuthStormpathTokenGrantAuthenticationAttempt(InternalDataStore dataStore) {
        super(dataStore);
    }

    public DefaultOAuthStormpathTokenGrantAuthenticationAttempt(InternalDataStore dataStore, Map<String, Object> properties) {
        super(dataStore, properties);
    }

    @Override
    public void setGrantType(String grantType) {
        setProperty(GRANT_TYPE, grantType);
    }

    @Override
    public void setToken(String token) {
        setProperty(TOKEN, token);
    }

    public String getGrantType() {
        return getString(GRANT_TYPE);
    }

    public String getToken() {
        return getString(TOKEN);
    }

    @Override
    public Map<String, Property> getPropertyDescriptors() {
        return PROPERTY_DESCRIPTORS;
    }
}
