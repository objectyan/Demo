package com.baidu.carlife.view;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.R;

public class SignalImageView extends ImageView {
    /* renamed from: a */
    private TelephonyManager f7221a;
    /* renamed from: b */
    private C2231a f7222b;

    /* renamed from: com.baidu.carlife.view.SignalImageView$a */
    private class C2231a extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ SignalImageView f7215a;
        /* renamed from: b */
        private final int f7216b;
        /* renamed from: c */
        private final int f7217c;
        /* renamed from: d */
        private final int f7218d;
        /* renamed from: e */
        private final int f7219e;
        /* renamed from: f */
        private final int f7220f;

        private C2231a(SignalImageView signalImageView) {
            this.f7215a = signalImageView;
            this.f7216b = 0;
            this.f7217c = 1;
            this.f7218d = 2;
            this.f7219e = 3;
            this.f7220f = 4;
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (this.f7215a.f7221a.getSimState() == 5) {
                int bin;
                if (signalStrength.isGsm()) {
                    int asu = signalStrength.getGsmSignalStrength();
                    if (asu < 0 || asu >= 99) {
                        bin = 0;
                    } else if (asu >= 16) {
                        bin = 4;
                    } else if (asu >= 8) {
                        bin = 3;
                    } else if (asu >= 4) {
                        bin = 2;
                    } else {
                        bin = 1;
                    }
                } else {
                    int dBm = signalStrength.getCdmaDbm();
                    if (dBm >= -75) {
                        bin = 4;
                    } else if (dBm >= -85) {
                        bin = 3;
                    } else if (dBm >= -95) {
                        bin = 2;
                    } else if (dBm >= -100) {
                        bin = 1;
                    } else {
                        bin = 0;
                    }
                }
                m8466a(bin);
                return;
            }
            this.f7215a.setImageResource(R.drawable.signal_cellular_no_sim);
        }

        /* renamed from: a */
        private void m8466a(int level) {
            switch (level) {
                case 0:
                    this.f7215a.setImageResource(R.drawable.signal_cellular_0);
                    return;
                case 1:
                    this.f7215a.setImageResource(R.drawable.signal_cellular_1);
                    return;
                case 2:
                    this.f7215a.setImageResource(R.drawable.signal_cellular_2);
                    return;
                case 3:
                    this.f7215a.setImageResource(R.drawable.signal_cellular_3);
                    return;
                case 4:
                    this.f7215a.setImageResource(R.drawable.signal_cellular_4);
                    return;
                default:
                    return;
            }
        }
    }

    public SignalImageView(Context context) {
        super(context);
    }

    public SignalImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignalImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7221a = (TelephonyManager) context.getSystemService("phone");
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7222b = new C2231a();
        this.f7221a.listen(this.f7222b, 256);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7221a.listen(this.f7222b, 0);
    }
}
