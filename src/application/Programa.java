package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import exception.DomainException;

public class Programa {

	public static void main(String[] args) throws DomainException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Produto p = new Produto();
		
		System.out.println("Onde deseja salvar o arquivo?");
		String caminhoOrigem = sc.nextLine();	
		System.out.println("Qual o nome do arquivo?");
		String arquivoOrigem = sc.nextLine();
		
		System.out.println("Deseja incluir dados no arquivo(S/N)?");
		char decisao = sc.next().charAt(0);
		
		while (decisao == 'S' || decisao == 's') {

			System.out.println("Digite o nome do produto: ");
			p.setNomeProduto(sc.next());
			System.out.print("Digite a quantidade: ");
			p.setQtdProduto(sc.nextLong());
			System.out.print("Digite o valor: ");
			p.setValorProduto(sc.nextDouble());
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoOrigem + arquivoOrigem, true))){
				bw.write(p.toString());
				bw.newLine();
			} catch (IOException e) {
				throw new DomainException("Mensagem: " + e.getMessage());
			} 
			
			System.out.println("Deseja continuar incluir dados no arquivo(S/N)?");
			decisao = sc.next().charAt(0);
			
		}
		String caminhoDestino = caminhoOrigem + "out\\";
		boolean dirCriado = new File(caminhoDestino).mkdir();
		
			try (BufferedReader br = new BufferedReader(new FileReader(caminhoOrigem + arquivoOrigem))){
				String linha = br.readLine();
				while (linha != null) {
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDestino + "summary.csv", true))){
						String vetor[] = linha.split(";");
						
                        Produto produto = new Produto(vetor[0].trim(),Double.parseDouble(vetor[1].trim()), Long.parseLong(vetor[2].trim()));
                        bw.write(produto.toStringOut());
						bw.newLine();
					} catch (IOException e) {
						throw new DomainException("Mensagem: " + e.getMessage());
					} 
					linha = br.readLine();
				}
				System.out.println("Arquivo destino criado com sucesso.");
			} catch (IOException e) {
				throw new DomainException("Mensagem: " + e.getMessage());
			}
			
		
		sc.close();
	}

}
