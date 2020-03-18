package cn.zjd.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/18 14:32
 * @auther by Dong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
    private Long   id;
    private String serial;
}
