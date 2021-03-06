package com.example.easycooking.test;
/**
 * This class is testing the Image model
 * @author Chenkun
 *
 */
import static org.junit.Assert.*;
import com.example.easycooking.model. *;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImageTest {

	Image image;
	
	@Before
	       public void setUp()  {
		 	image = new Image();
              	}



        @After 
                public void tearDown(){
		   image = null;					  
        	}
  // test whether create image is successful or not 
    	@Test
        	public void CreateImageTest() {
		
	//	java.util.ArrayList<Ingredient>  v1 = new java.util.ArrayList<Ingredient>();
	//	java.util.ArrayList<Image>  v2 = new java.util.ArrayList<Image>();
	//	Step step = new Step();
	//	Recipe recipe = new Recipe("000000","fried rice",v2,v1,step, 0);
		 image.set_IMAGE_ID("121212");
		 image.set_image_belongto("000000");
		 image.set_imageUri("12345678");
		 
		 assertEquals("000000",image.get_image_belongto());
		 assertEquals("121212",image.get_IMAGE_ID());
		 assertEquals("12345678",image.get_imageUri());
		 
	}
	
}	
	
