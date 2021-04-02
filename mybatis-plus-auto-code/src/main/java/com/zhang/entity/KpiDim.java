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

@TableName("zt_kpi_dim")
public class KpiDim extends Model<KpiDim> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 指标所属类别
     */
    private Integer kpiTypeId;
    /**
     * 指标名称
     */
    private String kpiDesc;
    /**
     * 默认单位
     */
    private String unit;
    /**
     * 核定部门id
     */
    private Integer deptId;
    /**
     * 删除标记
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

    public Integer getKpiTypeId() {
        return kpiTypeId;
    }

    public void setKpiTypeId(Integer kpiTypeId) {
        this.kpiTypeId = kpiTypeId;
    }

    public String getKpiDesc() {
        return kpiDesc;
    }

    public void setKpiDesc(String kpiDesc) {
        this.kpiDesc = kpiDesc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
        return "KpiDim{" +
        ", id=" + id +
        ", kpiTypeId=" + kpiTypeId +
        ", kpiDesc=" + kpiDesc +
        ", unit=" + unit +
        ", deptId=" + deptId +
        ", del=" + del +
        ", sort=" + sort +
        "}";
    }
}
