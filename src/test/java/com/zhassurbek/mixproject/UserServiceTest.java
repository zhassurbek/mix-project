package com.zhassurbek.mixproject;


import com.zhassurbek.mixproject.jpaRepo.UserRepository;
import com.zhassurbek.mixproject.model.User;
import com.zhassurbek.mixproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // создаем имитацию - mock(мокаем)
    @Mock
    private UserRepository userRepository;

    // подставляем имитацию в сервис
    @InjectMocks
    private UserService userService;

    // пишем тест
    @Test
    public void testFindByUsername() {
        // Подготовим имитацию (mock) объекта User и UserRepository
        User mockUser = new User();
        mockUser.setUsername("zhassurbek");

        when(userRepository.findByUsername("zhassurbek")).thenReturn(mockUser);

        // Вызовим метод, который вы хотите протестировать
        User resultUser = userService.findByUsername("zhassurbek");

        // Проверим, что метод вернул ожидаемый результат
        assertEquals("zhassurbek", resultUser.getUsername());

        // Проверим, что метод репозитория был вызван с правильным аргументом
        verify(userRepository, times(1)).findByUsername("zhassurbek");
    }

}
