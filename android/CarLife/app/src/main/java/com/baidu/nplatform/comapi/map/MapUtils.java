package com.baidu.nplatform.comapi.map;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class MapUtils {
    static double[][] LL2MC = new double[][]{new double[]{-0.0015702102444d, 111320.7020616939d, 1.704480524535203E15d, -1.033898737604234E16d, 2.611266785660388E16d, -3.51496691766537E16d, 2.659570071840392E16d, -1.072501245418824E16d, 1.800819912950474E15d, 82.5d}, new double[]{8.277824516172526E-4d, 111320.7020463578d, 6.477955746671607E8d, -4.082003173641316E9d, 1.077490566351142E10d, -1.517187553151559E10d, 1.205306533862167E10d, -5.124939663577472E9d, 9.133119359512032E8d, 67.5d}, new double[]{0.00337398766765d, 111320.7020202162d, 4481351.045890365d, -2.339375119931662E7d, 7.968221547186455E7d, -1.159649932797253E8d, 9.723671115602145E7d, -4.366194633752821E7d, 8477230.501135234d, 52.5d}, new double[]{0.00220636496208d, 111320.7020209128d, 51751.86112841131d, 3796837.749470245d, 992013.7397791013d, -1221952.21711287d, 1340652.697009075d, -620943.6990984312d, 144416.9293806241d, 37.5d}, new double[]{-3.441963504368392E-4d, 111320.7020576856d, 278.2353980772752d, 2485758.690035394d, 6070.750963243378d, 54821.18345352118d, 9540.606633304236d, -2710.55326746645d, 1405.483844121726d, 22.5d}, new double[]{-3.218135878613132E-4d, 111320.7020701615d, 0.00369383431289d, 823725.6402795718d, 0.46104986909093d, 2351.343141331292d, 1.58060784298199d, 8.77738589078284d, 0.37238884252424d, 7.45d}};
    static double[] LLBAND = new double[]{7.5E7d, 6.0E7d, 4.5E7d, 3.0E7d, 1.5E7d, 0.0d};
    static double[][] MC2LL = new double[][]{new double[]{1.410526172116255E-8d, 8.98305509648872E-6d, -1.9939833816331d, 200.9824383106796d, -187.2403703815547d, 91.6087516669843d, -23.38765649603339d, 2.57121317296198d, -0.03801003308653d, 1.73379812E7d}, new double[]{-7.435856389565537E-9d, 8.983055097726239E-6d, -0.78625201886289d, 96.32687599759846d, -1.85204757529826d, -59.36935905485877d, 47.40033549296737d, -16.50741931063887d, 2.28786674699375d, 1.026014486E7d}, new double[]{-3.030883460898826E-8d, 8.98305509983578E-6d, 0.30071316287616d, 59.74293618442277d, 7.357984074871d, -25.38371002664745d, 13.45380521110908d, -3.29883767235584d, 0.32710905363475d, 6856817.37d}, new double[]{-1.981981304930552E-8d, 8.983055099779535E-6d, 0.03278182852591d, 40.31678527705744d, 0.65659298677277d, -4.44255534477492d, 0.85341911805263d, 0.12923347998204d, -0.04625736007561d, 4482777.06d}, new double[]{3.09191371068437E-9d, 8.983055096812155E-6d, 6.995724062E-5d, 23.10934304144901d, -2.3663490511E-4d, -0.6321817810242d, -0.00663494467273d, 0.03430082397953d, -0.00466043876332d, 2555164.4d}, new double[]{2.890871144776878E-9d, 8.983055095805407E-6d, -3.068298E-8d, 7.47137025468032d, -3.53937994E-6d, -0.02145144861037d, -1.234426596E-5d, 1.0322952773E-4d, -3.23890364E-6d, 826088.5d}};
    static double[] MCBAND = new double[]{1.289059486E7d, 8362377.87d, 5591021.0d, 3481989.83d, 1678043.12d, 0.0d};

    static class VDPOINT {
        /* renamed from: x */
        double f19729x;
        /* renamed from: y */
        double f19730y;

        VDPOINT() {
        }
    }

    static VDPOINT _conv_(VDPOINT fromPoint, double[] factor) {
        int i;
        int i2 = -1;
        VDPOINT toPoint = new VDPOINT();
        toPoint.f19729x = factor[0] + (factor[1] * Math.abs(fromPoint.f19729x));
        double temp = Math.abs(fromPoint.f19730y) / factor[9];
        toPoint.f19730y = (((((factor[2] + (factor[3] * temp)) + ((factor[4] * temp) * temp)) + (((factor[5] * temp) * temp) * temp)) + ((((factor[6] * temp) * temp) * temp) * temp)) + (((((factor[7] * temp) * temp) * temp) * temp) * temp)) + ((((((factor[8] * temp) * temp) * temp) * temp) * temp) * temp);
        double d = toPoint.f19729x;
        if (fromPoint.f19729x < 0.0d) {
            i = -1;
        } else {
            i = 1;
        }
        toPoint.f19729x = d * ((double) i);
        d = toPoint.f19730y;
        if (fromPoint.f19730y >= 0.0d) {
            i2 = 1;
        }
        toPoint.f19730y = ((double) i2) * d;
        return toPoint;
    }

    public static GeoPoint mc2ll(GeoPoint pt) {
        VDPOINT point = new VDPOINT();
        point.f19729x = (double) pt.getLongitudeE6();
        point.f19730y = (double) pt.getLatitudeE6();
        VDPOINT temp = new VDPOINT();
        temp.f19729x = point.f19729x;
        if (temp.f19729x > 2.0037508342E7d) {
            temp.f19729x = 2.0037508342E7d;
        } else if (temp.f19729x < -2.0037508342E7d) {
            temp.f19729x = -2.0037508342E7d;
        }
        temp.f19730y = point.f19730y;
        if (temp.f19730y < 1.0E-6d && temp.f19730y >= 0.0d) {
            temp.f19730y = 1.0E-6d;
        } else if (temp.f19730y < 0.0d && temp.f19730y > -1.0E-6d) {
            temp.f19730y = -1.0E-6d;
        } else if (temp.f19730y > 2.0037508342E7d) {
            temp.f19730y = 2.0037508342E7d;
        } else if (temp.f19730y < -2.0037508342E7d) {
            temp.f19730y = -2.0037508342E7d;
        }
        double[] factor = null;
        for (int i = 0; i < 6; i++) {
            if (Math.abs(temp.f19730y) > MCBAND[i]) {
                factor = MC2LL[i];
                break;
            }
        }
        VDPOINT p = _conv_(temp, factor);
        return new GeoPoint((int) (p.f19730y * 1000000.0d), (int) (p.f19729x * 1000000.0d));
    }

    public static GeoPoint ll2mc(GeoPoint point) {
        VDPOINT temp = new VDPOINT();
        double[] factor = null;
        temp.f19730y = (double) Math.abs(point.getLatitudeE6());
        if (temp.f19730y < 0.1d) {
            temp.f19730y = 0.1d;
        }
        for (int i = 0; i < LLBAND.length; i++) {
            if (temp.f19730y > LLBAND[i]) {
                factor = LL2MC[i];
                break;
            }
        }
        temp.f19729x = ((double) point.getLongitudeE6()) / 1000000.0d;
        temp.f19730y = ((double) point.getLatitudeE6()) / 1000000.0d;
        VDPOINT p = _conv_(temp, factor);
        return new GeoPoint((int) p.f19730y, (int) p.f19729x);
    }
}
