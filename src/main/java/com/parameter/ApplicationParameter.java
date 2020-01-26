package com.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationParameter {

    private String policeTokenUrl;
}
