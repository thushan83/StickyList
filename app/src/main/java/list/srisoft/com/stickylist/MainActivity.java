package list.srisoft.com.stickylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.models.ItemBase;

public class MainActivity extends AppCompatActivity {

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ItemAdapter<GroupViewHolder, MemberViewHolder, ItemBase> adapter = new ItemAdapter<>(R.layout.group_item_view,
                R.layout.child_item_view, GroupViewHolder.class, MemberViewHolder.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<ItemBase> items = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            Group group1 = new Group();
            group1.setGroupName("Group"+i);
            items.add(group1);
        }

       // adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setData(items);

        adapter.setOnClickListener(new ItemAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                int members = randomWithRange(1,10);
                List<ItemBase> itemList = new ArrayList<>();
                for(int j = 0; j < members; j++){
                    Member member = new Member();
                    member.setFullName("Member "+j);
                    itemList.add(member);
                }
                Log.d("Test","position - "+position);
                adapter.setData(position,itemList);
            }
        });

    }
}
