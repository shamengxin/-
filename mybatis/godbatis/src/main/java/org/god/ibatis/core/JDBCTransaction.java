package org.god.ibatis.core;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC事务管理器（godbatis框架目前只对JdbcTransaction进行实现）
 */
public class JDBCTransaction implements Transaction{

    /**
     * 数据源属性
     * 经典的设计：面向接口编程
     */
    private DataSource dataSource;

    @Override
    public Connection getConnection() {
        return connection;
    }

    /**
     * 自动提交标志
     * true表示自动提交
     * false表示不采用自动提交
     */
    private boolean autoCommit;

    /**
     * 连接对象
     */
    private Connection connection;

    /**
     * 创建事务管理器对象
     * @param dataSource
     * @param autoCommit
     */
    public JDBCTransaction(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openConnection(){
        if (connection == null) {
            try {
                connection=dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
