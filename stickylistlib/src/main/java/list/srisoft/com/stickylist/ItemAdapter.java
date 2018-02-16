package list.srisoft.com.stickylist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.holders.ChildItemViewHolder;
import list.srisoft.com.stickylist.holders.GroupItemViewHolder;
import list.srisoft.com.stickylist.holders.ViewHolderBase;
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
    private Class<GIVH> typeGroupHolder;
    private Class<CIVH> typeChildHolder;

    public ItemAdapter(int groupLayout, int childLayout,
                       Class<GIVH> typeGroupHolder, Class<CIVH> typeChildHolder) {
        this.groupLayout = groupLayout;
        this.childLayout = childLayout;
        this.typeGroupHolder = typeGroupHolder;
        this.typeChildHolder = typeChildHolder;
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
    public void onBindViewHolder(ViewHolderBase holder, int position) {
        Log.d("SL", "onBindViewHolder - " + position);
        ItemBase item = items.get(position);
        holder.bind(item);
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

    public void setData(List<T> data) {
        Log.d("SL", "setData");
        items.addAll(data);
    }
}
