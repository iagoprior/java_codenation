package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel{

    static private final BigDecimal getSoma(Object classe, Class<? extends Annotation> annotation) throws IllegalAccessException{
    BigDecimal adicionar = BigDecimal.ZERO;

    for(Field field : classe.getClass().getDeclaredFields()){
       if (field.isAnnotationPresent(annotation)
               && field.getType().equals(BigDecimal.class)) {
           try{
               field.setAccessible(true);
               adicionar = adicionar.add((BigDecimal) field.get(classe));
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }
    return adicionar;
    }

       @Override
       public BigDecimal somar(Object classe) throws IllegalAccessException{
          return getSoma(classe, Somar.class);

       }


      @Override
      public BigDecimal subtrair(Object classe) throws IllegalAccessException{
      return getSoma(classe, Subtrair.class);

      }


      @Override
      public BigDecimal totalizar(Object classe) throws IllegalAccessException{
      return somar(classe).subtract(subtrair(classe));

    }


}