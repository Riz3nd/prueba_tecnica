package com.rizend.prueba_tecnica.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizend.prueba_tecnica.R;
import com.rizend.prueba_tecnica.model.usermodel.User;
import com.rizend.prueba_tecnica.utils.Utils;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder>{
    private ArrayList<User> mData;
    private ArrayList<User> auxData;
    private LayoutInflater mInflate;
    private Context mContext;

    public UserAdapter(Context context, ArrayList<User> data){
        this.mInflate = LayoutInflater.from(context);
        this.mData = data;
        if(auxData == null){
            this.auxData = new ArrayList<>();
            auxData.addAll(mData);
        }
    }

    @NonNull
    @Override
    public UserAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.list_users, null);
        return new UserAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewHolder holder, int position) {
        holder.binData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView name, userName, email, phone, webSite, initials, userID;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.user_name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            webSite = itemView.findViewById(R.id.website);
            initials = itemView.findViewById(R.id.initials);
            userID = itemView.findViewById(R.id.user_id);
        }

        public void binData(User user) {
            name.setText(user.getName());
            userName.setText(user.getUsername());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
            webSite.setText(user.getWebsite());
            initials.setText(Utils.getInitals(user.getName()));
            userID.setText(" "+user.getId());
        }
    }

    public void filter(String str){
        if (str.length() != 0) {
            mData.clear();
            for (User userlist : auxData) {
                if (userlist.getUsername().toLowerCase().contains(str.toLowerCase())) {
                    mData.add(userlist);
                }
            }
        }else{
            mData.clear();
            mData.addAll(auxData);
        }
        notifyDataSetChanged();
    }
}
