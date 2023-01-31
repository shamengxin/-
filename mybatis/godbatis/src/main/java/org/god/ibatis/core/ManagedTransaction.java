package org.god.ibatis.core;

import java.sql.Connection;

/**
 * MANAGED事务管理器（godbatis对这个类就不再进行实现了。）
 */
public class ManagedTransaction implements Transaction{
    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() {

    }

    @Override
    public void openConnection() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
