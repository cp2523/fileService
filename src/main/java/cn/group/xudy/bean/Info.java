package cn.group.xudy.bean;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author chen123
 * @since 2018-07-31
 */
@TableName("user_info")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信唯一标识
     */
    private String uid;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 中文姓名
     */
    private String name;
    /**
     * 英文姓名
     */
    private String ename;
    /**
     * 所在地
     */
    private String citycode;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 注册日期
     */
    private Date createtime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Info{" +
        ", uid=" + uid +
        ", phone=" + phone +
        ", name=" + name +
        ", ename=" + ename +
        ", citycode=" + citycode +
        ", address=" + address +
        ", createtime=" + createtime +
        "}";
    }
}
