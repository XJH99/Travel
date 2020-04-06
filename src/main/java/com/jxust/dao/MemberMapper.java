package com.jxust.dao;

import com.jxust.bean.Member;
import com.jxust.utils.CustomerException;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员查询mapper接口
 */
@Mapper
public interface MemberMapper {
    /**
     * 根据id来查询会员
     * @param id
     * @return
     * @throws CustomerException
     */
    Member findById(Integer id) throws CustomerException;
}
