package com.sinovatio.repository;

import com.sinovatio.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @ClassName: PictureRepository
* @Description: 图片配置
* @Author JinLu
* @Date 2019/4/3 17:33
* @Version 1.0
*/
public interface PictureRepository extends JpaRepository<Picture,Long>, JpaSpecificationExecutor {
}
