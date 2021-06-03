package com.example.minichatapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.minichatapp.AccountSettingActivity;
import com.example.minichatapp.FriendAddActivity;
import com.example.minichatapp.MessageSettingsActivity;
import com.example.minichatapp.R;
import com.example.minichatapp.data.home.HomeDataSource;
import com.example.minichatapp.data.home.HomeRepository;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.ui.BottomViewModel;

import io.rong.imkit.RongIM;


public class HomeFragment extends Fragment implements LifecycleOwner {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel =
                new ViewModelProvider(this,new HomeViewModelFactory()).get(HomeViewModel.class);
        BottomViewModel bottomViewModel=new ViewModelProvider(requireActivity()).get(BottomViewModel.class);
        final TextView accountView = root.findViewById(R.id.account);
        final TextView nameView=root.findViewById(R.id.name);
        final View a_s_view=root.findViewById(R.id.accountView);
        final View m_s_view=root.findViewById(R.id.messageView);
        final View addFriendView=root.findViewById(R.id.addFriendView);
        final Button exitButton=root.findViewById(R.id.exit);

        if(homeViewModel==null){
            Log.d("homeViewModelIsNull","null");
        }
        homeViewModel.getUid().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                accountView.setText(s);
            }
        });
        homeViewModel.getU_name().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                nameView.setText(s);
            }
        });

        a_s_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountSettingActivity.ActionStart(getContext());
            }
        });
        m_s_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageSettingsActivity.ActionStart(getContext());
            }
        });
        addFriendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FriendAddActivity.ActionStart(getContext(),bottomViewModel.getUid().getValue());
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomViewModel.logout();
                RongIM.getInstance().logout();
            }
        });


        return root;
    }

}