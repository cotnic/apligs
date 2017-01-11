package com.example.nacepc.apligs;

import android.net.Uri;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by NACEPC on 1/9/2017.
 */

public class Connections {

    public static String getConnection(String URL) throws IOException {
        final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
        URL = Uri.encode(URL, ALLOWED_URI_CHARS);
        HttpClient hc = new DefaultHttpClient();
        HttpGet httpOffers = new HttpGet(URL.replace(" ", "%20"));
        HttpResponse httpResponse = hc.execute(httpOffers);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }
    public static String postConnection(String URL, JSONObject jsonObjectj) throws IOException {
        // To encode URL, so it works over POST connection also with spaces and things like this
        final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'% ";
        URL = Uri.encode(URL, ALLOWED_URI_CHARS);
        HttpClient hc = new DefaultHttpClient();
        HttpPost httpPostRequest = new HttpPost(URL);
        StringEntity se = new StringEntity( jsonObjectj.toString());
        httpPostRequest.setHeader("Content-Type", "application/json");
        httpPostRequest.setHeader("Accept", "application/json");
        httpPostRequest.setEntity(se);
        HttpResponse httpResponse = hc.execute(httpPostRequest);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }

}
