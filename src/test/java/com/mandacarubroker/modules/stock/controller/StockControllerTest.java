package com.mandacarubroker.modules.stock.controller;

import com.mandacarubroker.modules.stock.Stock;
import com.mandacarubroker.modules.stock.service.CreateStockService;
import com.mandacarubroker.modules.stock.service.DeleteStockService;
import com.mandacarubroker.modules.stock.service.ReadStockService;
import org.hibernate.sql.Delete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StockControllerTest {

    @DisplayName("Retorna a lista de ações")
    @Test
    void getAllStocks_ReturnsListOfStocks() {
        // Arrange
        ReadStockService readStockService = mock(ReadStockService.class);
        List<Stock> expectedStocks = Arrays.asList(new Stock(), new Stock());
        when(readStockService.findAll()).thenReturn(expectedStocks);

        // Act
        List<Stock> actualStocks = readStockService.findAll();

        // Assert
        assertEquals(expectedStocks, actualStocks);
    }

    @DisplayName("Retorna uma ação através do ID")
    @Test
    void getStockById_WithValidId_ReturnsStock() {
        // Arrange
        ReadStockService readStockService = mock(ReadStockService.class);
        Stock expectedStock = new Stock();
        when(readStockService.findById("validId")).thenReturn(expectedStock);

        // Act
        Stock actualStock = readStockService.findById("validId");

        // Assert
        assertEquals(expectedStock, actualStock);
    }

    // Dificuldade para criar os outros testes, create, update e delete :-(


}
