package com.baidu.carlife.logic;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.fragment.WebViewFragment;

/* compiled from: SpannableStringHelper */
/* renamed from: com.baidu.carlife.logic.u */
public class C1877u {

    /* compiled from: SpannableStringHelper */
    /* renamed from: com.baidu.carlife.logic.u$a */
    public interface C1873a {
        /* renamed from: a */
        void mo1698a();
    }

    /* compiled from: SpannableStringHelper */
    /* renamed from: com.baidu.carlife.logic.u$1 */
    static class C18741 implements C1873a {
        C18741() {
        }

        /* renamed from: a */
        public void mo1698a() {
            C1877u.m7170b(C1157a.m3876a().getString(C0965R.string.service_terms_title), "file:///android_asset/carlifeDisclaimer.html");
        }
    }

    /* compiled from: SpannableStringHelper */
    /* renamed from: com.baidu.carlife.logic.u$2 */
    static class C18752 implements C1873a {
        C18752() {
        }

        /* renamed from: a */
        public void mo1698a() {
            C1877u.m7170b(C1157a.m3876a().getString(C0965R.string.privacy_policy), "https://www.baidu.com/duty/wise/wise_secretright.html");
        }
    }

    /* renamed from: a */
    public static SpannableString m7165a(String textContent) {
        SpannableString spannableString = new SpannableString(textContent);
        C1877u.m7166a(spannableString);
        return spannableString;
    }

    /* renamed from: a */
    private static void m7166a(SpannableString spannableString) {
        C1870s serviceRange = new C1870s(17, 23);
        C1877u.m7167a(spannableString, serviceRange, Color.parseColor("#FF000000"));
        C1877u.m7168a(spannableString, serviceRange, new C18741());
        C1870s privacyRange = new C1870s(24, 30);
        C1877u.m7167a(spannableString, privacyRange, Color.parseColor("#FF000000"));
        C1877u.m7168a(spannableString, privacyRange, new C18752());
    }

    /* renamed from: b */
    private static void m7170b(String title, String url) {
        Bundle bundle = new Bundle();
        bundle.putString(WebViewFragment.f4861a, title);
        bundle.putString(WebViewFragment.f4862b, url);
        C1328h.m4757a().showFragment(517, bundle);
    }

    /* renamed from: a */
    private static void m7167a(SpannableString spannableString, C1870s range, int color) {
        spannableString.setSpan(new ForegroundColorSpan(color), range.m7131a(), range.m7132b(), 33);
    }

    /* renamed from: a */
    private static void m7168a(SpannableString spannableString, C1870s range, final C1873a listener) {
        spannableString.setSpan(new C1853n() {
            public void onClick(View widget) {
                if (listener != null) {
                    listener.mo1698a();
                }
            }
        }, range.m7131a(), range.m7132b(), 33);
    }
}
