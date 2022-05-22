package com.shardeum.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FaqResponce {
    private List<FaqExcelDto> file;
}
