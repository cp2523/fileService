package cn.group.xudy.dao;

import cn.group.xudy.bean.Info;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * <p>
 * 用户基础信息表 Mapper 接口
 * </p>
 *
 * @author chen123
 * @since 2018-07-31
 */
@Repository
public interface InfoMapper extends BaseMapper<Info> {
    /**
     *
     * @Title: selectUserByMap
     * @Description: 多条件组合查找用户
     * @param parameterMap
     * @return
     * @throws Exception
     */
    Info selectUserByMap(Map<String, Object> parameterMap) throws Exception;

}
