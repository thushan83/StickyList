package list.srisoft.com.stickylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        extends RecyclerView.Adapter<ViewHolderBase>{

    private List<T> items= new ArrayList<>();
    private int groupLayout;
    private int childlayout;

    public ItemAdapter(int groupLayout, int childlayout) {
        this.groupLayout = groupLayout;
        this.childlayout = childlayout;
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(viewType == Type.CHILD.ordinal()){
           view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(childlayout, parent, false);
           return new ChildItemViewHolder(view);
        }

        if(viewType == Type.GROUP.ordinal()){
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(groupLayout, parent, false);
            return new GroupItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderBase holder, int position) {
        ItemBase item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemViewType(int position) {
        ItemBase item = items.get(position);
        if(item.getType() == Type.CHILD){
            return Type.CHILD.ordinal();
        }else {
            return Type.GROUP.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<T> data) {
        items.addAll(data);
    }
}
