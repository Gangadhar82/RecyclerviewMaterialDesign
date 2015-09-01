package com.mmadapps.recyclerviewmaterialdesign;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener{

    ImageView img;
    TextView txt;
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public static interface OnItemClickListener
    {
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data fro recycler view
        ItemData itemsData[] = {
                new ItemData("Gangadhar","v can help here to take ur problems n anything here kgjkljgklajigjkladjgnklajgkljaklgjakljgkajgkaj",R.drawable.ic_mail_grey_600_48dp),
                new ItemData("Bhaskar Reddy","u can delet herkjkjkjkj kjfiejkjdiopadjkjajeiorejfauaijrej ",R.drawable.ic_close_grey_600_48dp),
                new ItemData("Sourab kumar","store in cloud kdkopdjgiojal;kjfk jlafkjopao ",R.drawable.ic_content_copy_grey_600_48dp),
                new ItemData("Vinod kumar","choose your fav",R.drawable.ic_delete_grey_600_48dp),
                new ItemData("Hari prasad ","like this",R.drawable.ic_edit_grey_600_48dp),
                new ItemData("Dhanashekar","ggrjifjgkfsjkgsjkgj",R.drawable.ic_save_grey_600_48dp),
                new ItemData("Poornima","dflkdjgojajfkaj",R.drawable.ic_close_grey_600_48dp),
                new ItemData("Ramkrishna","jfdljkgjdajgoakopotk",R.drawable.ic_content_copy_grey_600_48dp),
                new ItemData("Sasikala","kjgoerkgtkeraopgkmopadfkgp[adkgpojaotgkjap[kgopajhoakopgjnaiojgop",R.drawable.ic_delete_grey_600_48dp),
                new ItemData("Sumiya","fdjkjadiejjdkjkfjhgkj",R.drawable.ic_edit_grey_600_48dp),
                new ItemData("Priya","dfalkeitoiy][rweiyoklg",R.drawable.ic_save_grey_600_48dp),
                new ItemData("Shilpa","gflkoirtoemkd",R.drawable.ic_delete_grey_600_48dp),
                new ItemData("Deepika ","kdl;koeitep",R.drawable.ic_save_grey_600_48dp),
                new ItemData(" Samhitha","dk;alkoeiopeiojgg",R.drawable.ic_content_copy_grey_600_48dp)};


        // 2. set layoutManger

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimators
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("bhaskar",view.toString());
                        txt= (TextView) view.findViewById(R.id.item_title);
                        TextView txt1= (TextView) view.findViewById(R.id.item_title1);
                        img= (ImageView) view.findViewById(R.id.item_icon);
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("hii",txt.getText().toString());
                        intent.putExtra("howru",txt1.getText().toString());
                        Drawable drawable  = img.getDrawable();
                        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                        intent.putExtra("hello", bitmap);
                        startActivity(intent);


                    }
                })
        );



    }


    public  void clickmeYa(View view)
    {
        Intent intent=new Intent(MainActivity.this,DialogActivity.class);
        img= (ImageView) view.findViewById(R.id.item_icon);
        Drawable drawable  = img.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        intent.putExtra("hello", bitmap);
        startActivity(intent);
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        TextView vi=(TextView)view;
//        String str=vi.getText().toString();
//        Log.d("rudra", str);
//        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//        intent.putExtra("data",str);
//
//    }


}



