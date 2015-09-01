package com.mmadapps.recyclerviewmaterialdesign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView mImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        TextView txt= (TextView) findViewById(R.id.textView2);
        TextView txt1= (TextView) findViewById(R.id.textView);
        txt.setText(intent.getStringExtra("hii"));
        txt1.setText(intent.getStringExtra("howru"));
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("hello");
        mImg = (ImageView) findViewById(R.id.imageView);
        mImg.setImageBitmap(bitmap);

    }

    public  void clickmeYa(View view)
    {
        Intent intent=new Intent(SecondActivity.this,DialogActivity.class);
        Drawable drawable  = mImg.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        intent.putExtra("hello", bitmap);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
