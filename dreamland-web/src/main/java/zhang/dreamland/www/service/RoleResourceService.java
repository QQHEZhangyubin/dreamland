package zhang.dreamland.www.service;

import zhang.dreamland.www.entity.Role;
import zhang.dreamland.www.entity.RoleResource;

import java.util.List;

public interface RoleResourceService {
    /**
     * 添加roleResource
     * @param roleResource
     */
    void add(RoleResource roleResource);

    /**
     * 根据id查询RoleResource
     *
     * @param id
     * @return
     */
    RoleResource findById(Long id);

    /**
     * 根据角色id查询角色资源集合
     * @param rid
     * @returnsource
     */
    List<RoleResource> findByRoleId(Long rid);

    /**
     * 根据id删除RoleRe
     * @param id
     */
    void deleteById(Long id);
}
