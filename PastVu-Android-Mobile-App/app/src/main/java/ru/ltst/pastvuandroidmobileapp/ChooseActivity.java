package ru.ltst.pastvuandroidmobileapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import ru.ltst.pastvuandroidmobileapp.R;

public class ChooseActivity extends Activity implements View.OnClickListener{

    ActionBar act_bar;
    Button btnToSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        act_bar = getActionBar();
        if (act_bar!=null){
            act_bar.setDisplayShowHomeEnabled(false);
            //act_bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_background));
            act_bar.show();
        }
        btnToSettings = (Button) findViewById(R.id.btn_settings_on_main_menu);
        btnToSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_settings_on_main_menu:
                Intent settingsAct = new Intent(this, SettingsActivity.class);
                startActivity(settingsAct);
                break;
        }
//        try {//строки для сохранения в кэш выбранной картинки
//            Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.retrika_main);
//            FileOutputStream fos = new FileOutputStream(new File(getCacheDir(), getString(R.string.pictureOld_file_name)));
//            Toast.makeText(this, "Saved in:"+fos.toString(), Toast.LENGTH_LONG).show();
//            mBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
//            fos.flush();
//            fos.close();
//        } catch (Exception e) {
//            Toast.makeText(this, "MyLog:"+e.toString(), Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.choose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
