package com.mdv.appstore.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RevenueDTO {
    private Long id;
    private LocalDate date;
    private Double totalRevenue;
}
