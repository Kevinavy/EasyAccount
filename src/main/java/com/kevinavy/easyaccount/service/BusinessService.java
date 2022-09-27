package com.kevinavy.easyaccount.service;

import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.BillTypeVo;
import com.kevinavy.easyaccount.model.vo.BillVo;

import java.util.List;

public interface BusinessService {
    Result addBill(BillVo billVo);

    Result addBill(List<BillVo> billVoList);

    Result getBill(String billUuid);

    Result getBillList(PageRequest pageRequest);

    Result getBillListTotal(PageRequest pageRequest);

    Result updateBill(BillVo billVo);

    Result deleteBill(String billUuid);

    Result getBillTypeListTotal(String pageRequest);

    Result addBillType(BillTypeVo billTypeVo);

    Result updateBillType(BillTypeVo billTypeVo);

    Result deleteBillType(String billTypeUuid);


}
