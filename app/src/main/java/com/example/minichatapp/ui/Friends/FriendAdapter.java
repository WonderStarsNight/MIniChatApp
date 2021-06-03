package com.example.minichatapp.ui.Friends;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minichatapp.R;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.data.model.User;

import java.io.FileReader;
import java.util.List;

import io.rong.imkit.utils.RouteUtils;
import io.rong.imlib.model.Conversation;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private  List<Friend> friendList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameView;
        private final View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            nameView=(TextView)itemView.findViewById(R.id.friend_name);
        }

        public TextView getNameView() {
            return nameView;
        }

        public View getItemView() {
            return itemView;
        }
    }
    public void notifyAfterAdd(List<Friend> friends){
        friendList=friends;
        notifyDataSetChanged();
    }

    public FriendAdapter(List<Friend> friendList) {
        this.friendList=friendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(friendList.get(position).getNick_name()==null){
            holder.getNameView().setText(friendList.get(position).getF_name());
        }else {
            holder.getNameView().setText(friendList.get(position).getNick_name());
        }

        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conversation.ConversationType conversationType  = Conversation.ConversationType.PRIVATE;
                String targetId = friendList.get(position).getFid();
                String title =friendList.get(position).getF_name();
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(title)) {
                    bundle.putString(RouteUtils.TITLE, title); //会话页面标题
                    //bundle.putLong(RouteUtils.INDEX_MESSAGE_TIME, fixedMsgSentTime); //打开会话页面时的默认跳转位置，如果不配置将跳转到消息列表底部
                }
                RouteUtils.routeToConversationActivity(view.getContext(), conversationType, targetId, bundle);

            }
        });

    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
