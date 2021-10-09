package com.imis.agile.module.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.agile.constant.DataBaseConstant;
import com.imis.agile.module.api.model.vo.ItemVO;
import com.imis.agile.module.system.mapper.DictItemMapper;
import com.imis.agile.module.system.model.dto.QueryDictItemDTO;
import com.imis.agile.module.system.model.entity.DictItem;
import com.imis.agile.module.system.model.vo.DictItemVO;
import com.imis.agile.module.system.service.IDictItemService;
import com.imis.agile.util.AgileUtil;
import com.imis.agile.util.BuildingTreeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典 - 项 服务实现类
 * </p>
 *
 * @author XinLau
 * @since 2020-03-23
 */
@Service
@Slf4j
@DS(DataBaseConstant.DATA_SOURCE_MASTER)
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements IDictItemService {

    /**
     * 字典 - 值 查询
     *
     * @param query - 查询参数
     * @return List<DictItemVO>
     * @author XinLau
     * @creed The only constant is change ! ! !
     * @since 2020/3/5 17:25
     */
    @Override
    @DS(DataBaseConstant.DATA_SOURCE_SLAVE)
    public List<DictItemVO> queryDictItemList(final QueryDictItemDTO query) {
        // 查询数据
        List<DictItemVO> dictItemList = this.baseMapper.queryDictItemList(query);
        if (AgileUtil.isNotEmpty(dictItemList)) {
            // 构建数据
            BuildingTreeData<DictItemVO> buildingTreeData = new BuildingTreeData<>();
            return buildingTreeData.buildingTreeData(dictItemList);
        }
        return dictItemList;
    }

    /**
     * 字典 - 值 查询
     *
     * @param dictIdList - 字典 - 项 ID
     * @return List<ItemVO>
     * @author XinLau
     * @creed The only constant is change ! ! !
     * @since 2020/3/5 17:25
     */
    @Override
    @DS(DataBaseConstant.DATA_SOURCE_SLAVE)
    public List<ItemVO> queryDictItemListByDictIdList(final List<String> dictIdList) {
        List<ItemVO> dictItemList = this.baseMapper.queryDictItemListByDictIdList(dictIdList);
        if (AgileUtil.isNotEmpty(dictItemList)) {
            // 构建数据
            BuildingTreeData<ItemVO> buildingTreeData = new BuildingTreeData<>();
            return buildingTreeData.buildingTreeData(dictItemList);
        }
        return dictItemList;
    }

    /**
     * 字典 - 值 查询
     *
     * @param dictCode - 字典 - 项 编码
     * @return List<ItemVO>
     * @author XinLau
     * @creed The only constant is change ! ! !
     * @since 2020/3/5 17:25
     */
    @Override
    @DS(DataBaseConstant.DATA_SOURCE_SLAVE)
    public List<ItemVO> queryDictItemListByDictCode(final String dictCode) {
        List<ItemVO> dictItemList = new ArrayList<>();
        if (AgileUtil.isNotEmpty(dictCode)) {
            dictItemList = this.baseMapper.queryDictItemListByDictCode(dictCode);
            // 构建数据
            BuildingTreeData<ItemVO> buildingTreeData = new BuildingTreeData<>();
            return buildingTreeData.buildingTreeData(dictItemList);
        }
        return dictItemList;
    }

    /**
     * 字典 - 数据库表名称
     *
     * @return List<ItemVO>
     * @author XinLau
     * @creed The only constant is change ! ! !
     * @since 2020/3/5 17:25
     */
    @Override
    @DS(DataBaseConstant.DATA_SOURCE_SLAVE)
    public List<ItemVO> queryTableItemList(){
        return this.baseMapper.queryTableItemList();
    }

    /**
     * 字典 - 数据库表字段名称
     *
     * @param tableName - 数据库表名称
     * @return List<ItemVO>
     * @author XinLau
     * @creed The only constant is change ! ! !
     * @since 2020/3/5 17:25
     */
    @Override
    @DS(DataBaseConstant.DATA_SOURCE_SLAVE)
    public List<ItemVO> queryTableColumnItemListByTableName(final String tableName){
        return this.baseMapper.queryTableColumnItemListByTableName(tableName);
    }

}