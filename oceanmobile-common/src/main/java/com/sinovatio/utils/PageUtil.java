package com.sinovatio.utils;

import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @ClassName: PageUtil
* @Description: 分页工具
* @Author JinLu
* @Date 2019/4/3 11:51
* @Version 1.0
*/
public class PageUtil extends cn.hutool.core.util.PageUtil {

    /**
     * @Author JinLu
     * @Description:  分页
     * @Param [page, size, list]
     * @Return java.util.List
     * @Date 2019/4/3 11:51
    */
    public static List toPage(int page, int size , List list) {
        int fromIndex = page * size;
        int toIndex = page * size + size;

        if(fromIndex > list.size()){
            return new ArrayList();
        } else if(toIndex >= list.size()) {
            return list.subList(fromIndex,list.size());
        } else {
            return list.subList(fromIndex,toIndex);
        }
    }

    /**
     * @Author JinLu
     * @Description: Page 数据处理，预防redis反序列化报错
     * @Param [page]
     * @Return java.util.Map
     * @Date 2019/4/3 11:52
    */
    public static Map toPage(Page page) {
        Map map = new HashMap();

        map.put("content",page.getContent());
        map.put("totalElements",page.getTotalElements());

        return map;
    }

    /**
     * @Author JinLu
     * @Description: 分页
     * @Param [object, totalElements]
     * @Return java.util.Map
     * @Date 2019/4/3 11:52
    */
    public static Map toPage(Object object, Object totalElements) {
        Map map = new HashMap();

        map.put("content",object);
        map.put("totalElements",totalElements);

        return map;
    }

}
