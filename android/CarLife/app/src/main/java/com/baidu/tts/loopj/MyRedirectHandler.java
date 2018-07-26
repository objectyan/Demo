package com.baidu.tts.loopj;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class MyRedirectHandler extends DefaultRedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final boolean enableRedirects;

    public MyRedirectHandler(boolean allowRedirects) {
        this.enableRedirects = allowRedirects;
    }

    public boolean isRedirectRequested(HttpResponse response, HttpContext context) {
        if (!this.enableRedirects) {
            return false;
        }
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        switch (response.getStatusLine().getStatusCode()) {
            case 301:
            case 302:
            case 303:
            case 307:
                return true;
            default:
                return false;
        }
    }

    public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        Header firstHeader = response.getFirstHeader("location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + response.getStatusLine() + " but no location header");
        }
        String replaceAll = firstHeader.getValue().replaceAll(" ", "%20");
        try {
            URI uri;
            URI uri2 = new URI(replaceAll);
            HttpParams params = response.getParams();
            if (uri2.isAbsolute()) {
                uri = uri2;
            } else if (params.isParameterTrue("http.protocol.reject-relative-redirect")) {
                throw new ProtocolException("Relative redirect location '" + uri2 + "' not allowed");
            } else {
                HttpHost httpHost = (HttpHost) context.getAttribute("http.target_host");
                if (httpHost == null) {
                    throw new IllegalStateException("Target host not available in the HTTP context");
                }
                try {
                    uri = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) context.getAttribute("http.request")).getRequestLine().getUri()), httpHost, true), uri2);
                } catch (Throwable e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            }
            if (params.isParameterFalse("http.protocol.allow-circular-redirects")) {
                RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute("http.protocol.redirect-locations");
                if (redirectLocations == null) {
                    redirectLocations = new RedirectLocations();
                    context.setAttribute("http.protocol.redirect-locations", redirectLocations);
                }
                if (uri.getFragment() != null) {
                    try {
                        uri2 = URIUtils.rewriteURI(uri, new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                    } catch (Throwable e2) {
                        throw new ProtocolException(e2.getMessage(), e2);
                    }
                }
                uri2 = uri;
                if (redirectLocations.contains(uri2)) {
                    throw new CircularRedirectException("Circular redirect to '" + uri2 + "'");
                }
                redirectLocations.add(uri2);
            }
            return uri;
        } catch (Throwable e22) {
            throw new ProtocolException("Invalid redirect URI: " + replaceAll, e22);
        }
    }
}
