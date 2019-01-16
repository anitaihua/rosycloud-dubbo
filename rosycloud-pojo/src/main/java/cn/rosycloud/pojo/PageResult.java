package cn.rosycloud.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回的实体类
 * @author jt
 *
 */
public class PageResult implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -8040100620884340025L;

    private long total; // 总记录数
    private List rows; // 返回每页的数据的集合

    public PageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}

