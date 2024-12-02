import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeleteTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup(new GroupData("name", "header", "footer"));
        }
        removeGroup();
    }
}
