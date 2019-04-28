package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import com.sinovatio.domain.FileConfig;
import com.sinovatio.domain.FileContent;
import com.sinovatio.service.FileService;
import com.sinovatio.service.query.FileQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
* @ClassName: QiniuController
* @Description: 文件云存储服务接口
* @Author JinLu
* @Date 2019/4/19 16:13
* @Version 1.0
*/
@Slf4j
@RestController
@RequestMapping("api")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileQueryService fileQueryService;

    @GetMapping(value = "/qiNiuConfig")
    public ResponseEntity get(){
        return new ResponseEntity(fileService.find(), HttpStatus.OK);
    }

    @Log("配置文件云存储")
    @PutMapping(value = "/qiNiuConfig")
    public ResponseEntity emailConfig(@Validated @RequestBody FileConfig fileConfig){
        fileService.update(fileConfig);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("查询文件")
    @GetMapping(value = "/qiNiuContent")
    public ResponseEntity getRoles(FileContent resources, Pageable pageable){
        return new ResponseEntity(fileQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    /**
     * 上传文件到文件云
     * @param file
     * @return
     */
    @Log("上传文件")
    @PostMapping(value = "/qiNiuContent")
    public ResponseEntity upload(@RequestParam MultipartFile file){
        FileContent fileContent = fileService.upload(file,fileService.find());
        Map map = new HashMap();
        map.put("id", fileContent.getId());
        map.put("errno",0);
        map.put("data",new String[]{fileContent.getUrl()});
        return new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * 同步文件云数据到数据库
     * @return
     */
    @Log("同步文件云数据")
    @PostMapping(value = "/qiNiuContent/synchronize")
    public ResponseEntity synchronize(){
        log.warn("REST request to synchronize qiNiu : {}");
        fileService.synchronize(fileService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 下载文件云
     * @param id
     * @return
     * @throws Exception
     */
    @Log("下载文件")
    @GetMapping(value = "/qiNiuContent/download/{id}")
    public ResponseEntity download(@PathVariable Long id){
        Map map = new HashMap();
        map.put("url", fileService.download(fileService.findByContentId(id),fileService.find()));
        return new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * 删除文件云
     * @param id
     * @return
     * @throws Exception
     */
    @Log("删除文件")
    @DeleteMapping(value = "/qiNiuContent/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        fileService.delete(fileService.findByContentId(id),fileService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}
