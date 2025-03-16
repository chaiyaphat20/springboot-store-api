package com.itgeniues.springboot_store_api.models

import jakarta.persistence.*

enum class RoleName{
    USER,MANAGER,ADMIN
}

@Entity
@Table(name = "roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    val roleName:RoleName,

    // ความสัมพันธ์แบบหลายต่อหลาย (Many-to-Many) กับคลาส User
    // mappedBy = "roles" หมายถึง การเชื่อมโยงนี้ถูกจัดการโดยฝั่งตรงข้ามผ่านตัวแปรชื่อ "roles" ในคลาส User
    // (เป็นฝั่งรอง ไม่ได้เป็นเจ้าของความสัมพันธ์)
    @ManyToMany(mappedBy = "roles")
    val users: MutableList<User> = mutableListOf(),
){
    // เพิ่ม constructor ว่าง (ไม่มี parameter) สำหรับ JPA
    constructor() : this(0, RoleName.USER)
}
