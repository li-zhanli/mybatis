package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepMapper {
    List<User> getDepAndUser(@Param("id") int id);
}
