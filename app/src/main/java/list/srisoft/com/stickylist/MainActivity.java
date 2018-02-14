package list.srisoft.com.stickylist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.models.ItemBase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ItemAdapter<GroupViewHolder, MemberViewHolder, ItemBase> adapter = new ItemAdapter<>(R.layout.group_item_view,
                R.layout.child_item_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<ItemBase> items = new ArrayList<>();
        Group group1=new Group();
        group1.setGroupName("Group1");

        Group group2=new Group();
        group1.setGroupName("Group2");

        Group group3=new Group();
        group1.setGroupName("Group3");

        Group group4=new Group();
        group1.setGroupName("Group4");

        Group group5=new Group();
        group1.setGroupName("Group5");

        items.add(group1);
        items.add(group2);
        items.add(group3);
        items.add(group4);
        items.add(group5);

        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        adapter.setData(items);
        adapter.notifyDataSetChanged();
    }


}
