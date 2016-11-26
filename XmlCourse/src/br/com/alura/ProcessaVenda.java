package br.com.alura;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutosHandler;

public class ProcessaVenda {

	public static void main(String[] args) throws Exception {
		lerPeloSax();
	}
	
	public static void lerPeloSax() throws Exception{
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		ProdutosHandler produtosHandler = new ProdutosHandler();
		xmlReader.setContentHandler(produtosHandler);
		
		FileInputStream fileInputStream = new FileInputStream("src/venda.xml");
		InputSource inputSource = new InputSource(fileInputStream);
		
		xmlReader.parse(inputSource);
		System.out.println(produtosHandler.getProdutos());
	}
	
	public static void lerPeloDOM() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		
		NodeList formasPagamento = document.getElementsByTagName("formaDePagamento");
		System.out.println(formasPagamento.item(0).getTextContent());
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);
		
		NodeList produtos = document.getElementsByTagName("produto");
		for(int i=0;i<produtos.getLength();i++){
			Element produtoElement = (Element) produtos.item(i);
			String nome = produtoElement.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produtoElement.getElementsByTagName("preco").item(0).getTextContent());
			
		    Produto produto = new Produto(nome,preco);
		    
		    System.out.println(produto);
		}
	}
}
