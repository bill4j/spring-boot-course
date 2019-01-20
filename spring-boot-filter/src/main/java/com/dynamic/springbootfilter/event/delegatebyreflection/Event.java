package com.dynamic.springbootfilter.event.delegatebyreflection;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class Event {
    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }



    public Object[] getParams() {
        return params;
    }



    public Class[] getParamTypes() {
        return paramTypes;
    }


    /**
     * 事件对象的封装类
     * @author Administrator
     *
     */
        //要执行方法的对象

        private Object object;
        //要执行的方法名称
        private String methodName;
        //要执行方法的参数
        private Object[] params;
        //要执行方法的参数类型
        private Class[] paramTypes;

        public Event(){

        }

        public Event(Object object,String methodName,Object...args){
            this.object=object;
            this.methodName=methodName;
            this.params=args;
            contractParamTypes(this.params);
        }
        //根据参数数组生成参数类型数组
        private void contractParamTypes(Object[] params){
            this.paramTypes=new Class[params.length];
            for(int i=0;i<params.length;i++){
                this.paramTypes[i]=params[i].getClass();
            }
        }


        public Object getObject() {
            return object;
        }

        //这里省略了若干get和set方法

        /**
         * 根据该对象的方法名，方法参数，利用反射机制，执行该方法
         * @throws Exception
         */
        public void invoke() throws Exception{
            Method method=object.getClass().getMethod(this.getMethodName(),
                    this.getParamTypes());
            if(null==method){
                return;
            }
            method.invoke(this.getObject(), this.getParams());
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("event.delegatebyreflection.Event{");
        sb.append("object=").append(object);
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", params=").append(Arrays.toString(params));
        sb.append(", paramTypes=").append(Arrays.toString(paramTypes));
        sb.append('}');
        return sb.toString();
    }
}
