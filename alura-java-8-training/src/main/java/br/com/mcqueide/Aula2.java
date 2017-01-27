package br.com.mcqueide;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Aula2 {

	private static List<String> palavras;
	
	public static void main(String[] args) {
	
		palavras = new ArrayList<>();
    	palavras.add("alura online");
    	palavras.add("editora casa do codigo");
    	palavras.add("caelum");
    	
    	interableForEach();
	}
	
	public static void interableForEach(){
    	System.out.println("\n\nFor each da interface interable passando classe anônima:");
    	palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
    	
    	System.out.println("\n\nFor each da interface interable usando lâmbida:");
    	palavras.forEach((String s) -> {
				System.out.println(s);
    		}
		);
    	
    	System.out.println("\n\nFor each da interface interable usando lâmbida, e removendo declarações opcionais para interfaces funcionais:");
    	palavras.forEach(s -> System.out.println(s));
    }

}