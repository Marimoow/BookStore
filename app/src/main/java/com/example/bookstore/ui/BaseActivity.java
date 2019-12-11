package com.example.bookstore.ui;


import android.os.Bundle;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


/**
 * descreption:
 * company: codingke.com
 * Created by vince on 15/11/13.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    /**
     * Toast提示
     * @param text
     */
    public void showToast(String text){
        Toast.makeText(BaseActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
