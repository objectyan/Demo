package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackInputActivity */
final class cb extends AsyncTask {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21598a;

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m17717a();
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object... objArr) {
    }

    cb(FeedbackInputActivity feedbackInputActivity) {
        this.f21598a = feedbackInputActivity;
    }

    protected final void onPreExecute() {
        if (this.f21598a.getCurrentFocus() != null && this.f21598a.getCurrentFocus().getWindowToken() != null) {
            ((InputMethodManager) this.f21598a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21598a.getCurrentFocus().getWindowToken(), 2);
        }
    }

    /* renamed from: a */
    private static Integer m17717a() {
        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (this.f21598a.au) {
            Intent intent = new Intent(this.f21598a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", C5167a.f21362h);
            this.f21598a.startActivity(intent);
            this.f21598a.finish();
        } else {
            this.f21598a.finish();
        }
        try {
            this.f21598a.overridePendingTransition(C5216i.m17758a(this.f21598a.getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(this.f21598a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
        }
    }
}
