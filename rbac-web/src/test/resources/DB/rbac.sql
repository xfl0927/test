DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` bigint(20) AUTO_INCREMENT COMMENT '主键ID',
    `age` varchar(32) NOT NULL COMMENT '12',
    `username` varchar(32) NOT NULL COMMENT '用户名',
    `nickname` varchar(32) NOT NULL COMMENT '昵称',
    `sex` tinyint(4) NOT NULL COMMENT '性别 [1男,2女]',
    `dept_id` int(11) NOT NULL COMMENT '部门id',
    `created_time` datetime NOT NULL COMMENT '创建时间【yyyy-MM-dd HH:mm:ss】',
    `created_by` varchar(20) NOT NULL COMMENT '创建人【最大长度20】',
    `operated_time` datetime NOT NULL COMMENT '修改时间【yyyy-MM-dd HH:mm:ss】',
    `operated_by` varchar(20) NOT NULL COMMENT '修改人【最大长度20】',
    `version` int(11) NOT NULL COMMENT '乐观锁版本号【整型】',
    `deleted` tinyint(1) NOT NULL COMMENT '逻辑删除标识【0-未删除，1-已删除】',
    PRIMARY KEY (`id`),
    KEY `IDX_OQAHV3RZN` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `id` bigint(20) AUTO_INCREMENT COMMENT '主键ID',
    `code` varchar(32) NOT NULL COMMENT '角色编码',
    `role_name` varchar(32) NOT NULL COMMENT '角色名称',
    `created_time` datetime NOT NULL COMMENT '创建时间【yyyy-MM-dd HH:mm:ss】',
    `created_by` varchar(20) NOT NULL COMMENT '创建人【最大长度20】',
    `operated_time` datetime NOT NULL COMMENT '修改时间【yyyy-MM-dd HH:mm:ss】',
    `operated_by` varchar(20) NOT NULL COMMENT '修改人【最大长度20】',
    `version` int(11) NOT NULL COMMENT '乐观锁版本号【整型】',
    `deleted` tinyint(1) NOT NULL COMMENT '逻辑删除标识【0-未删除，1-已删除】',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
    `id` int(11) AUTO_INCREMENT COMMENT '主键ID',
    `res_code` varchar(32) NOT NULL COMMENT '资源编码',
    `res_name` varchar(32) NOT NULL COMMENT '资源名称',
    `res_type` tinyint(4) NOT NULL COMMENT '资源类型  [1菜单组,2菜单,3按钮,4请求,9其他]',
    `order_no` int(11) NOT NULL COMMENT '排序号【整型】',
    `created_time` datetime NOT NULL COMMENT '创建时间【yyyy-MM-dd HH:mm:ss】',
    `created_by` varchar(20) NOT NULL COMMENT '创建人【最大长度20】',
    `operated_time` datetime NOT NULL COMMENT '修改时间【yyyy-MM-dd HH:mm:ss】',
    `operated_by` varchar(20) NOT NULL COMMENT '修改人【最大长度20】',
    `version` int(11) NOT NULL COMMENT '乐观锁版本号【整型】',
    `deleted` tinyint(1) NOT NULL COMMENT '逻辑删除标识【0-未删除，1-已删除】',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
    `id` int(11) AUTO_INCREMENT COMMENT '主键ID',
    `dept_name` varchar(33) NOT NULL COMMENT '部门名称',
    `created_time` datetime NOT NULL COMMENT '创建时间【yyyy-MM-dd HH:mm:ss】',
    `created_by` varchar(20) NOT NULL COMMENT '创建人【最大长度20】',
    `operated_by` varchar(20) NOT NULL COMMENT '修改人【最大长度20】',
    `version` int(11) NOT NULL COMMENT '乐观锁版本号【整型】',
    `deleted` tinyint(1) NOT NULL COMMENT '逻辑删除标识【0-未删除，1-已删除】',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

DROP TABLE IF EXISTS `r_user_role`;

CREATE TABLE `r_user_role` (
    `id` bigint(20) AUTO_INCREMENT COMMENT '主键',
    `user_id` bigint(20) NOT NULL COMMENT '主键ID',
    `role_id` bigint(20) NOT NULL COMMENT '主键ID',
    `created_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `IDX_R_USER_ROLE_1` (`user_id`),
    KEY `IDX_R_USER_ROLE_2` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `r_role_resource`;

CREATE TABLE `r_role_resource` (
    `id` int(11) AUTO_INCREMENT COMMENT '主键',
    `resource_id` int(11) NOT NULL COMMENT '主键ID',
    `role_id` bigint(20) NOT NULL COMMENT '主键ID',
    `created_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `IDX_R_ROLE_RESOURCE_1` (`resource_id`),
    KEY `IDX_R_ROLE_RESOURCE_2` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

