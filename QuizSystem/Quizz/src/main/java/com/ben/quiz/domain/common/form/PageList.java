package com.ben.quiz.domain.common.form;
 
import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable {
 
   private static final long serialVersionUID = 1L;
 
   public PageList() {
 
   }
 
   public PageList(List<T> searchResult, int totalRowsCount) {
 
       this.setSearchResult(searchResult);
       this.setTotalRowCount(totalRowsCount);
 
   }
 
   /** Search result (target page) */
   private List<T> searchResult;
 
   /** Number of search results (all pages) */
   private int totalRowCount;
 
   public List<T> getSearchResult() {
       return searchResult;
   }
 
   public void setSearchResult(List<T> searchResult) {
       this.searchResult = searchResult;
   }
 
   public int getTotalRowCount() {
       return totalRowCount;
   }
 
   public void setTotalRowCount(int totalRowCount) {
       this.totalRowCount = totalRowCount;
   }
 
}