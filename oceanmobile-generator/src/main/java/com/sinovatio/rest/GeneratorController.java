package com.sinovatio.rest;

import cn.hutool.core.util.PageUtil;
import com.sinovatio.domain.vo.ColumnInfo;
import com.sinovatio.exception.BadRequestException;
import com.sinovatio.service.GenConfigService;
import com.sinovatio.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* @ClassName: GeneratorController
* @Description: 代码生成接口
* @Author JinLu
* @Date 2019/4/3 13:57
* @Version 1.0
*/
@RestController
@RequestMapping("api")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private GenConfigService genConfigService;

    @Value("${generator.enabled}")
    private Boolean generatorEnabled;

    /**
     * @Author JinLu
     * @Description: 查询数据库元数据
     * @Param [name, page, size]
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 13:58
    */
    @GetMapping(value = "/generator/tables")
    public ResponseEntity getTables(@RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "0")Integer page,
                                   @RequestParam(defaultValue = "10")Integer size){
        int[] startEnd = PageUtil.transToStartEnd(page+1, size);
        return new ResponseEntity(generatorService.getTables(name,startEnd), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 
     * @param tableName 查询表内元数据
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 14:36
    */
    @GetMapping(value = "/generator/columns")
    public ResponseEntity getTables(@RequestParam String tableName){
        return new ResponseEntity(generatorService.getColumns(tableName), HttpStatus.OK);
    }

    /**
     * @Author JinLu
     * @Description: 生成代码
     * @param columnInfos  列信息
     * @param tableName 表名
     * @Return org.springframework.http.ResponseEntity
     * @Date 2019/4/3 14:36
    */
    @PostMapping(value = "/generator")
    public ResponseEntity generator(@RequestBody List<ColumnInfo> columnInfos, @RequestParam String tableName){
        if(!generatorEnabled){
            throw new BadRequestException("此环境不允许生成代码！");
        }
        generatorService.generator(columnInfos,genConfigService.find(),tableName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
