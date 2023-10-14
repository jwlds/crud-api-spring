package br.com.jw.crudappauth.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

public record ProductDTO(
         @NotBlank
         String name,

         BigDecimal price,

         String category,

         String description,

         String code,


         int quantityInStock,

         List<String>images) {
}
