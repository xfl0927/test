# 权限管理系统

## 关于项目

- web项目启动类：[RbacApp.java](/rbac-web/src/main/java/com/example/rbac/RbacApp.java)
- 单元测试入口类：[Main.java](/rbac-web/src/test/java/com/example/rbac/Main.java)
- mysql建表语句：[rbac.sql](/rbac-web/src/test/resources/DB/rbac.sql)

## 表结构

### 【user】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| id | bigint(20) | 是 | 主键 | 主键ID |
| age | varchar(32) | 是 |  | 12 |
| username | varchar(32) | 是 |  | 用户名 |
| nickname | varchar(32) | 是 |  | 昵称 |
| sex | tinyint(4) | 是 |  | 性别 [1男,2女] |
| dept_id | int(11) | 是 |  | 部门id |
| created_time | datetime | 是 |  | 创建时间【yyyy-MM-dd HH:mm:ss】 |
| created_by | varchar(20) | 是 |  | 创建人【最大长度20】 |
| operated_time | datetime | 是 |  | 修改时间【yyyy-MM-dd HH:mm:ss】 |
| operated_by | varchar(20) | 是 |  | 修改人【最大长度20】 |
| version | int(11) | 是 |  | 乐观锁版本号【整型】 |
| deleted | tinyint(1) | 是 |  | 逻辑删除标识【0-未删除，1-已删除】 |

### 【role】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| id | bigint(20) | 是 | 主键 | 主键ID |
| code | varchar(32) | 是 |  | 角色编码 |
| role_name | varchar(32) | 是 |  | 角色名称 |
| created_time | datetime | 是 |  | 创建时间【yyyy-MM-dd HH:mm:ss】 |
| created_by | varchar(20) | 是 |  | 创建人【最大长度20】 |
| operated_time | datetime | 是 |  | 修改时间【yyyy-MM-dd HH:mm:ss】 |
| operated_by | varchar(20) | 是 |  | 修改人【最大长度20】 |
| version | int(11) | 是 |  | 乐观锁版本号【整型】 |
| deleted | tinyint(1) | 是 |  | 逻辑删除标识【0-未删除，1-已删除】 |

### 【resource】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| id | int(11) | 是 | 主键 | 主键ID |
| res_code | varchar(32) | 是 |  | 资源编码 |
| res_name | varchar(32) | 是 |  | 资源名称 |
| res_type | tinyint(4) | 是 |  | 资源类型  [1菜单组,2菜单,3按钮,4请求,9其他] |
| order_no | int(11) | 是 |  | 排序号【整型】 |
| created_time | datetime | 是 |  | 创建时间【yyyy-MM-dd HH:mm:ss】 |
| created_by | varchar(20) | 是 |  | 创建人【最大长度20】 |
| operated_time | datetime | 是 |  | 修改时间【yyyy-MM-dd HH:mm:ss】 |
| operated_by | varchar(20) | 是 |  | 修改人【最大长度20】 |
| version | int(11) | 是 |  | 乐观锁版本号【整型】 |
| deleted | tinyint(1) | 是 |  | 逻辑删除标识【0-未删除，1-已删除】 |

### 部门【department】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| id | int(11) | 是 | 主键 | 主键ID |
| dept_name | varchar(33) | 是 |  | 部门名称 |
| created_time | datetime | 是 |  | 创建时间【yyyy-MM-dd HH:mm:ss】 |
| created_by | varchar(20) | 是 |  | 创建人【最大长度20】 |
| operated_by | varchar(20) | 是 |  | 修改人【最大长度20】 |
| version | int(11) | 是 |  | 乐观锁版本号【整型】 |
| deleted | tinyint(1) | 是 |  | 逻辑删除标识【0-未删除，1-已删除】 |

### 【r_user_role】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| user_id | bigint(20) | 是 |  | 主键ID |
| role_id | bigint(20) | 是 |  | 主键ID |

### 【r_role_resource】
|字段名 | 类型 | 非空 | 键 | 注释 |
|------ | ---- | --- | --- | ---- |
| resource_id | int(11) | 是 |  | 主键ID |
| role_id | bigint(20) | 是 |  | 主键ID |
