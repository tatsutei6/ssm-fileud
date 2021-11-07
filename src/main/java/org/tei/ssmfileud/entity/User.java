package org.tei.ssmfileud.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    private Integer id;
    @NotBlank(message="{member.mid.notnull.error}")
    @Length(max = 3,min = 3)
    private String name;

}
