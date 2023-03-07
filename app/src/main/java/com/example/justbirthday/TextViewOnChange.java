package com.example.justbirthday;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

public class TextViewOnChange implements View.OnFocusChangeListener{
    String default_text;
    Boolean is_default = true;
    Context app_context;


    TextViewOnChange(String in, Context context){
        default_text = in;
        app_context = context;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        TextView tv = (TextView) v;
        if (is_default) {
            is_default = false;
            tv.setTextColor(app_context.getResources().getColor(R.color.black));
        }
        if (!hasFocus){
            if(tv.getText().length() == 0) {
                is_default = true;
                tv.setText(default_text);
                tv.setTextColor(app_context.getResources().getColor(R.color.light_gray));
            }
        }
    }
}
