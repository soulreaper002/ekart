package com.project.retail.Ekart.DAO;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.retail.Ekart.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UseruserRepoTest {
	@Autowired
	UserRepository userRepo;
	@Test
	public void useruserRepo_findByIdtTest() {
	//	User user = userRepo.findById(1);
		//assertEquals("Sudhanshu", user.getUser_name());
	}
	@Test
	@DirtiesContext
	public void useruserRepo_deleteByIdtTest() {
		/*
		 * //userRepo.delete(1); assertNull(userRepo.findById(1));
		 */
	}
	@Test
	@DirtiesContext
	public void useruserRepo_saveTest()
	{
		/*
		 * //get the user Optional<User> user = userRepo.findById(1);
		 * //assertEquals("Sudhanshu", user.getUser_name()); //update the user
		 * //user.setUser_name("rashmi"); //userRepo.save(user); //test the save // User
		 * user1 = userRepo.findById(1); //assertEquals("rashmi", user1.getUser_name());
		 */			
	}
}
