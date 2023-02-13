package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> beanMap = new HashMap<>();

    public ClassPathXmlApplicationContext(String resource) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(ClassLoader.getSystemClassLoader().getResourceAsStream(resource));
            List<Node> beanNodes = document.selectNodes("//bean");
            beanNodes.forEach(beanNode -> {
                Element beanElt = (Element) beanNode;
                String id = beanElt.attributeValue("id");
                String className = beanElt.attributeValue("class");
                try {
                    Class<?> clazz = Class.forName(className);
                    Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
                    Object bean = declaredConstructor.newInstance();
                    beanMap.put(id, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            beanNodes.forEach(beanNode -> {
                Element beanElt = (Element) beanNode;
                String beanId = beanElt.attributeValue("id");
                List<Element> propertyElts = beanElt.elements("property");
                propertyElts.forEach(propertyElt -> {
                    try {
                        String propertyName = propertyElt.attributeValue("name");
                        Class<?> propertyType = beanMap.get(beanId).getClass().getDeclaredField(propertyName).getType();
                        String setMehtodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        Method setMethod = beanMap.get(beanId).getClass().getDeclaredMethod(setMehtodName, propertyType);
                        String propertyValue = propertyElt.attributeValue("value");
                        String propertyRef = propertyElt.attributeValue("ref");
                        Object propertyVal=null;
                        if (propertyValue!=null){
                            String propertyTypeSimpleName = propertyType.getSimpleName();
                            switch (propertyTypeSimpleName){
                                case "byte": case "Byte":
                                    propertyVal=Byte.valueOf(propertyValue);
                                    break;
                                case "short": case "Short":
                                    propertyVal=Short.valueOf(propertyValue);
                                    break;
                                case "int": case "Integer":
                                    propertyVal=Integer.valueOf(propertyValue);
                                    break;
                                case "long": case "Long":
                                    propertyVal=Long.valueOf(propertyValue);
                                    break;
                                case "float": case "Float":
                                    propertyVal=Float.valueOf(propertyValue);
                                    break;
                                case "double": case "Double":
                                    propertyVal=Double.valueOf(propertyValue);
                                    break;
                                case "boolean": case "Boolean":
                                    propertyVal=Boolean.valueOf(propertyValue);
                                    break;
                                case "char": case "Character":
                                    propertyVal=propertyValue.charAt(0);
                                    break;
                                case "String":
                                    propertyVal=propertyValue;
                                    break;
                            }
                            setMethod.invoke(beanMap.get(beanId),propertyVal);
                        }

                        if (propertyRef != null){
                            setMethod.invoke(beanMap.get(beanId),beanMap.get(propertyRef));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanId) {
        return beanMap.get(beanId);
    }
}
