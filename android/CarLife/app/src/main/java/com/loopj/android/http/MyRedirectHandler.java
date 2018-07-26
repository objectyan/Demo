package com.loopj.android.http;

import cz.msebera.android.httpclient.C6033u;
import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;
import cz.msebera.android.httpclient.C6592r;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.p157l.C3062j;
import cz.msebera.android.httpclient.p158b.C6244e;
import cz.msebera.android.httpclient.p158b.p167g.C2996i;
import cz.msebera.android.httpclient.p173i.p175b.C3070v;
import cz.msebera.android.httpclient.p173i.p175b.ar;
import cz.msebera.android.httpclient.p185n.C6198g;
import java.net.URI;
import java.net.URISyntaxException;

class MyRedirectHandler extends C3070v {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final boolean enableRedirects;

    public MyRedirectHandler(boolean allowRedirects) {
        this.enableRedirects = allowRedirects;
    }

    public boolean isRedirectRequested(C6228x response, C6198g context) {
        if (!this.enableRedirects) {
            return false;
        }
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        switch (response.mo5067a().mo5266b()) {
            case 301:
            case 302:
            case 303:
            case 307:
                return true;
            default:
                return false;
        }
    }

    public URI getLocationURI(C6228x response, C6198g context) throws aj {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        C6327f locationHeader = response.getFirstHeader("location");
        if (locationHeader == null) {
            throw new aj("Received redirect response " + response.mo5067a() + " but no location header");
        }
        String location = locationHeader.mo5248d().replaceAll(" ", "%20");
        try {
            URI uri = new URI(location);
            C3062j params = response.getParams();
            if (!uri.isAbsolute()) {
                if (params.c("http.protocol.reject-relative-redirect")) {
                    throw new aj("Relative redirect location '" + uri + "' not allowed");
                }
                C6592r target = (C6592r) context.mo5023a("http.target_host");
                if (target == null) {
                    throw new IllegalStateException("Target host not available in the HTTP context");
                }
                try {
                    uri = C2996i.a(C2996i.a(new URI(((C6033u) context.mo5023a("http.request")).getRequestLine().mo5264c()), target, true), uri);
                } catch (URISyntaxException ex) {
                    throw new aj(ex.getMessage(), ex);
                }
            }
            if (params.d("http.protocol.allow-circular-redirects")) {
                URI redirectURI;
                ar redirectLocations = (ar) context.mo5023a("http.protocol.redirect-locations");
                if (redirectLocations == null) {
                    redirectLocations = new ar();
                    context.mo5024a("http.protocol.redirect-locations", redirectLocations);
                }
                if (uri.getFragment() != null) {
                    try {
                        redirectURI = C2996i.a(uri, new C6592r(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                    } catch (URISyntaxException ex2) {
                        throw new aj(ex2.getMessage(), ex2);
                    }
                }
                redirectURI = uri;
                if (redirectLocations.m23397a(redirectURI)) {
                    throw new C6244e("Circular redirect to '" + redirectURI + "'");
                }
                redirectLocations.m23399b(redirectURI);
            }
            return uri;
        } catch (URISyntaxException ex22) {
            throw new aj("Invalid redirect URI: " + location, ex22);
        }
    }
}
