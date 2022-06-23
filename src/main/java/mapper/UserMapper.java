package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*查询所有用户*/
    List<User> selectAllUser();

    /*通过Id查询一个用户*/
    User selectUserById(@Param("id") Integer id);

    /*模糊查询，根据username字段查询用户*/
    User selectUserByName(String name);

    /*添加用户*/
    void insertUser(User user);

    /*根据ID更新用户*/
    void updateUser(User user);

    /*根据Id删除用户*/
    void deleteUser(Integer id);

    /*测试多个Id查询的语句*/
    List<User> selectUserByListUser(@Param("ids") List<Integer> ids);

    /*测试我的*/
    int selectAll();

    /*测试list*/
    List<Map<String,Object>> selectAllUserUser();

    /*测试association标签*/
    User getUserByAssociation(@Param("id") int id);

    User selectTwoCondition(Integer id, Integer age);

}
