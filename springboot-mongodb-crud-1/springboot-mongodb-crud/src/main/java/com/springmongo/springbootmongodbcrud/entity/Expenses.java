package com.springmongo.springbootmongodbcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("expense")
public class Expenses {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expensesName;
    @Field(name = "category")
    private ExpensesCategory expensesCategory;
    @Field(name = "amount")
    private BigDecimal expensesAmount;
}
