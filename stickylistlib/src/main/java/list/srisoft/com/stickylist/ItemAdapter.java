package list.srisoft.com.stickylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.holders.ChildItemViewHolder;
import list.srisoft.com.stickylist.holders.GroupItemViewHolder;
import list.srisoft.com.stickylist.holders.ViewHolderBase;
import list.srisoft.com.stickylist.itemdecoration.ItemDecoration;
import list.srisoft.com.stickylist.models.GroupItem;
import list.srisoft.com.stickylist.models.ItemBase;
import list.srisoft.com.stickylist.util.Type;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class ItemAdapter<GIVH extends GroupItemViewHolder, CIVH extends ChildItemViewHolder
        , T extends ItemBase>
        extends RecyclerView.Adapter<ViewHolderBase> {

    private List<T> items = new ArrayList<>();
    private int groupLayout;
    private int childLayout;
    private T lastExpandedItem;
    private List<T> prevExpandedItems = new ArrayList<>();
    private Class<GIVH> typeGroupHolder;
    private Class<CIVH> typeChildHolder;
    private OnItemClickedListener onItemClickedListener;
    private RecyclerView recyclerView;

    public ItemAdapter(int groupLayout, int childLayout,
                       Class<GIVH> typeGroupHolder, Class<CIVH> typeChildHolder
            , RecyclerView recyclerView, Context context) {
        this.groupLayout = groupLayout;
        this.childLayout = childLayout;
        this.typeGroupHolder = typeGroupHolder;
        this.typeChildHolder = typeChildHolder;
        this.recyclerView = recyclerView;
        this.recyclerView.addItemDecoration(new ItemDecoration((List<GroupItem>) items, context));
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        ViewHolderBase holder = null;
        Log.d("SL", "onCreateViewHolder - " + viewType);
        if (viewType == Type.CHILD.ordinal()) {
            Log.d("SL", "ChildItemViewHolder");
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(childLayout, parent, false);
            try {
                holder = typeChildHolder.getConstructor(View.class).newInstance(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (viewType == Type.GROUP.ordinal()) {
            Log.d("SL", "GroupItemViewHolder");
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(groupLayout, parent, false);
            try {
                holder = typeGroupHolder.getConstructor(View.class).newInstance(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderBase holder, final int position) {
        Log.d("SL", "onBindViewHolder - " + position);
        final ItemBase item = items.get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prevExpandedItems != null) {
                    items.removeAll(prevExpandedItems);
                }

                notifyDataSetChanged();
                int pos = position - prevExpandedItems.size();
                int usableposition = pos < 0 ? position : pos;
                T item = items.get(usableposition);

                if (!item.isExpanded()){
                    onItemClickedListener.onItemClicked(usableposition);
                    item.setExpanded(true);
                } else {
                    item.setExpanded(false);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("SL", "getItemViewType - " + position);
        ItemBase item = items.get(position);
        if (item.getType() == Type.CHILD) {
            return Type.CHILD.ordinal();
        }

        if (item.getType() == Type.GROUP) {
            return Type.GROUP.ordinal();
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        Log.d("SL", "getItemCount - " + items.size());
        return items.size();
    }

    public void setOnClickListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public void setData(List<T> data) {
        Log.d("SL", "setData");
        items.addAll(data);
    }

    public void setData(int pos, List<T> data) {
        Log.d("SL", "setData");
        prevExpandedItems = data;
        lastExpandedItem = items.get(pos);
        lastExpandedItem.setExpanded(true);
        items.addAll(pos + 1, data);
        notifyItemRangeChanged(pos + 1, data.size());
    }

    interface OnItemClickedListener {
        void onItemClicked(int position);
    }
}
