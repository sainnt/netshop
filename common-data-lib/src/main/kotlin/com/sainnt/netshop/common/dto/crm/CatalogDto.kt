package com.sainnt.netshop.common.dto.crm

import com.fasterxml.jackson.annotation.JsonInclude

data class CatalogDto(
    val id: Long,
    val name:String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var subCatalogs: List<CatalogDto>? = null
)