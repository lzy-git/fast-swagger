# 极速接口文档

#### 介绍
基于swagger3构建的新一代api文档，是支撑极速中台的基础二方库，也是极速项目的基础架构。


#### 使用说明

1. 创建springboot项目
2. 引入maven依赖
   ```  
    <dependency>
        <groupId>com.openyuan</groupId>
        <artifactId>fast-swagger</artifactId>
        <version>1.0.0</version>
    </dependency>
   ```
3. 在启动类加注解@EnableFastSwagger，如：
    ```
   @EnableFastSwagger
   @SpringBootApplication
   public class UserApplication {}
    ```
3. 在Spring Boot的项目配置文件application.yml中添加相应的配置，如：
   ```
    fast.swagger: 
        # 发布生产建议关闭API文档
        enable: true #swagger开启配置，true:开启，false:关闭。
        # 配置接口文档具体信息
        info: 
            title: "极速接口文档"
            description: "极速接口文档描述"
            service_url: "http://www.jisuframe.com"
            version: "1.0.0"
   ```

4. 在需要生成接口的contraller的方法上面使用@Api注解，方法上的关键字使用@ApiOperation，如:
   ```
    @Api(tags = {"喵喵用户中心:用户信息服务"})
    public class UserContraller {
        /**
        * 新增用户信息
        *
        * @param userReqDTO 请求对象
        * @return R 处理结果
        */
        @PostMapping("/save")
        @ApiOperation(value = "新增用户信息", notes = "内部调用")
        R save(@RequestBody UserReqDTO userReqDTO){}
    }
   ```

5. 在需要在dto生成参数使用ApiModel注解，属性上的关键字使用@ApiModelProperty，如:
   ```
   @ApiModel(value = "UserReqDTO", description = "用户信息Eo对象")
   public class UserReqDTO {
           
       /**
        * 用户账号
        */
       @ApiModelProperty(name = "userAccount", value = "用户账号")
       private String userAccount;
           
       /**
        * 用户昵称
        */
       @ApiModelProperty(name = "nickName", value = "用户昵称")
       private String nickName;
   }
   ```

#### swagger注解说明
1. 参数说明
   ```
   @Api：用在请求的类上，表示对类的说明
       tags="说明该类的作用，可以在UI界面上看到的注解"
       value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
   
   @ApiOperation：用在请求的方法上，说明方法的用途、作用
       value="说明方法的用途、作用"
       notes="方法的备注说明"
   
   @ApiImplicitParams：用在请求的方法上，表示一组参数说明
       @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
           name：参数名
           value：参数的汉字说明、解释
           required：参数是否必须传
           paramType：参数放在哪个地方
               · header --> 请求参数的获取：@RequestHeader
               · query --> 请求参数的获取：@RequestParam
               · path（用于restful接口）--> 请求参数的获取：@PathVariable
               · div（不常用）
               · form（不常用）    
           dataType：参数类型，默认String，其它值dataType="Integer"       
           defaultValue：参数的默认值
   
   @ApiResponses：用在请求的方法上，表示一组响应
       @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
           code：数字，例如400
           message：信息，例如"请求参数没填好"
           response：抛出异常的类
   
   @ApiModel：用于响应类上，表示一个返回响应数据的信息
               （这种一般用在post创建的时候，使用@RequestBody这样的场景，
               请求参数无法使用@ApiImplicitParam注解进行描述的时候）
       @ApiModelProperty：用在属性上，描述响应类的属性
   ```

#### QQ交流群
    群号：728192592  
    加群链接：https://qm.qq.com/cgi-bin/qm/qr?k=at9Vz5OnLTKIMdPVhpWNj8_CU1I-KXRQ&authKey=L%2FLcDXaWT7SvhqLA4OhzdIplpGf07N%2FgSvbmwFagtGB5o3JYtsgqlLuIqjUQ6vLb&noverify=0&group_code=728192592

#### 参与贡献
1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

