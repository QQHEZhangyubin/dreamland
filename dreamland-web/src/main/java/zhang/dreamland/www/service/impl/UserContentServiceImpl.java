package zhang.dreamland.www.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import zhang.dreamland.www.common.PageHelper;
import zhang.dreamland.www.common.StringUtil;
import zhang.dreamland.www.dao.CommentMapper;
import zhang.dreamland.www.dao.UserContentMapper;
import zhang.dreamland.www.entity.Comment;
import zhang.dreamland.www.entity.UserContent;
import zhang.dreamland.www.service.UserContentService;


import java.util.List;

/**
 * Created by wly on 2018/1/9.
 */
@Service
public class UserContentServiceImpl implements UserContentService {
    @Autowired
    private UserContentMapper userContentMapper;
    @Autowired
    private CommentMapper commentMapper;
    public int addContent(UserContent content) {
        return userContentMapper.inserContent( content );
    }

    public List<UserContent> findByUserId(Long uid) {
        UserContent userContent = new UserContent();
        userContent.setuId(uid);
        List<UserContent> list = userContentMapper.select( userContent );
        return list;
    }

    public List<UserContent> findAll() {
        return userContentMapper.select( null );
    }

    @Override
    public UserContent findById(Long id) {
        UserContent userContent = new UserContent();
        userContent.setId( id );
        return userContentMapper.selectOne( userContent );
    }

    public PageHelper.Page<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize) {
        //分页查询
        System.out.println("第"+pageNum+"页");
        System.out.println("每页显示："+pageSize+"条");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list =  userContentMapper.select( content );
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        return endPage;
    }

    public PageHelper.Page<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize) {
        //分页查询
        System.out.println("第"+pageNum+"页");
        System.out.println("每页显示："+pageSize+"条");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list =  userContentMapper.select( content );

        List<Comment> comments = commentMapper.select( comment );

        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        List<UserContent> result = endPage.getResult();
        return endPage;
    }

    public PageHelper.Page<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize) {
        Example e = new Example(UserContent.class);
        e.setOrderByClause("upvote DESC");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list = userContentMapper.selectByExample(e);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        return endPage;
    }

    public UserContent findById(long id) {
        UserContent userContent = new UserContent();
        userContent.setId( id );
        return userContentMapper.selectOne( userContent );
    }


    public void updateById(UserContent content) {
        userContentMapper.updateByPrimaryKeySelective( content );
    }

    @Override
    public List<UserContent> findCategoryByUid(Long uid) {
        return userContentMapper.findCategoryByUid(uid);
    }

    @Override
    public PageHelper.Page<UserContent> findByCategory(String category, Long uid, Integer pageNum, Integer pageSize) {
        UserContent userContent = new UserContent();
        if (StringUtils.isNotBlank(category) && !"null".equals(category)){
            userContent.setCategory(category);
        }
        userContent.setuId(uid);
        userContent.setPersonal("0");
        PageHelper.startPage(pageNum,pageSize);//开始分页
        userContentMapper.select(userContent);
        PageHelper.Page endpage = PageHelper.endPage();//分页结束
        return endpage;
    }

    @Override
    public PageHelper.Page<UserContent> findPersonal(Long uid, Integer pageNum, Integer pageSize) {
        UserContent userContent = new UserContent();
        userContent.setuId(uid);
        userContent.setPersonal("1");
        PageHelper.startPage(pageNum,pageSize);
        userContentMapper.select(userContent);
        PageHelper.Page endpage = PageHelper.endPage();
        return endpage;
    }

    @Override
    public void deleteById(Long cid) {
        userContentMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public PageHelper.Page<UserContent> findAll(Integer pageNum, Integer pageSize) {
        //分页查询
        PageHelper.startPage(pageNum, pageSize);//开始分页
        Example e = new Example(UserContent.class);
        e.setOrderByClause("rpt_time DESC");
        List<UserContent> list =  userContentMapper.selectByExample(e);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        return endPage;
    }


}
