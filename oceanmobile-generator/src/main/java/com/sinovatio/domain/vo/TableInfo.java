package com.sinovatio.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TableInfo
* @Description: 表的数据信息
* @Author JinLu
* @Date 2019/4/3 13:54
* @Version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {

    /** 表名称 **/
    private Object tableName;

    /** 创建日期 **/
    private Object createTime;
}
