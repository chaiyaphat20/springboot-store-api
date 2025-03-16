package com.itgeniues.springboot_store_api.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false,unique = true)
    var username: String,

    @Column(nullable = false,unique = true)
    var email: String,

    @JsonIgnore  //ซ่อนไม่ให้แสดงบน json
    @Column(nullable = false)
    var password: String,

    // ความสัมพันธ์แบบหลายต่อหลาย ระหว่าง User กับ Role
    // FetchType.EAGER หมายถึง ข้อมูลจะถูกดึงมาพร้อมกันทันที เมื่อดึง User (แบบ JOIN)
    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_roles", // สร้างตารางกลางชื่อ user_roles เพื่อเชื่อมความสัมพันธ์
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")], // คอลัมน์ user_id อ้างอิงถึง id ในตาราง User
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")] // คอลัมน์ role_id อ้างอิงถึง id ในตาราง Role
    )
    // ตัวแปรเก็บรายการบทบาท (roles) ที่ผู้ใช้มี สามารถเพิ่ม/ลบบทบาทได้
    var roles: MutableList<Role> = mutableListOf(),
){
    // เพิ่ม constructor ว่าง ต้องเรียก primary constructor ให้ครบทุกพารามิเตอร์
    constructor() : this(0, "", "", "", mutableListOf())
}
