package com.bwl.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/10
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Long code;
    private String message;
    private T data;


    public CommonResult(Long code,String message){
//        this.code = code;
//        this.message = message;
//        this.data = null;
        this(code,message,null);
    }

    /**
     * 成功返回结果
     * @param data 传过来的数据
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }


    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param message 提示信息
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }


    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> faield(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     *失败返回结果
     * @param message 提示信息
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> faield(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> faield(){
        return faield((ResultCode.FAILED));
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> validateFaield(String message){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }

    /**
     * 未登录返回结果
     * @param data 数据
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }

    /**
     * 未授权返回结果
     * @param data 数据
     * @param <T> 泛型
     * @return 响应数据
     */
    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
    }

}
