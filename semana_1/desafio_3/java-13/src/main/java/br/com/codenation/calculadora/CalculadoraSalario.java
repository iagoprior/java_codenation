package br.com.codenation.calculadora;



public class CalculadoraSalario {


	public long calcularSalarioLiquido(double salarioBase) {


		if(salarioBase < 1039.00){

			return Math.round(0.0);

		}


		double descontoINSS = salarioBase - calcularInss(salarioBase);

		double descontoIRFF = descontoINSS - calcularIRRf(descontoINSS);

		return Math.round(descontoIRFF);

	}


	private double calcularInss(double salarioBase) {


		double desconto;

		double salarioDescontadoINSS;

		if(salarioBase <= 1500.00){

			desconto = 8.0;

			salarioDescontadoINSS = desconto * (salarioBase/100);

		}else if(salarioBase <= 4000.00){

			desconto = 9.0;

			salarioDescontadoINSS = desconto * (salarioBase/100);

		}else{

			desconto = 11.0;

			salarioDescontadoINSS = desconto * (salarioBase/100);

		}

		return salarioDescontadoINSS;

	}


	private double calcularIRRf(double descontoINSS) {


		double desconto;

		double salarioDescontadoIRFF;

		if(descontoINSS <= 3000.00){

			desconto = 0.0;

			salarioDescontadoIRFF = desconto * (descontoINSS/100);

		}else if(descontoINSS <= 6000.00 ){

			desconto = 7.5;

			salarioDescontadoIRFF = desconto * (descontoINSS/100);

		}else{

			desconto = 15.0;

			salarioDescontadoIRFF = desconto * (descontoINSS/100);

		}

		return  salarioDescontadoIRFF;

	}

}



