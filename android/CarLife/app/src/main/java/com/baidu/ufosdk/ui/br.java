package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.List;

public final class br
  extends BaseAdapter
{
  private Context b;
  
  public br(FeedbackInputActivity paramFeedbackInputActivity, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final int getCount()
  {
    return FeedbackInputActivity.p(this.a).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  /* Error */
  public final android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   7: iload_1
    //   8: invokeinterface 47 2 0
    //   13: checkcast 49	java/util/Map
    //   16: ldc 51
    //   18: invokeinterface 54 2 0
    //   23: checkcast 56	java/lang/Integer
    //   26: iconst_0
    //   27: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 64	java/lang/Integer:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +1245 -> 1278
    //   36: aload_0
    //   37: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   40: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   43: iload_1
    //   44: invokeinterface 47 2 0
    //   49: checkcast 49	java/util/Map
    //   52: ldc 66
    //   54: invokeinterface 54 2 0
    //   59: checkcast 68	java/lang/String
    //   62: ldc 70
    //   64: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +1164 -> 1231
    //   70: iconst_1
    //   71: istore 4
    //   73: aconst_null
    //   74: astore 10
    //   76: aconst_null
    //   77: astore 13
    //   79: aconst_null
    //   80: astore 15
    //   82: aconst_null
    //   83: astore 14
    //   85: aload_2
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: ldc 75
    //   92: invokevirtual 80	android/view/View:getTag	(I)Ljava/lang/Object;
    //   95: checkcast 56	java/lang/Integer
    //   98: invokevirtual 83	java/lang/Integer:intValue	()I
    //   101: iload 4
    //   103: if_icmpeq +3640 -> 3743
    //   106: iload 4
    //   108: iconst_1
    //   109: if_icmpne +1396 -> 1505
    //   112: new 85	com/baidu/ufosdk/ui/ce
    //   115: dup
    //   116: invokespecial 86	com/baidu/ufosdk/ui/ce:<init>	()V
    //   119: astore 11
    //   121: new 88	android/widget/RelativeLayout
    //   124: dup
    //   125: aload_0
    //   126: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   129: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   132: astore_3
    //   133: new 88	android/widget/RelativeLayout
    //   136: dup
    //   137: aload_0
    //   138: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   141: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   144: astore_2
    //   145: new 88	android/widget/RelativeLayout
    //   148: dup
    //   149: aload_0
    //   150: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   153: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   156: astore 9
    //   158: aload_3
    //   159: new 93	android/widget/AbsListView$LayoutParams
    //   162: dup
    //   163: iconst_m1
    //   164: bipush -2
    //   166: invokespecial 96	android/widget/AbsListView$LayoutParams:<init>	(II)V
    //   169: invokevirtual 100	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   172: aload 9
    //   174: ldc 101
    //   176: invokevirtual 105	android/widget/RelativeLayout:setId	(I)V
    //   179: new 107	android/widget/TextView
    //   182: dup
    //   183: aload_0
    //   184: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   187: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   190: astore 12
    //   192: aload 12
    //   194: aload_0
    //   195: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   198: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   201: ldc 114
    //   203: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   206: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   209: aload 12
    //   211: iconst_m1
    //   212: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   215: aload 12
    //   217: getstatic 132	com/baidu/ufosdk/a:O	F
    //   220: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   223: aload 12
    //   225: bipush 17
    //   227: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   230: aload 12
    //   232: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   235: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   238: aload 12
    //   240: aload_0
    //   241: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   244: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   247: ldc -106
    //   249: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   252: aload_0
    //   253: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   256: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   259: fconst_2
    //   260: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   263: iconst_2
    //   264: iadd
    //   265: aload_0
    //   266: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   269: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   272: ldc -106
    //   274: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   277: aload_0
    //   278: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   281: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   284: fconst_2
    //   285: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   288: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   291: new 161	android/widget/RelativeLayout$LayoutParams
    //   294: dup
    //   295: bipush -2
    //   297: bipush -2
    //   299: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   302: astore 15
    //   304: aload 15
    //   306: iconst_0
    //   307: aload_0
    //   308: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   311: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   314: ldc -106
    //   316: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   319: iconst_0
    //   320: iconst_0
    //   321: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   324: aload 15
    //   326: bipush 14
    //   328: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   331: aload 9
    //   333: aload 12
    //   335: aload 15
    //   337: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   340: new 161	android/widget/RelativeLayout$LayoutParams
    //   343: dup
    //   344: iconst_m1
    //   345: bipush -2
    //   347: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   350: astore 15
    //   352: aload 9
    //   354: iconst_0
    //   355: aload_0
    //   356: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   359: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   362: ldc -83
    //   364: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   367: iconst_0
    //   368: aload_0
    //   369: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   372: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   375: ldc -82
    //   377: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   380: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   383: aload_3
    //   384: aload 9
    //   386: aload 15
    //   388: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   391: aload 11
    //   393: aload 12
    //   395: putfield 178	com/baidu/ufosdk/ui/ce:a	Landroid/widget/TextView;
    //   398: aload 11
    //   400: aload 9
    //   402: putfield 182	com/baidu/ufosdk/ui/ce:d	Landroid/widget/RelativeLayout;
    //   405: new 184	android/widget/ImageView
    //   408: dup
    //   409: aload_0
    //   410: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   413: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   416: astore 12
    //   418: aload 12
    //   420: ldc -70
    //   422: invokevirtual 187	android/widget/ImageView:setId	(I)V
    //   425: new 161	android/widget/RelativeLayout$LayoutParams
    //   428: dup
    //   429: aload_0
    //   430: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   433: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   436: ldc -68
    //   438: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   441: aload_0
    //   442: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   445: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   448: ldc -68
    //   450: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   453: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   456: astore 15
    //   458: aload 15
    //   460: bipush 11
    //   462: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   465: aload 15
    //   467: aload_0
    //   468: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   471: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   474: ldc -83
    //   476: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   479: iconst_0
    //   480: aload_0
    //   481: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   484: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   487: ldc -82
    //   489: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   492: iconst_0
    //   493: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   496: aload_2
    //   497: aload 12
    //   499: aload 15
    //   501: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   504: aload 11
    //   506: aload 12
    //   508: putfield 191	com/baidu/ufosdk/ui/ce:b	Landroid/widget/ImageView;
    //   511: new 88	android/widget/RelativeLayout
    //   514: dup
    //   515: aload_0
    //   516: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   519: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   522: astore 15
    //   524: aload 15
    //   526: aload_0
    //   527: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   530: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   533: ldc -63
    //   535: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   538: invokevirtual 194	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   541: aload 15
    //   543: aload_0
    //   544: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   547: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   550: fconst_2
    //   551: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   554: bipush 10
    //   556: iadd
    //   557: aload_0
    //   558: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   561: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   564: fconst_2
    //   565: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   568: iconst_5
    //   569: iadd
    //   570: aload_0
    //   571: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   574: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   577: fconst_2
    //   578: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   581: bipush 10
    //   583: iadd
    //   584: aload_0
    //   585: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   588: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   591: fconst_2
    //   592: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   595: iconst_5
    //   596: iadd
    //   597: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   600: new 184	android/widget/ImageView
    //   603: dup
    //   604: aload_0
    //   605: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   608: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   611: astore 16
    //   613: aload 16
    //   615: new 196	com/baidu/ufosdk/ui/bs
    //   618: dup
    //   619: aload_0
    //   620: invokespecial 199	com/baidu/ufosdk/ui/bs:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   623: invokevirtual 203	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   626: aload 16
    //   628: getstatic 209	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   631: invokevirtual 213	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   634: invokestatic 215	com/baidu/ufosdk/util/i:a	()I
    //   637: bipush 23
    //   639: if_icmpge +9 -> 648
    //   642: aload 16
    //   644: iconst_1
    //   645: invokevirtual 219	android/widget/ImageView:setAdjustViewBounds	(Z)V
    //   648: new 161	android/widget/RelativeLayout$LayoutParams
    //   651: dup
    //   652: bipush -2
    //   654: bipush -2
    //   656: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   659: astore 17
    //   661: aload 17
    //   663: iconst_0
    //   664: iconst_0
    //   665: iconst_0
    //   666: iconst_0
    //   667: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   670: aload 15
    //   672: aload 16
    //   674: aload 17
    //   676: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   679: new 161	android/widget/RelativeLayout$LayoutParams
    //   682: dup
    //   683: bipush -2
    //   685: bipush -2
    //   687: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   690: astore 17
    //   692: aload 17
    //   694: iconst_0
    //   695: iconst_0
    //   696: iconst_0
    //   697: iconst_0
    //   698: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   701: aload 17
    //   703: iconst_0
    //   704: aload 12
    //   706: invokevirtual 222	android/widget/ImageView:getId	()I
    //   709: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   712: aload_2
    //   713: aload 15
    //   715: aload 17
    //   717: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   720: aload 11
    //   722: aload 16
    //   724: putfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   727: aload_2
    //   728: iconst_0
    //   729: iconst_0
    //   730: iconst_0
    //   731: aload_0
    //   732: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   735: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   738: ldc -106
    //   740: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   743: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   746: new 161	android/widget/RelativeLayout$LayoutParams
    //   749: dup
    //   750: iconst_m1
    //   751: bipush -2
    //   753: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   756: astore 12
    //   758: aload 12
    //   760: iconst_3
    //   761: aload 9
    //   763: invokevirtual 228	android/widget/RelativeLayout:getId	()I
    //   766: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   769: aload_3
    //   770: aload_2
    //   771: aload 12
    //   773: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   776: aload_3
    //   777: new 230	com/baidu/ufosdk/ui/bt
    //   780: dup
    //   781: aload_0
    //   782: invokespecial 231	com/baidu/ufosdk/ui/bt:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   785: invokevirtual 232	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   788: aload_3
    //   789: ldc -23
    //   791: aload 11
    //   793: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   796: aload_3
    //   797: ldc 75
    //   799: iload 4
    //   801: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   804: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   807: aload 13
    //   809: astore 9
    //   811: aload 14
    //   813: astore 12
    //   815: iload 4
    //   817: iconst_1
    //   818: if_icmpne +3308 -> 4126
    //   821: aload 11
    //   823: getfield 182	com/baidu/ufosdk/ui/ce:d	Landroid/widget/RelativeLayout;
    //   826: iconst_0
    //   827: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   830: iload_1
    //   831: ifne +43 -> 874
    //   834: aload 11
    //   836: getfield 178	com/baidu/ufosdk/ui/ce:a	Landroid/widget/TextView;
    //   839: aload_0
    //   840: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   843: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   846: iload_1
    //   847: invokeinterface 47 2 0
    //   852: checkcast 49	java/util/Map
    //   855: ldc -14
    //   857: invokeinterface 54 2 0
    //   862: checkcast 68	java/lang/String
    //   865: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   868: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   871: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   874: iload_1
    //   875: ifeq +141 -> 1016
    //   878: aload_0
    //   879: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   882: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   885: iload_1
    //   886: iconst_1
    //   887: isub
    //   888: invokeinterface 47 2 0
    //   893: checkcast 49	java/util/Map
    //   896: ldc -14
    //   898: invokeinterface 54 2 0
    //   903: checkcast 68	java/lang/String
    //   906: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   909: lstore 5
    //   911: aload_0
    //   912: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   915: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   918: iload_1
    //   919: invokeinterface 47 2 0
    //   924: checkcast 49	java/util/Map
    //   927: ldc -14
    //   929: invokeinterface 54 2 0
    //   934: checkcast 68	java/lang/String
    //   937: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   940: lstore 7
    //   942: lload 5
    //   944: lload 7
    //   946: lsub
    //   947: ldc2_w 256
    //   950: lcmp
    //   951: ifgt +15 -> 966
    //   954: lload 7
    //   956: lload 5
    //   958: lsub
    //   959: ldc2_w 256
    //   962: lcmp
    //   963: ifle +2918 -> 3881
    //   966: aload 11
    //   968: getfield 178	com/baidu/ufosdk/ui/ce:a	Landroid/widget/TextView;
    //   971: lload 7
    //   973: invokestatic 259	com/baidu/ufosdk/util/i:b	(J)Ljava/lang/String;
    //   976: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   979: lload 5
    //   981: lload 7
    //   983: lsub
    //   984: ldc2_w 260
    //   987: lcmp
    //   988: ifgt +15 -> 1003
    //   991: lload 7
    //   993: lload 5
    //   995: lsub
    //   996: ldc2_w 260
    //   999: lcmp
    //   1000: ifle +16 -> 1016
    //   1003: aload 11
    //   1005: getfield 178	com/baidu/ufosdk/ui/ce:a	Landroid/widget/TextView;
    //   1008: lload 7
    //   1010: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   1013: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1016: aload 11
    //   1018: getfield 191	com/baidu/ufosdk/ui/ce:b	Landroid/widget/ImageView;
    //   1021: new 263	android/graphics/drawable/BitmapDrawable
    //   1024: dup
    //   1025: aload_0
    //   1026: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1029: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1032: invokestatic 268	com/baidu/ufosdk/util/p:c	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   1035: invokespecial 271	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1038: invokevirtual 272	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1041: aload_0
    //   1042: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1045: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1048: iload_1
    //   1049: invokeinterface 47 2 0
    //   1054: checkcast 49	java/util/Map
    //   1057: ldc 66
    //   1059: invokeinterface 54 2 0
    //   1064: checkcast 68	java/lang/String
    //   1067: ldc 70
    //   1069: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   1072: ifeq +2874 -> 3946
    //   1075: aload_0
    //   1076: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1079: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1082: iload_1
    //   1083: invokeinterface 47 2 0
    //   1088: checkcast 49	java/util/Map
    //   1091: ldc_w 274
    //   1094: invokeinterface 54 2 0
    //   1099: checkcast 68	java/lang/String
    //   1102: astore_2
    //   1103: aload 11
    //   1105: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   1108: aload_0
    //   1109: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   1112: ldc_w 276
    //   1115: invokestatic 279	com/baidu/ufosdk/util/p:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1118: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1121: invokestatic 287	com/baidu/ufosdk/util/a:a	()Lcom/baidu/ufosdk/util/a;
    //   1124: new 289	com/baidu/ufosdk/util/q
    //   1127: dup
    //   1128: aload_0
    //   1129: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1132: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1135: aload 11
    //   1137: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   1140: aload_0
    //   1141: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1144: invokestatic 293	com/baidu/ufosdk/ui/FeedbackInputActivity:H	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Landroid/os/Handler;
    //   1147: invokespecial 296	com/baidu/ufosdk/util/q:<init>	(Landroid/content/Context;Landroid/widget/ImageView;Landroid/os/Handler;)V
    //   1150: aload_2
    //   1151: invokevirtual 299	com/baidu/ufosdk/util/a:a	(Lcom/baidu/ufosdk/util/q;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1154: astore_2
    //   1155: aload_2
    //   1156: ifnull +73 -> 1229
    //   1159: getstatic 302	com/baidu/ufosdk/ui/FeedbackInputActivity:a	Ljava/util/ArrayList;
    //   1162: aload_2
    //   1163: invokevirtual 307	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1166: pop
    //   1167: aload 11
    //   1169: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   1172: aload_2
    //   1173: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1176: aload_2
    //   1177: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   1180: aload_2
    //   1181: invokevirtual 315	android/graphics/Bitmap:getWidth	()I
    //   1184: if_icmple +2718 -> 3902
    //   1187: aload 11
    //   1189: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   1192: aload_0
    //   1193: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1196: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1199: ldc_w 316
    //   1202: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1205: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   1208: aload 11
    //   1210: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   1213: aload_0
    //   1214: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1217: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1220: ldc_w 320
    //   1223: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1226: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   1229: aload_3
    //   1230: areturn
    //   1231: aload_0
    //   1232: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1235: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1238: iload_1
    //   1239: invokeinterface 47 2 0
    //   1244: checkcast 49	java/util/Map
    //   1247: ldc 66
    //   1249: invokeinterface 54 2 0
    //   1254: checkcast 68	java/lang/String
    //   1257: ldc_w 325
    //   1260: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   1263: ifeq +9 -> 1272
    //   1266: iconst_1
    //   1267: istore 4
    //   1269: goto -1196 -> 73
    //   1272: iconst_2
    //   1273: istore 4
    //   1275: goto -1202 -> 73
    //   1278: aload_0
    //   1279: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1282: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1285: iload_1
    //   1286: invokeinterface 47 2 0
    //   1291: checkcast 49	java/util/Map
    //   1294: ldc 51
    //   1296: invokeinterface 54 2 0
    //   1301: checkcast 56	java/lang/Integer
    //   1304: iconst_1
    //   1305: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1308: invokevirtual 64	java/lang/Integer:equals	(Ljava/lang/Object;)Z
    //   1311: ifeq +168 -> 1479
    //   1314: aload_0
    //   1315: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1318: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1321: iload_1
    //   1322: invokeinterface 47 2 0
    //   1327: checkcast 49	java/util/Map
    //   1330: ldc 66
    //   1332: invokeinterface 54 2 0
    //   1337: checkcast 68	java/lang/String
    //   1340: ldc 70
    //   1342: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   1345: ifeq +9 -> 1354
    //   1348: iconst_4
    //   1349: istore 4
    //   1351: goto -1278 -> 73
    //   1354: aload_0
    //   1355: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1358: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1361: iload_1
    //   1362: invokeinterface 47 2 0
    //   1367: checkcast 49	java/util/Map
    //   1370: ldc 66
    //   1372: invokeinterface 54 2 0
    //   1377: checkcast 68	java/lang/String
    //   1380: ldc_w 325
    //   1383: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   1386: ifeq +9 -> 1395
    //   1389: iconst_4
    //   1390: istore 4
    //   1392: goto -1319 -> 73
    //   1395: aload_0
    //   1396: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1399: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1402: iload_1
    //   1403: invokeinterface 47 2 0
    //   1408: checkcast 49	java/util/Map
    //   1411: ldc_w 274
    //   1414: invokeinterface 54 2 0
    //   1419: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   1422: ldc_w 333
    //   1425: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1428: ifne +39 -> 1467
    //   1431: aload_0
    //   1432: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1435: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   1438: iload_1
    //   1439: invokeinterface 47 2 0
    //   1444: checkcast 49	java/util/Map
    //   1447: ldc_w 274
    //   1450: invokeinterface 54 2 0
    //   1455: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   1458: ldc_w 339
    //   1461: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1464: ifeq +9 -> 1473
    //   1467: iconst_4
    //   1468: istore 4
    //   1470: goto -1397 -> 73
    //   1473: iconst_3
    //   1474: istore 4
    //   1476: goto -1403 -> 73
    //   1479: iconst_3
    //   1480: istore 4
    //   1482: goto -1409 -> 73
    //   1485: astore 15
    //   1487: aload 15
    //   1489: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   1492: goto -1283 -> 209
    //   1495: astore 16
    //   1497: aload 16
    //   1499: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   1502: goto -902 -> 600
    //   1505: iload 4
    //   1507: iconst_2
    //   1508: if_icmpne +736 -> 2244
    //   1511: new 344	com/baidu/ufosdk/ui/cf
    //   1514: dup
    //   1515: invokespecial 345	com/baidu/ufosdk/ui/cf:<init>	()V
    //   1518: astore 12
    //   1520: new 88	android/widget/RelativeLayout
    //   1523: dup
    //   1524: aload_0
    //   1525: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   1528: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1531: astore_3
    //   1532: new 88	android/widget/RelativeLayout
    //   1535: dup
    //   1536: aload_0
    //   1537: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   1540: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1543: astore_2
    //   1544: new 88	android/widget/RelativeLayout
    //   1547: dup
    //   1548: aload_0
    //   1549: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   1552: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   1555: astore 9
    //   1557: aload_3
    //   1558: new 93	android/widget/AbsListView$LayoutParams
    //   1561: dup
    //   1562: iconst_m1
    //   1563: bipush -2
    //   1565: invokespecial 96	android/widget/AbsListView$LayoutParams:<init>	(II)V
    //   1568: invokevirtual 100	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1571: aload 9
    //   1573: ldc 101
    //   1575: invokevirtual 105	android/widget/RelativeLayout:setId	(I)V
    //   1578: new 107	android/widget/TextView
    //   1581: dup
    //   1582: aload_0
    //   1583: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1586: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   1589: astore 11
    //   1591: aload 11
    //   1593: aload_0
    //   1594: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1597: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1600: ldc 114
    //   1602: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1605: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1608: aload 11
    //   1610: iconst_m1
    //   1611: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   1614: aload 11
    //   1616: getstatic 132	com/baidu/ufosdk/a:O	F
    //   1619: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   1622: aload 11
    //   1624: bipush 17
    //   1626: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   1629: aload 11
    //   1631: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   1634: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   1637: aload 11
    //   1639: aload_0
    //   1640: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1643: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1646: ldc -106
    //   1648: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1651: aload_0
    //   1652: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1655: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1658: fconst_2
    //   1659: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1662: iconst_2
    //   1663: iadd
    //   1664: aload_0
    //   1665: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1668: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1671: ldc -106
    //   1673: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1676: aload_0
    //   1677: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1680: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1683: fconst_2
    //   1684: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1687: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   1690: new 161	android/widget/RelativeLayout$LayoutParams
    //   1693: dup
    //   1694: bipush -2
    //   1696: bipush -2
    //   1698: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1701: astore 14
    //   1703: aload 14
    //   1705: iconst_0
    //   1706: aload_0
    //   1707: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1710: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1713: ldc -106
    //   1715: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1718: iconst_0
    //   1719: iconst_0
    //   1720: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1723: aload 14
    //   1725: bipush 14
    //   1727: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1730: aload 9
    //   1732: aload 11
    //   1734: aload 14
    //   1736: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1739: new 161	android/widget/RelativeLayout$LayoutParams
    //   1742: dup
    //   1743: iconst_m1
    //   1744: bipush -2
    //   1746: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1749: astore 14
    //   1751: aload 9
    //   1753: iconst_0
    //   1754: aload_0
    //   1755: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1758: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1761: ldc -83
    //   1763: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1766: iconst_0
    //   1767: aload_0
    //   1768: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1771: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1774: ldc -82
    //   1776: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1779: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   1782: aload_3
    //   1783: aload 9
    //   1785: aload 14
    //   1787: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1790: aload 12
    //   1792: aload 11
    //   1794: putfield 346	com/baidu/ufosdk/ui/cf:a	Landroid/widget/TextView;
    //   1797: aload 12
    //   1799: aload 9
    //   1801: putfield 347	com/baidu/ufosdk/ui/cf:d	Landroid/widget/RelativeLayout;
    //   1804: new 184	android/widget/ImageView
    //   1807: dup
    //   1808: aload_0
    //   1809: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1812: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1815: astore 11
    //   1817: aload 11
    //   1819: ldc -70
    //   1821: invokevirtual 187	android/widget/ImageView:setId	(I)V
    //   1824: new 161	android/widget/RelativeLayout$LayoutParams
    //   1827: dup
    //   1828: aload_0
    //   1829: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1832: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1835: ldc -68
    //   1837: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1840: aload_0
    //   1841: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1844: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1847: ldc -68
    //   1849: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1852: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1855: astore 14
    //   1857: aload 14
    //   1859: bipush 11
    //   1861: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1864: aload 14
    //   1866: aload_0
    //   1867: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1870: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1873: ldc -83
    //   1875: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1878: iconst_0
    //   1879: aload_0
    //   1880: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1883: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1886: ldc -82
    //   1888: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1891: iconst_0
    //   1892: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1895: aload_2
    //   1896: aload 11
    //   1898: aload 14
    //   1900: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1903: aload 12
    //   1905: aload 11
    //   1907: putfield 348	com/baidu/ufosdk/ui/cf:b	Landroid/widget/ImageView;
    //   1910: new 107	android/widget/TextView
    //   1913: dup
    //   1914: aload_0
    //   1915: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1918: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   1921: astore 14
    //   1923: aload 14
    //   1925: ldc_w 349
    //   1928: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   1931: aload 14
    //   1933: getstatic 352	com/baidu/ufosdk/a:P	F
    //   1936: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   1939: aload 14
    //   1941: ldc_w 353
    //   1944: fconst_1
    //   1945: invokevirtual 357	android/widget/TextView:setLineSpacing	(FF)V
    //   1948: aload 14
    //   1950: aload_0
    //   1951: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1954: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1957: ldc -63
    //   1959: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1962: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1965: aload 14
    //   1967: bipush 16
    //   1969: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   1972: aload 14
    //   1974: aload_0
    //   1975: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1978: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1981: ldc_w 358
    //   1984: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1987: aload_0
    //   1988: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   1991: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   1994: ldc -106
    //   1996: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   1999: aload_0
    //   2000: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2003: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2006: ldc_w 359
    //   2009: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2012: aload_0
    //   2013: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2016: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2019: ldc -82
    //   2021: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2024: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   2027: aload 14
    //   2029: ldc_w 360
    //   2032: fconst_1
    //   2033: invokevirtual 357	android/widget/TextView:setLineSpacing	(FF)V
    //   2036: aload 14
    //   2038: iconst_1
    //   2039: invokevirtual 363	android/widget/TextView:setAutoLinkMask	(I)V
    //   2042: aload 14
    //   2044: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   2047: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   2050: aload 14
    //   2052: new 365	com/baidu/ufosdk/ui/bu
    //   2055: dup
    //   2056: aload_0
    //   2057: invokespecial 366	com/baidu/ufosdk/ui/bu:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   2060: invokevirtual 370	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2063: new 161	android/widget/RelativeLayout$LayoutParams
    //   2066: dup
    //   2067: bipush -2
    //   2069: bipush -2
    //   2071: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2074: astore 16
    //   2076: aload 16
    //   2078: aload_0
    //   2079: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2082: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2085: ldc_w 371
    //   2088: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2091: iconst_0
    //   2092: iconst_0
    //   2093: iconst_0
    //   2094: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   2097: aload 16
    //   2099: iconst_0
    //   2100: aload 11
    //   2102: invokevirtual 222	android/widget/ImageView:getId	()I
    //   2105: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   2108: aload_2
    //   2109: aload 14
    //   2111: aload 16
    //   2113: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2116: aload 12
    //   2118: aload 14
    //   2120: putfield 373	com/baidu/ufosdk/ui/cf:c	Landroid/widget/TextView;
    //   2123: aload_2
    //   2124: iconst_0
    //   2125: iconst_0
    //   2126: iconst_0
    //   2127: aload_0
    //   2128: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2131: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2134: ldc -106
    //   2136: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2139: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   2142: new 161	android/widget/RelativeLayout$LayoutParams
    //   2145: dup
    //   2146: iconst_m1
    //   2147: bipush -2
    //   2149: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2152: astore 11
    //   2154: aload 11
    //   2156: iconst_3
    //   2157: aload 9
    //   2159: invokevirtual 228	android/widget/RelativeLayout:getId	()I
    //   2162: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   2165: aload_3
    //   2166: aload_2
    //   2167: aload 11
    //   2169: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2172: aload_3
    //   2173: new 375	com/baidu/ufosdk/ui/bv
    //   2176: dup
    //   2177: aload_0
    //   2178: invokespecial 376	com/baidu/ufosdk/ui/bv:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   2181: invokevirtual 232	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2184: aload_3
    //   2185: ldc -23
    //   2187: aload 12
    //   2189: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   2192: aload_3
    //   2193: ldc 75
    //   2195: iload 4
    //   2197: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2200: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   2203: aload 15
    //   2205: astore 11
    //   2207: aload 13
    //   2209: astore 9
    //   2211: goto -1396 -> 815
    //   2214: astore 14
    //   2216: aload 14
    //   2218: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   2221: goto -613 -> 1608
    //   2224: astore 16
    //   2226: aload 16
    //   2228: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   2231: goto -266 -> 1965
    //   2234: astore 16
    //   2236: aload 16
    //   2238: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   2241: goto -276 -> 1965
    //   2244: iload 4
    //   2246: iconst_3
    //   2247: if_icmpne +744 -> 2991
    //   2250: new 379	com/baidu/ufosdk/ui/cd
    //   2253: dup
    //   2254: invokespecial 380	com/baidu/ufosdk/ui/cd:<init>	()V
    //   2257: astore 9
    //   2259: new 88	android/widget/RelativeLayout
    //   2262: dup
    //   2263: aload_0
    //   2264: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   2267: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2270: astore_3
    //   2271: new 88	android/widget/RelativeLayout
    //   2274: dup
    //   2275: aload_0
    //   2276: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   2279: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2282: astore_2
    //   2283: new 88	android/widget/RelativeLayout
    //   2286: dup
    //   2287: aload_0
    //   2288: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   2291: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   2294: astore 11
    //   2296: aload_3
    //   2297: new 93	android/widget/AbsListView$LayoutParams
    //   2300: dup
    //   2301: iconst_m1
    //   2302: bipush -2
    //   2304: invokespecial 96	android/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2307: invokevirtual 100	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2310: aload 11
    //   2312: ldc 101
    //   2314: invokevirtual 105	android/widget/RelativeLayout:setId	(I)V
    //   2317: new 107	android/widget/TextView
    //   2320: dup
    //   2321: aload_0
    //   2322: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2325: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2328: astore 12
    //   2330: aload 12
    //   2332: aload_0
    //   2333: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2336: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2339: ldc 114
    //   2341: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   2344: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2347: aload 12
    //   2349: iconst_m1
    //   2350: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   2353: aload 12
    //   2355: getstatic 132	com/baidu/ufosdk/a:O	F
    //   2358: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   2361: aload 12
    //   2363: bipush 17
    //   2365: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   2368: aload 12
    //   2370: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   2373: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   2376: aload 12
    //   2378: aload_0
    //   2379: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2382: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2385: ldc -106
    //   2387: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2390: aload_0
    //   2391: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2394: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2397: fconst_2
    //   2398: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2401: iconst_2
    //   2402: iadd
    //   2403: aload_0
    //   2404: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2407: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2410: ldc -106
    //   2412: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2415: aload_0
    //   2416: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2419: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2422: fconst_2
    //   2423: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2426: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   2429: new 161	android/widget/RelativeLayout$LayoutParams
    //   2432: dup
    //   2433: bipush -2
    //   2435: bipush -2
    //   2437: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2440: astore 13
    //   2442: aload 13
    //   2444: iconst_0
    //   2445: aload_0
    //   2446: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2449: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2452: ldc -106
    //   2454: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2457: iconst_0
    //   2458: iconst_0
    //   2459: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   2462: aload 13
    //   2464: bipush 14
    //   2466: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2469: aload 11
    //   2471: aload 12
    //   2473: aload 13
    //   2475: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2478: new 161	android/widget/RelativeLayout$LayoutParams
    //   2481: dup
    //   2482: iconst_m1
    //   2483: bipush -2
    //   2485: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2488: astore 13
    //   2490: aload 11
    //   2492: iconst_0
    //   2493: aload_0
    //   2494: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2497: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2500: ldc -83
    //   2502: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2505: iconst_0
    //   2506: aload_0
    //   2507: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2510: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2513: ldc -82
    //   2515: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2518: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   2521: aload_3
    //   2522: aload 11
    //   2524: aload 13
    //   2526: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2529: aload 9
    //   2531: aload 12
    //   2533: putfield 381	com/baidu/ufosdk/ui/cd:a	Landroid/widget/TextView;
    //   2536: aload 9
    //   2538: aload 11
    //   2540: putfield 382	com/baidu/ufosdk/ui/cd:d	Landroid/widget/RelativeLayout;
    //   2543: new 184	android/widget/ImageView
    //   2546: dup
    //   2547: aload_0
    //   2548: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2551: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2554: astore 12
    //   2556: aload 12
    //   2558: ldc -70
    //   2560: invokevirtual 187	android/widget/ImageView:setId	(I)V
    //   2563: new 161	android/widget/RelativeLayout$LayoutParams
    //   2566: dup
    //   2567: aload_0
    //   2568: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2571: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2574: ldc -68
    //   2576: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2579: aload_0
    //   2580: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2583: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2586: ldc -68
    //   2588: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2591: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2594: astore 13
    //   2596: aload 13
    //   2598: aload_0
    //   2599: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2602: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2605: ldc -82
    //   2607: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2610: iconst_0
    //   2611: aload_0
    //   2612: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2615: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2618: ldc_w 353
    //   2621: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2624: iconst_0
    //   2625: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   2628: aload 13
    //   2630: bipush 9
    //   2632: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2635: aload_2
    //   2636: aload 12
    //   2638: aload 13
    //   2640: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2643: aload 9
    //   2645: aload 12
    //   2647: putfield 383	com/baidu/ufosdk/ui/cd:b	Landroid/widget/ImageView;
    //   2650: new 107	android/widget/TextView
    //   2653: dup
    //   2654: aload_0
    //   2655: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2658: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2661: astore 13
    //   2663: aload 13
    //   2665: aload_0
    //   2666: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2669: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2672: ldc_w 385
    //   2675: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   2678: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2681: aload 13
    //   2683: aload_0
    //   2684: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2687: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2690: ldc_w 386
    //   2693: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2696: aload_0
    //   2697: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2700: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2703: ldc_w 387
    //   2706: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2709: aload_0
    //   2710: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2713: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2716: ldc_w 388
    //   2719: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2722: aload_0
    //   2723: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2726: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2729: ldc_w 389
    //   2732: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2735: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   2738: aload 13
    //   2740: bipush 16
    //   2742: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   2745: aload 13
    //   2747: ldc_w 360
    //   2750: fconst_1
    //   2751: invokevirtual 357	android/widget/TextView:setLineSpacing	(FF)V
    //   2754: aload 13
    //   2756: ldc_w 349
    //   2759: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   2762: aload 13
    //   2764: getstatic 352	com/baidu/ufosdk/a:P	F
    //   2767: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   2770: aload 13
    //   2772: iconst_1
    //   2773: invokevirtual 363	android/widget/TextView:setAutoLinkMask	(I)V
    //   2776: aload 13
    //   2778: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   2781: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   2784: aload 13
    //   2786: new 391	com/baidu/ufosdk/ui/bw
    //   2789: dup
    //   2790: aload_0
    //   2791: invokespecial 392	com/baidu/ufosdk/ui/bw:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   2794: invokevirtual 370	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2797: aload 13
    //   2799: new 394	com/baidu/ufosdk/ui/bx
    //   2802: dup
    //   2803: aload_0
    //   2804: invokespecial 395	com/baidu/ufosdk/ui/bx:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   2807: invokevirtual 396	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2810: new 161	android/widget/RelativeLayout$LayoutParams
    //   2813: dup
    //   2814: bipush -2
    //   2816: bipush -2
    //   2818: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2821: astore 16
    //   2823: aload 16
    //   2825: iconst_0
    //   2826: iconst_0
    //   2827: aload_0
    //   2828: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2831: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2834: ldc_w 397
    //   2837: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2840: iconst_0
    //   2841: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   2844: aload 16
    //   2846: iconst_1
    //   2847: aload 12
    //   2849: invokevirtual 222	android/widget/ImageView:getId	()I
    //   2852: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   2855: aload_2
    //   2856: aload 13
    //   2858: aload 16
    //   2860: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2863: aload 9
    //   2865: aload 13
    //   2867: putfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   2870: aload_2
    //   2871: iconst_0
    //   2872: iconst_0
    //   2873: iconst_0
    //   2874: aload_0
    //   2875: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   2878: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   2881: ldc -106
    //   2883: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   2886: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   2889: new 161	android/widget/RelativeLayout$LayoutParams
    //   2892: dup
    //   2893: iconst_m1
    //   2894: bipush -2
    //   2896: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2899: astore 12
    //   2901: aload 12
    //   2903: iconst_3
    //   2904: aload 11
    //   2906: invokevirtual 228	android/widget/RelativeLayout:getId	()I
    //   2909: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   2912: aload_3
    //   2913: aload_2
    //   2914: aload 12
    //   2916: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2919: aload_3
    //   2920: new 400	com/baidu/ufosdk/ui/by
    //   2923: dup
    //   2924: aload_0
    //   2925: invokespecial 401	com/baidu/ufosdk/ui/by:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   2928: invokevirtual 232	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2931: aload_3
    //   2932: ldc -23
    //   2934: aload 9
    //   2936: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   2939: aload_3
    //   2940: ldc 75
    //   2942: iload 4
    //   2944: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2947: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   2950: aload 14
    //   2952: astore 12
    //   2954: aload 15
    //   2956: astore 11
    //   2958: goto -2143 -> 815
    //   2961: astore 13
    //   2963: aload 13
    //   2965: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   2968: goto -621 -> 2347
    //   2971: astore 16
    //   2973: aload 16
    //   2975: invokevirtual 377	java/io/IOException:printStackTrace	()V
    //   2978: goto -297 -> 2681
    //   2981: astore 16
    //   2983: aload 16
    //   2985: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   2988: goto -307 -> 2681
    //   2991: aload 14
    //   2993: astore 12
    //   2995: aload 15
    //   2997: astore 11
    //   2999: aload 13
    //   3001: astore 9
    //   3003: aload_2
    //   3004: astore_3
    //   3005: iload 4
    //   3007: iconst_4
    //   3008: if_icmpne -2193 -> 815
    //   3011: new 403	com/baidu/ufosdk/ui/cc
    //   3014: dup
    //   3015: invokespecial 404	com/baidu/ufosdk/ui/cc:<init>	()V
    //   3018: astore 10
    //   3020: new 88	android/widget/RelativeLayout
    //   3023: dup
    //   3024: aload_0
    //   3025: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   3028: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   3031: astore_3
    //   3032: new 88	android/widget/RelativeLayout
    //   3035: dup
    //   3036: aload_0
    //   3037: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   3040: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   3043: astore_2
    //   3044: new 88	android/widget/RelativeLayout
    //   3047: dup
    //   3048: aload_0
    //   3049: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   3052: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   3055: astore 9
    //   3057: aload_3
    //   3058: new 93	android/widget/AbsListView$LayoutParams
    //   3061: dup
    //   3062: iconst_m1
    //   3063: bipush -2
    //   3065: invokespecial 96	android/widget/AbsListView$LayoutParams:<init>	(II)V
    //   3068: invokevirtual 100	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3071: aload 9
    //   3073: ldc 101
    //   3075: invokevirtual 105	android/widget/RelativeLayout:setId	(I)V
    //   3078: new 107	android/widget/TextView
    //   3081: dup
    //   3082: aload_0
    //   3083: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3086: invokespecial 108	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   3089: astore 11
    //   3091: aload 11
    //   3093: aload_0
    //   3094: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3097: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3100: ldc 114
    //   3102: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   3105: invokevirtual 123	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3108: aload 11
    //   3110: iconst_m1
    //   3111: invokevirtual 126	android/widget/TextView:setTextColor	(I)V
    //   3114: aload 11
    //   3116: getstatic 132	com/baidu/ufosdk/a:O	F
    //   3119: invokevirtual 136	android/widget/TextView:setTextSize	(F)V
    //   3122: aload 11
    //   3124: bipush 17
    //   3126: invokevirtual 139	android/widget/TextView:setGravity	(I)V
    //   3129: aload 11
    //   3131: invokestatic 145	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   3134: invokevirtual 149	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   3137: aload 11
    //   3139: aload_0
    //   3140: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3143: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3146: ldc -106
    //   3148: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3151: aload_0
    //   3152: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3155: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3158: fconst_2
    //   3159: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3162: iconst_2
    //   3163: iadd
    //   3164: aload_0
    //   3165: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3168: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3171: ldc -106
    //   3173: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3176: aload_0
    //   3177: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3180: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3183: fconst_2
    //   3184: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3187: invokevirtual 159	android/widget/TextView:setPadding	(IIII)V
    //   3190: new 161	android/widget/RelativeLayout$LayoutParams
    //   3193: dup
    //   3194: bipush -2
    //   3196: bipush -2
    //   3198: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3201: astore 12
    //   3203: aload 12
    //   3205: iconst_0
    //   3206: aload_0
    //   3207: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3210: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3213: ldc -106
    //   3215: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3218: iconst_0
    //   3219: iconst_0
    //   3220: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   3223: aload 12
    //   3225: bipush 14
    //   3227: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   3230: aload 9
    //   3232: aload 11
    //   3234: aload 12
    //   3236: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3239: new 161	android/widget/RelativeLayout$LayoutParams
    //   3242: dup
    //   3243: iconst_m1
    //   3244: bipush -2
    //   3246: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3249: astore 12
    //   3251: aload 9
    //   3253: iconst_0
    //   3254: aload_0
    //   3255: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3258: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3261: ldc -83
    //   3263: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3266: iconst_0
    //   3267: aload_0
    //   3268: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3271: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3274: ldc -82
    //   3276: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3279: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   3282: aload_3
    //   3283: aload 9
    //   3285: aload 12
    //   3287: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3290: aload 10
    //   3292: aload 11
    //   3294: putfield 405	com/baidu/ufosdk/ui/cc:a	Landroid/widget/TextView;
    //   3297: aload 10
    //   3299: aload 9
    //   3301: putfield 406	com/baidu/ufosdk/ui/cc:d	Landroid/widget/RelativeLayout;
    //   3304: new 184	android/widget/ImageView
    //   3307: dup
    //   3308: aload_0
    //   3309: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3312: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   3315: astore 11
    //   3317: aload 11
    //   3319: ldc -70
    //   3321: invokevirtual 187	android/widget/ImageView:setId	(I)V
    //   3324: new 161	android/widget/RelativeLayout$LayoutParams
    //   3327: dup
    //   3328: aload_0
    //   3329: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3332: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3335: ldc -68
    //   3337: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3340: aload_0
    //   3341: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3344: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3347: ldc -68
    //   3349: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3352: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3355: astore 12
    //   3357: aload 12
    //   3359: aload_0
    //   3360: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3363: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3366: ldc -82
    //   3368: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3371: iconst_0
    //   3372: aload_0
    //   3373: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3376: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3379: ldc_w 353
    //   3382: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3385: iconst_0
    //   3386: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   3389: aload 12
    //   3391: bipush 9
    //   3393: invokevirtual 168	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   3396: aload_2
    //   3397: aload 11
    //   3399: aload 12
    //   3401: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3404: aload 10
    //   3406: aload 11
    //   3408: putfield 407	com/baidu/ufosdk/ui/cc:b	Landroid/widget/ImageView;
    //   3411: new 88	android/widget/RelativeLayout
    //   3414: dup
    //   3415: aload_0
    //   3416: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3419: invokespecial 91	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   3422: astore 12
    //   3424: aload 12
    //   3426: aload_0
    //   3427: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3430: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3433: ldc_w 385
    //   3436: invokestatic 119	com/baidu/ufosdk/util/r:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   3439: invokevirtual 194	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3442: aload 12
    //   3444: aload_0
    //   3445: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3448: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3451: fconst_2
    //   3452: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3455: bipush 10
    //   3457: iadd
    //   3458: aload_0
    //   3459: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3462: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3465: fconst_2
    //   3466: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3469: iconst_5
    //   3470: iadd
    //   3471: aload_0
    //   3472: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3475: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3478: fconst_2
    //   3479: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3482: bipush 10
    //   3484: iadd
    //   3485: aload_0
    //   3486: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3489: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3492: fconst_2
    //   3493: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3496: iconst_5
    //   3497: iadd
    //   3498: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   3501: new 184	android/widget/ImageView
    //   3504: dup
    //   3505: aload_0
    //   3506: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3509: invokespecial 185	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   3512: astore 16
    //   3514: aload 16
    //   3516: new 409	com/baidu/ufosdk/ui/bz
    //   3519: dup
    //   3520: aload_0
    //   3521: invokespecial 410	com/baidu/ufosdk/ui/bz:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   3524: invokevirtual 203	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3527: aload 16
    //   3529: getstatic 209	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   3532: invokevirtual 213	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   3535: invokestatic 215	com/baidu/ufosdk/util/i:a	()I
    //   3538: bipush 23
    //   3540: if_icmpge +9 -> 3549
    //   3543: aload 16
    //   3545: iconst_1
    //   3546: invokevirtual 219	android/widget/ImageView:setAdjustViewBounds	(Z)V
    //   3549: new 161	android/widget/RelativeLayout$LayoutParams
    //   3552: dup
    //   3553: bipush -2
    //   3555: bipush -2
    //   3557: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3560: astore 17
    //   3562: aload 17
    //   3564: iconst_0
    //   3565: iconst_0
    //   3566: iconst_0
    //   3567: iconst_0
    //   3568: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   3571: aload 12
    //   3573: aload 16
    //   3575: aload 17
    //   3577: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3580: new 161	android/widget/RelativeLayout$LayoutParams
    //   3583: dup
    //   3584: bipush -2
    //   3586: bipush -2
    //   3588: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3591: astore 17
    //   3593: aload 17
    //   3595: iconst_0
    //   3596: iconst_0
    //   3597: iconst_0
    //   3598: iconst_0
    //   3599: invokevirtual 165	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   3602: aload 17
    //   3604: iconst_1
    //   3605: aload 11
    //   3607: invokevirtual 222	android/widget/ImageView:getId	()I
    //   3610: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   3613: aload_2
    //   3614: aload 12
    //   3616: aload 17
    //   3618: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3621: aload 10
    //   3623: aload 16
    //   3625: putfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   3628: aload_2
    //   3629: iconst_0
    //   3630: iconst_0
    //   3631: iconst_0
    //   3632: aload_0
    //   3633: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3636: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3639: ldc -106
    //   3641: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3644: invokevirtual 175	android/widget/RelativeLayout:setPadding	(IIII)V
    //   3647: new 161	android/widget/RelativeLayout$LayoutParams
    //   3650: dup
    //   3651: iconst_m1
    //   3652: bipush -2
    //   3654: invokespecial 162	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   3657: astore 11
    //   3659: aload 11
    //   3661: iconst_3
    //   3662: aload 9
    //   3664: invokevirtual 228	android/widget/RelativeLayout:getId	()I
    //   3667: invokevirtual 224	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   3670: aload_3
    //   3671: aload_2
    //   3672: aload 11
    //   3674: invokevirtual 172	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3677: aload_3
    //   3678: new 413	com/baidu/ufosdk/ui/ca
    //   3681: dup
    //   3682: aload_0
    //   3683: invokespecial 414	com/baidu/ufosdk/ui/ca:<init>	(Lcom/baidu/ufosdk/ui/br;)V
    //   3686: invokevirtual 232	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3689: aload_3
    //   3690: ldc -23
    //   3692: aload 10
    //   3694: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   3697: aload_3
    //   3698: ldc 75
    //   3700: iload 4
    //   3702: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3705: invokevirtual 237	android/view/View:setTag	(ILjava/lang/Object;)V
    //   3708: aload 14
    //   3710: astore 12
    //   3712: aload 15
    //   3714: astore 11
    //   3716: aload 13
    //   3718: astore 9
    //   3720: goto -2905 -> 815
    //   3723: astore 12
    //   3725: aload 12
    //   3727: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   3730: goto -622 -> 3108
    //   3733: astore 16
    //   3735: aload 16
    //   3737: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   3740: goto -239 -> 3501
    //   3743: iload 4
    //   3745: iconst_1
    //   3746: if_icmpne +27 -> 3773
    //   3749: aload_2
    //   3750: ldc -23
    //   3752: invokevirtual 80	android/view/View:getTag	(I)Ljava/lang/Object;
    //   3755: checkcast 85	com/baidu/ufosdk/ui/ce
    //   3758: astore 11
    //   3760: aload 14
    //   3762: astore 12
    //   3764: aload 13
    //   3766: astore 9
    //   3768: aload_2
    //   3769: astore_3
    //   3770: goto -2955 -> 815
    //   3773: iload 4
    //   3775: iconst_2
    //   3776: if_icmpne +27 -> 3803
    //   3779: aload_2
    //   3780: ldc -23
    //   3782: invokevirtual 80	android/view/View:getTag	(I)Ljava/lang/Object;
    //   3785: checkcast 344	com/baidu/ufosdk/ui/cf
    //   3788: astore 12
    //   3790: aload 15
    //   3792: astore 11
    //   3794: aload 13
    //   3796: astore 9
    //   3798: aload_2
    //   3799: astore_3
    //   3800: goto -2985 -> 815
    //   3803: iload 4
    //   3805: iconst_3
    //   3806: if_icmpne +27 -> 3833
    //   3809: aload_2
    //   3810: ldc -23
    //   3812: invokevirtual 80	android/view/View:getTag	(I)Ljava/lang/Object;
    //   3815: checkcast 379	com/baidu/ufosdk/ui/cd
    //   3818: astore 9
    //   3820: aload 14
    //   3822: astore 12
    //   3824: aload 15
    //   3826: astore 11
    //   3828: aload_2
    //   3829: astore_3
    //   3830: goto -3015 -> 815
    //   3833: aload 14
    //   3835: astore 12
    //   3837: aload 15
    //   3839: astore 11
    //   3841: aload 13
    //   3843: astore 9
    //   3845: aload_2
    //   3846: astore_3
    //   3847: iload 4
    //   3849: iconst_4
    //   3850: if_icmpne -3035 -> 815
    //   3853: aload_2
    //   3854: ldc -23
    //   3856: invokevirtual 80	android/view/View:getTag	(I)Ljava/lang/Object;
    //   3859: checkcast 403	com/baidu/ufosdk/ui/cc
    //   3862: astore 10
    //   3864: aload 14
    //   3866: astore 12
    //   3868: aload 15
    //   3870: astore 11
    //   3872: aload 13
    //   3874: astore 9
    //   3876: aload_2
    //   3877: astore_3
    //   3878: goto -3063 -> 815
    //   3881: aload 11
    //   3883: getfield 182	com/baidu/ufosdk/ui/ce:d	Landroid/widget/RelativeLayout;
    //   3886: bipush 8
    //   3888: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   3891: goto -2875 -> 1016
    //   3894: astore_2
    //   3895: aload_2
    //   3896: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   3899: goto -2858 -> 1041
    //   3902: aload 11
    //   3904: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   3907: aload_0
    //   3908: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3911: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3914: ldc_w 320
    //   3917: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3920: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   3923: aload 11
    //   3925: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   3928: aload_0
    //   3929: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3932: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   3935: ldc_w 316
    //   3938: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   3941: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   3944: aload_3
    //   3945: areturn
    //   3946: aload_0
    //   3947: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3950: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   3953: iload_1
    //   3954: invokeinterface 47 2 0
    //   3959: checkcast 49	java/util/Map
    //   3962: ldc 66
    //   3964: invokeinterface 54 2 0
    //   3969: checkcast 68	java/lang/String
    //   3972: ldc_w 325
    //   3975: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   3978: ifeq -2749 -> 1229
    //   3981: aload 11
    //   3983: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   3986: ifnull -2757 -> 1229
    //   3989: aload_0
    //   3990: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   3993: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   3996: iload_1
    //   3997: invokeinterface 47 2 0
    //   4002: checkcast 49	java/util/Map
    //   4005: ldc_w 274
    //   4008: invokeinterface 54 2 0
    //   4013: checkcast 309	android/graphics/Bitmap
    //   4016: astore_2
    //   4017: aload_2
    //   4018: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   4021: aload_2
    //   4022: invokevirtual 315	android/graphics/Bitmap:getWidth	()I
    //   4025: if_icmple +56 -> 4081
    //   4028: aload 11
    //   4030: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   4033: aload_0
    //   4034: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4037: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4040: ldc_w 316
    //   4043: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   4046: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   4049: aload 11
    //   4051: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   4054: aload_0
    //   4055: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4058: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4061: ldc_w 320
    //   4064: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   4067: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   4070: aload 11
    //   4072: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   4075: aload_2
    //   4076: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   4079: aload_3
    //   4080: areturn
    //   4081: aload 11
    //   4083: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   4086: aload_0
    //   4087: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4090: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4093: ldc_w 320
    //   4096: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   4099: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   4102: aload 11
    //   4104: getfield 227	com/baidu/ufosdk/ui/ce:c	Landroid/widget/ImageView;
    //   4107: aload_0
    //   4108: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4111: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4114: ldc_w 316
    //   4117: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   4120: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   4123: goto -53 -> 4070
    //   4126: iload 4
    //   4128: iconst_2
    //   4129: if_icmpne +283 -> 4412
    //   4132: aload 12
    //   4134: getfield 347	com/baidu/ufosdk/ui/cf:d	Landroid/widget/RelativeLayout;
    //   4137: iconst_0
    //   4138: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   4141: iload_1
    //   4142: ifne +43 -> 4185
    //   4145: aload 12
    //   4147: getfield 346	com/baidu/ufosdk/ui/cf:a	Landroid/widget/TextView;
    //   4150: aload_0
    //   4151: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4154: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4157: iload_1
    //   4158: invokeinterface 47 2 0
    //   4163: checkcast 49	java/util/Map
    //   4166: ldc -14
    //   4168: invokeinterface 54 2 0
    //   4173: checkcast 68	java/lang/String
    //   4176: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4179: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   4182: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4185: iload_1
    //   4186: ifeq +141 -> 4327
    //   4189: aload_0
    //   4190: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4193: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4196: iload_1
    //   4197: iconst_1
    //   4198: isub
    //   4199: invokeinterface 47 2 0
    //   4204: checkcast 49	java/util/Map
    //   4207: ldc -14
    //   4209: invokeinterface 54 2 0
    //   4214: checkcast 68	java/lang/String
    //   4217: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4220: lstore 5
    //   4222: aload_0
    //   4223: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4226: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4229: iload_1
    //   4230: invokeinterface 47 2 0
    //   4235: checkcast 49	java/util/Map
    //   4238: ldc -14
    //   4240: invokeinterface 54 2 0
    //   4245: checkcast 68	java/lang/String
    //   4248: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4251: lstore 7
    //   4253: lload 5
    //   4255: lload 7
    //   4257: lsub
    //   4258: ldc2_w 256
    //   4261: lcmp
    //   4262: ifgt +15 -> 4277
    //   4265: lload 7
    //   4267: lload 5
    //   4269: lsub
    //   4270: ldc2_w 256
    //   4273: lcmp
    //   4274: ifle +117 -> 4391
    //   4277: aload 12
    //   4279: getfield 346	com/baidu/ufosdk/ui/cf:a	Landroid/widget/TextView;
    //   4282: lload 7
    //   4284: invokestatic 259	com/baidu/ufosdk/util/i:b	(J)Ljava/lang/String;
    //   4287: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4290: lload 5
    //   4292: lload 7
    //   4294: lsub
    //   4295: ldc2_w 260
    //   4298: lcmp
    //   4299: ifgt +15 -> 4314
    //   4302: lload 7
    //   4304: lload 5
    //   4306: lsub
    //   4307: ldc2_w 260
    //   4310: lcmp
    //   4311: ifle +16 -> 4327
    //   4314: aload 12
    //   4316: getfield 346	com/baidu/ufosdk/ui/cf:a	Landroid/widget/TextView;
    //   4319: lload 7
    //   4321: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   4324: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4327: aload 12
    //   4329: getfield 348	com/baidu/ufosdk/ui/cf:b	Landroid/widget/ImageView;
    //   4332: new 263	android/graphics/drawable/BitmapDrawable
    //   4335: dup
    //   4336: aload_0
    //   4337: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4340: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4343: invokestatic 268	com/baidu/ufosdk/util/p:c	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   4346: invokespecial 271	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   4349: invokevirtual 272	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4352: aload_0
    //   4353: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4356: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4359: iload_1
    //   4360: invokeinterface 47 2 0
    //   4365: checkcast 49	java/util/Map
    //   4368: ldc_w 274
    //   4371: invokeinterface 54 2 0
    //   4376: checkcast 68	java/lang/String
    //   4379: astore_2
    //   4380: aload 12
    //   4382: getfield 373	com/baidu/ufosdk/ui/cf:c	Landroid/widget/TextView;
    //   4385: aload_2
    //   4386: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4389: aload_3
    //   4390: areturn
    //   4391: aload 12
    //   4393: getfield 347	com/baidu/ufosdk/ui/cf:d	Landroid/widget/RelativeLayout;
    //   4396: bipush 8
    //   4398: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   4401: goto -74 -> 4327
    //   4404: astore_2
    //   4405: aload_2
    //   4406: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   4409: goto -57 -> 4352
    //   4412: iload 4
    //   4414: iconst_3
    //   4415: if_icmpne +567 -> 4982
    //   4418: aload 9
    //   4420: getfield 382	com/baidu/ufosdk/ui/cd:d	Landroid/widget/RelativeLayout;
    //   4423: iconst_0
    //   4424: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   4427: iload_1
    //   4428: ifne +43 -> 4471
    //   4431: aload 9
    //   4433: getfield 381	com/baidu/ufosdk/ui/cd:a	Landroid/widget/TextView;
    //   4436: aload_0
    //   4437: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4440: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4443: iload_1
    //   4444: invokeinterface 47 2 0
    //   4449: checkcast 49	java/util/Map
    //   4452: ldc -14
    //   4454: invokeinterface 54 2 0
    //   4459: checkcast 68	java/lang/String
    //   4462: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4465: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   4468: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4471: iload_1
    //   4472: ifeq +141 -> 4613
    //   4475: aload_0
    //   4476: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4479: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4482: iload_1
    //   4483: iconst_1
    //   4484: isub
    //   4485: invokeinterface 47 2 0
    //   4490: checkcast 49	java/util/Map
    //   4493: ldc -14
    //   4495: invokeinterface 54 2 0
    //   4500: checkcast 68	java/lang/String
    //   4503: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4506: lstore 5
    //   4508: aload_0
    //   4509: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4512: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4515: iload_1
    //   4516: invokeinterface 47 2 0
    //   4521: checkcast 49	java/util/Map
    //   4524: ldc -14
    //   4526: invokeinterface 54 2 0
    //   4531: checkcast 68	java/lang/String
    //   4534: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   4537: lstore 7
    //   4539: lload 5
    //   4541: lload 7
    //   4543: lsub
    //   4544: ldc2_w 256
    //   4547: lcmp
    //   4548: ifgt +15 -> 4563
    //   4551: lload 7
    //   4553: lload 5
    //   4555: lsub
    //   4556: ldc2_w 256
    //   4559: lcmp
    //   4560: ifle +269 -> 4829
    //   4563: aload 9
    //   4565: getfield 381	com/baidu/ufosdk/ui/cd:a	Landroid/widget/TextView;
    //   4568: lload 7
    //   4570: invokestatic 259	com/baidu/ufosdk/util/i:b	(J)Ljava/lang/String;
    //   4573: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4576: lload 5
    //   4578: lload 7
    //   4580: lsub
    //   4581: ldc2_w 260
    //   4584: lcmp
    //   4585: ifgt +15 -> 4600
    //   4588: lload 7
    //   4590: lload 5
    //   4592: lsub
    //   4593: ldc2_w 260
    //   4596: lcmp
    //   4597: ifle +16 -> 4613
    //   4600: aload 9
    //   4602: getfield 381	com/baidu/ufosdk/ui/cd:a	Landroid/widget/TextView;
    //   4605: lload 7
    //   4607: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   4610: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4613: aconst_null
    //   4614: astore_2
    //   4615: aload_0
    //   4616: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   4619: invokevirtual 417	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4622: invokevirtual 421	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4625: astore 10
    //   4627: aload 10
    //   4629: astore_2
    //   4630: aload 10
    //   4632: aload_0
    //   4633: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   4636: invokevirtual 424	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4639: iconst_0
    //   4640: invokevirtual 430	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   4643: astore 11
    //   4645: aload 11
    //   4647: astore_2
    //   4648: aload 10
    //   4650: astore 11
    //   4652: aload_2
    //   4653: astore 10
    //   4655: aload 11
    //   4657: aload 10
    //   4659: invokevirtual 434	android/content/pm/PackageManager:getApplicationIcon	(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;
    //   4662: checkcast 263	android/graphics/drawable/BitmapDrawable
    //   4665: invokevirtual 438	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   4668: astore_2
    //   4669: aload 9
    //   4671: getfield 383	com/baidu/ufosdk/ui/cd:b	Landroid/widget/ImageView;
    //   4674: new 263	android/graphics/drawable/BitmapDrawable
    //   4677: dup
    //   4678: aload_2
    //   4679: invokespecial 271	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   4682: invokevirtual 272	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4685: aload 9
    //   4687: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4690: ifnull -3461 -> 1229
    //   4693: aload_0
    //   4694: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4697: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   4700: iload_1
    //   4701: invokeinterface 47 2 0
    //   4706: checkcast 49	java/util/Map
    //   4709: ldc_w 274
    //   4712: invokeinterface 54 2 0
    //   4717: checkcast 68	java/lang/String
    //   4720: astore_2
    //   4721: aload_2
    //   4722: ldc_w 333
    //   4725: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4728: ifne +13 -> 4741
    //   4731: aload_2
    //   4732: ldc_w 339
    //   4735: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4738: ifeq +123 -> 4861
    //   4741: invokestatic 287	com/baidu/ufosdk/util/a:a	()Lcom/baidu/ufosdk/util/a;
    //   4744: new 289	com/baidu/ufosdk/util/q
    //   4747: dup
    //   4748: aload_0
    //   4749: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4752: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4755: aload 9
    //   4757: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4760: aload_0
    //   4761: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4764: invokestatic 293	com/baidu/ufosdk/ui/FeedbackInputActivity:H	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Landroid/os/Handler;
    //   4767: invokespecial 441	com/baidu/ufosdk/util/q:<init>	(Landroid/content/Context;Landroid/widget/TextView;Landroid/os/Handler;)V
    //   4770: aload_2
    //   4771: invokevirtual 299	com/baidu/ufosdk/util/a:a	(Lcom/baidu/ufosdk/util/q;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   4774: astore_2
    //   4775: aload_2
    //   4776: ifnull -3547 -> 1229
    //   4779: new 443	android/text/style/ImageSpan
    //   4782: dup
    //   4783: aload_0
    //   4784: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4787: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   4790: aload_2
    //   4791: invokespecial 446	android/text/style/ImageSpan:<init>	(Landroid/content/Context;Landroid/graphics/Bitmap;)V
    //   4794: astore_2
    //   4795: new 448	android/text/SpannableString
    //   4798: dup
    //   4799: ldc_w 450
    //   4802: invokespecial 452	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   4805: astore 10
    //   4807: aload 10
    //   4809: aload_2
    //   4810: iconst_0
    //   4811: iconst_4
    //   4812: bipush 33
    //   4814: invokevirtual 456	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   4817: aload 9
    //   4819: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4822: aload 10
    //   4824: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4827: aload_3
    //   4828: areturn
    //   4829: aload 9
    //   4831: getfield 382	com/baidu/ufosdk/ui/cd:d	Landroid/widget/RelativeLayout;
    //   4834: bipush 8
    //   4836: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   4839: goto -226 -> 4613
    //   4842: astore 10
    //   4844: aconst_null
    //   4845: astore 10
    //   4847: aload_2
    //   4848: astore 11
    //   4850: goto -195 -> 4655
    //   4853: astore_2
    //   4854: aload_2
    //   4855: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   4858: goto -173 -> 4685
    //   4861: aload_2
    //   4862: ldc_w 458
    //   4865: invokevirtual 461	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4868: ifeq +103 -> 4971
    //   4871: aload_0
    //   4872: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4875: iconst_1
    //   4876: putfield 464	com/baidu/ufosdk/ui/FeedbackInputActivity:d	Z
    //   4879: new 466	android/text/SpannableStringBuilder
    //   4882: dup
    //   4883: aload_2
    //   4884: invokespecial 467	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   4887: astore 10
    //   4889: aload 10
    //   4891: new 469	android/text/style/ForegroundColorSpan
    //   4894: dup
    //   4895: ldc_w 470
    //   4898: invokespecial 472	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   4901: aload_2
    //   4902: invokevirtual 475	java/lang/String:length	()I
    //   4905: bipush 8
    //   4907: isub
    //   4908: aload_2
    //   4909: invokevirtual 475	java/lang/String:length	()I
    //   4912: iconst_4
    //   4913: isub
    //   4914: bipush 33
    //   4916: invokevirtual 476	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   4919: aload 9
    //   4921: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4924: aload 10
    //   4926: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4929: aload_0
    //   4930: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4933: invokestatic 480	com/baidu/ufosdk/ui/FeedbackInputActivity:I	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/ArrayList;
    //   4936: ifnonnull -3707 -> 1229
    //   4939: aload_0
    //   4940: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4943: new 304	java/util/ArrayList
    //   4946: dup
    //   4947: invokespecial 481	java/util/ArrayList:<init>	()V
    //   4950: invokestatic 484	com/baidu/ufosdk/ui/FeedbackInputActivity:a	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;Ljava/util/ArrayList;)V
    //   4953: aload_0
    //   4954: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   4957: invokestatic 480	com/baidu/ufosdk/ui/FeedbackInputActivity:I	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/ArrayList;
    //   4960: aload 9
    //   4962: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4965: invokevirtual 307	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4968: pop
    //   4969: aload_3
    //   4970: areturn
    //   4971: aload 9
    //   4973: getfield 398	com/baidu/ufosdk/ui/cd:c	Landroid/widget/TextView;
    //   4976: aload_2
    //   4977: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   4980: aload_3
    //   4981: areturn
    //   4982: iload 4
    //   4984: iconst_4
    //   4985: if_icmpne -3756 -> 1229
    //   4988: aload 10
    //   4990: getfield 406	com/baidu/ufosdk/ui/cc:d	Landroid/widget/RelativeLayout;
    //   4993: iconst_0
    //   4994: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   4997: iload_1
    //   4998: ifne +43 -> 5041
    //   5001: aload 10
    //   5003: getfield 405	com/baidu/ufosdk/ui/cc:a	Landroid/widget/TextView;
    //   5006: aload_0
    //   5007: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5010: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5013: iload_1
    //   5014: invokeinterface 47 2 0
    //   5019: checkcast 49	java/util/Map
    //   5022: ldc -14
    //   5024: invokeinterface 54 2 0
    //   5029: checkcast 68	java/lang/String
    //   5032: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5035: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   5038: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5041: iload_1
    //   5042: ifeq +141 -> 5183
    //   5045: aload_0
    //   5046: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5049: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5052: iload_1
    //   5053: iconst_1
    //   5054: isub
    //   5055: invokeinterface 47 2 0
    //   5060: checkcast 49	java/util/Map
    //   5063: ldc -14
    //   5065: invokeinterface 54 2 0
    //   5070: checkcast 68	java/lang/String
    //   5073: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5076: lstore 5
    //   5078: aload_0
    //   5079: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5082: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5085: iload_1
    //   5086: invokeinterface 47 2 0
    //   5091: checkcast 49	java/util/Map
    //   5094: ldc -14
    //   5096: invokeinterface 54 2 0
    //   5101: checkcast 68	java/lang/String
    //   5104: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5107: lstore 7
    //   5109: lload 5
    //   5111: lload 7
    //   5113: lsub
    //   5114: ldc2_w 256
    //   5117: lcmp
    //   5118: ifgt +15 -> 5133
    //   5121: lload 7
    //   5123: lload 5
    //   5125: lsub
    //   5126: ldc2_w 256
    //   5129: lcmp
    //   5130: ifle +387 -> 5517
    //   5133: aload 10
    //   5135: getfield 405	com/baidu/ufosdk/ui/cc:a	Landroid/widget/TextView;
    //   5138: lload 7
    //   5140: invokestatic 259	com/baidu/ufosdk/util/i:b	(J)Ljava/lang/String;
    //   5143: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5146: lload 5
    //   5148: lload 7
    //   5150: lsub
    //   5151: ldc2_w 260
    //   5154: lcmp
    //   5155: ifgt +15 -> 5170
    //   5158: lload 7
    //   5160: lload 5
    //   5162: lsub
    //   5163: ldc2_w 260
    //   5166: lcmp
    //   5167: ifle +16 -> 5183
    //   5170: aload 10
    //   5172: getfield 405	com/baidu/ufosdk/ui/cc:a	Landroid/widget/TextView;
    //   5175: lload 7
    //   5177: invokestatic 251	com/baidu/ufosdk/util/i:a	(J)Ljava/lang/String;
    //   5180: invokevirtual 255	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   5183: aconst_null
    //   5184: astore_2
    //   5185: aload_0
    //   5186: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   5189: invokevirtual 417	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   5192: invokevirtual 421	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   5195: astore 9
    //   5197: aload 9
    //   5199: astore_2
    //   5200: aload 9
    //   5202: aload_0
    //   5203: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   5206: invokevirtual 424	android/content/Context:getPackageName	()Ljava/lang/String;
    //   5209: iconst_0
    //   5210: invokevirtual 430	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   5213: astore 11
    //   5215: aload 11
    //   5217: astore_2
    //   5218: aload 9
    //   5220: astore 11
    //   5222: aload_2
    //   5223: astore 9
    //   5225: aload 11
    //   5227: aload 9
    //   5229: invokevirtual 434	android/content/pm/PackageManager:getApplicationIcon	(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;
    //   5232: checkcast 263	android/graphics/drawable/BitmapDrawable
    //   5235: invokevirtual 438	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   5238: astore_2
    //   5239: aload 10
    //   5241: getfield 407	com/baidu/ufosdk/ui/cc:b	Landroid/widget/ImageView;
    //   5244: new 263	android/graphics/drawable/BitmapDrawable
    //   5247: dup
    //   5248: aload_2
    //   5249: invokespecial 271	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   5252: invokevirtual 272	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   5255: aload_0
    //   5256: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5259: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5262: iload_1
    //   5263: invokeinterface 47 2 0
    //   5268: checkcast 49	java/util/Map
    //   5271: ldc 66
    //   5273: invokeinterface 54 2 0
    //   5278: checkcast 68	java/lang/String
    //   5281: ldc 70
    //   5283: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   5286: ifne +75 -> 5361
    //   5289: aload_0
    //   5290: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5293: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5296: iload_1
    //   5297: invokeinterface 47 2 0
    //   5302: checkcast 49	java/util/Map
    //   5305: ldc_w 274
    //   5308: invokeinterface 54 2 0
    //   5313: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   5316: ldc_w 333
    //   5319: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5322: ifne +39 -> 5361
    //   5325: aload_0
    //   5326: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5329: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5332: iload_1
    //   5333: invokeinterface 47 2 0
    //   5338: checkcast 49	java/util/Map
    //   5341: ldc_w 274
    //   5344: invokeinterface 54 2 0
    //   5349: invokevirtual 331	java/lang/Object:toString	()Ljava/lang/String;
    //   5352: ldc_w 339
    //   5355: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5358: ifeq +235 -> 5593
    //   5361: aload_0
    //   5362: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5365: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5368: iload_1
    //   5369: invokeinterface 47 2 0
    //   5374: checkcast 49	java/util/Map
    //   5377: ldc_w 274
    //   5380: invokeinterface 54 2 0
    //   5385: checkcast 68	java/lang/String
    //   5388: astore_2
    //   5389: aload 10
    //   5391: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5394: aload_0
    //   5395: getfield 17	com/baidu/ufosdk/ui/br:b	Landroid/content/Context;
    //   5398: ldc_w 276
    //   5401: invokestatic 279	com/baidu/ufosdk/util/p:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   5404: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   5407: invokestatic 287	com/baidu/ufosdk/util/a:a	()Lcom/baidu/ufosdk/util/a;
    //   5410: new 289	com/baidu/ufosdk/util/q
    //   5413: dup
    //   5414: aload_0
    //   5415: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5418: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5421: aload 10
    //   5423: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5426: aload_0
    //   5427: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5430: invokestatic 293	com/baidu/ufosdk/ui/FeedbackInputActivity:H	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Landroid/os/Handler;
    //   5433: invokespecial 296	com/baidu/ufosdk/util/q:<init>	(Landroid/content/Context;Landroid/widget/ImageView;Landroid/os/Handler;)V
    //   5436: aload_2
    //   5437: invokevirtual 299	com/baidu/ufosdk/util/a:a	(Lcom/baidu/ufosdk/util/q;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   5440: astore_2
    //   5441: aload_2
    //   5442: ifnull -4213 -> 1229
    //   5445: getstatic 302	com/baidu/ufosdk/ui/FeedbackInputActivity:a	Ljava/util/ArrayList;
    //   5448: aload_2
    //   5449: invokevirtual 307	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5452: pop
    //   5453: aload 10
    //   5455: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5458: aload_2
    //   5459: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   5462: aload_2
    //   5463: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   5466: aload_2
    //   5467: invokevirtual 315	android/graphics/Bitmap:getWidth	()I
    //   5470: if_icmple +79 -> 5549
    //   5473: aload 10
    //   5475: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5478: aload_0
    //   5479: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5482: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5485: ldc_w 316
    //   5488: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5491: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   5494: aload 10
    //   5496: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5499: aload_0
    //   5500: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5503: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5506: ldc_w 320
    //   5509: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5512: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   5515: aload_3
    //   5516: areturn
    //   5517: aload 10
    //   5519: getfield 406	com/baidu/ufosdk/ui/cc:d	Landroid/widget/RelativeLayout;
    //   5522: bipush 8
    //   5524: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
    //   5527: goto -344 -> 5183
    //   5530: astore 9
    //   5532: aconst_null
    //   5533: astore 9
    //   5535: aload_2
    //   5536: astore 11
    //   5538: goto -313 -> 5225
    //   5541: astore_2
    //   5542: aload_2
    //   5543: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   5546: goto -291 -> 5255
    //   5549: aload 10
    //   5551: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5554: aload_0
    //   5555: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5558: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5561: ldc_w 320
    //   5564: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5567: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   5570: aload 10
    //   5572: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5575: aload_0
    //   5576: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5579: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5582: ldc_w 316
    //   5585: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5588: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   5591: aload_3
    //   5592: areturn
    //   5593: aload_0
    //   5594: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5597: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5600: iload_1
    //   5601: invokeinterface 47 2 0
    //   5606: checkcast 49	java/util/Map
    //   5609: ldc 66
    //   5611: invokeinterface 54 2 0
    //   5616: checkcast 68	java/lang/String
    //   5619: ldc_w 325
    //   5622: invokevirtual 74	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   5625: ifeq -4396 -> 1229
    //   5628: aload 10
    //   5630: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5633: ifnull -4404 -> 1229
    //   5636: aload_0
    //   5637: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5640: invokestatic 27	com/baidu/ufosdk/ui/FeedbackInputActivity:p	(Lcom/baidu/ufosdk/ui/FeedbackInputActivity;)Ljava/util/List;
    //   5643: iload_1
    //   5644: invokeinterface 47 2 0
    //   5649: checkcast 49	java/util/Map
    //   5652: ldc_w 274
    //   5655: invokeinterface 54 2 0
    //   5660: checkcast 309	android/graphics/Bitmap
    //   5663: astore_2
    //   5664: aload_2
    //   5665: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   5668: aload_2
    //   5669: invokevirtual 315	android/graphics/Bitmap:getWidth	()I
    //   5672: if_icmple +56 -> 5728
    //   5675: aload 10
    //   5677: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5680: aload_0
    //   5681: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5684: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5687: ldc_w 316
    //   5690: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5693: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   5696: aload 10
    //   5698: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5701: aload_0
    //   5702: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5705: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5708: ldc_w 320
    //   5711: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5714: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   5717: aload 10
    //   5719: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5722: aload_2
    //   5723: invokevirtual 282	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   5726: aload_3
    //   5727: areturn
    //   5728: aload 10
    //   5730: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5733: aload_0
    //   5734: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5737: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5740: ldc_w 320
    //   5743: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5746: invokevirtual 319	android/widget/ImageView:setMaxWidth	(I)V
    //   5749: aload 10
    //   5751: getfield 411	com/baidu/ufosdk/ui/cc:c	Landroid/widget/ImageView;
    //   5754: aload_0
    //   5755: getfield 12	com/baidu/ufosdk/ui/br:a	Lcom/baidu/ufosdk/ui/FeedbackInputActivity;
    //   5758: invokevirtual 112	com/baidu/ufosdk/ui/FeedbackInputActivity:getApplicationContext	()Landroid/content/Context;
    //   5761: ldc_w 316
    //   5764: invokestatic 155	com/baidu/ufosdk/util/i:a	(Landroid/content/Context;F)I
    //   5767: invokevirtual 323	android/widget/ImageView:setMaxHeight	(I)V
    //   5770: goto -53 -> 5717
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5773	0	this	br
    //   0	5773	1	paramInt	int
    //   0	5773	2	paramView	android.view.View
    //   0	5773	3	paramViewGroup	android.view.ViewGroup
    //   71	4915	4	i	int
    //   909	4252	5	l1	long
    //   940	4236	7	l2	long
    //   156	5072	9	localObject1	Object
    //   5530	1	9	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   5533	1	9	localObject2	Object
    //   74	4749	10	localObject3	Object
    //   4842	1	10	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   4845	905	10	localSpannableStringBuilder	android.text.SpannableStringBuilder
    //   119	5418	11	localObject4	Object
    //   190	3521	12	localObject5	Object
    //   3723	3	12	localException1	Exception
    //   3762	630	12	localObject6	Object
    //   77	2789	13	localObject7	Object
    //   2961	912	13	localException2	Exception
    //   83	2036	14	localObject8	Object
    //   2214	1651	14	localException3	Exception
    //   80	634	15	localObject9	Object
    //   1485	2384	15	localException4	Exception
    //   611	112	16	localImageView1	android.widget.ImageView
    //   1495	3	16	localException5	Exception
    //   2074	38	16	localLayoutParams1	android.widget.RelativeLayout.LayoutParams
    //   2224	3	16	localIOException1	java.io.IOException
    //   2234	3	16	localException6	Exception
    //   2821	38	16	localLayoutParams2	android.widget.RelativeLayout.LayoutParams
    //   2971	3	16	localIOException2	java.io.IOException
    //   2981	3	16	localException7	Exception
    //   3512	112	16	localImageView2	android.widget.ImageView
    //   3733	3	16	localException8	Exception
    //   659	2958	17	localLayoutParams3	android.widget.RelativeLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   192	209	1485	java/lang/Exception
    //   524	600	1495	java/lang/Exception
    //   1591	1608	2214	java/lang/Exception
    //   1948	1965	2224	java/io/IOException
    //   1948	1965	2234	java/lang/Exception
    //   2330	2347	2961	java/lang/Exception
    //   2663	2681	2971	java/io/IOException
    //   2663	2681	2981	java/lang/Exception
    //   3091	3108	3723	java/lang/Exception
    //   3424	3501	3733	java/lang/Exception
    //   1016	1041	3894	java/lang/Exception
    //   4327	4352	4404	java/lang/Exception
    //   4615	4627	4842	android/content/pm/PackageManager$NameNotFoundException
    //   4630	4645	4842	android/content/pm/PackageManager$NameNotFoundException
    //   4669	4685	4853	java/lang/Exception
    //   5185	5197	5530	android/content/pm/PackageManager$NameNotFoundException
    //   5200	5215	5530	android/content/pm/PackageManager$NameNotFoundException
    //   5239	5255	5541	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */