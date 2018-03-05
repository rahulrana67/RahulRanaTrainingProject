package com.oodles.configuration;

import org.springframework.beans.factory.annotation.Value;

public class StagEnv implements EnvConfiguration {
    @Value("${spring.datasource.url.stage}")
    private String mySqlDBUrl;

    @Value("${spring.datasource.user.stage}")
    private String mySqlDBUser;

    @Value("${spring.datasource.password.stage}")
    private String mySqlDBPassword;

    /*@Value("${spring.datasource.db.driver}")
    private String mySqlDBDriver;
*/
    
/*    @Value("${oodles.server.app.url.stage}")
    private String appUrl;
*/
    @Value("${oodles.package.controller}")
    private String [] controllerPackages;

    @Override
    public String getEnvironment() {
        return "Stage Environment";
    }

    @Override
    public String getMySqlDBUrl() {
        return mySqlDBUrl;
    }

    @Override
    public String getMySqlDBUser() {
        return mySqlDBUser;
    }

    @Override
    public String getMySqlDBPassword() {
        return mySqlDBPassword;
    }

    /*@Override
    public String getMySqlDBDriver() {
        return mySqlDBDriver;
    }*/

   /* @Override
    public String getAppUrl() {
        return appUrl;
    }*/

    @Override
    public String [] getControllerPackages() {
        return controllerPackages;
    }


}
