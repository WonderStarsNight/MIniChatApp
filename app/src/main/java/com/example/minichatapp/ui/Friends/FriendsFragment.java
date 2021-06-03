package com.example.minichatapp.ui.Friends;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minichatapp.R;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.ui.BottomViewModel;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {

    private FriendsViewModel mViewModel;

    public static FriendsFragment newInstance() {
        return new FriendsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_friends, container, false);

        BottomViewModel bottomViewModel=new ViewModelProvider(requireActivity()).get(BottomViewModel.class);
        mViewModel=new ViewModelProvider(this,new FriendsViewModelFactory(bottomViewModel.getUid().getValue())).get(FriendsViewModel.class);
        mViewModel.init(bottomViewModel.getUid().getValue());
        RecyclerView recyclerView=root.findViewById(R.id.friend_list);

        LinearLayoutManager manager=new LinearLayoutManager(this.getContext());
        List<Friend> friendList=mViewModel.getFriendListData().getValue();
        Log.d("friendList",String.valueOf(friendList.size()));
        if(friendList==null){
            friendList=new ArrayList<>();
        }
        FriendAdapter adapter=new FriendAdapter(friendList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        mViewModel.getFriendListData().observe(getViewLifecycleOwner(), new Observer<List<Friend>>() {
            @Override
            public void onChanged(List<Friend> friendList) {
                adapter.notifyAfterAdd(friendList);
            }
        });
        return root;
    }


}