package fpoly.cp17302_3.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import fpoly.cp17302_3.duan1.Fragment.DangXuat_Fragment;
import fpoly.cp17302_3.duan1.Fragment.DoiMatKhau_Fragment;
import fpoly.cp17302_3.duan1.Fragment.PhimDangChieu_Fragment;
import fpoly.cp17302_3.duan1.Fragment.ThongKe_Fragment;
import fpoly.cp17302_3.duan1.Fragment.TinTuc_Fragment;
import fpoly.cp17302_3.duan1.Fragment.TrangChu_Fragment;
import fpoly.cp17302_3.duan1.Fragment.VeCuaToi_Fragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout frameLayout = findViewById(R.id.framelayout);
        NavigationView navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawerlayout);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.mHome:
                        fragment = new TrangChu_Fragment();
                        break;
                    case R.id.mDangChieu:
                        fragment = new PhimDangChieu_Fragment();
                        break;
                    case R.id.mTinTuc:
                        fragment = new TinTuc_Fragment();
                        break;
                    case R.id.mVeCuaToi:
                        fragment = new VeCuaToi_Fragment();
                        break;
                    case R.id.mThongKe:
                        fragment = new ThongKe_Fragment();
                        break;
                    case R.id.mDoiMatKhau:
                        fragment = new DoiMatKhau_Fragment();
                        break;
                    case R.id.mDangXuat:
                        fragment = new DangXuat_Fragment();
                        break;
                    default:
                        fragment = new TrangChu_Fragment();
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.framelayout, fragment)
                            .commit();
                    toolbar.setTitle(item.getTitle());
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}