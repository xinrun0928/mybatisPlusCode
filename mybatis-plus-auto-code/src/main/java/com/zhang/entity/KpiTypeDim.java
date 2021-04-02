package com.zhang.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZhangXinRun
 * @since 2021-03-25
 */
@TableName("zt_kpi_type_dim")
public class KpiTypeDim extends Model<KpiTypeDim> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 夫级别ID
     */
    private Integer parentType;
    /**
     * 级别 1，2
     */
    private Integer typeLevel;
    /**
     * 描述
     */
    private String typeDesc;
    /**
     * 5
     */
    private Integer del;
    /**
     * 排序
     */
    private Integer sort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentType() {
        return parentType;
    }

    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "KpiTypeDim{" +
        ", id=" + id +
        ", parentType=" + parentType +
        ", typeLevel=" + typeLevel +
        ", typeDesc=" + typeDesc +
        ", del=" + del +
        ", sort=" + sort +
        "}";
    }
}
