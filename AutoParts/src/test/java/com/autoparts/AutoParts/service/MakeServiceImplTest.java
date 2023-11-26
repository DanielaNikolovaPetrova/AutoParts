package com.autoparts.AutoParts.service;

import com.autoparts.AutoParts.converter.autoPart.MakeConverter;
import com.autoparts.AutoParts.dto.autoPart.MakeRequest;
import com.autoparts.AutoParts.entity.autoPart.Make;
import com.autoparts.AutoParts.repository.autoPart.MakeRepository;
import com.autoparts.AutoParts.service.autoPart.impl.MakeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MakeServiceImplTest {
    @InjectMocks
    private MakeServiceImpl service;

    @Mock
    private MakeRepository repository;

    @Mock
    private MakeConverter converter;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new MakeServiceImpl(repository, converter);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void addMake(){
        //Arrange
        MakeRequest request = MakeRequest.builder()
                .name("Ford")
                .build();
        Make make = Make.builder()
                .id(1L)
                .name(request.getName())
                .build();
        when(converter.toMake(request)).thenReturn(make);
        when(repository.save(make)).thenReturn(make);

        //Act
        Make savedMake = service.addMake(request);

        //Assert
        assertNotNull(savedMake);
        assertEquals(make, savedMake);

        verify(repository, times(1)).save(any(Make.class));

    }
}
