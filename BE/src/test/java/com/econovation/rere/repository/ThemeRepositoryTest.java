package com.econovation.rere.repository;

import com.econovation.rere.entity.CardBook;
import com.econovation.rere.entity.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ThemeRepositoryTest {

    @Autowired
    private ThemeRepository repository;

    @Test
    void testThemeInsert(){
        Theme theme = new Theme();
        LocalDateTime time = LocalDateTime.now();
        theme.setThemeName("SW 응용 기초");

//        theme과 cardbook은 의존 관계가 존재하는데,
//        어떻게 설정하지?
//        theme.setCardbook();

        theme.setCreateDate(time);
        theme.setUpdateDate(time);

        this.repository.save(theme);
    }
}
