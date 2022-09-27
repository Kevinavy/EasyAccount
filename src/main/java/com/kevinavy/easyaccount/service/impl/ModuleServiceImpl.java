package com.kevinavy.easyaccount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevinavy.easyaccount.model.common.context.UserContext;
import com.kevinavy.easyaccount.model.po.AccountPo;
import com.kevinavy.easyaccount.utils.QueryWrapperUtil;
import com.kevinavy.easyaccount.utils.TimeUtil;
import com.kevinavy.easyaccount.mapper.AccountMapper;
import com.kevinavy.easyaccount.mapper.CreditMapper;
import com.kevinavy.easyaccount.mapper.ModelMapper;
import com.kevinavy.easyaccount.model.common.http.PageRequest;
import com.kevinavy.easyaccount.model.common.http.PageResponse;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.po.CreditPo;
import com.kevinavy.easyaccount.model.po.ModelPo;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import com.kevinavy.easyaccount.model.vo.CreditVo;
import com.kevinavy.easyaccount.model.vo.ModelVo;
import com.kevinavy.easyaccount.service.ModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private ModelMapper modelMapper;

    @Resource
    private CreditMapper creditMapper;

    /**
     * 获取账户详情
     * @param accountUuid
     * @return
     */
    @Override
    public Result getAccount(String accountUuid) {
        AccountPo accountPo = accountMapper.selectById(accountUuid);
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(accountPo, accountVo);
        return Result.success("获取账户信息成功！", accountVo);
    }

    /**
     * 分页获取账户列表
     * @param pageRequest
     * @return
     */
    @Override
    public Result getAccountList(PageRequest pageRequest) {
        String uuid = UserContext.getLocalStorage().get("uuid").toString();
        QueryWrapper<AccountPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .eq("user_uuid", uuid)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        Page<AccountPo> queryPage = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        Page<AccountPo> resultPage = accountMapper.selectPage(queryPage, queryWrapper);
        List<AccountVo> accountList = resultPage.getRecords().stream()
                .map(accountPo -> {
                    AccountVo accountVo = new AccountVo();
                    BeanUtils.copyProperties(accountPo, accountVo);
                    return accountVo;
                })
                .toList();

        PageResponse<AccountVo> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(resultPage.getCurrent());
        pageResponse.setPageSize(resultPage.getSize());
        pageResponse.setTotalCount(resultPage.getTotal());
        pageResponse.setList(accountList);
        return Result.success("获取账户信息列表成功！", pageResponse);
    }

    /**
     * 获取全部账户列表
     * @return
     */
    @Override
    public Result getAccountListTotal(PageRequest pageRequest) {
        QueryWrapper<AccountPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        List<AccountPo> resultList = accountMapper.selectList(queryWrapper);
        List<AccountVo> accountList = resultList.stream()
                .map(accountPo -> {
                    AccountVo accountVo = new AccountVo();
                    BeanUtils.copyProperties(accountPo, accountVo);
                    return accountVo;
                })
                .toList();
        return Result.success("获取账户信息列表成功！", accountList);
    }

    /**
     * 添加账户
     * @param accountVo
     * @return
     */
    @Override
    public Result addAccount(AccountVo accountVo) {
        AccountPo accountPo = new AccountPo();
        BeanUtils.copyProperties(accountVo, accountPo);
        accountPo.setCreateTime(TimeUtil.getCurrentDateTime());
        accountPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        accountPo.setDeleteFlag(0);
        accountMapper.insert(accountPo);
        return Result.success("账户添加成功！");
    }

    /**
     * 修改账户
     * @param accountVo
     * @return
     */
    @Override
    public Result updateAccount(AccountVo accountVo) {
        AccountPo accountPo = new AccountPo();
        BeanUtils.copyProperties(accountVo, accountPo);
        accountPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        accountMapper.updateById(accountPo);
        return Result.success("账户修改成功！");
    }

    /**
     * 删除账户
     * @param accountUuid
     * @return
     */
    @Override
    public Result deleteAccount(String accountUuid) {
        AccountPo accountPo = accountMapper.selectById(accountUuid);
        accountPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        accountPo.setDeleteFlag(1);
        accountMapper.updateById(accountPo);
        return Result.success("账户删除成功！");
    }

    /**
     * 获取模型详情
     * @param modelUuid
     * @return
     */
    @Override
    public Result getModel(String modelUuid) {
        ModelPo modelPo = modelMapper.selectById(modelUuid);
        ModelVo modelVo = new ModelVo();
        BeanUtils.copyProperties(modelPo, modelVo);
        return Result.success("获取模型详情成功！", modelVo);
    }

    /**
     * 分页获取模型列表
     * @param pageRequest
     * @return
     */
    @Override
    public Result getModelList(PageRequest pageRequest) {
        QueryWrapper<ModelPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        Page<ModelPo> queryPage = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        Page<ModelPo> resultPage = modelMapper.selectPage(queryPage, queryWrapper);
        List<ModelVo> modelList = resultPage.getRecords().stream()
                .map(modelPo -> {
                    ModelVo modelVo = new ModelVo();
                    BeanUtils.copyProperties(modelPo, modelVo);
                    return modelVo;
                })
                .toList();

        PageResponse<ModelVo> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(resultPage.getCurrent());
        pageResponse.setPageSize(resultPage.getSize());
        pageResponse.setTotalCount(resultPage.getTotal());
        pageResponse.setList(modelList);
        return Result.success("获取模型信息列表成功！", pageResponse);
    }

    /**
     * 获取全部模型列表
     * @return
     */
    @Override
    public Result getModelListTotal(PageRequest pageRequest) {
        QueryWrapper<ModelPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        List<ModelPo> resultList = modelMapper.selectList(queryWrapper);
        List<ModelVo> modelList = resultList.stream()
                .map(modelPo -> {
                    ModelVo modelVo = new ModelVo();
                    BeanUtils.copyProperties(modelPo, modelVo);
                    return modelVo;
                })
                .toList();
        return Result.success("获取模型信息列表成功！", modelList);
    }

    /**
     * 添加模型
     * @param modelVo
     * @return
     */
    @Override
    public Result addModel(ModelVo modelVo) {
        ModelPo modelPo = new ModelPo();
        BeanUtils.copyProperties(modelVo, modelPo);
        modelPo.setCreateTime(TimeUtil.getCurrentDateTime());
        modelPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        modelPo.setDeleteFlag(0);
        modelMapper.insert(modelPo);
        return Result.success("模型添加成功！");
    }

    /**
     * 修改模型
     * @param modelVo
     * @return
     */
    @Override
    public Result updateModel(ModelVo modelVo) {
        ModelPo modelPo = new ModelPo();
        BeanUtils.copyProperties(modelVo, modelPo);
        modelPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        modelMapper.updateById(modelPo);
        return Result.success("模型修改成功！");
    }

    /**
     * 删除模型
     * @param modelUuid
     * @return
     */
    @Override
    public Result deleteModel(String modelUuid) {
        ModelPo modelPo = modelMapper.selectById(modelUuid);
        modelPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        modelPo.setDeleteFlag(1);
        modelMapper.updateById(modelPo);
        return Result.success("模型删除成功！");
    }

    /**
     * 获取信用详情
     * @param creditUuid
     * @return
     */
    @Override
    public Result getCredit(String creditUuid) {
        CreditPo creditPo = creditMapper.selectById(creditUuid);
        return Result.success("获取信用详情成功！", creditPo);
    }

    /**
     * 分页获取信用详情列表
     * @param pageRequest
     * @return
     */
    @Override
    public Result getCreditList(PageRequest pageRequest) {
        QueryWrapper<CreditPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        Page<CreditPo> queryPage = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        Page<CreditPo> resultPage = creditMapper.selectPage(queryPage, queryWrapper);
        List<CreditVo> creditList = resultPage.getRecords().stream()
                .map(creditPo -> {
                    CreditVo creditVo = new CreditVo();
                    BeanUtils.copyProperties(creditPo, creditVo);
                    return creditVo;
                })
                .toList();

        PageResponse<CreditVo> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(resultPage.getCurrent());
        pageResponse.setPageSize(resultPage.getSize());
        pageResponse.setTotalCount(resultPage.getTotal());
        pageResponse.setList(creditList);
        return Result.success("获取信用信息列表成功！", pageResponse);
    }

    /**
     * 获取全部信用列表
     * @return
     */
    @Override
    public Result getCreditListTotal(PageRequest pageRequest) {
        QueryWrapper<CreditPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("delete_flag", 0)
                .orderByAsc("create_time");
        for (Map.Entry<String, Object> entry : pageRequest.getFilterMap().entrySet()) {
            queryWrapper.eq(QueryWrapperUtil.humpToLine(entry.getKey()), entry.getValue());
        }
        List<CreditPo> resultList = creditMapper.selectList(queryWrapper);
        List<CreditVo> creditList = resultList.stream()
                .map(creditPo -> {
                    CreditVo creditVo = new CreditVo();
                    BeanUtils.copyProperties(creditPo, creditVo);
                    return creditVo;
                })
                .toList();
        return Result.success("获取信用信息列表成功！", creditList);
    }

    /**
     * 添加信用
     * @param creditVo
     * @return
     */
    @Override
    public Result addCredit(CreditVo creditVo) {
        CreditPo creditPo = new CreditPo();
        BeanUtils.copyProperties(creditVo, creditPo);
        creditPo.setCreateTime(TimeUtil.getCurrentDateTime());
        creditPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        creditPo.setDeleteFlag(0);
        creditMapper.insert(creditPo);
        return Result.success("信用添加成功！");
    }

    /**
     * 修改信用
     * @param creditVo
     * @return
     */
    @Override
    public Result updateCredit(CreditVo creditVo) {
        CreditPo creditPo = new CreditPo();
        BeanUtils.copyProperties(creditVo, creditPo);
        creditPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        creditMapper.updateById(creditPo);
        return Result.success("信用修改成功！");
    }

    /**
     * 删除信用
     * @param creditUuid
     * @return
     */
    @Override
    public Result deleteCredit(String creditUuid) {
        CreditPo creditPo = creditMapper.selectById(creditUuid);
        creditPo.setUpdateTime(TimeUtil.getCurrentDateTime());
        creditPo.setDeleteFlag(1);
        creditMapper.updateById(creditPo);
        return Result.success("信用删除成功！");
    }
}
