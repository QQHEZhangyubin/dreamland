package zhang.dreamland.www.service;

import zhang.dreamland.www.common.PageHelper;
import zhang.dreamland.www.entity.Comment;
import zhang.dreamland.www.entity.UserContent;

import java.util.List;

public interface UserContentService {
    /**
     * 查询所有Content并分页
     *
     */
    PageHelper.Page<UserContent> findAll( UserContent content,Integer pageNum,Integer pageSize);
    PageHelper.Page<UserContent> findAll(UserContent content, Comment comment,Integer pageNum,Integer pageSize);
    PageHelper.Page<UserContent> findAllByUpvote(UserContent content,Integer pageNum,Integer pageSize);

    /**
     * 添加文章
     */
    int addContent(UserContent content);

    /**
     *根据用户id查询文章集合
     */
    List<UserContent> findByUserId(Long uid);

    /**
     * 查询所有文章
     */
    List<UserContent> findAll();

    /**
     * 根据文章id查找文章
     */
    UserContent findById(Long id);

    /**
     * 根据文章更新文章
     */
    void updateById(UserContent content);

    /**
     * 根据用户id查询出梦分类
     * @param uid
     * @return
     */
    List<UserContent> findCategoryByUid(Long uid);

    /**
     * 根据文章分类查询所有的文章
     * @param category
     * @param uid
     * @param pageNum
     * @param pigeSize
     * @return
     */
    PageHelper.Page<UserContent> findByCategory(String category,Long uid,Integer pageNum,Integer pigeSize);
    /**
     * 根据用户id查询所有文章私密并分页
     * @param uid
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<UserContent> findPersonal(Long uid ,Integer pageNum, Integer pageSize);
    /**
     * 根据文章id删除文章
     * @param cid
     */
    void deleteById(Long cid);
    /**
     * 根据发布时间倒排序并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<UserContent> findAll(Integer pageNum, Integer pageSize);
}
