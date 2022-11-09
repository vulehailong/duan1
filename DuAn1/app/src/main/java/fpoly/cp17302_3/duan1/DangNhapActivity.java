package fpoly.cp17302_3.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fpoly.cp17302_3.duan1.DAO.ThanhVienDAO;

public class DangNhapActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        EditText edtUserName = findViewById(R.id.edtUser);
        EditText edtPassWord = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUserName.getText().toString();
                String pass = edtPassWord.getText().toString();

                if (user.equalsIgnoreCase("tv01") && pass.equals("123")){
                    startActivity(new Intent(DangNhapActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(DangNhapActivity.this, "Không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}