package com.train.common.utils;

import com.train.common.core.page.PageDomain;
import com.train.common.core.page.TableSupport;
import com.github.pagehelper.PageHelper;
import com.train.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 * 
 * @author relief
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }
}
