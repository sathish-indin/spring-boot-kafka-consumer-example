package com.poc.lightapp.config;

public class SystemParam {

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private String ip;

    public SystemParam(String ip) {
        this.ip = ip;
    }
}
