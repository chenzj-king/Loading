package com.sq580.lib.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
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
        return newInstance(context, charSequence, cancelable, true);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable, boolean isAutoShow) {
        LoadingDialog loadingDialog = new LoadingDialog(context, R.style.LoadingDialog);
        loadingDialog.setTitle("");
        loadingDialog.setContentView(R.layout.dialog_loading);

        if (charSequence == null || charSequence.length() == 0) {
            loadingDialog.findViewById(R.id.tip_tv).setVisibility(View.GONE);
        } else {
            ((TextView) loadingDialog.findViewById(R.id.tip_tv)).setText(charSequence);
        }
        loadingDialog.setCancelable(cancelable);
        if (isAutoShow) {
            loadingDialog.show();
        }
        return loadingDialog;
    }

    public void onWindowFocusChanged(boolean isShowAnimation) {
        ((AnimationDrawable) findViewById(R.id.spinner_iv).getBackground()).start();
    }

}
