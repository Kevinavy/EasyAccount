package com.kevinavy.easyaccount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevinavy.easyaccount.constant.enums.BillTypeClass;
import com.kevinavy.easyaccount.constant.enums.CreditType;
import com.kevinavy.easyaccount.mapper.BillMapper;
import com.kevinavy.easyaccount.mapper.BillTypeMapper;
import com.kevinavy.easyaccount.mapper.CreditMapper;
import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.PageResponse;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.po.BillPo;
import com.kevinavy.easyaccount.model.po.BillTypePo;
import com.kevinavy.easyaccount.model.po.CreditPo;
import com.kevinavy.easyaccount.model.vo.BillTypeVo;
import com.kevinavy.easyaccount.model.vo.BillVo;
import com.kevinavy.easyaccount.service.BusinessService;
import com.kevinavy.easyaccount.utils.QueryWrapperUtil;
import com.kevinavy.easyaccount.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BillMapper billMapper;

    @Resource
    private BillTypeMapper billTypeMapper;

    @Resource
    private CreditMapper creditMapper;

    @Override
    @Transactional
    public Result addBill(BillVo billVo) {
        if (billVo.getRelatedCreditFlag() == 1) {
            updateCredit(billVo);
        }
        BillPo billPo = new BillPo();
        BeanUtils.copyProperties(billVo, billPo);
        billPo.setCreateTime(TimeUtil.getCurrentDateTime());
        billPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        billPo.setDeleteFlag(0);
        billMapper.insert(billPo);
        return Result.success("账单添加成功！");
    }

    @Override
    @Transactional
    public Result addBill(List<BillVo> billVoList) {
        String transactionUuid = String.valueOf(UUID.randomUUID());
        List<BillPo> billPoList = billVoList.stream()
                .map(billVo -> {
                    BillPo billPo = new BillPo();
                    BeanUtils.copyProperties(billVo, billPo);
                    billPo.setRelatedTransactionFlag(0);
                    billPo.setRelatedTransactionUuid(transactionUuid);
                    billPo.setCreateTime(TimeUtil.getCurrentDateTime());
                    billPo.setUpdateTime(TimeUtil.getCurrentDateTime());
                    billPo.setDeleteFlag(0);
                    return billPo;
                })
                .toList();
        billMapper.insertBatchSomeColumn(billPoList);
        return Result.success("账单添加成功！");
    }

    @Override
    public Result getBill(String billUuid) {
        BillPo billPo = billMapper.selectById(billUuid);
        BillVo billVo = new BillVo();
        BeanUtils.copyProperties(billPo, billVo);
        return Result.success("获取账单详情成功！", billVo);
    }

    @Override
    public Result getBillList(PageRequest pageRequest) {
        QueryWrapper<BillPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByDesc("bill_date")
                .orderByDesc("bill_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        Page<BillPo> queryPage = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        Page<BillPo> resultPage = billMapper.selectPage(queryPage, queryWrapper);
        List<BillVo> billVoList = resultPage.getRecords().stream()
                .map(billPo -> {
                    BillVo billVo = new BillVo();
                    BeanUtils.copyProperties(billPo, billVo);
                    return billVo;
                })
                .toList();
        PageResponse<BillVo> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(resultPage.getCurrent());
        pageResponse.setPageSize(resultPage.getSize());
        pageResponse.setTotalCount(resultPage.getTotal());
        pageResponse.setList(billVoList);
        return Result.success("获取账单列表成功！", pageResponse);
    }

    @Override
    public Result getBillListTotal(PageRequest pageRequest) {
        QueryWrapper<BillPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByDesc("bill_date")
                .orderByDesc("bill_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        List<BillPo> billPoList = billMapper.selectList(queryWrapper);
        List<BillVo> billVoList = billPoList.stream()
                .map(billPo -> {
                    BillVo billVo = new BillVo();
                    BeanUtils.copyProperties(billPo, billVo);
                    return billVo;
                })
                .toList();
        return Result.success("获取账单列表成功！", billVoList);
    }

    @Override
    @Transactional
    public Result updateBill(BillVo billVo) {
        BillPo billPoOld = billMapper.selectById(billVo.getBillUuid());
        if (billPoOld.getRelatedCreditFlag() == 1){
            rollbackCredit(billPoOld);
        }
        if (billVo.getRelatedCreditFlag() == 1) {
            updateCredit(billVo);
        }
        BillPo billPo = new BillPo();
        BeanUtils.copyProperties(billVo, billPo);
        billPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        billMapper.updateById(billPo);
        return Result.success("修改账单成功！");
    }

    @Override
    @Transactional
    public Result deleteBill(String billUuid) {
        BillPo billPo = billMapper.selectById(billUuid);
        if (billPo.getRelatedCreditFlag() == 1) {
            rollbackCredit(billPo);
        }
        billPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        billPo.setDeleteFlag(1);
        billMapper.updateById(billPo);
        return Result.success("账单删除成功！");
    }

    @Override
    public Result getBillTypeListTotal(String userUuid) {
        QueryWrapper<BillTypePo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .and(wrapper -> {
                    wrapper.eq("user_uuid", userUuid).or().eq("user_uuid", "");
                })
                .orderByAsc("create_time");
        List<BillTypePo> billTypePoList = billTypeMapper.selectList(queryWrapper);
        List<BillTypeVo> billTypeVoList = billTypePoList.stream()
                .map(billTypePo -> {
                    BillTypeVo billTypeVo = new BillTypeVo();
                    BeanUtils.copyProperties(billTypePo, billTypeVo);
                    return billTypeVo;
                })
                .toList();
        return Result.success("获取账单类型列表成功！", billTypeVoList);
    }

    @Override
    public Result addBillType(BillTypeVo billTypeVo) {
        BillTypePo billTypePo = new BillTypePo();
        BeanUtils.copyProperties(billTypeVo, billTypePo);
        billTypePo.setCreateTime(TimeUtil.getCurrentDateTime());
        billTypePo.setUpdateTime(TimeUtil.getCurrentDateTime());
        billTypePo.setDeleteFlag(0);
        billTypeMapper.insert(billTypePo);
        return Result.success("账单类型添加成功！");
    }

    @Override
    public Result updateBillType(BillTypeVo billTypeVo) {
        BillTypePo billTypePo = new BillTypePo();
        BeanUtils.copyProperties(billTypeVo, billTypePo);
        billTypePo.setUpdateTime(TimeUtil.getCurrentDateTime());
        billTypeMapper.updateById(billTypePo);
        return Result.success("账单类型修改成功！");
    }

    @Override
    public Result deleteBillType(String billTypeUuid) {
        BillTypePo billTypePo = billTypeMapper.selectById(billTypeUuid);
        billTypePo.setDeleteFlag(1);
        billTypeMapper.updateById(billTypePo);
        return Result.success("账单类型删除成功！");
    }

    private boolean calculateTrend(BillTypeClass billTypeClass, CreditType creditType) {
        if (billTypeClass == BillTypeClass.INCOME) {
            if (creditType == CreditType.DEBT) {
                return true;
            }
            else if (creditType == CreditType.LOAN) {
                return false;
            }
        }
        else if (billTypeClass == BillTypeClass.EXPENDITURE) {
            if (creditType == CreditType.DEBT) {
                return false;
            }
            else if (creditType == CreditType.LOAN) {
                return true;
            }
        }
        return true;
    }

    @Transactional
    void updateCredit(BillVo billVo) {
        BillTypePo billTypePo = billTypeMapper.selectById(billVo.getBillTypeUuid());
        CreditPo creditPo = creditMapper.selectById(billVo.getRelatedCreditUuid());
        Integer creditMoneyTotal = creditPo.getCreditMoneyTotal();
        Integer creditMoney = creditPo.getCreditMoney();
        if (calculateTrend(billTypePo.getBillTypeClass(), creditPo.getCreditType())) {
            Integer creditMoneyFinal = creditMoney + billVo.getRelatedCreditMoney();
            creditPo.setCreditMoney(creditMoneyFinal);
            if (creditMoneyFinal > creditMoneyTotal) {
                creditPo.setCreditFinish(1);
            }
        }
        else {
            Integer creditMoneyFinal = creditMoneyTotal + billVo.getRelatedCreditMoney();
            creditPo.setCreditMoneyTotal(creditMoneyFinal);
        }
        creditPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        creditMapper.updateById(creditPo);
    }

    @Transactional
    void rollbackCredit(BillPo billPo) {
        BillTypePo billTypePo = billTypeMapper.selectById(billPo.getBillTypeUuid());
        CreditPo creditPo = creditMapper.selectById(billPo.getRelatedCreditUuid());
        Integer creditMoneyTotal = creditPo.getCreditMoneyTotal();
        Integer creditMoney = creditPo.getCreditMoney();
        if (calculateTrend(billTypePo.getBillTypeClass(), creditPo.getCreditType())) {
            Integer creditMoneyFinal = creditMoney - billPo.getRelatedCreditMoney();
            creditPo.setCreditMoney(creditMoneyFinal);
            if (creditMoneyFinal < creditMoneyTotal) {
                creditPo.setCreditFinish(0);
            }
        }
        else {
            Integer creditMoneyFinal = creditMoneyTotal - billPo.getRelatedCreditMoney();
            creditPo.setCreditMoneyTotal(creditMoneyFinal);
        }
        creditPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        creditMapper.updateById(creditPo);
    }
}
