package br.com.codenation;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

import java.util.stream.IntStream;

import java.util.*;

import java.util.function.Function;


public class StatisticUtil {


	public static int average(int[] elements) {


		Arrays.sort(elements);
		double mean = 0.0;
		for (double n : elements) {
			mean = mean + n;
		}
		mean = mean / elements.length;
		return (int) mean;
	}


	public static int mode(int[] elements) {

		return IntStream.of(elements)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Comparator.comparingLong(Map.Entry::getValue))
				.get().getKey();
	}


	public static int median(int[] elements) {

		Arrays.sort(elements);
		double median = 0;
		double pos1 = Math.floor((elements.length - 1.0) / 2.0);
		double pos2 = Math.ceil((elements.length - 1.0) / 2.0);

		if (pos1 == pos2 ) {
			median = elements[(int)pos1];
		} else {
			median = (elements[(int)pos1] + elements[(int)pos2]) / 2.0 ;
		}
		return (int) median;
	}
}


