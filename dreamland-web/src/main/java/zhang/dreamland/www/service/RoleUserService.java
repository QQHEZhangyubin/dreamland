package zhang.dreamland.www.service;

import zhang.dreamland.www.entity.RoleUser;
import zhang.dreamland.www.entity.User;

import java.util.List;

public interface RoleUserService {
    /**
     * 根据用户查询角色用户集合
     */
    List<RoleUser> findByUser(User user);

    /**
     * 添加用户角色中间对象
     * @param roleUser
     * @return
     */
    int add(RoleUser roleUser);

    /**
     * 根据用户id删除
     * @param uid
     */
    void deleteByUid(Long uid);
}
