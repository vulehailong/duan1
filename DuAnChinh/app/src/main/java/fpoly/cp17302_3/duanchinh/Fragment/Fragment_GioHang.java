package fpoly.cp17302_3.duanchinh.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpoly.cp17302_3.duanchinh.Adapter.KhachHang_GioHang_Adapter;
import fpoly.cp17302_3.duanchinh.DAO.VeDao;
import fpoly.cp17302_3.duanchinh.Model.Ve;
import fpoly.cp17302_3.duanchinh.R;

public class Fragment_GioHang extends Fragment {
    VeDao veDao;
    RecyclerView recyclerGioHang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang, container, false);

        recyclerGioHang = view.findViewById(R.id.recyclerGioHang);
        veDao = new VeDao(getContext());
        loadData();



        return view;
    }


    private void loadData() {
        ArrayList<Ve> list = veDao.getDSVe();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerGioHang.setLayoutManager(linearLayoutManager);
        KhachHang_GioHang_Adapter adapter = new KhachHang_GioHang_Adapter(getContext(), list, veDao);
        recyclerGioHang.setAdapter(adapter);
    }
}
