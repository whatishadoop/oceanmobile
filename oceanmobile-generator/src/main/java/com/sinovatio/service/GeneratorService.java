package com.sinovatio.service;

import com.sinovatio.domain.GenConfig;
import com.sinovatio.domain.vo.ColumnInfo;
import java.util.List;

/**
* @ClassName: GeneratorService
* @Description: 代码生成服务
* @Author JinLu
* @Date 2019/4/3 14:04
* @Version 1.0
*/
public interface GeneratorService {

    /**
     * @Author JinLu
     * @Description: 查询表名信息
     * @param name 表名
     * @param startEnd  表名开头字符
     * @Return java.lang.Object
     * @Date 2019/4/3 14:38
    */
    Object getTables(String name, int[] startEnd);

    /**
     * @Author JinLu
     * @Description: 得到数据表的元数据
     * @param name 表名
     * @Return java.lang.Object
     * @Date 2019/4/3 14:42
    */
    Object getColumns(String name);

    /**
     * @Author JinLu
     * @Description: 生成代码
     * @param columnInfos 列信息
     * @param genConfig 生成配置信息
     * @param tableName 表名
     * @Return void
     * @Date 2019/4/3 14:42
    */
    void generator(List<ColumnInfo> columnInfos, GenConfig genConfig, String tableName);
}
