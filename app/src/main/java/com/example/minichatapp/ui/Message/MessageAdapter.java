package com.example.minichatapp.ui.Message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minichatapp.BottomActivity;
import com.example.minichatapp.ConversationActivity;
import com.example.minichatapp.R;
import com.example.minichatapp.data.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private final List<Message> messageList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nameView;
        private final TextView contentView;
        private final TextView timeView;
        private final View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            nameView=(TextView)itemView.findViewById(R.id.message_name);
            contentView=(TextView)itemView.findViewById(R.id.message_content);
            timeView=(TextView)itemView.findViewById(R.id.message_time);
        }

        public TextView getNameView() {
            return nameView;
        }

        public View getItemView() {
            return itemView;
        }

        public TextView getContentView() {
            return contentView;
        }

        public TextView getTimeView() {
            return timeView;
        }
    }

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
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
        Message message=messageList.get(position);
        holder.getNameView().setText(message.getName());
        holder.getTimeView().setText(message.getTime());
        holder.getContentView().setText(message.getContent());
        String u_id="";
        String f_id=message.getR_id().equals(u_id)?message.getS_id():message.getR_id();
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConversationActivity.ActionStart(view.getContext(),f_id,u_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
