package com.revature.activity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.revature.exercise.SecretClass;

public class ReflectionActivity {

	/*
	 * Find all of the following:
	 * 1. What fields does the secret class have? id, name, message, passcode
	 * 2. What methods does the secret class have? getMessage getStaticMessahe
	 * 3. What are the modifiers on the fields and the methods? private, private, private, private final, public, public static
	 * 4. What happens when you call each of the methods? https://i.ytimg.com/vi/GUlWIxrZp9M/maxresdefault.jpg https://www.youtube.com/watch?v=dQw4w9WgXcQ
	 * 5. What are the values of the fields? 4, Alchemy, https://i.ytimg.com/vi/GUlWIxrZp9M/maxresdefault.jpg, 123123321
	 * 6. What annotations are used in the secret class?
	 * 7. What fields do the annotations have? 
	 * 8. Which fields in the secret class use the annotations? 
	 * 9. What are the values of those annotations' fields on each class field? 
	 * 10. What annotation(s) does the class itself have, and what are the values of 
	 *     the field(s) on them?
	 */
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		SecretClass secret = new SecretClass();
		Class objClass = secret.getClass();
		Field[] fields = objClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("Fields are: " + field.getName());
			int modifier = field.getModifiers();
			System.out.println("Modifiers are: " + Modifier.toString(modifier));
			Object type = field.getType();
			field.setAccessible(true);
			Object value = field.get(secret);
			field.set(secret, value);
			System.out.println("Value is: " + field.get(secret));
			System.out.println(field.getName() + "'s annotations are: ");
			Annotation[] annotations = field.getDeclaredAnnotations();
			System.out.println(annotations.length);
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			System.out.println();
		}
		Method[] methods = objClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("Methods are: " + method.getName());
			int modifier = method.getModifiers();
			System.out.println("Modifiers are: " + Modifier.toString(modifier));
			System.out.println(method.getName() + "'s annotations are: ");
			Annotation[] annotations = method.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			System.out.println();
		}
		System.out.println(secret.getMessage());
		System.out.println(secret.getStaticMessage());
		System.out.println();
		
		Annotation[] declaredAnnotations = secret.getClass().getDeclaredAnnotations();
		System.out.println("Class annotations are: ");
		for (Annotation annotation : declaredAnnotations) {
			System.out.println(annotation);
		}
	}

	/*
	 * Example using the class and annotation below:
	 * 
	 * 1. the fields are name and number
	 * 2. the method is getName
	 * 3. name is public, number is public/static, getName() is public
	 * 4. the method returns the value of the name field
	 * 5. the value of name is "Ash", the value of number is 30
	 * 6. the annotation is Hello
	 * 7. the Hello annotation has a "value" field
	 * 8. the number field uses the Hello annotation
	 * 9. the "value" field of Hello is "num" on the number field
	 * 10. the class has the Hello field and its value is the default, "world"
	 * 
	 * @Hello
	 * public class Example {
	 * 		private String name = "Ash";
	 * 		@Hello(value="num")
	 * 		private static int number = 30;
	 *		public String getName() {
	 *			return this.name;
	 *		}
	 * }
	 * 
	 * @interface Hello {
	 * 		String value() default "world";
	 * }
	 */
}
