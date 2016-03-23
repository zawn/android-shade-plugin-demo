/*
 * Copyright (c) &amp;#36;today.year, House365. All rights reserved.
 */

package com.house365.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

/**
 * 主界面.
 */
public class LibraryMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_main);
        new Thread() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .get()
                        .url(" https://api.github.com/users/vRallev")
                        .build();

                try {
                    final String message = new OkHttpClient()
                            .newCall(request)
                            .execute()
                            .message();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LibraryMainActivity.this, "Message: " + message, Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (IOException e) {
                    Log.e("Demo", e.getMessage(), e);
                }
            }
        }.start();
    }
}
