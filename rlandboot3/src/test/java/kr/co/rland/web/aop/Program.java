package kr.co.rland.web.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc = new DefaultCalculator(3, 4);

		// 자바에서 제공하는 AOP 기능

		Calculator 가짜 = (Calculator) Proxy.newProxyInstance(
				DefaultCalculator.class.getClassLoader()
				,new Class[] { Calculator.class }
				,(Object proxy, Method method, Object[] ags) -> {
					
					System.out.printf("호출되고 있는 메소드 이름: %s\n", method.getName());
					System.out.printf("메소드 호출 전\n", method.getName());
					Object result = method.invoke(calc, ags);
					System.out.printf("결과값 : %d\n",result);
					System.out.printf("메소드 호출 후\n", method.getName());
					
					return result;
				});

		int result = 0;

		result = 가짜.plus();
		System.out.printf("plus result : %d\n", result);
		result = 가짜.sub();
		System.out.printf("sub result : %d\n", result);
		result = 가짜.multi();
		System.out.printf("multi result : %d\n", result);
	}

}
