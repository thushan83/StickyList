package list.srisoft.com.stickylist;

import list.srisoft.com.stickylist.models.ChildItem;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class Member extends ChildItem {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
