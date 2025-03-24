package com.example;



import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Optional;


public class AppTest 
{
    
    @Test
	public void objectsAreEqual(){
		String s1 = "Hello";
		String s2 = "Hello";
		assertThat(s1).isEqualTo(s2);
	}

	@Test
	public void objectsAreNotEqual(){
		String s1 = "Hello";
		String s2 = "World";
		assertThat(s1).isNotEqualTo(s2);
	}

	@Test
	public  void referenceIsEqual(){
		String s1 = "Hello";
		String s2 = s1;
		assertThat(s1).isSameAs(s2);
	}

	@Test
	public void referenceIsNotEqual(){
		String s1 = "Hello";
		String s2 = "hello";
		assertThat(s1).isNotSameAs(s2);
	}

	@Test
	public void integerArrayIsEqual(){
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		assertThat(arr1).isEqualTo(arr2);
	}

	@Test
	public void arrayListTest(){
		String s1 = "Hello";
		Integer i1 = 1;
		Double d1 =  1.0;
		Float f1 = 1.0f;

		List<Object> list1 = new ArrayList<>();
		list1.add(s1);
		list1.add(i1);
		list1.add(d1);

		assertThat(list1).containsExactly(s1,i1,d1);

		assertThat(list1).contains(s1,i1,d1);

		assertThat(list1).containsOnlyOnce(s1);
		assertThat(list1).doesNotContain(f1);
	}

	@Test
	public void testHashMap(){
		HashMap<String,String> testMap = new HashMap<>();
		testMap.put("one", "1");
		testMap.put("two", "2");
		testMap.put("three", "3");

		assertThat(testMap).containsKeys("one");
		assertThat(testMap).containsValue("1");
	}

	@Test
	public void testExceptionIndexOutOfRange(){
		int[] arr = {1,2,3};
		assertThatThrownBy(() -> {
			int i = arr[3];
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class); 
	}
	@Test
	public void testOptional(){
		Optional<String> opt = Optional.empty();
		assertThat(opt).isEmpty();
	}
}
