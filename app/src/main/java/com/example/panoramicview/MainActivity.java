package com.example.panoramicview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import co.gofynd.gravityview.GravityView;
import com.example.panoramicview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private GravityView gravityView;
    private boolean supportvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        init();
        if(supportvalue){
            this.gravityView.setImage(binding.ivImage,R.drawable.fulview).center();
        }
        else
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fulview);
            binding.ivImage.setImageBitmap(bitmap);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }

    public void init()
    {
        this.gravityView = GravityView.getInstance(getBaseContext());
        this.supportvalue = gravityView.deviceSupported();
    }

}