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



	public static void main(String[] args) {
		SpringApplication.run(Cursomc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	
	}

}
