package com.example.justbirthday;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

public class TextViewOnChange implements View.OnFocusChangeListener{
    String default_text;
    Context app_context;
    boolean[] is_set;
    int index;


    TextViewOnChange(String in, Context context, boolean[] is_set, int index){
        default_text = in;
        app_context = context;
        this.is_set = is_set;
        this.index = index;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        TextView tv = (TextView) v;
        if (!is_set[index]) {
            is_set[index] = true;
            tv.setTextColor(app_context.getResources().getColor(R.color.black));
        }
        if (!hasFocus){
            if(tv.getText().length() == 0) {
                is_set[index] = false;
                tv.setText(default_text);
                tv.setTextColor(app_context.getResources().getColor(R.color.light_gray));
            }
        }
    }
}
