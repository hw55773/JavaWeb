package com.wh;

import com.wh.mapper.DepteMapper;
import com.wh.pojo.Depte;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootCrudMybitisApplicationTests {

	@Resource(name = "depteMapper")
	DepteMapper depteMapper;

	//删除测试
	@Test
	void deleteDepteTest() {
		depteMapper.deletDepte(13);


	}
	//增加测试
	@Test
	void insertDepte(){
		Depte depte=new Depte();
		depte.setDepteName("中学部");
		depte.setCagrotery("民企企");
		depte.setCreateTime(LocalDateTime.of(2024,04,15,12,05,12));
		depte.setUpdateTime(LocalDateTime.now());
		depteMapper.insertDepte(depte);
		System.out.println(depte.getId());
	}
	//更新测试
	@Test
	void updateDepte(){
		Depte depte=new Depte();
		depte.setId(8);
		depte.setDepteName("董事部");
		depte.setCagrotery("国企");
		depte.setCreateTime(LocalDateTime.of(2024,04,15,12,05,12));
		depte.setUpdateTime(LocalDateTime.now());
		depteMapper.updateDepte(depte);

	}
	//根据Id查询
	@Test
	void search(){
		System.out.println(depteMapper.search(7));
	}

	//条件查询&动态
	@Test
	void searchOrder(){

		System.out.println(depteMapper.searchOrder(null,"民企", LocalDate.of(2024,03,01),LocalDate.of(2024,05,01)));

	}
	//动态更新
	@Test
	void updateDepte2() {
		Depte depte = new Depte();
		depte.setId(8);
		depte.setDepteName("资源部");
		depte.setUpdateTime(LocalDateTime.now());
		depteMapper.updateDepte(depte);
	}
	//删除多个行信息
	@Test
	void deleteList(){
		List<Integer> ids= Arrays.asList(18,19,20);

		depteMapper.deleteList(ids);
	}
}
