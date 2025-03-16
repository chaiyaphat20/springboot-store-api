package com.itgeniues.springboot_store_api.controllers

import com.itgeniues.springboot_store_api.models.Product
import com.itgeniues.springboot_store_api.services.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Products",description = "Product API")
@RestController
@RequestMapping(value = ["/api/v1/products"])
class ProductController(private val productService: ProductService) {
    // ฟังก์ชันสำหรับการดึงข้อมูล Product ทั้งหมด
    // GET /api/products
    @Operation(summary = "Get all products")
    @GetMapping
    fun getAllProducts() = productService.getAllProducts()

    // ฟังก์ชันสำหรับการดึงข้อมูล Product ตาม ID
    // GET /api/products/{id}
    @Operation(summary = "Get Product By ID")
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int):  ResponseEntity<Product> {
        val  product = productService.getProductById(id)
        return product.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    // ฟังก์ชันสำหรับการเพิ่มข้อมูล Product
    // POST /api/products
    @Operation(summary = "Create a new product")
    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createdProduct = productService.createProduct(product)
        return ResponseEntity(createdProduct, HttpStatus.CREATED)
    }

    // ฟังก์ชันสำหรับการแก้ไขข้อมูล Product
    // PUT /api/products/{id}
    @Operation(summary = "Update product")
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product: Product): ResponseEntity<Product> {
        val updatedProduct = productService.updateProduct(id, product)
        return ResponseEntity.ok(updatedProduct)
    }

    // ฟังก์ชันสำหรับการลบข้อมูล Product
    // DELETE /api/products/{id}
    @Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }


}