package com.xing.scaffold.domain.http;

import com.xing.scaffold.domain.UserVo;
import lombok.Data;

/**
 * 单独用户结果封装
 *
 * @author xingzhe
 * @date 2021/4/7 20:50
 */
@Data
public class UserResponse extends BaseResponse{

    /**
     * 用户信息
     */
    private UserVo userVo;

}
