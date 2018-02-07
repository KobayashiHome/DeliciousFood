package com.skylinelin.deliciousfood;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author skylinelin
 * @date 2018/2/6
 * */

public class MainActivity extends AppCompatActivity {
    //初始化控件
    private CheckBox mCheckBoxZhong;
    private CheckBox mChechBoxXi;
    private CheckBox mCheckBoxTian;

    private RadioGroup mRadioGroupYesNo;
    private RadioButton mRadioButtonYes;
    private RadioButton mRadioButtonNo;

    private TextView mTextViewPrice;
    private SeekBar mSeekBarPrice;

    private Button mButtonChong;
    private Button mButtonSou;

    private ImageView mInageViewFood;
    private Button mButtonXiang;

    private Button mButtonUp;
    private Button mButtonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        mButtonXiang = findViewById(R.id.button_xiang);
        Paint paint = mButtonXiang.getPaint();
        paint.setFlags(paint.getFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

}
