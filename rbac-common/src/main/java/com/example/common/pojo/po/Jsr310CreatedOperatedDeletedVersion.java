package com.example.common.pojo.po;


/**
 * 逻辑删除+创建人&创建时间+操作人&操作时间+版本号-jsr310时间API
 *
 * @author Jack
 * @date 2020/04/25
 */
public interface Jsr310CreatedOperatedDeletedVersion extends Jsr310Created, Jsr310Operated, Deleted, Version {
}

