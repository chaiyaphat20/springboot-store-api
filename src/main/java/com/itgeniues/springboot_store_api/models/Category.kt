package com.itgeniues.springboot_store_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "categories")

data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // กำหนดให้ field เป็น Primary Key และ Auto Increment
    var id: Int = 0,

    @Column(name = "categoryname")
    @Size(min = 3, max = 50)
    @NotBlank(message = "Category name is required")
    var categoryName: String = "",

    @Column(name = "categorystatus")
    var categoryStatus: Int = 0
)