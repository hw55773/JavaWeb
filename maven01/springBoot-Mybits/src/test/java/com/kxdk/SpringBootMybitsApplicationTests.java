package com.kxdk;

import com.kxdk.mapper.DepteMapper;
import com.kxdk.pojo.Depte;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybitsApplicationTests {

    @Resource(name = "depteMapper")
    DepteMapper depteMapper;
    @Test
    void allListdepte() {
        List<Depte> depteList=depteMapper.depteList();
        depteList.stream().forEach(depte -> {
            System.out.println(depte);
        });
    }

}
