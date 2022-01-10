package com.osfdigital.reactivecrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("aluno")
public class Aluno {

    @Id
    private Long id;
    @NotEmpty
    private String nome;
    @NotNull
    private Integer idade;
    @NotEmpty
    private String serie;
}
