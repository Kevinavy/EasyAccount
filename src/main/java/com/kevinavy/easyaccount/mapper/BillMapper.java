package com.kevinavy.easyaccount.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinavy.easyaccount.model.po.BillPo;

import java.util.Collection;

public interface BillMapper extends BaseMapper<BillPo> {
    Integer insertBatchSomeColumn(Collection<BillPo> billPoCollection);
}
