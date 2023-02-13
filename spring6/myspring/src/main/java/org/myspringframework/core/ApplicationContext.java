package org.myspringframework.core;

public interface ApplicationContext {

    /**
     * 根据BeanId获取bean的实例
     * @param beanId bean的id
     * @return bean的实例
     */
    Object getBean(String beanId);

}
