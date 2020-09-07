package br.com.codenation.desafioexe;
import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	@org.jetbrains.annotations.NotNull
	public static List<Integer> fibonacci() {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(0);
		ls.add(1);
		Integer result = 0;
		while(result <= 350) {
			result = ls.get(ls.size() - 2) + ls.get(ls.size() - 1);
			ls.add(result);
		}
		return ls;
	}
	public static boolean isFibonacci(Integer n){
		return fibonacci().contains(n);
	}

}