package com.shardeum.service;


import com.shardeum.client.FaqExcelClient;
import com.shardeum.dto.FaqExcelDto;
import com.shardeum.dto.SearchByMessageResponse;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;

@Service
@RequiredArgsConstructor
public class FaqService {
    private final FaqExcelClient faqExcelClient;

    public SearchByMessageResponse findAnswerByMessage(String message) {
        return faqExcelClient.getAnswerByText(message);
    }

    public String findAnswerById(Integer id) {
        String result = faqExcelClient.getExcelData();
        result = result.substring(result.indexOf("\r\n" + id + ","), result.indexOf(id + 1 + ",") - 2);
        result = result.substring(result.indexOf("?,") + 2);
        return result;
    }
}