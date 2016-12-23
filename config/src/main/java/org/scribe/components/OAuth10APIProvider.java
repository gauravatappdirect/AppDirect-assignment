package org.scribe.components;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Created by gaurav on 24/12/16.
 */
public class OAuth10APIProvider extends DefaultApi10a {
    public String getRequestTokenEndpoint() {
        return null;
    }

    public String getAccessTokenEndpoint() {
        return null;
    }

    public String getAuthorizationUrl(Token requestToken) {
        return null;
    }
}
