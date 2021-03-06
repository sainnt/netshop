package com.sainnt.netshop.api.product.controller

import com.sainnt.netshop.api.product.config.ApiConfig
import com.sainnt.netshop.api.product.service.CatalogService
import com.sainnt.netshop.common.dto.crm.CatalogDto
import com.sainnt.netshop.common.dto.request.CatalogCreateDto
import com.sainnt.netshop.common.exception.NetShopApiException
import org.springframework.data.domain.Page
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min

@RestController
@RequestMapping("/catalog")
class CatalogController(
    private val catalogService: CatalogService,
    private val apiConfig: ApiConfig
) {

    @GetMapping("/search")
    fun search(
        @RequestParam name: String? = null,
        @Min(1, message = "Page number must be greater then 1")
        @RequestParam(required = false, defaultValue = "1") page: Int,
        @Min(1, message = "Page size must be greater then 1")
        @RequestParam(required = false, defaultValue = "\${api.config.defaultPageSize}") pageSize: Int
    ): Page<CatalogDto> {
        if (pageSize > apiConfig.mapPageSize)
            throw NetShopApiException("Page size cannot be greater then ${apiConfig.mapPageSize}")
        return catalogService.search(name, page - 1, pageSize)
    }

    @GetMapping
    fun getRootCatalogs(
        @Min(1, message = "Page number must be greater then 1")
        @RequestParam(required = false, defaultValue = "1") page: Int,
        @Min(1, message = "Page size must be greater then 1")
        @RequestParam(required = false, defaultValue = "\${api.config.defaultPageSize}")
        pageSize: Int = apiConfig.defaultPageSize
    ): Page<CatalogDto> {
        if (pageSize > apiConfig.mapPageSize)
            throw NetShopApiException("Page size cannot be greater then ${apiConfig.mapPageSize}")
        return catalogService.getRootCatalogs(page - 1, pageSize)
    }

    @GetMapping("/{catalogId}")
    fun getById(@PathVariable catalogId: Long): CatalogDto {
        return catalogService.getById(catalogId)
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping
    fun createCatalog(@RequestBody catalogCreateDto: CatalogCreateDto): CatalogDto {
        return catalogService.create(catalogCreateDto)
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/{catalogId}")
    fun deleteById(@PathVariable catalogId: Long) {
        catalogService.deleteById(catalogId)
    }

}