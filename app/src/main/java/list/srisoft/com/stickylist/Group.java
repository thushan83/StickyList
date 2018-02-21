package list.srisoft.com.stickylist;

import java.util.ArrayList;
import java.util.List;

import list.srisoft.com.stickylist.models.GroupItem;
import list.srisoft.com.stickylist.models.ItemBase;

/**
 * Created by thushan.gunawardana on 2/14/2018.
 */

public class Group extends GroupItem {

    private String groupName;
    private List<ItemBase> memberList = new ArrayList<>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ItemBase> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList.addAll(memberList);
    }
}
