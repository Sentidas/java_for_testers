package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        int newGroupCount = app.groups().getCount();
        assertEquals(groupCount + 1, newGroupCount);
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData("", "", ""));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some group name");
        app.groups().createGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some group header"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("some group footer"));
    }
}
