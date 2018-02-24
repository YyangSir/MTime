# MTime
一个基于spring boot微服务架构的影评系统<br>
spring boot真的简约方便因为约定大于配置的原则省去了很多杂乱的xml文件整个项目都变的清爽了。部署到服务器也是非常简单的使用maven打包上传服务器后执行命令java -jar 项目包名.jar即可

---

|Author|程序羊|
|---|---
|E-mail|yyangsir0611@gmail.com

----------

## 项目内容
项目分为用户和管理员两个模块<br>

 - 用户 注册登陆，浏览查询电影演员，发表评论及我的影评
 - 管理员 上传和删除电影，演员等信息

### orm层

 - PageHelper分页插件
 - 通用Mapper插件实现单表的快速开发
 - mybatis强大的关系映射进行多表连接查询

### web层

 - 使用restful api风格的url 实现"表现层状态转化" 方便管理大量api接口 
 - 在自定义配置文件`WebMvcConfigurer`添加拦截器，统一的异常处理，JSON的转化和解决跨域问题 

### 前端及数据传输

### 图片存储

 - 本地存储 
     使用spring boot静态资源映射在`application.properties`中配置文件夹路径`web.upload-path=E:/xxx/xxx` 和 `spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,\
  classpath:/static/,classpath:/public/,file:${web.upload-path}`
 - 网络存储 
    使用七牛云作为图床存储图片 上传图片后将返回的图片地址存入数据库加上**外链默认域名**直接访问



### 服务器部署

 - 更改开发环境 在`application.properties`配置
``` java
spring.profiles.active=ops //dev为本地开发环境
```
 - 浏览器报错Access-Control-Allow-Origin
    前端请求的url更改为
```js
var k_protocol = window.location.protocol;
url:k_protocol+'/user/xxx'
```
    在`WebMvcConfigurer`文件中添加
```java
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }
```


----------
## 技术选型&文档

