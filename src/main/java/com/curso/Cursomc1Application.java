package com.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.dominio.Categoria;
import com.curso.dominio.Cidade;
import com.curso.dominio.Cliente;
import com.curso.dominio.Endereco;
import com.curso.dominio.Estado;
import com.curso.dominio.ItemPedido;
import com.curso.dominio.Pagamento;
import com.curso.dominio.PagamentoComBoleto;
import com.curso.dominio.PagamentoComCartao;
import com.curso.dominio.Pedido;
import com.curso.dominio.Produto;
import com.curso.dominio.enums.EstadoPagamento;
import com.curso.dominio.enums.TipoCliente;
import com.curso.repository.CategoriaRepository;
import com.curso.repository.CidadeRepository;
import com.curso.repository.ClienteRepository;
import com.curso.repository.EnderecoRepository;
import com.curso.repository.EstadoRepository;
import com.curso.repository.ItemPedidoRepository;
import com.curso.repository.PagamentoRepository;
import com.curso.repository.PedidoRepository;
import com.curso.repository.ProdutoRepository;

@SpringBootApplication
public class Cursomc1Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cursomc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Pão com Pão");
		Categoria cat4 = new Categoria(null, "Pão com ovo frito");
		Categoria cat5 = new Categoria(null, "Baiao de dois");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Mesa", 180.00);
		Produto p3 = new Produto(null, "Teclado", 20.00);
		Produto p4 = new Produto(null, "Garrafa", 4.00);
		Produto p5 = new Produto(null, "Cadeira", 120.00);
		Produto p6 = new Produto(null, "Mouse", 35.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4));
		cat5.getProdutos().addAll(Arrays.asList(p1,p2,p3,p6));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3,p4,p5,p6));

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "aaaa", "aaaa@gmail.com", "12332145621", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("1111-2222", "2222-3333"));

		Endereco e1 = new Endereco(null, "Rua abc", "321", "Casa 1", "Alfabeto", "00000-111", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua bcd", "111", "Casa A", "Longe", "11111-000", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
