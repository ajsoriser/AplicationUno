package com.example.ajsor.aplicationuno;

import android.Manifest;
import android.content.res.Configuration;
import android.gesture.OrientedBoundingBox;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Call Display Class
        DisplayResults();

    }

    public void DisplayResults(){

        //Run check for OS Version
        AlertUserAboutVersion();
    }


    //Change Interface for User <<== VersionFinder
    private void AlertUserAboutVersion(){
        //Get Return from VersionFinder(Bool)
        TextView lblOutput = findViewById(R.id.viewlblOutput);

        boolean VerHunter = VersionFinder();
        if (VerHunter == false){
            lblOutput.setText("You will not be able to run, your system is too far out of date... try updating");
        }
        else{
            lblOutput.setText("You will be able to use this application, probably becuase youre not as much of a failure as we assumed you would be");
        }
    }
    //Check Version of OS
    private boolean VersionFinder(){

        Boolean boolTemp;

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            return false;
        } else{
            return true;
        }
        //+++++SelfNote++++ need to find how to write an auto test that will pass in values for each of the os's for faster testing.
    }


    //CheckScreen rotation listener
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(this, "Orientation Changed", Toast.LENGTH_LONG).show();
        super.onConfigurationChanged(newConfig);
    }
}
