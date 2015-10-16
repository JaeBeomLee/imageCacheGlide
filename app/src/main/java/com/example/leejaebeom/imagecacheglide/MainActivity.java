package com.example.leejaebeom.imagecacheglide;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    String url = "https://lh6.googleusercontent.com/-qA6BZB27IPw/AAAAAAAAAAI/AAAAAAAAAAA/agDF9Tc9hL0/s0-c-k-no-ns/photo.jpg";
    ImageView im1;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        im1 = (ImageView)findViewById(R.id.im1);
        setSupportActionBar(toolbar);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    bitmap = Glide.with(MainActivity.this).load(url).asBitmap().into(500, 500).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                im1.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

