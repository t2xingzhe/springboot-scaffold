package com.xing.scaffold.domain.http;

import com.xing.scaffold.domain.UserVo;
import lombok.Data;

import java.util.List;

/**
 * 用户列表返回封装
 *
 * @author xingzhe
 * @date 2021/4/7 20:50
 */
@Data
public class UserListResponse extends BaseResponse{

    /**
     * 用户信息
     */
    private List<UserVo> userVo;

}
