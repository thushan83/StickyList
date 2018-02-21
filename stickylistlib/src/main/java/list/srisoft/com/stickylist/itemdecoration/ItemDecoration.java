package list.srisoft.com.stickylist.itemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import list.srisoft.com.stickylist.R;
import list.srisoft.com.stickylist.models.GroupItem;
import list.srisoft.com.stickylist.models.ItemGroup;

/**
 * Created by thushan.gunawardana on 2/21/2018.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {

    List<GroupItem> items;
    Context context;

    public ItemDecoration(List<GroupItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    private View inflateHeaderView(RecyclerView parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.sticky_header_layout,
                parent,
                false);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        for (int i = 1; i < parent.getChildCount(); i++) {
            if(items.get(i) instanceof GroupItem) {
                View headerView = inflateHeaderView(parent);
                TextView caption = headerView.findViewById(R.id.tvCaption);
                GroupItem target = items.get(i);
                View child = parent.getChildAt(i);
                ItemGroup itemGroup = target.getGroup();
                caption.setText(itemGroup.getGroupName());
                drawHeader(c, target, itemGroup, child, headerView);
            }
        }
    }

    private void drawHeader(Canvas c, GroupItem targetItem, ItemGroup group, View child, View headerView) {
        c.save();
        c.translate(0,0);
        headerView.draw(c);
        c.restore();
    }
}
