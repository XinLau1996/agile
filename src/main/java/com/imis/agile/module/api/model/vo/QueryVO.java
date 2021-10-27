package com.imis.agile.module.api.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * QueryVO<br>
 * 基础信息返回值
 * </p>
 *
 * @author XinLau
 * @version 1.0
 * @since 2021年08月18日 11:35
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "基础信息查询返回值", description = "基础信息返回值")
public class QueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色管理
     */
    @ApiModelProperty(value = "角色管理")
    private List<RoleVO> roleList;

    /**
     * 菜单权限
     */
    @ApiModelProperty(value = "菜单权限")
    private List<MenuTreeVO> menuTreeList;

    /**
     * 按钮权限
     */
    @ApiModelProperty(value = "按钮权限")
    private List<ButtonVO> buttonList;

    /**
     * 字典
     */
    @ApiModelProperty(value = "字典")
    private List<DictVO> dictList;

}
