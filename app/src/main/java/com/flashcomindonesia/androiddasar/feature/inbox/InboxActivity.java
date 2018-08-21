package com.flashcomindonesia.androiddasar.feature.inbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.flashcomindonesia.androiddasar.R;
import com.flashcomindonesia.androiddasar.model.Inbox;
import com.flashcomindonesia.androiddasar.utility.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class InboxActivity extends AppCompatActivity {

    RecyclerView rvInbox;
    InboxAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        rvInbox = findViewById(R.id.rv_inbox);
        adapter = new InboxAdapter();

        rvInbox.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        rvInbox.setAdapter(adapter);
        final List<Inbox> inboxes = new ArrayList<>();
        inboxes.add(new Inbox("Erix", "aaaaa aaa aaaaa", "12:10"));
        inboxes.add(new Inbox("Andi", "bbbbbbb bbbbbb", "13:10"));
        inboxes.add(new Inbox("Budi", "ccccc cccc cccc cccccccccc", "12:40"));
        inboxes.add(new Inbox("Rendi", "dddd dddddddd ddddd ddd ", "11:10"));
        inboxes.add(new Inbox("Sandi", "skkanslasnalns", "12:58"));
        adapter.addAll(inboxes);

        rvInbox.addOnItemTouchListener(new RecyclerTouchListener(this, rvInbox,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Toast.makeText(InboxActivity.this, "nama Pengirim: "
                                + inboxes.get(position).getPengirim(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        adapter.remove(position);
                    }
                }));
    }
}
