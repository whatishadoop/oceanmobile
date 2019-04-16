package com.sinovatio.domain;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @ClassName: QiniuContent
* @Description: 上传成功后，存储结果
* @Author JinLu
* @Date 2019/4/3 17:29
* @Version 1.0
*/
@Data
@Entity
@Table(name = "qiniu_content")
public class QiniuContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文件名，如qiniu.jpg
     */
    @Column(name = "name",unique = false)
    private String key;

    /**
     * 空间名
     */
    private String bucket;

    /**
     * 大小
     */
    private String size;

    /**
     * 文件地址
     */
    private String url;

    /**
     * 空间类型：公开/私有
     */
    private String type = "公开";

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;
}
