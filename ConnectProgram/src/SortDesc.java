import java.util.ArrayList;
import java.util.List;

public class SortDesc {
    private List<convertToArray> userList = new ArrayList<>();

    public SortDesc(List<convertToArray> userList)
    {
        setUserList(userList);
    }

    public List<convertToArray> getUserList() {
        return userList;
    }

    public void setUserList(List<convertToArray> userList) {
        this.userList = userList;
    }

    public List<convertToArray> sort()
    {
        List<convertToArray> userList = getUserList();

        convertToArray tmp = null;

        //  2 1
        // 1 2 3 4 5 6
        for(int i = 0; i < 99; i++)
        {
            for(int j = 0; j < 99; j++)
            {
                tmp = new convertToArray();

                if(userList.get(j).getFilm_id() < userList.get(j+1).getFilm_id()) {
                tmp = userList.get(j);
                userList.set(j, userList.get(j+1));
                userList.set(j+1, tmp);
                }
            }
        }

        return userList;
    }

}
