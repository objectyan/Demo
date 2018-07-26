package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EllipsizingTextView extends TextView {
    private static final Pattern DEFAULT_END_PUNCTUATION = Pattern.compile("[\\.!?,;:…]*$", 32);
    private static final CharSequence ELLIPSIS = "…";
    private boolean isEllipsized;
    private boolean isStale;
    private final List<EllipsizeListener> mEllipsizeListeners;
    private EllipsizeStrategy mEllipsizeStrategy;
    private Pattern mEndPunctPattern;
    private CharSequence mFullText;
    private float mLineAddVertPad;
    private float mLineSpacingMult;
    private int mMaxLines;
    private boolean programmaticChange;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.widget.EllipsizingTextView$1 */
    static /* synthetic */ class C44651 {
        static final /* synthetic */ int[] $SwitchMap$android$text$TextUtils$TruncateAt = new int[TruncateAt.values().length];

        static {
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TruncateAt.END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TruncateAt.START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TruncateAt.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$text$TextUtils$TruncateAt[TruncateAt.MARQUEE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private abstract class EllipsizeStrategy {
        protected abstract CharSequence createEllipsizedText(CharSequence charSequence);

        private EllipsizeStrategy() {
        }

        public CharSequence processText(CharSequence text) {
            return !isInLayout(text) ? createEllipsizedText(text) : text;
        }

        public boolean isInLayout(CharSequence text) {
            return createWorkingLayout(text).getLineCount() <= getLinesCount();
        }

        protected Layout createWorkingLayout(CharSequence workingText) {
            return new StaticLayout(workingText, EllipsizingTextView.this.getPaint(), (EllipsizingTextView.this.getMeasuredWidth() - EllipsizingTextView.this.getPaddingLeft()) - EllipsizingTextView.this.getPaddingRight(), Alignment.ALIGN_NORMAL, EllipsizingTextView.this.mLineSpacingMult, EllipsizingTextView.this.mLineAddVertPad, false);
        }

        protected int getLinesCount() {
            if (!EllipsizingTextView.this.ellipsizingLastFullyVisibleLine()) {
                return EllipsizingTextView.this.mMaxLines;
            }
            int fullyVisibleLinesCount = getFullyVisibleLinesCount();
            if (fullyVisibleLinesCount == -1) {
                return 1;
            }
            return fullyVisibleLinesCount;
        }

        protected int getFullyVisibleLinesCount() {
            return ((EllipsizingTextView.this.getHeight() - EllipsizingTextView.this.getCompoundPaddingTop()) - EllipsizingTextView.this.getCompoundPaddingBottom()) / createWorkingLayout("").getLineBottom(0);
        }
    }

    private class EllipsizeEndStrategy extends EllipsizeStrategy {
        private EllipsizeEndStrategy() {
            super();
        }

        protected CharSequence createEllipsizedText(CharSequence fullText) {
            int cutOffIndex = createWorkingLayout(fullText).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
            int textLength = fullText.length();
            int cutOffLength = textLength - cutOffIndex;
            if (cutOffLength < EllipsizingTextView.ELLIPSIS.length()) {
                cutOffLength = EllipsizingTextView.ELLIPSIS.length();
            }
            String workingText = TextUtils.substring(fullText, 0, textLength - cutOffLength).trim();
            String strippedText = stripEndPunctuation(workingText);
            while (!isInLayout(strippedText + EllipsizingTextView.ELLIPSIS)) {
                int lastSpace = workingText.lastIndexOf(32);
                if (lastSpace == -1) {
                    break;
                }
                workingText = workingText.substring(0, lastSpace).trim();
                strippedText = stripEndPunctuation(workingText);
            }
            workingText = strippedText + EllipsizingTextView.ELLIPSIS;
            SpannableStringBuilder dest = new SpannableStringBuilder(workingText);
            if (fullText instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) fullText, 0, workingText.length(), null, dest, 0);
            }
            return dest;
        }

        public String stripEndPunctuation(CharSequence workingText) {
            return EllipsizingTextView.this.mEndPunctPattern.matcher(workingText).replaceFirst("");
        }
    }

    public interface EllipsizeListener {
        void ellipsizeStateChanged(boolean z);
    }

    private class EllipsizeMiddleStrategy extends EllipsizeStrategy {
        private EllipsizeMiddleStrategy() {
            super();
        }

        protected CharSequence createEllipsizedText(CharSequence fullText) {
            int cutOffIndex = createWorkingLayout(fullText).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
            int textLength = fullText.length();
            int cutOffLength = textLength - cutOffIndex;
            if (cutOffLength < EllipsizingTextView.ELLIPSIS.length()) {
                cutOffLength = EllipsizingTextView.ELLIPSIS.length();
            }
            cutOffLength += cutOffIndex % 2;
            String firstPart = TextUtils.substring(fullText, 0, (textLength / 2) - (cutOffLength / 2)).trim();
            String secondPart = TextUtils.substring(fullText, (textLength / 2) + (cutOffLength / 2), textLength).trim();
            while (!isInLayout(firstPart + EllipsizingTextView.ELLIPSIS + secondPart)) {
                int lastSpaceFirstPart = firstPart.lastIndexOf(32);
                int firstSpaceSecondPart = secondPart.indexOf(32);
                if (lastSpaceFirstPart == -1 || firstSpaceSecondPart == -1) {
                    break;
                }
                firstPart = firstPart.substring(0, lastSpaceFirstPart).trim();
                secondPart = secondPart.substring(firstSpaceSecondPart, secondPart.length()).trim();
            }
            SpannableStringBuilder firstDest = new SpannableStringBuilder(firstPart);
            SpannableStringBuilder secondDest = new SpannableStringBuilder(secondPart);
            if (fullText instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) fullText, 0, firstPart.length(), null, firstDest, 0);
                TextUtils.copySpansFrom((Spanned) fullText, textLength - secondPart.length(), textLength, null, secondDest, 0);
            }
            return TextUtils.concat(new CharSequence[]{firstDest, EllipsizingTextView.ELLIPSIS, secondDest});
        }
    }

    private class EllipsizeNoneStrategy extends EllipsizeStrategy {
        private EllipsizeNoneStrategy() {
            super();
        }

        protected CharSequence createEllipsizedText(CharSequence fullText) {
            return fullText;
        }
    }

    private class EllipsizeStartStrategy extends EllipsizeStrategy {
        private EllipsizeStartStrategy() {
            super();
        }

        protected CharSequence createEllipsizedText(CharSequence fullText) {
            int cutOffIndex = createWorkingLayout(fullText).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
            int textLength = fullText.length();
            int cutOffLength = textLength - cutOffIndex;
            if (cutOffLength < EllipsizingTextView.ELLIPSIS.length()) {
                cutOffLength = EllipsizingTextView.ELLIPSIS.length();
            }
            String workingText = TextUtils.substring(fullText, cutOffLength, textLength).trim();
            while (!isInLayout(EllipsizingTextView.ELLIPSIS + workingText)) {
                int firstSpace = workingText.indexOf(32);
                if (firstSpace == -1) {
                    break;
                }
                workingText = workingText.substring(firstSpace, workingText.length()).trim();
            }
            workingText = EllipsizingTextView.ELLIPSIS + workingText;
            SpannableStringBuilder dest = new SpannableStringBuilder(workingText);
            if (fullText instanceof Spanned) {
                TextUtils.copySpansFrom((Spanned) fullText, textLength - workingText.length(), textLength, null, dest, 0);
            }
            return dest;
        }
    }

    public EllipsizingTextView(Context context) {
        this(context, null);
    }

    public EllipsizingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    public EllipsizingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mEllipsizeListeners = new ArrayList();
        this.mLineSpacingMult = 1.0f;
        this.mLineAddVertPad = 0.0f;
        TypedArray a = context.obtainStyledAttributes(attrs, new int[]{16843091}, defStyle, 0);
        setMaxLines(a.getInt(0, Integer.MAX_VALUE));
        a.recycle();
        setEndPunctuationPattern(DEFAULT_END_PUNCTUATION);
    }

    public void setEndPunctuationPattern(Pattern pattern) {
        this.mEndPunctPattern = pattern;
    }

    public void addEllipsizeListener(EllipsizeListener listener) {
        this.mEllipsizeListeners.add(listener);
    }

    public void removeEllipsizeListener(EllipsizeListener listener) {
        this.mEllipsizeListeners.remove(listener);
    }

    public boolean isEllipsized() {
        return this.isEllipsized;
    }

    public int getMaxLines() {
        return this.mMaxLines;
    }

    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
        this.mMaxLines = maxLines;
        this.isStale = true;
    }

    public boolean ellipsizingLastFullyVisibleLine() {
        return this.mMaxLines == Integer.MAX_VALUE;
    }

    public void setLineSpacing(float add, float mult) {
        this.mLineAddVertPad = add;
        this.mLineSpacingMult = mult;
        super.setLineSpacing(add, mult);
    }

    public void setText(CharSequence text, BufferType type) {
        if (!this.programmaticChange) {
            this.mFullText = text;
            this.isStale = true;
        }
        super.setText(text, type);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (ellipsizingLastFullyVisibleLine()) {
            this.isStale = true;
        }
    }

    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        if (ellipsizingLastFullyVisibleLine()) {
            this.isStale = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.isStale) {
            resetText();
        }
        super.onDraw(canvas);
    }

    private void resetText() {
        int maxLines = getMaxLines();
        CharSequence workingText = this.mFullText;
        boolean ellipsized = false;
        if (maxLines != -1) {
            if (this.mEllipsizeStrategy == null) {
                setEllipsize(null);
            }
            workingText = this.mEllipsizeStrategy.processText(this.mFullText);
            if (this.mEllipsizeStrategy.isInLayout(this.mFullText)) {
                ellipsized = false;
            } else {
                ellipsized = true;
            }
        }
        if (!workingText.equals(getText())) {
            this.programmaticChange = true;
            try {
                setText(workingText);
            } finally {
                this.programmaticChange = false;
            }
        }
        this.isStale = false;
        if (ellipsized != this.isEllipsized) {
            this.isEllipsized = ellipsized;
            for (EllipsizeListener listener : this.mEllipsizeListeners) {
                listener.ellipsizeStateChanged(ellipsized);
            }
        }
    }

    public void setEllipsize(TruncateAt where) {
        if (where == null) {
            this.mEllipsizeStrategy = new EllipsizeNoneStrategy();
            return;
        }
        switch (C44651.$SwitchMap$android$text$TextUtils$TruncateAt[where.ordinal()]) {
            case 1:
                this.mEllipsizeStrategy = new EllipsizeEndStrategy();
                return;
            case 2:
                this.mEllipsizeStrategy = new EllipsizeStartStrategy();
                return;
            case 3:
                this.mEllipsizeStrategy = new EllipsizeMiddleStrategy();
                return;
            case 4:
                super.setEllipsize(where);
                this.isStale = false;
                this.mEllipsizeStrategy = new EllipsizeNoneStrategy();
                return;
            default:
                this.mEllipsizeStrategy = new EllipsizeNoneStrategy();
                return;
        }
    }
}
