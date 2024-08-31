package org.yeahicode.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.yeahicode.rbac.domain.Hr;

public interface HrMapper extends BaseMapper<Hr> {

    Hr getHrByPhone(@Param("phone") String phone);
}
