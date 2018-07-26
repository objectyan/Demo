package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class TrackStatisticBar extends LinearLayout implements OnClickListener {
    private State firstItem = State.NONE;
    private boolean isSingleItem = false;
    private State lastItem = State.NONE;
    private View mAccelerateRootView;
    private TextView mAccelerateTextView;
    private View mBrakeRootView;
    private TextView mBrakeTextView;
    private TextView mCaptionAccelerateTextView;
    private TextView mCaptionBrakeTextView;
    private TextView mCaptionSpeedTextView;
    private TextView mCaptionTurnTextView;
    private IBarClickListener mClickListener = null;
    private View mSpeedRootView;
    private TextView mSpeedTextView;
    private State mState = State.NONE;
    private View mTurnRootView;
    private TextView mTurnTextView;

    public interface IBarClickListener {
        void onAccelerate();

        void onBrake();

        void onSpeed();

        void onTurn();
    }

    private enum State {
        NONE,
        SPEED,
        BRAKE,
        TURN,
        ACCELERATE
    }

    public TrackStatisticBar(Context context) {
        super(context);
    }

    public TrackStatisticBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBarClickListener(IBarClickListener listener) {
        this.mClickListener = listener;
    }

    public void init(int speedNum, int brakeNum, int turnNum, int accelerateNum) {
        this.mState = State.NONE;
        this.isSingleItem = false;
        this.firstItem = State.NONE;
        this.lastItem = State.NONE;
        if (speedNum == 0 && brakeNum == 0 && turnNum == 0 && accelerateNum == 0) {
            setVisibility(8);
            return;
        }
        LogUtil.m15791e("TrackStatisticBar", "init: -->> speedNum: " + speedNum + ", brakeNum: " + brakeNum + ", turnNum: " + turnNum + ", accelerateNum: " + accelerateNum);
        if (speedNum < 0) {
            speedNum = 0;
        }
        if (brakeNum < 0) {
            brakeNum = 0;
        }
        if (turnNum < 0) {
            turnNum = 0;
        }
        if (accelerateNum < 0) {
            accelerateNum = 0;
        }
        if (((speedNum + brakeNum) + turnNum) + accelerateNum == 1) {
            this.isSingleItem = true;
        }
        this.mSpeedTextView.setText("");
        this.mBrakeTextView.setText("");
        this.mTurnTextView.setText("");
        this.mAccelerateTextView.setText("");
        this.mSpeedRootView.setVisibility(0);
        this.mBrakeRootView.setVisibility(0);
        this.mTurnRootView.setVisibility(0);
        this.mAccelerateRootView.setVisibility(0);
        setVisibility(0);
        if (speedNum > 0) {
            this.mSpeedTextView.setText("" + speedNum);
            this.firstItem = State.SPEED;
            this.lastItem = State.SPEED;
        }
        if (brakeNum > 0) {
            this.mBrakeTextView.setText("" + brakeNum);
            if (this.firstItem == State.NONE) {
                this.firstItem = State.BRAKE;
            }
            this.lastItem = State.BRAKE;
        }
        if (turnNum > 0) {
            this.mTurnTextView.setText("" + turnNum);
            if (this.firstItem == State.NONE) {
                this.firstItem = State.TURN;
            }
            this.lastItem = State.TURN;
        }
        if (accelerateNum > 0) {
            this.mAccelerateTextView.setText("" + accelerateNum);
            if (this.firstItem == State.NONE) {
                this.firstItem = State.ACCELERATE;
            }
            this.lastItem = State.ACCELERATE;
        }
        resetViews();
        action(this.firstItem, true);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == C4048R.id.ll_speed) {
            action(State.SPEED);
        } else if (id == C4048R.id.ll_brake) {
            action(State.BRAKE);
        } else if (id == C4048R.id.ll_turn) {
            action(State.TURN);
        } else if (id == C4048R.id.ll_accelerate) {
            action(State.ACCELERATE);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mSpeedRootView = findViewById(C4048R.id.ll_speed);
        this.mBrakeRootView = findViewById(C4048R.id.ll_brake);
        this.mTurnRootView = findViewById(C4048R.id.ll_turn);
        this.mAccelerateRootView = findViewById(C4048R.id.ll_accelerate);
        this.mSpeedRootView.setOnClickListener(this);
        this.mBrakeRootView.setOnClickListener(this);
        this.mTurnRootView.setOnClickListener(this);
        this.mAccelerateRootView.setOnClickListener(this);
        this.mSpeedTextView = (TextView) findViewById(C4048R.id.tv_speed);
        this.mBrakeTextView = (TextView) findViewById(C4048R.id.tv_brake);
        this.mTurnTextView = (TextView) findViewById(C4048R.id.tv_turn);
        this.mAccelerateTextView = (TextView) findViewById(C4048R.id.tv_accelerate);
        this.mCaptionSpeedTextView = (TextView) findViewById(C4048R.id.tv_caption_speed);
        this.mCaptionBrakeTextView = (TextView) findViewById(C4048R.id.tv_caption_brake);
        this.mCaptionTurnTextView = (TextView) findViewById(C4048R.id.tv_caption_turn);
        this.mCaptionAccelerateTextView = (TextView) findViewById(C4048R.id.tv_caption_accelerate);
    }

    private void action(State state) {
        action(state, false);
    }

    private int getPropriateResId(State currentState, boolean selected) {
        if (selected) {
            return C4048R.drawable.nsdk_navi_result_statistics_single_item_bg_selected;
        }
        return C4048R.drawable.nsdk_navi_result_statistics_single_item_bg_normal;
    }

    private void action(State state, boolean autoInvoke) {
        if (state != this.mState) {
            this.mState = state;
            if (!autoInvoke) {
                resetViews();
            }
            int resId = getPropriateResId(state, true);
            switch (state) {
                case SPEED:
                    this.mSpeedRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(resId));
                    this.mSpeedTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    this.mCaptionSpeedTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    if (this.mClickListener != null) {
                        this.mClickListener.onSpeed();
                        return;
                    }
                    return;
                case BRAKE:
                    this.mBrakeRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(resId));
                    this.mBrakeTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    this.mCaptionBrakeTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    if (this.mClickListener != null) {
                        this.mClickListener.onBrake();
                        return;
                    }
                    return;
                case TURN:
                    this.mTurnRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(resId));
                    this.mTurnTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    this.mCaptionTurnTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    if (this.mClickListener != null) {
                        this.mClickListener.onTurn();
                        return;
                    }
                    return;
                case ACCELERATE:
                    this.mAccelerateRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(resId));
                    this.mAccelerateTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    this.mCaptionAccelerateTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    if (this.mClickListener != null) {
                        this.mClickListener.onAccelerate();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void resetViews() {
        if (this.mSpeedTextView.getText().length() > 0) {
            this.mSpeedRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(getPropriateResId(State.SPEED, false)));
        } else {
            this.mSpeedRootView.setVisibility(8);
        }
        if (this.mBrakeTextView.getText().length() > 0) {
            this.mBrakeRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(getPropriateResId(State.BRAKE, false)));
        } else {
            this.mBrakeRootView.setVisibility(8);
        }
        if (this.mTurnTextView.getText().length() > 0) {
            this.mTurnRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(getPropriateResId(State.TURN, false)));
        } else {
            this.mTurnRootView.setVisibility(8);
        }
        if (this.mAccelerateTextView.getText().length() > 0) {
            this.mAccelerateRootView.setBackgroundDrawable(JarUtils.getResources().getDrawable(getPropriateResId(State.ACCELERATE, false)));
        } else {
            this.mAccelerateRootView.setVisibility(8);
        }
        int fontColor = Color.parseColor("#888888");
        this.mSpeedTextView.setTextColor(fontColor);
        this.mCaptionSpeedTextView.setTextColor(fontColor);
        this.mBrakeTextView.setTextColor(fontColor);
        this.mCaptionBrakeTextView.setTextColor(fontColor);
        this.mTurnTextView.setTextColor(fontColor);
        this.mCaptionTurnTextView.setTextColor(fontColor);
        this.mAccelerateTextView.setTextColor(fontColor);
        this.mCaptionAccelerateTextView.setTextColor(fontColor);
    }
}
