package com.exercise.bitboxer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ItemDTO implements Serializable {

    private  Long id;

    private  Long itemCode;

    private  String description;

    private  BigDecimal price;

    private  Boolean status;

    @JsonFormat(shape= JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private  LocalDateTime createdDate;

    private Set<SupplierDTO>  suppliers;
    @JsonManagedReference
    private Set<PriceReductionDTO> priceReductions;
}
