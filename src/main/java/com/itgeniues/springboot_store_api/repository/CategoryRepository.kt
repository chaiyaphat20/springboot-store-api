package com.itgeniues.springboot_store_api.repository

import com.itgeniues.springboot_store_api.models.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository:JpaRepository<Category,Int> {
}