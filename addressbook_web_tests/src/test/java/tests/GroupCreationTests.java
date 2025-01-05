package tests;

import model.GroupData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for(var name : List.of("", "group name")) {
            for(var header : List.of("", "group header")) {
                for(var footer : List.of("", "group footer")){
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 1; i <= 5; i++) {
            result.add(new GroupData()
                    .withName(ramdomString(i * 10))
                    .withHeader(ramdomString(i * 10))
                    .withFooter(ramdomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        return new ArrayList<>(List.of(
                new GroupData("", "group ' name", "", "")));
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultipleGroups(GroupData group) {
        List<GroupData> oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        List<GroupData> newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);

        List<GroupData> expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        assertEquals(expectedList, newGroups);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CanNotCreateGroup(GroupData group) {
        List<GroupData> oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        List<GroupData> newGroups = app.groups().getList();
        assertEquals(newGroups, oldGroups);
    }
}
