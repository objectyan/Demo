package com.baidu.sapi2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ProgressBar;
import com.baidu.carlife.C0965R;

public class SapiWebViewUtil {
    public static void addCustomView(Context context, SapiWebView sapiWebView) {
        setProgressBar(context, sapiWebView);
        setNoNetworkView(context, sapiWebView);
        setTimeoutView(context, sapiWebView);
    }

    public static void setNoNetworkView(final Context context, SapiWebView sapiWebView) {
        View noNetworkView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.layout_sapi_network_unavailable, null);
        noNetworkView.findViewById(C0965R.id.btn_network_settings).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.settings.SETTINGS");
                intent.setFlags(270532608);
                context.startActivity(intent);
            }
        });
        sapiWebView.setNoNetworkView(noNetworkView);
    }

    public static void setTimeoutView(Context context, final SapiWebView sapiWebView) {
        final View timeoutView = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0965R.layout.layout_sapi_loading_timeout, null);
        timeoutView.findViewById(C0965R.id.btn_retry).setOnClickListener(new OnClickListener() {

            /* renamed from: com.baidu.sapi2.SapiWebViewUtil$2$1 */
            class C48751 implements Runnable {
                C48751() {
                }

                public void run() {
                    timeoutView.setVisibility(4);
                    sapiWebView.loadUrl(sapiWebView.getUrl());
                }
            }

            public void onClick(View v) {
                sapiWebView.post(new C48751());
            }
        });
        sapiWebView.setTimeoutView(timeoutView);
    }

    public static void setProgressBar(Context context, SapiWebView sapiWebView) {
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new LayoutParams(-1, 4, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
