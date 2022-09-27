package com.kevinavy.easyaccount.controller;

import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.BillTypeVo;
import com.kevinavy.easyaccount.model.vo.BillVo;
import com.kevinavy.easyaccount.service.BusinessService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1/easyAccount/business")
public class BusinessController {
    @Resource
    BusinessService businessService;

    //账单

    @GetMapping("/bill/get/{billUuid}")
    public Result getBill(@PathVariable String billUuid) {
        return businessService.getBill(billUuid);
    }

    @PostMapping("/bill/getList")
    public Result getBillList(@RequestBody PageRequest pageRequest) {
        return businessService.getBillList(pageRequest);
    }

    @PostMapping("/bill/getListTotal")
    public Result getBillListTotal(@RequestBody PageRequest pageRequest) {
        return businessService.getBillListTotal(pageRequest);
    }

    @PostMapping("/bill/add")
    public Result addBill(@RequestBody BillVo billVo) {
        return businessService.addBill(billVo);
    }

    @PostMapping("/bill/addList")
    public Result addBill(@RequestBody List<BillVo> billVoList) {
        return businessService.addBill(billVoList);
    }

    @PostMapping("/bill/update")
    public Result updateBill(@RequestBody BillVo billVo) {
        return businessService.updateBill(billVo);
    }

    @GetMapping("/bill/delete/{billUuid}")
    public Result deleteBill(@PathVariable String billUuid) {
        return businessService.deleteBill(billUuid);
    }


    //账单类型

    @GetMapping("/billType/getListTotal/{userUuid}")
    public Result getBillBillTypeListTotal(@PathVariable String userUuid) {
        return businessService.getBillTypeListTotal(userUuid);
    }

    @PostMapping("/billType/add")
    public Result addBillType(@RequestBody BillTypeVo billTypeVo) {
        return businessService.addBillType(billTypeVo);
    }

    @PostMapping("/billType/update")
    public Result updateBillType(@RequestBody BillTypeVo billTypeVo) {
        return businessService.updateBillType(billTypeVo);
    }

    @GetMapping("/billType/delete/{billTypeUuid}")
    public Result deleteBillType(@PathVariable String billTypeUuid) {
        return businessService.deleteBillType(billTypeUuid);
    }
}
