package com.kevinavy.easyaccount.service;

import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import com.kevinavy.easyaccount.model.vo.CreditVo;
import com.kevinavy.easyaccount.model.vo.ModelVo;

public interface ModuleService {
    Result getAccount(String accountUuid);

    Result getAccountList(PageRequest pageRequest);

    Result addAccount(AccountVo accountVo);

    Result updateAccount(AccountVo accountVo);

    Result deleteAccount(String accountUuid);

    Result getAccountListTotal(PageRequest pageRequest);

    Result getModel(String modelUuid);

    Result getModelList(PageRequest pageRequest);

    Result getModelListTotal(PageRequest pageRequest);

    Result addModel(ModelVo modelVo);

    Result updateModel(ModelVo modelVo);

    Result deleteModel(String modelUuid);

    Result getCredit(String creditUuid);

    Result getCreditList(PageRequest pageRequest);

    Result getCreditListTotal(PageRequest pageRequest);

    Result addCredit(CreditVo creditVo);

    Result updateCredit(CreditVo creditVo);

    Result deleteCredit(String creditUuid);
}
