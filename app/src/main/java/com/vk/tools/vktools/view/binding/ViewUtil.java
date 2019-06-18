package com.vk.tools.vktools.view.binding;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class ViewUtil {

    public static final int COUNT_LOW_DAY_FOR_FINISH_WORK = 2;

    @SuppressWarnings("unused")
    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    @SuppressWarnings("unused")
    public static int dpToPx(@SuppressWarnings("SameParameterValue") int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    /**
     * Перевод из dp в px
     *
     * @param dp количество dp
     * @return количество px
     */
    public static int dpToPx(@SuppressWarnings("SameParameterValue") float dp) {
        return dpToPx((int) dp);
    }

}
