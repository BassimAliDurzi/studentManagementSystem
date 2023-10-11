package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("util")
@Import(ScannerConfig.class)
@ComponentScan(basePackages = "data_access")
public class ComponentScanConfig {
}
