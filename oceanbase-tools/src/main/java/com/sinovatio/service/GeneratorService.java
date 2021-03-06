package com.sinovatio.service;

import com.sinovatio.domain.GenConfig;
import com.sinovatio.domain.vo.ColumnInfo;
import java.util.List;

/**
* @ClassName: GeneratorService
* @Description: 代码生成
* @Author JinLu
* @Date 2019/4/19 14:27
* @Version 1.0
*/
public interface GeneratorService {

    /**
     * 查询数据库元数据
     * @param name
     * @param startEnd
     * @return
     */
    Object getTables(String name, int[] startEnd);

    /**
     * 得到数据表的元数据
     * @param name
     * @return
     */
    Object getColumns(String name);

    /**
     * 生成代码
     * @param columnInfos
     * @param genConfig
     * @param tableName
     */
    void generator(List<ColumnInfo> columnInfos, GenConfig genConfig, String tableName);
}
