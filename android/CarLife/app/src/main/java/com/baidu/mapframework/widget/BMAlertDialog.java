package com.baidu.mapframework.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public class BMAlertDialog extends Dialog implements DialogInterface, OnClickListener {
    /* renamed from: a */
    private static final int f19315a = 14;
    /* renamed from: b */
    private static final int f19316b = 1;
    /* renamed from: c */
    private LinearLayout f19317c;
    /* renamed from: d */
    private ImageView f19318d;
    /* renamed from: e */
    private TextView f19319e;
    /* renamed from: f */
    private LinearLayout f19320f;
    /* renamed from: g */
    private TextView f19321g;
    /* renamed from: h */
    private RelativeLayout f19322h;
    /* renamed from: i */
    private LinearLayout f19323i;
    /* renamed from: j */
    private Button f19324j;
    /* renamed from: k */
    private Button f19325k;
    /* renamed from: l */
    private Builder f19326l;
    /* renamed from: m */
    private LinearLayout f19327m;

    public static class Builder {
        public static final int HILIGHTED_TEXT_COLOR = -15564033;
        /* renamed from: a */
        private int f19292a;
        /* renamed from: b */
        private CharSequence f19293b;
        /* renamed from: c */
        private CharSequence f19294c;
        /* renamed from: d */
        private int f19295d;
        /* renamed from: e */
        private CharSequence f19296e;
        /* renamed from: f */
        private CharSequence f19297f;
        /* renamed from: g */
        private String[] f19298g;
        /* renamed from: h */
        private ListAdapter f19299h;
        /* renamed from: i */
        private boolean[] f19300i;
        /* renamed from: j */
        private boolean f19301j = false;
        /* renamed from: k */
        private boolean f19302k = true;
        /* renamed from: l */
        private boolean f19303l = false;
        /* renamed from: m */
        private boolean f19304m = false;
        /* renamed from: n */
        private DialogInterface.OnClickListener f19305n;
        /* renamed from: o */
        private DialogInterface.OnClickListener f19306o;
        /* renamed from: p */
        private OnDismissListener f19307p;
        /* renamed from: q */
        private OnCancelListener f19308q;
        /* renamed from: r */
        private OnKeyListener f19309r;
        /* renamed from: s */
        private OnMultiChoiceClickListener f19310s;
        /* renamed from: t */
        private DialogInterface.OnClickListener f19311t;
        /* renamed from: u */
        private View f19312u;
        /* renamed from: v */
        private Context f19313v;
        /* renamed from: w */
        private boolean f19314w = false;

        private class MultiChoiceAdapter extends BaseAdapter {
            /* renamed from: a */
            final /* synthetic */ Builder f19291a;

            private MultiChoiceAdapter(Builder builder) {
                this.f19291a = builder;
            }

            public int getCount() {
                if (this.f19291a.f19298g != null) {
                    return this.f19291a.f19298g.length;
                }
                return 0;
            }

            public Object getItem(int position) {
                if (this.f19291a.f19298g == null || this.f19291a.f19298g.length <= position) {
                    return null;
                }
                return this.f19291a.f19298g[position];
            }

            public long getItemId(int position) {
                return (long) position;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(this.f19291a.f19313v, C0965R.layout.alertdialog_checkbox, null);
                }
                TextView tv = (TextView) convertView.findViewById(C0965R.id.checkbox_content);
                ImageView iv = (ImageView) convertView.findViewById(C0965R.id.checkbox_image);
                if (this.f19291a.f19298g != null && this.f19291a.f19298g.length > position) {
                    tv.setText(this.f19291a.f19298g[position]);
                }
                if (this.f19291a.f19300i != null && this.f19291a.f19300i.length > position) {
                    if (this.f19291a.f19300i[position]) {
                        iv.setImageResource(C0965R.drawable.gps_wifi_hint_checkbox_selected);
                        iv.setTag(Boolean.valueOf(true));
                    } else {
                        iv.setImageResource(C0965R.drawable.gps_wifi_hint_checkbox_normal);
                        iv.setTag(Boolean.valueOf(false));
                    }
                }
                return convertView;
            }
        }

        public Builder(Context context) {
            this.f19313v = context;
        }

        public Context getContext() {
            return this.f19313v;
        }

        public Builder setIcon(int resource) {
            this.f19292a = resource;
            return this;
        }

        public Builder setTitle(int titleId) {
            this.f19293b = this.f19313v.getText(titleId);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.f19293b = title;
            return this;
        }

        public Builder setContentCenter(boolean center) {
            this.f19314w = center;
            return this;
        }

        public Builder setMessage(int messageId) {
            this.f19294c = this.f19313v.getText(messageId);
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.f19294c = message;
            return this;
        }

        public Builder setMessageGravity(int gravity) {
            this.f19295d = gravity;
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            this.f19296e = this.f19313v.getText(textId);
            this.f19305n = listener;
            return this;
        }

        public Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.f19296e = text;
            this.f19305n = listener;
            return this;
        }

        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            this.f19297f = this.f19313v.getText(textId);
            this.f19306o = listener;
            return this;
        }

        public Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
            this.f19297f = text;
            this.f19306o = listener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.f19302k = cancelable;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f19308q = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f19307p = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f19309r = onKeyListener;
            return this;
        }

        public Builder setView(View view) {
            if (view != null) {
                this.f19312u = view;
            }
            return this;
        }

        public Builder setItems(String[] array, DialogInterface.OnClickListener listener) {
            if (array != null) {
                this.f19298g = (String[]) array.clone();
            }
            this.f19311t = listener;
            return this;
        }

        public Builder setAdapter(ListAdapter adapter, DialogInterface.OnClickListener listener) {
            this.f19299h = adapter;
            this.f19311t = listener;
            return this;
        }

        public Builder setMultiChoiceItems(String[] array, boolean[] checks, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f19298g = (String[]) array.clone();
            this.f19300i = (boolean[]) checks.clone();
            this.f19310s = onMultiChoiceClickListener;
            this.f19301j = true;
            return this;
        }

        public Builder setPositiveHilighted(boolean hilight) {
            this.f19303l = hilight;
            return this;
        }

        public Builder setNegativeHilighted(boolean hilight) {
            this.f19304m = hilight;
            return this;
        }

        public BMAlertDialog show() {
            BMAlertDialog dialog = create();
            dialog.show();
            return dialog;
        }

        public BMAlertDialog create() {
            final BMAlertDialog dialog = new BMAlertDialog(this, C0965R.style.BMDialog);
            if (this.f19293b != null) {
                dialog.f19319e.setText(this.f19293b);
                dialog.f19319e.setVisibility(0);
                dialog.f19327m.setVisibility(0);
            } else {
                dialog.f19319e.setVisibility(8);
                dialog.f19327m.setVisibility(8);
            }
            if (this.f19292a > 0) {
                dialog.f19318d.setImageResource(this.f19292a);
                dialog.f19318d.setVisibility(0);
            } else {
                dialog.f19318d.setVisibility(8);
            }
            if (this.f19294c != null) {
                dialog.f19321g.setText(this.f19294c);
                if (this.f19295d > 0) {
                    dialog.f19321g.setGravity(this.f19295d);
                }
                dialog.f19320f.setVisibility(0);
                dialog.f19322h.setVisibility(8);
            } else if (this.f19298g != null && this.f19298g.length > 0) {
                listView = (ListView) View.inflate(this.f19313v, C0965R.layout.alertdialog_listview, null);
                if (this.f19301j) {
                    listView.setAdapter(new MultiChoiceAdapter());
                    if (this.f19310s != null) {
                        listView.setOnItemClickListener(new OnItemClickListener(this) {
                            /* renamed from: b */
                            final /* synthetic */ Builder f19286b;

                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                boolean isChecked;
                                ImageView iv = (ImageView) view.findViewById(C0965R.id.checkbox_image);
                                if (((Boolean) iv.getTag()).booleanValue()) {
                                    isChecked = false;
                                } else {
                                    isChecked = true;
                                }
                                this.f19286b.f19300i[position] = isChecked;
                                if (isChecked) {
                                    iv.setImageResource(C0965R.drawable.gps_wifi_hint_checkbox_selected);
                                    iv.setTag(Boolean.valueOf(true));
                                } else {
                                    iv.setImageResource(C0965R.drawable.gps_wifi_hint_checkbox_normal);
                                    iv.setTag(Boolean.valueOf(false));
                                }
                                this.f19286b.f19310s.onClick(dialog, position, isChecked);
                            }
                        });
                    }
                } else {
                    listView.setAdapter(new ArrayAdapter(this.f19313v, this.f19314w ? C0965R.layout.alertdialog_textview_center : C0965R.layout.alertdialog_textview, this.f19298g));
                    if (this.f19311t != null) {
                        listView.setOnItemClickListener(new OnItemClickListener(this) {
                            /* renamed from: b */
                            final /* synthetic */ Builder f19288b;

                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                this.f19288b.f19311t.onClick(dialog, position);
                                dialog.dismiss();
                            }
                        });
                    }
                }
                dialog.f19322h.removeAllViews();
                dialog.f19322h.addView(listView, new LayoutParams(-1, -2));
                dialog.f19322h.setVisibility(0);
                dialog.f19320f.setVisibility(8);
            } else if (this.f19299h != null) {
                listView = (ListView) View.inflate(this.f19313v, C0965R.layout.alertdialog_listview, null);
                listView.setAdapter(this.f19299h);
                if (this.f19311t != null) {
                    listView.setOnItemClickListener(new OnItemClickListener(this) {
                        /* renamed from: b */
                        final /* synthetic */ Builder f19290b;

                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            this.f19290b.f19311t.onClick(dialog, position);
                            dialog.dismiss();
                        }
                    });
                }
                dialog.f19322h.removeAllViews();
                dialog.f19322h.addView(listView, new LayoutParams(-1, -2));
                dialog.f19322h.setVisibility(0);
                dialog.f19320f.setVisibility(8);
            } else if (this.f19312u != null) {
                dialog.f19322h.removeAllViews();
                dialog.f19322h.addView(this.f19312u, new LayoutParams(-1, -2));
                dialog.f19322h.setVisibility(0);
                dialog.f19320f.setVisibility(8);
            } else {
                dialog.f19320f.setVisibility(8);
                dialog.f19322h.setVisibility(8);
            }
            dialog.setOnCancelListener(this.f19308q);
            dialog.setOnDismissListener(this.f19307p);
            if (this.f19309r != null) {
                dialog.setOnKeyListener(this.f19309r);
            }
            if (this.f19296e != null) {
                dialog.f19324j.setText(this.f19296e);
                dialog.f19324j.setOnClickListener(dialog);
                dialog.f19324j.setVisibility(0);
                if (this.f19303l) {
                    dialog.f19324j.setTextColor(HILIGHTED_TEXT_COLOR);
                }
            } else {
                dialog.f19324j.setVisibility(8);
            }
            if (this.f19297f != null) {
                dialog.f19325k.setText(this.f19297f);
                dialog.f19325k.setOnClickListener(dialog);
                dialog.f19325k.setVisibility(0);
                if (this.f19304m) {
                    dialog.f19325k.setTextColor(HILIGHTED_TEXT_COLOR);
                }
            } else {
                dialog.f19325k.setVisibility(8);
            }
            if (dialog.f19324j.getVisibility() == 0 && dialog.f19325k.getVisibility() == 0) {
                dialog.f19323i.setVisibility(0);
                if (m15239b()) {
                    m15235a(dialog.f19324j, C0965R.drawable.alert_dialog_rightbutton);
                    m15235a(dialog.f19325k, C0965R.drawable.alert_dialog_leftbutton);
                } else {
                    m15235a(dialog.f19324j, C0965R.drawable.alert_dialog_leftbutton);
                    m15235a(dialog.f19325k, C0965R.drawable.alert_dialog_rightbutton);
                }
            } else if (dialog.f19324j.getVisibility() == 0 || dialog.f19325k.getVisibility() == 0) {
                dialog.f19323i.setVisibility(0);
                m15235a(dialog.f19324j, C0965R.drawable.alert_dialog_midbutton);
                m15235a(dialog.f19325k, C0965R.drawable.alert_dialog_midbutton);
            } else {
                dialog.f19323i.setVisibility(8);
                m15235a(dialog.f19320f, C0965R.drawable.alert_dialog_message_bg2);
                m15235a(dialog.f19322h, C0965R.drawable.alert_dialog_message_bg2);
            }
            dialog.setCancelable(this.f19302k);
            return dialog;
        }

        /* renamed from: a */
        private void m15235a(View button, int resource) {
            if (button != null) {
                try {
                    button.setBackgroundResource(resource);
                } catch (Exception e) {
                    button.setBackgroundResource(0);
                }
            }
        }

        /* renamed from: b */
        private static boolean m15239b() {
            return VERSION.SDK_INT >= 14;
        }
    }

    private BMAlertDialog(Context context) {
        super(context);
    }

    public BMAlertDialog(Builder builder, int theme) {
        super(builder.getContext(), theme);
        this.f19326l = builder;
        if (Builder.m15239b()) {
            this.f19317c = (LinearLayout) m15245a(builder, C0965R.layout.bm_alert_dialog2);
        } else {
            this.f19317c = (LinearLayout) m15245a(builder, C0965R.layout.bm_alert_dialog);
        }
        if (this.f19317c != null) {
            this.f19317c.setMinimumWidth(SysOSAPIv2.getInstance().getScreenWidth());
            this.f19318d = (ImageView) this.f19317c.findViewById(C0965R.id.alertIcon);
            this.f19319e = (TextView) this.f19317c.findViewById(C0965R.id.alertTitle);
            this.f19320f = (LinearLayout) this.f19317c.findViewById(C0965R.id.contentPanel);
            this.f19321g = (TextView) this.f19317c.findViewById(C0965R.id.message);
            this.f19322h = (RelativeLayout) this.f19317c.findViewById(C0965R.id.customPanel);
            this.f19323i = (LinearLayout) this.f19317c.findViewById(C0965R.id.buttonPanel);
            this.f19324j = (Button) this.f19317c.findViewById(C0965R.id.positiveButton);
            this.f19325k = (Button) this.f19317c.findViewById(C0965R.id.negativeButton);
            this.f19327m = (LinearLayout) this.f19317c.findViewById(C0965R.id.topPanel);
        }
    }

    /* renamed from: a */
    private View m15245a(Builder builder, int layout) {
        View view = null;
        try {
            view = LayoutInflater.from(builder.getContext()).inflate(layout, null);
        } catch (Exception e) {
            try {
                view = LayoutInflater.from(builder.getContext()).inflate(layout, null);
            } catch (Exception e2) {
            }
        }
        return view;
    }

    public void show() {
        if (this.f19317c != null && m15247a(this.f19326l.getContext())) {
            setContentView(this.f19317c, new LayoutParams(-1, -2));
            super.show();
        }
    }

    public void updateMessage(CharSequence message) {
        if (this.f19321g != null && message != null) {
            this.f19321g.setText(message);
        }
    }

    /* renamed from: a */
    private boolean m15247a(Context activity) {
        return (activity == null || ((Activity) activity).isFinishing()) ? false : true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.positiveButton:
                if (this.f19326l.f19305n != null) {
                    this.f19326l.f19305n.onClick(this, -1);
                }
                dismiss();
                return;
            case C0965R.id.negativeButton:
                if (this.f19326l.f19306o != null) {
                    this.f19326l.f19306o.onClick(this, -2);
                }
                dismiss();
                return;
            default:
                return;
        }
    }

    public View getButton(int button) {
        switch (button) {
            case -2:
                return this.f19325k;
            case -1:
                return this.f19324j;
            default:
                return null;
        }
    }
}
