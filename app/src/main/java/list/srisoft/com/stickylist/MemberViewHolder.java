package list.srisoft.com.stickylist;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import list.srisoft.com.stickylist.holders.ChildItemViewHolder;
import list.srisoft.com.stickylist.models.ChildItem;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class MemberViewHolder extends ChildItemViewHolder {
    public MemberViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ChildItem item) {
        Log.d("sample","MemberViewHolder bind");
        TextView tvChildCption = itemView.findViewById(R.id.child_caption);
        Member member = (Member) item;
        tvChildCption.setText(member.getFullName());
    }
}
