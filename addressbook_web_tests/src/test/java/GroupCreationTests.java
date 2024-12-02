import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        createGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new GroupData("", "", ""));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithHeaderOnly() {
        openGroupsPage();
        createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        openGroupsPage();
        createGroup(new GroupData().withFooter("some footer"));
    }
}
