package org.nix.movieticketingsystem.commons.enums;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 *
 * 角色枚举信息
 */
public enum RoleEnum {

    ROLE_USER("USER","消费者"),
    ROLE_MANGER("MANGER","管理员"),
    ROLE_CINEMA("CINEMA","电影商");
    /**
     * 角色名字
     */
    private String roleName;
    /**
     * 角色介绍简短说明
     */
    private String massage;


    RoleEnum(String roleName, String massage) {
        this.roleName=roleName;
        this.massage=massage;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
