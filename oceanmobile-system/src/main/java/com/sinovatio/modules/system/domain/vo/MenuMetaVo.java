package com.sinovatio.modules.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
* @ClassName: MenuMetaVo
* @Description: 菜单元视图数据
* @Author JinLu
* @Date 2019/4/19 15:43
* @Version 1.0
*/
@Data
@AllArgsConstructor
public class MenuMetaVo implements Serializable {

    private String title;

    private String icon;
}
