package com.itgeniues.springboot_store_api.repository

import com.itgeniues.springboot_store_api.models.Product
import org.springframework.data.jpa.repository.JpaRepository

//<Product,Int>   -> Int -> ใส่ type ของ primarykey
interface ProductRepository:JpaRepository<Product,Int> {
}