package com.example.demo.service;

import com.example.demo.entity.AccountReference;
import com.example.demo.repository.BaseRepository;
import com.example.demo.util.DbResultMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbResultTest1 {

    @InjectMocks
    private DbResult dbResult;
    @Mock
    private BaseRepository<AccountReference, String> accountReferenceRepository;
    @Spy
    private DbResultMapper dbResultMapper;

    @Test
    public void test_InsertAccountReference() {
        // Actual input
        com.example.demo.dto.AccountReference accountRef = new com.example.demo.dto.AccountReference();
        accountRef.setAccountNumber("789456");
        accountRef.setAccountType("UBC");
        accountRef.setKeyAccountNumber("123456876");

        // Expected Output
        com.example.demo.entity.AccountReference accRef = new com.example.demo.entity.AccountReference();
        accRef.setAccountId("1234567890");
        accRef.setAccountNumer(789456);
        accRef.setAccountType("UBC");
        accRef.setKeyAccount("123456876");

        when(accountReferenceRepository.save(accRef)).thenReturn(accRef);
        dbResult.insertAccountReference1(accountRef);
        verify(accountReferenceRepository, times(1)).save(accRef);
    }
}
