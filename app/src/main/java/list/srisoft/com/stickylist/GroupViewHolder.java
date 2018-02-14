package list.srisoft.com.stickylist;

import android.view.View;
import android.widget.TextView;

import list.srisoft.com.stickylist.holders.GroupItemViewHolder;
import list.srisoft.com.stickylist.models.GroupItem;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class GroupViewHolder extends GroupItemViewHolder {
    public GroupViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(GroupItem item) {
        TextView tvChildCption = itemView.findViewById(R.id.group_caption);
        Group member = (Group) item;
        tvChildCption.setText(member.getGroupName());
    }
}
