package list.srisoft.com.stickylist.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import list.srisoft.com.stickylist.models.ItemBase;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public abstract class ViewHolderBase<T extends ItemBase> extends RecyclerView.ViewHolder {

    public ViewHolderBase(View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}
