package com.baidu.ufosdk.p251e;

/* compiled from: HttpURLConnSender */
/* renamed from: com.baidu.ufosdk.e.b */
public final class C5181b {
    /* renamed from: a */
    private static String f21401a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.lang.String m17578a(java.lang.String r8, java.lang.String r9) {
        /*
        r2 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r1 = "params is ";
        r0.<init>(r1);	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0 = r0.append(r9);	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0 = r0.toString();	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        com.baidu.ufosdk.util.C5210c.m17734b(r0);	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0.<init>(r8);	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x016b, all -> 0x012e }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 1;
        r0.setDoInput(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = "User-Agent";
        r3 = f21401a;	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        if (r3 != 0) goto L_0x0068;
    L_0x003c:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r4 = "UfoSDK/1.7.13 (";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r4 = com.baidu.ufosdk.p248b.C5171d.m17558a();	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r4 = com.baidu.ufosdk.p248b.C5171d.m17561c();	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r4 = ")";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        f21401a = r3;	 Catch:{ Exception -> 0x0171, all -> 0x014c }
    L_0x0068:
        r3 = f21401a;	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = "Accept-Charset";
        r3 = "utf-8";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = "contentType";
        r3 = "utf-8";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r6 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r1 = r0.getOutputStream();	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0171, all -> 0x014c }
        r6.writeBytes(r9);	 Catch:{ Exception -> 0x0178, all -> 0x0152 }
        r6.flush();	 Catch:{ Exception -> 0x0178, all -> 0x0152 }
        r6.close();	 Catch:{ Exception -> 0x0178, all -> 0x0152 }
        r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0178, all -> 0x0152 }
        r3.<init>();	 Catch:{ Exception -> 0x0178, all -> 0x0152 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x017f, all -> 0x0152 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r4) goto L_0x0199;
    L_0x00a8:
        r4 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x017f, all -> 0x0152 }
        r1 = r0.getInputStream();	 Catch:{ Exception -> 0x017f, all -> 0x0152 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x017f, all -> 0x0152 }
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0186, all -> 0x0157 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0157 }
    L_0x00b6:
        r1 = r5.readLine();	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        if (r1 != 0) goto L_0x00f6;
    L_0x00bc:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r2 = "httpURLConnSender response: ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r2 = r3.toString();	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        com.baidu.ufosdk.util.C5210c.m17732a(r1);	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r4.close();	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r5.close();	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r2 = r4;
        r4 = r5;
    L_0x00db:
        r0.disconnect();	 Catch:{ Exception -> 0x0190, all -> 0x0162 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0162 }
        r6.close();	 Catch:{ Exception -> 0x0129 }
        if (r0 == 0) goto L_0x00ea;
    L_0x00e7:
        r0.disconnect();	 Catch:{ Exception -> 0x0129 }
    L_0x00ea:
        if (r4 == 0) goto L_0x00ef;
    L_0x00ec:
        r4.close();	 Catch:{ Exception -> 0x0129 }
    L_0x00ef:
        if (r2 == 0) goto L_0x00f4;
    L_0x00f1:
        r2.close();	 Catch:{ Exception -> 0x0129 }
    L_0x00f4:
        r0 = r1;
    L_0x00f5:
        return r0;
    L_0x00f6:
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Exception -> 0x0101, all -> 0x015d }
        goto L_0x00b6;
    L_0x0101:
        r1 = move-exception;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r5;
        r5 = r6;
    L_0x0108:
        r0.printStackTrace();	 Catch:{ all -> 0x0167 }
        r0 = r1.toString();	 Catch:{ all -> 0x0167 }
        if (r5 == 0) goto L_0x0114;
    L_0x0111:
        r5.close();	 Catch:{ Exception -> 0x0124 }
    L_0x0114:
        if (r4 == 0) goto L_0x0119;
    L_0x0116:
        r4.disconnect();	 Catch:{ Exception -> 0x0124 }
    L_0x0119:
        if (r3 == 0) goto L_0x011e;
    L_0x011b:
        r3.close();	 Catch:{ Exception -> 0x0124 }
    L_0x011e:
        if (r2 == 0) goto L_0x00f5;
    L_0x0120:
        r2.close();	 Catch:{ Exception -> 0x0124 }
        goto L_0x00f5;
    L_0x0124:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00f5;
    L_0x0129:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00f4;
    L_0x012e:
        r0 = move-exception;
        r5 = r2;
        r4 = r2;
        r6 = r2;
    L_0x0132:
        if (r6 == 0) goto L_0x0137;
    L_0x0134:
        r6.close();	 Catch:{ Exception -> 0x0147 }
    L_0x0137:
        if (r4 == 0) goto L_0x013c;
    L_0x0139:
        r4.disconnect();	 Catch:{ Exception -> 0x0147 }
    L_0x013c:
        if (r5 == 0) goto L_0x0141;
    L_0x013e:
        r5.close();	 Catch:{ Exception -> 0x0147 }
    L_0x0141:
        if (r2 == 0) goto L_0x0146;
    L_0x0143:
        r2.close();	 Catch:{ Exception -> 0x0147 }
    L_0x0146:
        throw r0;
    L_0x0147:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0146;
    L_0x014c:
        r1 = move-exception;
        r5 = r2;
        r4 = r0;
        r6 = r2;
        r0 = r1;
        goto L_0x0132;
    L_0x0152:
        r1 = move-exception;
        r5 = r2;
        r4 = r0;
        r0 = r1;
        goto L_0x0132;
    L_0x0157:
        r1 = move-exception;
        r5 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        goto L_0x0132;
    L_0x015d:
        r1 = move-exception;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        goto L_0x0132;
    L_0x0162:
        r1 = move-exception;
        r5 = r4;
        r4 = r0;
        r0 = r1;
        goto L_0x0132;
    L_0x0167:
        r0 = move-exception;
        r6 = r5;
        r5 = r3;
        goto L_0x0132;
    L_0x016b:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x0108;
    L_0x0171:
        r1 = move-exception;
        r3 = r2;
        r4 = r0;
        r5 = r2;
        r0 = r1;
        r1 = r2;
        goto L_0x0108;
    L_0x0178:
        r1 = move-exception;
        r3 = r2;
        r4 = r0;
        r5 = r6;
        r0 = r1;
        r1 = r2;
        goto L_0x0108;
    L_0x017f:
        r1 = move-exception;
        r4 = r0;
        r5 = r6;
        r0 = r1;
        r1 = r3;
        r3 = r2;
        goto L_0x0108;
    L_0x0186:
        r1 = move-exception;
        r5 = r6;
        r7 = r3;
        r3 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x0108;
    L_0x0190:
        r1 = move-exception;
        r5 = r6;
        r7 = r3;
        r3 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x0108;
    L_0x0199:
        r4 = r2;
        goto L_0x00db;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ufosdk.e.b.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
