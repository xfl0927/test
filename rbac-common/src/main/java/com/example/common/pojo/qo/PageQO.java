package com.example.common.pojo.qo;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页查询入参
 *
 * @author Jack
 * @date 2020/04/25
 */
public class PageQO extends AbstractQO {

    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 每页的条数
     */
    @ApiParam(value = "分页参数，每页的条数", example = "20")
    @Max(value = 1000, message = "pageSize不能大于1000")
    protected Integer pageSize;

    /**
     * 当前第几页
     */
    @ApiParam(value = "分页参数，第几页", example = "1")
    @Min(value = 1, message = "pageNo不能小于1")
    protected Integer pageNo;

    public PageQO() {
        // 默认第一页，每页20条
        this(1, 20);
    }

    public PageQO(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = DEFAULT_PAGE_NO;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartIndex() {
        return (pageNo - 1) * pageSize;
    }
    public int getEndIndex() {
        return pageNo * pageSize;
    }

}

