package pers.zitianqiong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.zitianqiong.domain.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}