package com.example.minichatapp.ui.conversation;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minichatapp.R;

import io.rong.imkit.utils.RouteUtils;

public class ConversationFragment extends io.rong.imkit.conversation.ConversationFragment {

    private ConversationViewModel mViewModel;

    public static ConversationFragment newInstance() {
        return new ConversationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RouteUtils.routeToConversationListActivity(getContext(), "会话列表");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConversationViewModel.class);
        // TODO: Use the ViewModel
    }

}