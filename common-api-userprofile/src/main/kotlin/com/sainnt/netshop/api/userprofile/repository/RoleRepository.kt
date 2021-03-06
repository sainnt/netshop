package com.sainnt.netshop.api.userprofile.repository

import com.sainnt.netshop.api.userprofile.entity.Role
import com.sainnt.netshop.common.dto.security.RoleEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RoleRepository : JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = :#{#roleEnum.toString()}")
    fun find(roleEnum: RoleEnum): Role

    fun existsByName(name: String): Boolean
}