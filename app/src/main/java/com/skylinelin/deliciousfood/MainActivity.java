package com.skylinelin.deliciousfood;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

/**
 * @author skylinelin
 * @date 2018/2/6
 * */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity" ;
    /**
     * 初始化控件
     */
    private LinearLayout mPinZhong;
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

    private ImageView mImageViewFood;
    private Button mButtonXiang;

    private Button mButtonUp;
    private Button mButtonNext;

    private List<Food> mFoodList;

    private int page;

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

        mPinZhong = findViewById(R.id.pinzhong);
        mCheckBoxZhong = findViewById(R.id.check_box_zhong);
        mChechBoxXi = findViewById(R.id.check_box_xi);
        mCheckBoxTian = findViewById(R.id.check_box_tian);

        checkAll();

        mRadioGroupYesNo = findViewById(R.id.radio_yes_no);
        mRadioButtonYes = findViewById(R.id.radio_button_yes);
        mRadioButtonNo = findViewById(R.id.radio_button_no);
        mRadioGroupYesNo.check(R.id.radio_button_yes);

        mTextViewPrice = findViewById(R.id.text_view_price);
        mSeekBarPrice = findViewById(R.id.seek_bar_price);
        mSeekBarPrice.setProgress(100);
        mTextViewPrice.setText(" " + mSeekBarPrice.getProgress());
        mSeekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTextViewPrice.setText(" " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mImageViewFood = findViewById(R.id.image_view_food);
        mFoodList = initData();
        page = 0;
        mImageViewFood.setImageResource(mFoodList.get(page).getImgResId());

        //翻页按钮
        mButtonUp = findViewById(R.id.button_up);
        mButtonNext = findViewById(R.id.button_next);
        mButtonUp.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);


    }

    private List<Food> initData(){
        return FoodAPI.getDemoFood(this);
    }

    /**
     * 选中pinzhong里面的所有CheckBox
     */
    private void checkAll(){
        int pinzhong = mPinZhong.getChildCount();
        for (int i = 0; i < pinzhong; i++) {

            View checkBox = mPinZhong.getChildAt(i);
            if (checkBox instanceof CheckBox){
                ((CheckBox) checkBox).setChecked(true);
            }
            
        }
    }

    /**
     * 翻页按钮点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_up:
                showUp();
                break;

            case R.id.button_next:
                showNext();
                break;
                default:
                    break;
        }
    }

    /**
     * 翻页功能
     */
    private void showUp(){
        int upPage = (page - 1 + mFoodList.size())%mFoodList.size();
        showPageAtIndex(upPage);

    }

    private void showNext(){
        int nextPage = (page + 1)%mFoodList.size();
        showPageAtIndex(nextPage);

    }

    private void showPageAtIndex(int index){
        Log.d(TAG,"showPageAtIndex:" + index);

        Food food = mFoodList.get(index);
        mImageViewFood.setImageResource(food.getImgResId());
        page = index;
    }
}
