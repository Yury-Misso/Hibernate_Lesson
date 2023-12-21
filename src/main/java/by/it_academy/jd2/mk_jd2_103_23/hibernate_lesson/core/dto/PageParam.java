package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("PageParam")
public class PageParam {
    private int pageNo;
    private int sizePage;

    private int maxPage;

    public PageParam() {
    }

    public PageParam(int pageNo, int sizePage, int maxPage) {
        this.pageNo = pageNo;
        this.sizePage = sizePage;
        this.maxPage = maxPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageParam pageParam = (PageParam) o;

        if (pageNo != pageParam.pageNo) return false;
        if (sizePage != pageParam.sizePage) return false;
        return maxPage == pageParam.maxPage;
    }

    @Override
    public int hashCode() {
        int result = pageNo;
        result = 31 * result + sizePage;
        result = 31 * result + maxPage;
        return result;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNo=" + pageNo +
                ", sizePage=" + sizePage +
                ", maxPage=" + maxPage +
                '}';
    }
}
