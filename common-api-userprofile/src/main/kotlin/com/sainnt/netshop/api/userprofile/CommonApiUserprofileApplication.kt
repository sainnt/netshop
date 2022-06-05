package com.sainnt.netshop.api.userprofile
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
@EnableEurekaClient
class CommonApiUserprofileApplication

fun main(args: Array<String>) {
	runApplication<CommonApiUserprofileApplication>(*args)
}