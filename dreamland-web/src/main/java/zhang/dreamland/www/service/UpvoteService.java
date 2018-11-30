package zhang.dreamland.www.service;

import zhang.dreamland.www.entity.Upvote;

public interface UpvoteService {
    /**
     * 根据用户id和文章id查询
     */
    Upvote findByUidAndConId(Upvote upvote);
    /**
     * 添加upvote
     */
    int add(Upvote upvote);
    /**
     * 根据用户id查询最后一次登陆的Upvote
     */
    Upvote getByUid(Upvote upvote);

    /**
     * 更新Upvote
     */
    void update(Upvote upvote);
    /**
     * 根据文章id删除Upvote
     * @param cid
     */
    void deleteByContentId(Long cid);
}
