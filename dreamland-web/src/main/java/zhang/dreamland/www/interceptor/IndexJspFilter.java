package zhang.dreamland.www.interceptor;

import org.springframework.context.ApplicationContext;

import tk.mybatis.mapper.entity.Example;
import org.springframework.web.context.support.WebApplicationContextUtils;
import zhang.dreamland.www.common.PageHelper;
import zhang.dreamland.www.dao.UserContentMapper;
import zhang.dreamland.www.entity.UserContent;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class IndexJspFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("============自定义过滤器===========");
        ServletContext context = servletRequest.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        UserContentMapper userContentMapper = ctx.getBean(UserContentMapper.class);
        PageHelper.startPage(null,null);//开始分页

        Example e = new Example(UserContent.class);
        e.setOrderByClause("rpt_time DESC");


        List<UserContent> list = userContentMapper.selectByExample(e);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        servletRequest.setAttribute("page", endPage );
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
