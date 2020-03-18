package cn.zjd.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/18 14:35
 * @auther by Dong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>
{
    private Long   code;
    private String message;
    private T      data;

    public CommonResult(Long code, String message){
       this(code, message,null);
    }
}
