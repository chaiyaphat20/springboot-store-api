package com.itgeniues.springboot_store_api.controllers

import com.itgeniues.springboot_store_api.models.Category
import com.itgeniues.springboot_store_api.services.CategoryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Categories",description = "Category API")
@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(private val categoryService: CategoryService) {

    // ฟังก์ชันสำหรับการดึงข้อมูล Category ทั้งหมด
    // GET /api/categories
    @Operation(summary = "Get all Categories",description = "Get all Categories2")
    @GetMapping
    fun getCategories(): ResponseEntity<List<Category>> {
        val categories = categoryService.getAllCategories()
        return ResponseEntity.ok(categories)
    }

    // ฟังก์ชันสำหรับการดึงข้อมูล Category ตาม ID
    // GET /api/categories/{id}
    @Operation(summary = "Get a new Category by id",description = "Get a new Category by id")
    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Int): ResponseEntity<Category> {
        val category = categoryService.getCategoryById(id)
        return if (category.isPresent) {
            ResponseEntity.ok(category.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // ฟังก์ชันสำหรับการเพิ่มข้อมูล Category
    // POST /api/categories
    @Operation(summary = "Create a Category",description = "Create a Category")
    @PostMapping
    fun addCategory(@RequestBody category: Category): ResponseEntity<Category> {
        val savedCategory = categoryService.addCategory(category)
        return ResponseEntity.ok(savedCategory)
    }

    // ฟังก์ชันสำหรับการแก้ไขข้อมูล Category
    // PUT /api/categories/{id}
    @Operation(summary = "update a Category by id",description = "update a Category by id")
    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Int, @RequestBody category: Category): ResponseEntity<Category> {
        val updatedCategory = categoryService.updateCategory(id, category)
        return if (updatedCategory.isPresent) {
            ResponseEntity.ok(updatedCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // ฟังก์ชันสำหรับการลบข้อมูล Category
    // DELETE /api/categories/{id}
    @Operation(summary = "Delete category by ID",description = "Delete category by ID")
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Int): ResponseEntity<Category> {
        val deletedCategory = categoryService.deleteCategory(id)
        return if (deletedCategory.isPresent) {
            ResponseEntity.ok(deletedCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

}