package fpoly.cp17302_3.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ManHinhChao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);

        ImageView ivManHinh = findViewById(R.id.ivManHinhChao);

        Glide.with(this).load(R.mipmap.manhinhcho).into(ivManHinh);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ManHinhChao.this,MainActivity.class));
            }
        }, 2000);
    }
}