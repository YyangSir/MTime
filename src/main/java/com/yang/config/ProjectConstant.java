package com.yang.config;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.yang";//项目基础包名称

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".route";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".mapper.Mapper";//Mapper插件基础接口的完全限定名



    //上传图片路径
    public static final String BASE_DISK_FOLDER = "E:/Java_project/";
    public static final String BASE_CLOUD_URL = "http://ozqy003kk.bkt.clouddn.com/";

    public static final String MOVIE_UPLOADED_FOLDER = "img/movie_img/";
    public static final String USER_UPLOADED_FOLDER = "img/user_img/";
    public static final String ACTOR_UPLOADED_FOLDER = "img/actor_img/";

    //七牛云
    public static final String ACCESS_KEY = "swAZvM_yGji8XCr_l7D7dP07iNZ7vF0N7Lpn9FPZ";
    public static final String SECRET_KEY = "FI-chyvR3da9xxPRugkhN40tWKt80106OYTjM-Ad";
    public static final String BUCKET = "mtime";
}
