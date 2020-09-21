package com.pet.survery.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Woostalk
 */
@Component
public class CorsFilter implements Filter {

    static Logger logger = LoggerFactory.getLogger(com.pet.survery.filter.CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String curOrigin = request.getHeader("Origin");

        String curAllowOrigin = response.getHeader("Access-Control-Allow-Origin");
        //获取远程登陆ip地址
        String remoteAddr = req.getRemoteAddr();
        logger.info("\n\t ----------- IN CorsFilter -  curAllowOrigin: "+curAllowOrigin);
        logger.info("用户登录Ip地址:"+remoteAddr);
        //当前不允许跨域  设置跨域
        if(!"*".equals(curAllowOrigin)){
            if(allowOrigin(curOrigin)) {
                //curOrigin
                response.setHeader("Access-Control-Allow-Origin","*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Credentials","true");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,Accept,x-requested-with");
                response.setHeader("Access-Control-Expose-Headers","Content-Type,Content-Length,Authorization,Accept,x-requested-with");
                //response.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
            }
        }


        chain.doFilter(req, response);
    }

    private boolean allowOrigin(String curOrigin) {
        if(curOrigin==null){
            return false;
        }
        curOrigin = curOrigin.toLowerCase()
                    .replace("http://","");
//                    .replace("https://","");

        if(curOrigin!=null && (curOrigin.startsWith("120.27.")||curOrigin.startsWith("127.0.")
                ||curOrigin.startsWith("localhost")||curOrigin.startsWith("192.168.")
            )   ){
            logger.info("\n\t----允许跨域：Origin={} ", curOrigin);
            return true;
        }else{
            logger.info("\n\t----不允许跨域：Origin={} ", curOrigin);
            return false;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}
