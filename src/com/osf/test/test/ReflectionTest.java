package com.osf.test.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Test{
	private String str;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Test [str=" + str + ", name=" + name + "]";
	}

	
	
	
}

public class ReflectionTest {

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.osf.test.test.Test"); //class는 예약어기 때문에 class 변수를 만들때는 clazz or clss를 사용한다.
//			Method[] methods = clazz.getMethods();//Object를 포함한 메소드 표출.
			Method[] methods = clazz.getDeclaredMethods();//순수한 Test의 메서드 표출.
			Object obj = clazz.newInstance();
			for(Method m : methods) {
				//System.out.println(m.getName());
				String mName = m.getName();
				int idx = mName.indexOf("set");//getter setter중 setter만 찾겠다 !
				if(idx==0) {//getter setter중 setter만 찾겠다 !
					System.out.println(mName);
					m.invoke(obj, "abc"); //obj가 가지고있는 set메서드에 abc라는 스트링값을 강제로 입력해서 set 메소드를 호출.
					if("setname".equals(mName.toLowerCase())) {
						m.invoke(obj, "홍길동");
					}
				}
			}
			System.out.println(obj);
			//Test t = (Test)clazz.newInstance();// forName에 있는 클래스를 로딩한다음에 생성자를 실행시키는 메서드.
			//System.out.println(t); // 에러가 나지 않는 이유는 newInstance()에서 new Test가 실행되었기 때문에 . 
			//Test t1 = new Test();
			//System.out.println(t1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
