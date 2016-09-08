package com.stormpath.sdk.impl.oauth

import com.stormpath.sdk.impl.ds.InternalDataStore
import com.stormpath.sdk.impl.resource.StringProperty
import org.testng.annotations.Test

import static org.easymock.EasyMock.createStrictMock
import static org.testng.Assert.assertEquals
import static org.testng.Assert.assertTrue

/**
 * @since 1.1.0
 */
class DefaultCreateOAuthStormpathTokenGrantAuthenticationAttemptTest {

    @Test
    void testGetPropertyDescriptors() {

        def defaultCreateGrantAuthAttempt = new DefaultOAuthStormpathTokenGrantAuthenticationAttempt(createStrictMock(InternalDataStore))

        def propertyDescriptors = defaultCreateGrantAuthAttempt.getPropertyDescriptors()

        assertEquals(propertyDescriptors.size(), 2)

        assertTrue(propertyDescriptors.get("token") instanceof StringProperty)
        assertTrue(propertyDescriptors.get("grant_type") instanceof StringProperty)
    }

    @Test
    void testAuthentication() {

        def properties = [
                token : "VVVNNN",
                grant_type  : "stormpath_token"
        ]

        def internalDataStore = createStrictMock(InternalDataStore)

        def attempt = new DefaultOAuthStormpathTokenGrantAuthenticationAttempt(internalDataStore, properties)

        assertEquals(attempt.getToken(), properties.token)
        assertEquals(attempt.getGrantType(), properties.grant_type)
    }
}
