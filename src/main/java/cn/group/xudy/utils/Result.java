package cn.group.xudy.utils;


import java.io.Serializable;

/**
 *
 * @ClassName: Result
 * @Description: 返回实体类
 * @author chen
 * @date 2018年1月25日 下午5:24:54
 */
public class Result implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -2867756409591322259L;
    /**
     * 返回类型
     */
    private String returnType;
    /**
     * 返回结果
     */
    private Object returnValue;
    /**
     * 成功
     */
    private final String SUCCESS = "SUCCESS";
    /**
     * 失败
     */
    private final String FAIL = "FAIL";

    /**
     * 构造函数
     */
    public Result() {

    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "ReturnBean [returnType=" + returnType + ", returnValue=" + returnValue + ", SUCCESS=" + SUCCESS
                + ", FAIL=" + FAIL + "]";
    }

    /**
     *
     * @Title: setSuccessReturn
     * @Description: 设置成功返回
     * @param returnValue
     */
    public void setSuccessReturn(Object returnValue) {
        this.returnType = this.SUCCESS;
        this.returnValue = returnValue;
    }

    /**
     *
     * @Title: setFailReturn
     * @Description: 设置失败返回
     * @param returnValue
     */
    public void setFailReturn(Object returnValue) {
        this.returnType = this.FAIL;
        this.returnValue = returnValue;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

}

