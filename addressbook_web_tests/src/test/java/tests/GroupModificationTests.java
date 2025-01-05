package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
        app.groups().createGroup(new GroupData("", "group name", "group header", "group footer"));
    }
        List<GroupData> oldGroups = app.groups().getList();
        var index = new Random().nextInt(oldGroups.size());
        GroupData modifiedData = new GroupData().withName("modified13 group name");
        app.groups().modifyGroup(oldGroups.get(index), modifiedData);
        List<GroupData> newGroups = app.groups().getList();
        List<GroupData> expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, modifiedData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        assertEquals(expectedList, newGroups);
}
}
