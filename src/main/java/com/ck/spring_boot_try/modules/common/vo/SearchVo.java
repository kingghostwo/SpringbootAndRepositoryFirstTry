package com.ck.spring_boot_try.modules.common.vo;

import lombok.Data;

@Data
public class SearchVo {
    public final static int DEFAULT_CURRENT_PAGE = 1;
    public final static int DEFAULT_PAGE_SIZE = 5;
    private int currentPage;
    private int pageSize;
    private String keyWord;
    private String orderBy;
    private String sort;

    public void initSearchVo() {
        if (this != null) {
            this.setCurrentPage(this.getCurrentPage() == 0 ?
                    DEFAULT_CURRENT_PAGE : this.getCurrentPage());
            this.setPageSize(this.getPageSize() == 0 ?
                    DEFAULT_PAGE_SIZE : this.getPageSize());
        }
    }
}
