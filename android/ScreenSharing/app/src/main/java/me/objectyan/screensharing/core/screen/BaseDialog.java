package me.objectyan.screensharing.core.screen;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;

public abstract class BaseDialog extends FrameLayout  {

    protected static final String f3637a = "BaseDialog";

    protected MsgBaseHandler f3638b;

    protected Context f3639c;

    protected boolean f3640d;

    private OnDialogListener f3641e;

    private OnDialogCancelListener f3642f;

    private boolean f3643g;

    //
    class C12641 extends MsgBaseHandler {

        final  BaseDialog f3631a;

        C12641(BaseDialog this$0) {
            this.f3631a = this$0;
        }

        public void careAbout() {
            addMsg(CommonParams.hb);
            addMsg(4001);
            addMsg(4002);
            addMsg(4003);
            addMsg(4004);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case CommonParams.hb /*4140*/:
                    if (this.f3631a.isShown()) {
                        this.f3631a.mo1526d();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    //
    public enum C1265a {
        Center,
        Right,
        Bottom,
        left
    }


    protected abstract View mo1528a();


    protected abstract void mo1529b();


    public abstract void mo1530f();

    public BaseDialog(Context context) {
        this(context, null);
    }

    public BaseDialog(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3638b = new C12641(this);
        this.f3643g = false;
        this.f3640d = true;
        this.f3639c = context;
        addView(mo1528a(), mo1630i());
        mo1529b();
    }


    private LayoutParams mo1630i() {
        int customWidth;
        int i = -1;
        LayoutParams layoutParams = generateDefaultLayoutParams();
        layoutParams.gravity = 17;
        if (getCustomWidth() > 0) {
            customWidth = getCustomWidth();
        } else {
            customWidth = -1;
        }
        layoutParams.width = customWidth;
        if (getCustomHeight() > 0) {
            i = getCustomHeight();
        }
        layoutParams.height = i;
        return layoutParams;
    }

    protected int getCustomWidth() {
        return 0;
    }

    public int getCustomHeight() {
        return 0;
    }


    public void mo1525a(OnDialogListener listener) {
        this.f3640d = false;
        this.f3641e = listener;
        MsgHandlerCenter.registerMessageHandler(this.f3638b);
    }


    public void mo1629c() {
        if (!this.f3640d) {
            if (this.f3642f != null) {
                this.f3642f.onCancel();
            }
            mo1526d();
        }
    }


    public void mo1526d() {
        if (!this.f3640d) {
            this.f3640d = true;
            if (this.f3641e != null) {
                this.f3641e.dismissDialog(this);
            }
            MsgHandlerCenter.unRegisterMessageHandler(this.f3638b);
            mo1527g();
        }
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        this.f3643g = cancel;
    }


    public boolean m4475e() {
        return this.f3643g;
    }


    public void mo1527g() {
    }

    public void setOnDialogCancelListener(OnDialogCancelListener listener) {
        this.f3642f = listener;
    }


    public boolean m4478h() {
        return this.f3640d;
    }
}
