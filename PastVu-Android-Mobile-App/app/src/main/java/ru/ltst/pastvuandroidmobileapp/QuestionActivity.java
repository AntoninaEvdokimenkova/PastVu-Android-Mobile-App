package ru.ltst.pastvuandroidmobileapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class QuestionActivity extends Activity implements View.OnClickListener{

    ImageView outImage;
    Button btn_favourite, btn_to_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        outImage = (ImageView) findViewById(R.id.imageOldInQuestion);
        outImage.setImageBitmap(BitmapFactory.decodeFile(getCacheDir()+"/"+getString(R.string.pictureOld_file_name)));
        btn_favourite = (Button) findViewById(R.id.btnIsFavourite);
        btn_to_camera = (Button) findViewById(R.id.btnToCamera);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnIsFavourite:

                break;
            case R.id.btnToCamera:
                Intent cameraActivity = new Intent(this, CameraActivity.class);
                startActivity(cameraActivity);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question, menu);
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
