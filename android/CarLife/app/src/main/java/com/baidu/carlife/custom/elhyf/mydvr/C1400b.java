package com.baidu.carlife.custom.elhyf.mydvr;

import android.graphics.Bitmap;

/* compiled from: ReceivedFileSpeech */
/* renamed from: com.baidu.carlife.custom.elhyf.mydvr.b */
public class C1400b implements Comparable<C1400b> {
    /* renamed from: a */
    private Bitmap f4106a;
    /* renamed from: b */
    private String f4107b;
    /* renamed from: c */
    private String f4108c;
    /* renamed from: d */
    private String f4109d;
    /* renamed from: e */
    private String f4110e;
    /* renamed from: f */
    private String f4111f;
    /* renamed from: g */
    private C1399a f4112g;

    /* compiled from: ReceivedFileSpeech */
    /* renamed from: com.baidu.carlife.custom.elhyf.mydvr.b$a */
    public enum C1399a {
        Front_Camera,
        Back_Camera
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m5159a((C1400b) obj);
    }

    /* renamed from: a */
    public Bitmap m5160a() {
        return this.f4106a;
    }

    /* renamed from: b */
    public String m5164b() {
        return this.f4107b;
    }

    /* renamed from: c */
    public String m5166c() {
        return this.f4108c;
    }

    /* renamed from: d */
    public String m5168d() {
        return this.f4110e;
    }

    /* renamed from: e */
    public String m5170e() {
        return this.f4111f;
    }

    /* renamed from: f */
    public String m5172f() {
        return this.f4109d;
    }

    /* renamed from: g */
    public C1399a m5173g() {
        return this.f4112g;
    }

    /* renamed from: a */
    public void m5161a(Bitmap bitmap) {
        this.f4106a = bitmap;
    }

    /* renamed from: a */
    public void m5163a(String name) {
        this.f4107b = name;
    }

    /* renamed from: b */
    public void m5165b(String date) {
        this.f4108c = date;
    }

    /* renamed from: c */
    public void m5167c(String size) {
        this.f4110e = size;
    }

    /* renamed from: d */
    public void m5169d(String filePath) {
        this.f4111f = filePath;
    }

    /* renamed from: e */
    public void m5171e(String hour) {
        this.f4109d = hour;
    }

    /* renamed from: a */
    public void m5162a(C1399a cameraType) {
        this.f4112g = cameraType;
    }

    /* renamed from: a */
    public int m5159a(C1400b receivedFileSpeech) {
        int result = receivedFileSpeech.m5166c().compareTo(m5166c());
        if (result == 0) {
            return receivedFileSpeech.m5172f().compareTo(m5172f());
        }
        return result;
    }
}
