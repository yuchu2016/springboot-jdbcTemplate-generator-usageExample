package com.octopus.crudjdbc.common;
import lombok.Data;

/**
 * 分页请求参数类
 *
 * @author yuchu
 * @email 
 * @date 2018-04-27 10:53:13
 */
@Data
public class PageRequest{

    private static final int NUMBERS_PER_PAGE = 10;

    private int pageNum;

    private int pageSize;

    public PageRequest() {
        this.pageNum = 1;
        this.pageSize = NUMBERS_PER_PAGE;
    }

    public PageRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}

