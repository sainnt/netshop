package com.sainnt.netshop.api.cart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class CommonApiCartApplication

fun main(args: Array<String>) {
	runApplication<CommonApiCartApplication>(*args)
}
