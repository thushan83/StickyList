package list.srisoft.com.stickylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.models.ItemBase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ItemAdapter<GroupViewHolder, MemberViewHolder, ItemBase> adapter = new ItemAdapter<>(R.layout.group_item_view,
                R.layout.child_item_view, GroupViewHolder.class, MemberViewHolder.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<ItemBase> items = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            Group group1 = new Group();
            group1.setGroupName("Group"+i);
            items.add(group1);
        }

        //adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setData(items);
    }
}
