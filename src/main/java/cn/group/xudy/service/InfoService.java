package cn.group.xudy.service;

import cn.group.xudy.bean.Info;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author chen123
 * @since 2018-07-31
 */
public interface InfoService extends IService<Info> {
    /**
     *
     * @Title: selectUserByMap
     * @Description: 多条件组合查找用户
     * @param uid
     * @return
     * @throws Exception
     */
    Info selectUserByMap(Map<String, Object> parameterMap) throws Exception;

}
