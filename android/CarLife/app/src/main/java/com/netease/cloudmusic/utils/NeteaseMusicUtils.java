package com.netease.cloudmusic.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.model.C1929i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.track.database.DataService;
import com.baidu.platform.comapi.map.MapController;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NeteaseMusicUtils {
    private static final int BITRATE_DEFAULT = 160;
    private static final int BITRATE_HIGH = 320;
    private static final int BITRATE_LOW = 96;
    private static final int LOAD_MORE_INTERVAL = 20;
    private static final String NETEASE_MUSIC_SERVER_URI = "http://api.music.163.com/openapi/baidu";
    private static final String REQUEST_PARAM_IMAGE = "param=200y200&quality=70";
    private static final int RESULTCODE_FAIL_NETEASE_SERVER = 500;
    private static final int RESULTCODE_OK_NETEASE_SERVER = 200;
    private static final String TAG = "NeteaseMusicUtils";
    private static final int TYPE_NETEASE_REQUEST_DJRADIO = 3;
    private static final int TYPE_NETEASE_REQUEST_DJRADIO_CHILD = 4;
    private static final int TYPE_NETEASE_REQUEST_PLAYLIST = 2;
    private static final int TYPE_NETEASE_REQUEST_TOPLIST = 1;
    private static boolean isDownloadSong = false;
    private static long mCurSongDownloadSize = 0;
    private static long mCurSongTotalSize = 0;

    public static native String getUrlParameters(String str, String str2);

    public static native void nativeInit(Context context);

    static {
        System.loadLibrary(MapController.POISON_LAYER_TAG);
        nativeInit(C1157a.a());
    }

    private static ArrayList<C1929i> parseTopList(String jsonResult) {
        if (jsonResult == null || jsonResult.length() == 0) {
            return null;
        }
        ArrayList<C1929i> list = new ArrayList();
        try {
            JSONArray jsonArray = new JSONObject(jsonResult).getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                C1929i tmp = new C1929i();
                tmp.f6053a = jsonObject.getString("name").trim();
                tmp.f6054b = jsonObject.getString("coverUrl").trim();
                tmp.f6055c = String.valueOf(jsonObject.getLong("id"));
                list.add(tmp);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return list;
        }
    }

    private static ArrayList<C1929i> parsePlayList(String jsonResult) {
        if (jsonResult == null || jsonResult.length() == 0) {
            return null;
        }
        ArrayList<C1929i> list = new ArrayList();
        try {
            JSONArray jsonArray = new JSONObject(jsonResult).getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                C1929i tmp = new C1929i();
                tmp.f6053a = jsonObject.getString("name").trim();
                tmp.f6054b = jsonObject.getString("coverUrl").trim();
                tmp.f6055c = String.valueOf(jsonObject.getLong("id"));
                list.add(tmp);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return list;
        }
    }

    private static ArrayList<MusicSongModel> parseTopMusicList(String jsonResult) {
        if (jsonResult == null || jsonResult.length() == 0) {
            return null;
        }
        ArrayList<MusicSongModel> list = new ArrayList();
        try {
            JSONArray jsonArray = new JSONObject(jsonResult).getJSONObject("data").getJSONArray("tracks");
            C1260i.b(TAG, "-----parseMusicList---length:" + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getBoolean("canPlay")) {
                    MusicSongModel tmp = new MusicSongModel();
                    tmp.f5910b = jsonObject.getString("name").trim();
                    tmp.f5914f = jsonObject.getString("albumArtistName").trim();
                    tmp.f5917i = jsonObject.getString("duration").trim();
                    tmp.f5909a = jsonObject.getString("id").trim();
                    tmp.f5915g = jsonObject.getString("coverUrl").trim();
                    tmp.f5911c = jsonObject.getString("albumName").trim();
                    list.add(tmp);
                }
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return list;
        }
    }

    private static ArrayList<MusicSongModel> parsePlayMusicList(String jsonResult) {
        if (jsonResult == null || jsonResult.length() == 0) {
            return null;
        }
        ArrayList<MusicSongModel> list = new ArrayList();
        try {
            JSONArray jsonArray = new JSONObject(jsonResult).getJSONArray("data");
            C1260i.b(TAG, "-----parseMusicList---length:" + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getBoolean("canPlay")) {
                    MusicSongModel tmp = new MusicSongModel();
                    tmp.f5910b = jsonObject.getString("name").trim();
                    tmp.f5914f = jsonObject.getString("albumArtistName").trim();
                    tmp.f5917i = jsonObject.getString("duration").trim();
                    tmp.f5909a = jsonObject.getString("id").trim();
                    tmp.f5915g = jsonObject.getString("coverUrl").trim();
                    tmp.f5911c = jsonObject.getString("albumName").trim();
                    list.add(tmp);
                }
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return list;
        }
    }

    private static boolean parseSearchMusicList(String jsonResult, List<MusicSongModel> list) {
        if (jsonResult == null || jsonResult.length() == 0) {
            return false;
        }
        try {
            JSONObject jsonObjectResult = new JSONObject(jsonResult);
            boolean hasMore = jsonObjectResult.getBoolean("hasMore");
            JSONArray jsonArray = jsonObjectResult.getJSONObject("data").getJSONArray("mediaList");
            C1260i.b(TAG, "-----parseMusicList---length:" + jsonArray.length() + ", totalCount:" + jsonObjectResult.getJSONObject("data").getInt("totalCount") + ", hasMore:" + hasMore);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getBoolean("canPlay")) {
                    MusicSongModel tmp = new MusicSongModel();
                    tmp.f5910b = jsonObject.getString("name").trim();
                    tmp.f5914f = jsonObject.getString("albumArtistName").trim();
                    tmp.f5917i = jsonObject.getString("duration").trim();
                    tmp.f5909a = jsonObject.getString("id").trim();
                    tmp.f5915g = jsonObject.getString("coverUrl").trim();
                    tmp.f5911c = jsonObject.getString("albumName").trim();
                    list.add(tmp);
                }
            }
            return hasMore;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static ArrayList<MusicSongModel> getToplistDetail(String id) {
        String requestUri = "/toplist/detail";
        String paramJson = "{\"id\":" + id + "}";
        try {
            HttpPost httpPost = new HttpPost(NETEASE_MUSIC_SERVER_URI);
            String tmpPa = getUrlParameters(requestUri, paramJson);
            C1260i.b(TAG, "-------HTPPRESPONSE-------tmpPa:" + tmpPa);
            List<NameValuePair> params = new ArrayList();
            params.add(new BasicNameValuePair("params", tmpPa));
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            if (200 == httpResponse.getStatusLine().getStatusCode()) {
                String responseResult = EntityUtils.toString(httpResponse.getEntity());
                C1260i.b(TAG, "-------HTPPRESPONSE-------result:" + responseResult);
                return parseTopMusicList(responseResult);
            }
            C1260i.e(TAG, "------get netease data Failed!!!---------");
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static ArrayList<MusicSongModel> getPlaylistDetail(String id) {
        String requestUri = "/playlist/tracks";
        String paramJson = "{\"limit\":20,\"offset\":0,\"id\":" + id + "}";
        try {
            HttpPost httpPost = new HttpPost(NETEASE_MUSIC_SERVER_URI);
            C1260i.b(TAG, "-------HTPPRESPONSE-------before");
            String tmpPa = getUrlParameters(requestUri, paramJson);
            C1260i.b(TAG, "-------HTPPRESPONSE-------tmpPa:" + tmpPa);
            List<NameValuePair> params = new ArrayList();
            params.add(new BasicNameValuePair("params", tmpPa));
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            int resultCode = httpResponse.getStatusLine().getStatusCode();
            C1260i.b(TAG, "-------HTPPRESPONSE-------resultCode:" + resultCode);
            if (200 == resultCode) {
                return parsePlayMusicList(EntityUtils.toString(httpResponse.getEntity()));
            }
            C1260i.e(TAG, "------get netease data Failed!!!---------");
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean getSearchMusicList(String singer, String songName, List<MusicSongModel> list, int getTimes) {
        boolean hasMore = true;
        String requestUri = "/search";
        JSONObject paramJson = new JSONObject();
        try {
            paramJson.put("keyword", singer + " " + songName);
            paramJson.put("type", 1);
            paramJson.put(DataService.EXTRA_LIMIT, 20);
            paramJson.put("offset", getTimes * 20);
            try {
                HttpPost httpPost = new HttpPost(NETEASE_MUSIC_SERVER_URI);
                String tmpPa = getUrlParameters(requestUri, paramJson.toString());
                C1260i.b(TAG, "-------HTPPRESPONSE-------params:" + paramJson.toString());
                List<NameValuePair> params = new ArrayList();
                params.add(new BasicNameValuePair("params", tmpPa));
                httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
                if (200 == httpResponse.getStatusLine().getStatusCode()) {
                    String responseResult = EntityUtils.toString(httpResponse.getEntity());
                    hasMore = parseSearchMusicList(responseResult, list);
                    C1260i.b(TAG, "-------HTPPRESPONSE-------result:" + responseResult);
                } else {
                    C1260i.e(TAG, "------get netease data Failed!!!---------");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return hasMore;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    private static ArrayList<C1929i> getThemeList(String requestUri, String paramJson, int type) {
        if (TextUtils.isEmpty(paramJson) || TextUtils.isEmpty(requestUri)) {
            return null;
        }
        try {
            HttpPost httpPost = new HttpPost(NETEASE_MUSIC_SERVER_URI);
            C1260i.b(TAG, "-------HTPPRESPONSE-------before");
            String tmpPa = getUrlParameters(requestUri, paramJson);
            C1260i.b(TAG, "-------HTPPRESPONSE-------tmpPa:" + tmpPa);
            List<NameValuePair> params = new ArrayList();
            params.add(new BasicNameValuePair("params", tmpPa));
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            int resultCode = httpResponse.getStatusLine().getStatusCode();
            C1260i.b(TAG, "-------HTPPRESPONSE-------resultCode:" + resultCode);
            if (200 == resultCode) {
                String responseResult = EntityUtils.toString(httpResponse.getEntity());
                switch (type) {
                    case 1:
                        return parseTopList(responseResult);
                    case 2:
                        return parsePlayList(responseResult);
                    default:
                        return null;
                }
            } else if (500 != resultCode) {
                return null;
            } else {
                C1260i.e(TAG, "------get netease data Failed!!!---------");
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static long getCurSongDownloadSize() {
        return mCurSongDownloadSize;
    }

    public static long getCurSongTotalSize() {
        return mCurSongTotalSize;
    }

    public static void abortDownloadSong() {
        isDownloadSong = false;
    }

    public static String getSimpleSongUrl(String songId) {
        if (songId == null || songId.length() == 0) {
            return null;
        }
        String paramJson = "{\"songId\":\"" + songId + "\",\"bitrate\":" + 96 + "}";
        C1260i.b(TAG, "---------------paramJson:" + paramJson);
        String result = getUrlParameters("/url", paramJson);
        List<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("params", result));
        result = "http://api.music.163.com/openapi/baidu?" + URLEncodedUtils.format(params, "UTF-8");
        C1260i.b(TAG, "-------HTPPRESPONSE-------tmpPa:" + result);
        return result;
    }

    public static ArrayList<C1929i> getPlayList() {
        return getThemeList("/playlist/oftag", "{\"name\":华语,\"order\":hot|new,\"limit\":20,\"offset\":0}", 2);
    }

    public static ArrayList<C1929i> getTopList() {
        return getThemeList("/toplist", "{}", 1);
    }

    public static Bitmap getImage(String path) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(path + "?" + REQUEST_PARAM_IMAGE).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                C1260i.b(TAG, "-------getImage OK-------");
                InputStream inStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inStream);
                inStream.close();
                return bitmap;
            }
            C1260i.e(TAG, "------get netease data Failed!!!---------");
            return null;
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMusicUrlById(String songId) {
        try {
            return "http://api.music.163.com/openapi/baidu?params=" + URLEncoder.encode(getUrlParameters("/url", "{\"songId\":\"" + songId + "\",\"bitrate\":" + 96 + "}"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
