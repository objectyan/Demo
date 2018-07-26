package com.baidu.mobstat;

import java.io.File;
import java.security.MessageDigest;

public class cz {
    /* renamed from: a */
    public static String m15651a(byte[] bArr) {
        try {
            return cy.m15649b(MessageDigest.getInstance("SHA-256"), bArr);
        } catch (Throwable e) {
            db.m15662b(e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m15650a(File file) {
        try {
            return cy.m15648b(MessageDigest.getInstance("SHA-256"), file);
        } catch (Throwable e) {
            db.m15662b(e);
            return "";
        }
    }
}
