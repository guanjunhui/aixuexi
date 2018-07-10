package com.manong.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

public class AuthorityIntercept extends HandlerInterceptorAdapter {

    private List<String> allowList = Arrays.asList(
            "/student/list",
            "/index",
            "/login"
    );

    private static final PathMatcher PATH_MATCHER = new AntPathMatcher();

    private String upload_path;

    private boolean isSetApplication = false;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(!isSetApplication) {
            isSetApplication = true;
            ServletContext application = request.getSession().getServletContext();
//            application.setAttribute(Constants.FILE_PATH, upload_path);
        }

        if (!checkAllowAccess(request.getRequestURI())) {
            HttpSession session = request.getSession();
            Object userInfo = session.getAttribute("currentUser");
            if (userInfo == null) {
                //判断是否是ajax请求
                if(isAjaxRequest(request)) {
                    response.getWriter().print("please login");
                } else {
                    //session为空,跳到登录页
                    response.sendRedirect(request.getContextPath() + "/login");
                }
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 检查URI是否放行
     *
     * @param URI
     * @return 返回检查结果
     */
    private boolean checkAllowAccess(String URI) {
        if (!URI.startsWith("/")) {
            URI = "/" + URI;
        }
        for (String allow : allowList) {
            if (PATH_MATCHER.match(allow, URI)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        // 判断是否为ajax请求，默认不是
        boolean isAjaxRequest = false;
        if (StringUtils.isNotBlank(request.getHeader("x-requested-with"))
                && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }

    public List<String> getAllowList() {
        return allowList;
    }

    public void setAllowList(List<String> allowList) {
        this.allowList = allowList;
    }

}
