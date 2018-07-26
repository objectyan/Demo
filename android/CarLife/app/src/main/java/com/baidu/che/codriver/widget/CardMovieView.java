package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.protocol.data.nlp.CardMovieData;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2694a;
import com.baidu.che.codriver.util.C2714a;
import com.baidu.che.codriver.util.C2725h;

public class CardMovieView extends LinearLayout {
    /* renamed from: a */
    public static final String f9389a = CardMovieView.class.getSimpleName();
    /* renamed from: b */
    private TextView f9390b;
    /* renamed from: c */
    private TextView f9391c;
    /* renamed from: d */
    private TextView f9392d;
    /* renamed from: e */
    private TextView f9393e;
    /* renamed from: f */
    private TextView f9394f;
    /* renamed from: g */
    private NetworkImageView f9395g;
    /* renamed from: h */
    private Context f9396h;

    public CardMovieView(Context context) {
        super(context, null);
        this.f9396h = context;
    }

    public CardMovieView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.f9396h = context;
    }

    public CardMovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f9396h = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m10845a();
    }

    /* renamed from: a */
    private void m10845a() {
        this.f9390b = (TextView) findViewById(C0965R.id.movie_title);
        this.f9391c = (TextView) findViewById(C0965R.id.movie_time);
        this.f9392d = (TextView) findViewById(C0965R.id.movie_type_content);
        this.f9393e = (TextView) findViewById(C0965R.id.movie_direct_content);
        this.f9394f = (TextView) findViewById(C0965R.id.movie_actor_content);
        this.f9395g = (NetworkImageView) findViewById(C0965R.id.movie_post);
    }

    /* renamed from: a */
    public void m10846a(C2549b model) {
        C2725h.m10207b(f9389a, "updateCardMovieInfo");
        CardMovieData cardMovieResult = ((C2694a) model).f8810a;
        try {
            int i;
            if (cardMovieResult.name != null) {
                this.f9390b.setText(cardMovieResult.name);
            }
            if (cardMovieResult.showTime != null) {
                this.f9391c.setText(cardMovieResult.showTime);
            }
            String movieTemp = "";
            if (cardMovieResult.type != null) {
                for (i = 0; i < cardMovieResult.type.size(); i++) {
                    movieTemp = movieTemp + ((String) cardMovieResult.type.get(i)) + "/";
                }
            } else {
                movieTemp = "暂无数据";
            }
            this.f9392d.setText(movieTemp);
            if (cardMovieResult.director != null) {
                movieTemp = "";
                for (i = 0; i < cardMovieResult.director.size(); i++) {
                    movieTemp = movieTemp + ((String) cardMovieResult.director.get(i)) + "/";
                }
            } else {
                movieTemp = "暂无数据";
            }
            this.f9393e.setText(movieTemp);
            if (cardMovieResult.actor != null) {
                movieTemp = "";
                for (i = 0; i < cardMovieResult.actor.size(); i++) {
                    movieTemp = movieTemp + ((String) cardMovieResult.actor.get(i)) + "/";
                }
            } else {
                movieTemp = "暂无数据";
            }
            this.f9394f.setText(movieTemp);
            this.f9395g.setImageUrl(cardMovieResult.post, C2714a.m10135a());
        } catch (NullPointerException mNull) {
            C2725h.m10214e("ConversationAdapter", mNull.getMessage().toString());
        }
    }
}
