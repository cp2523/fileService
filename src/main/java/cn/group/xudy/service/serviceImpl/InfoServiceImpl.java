package cn.group.xudy.service.serviceImpl;

import cn.group.xudy.bean.Info;
import cn.group.xudy.dao.InfoMapper;
import cn.group.xudy.service.InfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author chen123
 * @since 2018-07-31
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {
    /**
     * 日志管理
     */
    private static Logger log = LoggerFactory.getLogger(InfoServiceImpl.class);

    /**
     * 用户数据访问接口
     */
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Info selectUserByMap(Map<String, Object> parameterMap) throws Exception {
        if (parameterMap==null){
            return null;
        }
        return infoMapper.selectUserByMap(parameterMap);
    }
}
