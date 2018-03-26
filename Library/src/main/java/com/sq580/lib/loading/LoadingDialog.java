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
        return newInstance(context, charSequence, cancelable, true);
    }

    public static LoadingDialog newInstance(Context context, CharSequence charSequence, boolean cancelable, boolean isAutoShow) {
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
        return loadingDialog;
    }

    public void onWindowFocusChanged(boolean isShowAnimation) {
        ((AnimationDrawable) ((ImageView) findViewById(R.id.spinner_iv)).getDrawable()).start();
    }

}
