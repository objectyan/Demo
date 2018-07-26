package com.baidu.tts.loopj;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private T handler = null;

    public abstract void onFailure(int i, Header[] headerArr, T t);

    public abstract void onSuccess(int i, Header[] headerArr, T t);

    public SaxAsyncHttpResponseHandler(T t) {
        if (t == null) {
            throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
        }
        this.handler = t;
    }

    protected byte[] getResponseData(HttpEntity entity) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable e;
        if (entity != null) {
            InputStream content = entity.getContent();
            if (content != null) {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this.handler);
                    inputStreamReader = new InputStreamReader(content, getCharset());
                    try {
                        xMLReader.parse(new InputSource(inputStreamReader));
                        AsyncHttpClient.silentCloseInputStream(content);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (SAXException e3) {
                        e = e3;
                        try {
                            AsyncHttpClient.log.mo3897e(LOG_TAG, "getResponseData exception", e);
                            AsyncHttpClient.silentCloseInputStream(content);
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e4) {
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            AsyncHttpClient.silentCloseInputStream(content);
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (ParserConfigurationException e6) {
                        e = e6;
                        AsyncHttpClient.log.mo3897e(LOG_TAG, "getResponseData exception", e);
                        AsyncHttpClient.silentCloseInputStream(content);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        return null;
                    }
                } catch (SAXException e8) {
                    e = e8;
                    inputStreamReader = null;
                    AsyncHttpClient.log.mo3897e(LOG_TAG, "getResponseData exception", e);
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return null;
                } catch (ParserConfigurationException e9) {
                    e = e9;
                    inputStreamReader = null;
                    AsyncHttpClient.log.mo3897e(LOG_TAG, "getResponseData exception", e);
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    e = th2;
                    inputStreamReader = null;
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw e;
                }
            }
        }
        return null;
    }

    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        onSuccess(statusCode, headers, this.handler);
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        onFailure(statusCode, headers, this.handler);
    }
}
