package com.itgeniues.springboot_store_api.repository

import com.itgeniues.springboot_store_api.models.Role
import com.itgeniues.springboot_store_api.models.RoleName
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository:JpaRepository<Role, Long> {
    fun findByRoleName(roleName: RoleName): Role?
}