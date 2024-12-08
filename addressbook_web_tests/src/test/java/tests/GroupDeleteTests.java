package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupDeleteTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        List<GroupData> oldGroups = app.groups().getList();
        var index = new Random().nextInt(oldGroups.size());

        app.groups().removeGroup(oldGroups.get(index));
        List<GroupData> newGroups = app.groups().getList();
        List<GroupData> expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        assertEquals(newGroups, expectedList);
    }

    @Test
    void canDeleteAllCroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        app.groups().removeAllGroups();
        assertEquals(0, app.groups().getCount());
    }
}
