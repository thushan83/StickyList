package list.srisoft.com.stickylist.models;

import java.util.UUID;
import list.srisoft.com.stickylist.util.Type;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class ItemBase {
    private UUID id;
    private String name;
    private Type type;
    private ItemGroup group;
    private boolean expanded;

    public ItemBase() {
        this.id = UUID.randomUUID();
    }

    public Type getType() {
        return type;
    }

    protected void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemGroup getGroup() {
        return group;
    }

    public void setGroup(ItemGroup group) {
        this.group = group;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
