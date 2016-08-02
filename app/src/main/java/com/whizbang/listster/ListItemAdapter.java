package com.whizbang.listster;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whizbang.listster.ListItemAdapter.ListItemViewHolder;
import com.whizbang.listster.databinding.ListItemRowBinding;

import java.util.ArrayList;
import java.util.List;


public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {


    private ArrayList<UserList> mDataset;


    public ListItemAdapter(ArrayList<UserList> data) {
        mDataset = data;
    }


    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;


        public ListItemViewHolder(ListItemRowBinding binding) {
            super(binding.getRoot());
            titleTextView = binding.title;
        }
    }


    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item_row, parent, false);
        return new ListItemViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.titleTextView.setText(mDataset.get(position).title);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public void addItem(UserList listItem) {
        mDataset.add(0, listItem);
        notifyDataSetChanged();
    }


    public void setItems(List<UserList> items) {
        mDataset.clear();
        mDataset.addAll(items);
        notifyDataSetChanged();
    }
}
