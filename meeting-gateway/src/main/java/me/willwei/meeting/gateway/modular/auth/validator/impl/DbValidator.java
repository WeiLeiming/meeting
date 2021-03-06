package me.willwei.meeting.gateway.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import me.willwei.meeting.gateway.common.persistence.dao.UserMapper;
import me.willwei.meeting.gateway.common.persistence.model.User;
import me.willwei.meeting.gateway.modular.auth.validator.IReqValidator;
import me.willwei.meeting.gateway.modular.auth.validator.dto.Credence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean validate(Credence credence) {
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        if (users != null && users.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
