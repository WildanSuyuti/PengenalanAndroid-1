package com.flashcomindonesia.androiddasar.feature.inbox;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flashcomindonesia.androiddasar.R;
import com.flashcomindonesia.androiddasar.model.Inbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kakaroto on 21/08/18.
 */
public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    List<Inbox> inboxes;

    public InboxAdapter() {
        inboxes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inbox, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvPengirim.setText(inboxes.get(position).getPengirim());
        holder.tvPesan.setText(inboxes.get(position).getPesan());
        holder.tvJam.setText(inboxes.get(position).getJam());
    }

    @Override
    public int getItemCount() {
        return inboxes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPengirim, tvPesan, tvJam;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPengirim = itemView.findViewById(R.id.tv_pengirim);
            tvPesan = itemView.findViewById(R.id.tv_pesan);
            tvJam = itemView.findViewById(R.id.tv_jam);
        }
    }

    public void add(Inbox inbox) {
        inboxes.add(inbox);
        notifyDataSetChanged();
    }

    public void addAll(List<Inbox> inboxes) {
        this.inboxes.addAll(inboxes);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        inboxes.remove(position);
        notifyDataSetChanged();
    }
}
