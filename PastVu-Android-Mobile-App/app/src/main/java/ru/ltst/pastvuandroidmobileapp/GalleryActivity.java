package ru.ltst.pastvuandroidmobileapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class GalleryActivity extends Activity {

    GridView gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gallery = (GridView) findViewById(R.id.galleryGridView);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context c = getApplicationContext();
                Intent questionActivity = new Intent(getApplicationContext(), QuestionActivity.class);
                try {//строки для сохранения в кэш выбранной картинки
                    //Bitmap mBitmap = BitmapFactory.decodeResource();
                    //FileOutputStream fos = new FileOutputStream(new File(getCacheDir(), getString(R.string.pictureOld_file_name)));
                    //Toast.makeText(c, "Saved in:" + fos.toString(), Toast.LENGTH_LONG).show();
                    //mBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
                    //fos.flush();
                    //fos.close();
                    startActivity(questionActivity);
                } catch (Exception e) {
                    Toast.makeText(c, "MyLog:"+e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
