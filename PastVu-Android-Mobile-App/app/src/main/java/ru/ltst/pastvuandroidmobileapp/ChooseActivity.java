package ru.ltst.pastvuandroidmobileapp;

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

import java.io.FileOutputStream;

import ru.ltst.pastvuandroidmobileapp.R;

public class ChooseActivity extends Activity implements View.OnClickListener{

    Button btnToCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        btnToCamera = (Button) findViewById(R.id.btnToCamera);
        btnToCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnToCamera:
                Intent cameraAct = new Intent(this, CameraActivity.class);
                try {
                    Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.retrika_main);
                    FileOutputStream fos = new FileOutputStream(getCacheDir() + getString(R.string.pictureOld_file_name));
                    Toast.makeText(this, "Saved in:"+getCacheDir().toString()+getString(R.string.pictureOld_file_name), Toast.LENGTH_LONG).show();
                    mBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                    Toast.makeText(this, "MyLog:"+e.toString(), Toast.LENGTH_LONG).show();
                }
                startActivity(cameraAct);
                break;
        }

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
