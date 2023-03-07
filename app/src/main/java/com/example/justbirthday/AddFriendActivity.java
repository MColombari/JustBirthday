package com.example.justbirthday;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import javax.xml.namespace.NamespaceContext;

public class AddFriendActivity extends AppCompatActivity{
    TextView NicknameTextView;
    TextView NameTextView;
    TextView SurnameTextView;
    TextView bDayTextView;
    TextView CommentsTextView;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //This line will enable full screen.
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_friend);

        NicknameTextView = (TextView) findViewById(R.id.NicknameInput);
        NameTextView = (TextView) findViewById(R.id.NameInput);
        SurnameTextView = (TextView) findViewById(R.id.SurnameInput);
        bDayTextView = (TextView) findViewById(R.id.bDayInput);
        CommentsTextView = (TextView) findViewById(R.id.CommentsInput);

        NicknameTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_nickname),
                                        getApplicationContext()));
        NameTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_name),
                                        getApplicationContext()));
        SurnameTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_surname),
                                        getApplicationContext()));
        /*bDayTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_bday),
                                        getApplicationContext()));*/
        CommentsTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_comments),
                                        getApplicationContext()));

        datePickerDialog = new DatePickerDialog(this);

        // Source to continue: "https://www.youtube.com/watch?v=qCoidM98zNk".

        bDayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        /*
        bDayTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            boolean auto_change = false;
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = bDayTextView.getText().toString();
                String[] split_text = text.split("/");
                if (!auto_change) {
                    if (split_text.length == 1) {
                        if (split_text[0].length() == 2) {
                            split_text[0] = split_text[0] + '/';
                        }
                        auto_change = true;
                        bDayTextView.setText(Utils.join_string(split_text));
                    } else if (split_text.length == 2) {
                        if ((split_text[1].length() == 2) | (Integer.parseInt(split_text[1]) > 12)) {
                            split_text[1] = split_text[1] + '/';
                        }
                        auto_change = true;
                        bDayTextView.setText(Utils.join_string(split_text));
                    } else if (split_text.length == 3) {
                        if (split_text[2].length() > 4) {
                            split_text[2] = split_text[2].substring(0, 3);
                            run_popup("Invalid Date", bDayTextView);
                        }
                        auto_change = true;
                        bDayTextView.setText(Utils.join_string(split_text));
                    } else if (split_text.length > 3) {
                        run_popup("Invalid Date", bDayTextView);
                    }
                }
                else{
                    auto_change = false;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        */
    }

    public void run_popup (String message, View v){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.generic_popup, null);

        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(20);
        }
        popupWindow.setAnimationStyle(R.style.AnimationGenericPopupWindow);
        popupWindow.update();
        // "v" is used as a parent view to get the View.getWindowToken() token from.
        popupWindow.showAtLocation(v, Gravity.TOP, 0, 300);

        Button button = (Button) findViewById(R.id.popup_button);
        button.setText(message);
    }
}