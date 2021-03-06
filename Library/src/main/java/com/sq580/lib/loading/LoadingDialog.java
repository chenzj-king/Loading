package com.sq580.lib.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author chenzj
 * @Title: LoadingDialog
 * @Description: 类的描述 -
 * @date 2016/8/21 18:32
 * @email admin@chenzhongjin.cn
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable) {
        return newInstance(context, charSequence, cancelable, true, null, null);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable, boolean isAutoShow) {
        return newInstance(context, charSequence, cancelable, isAutoShow, null, null);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable,
                                            OnCancelListener onCancelListener) {
        return newInstance(context, charSequence, cancelable, true, onCancelListener, null);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable,
                                            OnCancelListener onCancelListener, OnDismissListener onDismissListener) {
        return newInstance(context, charSequence, cancelable, true, onCancelListener, onDismissListener);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable,
                                            boolean isAutoShow, OnCancelListener onCancelListener,
                                            OnDismissListener onDismissListener) {
        LoadingDialog loadingDialog = new LoadingDialog(context, R.style.LoadingDialog);
        loadingDialog.setTitle("");

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        loadingDialog.setContentView(dialogView);

        if (charSequence == null || charSequence.length() == 0) {
            loadingDialog.findViewById(R.id.tip_tv).setVisibility(View.GONE);
        } else {
            ((TextView) loadingDialog.findViewById(R.id.tip_tv)).setText(charSequence);
        }
        loadingDialog.setCancelable(cancelable);

        //计算高度
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        dialogView.measure(w, h);
        int width = dialogView.getMeasuredWidth();
        int height = dialogView.getMeasuredHeight();

        Window window = loadingDialog.getWindow();
        if (window != null) {
            if (width * 0.9 > height) {
                window.setLayout(width, (int) (width * 0.9));
            } else {
                window.setLayout(width, height);
            }
        }
        //是否自动显示对话框
        if (isAutoShow) {
            loadingDialog.show();
        }
        if (null != onCancelListener) {
            loadingDialog.setOnCancelListener(onCancelListener);
        }
        if (null != onDismissListener) {
            loadingDialog.setOnDismissListener(onDismissListener);
        }
        return loadingDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            ((AnimationDrawable) ((ImageView) findViewById(R.id.spinner_iv)).getDrawable()).start();
        } else {
            ((AnimationDrawable) ((ImageView) findViewById(R.id.spinner_iv)).getDrawable()).stop();
        }
    }
}
