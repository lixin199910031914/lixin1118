package com.bawei.lixin1118.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lixin1118.R;
import com.bawei.lixin1118.entity.HomeEntity;

import java.util.List;

public class AAdapter extends RecyclerView.Adapter<AAdapter.OneHolder> {
    Context context;
    List<HomeEntity.ResultBean> result;
    private View inflate;

    public AAdapter(Context context, List<HomeEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new OneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.viewById.setText(result.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class OneHolder extends RecyclerView.ViewHolder {

        private final TextView viewById;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            viewById = inflate.findViewById(R.id.text_view);
        }
    }
}
