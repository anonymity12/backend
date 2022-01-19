package com.xj.family;

import java.util.List;

import com.xj.family.bean.Say;
import com.xj.family.service.SayService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FamilyApplicationTests {
	@Autowired
	SayService sayService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllSays() {
		System.out.println("lllll");

		List<Say> list = sayService.getAllSays();
		System.out.println(list);
	}

}
