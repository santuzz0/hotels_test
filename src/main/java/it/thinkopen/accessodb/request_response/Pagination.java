package it.thinkopen.accessodb.request_response;

public class Pagination {
    private Integer perPage;
    private Integer currentPage;
    private Integer totalPages;

    public Pagination() {
    }

    public Pagination(int perPage, int currentPage, int totalPages) {
        this.perPage = perPage;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
