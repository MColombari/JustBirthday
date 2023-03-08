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
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.namespace.NamespaceContext;

public class AddFriendActivity extends AppCompatActivity{
    TextView NicknameTextView;
    TextView NameTextView;
    TextView SurnameTextView;
    TextView bDayTextView;
    TextView CommentsTextView;

    int bDay = 8;
    int bMonth = 4;
    int bYear = 2000;

    final Calendar myCalendar= Calendar.getInstance();
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
        CommentsTextView.setOnFocusChangeListener(
                new TextViewOnChange(   getResources().getString(R.string.text_comments),
                                        getApplicationContext()));

        // Source:  "https://www.youtube.com/watch?v=qCoidM98zNk",
        //          "https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext".

        bDayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddFriendActivity.this,
                        R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                bDay = day;
                                bMonth = monthOfYear + 1;
                                bYear = year;
                                bDayTextView.setText(
                                        String.format("%02d", dayOfMonth) + "/" +
                                        String.format("%02d", monthOfYear + 1) + "/" +
                                        String.format("%04d", year));
                                bDayTextView.setTextColor(getResources().getColor(R.color.black));

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });


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