package br.com.codenation.desafioexe;




import java.util.ArrayList;

import java.util.List;




public class DesafioApplication {


	public static List<Integer> fibonacci() {


		List<Integer> fibo = new ArrayList<>();


		fibo.add(0,0);

		fibo.add(1,1);


		for(int i = 2; i<15; i++){


			fibo.add(i,fibo.get(i - 2) + fibo.get(i - 1));

		}


		return new ArrayList<>(fibo);


	}




	public static Boolean isFibonacci(Integer value){


		return fibonacci().contains(value);

	}





}