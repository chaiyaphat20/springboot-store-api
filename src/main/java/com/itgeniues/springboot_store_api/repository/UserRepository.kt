package com.itgeniues.springboot_store_api.repository

import com.itgeniues.springboot_store_api.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?

    //มันจะ ใช้ naming conventions
    //findById แยกเป็น
    //find - บอกว่าเป็นการค้นหา
    //By - คำสำคัญที่บอกว่าจะค้นหาตามเงื่อนไขต่อไปนี้
    //Id ชื่อคุณสมบัติ (property) ที่ใช้ในการค้นหา
    override fun findById(id: Long): Optional<User>


}