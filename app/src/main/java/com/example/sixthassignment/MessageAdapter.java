package com.example.sixthassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> messageList;
    private OnItemClickListener listener;
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    public interface OnItemClickListener {
        void onItemClick(Message message);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mMessageImage;
        TextView mMessageName;
        TextView mMessageContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mMessageImage = itemView.findViewById(R.id.message_image);
            mMessageName = itemView.findViewById(R.id.message_name);
            mMessageContent = itemView.findViewById(R.id.message_content);
        }

        public void bind(Message message) {
            mMessageImage.setImageResource(message.getImageId());
            mMessageName.setText(message.getName());
            mMessageContent.setText(message.getContent());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                Message message = messageList.get(position);
                listener.onItemClick(message);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
