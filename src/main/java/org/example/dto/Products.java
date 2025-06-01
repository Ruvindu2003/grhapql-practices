package org.example.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
public class Products{

    private Integer id;
    private String name;
    private String adress;
    private Float price;
    private String category;
}
