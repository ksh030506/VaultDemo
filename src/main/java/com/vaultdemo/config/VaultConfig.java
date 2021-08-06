package com.vaultdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class VaultConfig {
    @Value("${username}")
    private String username;

    @Value("${userpassword}")
    public String userpassword;

}