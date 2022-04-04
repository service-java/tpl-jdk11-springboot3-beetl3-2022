package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.java.Log;

@SpringBootTest
@Log
class DemoApplicationTests {

	@Test
	void contextLoads() {
		var a = """
select * 
from sys_user u 
where 1=1 
-- @ if(isNotEmpty(name)){
and name like #{name}
-- @ }
order by u.id desc
				""";
		log.info(a);
		
	}

}
