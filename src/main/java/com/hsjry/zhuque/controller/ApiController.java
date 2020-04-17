package com.hsjry.zhuque.controller;
 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
 
@Api(value = "ApiController",tags = "api入口")
@RestController("/")
public class ApiController {
 
    @ApiOperation(value = "GET方法",tags = "api入口")
    @GetMapping("getMethod/{data}")
    public String getMethod(@ApiParam(value = "携带参数",required = true) @PathVariable("data") String data){
        return "这是一个GET方法"+data;
    }
 
    @ApiOperation(value = "POST方法",tags = "api入口")
    @PostMapping("postMethod")
    public String postMethod(){
        return "这是一个POST方法";
    }
 
    @ApiOperation(value = "PUT方法",tags = "api入口")
    @PutMapping("putMethod/{data}")
    public String putMethod(@ApiParam(value = "携带参数",required = true) @PathVariable("data") String data){
        return "这是一个PUT方法"+data;
    }
 
    @ApiOperation(value = "DELETE方法",tags = "api入口")
    @DeleteMapping("deleteMethod/{data}")
    public String deleteMethod(@ApiParam(value = "携带参数",required = true) @PathVariable("data") String data){
        return "这是一个DELETE方法"+data;
    }
}