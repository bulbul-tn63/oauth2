package com.tnpay.registryservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hr-worker", route -> route
                        .path("/hr-worker/**")
                        .filters(filter -> filter.stripPrefix(1))
                        .uri("lb://hr-worker")
                )
                .route("hr-payroll", route -> route
                        .path("/hr-payroll/**", "/payments/{worker_id}/days/{worked_days}", "/circuit_breaker_timeout")
                        .filters(filter -> filter.stripPrefix(1))
                        .uri("lb://hr-payroll")
                )
                .route("user-service", route -> route
                        .path("/user-service/**")
                        .filters(filter -> filter.stripPrefix(1))
                        .uri("lb://user-service")
                )
                .build();
    }
}
