package com.indooratlas.android.sdk.resources;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class IAFloorPlan implements Parcelable {
    public static final Creator CREATOR = new C60181();
    /* renamed from: a */
    private String f24606a;
    /* renamed from: b */
    private String f24607b;
    /* renamed from: c */
    private String f24608c;
    /* renamed from: d */
    private int f24609d;
    /* renamed from: e */
    private int f24610e;
    /* renamed from: f */
    private float f24611f;
    /* renamed from: g */
    private float f24612g;
    /* renamed from: h */
    private int f24613h;
    /* renamed from: i */
    private double[] f24614i;
    /* renamed from: j */
    private double[] f24615j;
    /* renamed from: k */
    private boolean f24616k = false;
    /* renamed from: l */
    private Matrix f24617l;
    /* renamed from: m */
    private Matrix f24618m;
    /* renamed from: n */
    private float f24619n;
    /* renamed from: o */
    private float f24620o;
    /* renamed from: p */
    private double f24621p;
    /* renamed from: q */
    private IALatLng f24622q;
    /* renamed from: r */
    private IALatLng f24623r;
    /* renamed from: s */
    private IALatLng f24624s;
    /* renamed from: t */
    private IALatLng f24625t;

    /* renamed from: com.indooratlas.android.sdk.resources.IAFloorPlan$1 */
    static class C60181 implements Creator {
        C60181() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IAFloorPlan[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IAFloorPlan(parcel);
        }
    }

    public IAFloorPlan(String id, String name, String url, int bitmapWidth, int bitmapHeight, int floorLevel, double[] pixelToWgs, double[] wgsToPixel) {
        this.f24606a = id;
        this.f24607b = name;
        this.f24608c = url;
        this.f24609d = bitmapWidth;
        this.f24610e = bitmapHeight;
        this.f24613h = floorLevel;
        this.f24614i = pixelToWgs;
        this.f24615j = wgsToPixel;
    }

    public int describeContents() {
        return 0;
    }

    protected IAFloorPlan(Parcel in) {
        this.f24606a = in.readString();
        this.f24607b = in.readString();
        this.f24608c = in.readString();
        this.f24609d = in.readInt();
        this.f24610e = in.readInt();
        this.f24613h = in.readInt();
        this.f24614i = in.createDoubleArray();
        this.f24615j = in.createDoubleArray();
    }

    public void writeToParcel(Parcel out, int i) {
        out.writeString(this.f24606a);
        out.writeString(this.f24607b);
        out.writeString(this.f24608c);
        out.writeInt(this.f24609d);
        out.writeInt(this.f24610e);
        out.writeInt(this.f24613h);
        out.writeDoubleArray(this.f24614i);
        out.writeDoubleArray(this.f24615j);
    }

    public String getId() {
        return this.f24606a;
    }

    public String getName() {
        return this.f24607b;
    }

    public String getUrl() {
        return this.f24608c;
    }

    public int getBitmapWidth() {
        return this.f24609d;
    }

    public int getBitmapHeight() {
        return this.f24610e;
    }

    public int getFloorLevel() {
        return this.f24613h;
    }

    public Matrix getAffineWgs2pix() {
        m21564a();
        return this.f24617l;
    }

    public Matrix getAffinePix2wgs() {
        m21564a();
        return this.f24618m;
    }

    public float getPixelsToMeters() {
        m21564a();
        return this.f24611f;
    }

    public float getMetersToPixels() {
        m21564a();
        return this.f24612g;
    }

    public float getWidthMeters() {
        m21564a();
        return this.f24619n;
    }

    public float getHeightMeters() {
        m21564a();
        return this.f24620o;
    }

    public float getBearing() {
        m21564a();
        return (float) this.f24621p;
    }

    public IALatLng getCenter() {
        m21564a();
        return this.f24622q;
    }

    public IALatLng getTopLeft() {
        m21564a();
        return this.f24623r;
    }

    public IALatLng getBottomLeft() {
        m21564a();
        return this.f24624s;
    }

    public IALatLng getTopRight() {
        m21564a();
        return this.f24625t;
    }

    public PointF coordinateToPoint(IALatLng coord) {
        double[] a = m21565a(coord.latitude, coord.longitude, this.f24615j);
        return new PointF((float) a[0], (float) a[1]);
    }

    public IALatLng pointToCoordinate(PointF pointf) {
        double[] a = m21565a((double) pointf.x, (double) pointf.y, this.f24614i);
        return new IALatLng(a[0], a[1]);
    }

    /* renamed from: a */
    private Location m21562a(double d, double d2) {
        Location location = new Location("");
        double[] a = m21565a(d, d2, this.f24614i);
        location.setLatitude(a[0]);
        location.setLongitude(a[1]);
        return location;
    }

    /* renamed from: a */
    private static IALatLng m21563a(Location location) {
        return new IALatLng(location.getLatitude(), location.getLongitude());
    }

    /* renamed from: a */
    private static double[] m21565a(double d, double d2, double[] dArr) {
        return new double[]{((dArr[0] * d) + (dArr[1] * d2)) + dArr[2], ((dArr[3] * d) + (dArr[4] * d2)) + dArr[5]};
    }

    /* renamed from: a */
    private void m21564a() {
        if (!this.f24616k && this.f24614i.length == 6 && this.f24615j.length == 6) {
            int i;
            float[] fArr = new float[9];
            for (i = 0; i < 6; i++) {
                fArr[i] = (float) this.f24614i[i];
            }
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f24618m = new Matrix();
            this.f24618m.setValues(fArr);
            for (i = 0; i < 6; i++) {
                fArr[i] = (float) this.f24615j[i];
            }
            this.f24617l = new Matrix();
            this.f24617l.setValues(fArr);
            double[] a = m21565a(((double) this.f24609d) / 2.0d, ((double) this.f24610e) / 2.0d, this.f24614i);
            this.f24622q = new IALatLng(a[0], a[1]);
            Location a2 = m21562a(0.0d, 0.0d);
            this.f24623r = m21563a(a2);
            Location a3 = m21562a(0.0d, (double) this.f24610e);
            this.f24624s = m21563a(a3);
            Location a4 = m21562a((double) this.f24609d, 0.0d);
            this.f24625t = m21563a(a4);
            this.f24620o = a3.distanceTo(a2);
            this.f24619n = a2.distanceTo(a4);
            double d = this.f24624s.latitude;
            double d2 = this.f24624s.longitude;
            d *= 0.017453292519943295d;
            double d3 = this.f24623r.latitude * 0.017453292519943295d;
            d2 = (this.f24623r.longitude * 0.017453292519943295d) - (d2 * 0.017453292519943295d);
            this.f24621p = ((Math.atan2(Math.sin(d2) * Math.cos(d3), (Math.cos(d) * Math.sin(d3)) - ((Math.sin(d) * Math.cos(d3)) * Math.cos(d2))) / 0.017453292519943295d) + 360.0d) % 360.0d;
            this.f24612g = ((((float) this.f24609d) / this.f24619n) + (((float) this.f24610e) / this.f24620o)) / 2.0f;
            this.f24611f = 1.0f / this.f24612g;
            this.f24616k = true;
        }
    }

    public String toString() {
        return "IAFloorPlan{id='" + this.f24606a + '\'' + ", name='" + this.f24607b + '\'' + ", url='" + this.f24608c + '\'' + ", bitmapWidth=" + this.f24609d + ", bitmapHeight=" + this.f24610e + ", pixelsToMeters=" + this.f24611f + ", metersToPixels=" + this.f24612g + ", floorLevel=" + this.f24613h + ", pixelToWgs=" + Arrays.toString(this.f24614i) + ", wgsToPixel=" + Arrays.toString(this.f24615j) + '}';
    }
}
