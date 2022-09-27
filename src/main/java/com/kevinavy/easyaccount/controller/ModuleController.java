package com.kevinavy.easyaccount.controller;

import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import com.kevinavy.easyaccount.model.vo.CreditVo;
import com.kevinavy.easyaccount.model.vo.ModelVo;
import com.kevinavy.easyaccount.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/easyAccount/module")
public class ModuleController {
    @Resource
    ModuleService moduleService;

    //账户

    @GetMapping("/account/get/{accountUuid}")
    public Result getAccount(@PathVariable String accountUuid) {
        return moduleService.getAccount(accountUuid);
    }

    @PostMapping("/account/getList")
    public Result getAccountList(@RequestBody PageRequest pageRequest) {
        return moduleService.getAccountList(pageRequest);
    }

    @PostMapping("/account/getListTotal")
    public Result getAccountListTotal(@RequestBody PageRequest pageRequest) {
        return moduleService.getAccountListTotal(pageRequest);
    }

    @PostMapping("/account/add")
    public Result addAccount(@RequestBody AccountVo accountVo) {
        return moduleService.addAccount(accountVo);
    }

    @PostMapping("/account/update")
    public Result updateAccount(@RequestBody AccountVo accountVo) {
        return moduleService.updateAccount(accountVo);
    }

    @GetMapping("/account/delete/{accountUuid}")
    public Result deleteAccount(@PathVariable String accountUuid) {
        return moduleService.deleteAccount(accountUuid);
    }


    //模型

    @GetMapping("/model/get/{modelUuid}")
    public Result getModel(@PathVariable String modelUuid) {
        return moduleService.getModel(modelUuid);
    }

    @PostMapping("/model/getList")
    public Result getModelList(@RequestBody PageRequest pageRequest) {
        return moduleService.getModelList(pageRequest);
    }

    @PostMapping("/model/getListTotal")
    public Result getModelListTotal(@RequestBody PageRequest pageRequest) {
        return moduleService.getModelListTotal(pageRequest);
    }

    @PostMapping("/model/add")
    public Result addModel(@RequestBody ModelVo modelVo) {
        return moduleService.addModel(modelVo);
    }

    @PostMapping("/model/update")
    public Result updateModel(@RequestBody ModelVo modelVo) {
        return moduleService.updateModel(modelVo);
    }

    @GetMapping("/model/delete/{modelUuid}")
    public Result deleteModel(@PathVariable String modelUuid) {
        return moduleService.deleteModel(modelUuid);
    }

    //信用

    @GetMapping("/credit/get/{creditUuid}")
    public Result getCredit(@PathVariable String creditUuid) {
        return moduleService.getCredit(creditUuid);
    }

    @PostMapping("/credit/getList")
    public Result getCreditList(@RequestBody PageRequest pageRequest) {
        return moduleService.getCreditList(pageRequest);
    }

    @PostMapping("/credit/getListTotal")
    public Result getCreditListTotal(@RequestBody PageRequest pageRequest) {
        return moduleService.getCreditListTotal(pageRequest);
    }

    @PostMapping("/credit/add")
    public Result addCredit(@RequestBody CreditVo creditVo) {
        return moduleService.addCredit(creditVo);
    }

    @PostMapping("/credit/update")
    public Result updateCredit(@RequestBody CreditVo creditVo) {
        return moduleService.updateCredit(creditVo);
    }

    @GetMapping("/credit/delete/{creditUuid}")
    public Result deleteCredit(@PathVariable String creditUuid) {
        return moduleService.deleteCredit(creditUuid);
    }

}
