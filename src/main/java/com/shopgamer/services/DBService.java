package com.shopgamer.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Cidade;
import com.shopgamer.domain.Cliente;
import com.shopgamer.domain.Endereco;
import com.shopgamer.domain.Estado;
import com.shopgamer.domain.ItemPedido;
import com.shopgamer.domain.Pagamento;
import com.shopgamer.domain.PagamentoComBoleto;
import com.shopgamer.domain.PagamentoComCartao;
import com.shopgamer.domain.Pedido;
import com.shopgamer.domain.Produto;
import com.shopgamer.domain.enums.EstadoPagamento;
import com.shopgamer.domain.enums.Perfil;
import com.shopgamer.domain.enums.TipoCliente;
import com.shopgamer.repositories.CategoriaRepository;
import com.shopgamer.repositories.CidadeRepository;
import com.shopgamer.repositories.ClienteRepository;
import com.shopgamer.repositories.EnderecoRepository;
import com.shopgamer.repositories.EstadoRepository;
import com.shopgamer.repositories.ItemPedidoRepository;
import com.shopgamer.repositories.PagamentoRepository;
import com.shopgamer.repositories.PedidoRepository;
import com.shopgamer.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Categoria categoria1 = new Categoria(null, "Cadeira Gamer");
		Categoria categoria2 = new Categoria(null, "CPU Gamer");
		Categoria categoria3 = new Categoria(null, "Fone Gamer");
		Categoria categoria4 = new Categoria(null, "Mesa Gamer");
		Categoria categoria5 = new Categoria(null, "Monitor Gamer");
		Categoria categoria6 = new Categoria(null, "Notebook Gamer");
		Categoria categoria7 = new Categoria(null, "Teclado Gamer");

		Produto produto1 = new Produto(null, "Cadeira Gamer TGC12 – ThunderX3", 1539.90);
		Produto produto2 = new Produto(null, "Cadeira Gamer Mad Racer V8 Turbo - Pcyes", 1731.11);
		Produto produto3 = new Produto(null, "Cadeira Gamer EC3 – ThunderX3", 1249.90);
		Produto produto4 = new Produto(null, "Cadeira Gamer Ergonomic Yama1 - ThunderX3", 208.75);
		Produto produto5 = new Produto(null, "Cadeira Gamer Mx7 – Mymax", 899.00);
		Produto produto6 = new Produto(null, "Cadeira Gamer Rush - Racer-X", 1690.00);
		Produto produto7 = new Produto(null, "Cadeira Gamer EC1 – ThunderX3", 892.00);
		Produto produto8 = new Produto(null, "Cadeira Gamer Cruiser – Fortrek", 1290.00);
		Produto produto9 = new Produto(null, "Cadeira Gamer Sti Master - Pcyes", 836.99);
		Produto produto10 = new Produto(null, "Cadeira Gamer Conforsit - Zermatt", 1468.80);

		Produto produto11 = new Produto(null, "Pc Gamer Intel Core i7, 16GB RAM DDR3, GT 1030 2GB, SSD 480GB, Fonte 500w, Gabinete com LED", 3900.00);
		Produto produto12 = new Produto(null, "PC Gamer Completo AMD 10-Core CPU 3.8Ghz 8GB (Placa de vídeo Radeon R5 2GB) SSD e HD 2TB Kit Gamer Skill Monitor HDMI LED 19.5 Casual",3099.00);
		Produto produto13 = new Produto(null, "PC Gamer AMD 6-Core CPU 3.8Ghz 8GB (Placa de vídeo Radeon R5 2GB) SSD 120GB Skill Casual", 1486.30);
		Produto produto14 = new Produto(null, "Cpu Core I5, 8GB, SSD 240GB, Gabinete Gamer, Fonte 500w", 2219.19);
		Produto produto15 = new Produto(null, "PC Gamer Completo AMD 6-Core CPU 3.8Ghz 8GB (Placa de vídeo Radeon R5 2GB) SSD 120GB Kit Gamer Skill Monitor HDMI LED 19.5\" Casual",2171.59);
		Produto produto16 = new Produto(null, "Pc Gamer Fácil Intel Core I5 3470S 8Gb DDR3 GeForce GT 730 2Gb 128 bits HD 1 TB", 2599.99);
		Produto produto17 = new Produto(null, "Pc Gamer/Home Office I5 3470-8gb - 1tb Top27", 1930.00);
		Produto produto18 = new Produto(null, "CPU Gamer Core i5 3470, 8GB, 1TB, GT710 2GB", 2325.00);
		Produto produto19 = new Produto(null, "PC Gamer Completo AMD 6-Core CPU 3.8Ghz 8GB (Placa de vídeo Radeon R5 2GB) SSD 120GB Skill Monitor HDMI LED 19.5", 2030.99);
		Produto produto20 = new Produto(null, "PC Gamer Roda Tudo AMD A6 3.8GHZ Placa de vídeo Radeon R5 2GB HD 500GB 8GB Skill", 1592.87);

		Produto produto21 = new Produto(null, "Headset Gamer Pro H2 Preto, Fortrek", 107.50);
		Produto produto22 = new Produto(null, "Headset Logitech H390", 211.00);
		Produto produto23 = new Produto(null, "Headset Gamer HyperX Cloud Stinger", 229.00);
		Produto produto24 = new Produto(null, "Razer Headset Kraken X Lite Multi Platform", 1048.66);
		Produto produto25 = new Produto(null, "HyperX Gaming Headset Cloud Revolver", 1049.00);
		Produto produto26 = new Produto(null, "HyperX Gaming Headset Cloud Alpha", 799.00);
		Produto produto27 = new Produto(null, "Headset PUBG Azul", 169.90);
		Produto produto28 = new Produto(null, "Headset Gamer Redragon Ares Preto e Vermelho H120", 109.90);
		Produto produto29 = new Produto(null, "Headset Gamer JBL Quantum 100 Over Ear Preto - JBLQUANTUM100BLK", 169.90);
		Produto produto30 = new Produto(null, "Headphone Fone de Ouvido Havit HV-H2232d, Gamer", 101.62);

		Produto produto31 = new Produto(null, "Mesa para Computador Desk Gamer DRX 6000 Espresso Móveis Álamo/Preto/Vermelho", 473.58);
		Produto produto32 = new Produto(null, "Mesa para Computador Desk Gamer DRX 6000 Espresso Móveis Preto", 473.58);
		Produto produto33 = new Produto(null, "Mesa Gamer Madesa 9409 - Preto", 299.99);
		Produto produto34 = new Produto(null, "Mesa Para Computador/Gamer MX Preto Com 5 Prateleiras e Gancho para HeadSet", 299.90);
		Produto produto35 = new Produto(null, "Mesa para Computador Desk Gamer DRX 3000 Siena Móveis Preto", 388.48);
		Produto produto36 = new Produto(null, "Mesa para Computador/Gamer Mx Verde com 5 Prateleiras e Gancho para Headset", 299.00);
		Produto produto37 = new Produto(null, "Mesa para Computador Gamer 9409 Madesa - Branco", 399.99);
		Produto produto38 = new Produto(null, "Mesa Gamer Notável com Suporte para Fone NT2020", 349.50);
		Produto produto39 = new Produto(null, "Mesa Gamer Madesa 9409 - Branco", 299.99);
		Produto produto40 = new Produto(null, "MESA GAMER FORTREK GDESK HMG01 VERDE", 624.48);

		Produto produto41 = new Produto(null, "Monitor Philips 18.5\" LED HDMI 193V5LHSB2", 1050.50);
		Produto produto42 = new Produto(null, "Monitor LG Widescreen 24MK430H - 23.8\" LED, Full HD IPS, HDMI", 955.90);
		Produto produto43 = new Produto(null, "Monitor Samsung LED 23.5\" Widescreen Curvo, Full HD, HDMI/VGA, FreeSync - LC24F390FHLMZD", 1319.00);
		Produto produto44 = new Produto(null, "Monitor Gamer AOC SPEED 24\" 75Hz IPS 1ms", 999.99);
		Produto produto45 = new Produto(null, "Monitor Gamer AOC SNIPER 27\" 75Hz IPS 1ms", 1685.90);
		Produto produto46 = new Produto(null, "Monitor Gamer LG Ultragear 24ML600M - 23.8\" Full HD IPS, 2 HDMI, FreeSync, 1ms GtG, NVIDIA FreeSync", 1300.00);
		Produto produto47 = new Produto(null, "LG 29WK500-P - Monitor LG 29” UltraWide LED IPS Full HD, Preto", 1666.66);
		Produto produto48 = new Produto(null, "Monitor Gamer Acer 23,6'' KG241Q FHD 144Hz DVI/HDMI DisplayP", 2100.00);
		Produto produto49 = new Produto(null, "Monitor Gamer AOC Hero 27\" 144Hz IPS 1ms G-Sync Compatible 27G2, Preto, Grande", 1199.90);
		Produto produto50 = new Produto(null, "Monitor BenQ PD2700Q para Design Profissional com 27\" e Painel IPS QHD com 100% sRGB e Rec.", 4199.90);

		Produto produto51 = new Produto(null, "Notebook Gamer Acer Nitro 5 AN515-54-528V 15.6\" Core i5 8GB RAM,1TB+128SSD, GTX1650 4GB Win10 Home", 6399.00);
		Produto produto52 = new Produto(null, "Notebook Gamer Legion 5i i7-10750H 16GB 512GB SSD RTX2060 6GB W10 15.6\" Full HD WVA 82CF0002BR", 10249.00);
		Produto produto53 = new Produto(null, "Notebook Gamer Dell G15-i1100-M50P 15.6\" FHD 11ª Geração Intel Core i7 16GB 512GB SSD NVIDIA RTX 3060 Windows 11", 12309.99);
		Produto produto54 = new Produto(null, "Notebook Gamer Predator Helios 300 PH315-53-75N8 Intel Core i7 16GB 512GB SSD RTX 2060 15,6' Windows 10", 9999.99);
		Produto produto55 = new Produto(null, "Samsung Odyssey Intel® Core™ i5H, Windows 10, 8GB, 1TB, GeForce® GTX 1650 4GB, 15.6'' PLS Full HD LED", 12464.00);
		Produto produto56 = new Produto(null, "Notebook IdeaPad Gaming 3i, Intel Core i5-10300H, 8GB RAM, 256GB SSD, Placa Dedicada GTX 1650 4GB, Windows 10, 15.6\" Full HD WVA, Azul", 5289.12);
		Produto produto57 = new Produto(null, "Notebook ASUS M515DA-EJ502T AMD RYZEN 5 3500U / Radeon Vega 8 / 8 GB / 256 GB SSD / Windows 10 Home / Cinza", 3905.07);
		Produto produto58 = new Produto(null, "Notebook Gamer Dell G3-3500-A15P 10ª Geração Core i5 8GB 512GB SSD NVIDIA GTX 1650 Tela 15.6\" Windows 10 Preto", 4168.80);
		Produto produto59 = new Produto(null, "Notebook ASUS VivoBook X543UA-DM3457T INTEL CORE I5 8250U / Intel® HD graphics 620 / 8 GB / 256 GB / Windows 10 Home / Cinza Escuro", 4299.00);
		Produto produto60 = new Produto(null, "Notebook Lenovo Ultrafino ideapad S145 Ryzen 5 12GB 1TB Linux 15.6\" 81V7S00000 Prata", 3299.00);

		Produto produto61 = new Produto(null, "Teclado Rapid Fire Revolution Dazz", 104.90);
		Produto produto62 = new Produto(null, "Teclado Gamer Membrana Redragon Karura 2 RGB ABNT2 Preto - K502RGB, UNICO", 202.44);
		Produto produto63 = new Produto(null, "Teclado Mecânico Motospeed CK95 Preto Switch Vermelho", 184.00);
		Produto produto64 = new Produto(null, "Teclado Mecânico Gamer Redragon Dark Avenger Switch Outemu Brown Rgb Abnt2 - K568Rgb-1 (Brown)", 315.70);
		Produto produto65 = new Produto(null, "Teclado Mecânico Gamer Redragon Mitra Switch Brown com fio", 368.80);
		Produto produto66 = new Produto(null, "Teclado Gamer Mecânico Redragon Kumara Switch Outemu Red ABNT2 - K552", 349.00);
		Produto produto67 = new Produto(null, "HyperX Teclado Gamer HyperX Alloy Core RGB, ABNT2", 322.91);
		Produto produto68 = new Produto(null, "Teclado Mecânico Motospeed CK62 Bluetooth Gamer Branco Switch Azul RGB", 329.00);
		Produto produto69 = new Produto(null, "Teclado Mecânico Gamer HyperX Alloy FPS PRO LED VERM MX RED HX-KB4RD1-US/R2", 168.80);
		Produto produto70 = new Produto(null, "Teclado Corsair K70 RGB MK.2 RAPIDFIRE Ch. MX Portugues", 499.50);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6,
				produto7, produto8, produto9, produto10));
		categoria2.getProdutos().addAll(Arrays.asList(produto11, produto12, produto13, produto14, produto15, produto16,
				produto17, produto18, produto19, produto20));
		categoria3.getProdutos().addAll(Arrays.asList(produto21, produto22, produto23, produto24, produto25, produto26,
				produto27, produto28, produto29, produto30));
		categoria4.getProdutos().addAll(Arrays.asList(produto31, produto32, produto33, produto34, produto35, produto36,
				produto37, produto38, produto39, produto40));
		categoria5.getProdutos().addAll(Arrays.asList(produto41, produto42, produto43, produto44, produto45, produto46,
				produto47, produto48, produto49, produto50));
		categoria6.getProdutos().addAll(Arrays.asList(produto51, produto52, produto53, produto54, produto55, produto56,
				produto57, produto58, produto59, produto60));
		categoria6.getProdutos().addAll(Arrays.asList(produto61, produto62, produto63, produto64, produto65, produto66,
				produto67, produto68, produto69, produto70));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		produto4.getCategorias().addAll(Arrays.asList(categoria1));
		produto5.getCategorias().addAll(Arrays.asList(categoria1));
		produto6.getCategorias().addAll(Arrays.asList(categoria1));
		produto7.getCategorias().addAll(Arrays.asList(categoria1));
		produto8.getCategorias().addAll(Arrays.asList(categoria1));
		produto9.getCategorias().addAll(Arrays.asList(categoria1));
		produto10.getCategorias().addAll(Arrays.asList(categoria1));

		produto11.getCategorias().addAll(Arrays.asList(categoria2));
		produto12.getCategorias().addAll(Arrays.asList(categoria2));
		produto13.getCategorias().addAll(Arrays.asList(categoria2));
		produto14.getCategorias().addAll(Arrays.asList(categoria2));
		produto15.getCategorias().addAll(Arrays.asList(categoria2));
		produto16.getCategorias().addAll(Arrays.asList(categoria2));
		produto17.getCategorias().addAll(Arrays.asList(categoria2));
		produto18.getCategorias().addAll(Arrays.asList(categoria2));
		produto19.getCategorias().addAll(Arrays.asList(categoria2));
		produto20.getCategorias().addAll(Arrays.asList(categoria2));

		produto21.getCategorias().addAll(Arrays.asList(categoria3));
		produto22.getCategorias().addAll(Arrays.asList(categoria3));
		produto23.getCategorias().addAll(Arrays.asList(categoria3));
		produto24.getCategorias().addAll(Arrays.asList(categoria3));
		produto25.getCategorias().addAll(Arrays.asList(categoria3));
		produto26.getCategorias().addAll(Arrays.asList(categoria3));
		produto27.getCategorias().addAll(Arrays.asList(categoria3));
		produto28.getCategorias().addAll(Arrays.asList(categoria3));
		produto29.getCategorias().addAll(Arrays.asList(categoria3));
		produto30.getCategorias().addAll(Arrays.asList(categoria3));

		produto31.getCategorias().addAll(Arrays.asList(categoria4));
		produto32.getCategorias().addAll(Arrays.asList(categoria4));
		produto33.getCategorias().addAll(Arrays.asList(categoria4));
		produto34.getCategorias().addAll(Arrays.asList(categoria4));
		produto35.getCategorias().addAll(Arrays.asList(categoria4));
		produto36.getCategorias().addAll(Arrays.asList(categoria4));
		produto37.getCategorias().addAll(Arrays.asList(categoria4));
		produto38.getCategorias().addAll(Arrays.asList(categoria4));
		produto39.getCategorias().addAll(Arrays.asList(categoria4));
		produto40.getCategorias().addAll(Arrays.asList(categoria4));

		produto41.getCategorias().addAll(Arrays.asList(categoria5));
		produto42.getCategorias().addAll(Arrays.asList(categoria5));
		produto43.getCategorias().addAll(Arrays.asList(categoria5));
		produto44.getCategorias().addAll(Arrays.asList(categoria5));
		produto45.getCategorias().addAll(Arrays.asList(categoria5));
		produto46.getCategorias().addAll(Arrays.asList(categoria5));
		produto47.getCategorias().addAll(Arrays.asList(categoria5));
		produto48.getCategorias().addAll(Arrays.asList(categoria5));
		produto49.getCategorias().addAll(Arrays.asList(categoria5));
		produto50.getCategorias().addAll(Arrays.asList(categoria5));

		produto51.getCategorias().addAll(Arrays.asList(categoria6));
		produto52.getCategorias().addAll(Arrays.asList(categoria6));
		produto53.getCategorias().addAll(Arrays.asList(categoria6));
		produto54.getCategorias().addAll(Arrays.asList(categoria6));
		produto55.getCategorias().addAll(Arrays.asList(categoria6));
		produto56.getCategorias().addAll(Arrays.asList(categoria6));
		produto57.getCategorias().addAll(Arrays.asList(categoria6));
		produto58.getCategorias().addAll(Arrays.asList(categoria6));
		produto59.getCategorias().addAll(Arrays.asList(categoria6));
		produto60.getCategorias().addAll(Arrays.asList(categoria6));

		produto61.getCategorias().addAll(Arrays.asList(categoria7));
		produto62.getCategorias().addAll(Arrays.asList(categoria7));
		produto63.getCategorias().addAll(Arrays.asList(categoria7));
		produto64.getCategorias().addAll(Arrays.asList(categoria7));
		produto65.getCategorias().addAll(Arrays.asList(categoria7));
		produto66.getCategorias().addAll(Arrays.asList(categoria7));
		produto67.getCategorias().addAll(Arrays.asList(categoria7));
		produto68.getCategorias().addAll(Arrays.asList(categoria7));
		produto69.getCategorias().addAll(Arrays.asList(categoria7));
		produto70.getCategorias().addAll(Arrays.asList(categoria7));

		categoriaRepository.saveAll(
				Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5, categoria6, categoria7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10, produto11, produto12, produto13, produto14, produto15, produto16,
				produto17, produto18, produto19, produto20, produto21, produto22, produto23, produto24, produto25,
				produto26, produto27, produto28, produto29, produto30, produto31, produto32, produto33, produto34,
				produto35, produto36, produto37, produto38, produto39, produto40, produto41, produto42, produto43,
				produto44, produto45, produto46, produto47, produto48, produto49, produto50, produto51, produto52,
				produto53, produto54, produto55, produto56, produto57, produto58, produto59, produto60, produto61,
				produto62, produto63, produto64, produto65, produto66, produto67, produto68, produto69, produto70));

		
		Estado est11 = new Estado(null, "Minas Gerais");
		
		Cidade cid1346 = new Cidade(null, "Abadia Dos Dourados", est11);
		Cidade cid1347 = new Cidade(null, "Abaesté", est11);
		Cidade cid1348 = new Cidade(null, "Abre Campo", est11);
		Cidade cid1349 = new Cidade(null, "Acaiaca", est11);
		Cidade cid1350 = new Cidade(null, "Açucena", est11);
		Cidade cid1351 = new Cidade(null, "Água Boa", est11);
		Cidade cid1352 = new Cidade(null, "Água Comprida", est11);
		Cidade cid1353 = new Cidade(null, "Aguanil", est11);
		Cidade cid1354 = new Cidade(null, "Águas Formosas", est11);
		Cidade cid1355 = new Cidade(null, "Águas Vermelhas", est11);
		Cidade cid1356 = new Cidade(null, "Aimorés", est11);
		Cidade cid1357 = new Cidade(null, "Aiuruoca", est11);
		Cidade cid1358 = new Cidade(null, "Alagoa", est11);
		Cidade cid1359 = new Cidade(null, "Albertina", est11);
		Cidade cid1360 = new Cidade(null, "Além Paraíba", est11);
		Cidade cid1361 = new Cidade(null, "Alfenas", est11);
		Cidade cid1362 = new Cidade(null, "Alfredo Vasconcelos", est11);
		Cidade cid1363 = new Cidade(null, "Almenara", est11);
		Cidade cid1364 = new Cidade(null, "Alpercata", est11);
		Cidade cid1365 = new Cidade(null, "Alpinópolis", est11);
		Cidade cid1366 = new Cidade(null, "Alterosa", est11);
		Cidade cid1367 = new Cidade(null, "Alto Caparaó", est11);
		Cidade cid1368 = new Cidade(null, "Alto Rio Doce", est11);
		Cidade cid1369 = new Cidade(null, "Alvarenga", est11);
		Cidade cid1370 = new Cidade(null, "Alvinópolis", est11);
		Cidade cid1371 = new Cidade(null, "Alvorada de Minas", est11);
		Cidade cid1372 = new Cidade(null, "Amparo do Serra", est11);
		Cidade cid1373 = new Cidade(null, "Andradas", est11);
		Cidade cid1374 = new Cidade(null, "Cachoeira de Pajeú", est11);
		Cidade cid1375 = new Cidade(null, "Andrelândia", est11);
		Cidade cid1376 = new Cidade(null, "Angelândia", est11);
		Cidade cid1377 = new Cidade(null, "Antônio Carlos", est11);
		Cidade cid1378 = new Cidade(null, "Antônio Dias", est11);
		Cidade cid1379 = new Cidade(null, "Antônio Prado de Minas", est11);
		Cidade cid1380 = new Cidade(null, "Araçaí", est11);
		Cidade cid1381 = new Cidade(null, "Aracitaba", est11);
		Cidade cid1382 = new Cidade(null, "Araçuaí", est11);
		Cidade cid1383 = new Cidade(null, "Araguari", est11);
		Cidade cid1384 = new Cidade(null, "Arantina", est11);
		Cidade cid1385 = new Cidade(null, "Araponga", est11);
		Cidade cid1386 = new Cidade(null, "Araporã", est11);
		Cidade cid1387 = new Cidade(null, "Arapuá", est11);
		Cidade cid1388 = new Cidade(null, "Araújos", est11);
		Cidade cid1389 = new Cidade(null, "Araxá", est11);
		Cidade cid1390 = new Cidade(null, "Arceburgo", est11);
		Cidade cid1391 = new Cidade(null, "Arcos", est11);
		Cidade cid1392 = new Cidade(null, "Areado", est11);
		Cidade cid1393 = new Cidade(null, "Argirita", est11);
		Cidade cid1394 = new Cidade(null, "Aricanduva", est11);
		Cidade cid1395 = new Cidade(null, "Arinos", est11);
		Cidade cid1396 = new Cidade(null, "Astolfo Dutra", est11);
		Cidade cid1397 = new Cidade(null, "Ataléia", est11);
		Cidade cid1398 = new Cidade(null, "Augusto de Lima", est11);
		Cidade cid1399 = new Cidade(null, "Baependi", est11);
		Cidade cid1400 = new Cidade(null, "Baldim", est11);
		Cidade cid1401 = new Cidade(null, "Bambuí", est11);
		Cidade cid1402 = new Cidade(null, "Bandeira", est11);
		Cidade cid1403 = new Cidade(null, "Bandeira do Sul", est11);
		Cidade cid1404 = new Cidade(null, "Barão de Cocais", est11);
		Cidade cid1405 = new Cidade(null, "Barão de Monte Alto", est11);
		Cidade cid1406 = new Cidade(null, "Barbacena", est11);
		Cidade cid1407 = new Cidade(null, "Barra Longa", est11);
		Cidade cid1408 = new Cidade(null, "Barroso", est11);
		Cidade cid1409 = new Cidade(null, "Bela Vista de Minas", est11);
		Cidade cid1410 = new Cidade(null, "Belmiro Braga", est11);
		Cidade cid1411 = new Cidade(null, "Belo Horizonte", est11);
		Cidade cid1412 = new Cidade(null, "Belo Oriente", est11);
		Cidade cid1413 = new Cidade(null, "Belo Vale", est11);
		Cidade cid1414 = new Cidade(null, "Berilo", est11);
		Cidade cid1415 = new Cidade(null, "Bertópolis", est11);
		Cidade cid1416 = new Cidade(null, "Berizal", est11);
		Cidade cid1417 = new Cidade(null, "Bestim", est11);
		Cidade cid1418 = new Cidade(null, "Bias Fortes", est11);
		Cidade cid1419 = new Cidade(null, "Bicas", est11);
		Cidade cid1420 = new Cidade(null, "Biquinhas", est11);
		Cidade cid1421 = new Cidade(null, "Boa Esperança", est11);
		Cidade cid1422 = new Cidade(null, "Bocaina de Minas", est11);
		Cidade cid1423 = new Cidade(null, "Bocaiúva", est11);
		Cidade cid1424 = new Cidade(null, "Bom Despacho", est11);
		Cidade cid1425 = new Cidade(null, "Bom Jardim de Minas", est11);
		Cidade cid1426 = new Cidade(null, "Bom Jesus da Penha", est11);
		Cidade cid1427 = new Cidade(null, "Bom Jesus do Amparo", est11);
		Cidade cid1428 = new Cidade(null, "Bom Jesus do Galho", est11);
		Cidade cid1429 = new Cidade(null, "Bom Repouso", est11);
		Cidade cid1430 = new Cidade(null, "Bom Sucesso", est11);
		Cidade cid1431 = new Cidade(null, "Bonfim", est11);
		Cidade cid1432 = new Cidade(null, "Bonfinópolis de Minas", est11);
		Cidade cid1433 = new Cidade(null, "Bonito de Minas", est11);
		Cidade cid1434 = new Cidade(null, "Borda da Mata", est11);
		Cidade cid1435 = new Cidade(null, "Botelhos", est11);
		Cidade cid1436 = new Cidade(null, "Botumirim", est11);
		Cidade cid1437 = new Cidade(null, "Brasilândia de Minas", est11);
		Cidade cid1438 = new Cidade(null, "Brasília de Minas", est11);
		Cidade cid1439 = new Cidade(null, "Brás Pires", est11);
		Cidade cid1440 = new Cidade(null, "Braúnas", est11);
		Cidade cid1441 = new Cidade(null, "Brasópolis", est11);
		Cidade cid1442 = new Cidade(null, "Brumadinho", est11);
		Cidade cid1443 = new Cidade(null, "Bueno Brandão", est11);
		Cidade cid1444 = new Cidade(null, "Buenópolis", est11);
		Cidade cid1445 = new Cidade(null, "Bugre", est11);
		Cidade cid1446 = new Cidade(null, "Buritis", est11);
		Cidade cid1447 = new Cidade(null, "Buritizeiro", est11);
		Cidade cid1448 = new Cidade(null, "Cabeceira Grande", est11);
		Cidade cid1449 = new Cidade(null, "Cabo Verde", est11);
		Cidade cid1450 = new Cidade(null, "Cachoeira da Prata", est11);
		Cidade cid1451 = new Cidade(null, "Cachoeira de Minas", est11);
		Cidade cid1452 = new Cidade(null, "Cachoeira Dourada", est11);
		Cidade cid1453 = new Cidade(null, "Caestanópolis", est11);
		Cidade cid1454 = new Cidade(null, "Caesté", est11);
		Cidade cid1455 = new Cidade(null, "Caiana", est11);
		Cidade cid1456 = new Cidade(null, "Cajuri", est11);
		Cidade cid1457 = new Cidade(null, "Caldas", est11);
		Cidade cid1458 = new Cidade(null, "Camacho", est11);
		Cidade cid1459 = new Cidade(null, "Camanducaia", est11);
		Cidade cid1460 = new Cidade(null, "Cambuí", est11);
		Cidade cid1461 = new Cidade(null, "Cambuquira", est11);
		Cidade cid1462 = new Cidade(null, "Campanário", est11);
		Cidade cid1463 = new Cidade(null, "Campanha", est11);
		Cidade cid1464 = new Cidade(null, "Campestre", est11);
		Cidade cid1465 = new Cidade(null, "Campina Verde", est11);
		Cidade cid1466 = new Cidade(null, "Campo Azul", est11);
		Cidade cid1467 = new Cidade(null, "Campo Belo", est11);
		Cidade cid1468 = new Cidade(null, "Campo do Meio", est11);
		Cidade cid1469 = new Cidade(null, "Campo Florido", est11);
		Cidade cid1470 = new Cidade(null, "Campos Altos", est11);
		Cidade cid1471 = new Cidade(null, "Campos Gerais", est11);
		Cidade cid1472 = new Cidade(null, "Canaã", est11);
		Cidade cid1473 = new Cidade(null, "Canápolis", est11);
		Cidade cid1474 = new Cidade(null, "Cana Verde", est11);
		Cidade cid1475 = new Cidade(null, "Candeias", est11);
		Cidade cid1476 = new Cidade(null, "Cantagalo", est11);
		Cidade cid1477 = new Cidade(null, "Caparaó", est11);
		Cidade cid1478 = new Cidade(null, "Capela Nova", est11);
		Cidade cid1479 = new Cidade(null, "Capelinha", est11);
		Cidade cid1480 = new Cidade(null, "Capestinga", est11);
		Cidade cid1481 = new Cidade(null, "Capim Branco", est11);
		Cidade cid1482 = new Cidade(null, "Capinópolis", est11);
		Cidade cid1483 = new Cidade(null, "Capitão Andrade", est11);
		Cidade cid1484 = new Cidade(null, "Capitão Enéas", est11);
		Cidade cid1485 = new Cidade(null, "Capitólio", est11);
		Cidade cid1486 = new Cidade(null, "Caputira", est11);
		Cidade cid1487 = new Cidade(null, "Caraí", est11);
		Cidade cid1488 = new Cidade(null, "Caranaíba", est11);
		Cidade cid1489 = new Cidade(null, "Carandaí", est11);
		Cidade cid1490 = new Cidade(null, "Carangola", est11);
		Cidade cid1491 = new Cidade(null, "Caratinga", est11);
		Cidade cid1492 = new Cidade(null, "Carbonita", est11);
		Cidade cid1493 = new Cidade(null, "Careaçu", est11);
		Cidade cid1494 = new Cidade(null, "Carlos Chagas", est11);
		Cidade cid1495 = new Cidade(null, "Carmésia", est11);
		Cidade cid1496 = new Cidade(null, "Carmo da Cachoeira", est11);
		Cidade cid1497 = new Cidade(null, "Carmo da Mata", est11);
		Cidade cid1498 = new Cidade(null, "Carmo de Minas", est11);
		Cidade cid1499 = new Cidade(null, "Carmo do Cajuru", est11);
		Cidade cid1500 = new Cidade(null, "Carmo do Paranaíba", est11);
		Cidade cid1501 = new Cidade(null, "Carmo do Rio Claro", est11);
		Cidade cid1502 = new Cidade(null, "Carmópolis de Minas", est11);
		Cidade cid1503 = new Cidade(null, "Carneirinho", est11);
		Cidade cid1504 = new Cidade(null, "Carrancas", est11);
		Cidade cid1505 = new Cidade(null, "Carvalhópolis", est11);
		Cidade cid1506 = new Cidade(null, "Carvalhos", est11);
		Cidade cid1507 = new Cidade(null, "Casa Grande", est11);
		Cidade cid1508 = new Cidade(null, "Cascalho Rico", est11);
		Cidade cid1509 = new Cidade(null, "Cássia", est11);
		Cidade cid1510 = new Cidade(null, "Conceição da Barra de Minas", est11);
		Cidade cid1511 = new Cidade(null, "Cataguases", est11);
		Cidade cid1512 = new Cidade(null, "Catas Altas", est11);
		Cidade cid1513 = new Cidade(null, "Catas Altas da Noruega", est11);
		Cidade cid1514 = new Cidade(null, "Catuji", est11);
		Cidade cid1515 = new Cidade(null, "Catuti", est11);
		Cidade cid1516 = new Cidade(null, "Caxambu", est11);
		Cidade cid1517 = new Cidade(null, "Cedro do Abaesté", est11);
		Cidade cid1518 = new Cidade(null, "Central de Minas", est11);
		Cidade cid1519 = new Cidade(null, "Centralina", est11);
		Cidade cid1520 = new Cidade(null, "Chácara", est11);
		Cidade cid1521 = new Cidade(null, "Chalé", est11);
		Cidade cid1522 = new Cidade(null, "Chapada do Norte", est11);
		Cidade cid1523 = new Cidade(null, "Chapada Gaúcha", est11);
		Cidade cid1524 = new Cidade(null, "Chiador", est11);
		Cidade cid1525 = new Cidade(null, "Cipotânea", est11);
		Cidade cid1526 = new Cidade(null, "Claraval", est11);
		Cidade cid1527 = new Cidade(null, "Claro Dos Poções", est11);
		Cidade cid1528 = new Cidade(null, "Cláudio", est11);
		Cidade cid1529 = new Cidade(null, "Coimbra", est11);
		Cidade cid1530 = new Cidade(null, "Coluna", est11);
		Cidade cid1531 = new Cidade(null, "Comendador Gomes", est11);
		Cidade cid1532 = new Cidade(null, "Comercinho", est11);
		Cidade cid1533 = new Cidade(null, "Conceição da Aparecida", est11);
		Cidade cid1534 = new Cidade(null, "Conceição Das Pedras", est11);
		Cidade cid1535 = new Cidade(null, "Conceição Das Alagoas", est11);
		Cidade cid1536 = new Cidade(null, "Conceição de Ipanema", est11);
		Cidade cid1537 = new Cidade(null, "Conceição do Mato Dentro", est11);
		Cidade cid1538 = new Cidade(null, "Conceição do Pará", est11);
		Cidade cid1539 = new Cidade(null, "Conceição do Rio Verde", est11);
		Cidade cid1540 = new Cidade(null, "Conceição Dos Ouros", est11);
		Cidade cid1541 = new Cidade(null, "Cônego Marinho", est11);
		Cidade cid1542 = new Cidade(null, "Confins", est11);
		Cidade cid1543 = new Cidade(null, "Congonhal", est11);
		Cidade cid1544 = new Cidade(null, "Congonhas", est11);
		Cidade cid1545 = new Cidade(null, "Congonhas do Norte", est11);
		Cidade cid1546 = new Cidade(null, "Conquista", est11);
		Cidade cid1547 = new Cidade(null, "Conselheiro Lafaieste", est11);
		Cidade cid1548 = new Cidade(null, "Conselheiro Pena", est11);
		Cidade cid1549 = new Cidade(null, "Consolação", est11);
		Cidade cid1550 = new Cidade(null, "Contagem", est11);
		Cidade cid1551 = new Cidade(null, "Coqueiral", est11);
		Cidade cid1552 = new Cidade(null, "Coração de Jesus", est11);
		Cidade cid1553 = new Cidade(null, "Cordisburgo", est11);
		Cidade cid1554 = new Cidade(null, "Cordislândia", est11);
		Cidade cid1555 = new Cidade(null, "Corinto", est11);
		Cidade cid1556 = new Cidade(null, "Coroaci", est11);
		Cidade cid1557 = new Cidade(null, "Coromandel", est11);
		Cidade cid1558 = new Cidade(null, "Coronel Fabriciano", est11);
		Cidade cid1559 = new Cidade(null, "Coronel Murta", est11);
		Cidade cid1560 = new Cidade(null, "Coronel Pacheco", est11);
		Cidade cid1561 = new Cidade(null, "Coronel Xavier Chaves", est11);
		Cidade cid1562 = new Cidade(null, "Córrego Danta", est11);
		Cidade cid1563 = new Cidade(null, "Córrego do Bom Jesus", est11);
		Cidade cid1564 = new Cidade(null, "Córrego Fundo", est11);
		Cidade cid1565 = new Cidade(null, "Córrego Novo", est11);
		Cidade cid1566 = new Cidade(null, "Couto de Magalhães de Minas", est11);
		Cidade cid1567 = new Cidade(null, "Crisólita", est11);
		Cidade cid1568 = new Cidade(null, "Cristais", est11);
		Cidade cid1569 = new Cidade(null, "Cristália", est11);
		Cidade cid1570 = new Cidade(null, "Cristiano Otoni", est11);
		Cidade cid1571 = new Cidade(null, "Cristina", est11);
		Cidade cid1572 = new Cidade(null, "Crucilândia", est11);
		Cidade cid1573 = new Cidade(null, "Cruzeiro da Fortaleza", est11);
		Cidade cid1574 = new Cidade(null, "Cruzília", est11);
		Cidade cid1575 = new Cidade(null, "Cuparaque", est11);
		Cidade cid1576 = new Cidade(null, "Curral de Dentro", est11);
		Cidade cid1577 = new Cidade(null, "Curvelo", est11);
		Cidade cid1578 = new Cidade(null, "Datas", est11);
		Cidade cid1579 = new Cidade(null, "Delfim Moreira", est11);
		Cidade cid1580 = new Cidade(null, "Delfinópolis", est11);
		Cidade cid1581 = new Cidade(null, "Delta", est11);
		Cidade cid1582 = new Cidade(null, "Descoberto", est11);
		Cidade cid1583 = new Cidade(null, "Desterro de Entre Rios", est11);
		Cidade cid1584 = new Cidade(null, "Desterro do Melo", est11);
		Cidade cid1585 = new Cidade(null, "Diamantina", est11);
		Cidade cid1586 = new Cidade(null, "Diogo de Vasconcelos", est11);
		Cidade cid1587 = new Cidade(null, "Dionísio", est11);
		Cidade cid1588 = new Cidade(null, "Divinésia", est11);
		Cidade cid1589 = new Cidade(null, "Divino", est11);
		Cidade cid1590 = new Cidade(null, "Divino Das Laranjeiras", est11);
		Cidade cid1591 = new Cidade(null, "Divinolândia de Minas", est11);
		Cidade cid1592 = new Cidade(null, "Divinópolis", est11);
		Cidade cid1593 = new Cidade(null, "Divisa Alegre", est11);
		Cidade cid1594 = new Cidade(null, "Divisa Nova", est11);
		Cidade cid1595 = new Cidade(null, "Divisópolis", est11);
		Cidade cid1596 = new Cidade(null, "Dom Bosco", est11);
		Cidade cid1597 = new Cidade(null, "Dom Cavati", est11);
		Cidade cid1598 = new Cidade(null, "Dom Joaquim", est11);
		Cidade cid1599 = new Cidade(null, "Dom Silvério", est11);
		Cidade cid1600 = new Cidade(null, "Dom Viçoso", est11);
		Cidade cid1601 = new Cidade(null, "Dona Eusébia", est11);
		Cidade cid1602 = new Cidade(null, "Dores de Campos", est11);
		Cidade cid1603 = new Cidade(null, "Dores de Guanhães", est11);
		Cidade cid1604 = new Cidade(null, "Dores do Indaiá", est11);
		Cidade cid1605 = new Cidade(null, "Dores do Turvo", est11);
		Cidade cid1606 = new Cidade(null, "Doresópolis", est11);
		Cidade cid1607 = new Cidade(null, "Douradoquara", est11);
		Cidade cid1608 = new Cidade(null, "Durandé", est11);
		Cidade cid1609 = new Cidade(null, "Elói Mendes", est11);
		Cidade cid1610 = new Cidade(null, "Engenheiro Caldas", est11);
		Cidade cid1611 = new Cidade(null, "Engenheiro Navarro", est11);
		Cidade cid1612 = new Cidade(null, "Entre Folhas", est11);
		Cidade cid1613 = new Cidade(null, "Entre Rios de Minas", est11);
		Cidade cid1614 = new Cidade(null, "Ervália", est11);
		Cidade cid1615 = new Cidade(null, "Esmeraldas", est11);
		Cidade cid1616 = new Cidade(null, "Espera Feliz", est11);
		Cidade cid1617 = new Cidade(null, "Espinosa", est11);
		Cidade cid1618 = new Cidade(null, "Espírito Santo do Dourado", est11);
		Cidade cid1619 = new Cidade(null, "Estiva", est11);
		Cidade cid1620 = new Cidade(null, "Estrela Dalva", est11);
		Cidade cid1621 = new Cidade(null, "Estrela do Indaiá", est11);
		Cidade cid1622 = new Cidade(null, "Estrela do Sul", est11);
		Cidade cid1623 = new Cidade(null, "Eugenópolis", est11);
		Cidade cid1624 = new Cidade(null, "Ewbank da Câmara", est11);
		Cidade cid1625 = new Cidade(null, "Extrema", est11);
		Cidade cid1626 = new Cidade(null, "Fama", est11);
		Cidade cid1627 = new Cidade(null, "Faria Lemos", est11);
		Cidade cid1628 = new Cidade(null, "Felício Dos Santos", est11);
		Cidade cid1629 = new Cidade(null, "São Gonçalo do Rio Presto", est11);
		Cidade cid1630 = new Cidade(null, "Felisburgo", est11);
		Cidade cid1631 = new Cidade(null, "Felixlândia", est11);
		Cidade cid1632 = new Cidade(null, "Fernandes Tourinho", est11);
		Cidade cid1633 = new Cidade(null, "Ferros", est11);
		Cidade cid1634 = new Cidade(null, "Fervedouro", est11);
		Cidade cid1635 = new Cidade(null, "Florestal", est11);
		Cidade cid1636 = new Cidade(null, "Formiga", est11);
		Cidade cid1637 = new Cidade(null, "Formoso", est11);
		Cidade cid1638 = new Cidade(null, "Fortaleza de Minas", est11);
		Cidade cid1639 = new Cidade(null, "Fortuna de Minas", est11);
		Cidade cid1640 = new Cidade(null, "Francisco Badaró", est11);
		Cidade cid1641 = new Cidade(null, "Francisco Dumont", est11);
		Cidade cid1642 = new Cidade(null, "Francisco sá", est11);
		Cidade cid1643 = new Cidade(null, "Franciscópolis", est11);
		Cidade cid1644 = new Cidade(null, "Frei Gaspar", est11);
		Cidade cid1645 = new Cidade(null, "Frei Inocêncio", est11);
		Cidade cid1646 = new Cidade(null, "Frei Lagonegro", est11);
		Cidade cid1647 = new Cidade(null, "Fronteira", est11);
		Cidade cid1648 = new Cidade(null, "Fronteira Dos Vales", est11);
		Cidade cid1649 = new Cidade(null, "Fruta de Leite", est11);
		Cidade cid1650 = new Cidade(null, "Frutal", est11);
		Cidade cid1651 = new Cidade(null, "Funilândia", est11);
		Cidade cid1652 = new Cidade(null, "Galiléia", est11);
		Cidade cid1653 = new Cidade(null, "Gameleiras", est11);
		Cidade cid1654 = new Cidade(null, "Glaucilândia", est11);
		Cidade cid1655 = new Cidade(null, "Goiabeira", est11);
		Cidade cid1656 = new Cidade(null, "Goianá", est11);
		Cidade cid1657 = new Cidade(null, "Gonçalves", est11);
		Cidade cid1658 = new Cidade(null, "Gonzaga", est11);
		Cidade cid1659 = new Cidade(null, "Gouveia", est11);
		Cidade cid1660 = new Cidade(null, "Governador Valadares", est11);
		Cidade cid1661 = new Cidade(null, "Grão Mogol", est11);
		Cidade cid1662 = new Cidade(null, "Grupiara", est11);
		Cidade cid1663 = new Cidade(null, "Guanhães", est11);
		Cidade cid1664 = new Cidade(null, "Guapé", est11);
		Cidade cid1665 = new Cidade(null, "Guaraciaba", est11);
		Cidade cid1666 = new Cidade(null, "Guaraciama", est11);
		Cidade cid1667 = new Cidade(null, "Guaranésia", est11);
		Cidade cid1668 = new Cidade(null, "Guarani", est11);
		Cidade cid1669 = new Cidade(null, "Guarará", est11);
		Cidade cid1670 = new Cidade(null, "Guarda-mor", est11);
		Cidade cid1671 = new Cidade(null, "Guaxupé", est11);
		Cidade cid1672 = new Cidade(null, "Guidoval", est11);
		Cidade cid1673 = new Cidade(null, "Guimarânia", est11);
		Cidade cid1674 = new Cidade(null, "Guiricema", est11);
		Cidade cid1675 = new Cidade(null, "Gurinhatã", est11);
		Cidade cid1676 = new Cidade(null, "Heliodora", est11);
		Cidade cid1677 = new Cidade(null, "Iapu", est11);
		Cidade cid1678 = new Cidade(null, "Ibertioga", est11);
		Cidade cid1679 = new Cidade(null, "Ibiá", est11);
		Cidade cid1680 = new Cidade(null, "Ibiaí", est11);
		Cidade cid1681 = new Cidade(null, "Ibiracatu", est11);
		Cidade cid1682 = new Cidade(null, "Ibiraci", est11);
		Cidade cid1683 = new Cidade(null, "Ibirité", est11);
		Cidade cid1684 = new Cidade(null, "Ibitiúra de Minas", est11);
		Cidade cid1685 = new Cidade(null, "Ibituruna", est11);
		Cidade cid1686 = new Cidade(null, "Icaraí de Minas", est11);
		Cidade cid1687 = new Cidade(null, "Igarapé", est11);
		Cidade cid1688 = new Cidade(null, "Igaratinga", est11);
		Cidade cid1689 = new Cidade(null, "Iguatama", est11);
		Cidade cid1690 = new Cidade(null, "Ijaci", est11);
		Cidade cid1691 = new Cidade(null, "Ilicínea", est11);
		Cidade cid1692 = new Cidade(null, "Imbé de Minas", est11);
		Cidade cid1693 = new Cidade(null, "Inconfidentes", est11);
		Cidade cid1694 = new Cidade(null, "Indaiabira", est11);
		Cidade cid1695 = new Cidade(null, "Indianópolis", est11);
		Cidade cid1696 = new Cidade(null, "Ingaí", est11);
		Cidade cid1697 = new Cidade(null, "Inhapim", est11);
		Cidade cid1698 = new Cidade(null, "Inhaúma", est11);
		Cidade cid1699 = new Cidade(null, "Inimutaba", est11);
		Cidade cid1700 = new Cidade(null, "Ipaba", est11);
		Cidade cid1701 = new Cidade(null, "Ipanema", est11);
		Cidade cid1702 = new Cidade(null, "Ipatinga", est11);
		Cidade cid1703 = new Cidade(null, "Ipiaçu", est11);
		Cidade cid1704 = new Cidade(null, "Ipuiúna", est11);
		Cidade cid1705 = new Cidade(null, "Iraí de Minas", est11);
		Cidade cid1706 = new Cidade(null, "Itabira", est11);
		Cidade cid1707 = new Cidade(null, "Itabirinha", est11);
		Cidade cid1708 = new Cidade(null, "Itabirito", est11);
		Cidade cid1709 = new Cidade(null, "Itacambira", est11);
		Cidade cid1710 = new Cidade(null, "Itacarambi", est11);
		Cidade cid1711 = new Cidade(null, "Itaguara", est11);
		Cidade cid1712 = new Cidade(null, "Itaipé", est11);
		Cidade cid1713 = new Cidade(null, "Itajubá", est11);
		Cidade cid1714 = new Cidade(null, "Itamarandiba", est11);
		Cidade cid1715 = new Cidade(null, "Itamarati de Minas", est11);
		Cidade cid1716 = new Cidade(null, "Itambacuri", est11);
		Cidade cid1717 = new Cidade(null, "Itambé do Mato Dentro", est11);
		Cidade cid1718 = new Cidade(null, "Itamogi", est11);
		Cidade cid1719 = new Cidade(null, "Itamonte", est11);
		Cidade cid1720 = new Cidade(null, "Itanhandu", est11);
		Cidade cid1721 = new Cidade(null, "Itanhomi", est11);
		Cidade cid1722 = new Cidade(null, "Itaobim", est11);
		Cidade cid1723 = new Cidade(null, "Itapagipe", est11);
		Cidade cid1724 = new Cidade(null, "Itapecerica", est11);
		Cidade cid1725 = new Cidade(null, "Itapeva", est11);
		Cidade cid1726 = new Cidade(null, "Itatiaiuçu", est11);
		Cidade cid1727 = new Cidade(null, "Itaú de Minas", est11);
		Cidade cid1728 = new Cidade(null, "Itaúna", est11);
		Cidade cid1729 = new Cidade(null, "Itaverava", est11);
		Cidade cid1730 = new Cidade(null, "Itinga", est11);
		Cidade cid1731 = new Cidade(null, "Ituesta", est11);
		Cidade cid1732 = new Cidade(null, "Ituiutaba", est11);
		Cidade cid1733 = new Cidade(null, "Itumirim", est11);
		Cidade cid1734 = new Cidade(null, "Iturama", est11);
		Cidade cid1735 = new Cidade(null, "Itutinga", est11);
		Cidade cid1736 = new Cidade(null, "Jaboticatubas", est11);
		Cidade cid1737 = new Cidade(null, "Jacinto", est11);
		Cidade cid1738 = new Cidade(null, "Jacuí", est11);
		Cidade cid1739 = new Cidade(null, "Jacutinga", est11);
		Cidade cid1740 = new Cidade(null, "Jaguaraçu", est11);
		Cidade cid1741 = new Cidade(null, "Jaíba", est11);
		Cidade cid1742 = new Cidade(null, "Jampruca", est11);
		Cidade cid1743 = new Cidade(null, "Janaúba", est11);
		Cidade cid1744 = new Cidade(null, "Januária", est11);
		Cidade cid1745 = new Cidade(null, "Japaraíba", est11);
		Cidade cid1746 = new Cidade(null, "Japonvar", est11);
		Cidade cid1747 = new Cidade(null, "Jeceaba", est11);
		Cidade cid1748 = new Cidade(null, "Jenipapo de Minas", est11);
		Cidade cid1749 = new Cidade(null, "Jequeri", est11);
		Cidade cid1750 = new Cidade(null, "Jequitaí", est11);
		Cidade cid1751 = new Cidade(null, "Jequitibá", est11);
		Cidade cid1752 = new Cidade(null, "Jequitinhonha", est11);
		Cidade cid1753 = new Cidade(null, "Jesuânia", est11);
		Cidade cid1754 = new Cidade(null, "Joaíma", est11);
		Cidade cid1755 = new Cidade(null, "Joanésia", est11);
		Cidade cid1756 = new Cidade(null, "João Monlevade", est11);
		Cidade cid1757 = new Cidade(null, "João Pinheiro", est11);
		Cidade cid1758 = new Cidade(null, "Joaquim Felício", est11);
		Cidade cid1759 = new Cidade(null, "Jordânia", est11);
		Cidade cid1760 = new Cidade(null, "José Gonçalves de Minas", est11);
		Cidade cid1761 = new Cidade(null, "José Raydan", est11);
		Cidade cid1762 = new Cidade(null, "Josenópolis", est11);
		Cidade cid1763 = new Cidade(null, "Nova União", est11);
		Cidade cid1764 = new Cidade(null, "Juatuba", est11);
		Cidade cid1765 = new Cidade(null, "Juiz de Fora", est11);
		Cidade cid1766 = new Cidade(null, "Juramento", est11);
		Cidade cid1767 = new Cidade(null, "Juruaia", est11);
		Cidade cid1768 = new Cidade(null, "Juvenília", est11);
		Cidade cid1769 = new Cidade(null, "Ladainha", est11);
		Cidade cid1770 = new Cidade(null, "Lagamar", est11);
		Cidade cid1771 = new Cidade(null, "Lagoa da Prata", est11);
		Cidade cid1772 = new Cidade(null, "Lagoa Dos Patos", est11);
		Cidade cid1773 = new Cidade(null, "Lagoa Dourada", est11);
		Cidade cid1774 = new Cidade(null, "Lagoa Formosa", est11);
		Cidade cid1775 = new Cidade(null, "Lagoa Grande", est11);
		Cidade cid1776 = new Cidade(null, "Lagoa Santa", est11);
		Cidade cid1777 = new Cidade(null, "Lajinha", est11);
		Cidade cid1778 = new Cidade(null, "Lambari", est11);
		Cidade cid1779 = new Cidade(null, "Lamim", est11);
		Cidade cid1780 = new Cidade(null, "Laranjal", est11);
		Cidade cid1781 = new Cidade(null, "Lassance", est11);
		Cidade cid1782 = new Cidade(null, "Lavras", est11);
		Cidade cid1783 = new Cidade(null, "Leandro Ferreira", est11);
		Cidade cid1784 = new Cidade(null, "Leme do Prado", est11);
		Cidade cid1785 = new Cidade(null, "Leopoldina", est11);
		Cidade cid1786 = new Cidade(null, "Liberdade", est11);
		Cidade cid1787 = new Cidade(null, "Lima Duarte", est11);
		Cidade cid1788 = new Cidade(null, "Limeira do Oeste", est11);
		Cidade cid1789 = new Cidade(null, "Lontra", est11);
		Cidade cid1790 = new Cidade(null, "Luisburgo", est11);
		Cidade cid1791 = new Cidade(null, "Luislândia", est11);
		Cidade cid1792 = new Cidade(null, "Luminárias", est11);
		Cidade cid1793 = new Cidade(null, "Luz", est11);
		Cidade cid1794 = new Cidade(null, "Machacalis", est11);
		Cidade cid1795 = new Cidade(null, "Machado", est11);
		Cidade cid1796 = new Cidade(null, "Madre de Deus de Minas", est11);
		Cidade cid1797 = new Cidade(null, "Malacachesta", est11);
		Cidade cid1798 = new Cidade(null, "Mamonas", est11);
		Cidade cid1799 = new Cidade(null, "Manga", est11);
		Cidade cid1800 = new Cidade(null, "Manhuaçu", est11);
		Cidade cid1801 = new Cidade(null, "Manhumirim", est11);
		Cidade cid1802 = new Cidade(null, "Mantena", est11);
		Cidade cid1803 = new Cidade(null, "Maravilhas", est11);
		Cidade cid1804 = new Cidade(null, "Mar de Espanha", est11);
		Cidade cid1805 = new Cidade(null, "Maria da fé", est11);
		Cidade cid1806 = new Cidade(null, "Mariana", est11);
		Cidade cid1807 = new Cidade(null, "Marilac", est11);
		Cidade cid1808 = new Cidade(null, "Mário Campos", est11);
		Cidade cid1809 = new Cidade(null, "Maripá de Minas", est11);
		Cidade cid1810 = new Cidade(null, "Marliéria", est11);
		Cidade cid1811 = new Cidade(null, "Marmelópolis", est11);
		Cidade cid1812 = new Cidade(null, "Martinho Campos", est11);
		Cidade cid1813 = new Cidade(null, "Martins Soares", est11);
		Cidade cid1814 = new Cidade(null, "Mata Verde", est11);
		Cidade cid1815 = new Cidade(null, "Materlândia", est11);
		Cidade cid1816 = new Cidade(null, "Mateus Leme", est11);
		Cidade cid1817 = new Cidade(null, "Matias Barbosa", est11);
		Cidade cid1818 = new Cidade(null, "Matias Cardoso", est11);
		Cidade cid1819 = new Cidade(null, "Matipó", est11);
		Cidade cid1820 = new Cidade(null, "Mato Verde", est11);
		Cidade cid1821 = new Cidade(null, "Matozinhos", est11);
		Cidade cid1822 = new Cidade(null, "Matutina", est11);
		Cidade cid1823 = new Cidade(null, "Medeiros", est11);
		Cidade cid1824 = new Cidade(null, "Medina", est11);
		Cidade cid1825 = new Cidade(null, "Mendes Pimentel", est11);
		Cidade cid1826 = new Cidade(null, "Mercês", est11);
		Cidade cid1827 = new Cidade(null, "Mesquita", est11);
		Cidade cid1828 = new Cidade(null, "Minas Novas", est11);
		Cidade cid1829 = new Cidade(null, "Minduri", est11);
		Cidade cid1830 = new Cidade(null, "Mirabela", est11);
		Cidade cid1831 = new Cidade(null, "Miradouro", est11);
		Cidade cid1832 = new Cidade(null, "Miraí", est11);
		Cidade cid1833 = new Cidade(null, "Miravânia", est11);
		Cidade cid1834 = new Cidade(null, "Moeda", est11);
		Cidade cid1835 = new Cidade(null, "Moema", est11);
		Cidade cid1836 = new Cidade(null, "Monjolos", est11);
		Cidade cid1837 = new Cidade(null, "Monsenhor Paulo", est11);
		Cidade cid1838 = new Cidade(null, "Montalvânia", est11);
		Cidade cid1839 = new Cidade(null, "Monte Alegre de Minas", est11);
		Cidade cid1840 = new Cidade(null, "Monte Azul", est11);
		Cidade cid1841 = new Cidade(null, "Monte Belo", est11);
		Cidade cid1842 = new Cidade(null, "Monte Carmelo", est11);
		Cidade cid1843 = new Cidade(null, "Monte Formoso", est11);
		Cidade cid1844 = new Cidade(null, "Monte Santo de Minas", est11);
		Cidade cid1845 = new Cidade(null, "Montes Claros", est11);
		Cidade cid1846 = new Cidade(null, "Monte Sião", est11);
		Cidade cid1847 = new Cidade(null, "Montezuma", est11);
		Cidade cid1848 = new Cidade(null, "Morada Nova de Minas", est11);
		Cidade cid1849 = new Cidade(null, "Morro da Garça", est11);
		Cidade cid1850 = new Cidade(null, "Morro do Pilar", est11);
		Cidade cid1851 = new Cidade(null, "Munhoz", est11);
		Cidade cid1852 = new Cidade(null, "Muriaé", est11);
		Cidade cid1853 = new Cidade(null, "Mutum", est11);
		Cidade cid1854 = new Cidade(null, "Muzambinho", est11);
		Cidade cid1855 = new Cidade(null, "Nacip Raydan", est11);
		Cidade cid1856 = new Cidade(null, "Nanuque", est11);
		Cidade cid1857 = new Cidade(null, "Naque", est11);
		Cidade cid1858 = new Cidade(null, "Natalândia", est11);
		Cidade cid1859 = new Cidade(null, "Natércia", est11);
		Cidade cid1860 = new Cidade(null, "Nazareno", est11);
		Cidade cid1861 = new Cidade(null, "Nepomuceno", est11);
		Cidade cid1862 = new Cidade(null, "Ninheira", est11);
		Cidade cid1863 = new Cidade(null, "Nova Belém", est11);
		Cidade cid1864 = new Cidade(null, "Nova Era", est11);
		Cidade cid1865 = new Cidade(null, "Nova Lima", est11);
		Cidade cid1866 = new Cidade(null, "Nova Módica", est11);
		Cidade cid1867 = new Cidade(null, "Nova Ponte", est11);
		Cidade cid1868 = new Cidade(null, "Nova Porteirinha", est11);
		Cidade cid1869 = new Cidade(null, "Nova Resende", est11);
		Cidade cid1870 = new Cidade(null, "Nova Serrana", est11);
		Cidade cid1871 = new Cidade(null, "Novo Cruzeiro", est11);
		Cidade cid1872 = new Cidade(null, "Novo Oriente de Minas", est11);
		Cidade cid1873 = new Cidade(null, "Novorizonte", est11);
		Cidade cid1874 = new Cidade(null, "Olaria", est11);
		Cidade cid1875 = new Cidade(null, "Olhos-d´água", est11);
		Cidade cid1876 = new Cidade(null, "Olímpio Noronha", est11);
		Cidade cid1877 = new Cidade(null, "Oliveira", est11);
		Cidade cid1878 = new Cidade(null, "Oliveira Fortes", est11);
		Cidade cid1879 = new Cidade(null, "Onça de Pitangui", est11);
		Cidade cid1880 = new Cidade(null, "Oratórios", est11);
		Cidade cid1881 = new Cidade(null, "Orizânia", est11);
		Cidade cid1882 = new Cidade(null, "Ouro Branco", est11);
		Cidade cid1883 = new Cidade(null, "Ouro Fino", est11);
		Cidade cid1884 = new Cidade(null, "Ouro Presto", est11);
		Cidade cid1885 = new Cidade(null, "Ouro Verde de Minas", est11);
		Cidade cid1886 = new Cidade(null, "Padre Carvalho", est11);
		Cidade cid1887 = new Cidade(null, "Padre Paraíso", est11);
		Cidade cid1888 = new Cidade(null, "Paineiras", est11);
		Cidade cid1889 = new Cidade(null, "Pains", est11);
		Cidade cid1890 = new Cidade(null, "Pai Pedro", est11);
		Cidade cid1891 = new Cidade(null, "Paiva", est11);
		Cidade cid1892 = new Cidade(null, "Palma", est11);
		Cidade cid1893 = new Cidade(null, "Palmópolis", est11);
		Cidade cid1894 = new Cidade(null, "Papagaios", est11);
		Cidade cid1895 = new Cidade(null, "Paracatu", est11);
		Cidade cid1896 = new Cidade(null, "Pará de Minas", est11);
		Cidade cid1897 = new Cidade(null, "Paraguaçu", est11);
		Cidade cid1898 = new Cidade(null, "Paraisópolis", est11);
		Cidade cid1899 = new Cidade(null, "Paraopeba", est11);
		Cidade cid1900 = new Cidade(null, "Passabém", est11);
		Cidade cid1901 = new Cidade(null, "Passa Quatro", est11);
		Cidade cid1902 = new Cidade(null, "Passa Tempo", est11);
		Cidade cid1903 = new Cidade(null, "Passa-vinte", est11);
		Cidade cid1904 = new Cidade(null, "Passos", est11);
		Cidade cid1905 = new Cidade(null, "Patis", est11);
		Cidade cid1906 = new Cidade(null, "Patos de Minas", est11);
		Cidade cid1907 = new Cidade(null, "Patrocínio", est11);
		Cidade cid1908 = new Cidade(null, "Patrocínio do Muriaé", est11);
		Cidade cid1909 = new Cidade(null, "Paula Cândido", est11);
		Cidade cid1910 = new Cidade(null, "Paulistas", est11);
		Cidade cid1911 = new Cidade(null, "Pavão", est11);
		Cidade cid1912 = new Cidade(null, "Peçanha", est11);
		Cidade cid1913 = new Cidade(null, "Pedra Azul", est11);
		Cidade cid1914 = new Cidade(null, "Pedra Bonita", est11);
		Cidade cid1915 = new Cidade(null, "Pedra do Anta", est11);
		Cidade cid1916 = new Cidade(null, "Pedra do Indaiá", est11);
		Cidade cid1917 = new Cidade(null, "Pedra Dourada", est11);
		Cidade cid1918 = new Cidade(null, "Pedralva", est11);
		Cidade cid1919 = new Cidade(null, "Pedras de Maria da Cruz", est11);
		Cidade cid1920 = new Cidade(null, "Pedrinópolis", est11);
		Cidade cid1921 = new Cidade(null, "Pedro Leopoldo", est11);
		Cidade cid1922 = new Cidade(null, "Pedro Teixeira", est11);
		Cidade cid1923 = new Cidade(null, "Pequeri", est11);
		Cidade cid1924 = new Cidade(null, "Pequi", est11);
		Cidade cid1925 = new Cidade(null, "Perdigão", est11);
		Cidade cid1926 = new Cidade(null, "Perdizes", est11);
		Cidade cid1927 = new Cidade(null, "Perdões", est11);
		Cidade cid1928 = new Cidade(null, "Periquito", est11);
		Cidade cid1929 = new Cidade(null, "Pescador", est11);
		Cidade cid1930 = new Cidade(null, "Piau", est11);
		Cidade cid1931 = new Cidade(null, "Piedade de Caratinga", est11);
		Cidade cid1932 = new Cidade(null, "Piedade de Ponte Nova", est11);
		Cidade cid1933 = new Cidade(null, "Piedade do Rio Grande", est11);
		Cidade cid1934 = new Cidade(null, "Piedade Dos Gerais", est11);
		Cidade cid1935 = new Cidade(null, "Pimenta", est11);
		Cidade cid1936 = new Cidade(null, "Pingo-d´água", est11);
		Cidade cid1937 = new Cidade(null, "Pintópolis", est11);
		Cidade cid1938 = new Cidade(null, "Piracema", est11);
		Cidade cid1939 = new Cidade(null, "Pirajuba", est11);
		Cidade cid1940 = new Cidade(null, "Piranga", est11);
		Cidade cid1941 = new Cidade(null, "Piranguçu", est11);
		Cidade cid1942 = new Cidade(null, "Piranguinho", est11);
		Cidade cid1943 = new Cidade(null, "Pirapestinga", est11);
		Cidade cid1944 = new Cidade(null, "Pirapora", est11);
		Cidade cid1945 = new Cidade(null, "Piraúba", est11);
		Cidade cid1946 = new Cidade(null, "Pitangui", est11);
		Cidade cid1947 = new Cidade(null, "Piumhi", est11);
		Cidade cid1948 = new Cidade(null, "Planura", est11);
		Cidade cid1949 = new Cidade(null, "Poço Fundo", est11);
		Cidade cid1950 = new Cidade(null, "Poços de Caldas", est11);
		Cidade cid1951 = new Cidade(null, "Pocrane", est11);
		Cidade cid1952 = new Cidade(null, "Pompéu", est11);
		Cidade cid1953 = new Cidade(null, "Ponte Nova", est11);
		Cidade cid1954 = new Cidade(null, "Ponto Chique", est11);
		Cidade cid1955 = new Cidade(null, "Ponto Dos Volantes", est11);
		Cidade cid1956 = new Cidade(null, "Porteirinha", est11);
		Cidade cid1957 = new Cidade(null, "Porto Firme", est11);
		Cidade cid1958 = new Cidade(null, "Poté", est11);
		Cidade cid1959 = new Cidade(null, "Pouso Alegre", est11);
		Cidade cid1960 = new Cidade(null, "Pouso Alto", est11);
		Cidade cid1961 = new Cidade(null, "Prados", est11);
		Cidade cid1962 = new Cidade(null, "Prata", est11);
		Cidade cid1963 = new Cidade(null, "Pratápolis", est11);
		Cidade cid1964 = new Cidade(null, "Pratinha", est11);
		Cidade cid1965 = new Cidade(null, "Presidente Bernardes", est11);
		Cidade cid1966 = new Cidade(null, "Presidente Juscelino", est11);
		Cidade cid1967 = new Cidade(null, "Presidente Kubitschek", est11);
		Cidade cid1968 = new Cidade(null, "Presidente Olegário", est11);
		Cidade cid1969 = new Cidade(null, "Alto Jequitibá", est11);
		Cidade cid1970 = new Cidade(null, "Prudente de Morais", est11);
		Cidade cid1971 = new Cidade(null, "Quartel Geral", est11);
		Cidade cid1972 = new Cidade(null, "Queluzito", est11);
		Cidade cid1973 = new Cidade(null, "Raposos", est11);
		Cidade cid1974 = new Cidade(null, "Raul Soares", est11);
		Cidade cid1975 = new Cidade(null, "Recreio", est11);
		Cidade cid1976 = new Cidade(null, "Reduto", est11);
		Cidade cid1977 = new Cidade(null, "Resende Costa", est11);
		Cidade cid1978 = new Cidade(null, "Resplendor", est11);
		Cidade cid1979 = new Cidade(null, "Ressaquinha", est11);
		Cidade cid1980 = new Cidade(null, "Riachinho", est11);
		Cidade cid1981 = new Cidade(null, "Riacho Dos Machados", est11);
		Cidade cid1982 = new Cidade(null, "Ribeirão Das Neves", est11);
		Cidade cid1983 = new Cidade(null, "Ribeirão Vermelho", est11);
		Cidade cid1984 = new Cidade(null, "Rio Acima", est11);
		Cidade cid1985 = new Cidade(null, "Rio Casca", est11);
		Cidade cid1986 = new Cidade(null, "Rio Doce", est11);
		Cidade cid1987 = new Cidade(null, "Rio do Prado", est11);
		Cidade cid1988 = new Cidade(null, "Rio Espera", est11);
		Cidade cid1989 = new Cidade(null, "Rio Manso", est11);
		Cidade cid1990 = new Cidade(null, "Rio Novo", est11);
		Cidade cid1991 = new Cidade(null, "Rio Paranaíba", est11);
		Cidade cid1992 = new Cidade(null, "Rio Pardo de Minas", est11);
		Cidade cid1993 = new Cidade(null, "Rio Piracicaba", est11);
		Cidade cid1994 = new Cidade(null, "Rio Pomba", est11);
		Cidade cid1995 = new Cidade(null, "Rio Presto", est11);
		Cidade cid1996 = new Cidade(null, "Rio Vermelho", est11);
		Cidade cid1997 = new Cidade(null, "Ritápolis", est11);
		Cidade cid1998 = new Cidade(null, "Rochedo de Minas", est11);
		Cidade cid1999 = new Cidade(null, "Rodeiro", est11);
		Cidade cid2000 = new Cidade(null, "Romaria", est11);
		Cidade cid2001 = new Cidade(null, "Rosário da Limeira", est11);
		Cidade cid2002 = new Cidade(null, "Rubelita", est11);
		Cidade cid2003 = new Cidade(null, "Rubim", est11);
		Cidade cid2004 = new Cidade(null, "Sabará", est11);
		Cidade cid2005 = new Cidade(null, "Sabinópolis", est11);
		Cidade cid2006 = new Cidade(null, "Sacramento", est11);
		Cidade cid2007 = new Cidade(null, "Salinas", est11);
		Cidade cid2008 = new Cidade(null, "Salto da Divisa", est11);
		Cidade cid2009 = new Cidade(null, "Santa Bárbara", est11);
		Cidade cid2010 = new Cidade(null, "Santa Bárbara do Leste", est11);
		Cidade cid2011 = new Cidade(null, "Santa Bárbara do Monte Verde", est11);
		Cidade cid2012 = new Cidade(null, "Santa Bárbara do Tugúrio", est11);
		Cidade cid2013 = new Cidade(null, "Santa Cruz de Minas", est11);
		Cidade cid2014 = new Cidade(null, "Santa Cruz de Salinas", est11);
		Cidade cid2015 = new Cidade(null, "Santa Cruz do Escalvado", est11);
		Cidade cid2016 = new Cidade(null, "Santa Efigênia de Minas", est11);
		Cidade cid2017 = new Cidade(null, "Santa fé de Minas", est11);
		Cidade cid2018 = new Cidade(null, "Santa Helena de Minas", est11);
		Cidade cid2019 = new Cidade(null, "Santa Juliana", est11);
		Cidade cid2020 = new Cidade(null, "Santa Luzia", est11);
		Cidade cid2021 = new Cidade(null, "Santa Margarida", est11);
		Cidade cid2022 = new Cidade(null, "Santa Maria de Itabira", est11);
		Cidade cid2023 = new Cidade(null, "Santa Maria do Salto", est11);
		Cidade cid2024 = new Cidade(null, "Santa Maria do Suaçuí", est11);
		Cidade cid2025 = new Cidade(null, "Santana da Vargem", est11);
		Cidade cid2026 = new Cidade(null, "Santana de Cataguases", est11);
		Cidade cid2027 = new Cidade(null, "Santana de Pirapama", est11);
		Cidade cid2028 = new Cidade(null, "Santana do Deserto", est11);
		Cidade cid2029 = new Cidade(null, "Santana do Garambéu", est11);
		Cidade cid2030 = new Cidade(null, "Santana do Jacaré", est11);
		Cidade cid2031 = new Cidade(null, "Santana do Manhuaçu", est11);
		Cidade cid2032 = new Cidade(null, "Santana do Paraíso", est11);
		Cidade cid2033 = new Cidade(null, "Santana do Riacho", est11);
		Cidade cid2034 = new Cidade(null, "Santana Dos Montes", est11);
		Cidade cid2035 = new Cidade(null, "Santa Rita de Caldas", est11);
		Cidade cid2036 = new Cidade(null, "Santa Rita de Jacutinga", est11);
		Cidade cid2037 = new Cidade(null, "Santa Rita de Minas", est11);
		Cidade cid2038 = new Cidade(null, "Santa Rita de Ibitipoca", est11);
		Cidade cid2039 = new Cidade(null, "Santa Rita do Ituesto", est11);
		Cidade cid2040 = new Cidade(null, "Santa Rita do Sapucaí", est11);
		Cidade cid2041 = new Cidade(null, "Santa Rosa da Serra", est11);
		Cidade cid2042 = new Cidade(null, "Santa Vitória", est11);
		Cidade cid2043 = new Cidade(null, "Santo Antônio do Amparo", est11);
		Cidade cid2044 = new Cidade(null, "Santo Antônio do Aventureiro", est11);
		Cidade cid2045 = new Cidade(null, "Santo Antônio do Grama", est11);
		Cidade cid2046 = new Cidade(null, "Santo Antônio do Itambé", est11);
		Cidade cid2047 = new Cidade(null, "Santo Antônio do Jacinto", est11);
		Cidade cid2048 = new Cidade(null, "Santo Antônio do Monte", est11);
		Cidade cid2049 = new Cidade(null, "Santo Antônio do Restiro", est11);
		Cidade cid2050 = new Cidade(null, "Santo Antônio do Rio Abaixo", est11);
		Cidade cid2051 = new Cidade(null, "Santo Hipólito", est11);
		Cidade cid2052 = new Cidade(null, "Santos Dumont", est11);
		Cidade cid2053 = new Cidade(null, "São Bento Abade", est11);
		Cidade cid2054 = new Cidade(null, "São Brás do Suaçuí", est11);
		Cidade cid2055 = new Cidade(null, "São Domingos Das Dores", est11);
		Cidade cid2056 = new Cidade(null, "São Domingos do Prata", est11);
		Cidade cid2057 = new Cidade(null, "São Félix de Minas", est11);
		Cidade cid2058 = new Cidade(null, "São Francisco", est11);
		Cidade cid2059 = new Cidade(null, "São Francisco de Paula", est11);
		Cidade cid2060 = new Cidade(null, "São Francisco de Sales", est11);
		Cidade cid2061 = new Cidade(null, "São Francisco do Glória", est11);
		Cidade cid2062 = new Cidade(null, "São Geraldo", est11);
		Cidade cid2063 = new Cidade(null, "São Geraldo da Piedade", est11);
		Cidade cid2064 = new Cidade(null, "São Geraldo do Baixio", est11);
		Cidade cid2065 = new Cidade(null, "São Gonçalo do Abaesté", est11);
		Cidade cid2066 = new Cidade(null, "São Gonçalo do Pará", est11);
		Cidade cid2067 = new Cidade(null, "São Gonçalo do Rio Abaixo", est11);
		Cidade cid2068 = new Cidade(null, "São Gonçalo do Sapucaí", est11);
		Cidade cid2069 = new Cidade(null, "São Gotardo", est11);
		Cidade cid2070 = new Cidade(null, "São João Batista do Glória", est11);
		Cidade cid2071 = new Cidade(null, "São João da Lagoa", est11);
		Cidade cid2072 = new Cidade(null, "São João da Mata", est11);
		Cidade cid2073 = new Cidade(null, "São João da Ponte", est11);
		Cidade cid2074 = new Cidade(null, "São João Das Missões", est11);
		Cidade cid2075 = new Cidade(null, "São João Del Rei", est11);
		Cidade cid2076 = new Cidade(null, "São João do Manhuaçu", est11);
		Cidade cid2077 = new Cidade(null, "São João do Manteninha", est11);
		Cidade cid2078 = new Cidade(null, "São João do Oriente", est11);
		Cidade cid2079 = new Cidade(null, "São João do Pacuí", est11);
		Cidade cid2080 = new Cidade(null, "São João do Paraíso", est11);
		Cidade cid2081 = new Cidade(null, "São João Evangelista", est11);
		Cidade cid2082 = new Cidade(null, "São João Nepomuceno", est11);
		Cidade cid2083 = new Cidade(null, "São Joaquim de Bicas", est11);
		Cidade cid2084 = new Cidade(null, "São José da Barra", est11);
		Cidade cid2085 = new Cidade(null, "São José da Lapa", est11);
		Cidade cid2086 = new Cidade(null, "São José da Safira", est11);
		Cidade cid2087 = new Cidade(null, "São José da Varginha", est11);
		Cidade cid2088 = new Cidade(null, "São José do Alegre", est11);
		Cidade cid2089 = new Cidade(null, "São José do Divino", est11);
		Cidade cid2090 = new Cidade(null, "São José do Goiabal", est11);
		Cidade cid2091 = new Cidade(null, "São José do Jacuri", est11);
		Cidade cid2092 = new Cidade(null, "São José do Mantimento", est11);
		Cidade cid2093 = new Cidade(null, "São Lourenço", est11);
		Cidade cid2094 = new Cidade(null, "São Miguel do Anta", est11);
		Cidade cid2095 = new Cidade(null, "São Pedro da União", est11);
		Cidade cid2096 = new Cidade(null, "São Pedro Dos Ferros", est11);
		Cidade cid2097 = new Cidade(null, "São Pedro do Suaçuí", est11);
		Cidade cid2098 = new Cidade(null, "São Romão", est11);
		Cidade cid2099 = new Cidade(null, "São Roque de Minas", est11);
		Cidade cid2100 = new Cidade(null, "São Sebastião da Bela Vista", est11);
		Cidade cid2101 = new Cidade(null, "São Sebastião da Vargem Alegre", est11);
		Cidade cid2102 = new Cidade(null, "São Sebastião do Anta", est11);
		Cidade cid2103 = new Cidade(null, "São Sebastião do Maranhão", est11);
		Cidade cid2104 = new Cidade(null, "São Sebastião do Oeste", est11);
		Cidade cid2105 = new Cidade(null, "São Sebastião do Paraíso", est11);
		Cidade cid2106 = new Cidade(null, "São Sebastião do Rio Presto", est11);
		Cidade cid2107 = new Cidade(null, "São Sebastião do Rio Verde", est11);
		Cidade cid2108 = new Cidade(null, "São Tiago", est11);
		Cidade cid2109 = new Cidade(null, "São Tomás de Aquino", est11);
		Cidade cid2110 = new Cidade(null, "São Thomé Das Lestras", est11);
		Cidade cid2111 = new Cidade(null, "São Vicente de Minas", est11);
		Cidade cid2112 = new Cidade(null, "Sapucaí-mirim", est11);
		Cidade cid2113 = new Cidade(null, "Sardoá", est11);
		Cidade cid2114 = new Cidade(null, "Sarzedo", est11);
		Cidade cid2115 = new Cidade(null, "Sestubinha", est11);
		Cidade cid2116 = new Cidade(null, "Sem-peixe", est11);
		Cidade cid2117 = new Cidade(null, "Senador Amaral", est11);
		Cidade cid2118 = new Cidade(null, "Senador Cortes", est11);
		Cidade cid2119 = new Cidade(null, "Senador Firmino", est11);
		Cidade cid2120 = new Cidade(null, "Senador José Bento", est11);
		Cidade cid2121 = new Cidade(null, "Senador Modestino Gonçalves", est11);
		Cidade cid2122 = new Cidade(null, "Senhora de Oliveira", est11);
		Cidade cid2123 = new Cidade(null, "Senhora do Porto", est11);
		Cidade cid2124 = new Cidade(null, "Senhora Dos Remédios", est11);
		Cidade cid2125 = new Cidade(null, "Sericita", est11);
		Cidade cid2126 = new Cidade(null, "Seritinga", est11);
		Cidade cid2127 = new Cidade(null, "Serra Azul de Minas", est11);
		Cidade cid2128 = new Cidade(null, "Serra da Saudade", est11);
		Cidade cid2129 = new Cidade(null, "Serra Dos Aimorés", est11);
		Cidade cid2130 = new Cidade(null, "Serra do Salitre", est11);
		Cidade cid2131 = new Cidade(null, "Serrania", est11);
		Cidade cid2132 = new Cidade(null, "Serranópolis de Minas", est11);
		Cidade cid2133 = new Cidade(null, "Serranos", est11);
		Cidade cid2134 = new Cidade(null, "Serro", est11);
		Cidade cid2135 = new Cidade(null, "Seste Lagoas", est11);
		Cidade cid2136 = new Cidade(null, "Silveirânia", est11);
		Cidade cid2137 = new Cidade(null, "Silvianópolis", est11);
		Cidade cid2138 = new Cidade(null, "Simão Pereira", est11);
		Cidade cid2139 = new Cidade(null, "Simonésia", est11);
		Cidade cid2140 = new Cidade(null, "Sobrália", est11);
		Cidade cid2141 = new Cidade(null, "Soledade de Minas", est11);
		Cidade cid2142 = new Cidade(null, "Tabuleiro", est11);
		Cidade cid2143 = new Cidade(null, "Taiobeiras", est11);
		Cidade cid2144 = new Cidade(null, "Taparuba", est11);
		Cidade cid2145 = new Cidade(null, "Tapira", est11);
		Cidade cid2146 = new Cidade(null, "Tapiraí", est11);
		Cidade cid2147 = new Cidade(null, "Taquaraçu de Minas", est11);
		Cidade cid2148 = new Cidade(null, "Tarumirim", est11);
		Cidade cid2149 = new Cidade(null, "Teixeiras", est11);
		Cidade cid2150 = new Cidade(null, "Teófilo Otoni", est11);
		Cidade cid2151 = new Cidade(null, "Timóteo", est11);
		Cidade cid2152 = new Cidade(null, "Tiradentes", est11);
		Cidade cid2153 = new Cidade(null, "Tiros", est11);
		Cidade cid2154 = new Cidade(null, "Tocantins", est11);
		Cidade cid2155 = new Cidade(null, "Tocos do Moji", est11);
		Cidade cid2156 = new Cidade(null, "Toledo", est11);
		Cidade cid2157 = new Cidade(null, "Tombos", est11);
		Cidade cid2158 = new Cidade(null, "Três Corações", est11);
		Cidade cid2159 = new Cidade(null, "Três Marias", est11);
		Cidade cid2160 = new Cidade(null, "Três Pontas", est11);
		Cidade cid2161 = new Cidade(null, "Tumiritinga", est11);
		Cidade cid2162 = new Cidade(null, "Tupaciguara", est11);
		Cidade cid2163 = new Cidade(null, "Turmalina", est11);
		Cidade cid2164 = new Cidade(null, "Turvolândia", est11);
		Cidade cid2165 = new Cidade(null, "Ubá", est11);
		Cidade cid2166 = new Cidade(null, "Ubaí", est11);
		Cidade cid2167 = new Cidade(null, "Ubaporanga", est11);
		Cidade cid2168 = new Cidade(null, "Uberaba", est11);
		Cidade cid2169 = new Cidade(null, "Uberlândia", est11);
		Cidade cid2170 = new Cidade(null, "Umburatiba", est11);
		Cidade cid2171 = new Cidade(null, "Unaí", est11);
		Cidade cid2172 = new Cidade(null, "União de Minas", est11);
		Cidade cid2173 = new Cidade(null, "Uruana de Minas", est11);
		Cidade cid2174 = new Cidade(null, "Urucânia", est11);
		Cidade cid2175 = new Cidade(null, "Urucuia", est11);
		Cidade cid2176 = new Cidade(null, "Vargem Alegre", est11);
		Cidade cid2177 = new Cidade(null, "Vargem Bonita", est11);
		Cidade cid2178 = new Cidade(null, "Vargem Grande do Rio Pardo", est11);
		Cidade cid2179 = new Cidade(null, "Varginha", est11);
		Cidade cid2180 = new Cidade(null, "Varjão de Minas", est11);
		Cidade cid2181 = new Cidade(null, "Várzea da Palma", est11);
		Cidade cid2182 = new Cidade(null, "Varzelândia", est11);
		Cidade cid2183 = new Cidade(null, "Vazante", est11);
		Cidade cid2184 = new Cidade(null, "Verdelândia", est11);
		Cidade cid2185 = new Cidade(null, "Veredinha", est11);
		Cidade cid2186 = new Cidade(null, "Veríssimo", est11);
		Cidade cid2187 = new Cidade(null, "Vermelho Novo", est11);
		Cidade cid2188 = new Cidade(null, "Vespasiano", est11);
		Cidade cid2189 = new Cidade(null, "Viçosa", est11);
		Cidade cid2190 = new Cidade(null, "Vieiras", est11);
		Cidade cid2191 = new Cidade(null, "Mathias Lobato", est11);
		Cidade cid2192 = new Cidade(null, "Virgem da Lapa", est11);
		Cidade cid2193 = new Cidade(null, "Virgínia", est11);
		Cidade cid2194 = new Cidade(null, "Virginópolis", est11);
		Cidade cid2195 = new Cidade(null, "Virgolândia", est11);
		Cidade cid2196 = new Cidade(null, "Visconde do Rio Branco", est11);
		Cidade cid2197 = new Cidade(null, "Volta Grande", est11);
		Cidade cid2198 = new Cidade(null, "Wenceslau Braz", est11);
		

		est11.getCidades().addAll(Arrays.asList(cid1346, cid1347, cid1348, cid1349,
				cid1350, cid1351, cid1352, cid1353, cid1354, cid1355, cid1356, cid1357, cid1358, cid1359, cid1360,
				cid1361, cid1362, cid1363, cid1364, cid1365, cid1366, cid1367, cid1368, cid1369, cid1370, cid1371,
				cid1372, cid1373, cid1374, cid1375, cid1376, cid1377, cid1378, cid1379, cid1380, cid1381, cid1382,
				cid1383, cid1384, cid1385, cid1386, cid1387, cid1388, cid1389, cid1390, cid1391, cid1392, cid1393,
				cid1394, cid1395, cid1396, cid1397, cid1398, cid1399, cid1400, cid1401, cid1402, cid1403, cid1404,
				cid1405, cid1406, cid1407, cid1408, cid1409, cid1410, cid1411, cid1412, cid1413, cid1414, cid1415,
				cid1416, cid1417, cid1418, cid1419, cid1420, cid1421, cid1422, cid1423, cid1424, cid1425, cid1426,
				cid1427, cid1428, cid1429, cid1430, cid1431, cid1432, cid1433, cid1434, cid1435, cid1436, cid1437,
				cid1438, cid1439, cid1440, cid1441, cid1442, cid1443, cid1444, cid1445, cid1446, cid1447, cid1448,
				cid1449, cid1450, cid1451, cid1452, cid1453, cid1454, cid1455, cid1456, cid1457, cid1458, cid1459,
				cid1460, cid1461, cid1462, cid1463, cid1464, cid1465, cid1466, cid1467, cid1468, cid1469, cid1470,
				cid1471, cid1472, cid1473, cid1474, cid1475, cid1476, cid1477, cid1478, cid1479, cid1480, cid1481,
				cid1482, cid1483, cid1484, cid1485, cid1486, cid1487, cid1488, cid1489, cid1490, cid1491, cid1492,
				cid1493, cid1494, cid1495, cid1496, cid1497, cid1498, cid1499, cid1500, cid1501, cid1502, cid1503,
				cid1504, cid1505, cid1506, cid1507, cid1508, cid1509, cid1510, cid1511, cid1512, cid1513, cid1514,
				cid1515, cid1516, cid1517, cid1518, cid1519, cid1520, cid1521, cid1522, cid1523, cid1524, cid1525,
				cid1526, cid1527, cid1528, cid1529, cid1530, cid1531, cid1532, cid1533, cid1534, cid1535, cid1536,
				cid1537, cid1538, cid1539, cid1540, cid1541, cid1542, cid1543, cid1544, cid1545, cid1546, cid1547,
				cid1548, cid1549, cid1550, cid1551, cid1552, cid1553, cid1554, cid1555, cid1556, cid1557, cid1558,
				cid1559, cid1560, cid1561, cid1562, cid1563, cid1564, cid1565, cid1566, cid1567, cid1568, cid1569,
				cid1570, cid1571, cid1572, cid1573, cid1574, cid1575, cid1576, cid1577, cid1578, cid1579, cid1580,
				cid1581, cid1582, cid1583, cid1584, cid1585, cid1586, cid1587, cid1588, cid1589, cid1590, cid1591,
				cid1592, cid1593, cid1594, cid1595, cid1596, cid1597, cid1598, cid1599, cid1600, cid1601, cid1602,
				cid1603, cid1604, cid1605, cid1606, cid1607, cid1608, cid1609, cid1610, cid1611, cid1612, cid1613,
				cid1614, cid1615, cid1616, cid1617, cid1618, cid1619, cid1620, cid1621, cid1622, cid1623, cid1624,
				cid1625, cid1626, cid1627, cid1628, cid1629, cid1630, cid1631, cid1632, cid1633, cid1634, cid1635,
				cid1636, cid1637, cid1638, cid1639, cid1640, cid1641, cid1642, cid1643, cid1644, cid1645, cid1646,
				cid1647, cid1648, cid1649, cid1650, cid1651, cid1652, cid1653, cid1654, cid1655, cid1656, cid1657,
				cid1658, cid1659, cid1660, cid1661, cid1662, cid1663, cid1664, cid1665, cid1666, cid1667, cid1668,
				cid1669, cid1670, cid1671, cid1672, cid1673, cid1674, cid1675, cid1676, cid1677, cid1678, cid1679,
				cid1680, cid1681, cid1682, cid1683, cid1684, cid1685, cid1686, cid1687, cid1688, cid1689, cid1690,
				cid1691, cid1692, cid1693, cid1694, cid1695, cid1696, cid1697, cid1698, cid1699, cid1700, cid1701,
				cid1702, cid1703, cid1704, cid1705, cid1706, cid1707, cid1708, cid1709, cid1710, cid1711, cid1712,
				cid1713, cid1714, cid1715, cid1716, cid1717, cid1718, cid1719, cid1720, cid1721, cid1722, cid1723,
				cid1724, cid1725, cid1726, cid1727, cid1728, cid1729, cid1730, cid1731, cid1732, cid1733, cid1734,
				cid1735, cid1736, cid1737, cid1738, cid1739, cid1740, cid1741, cid1742, cid1743, cid1744, cid1745,
				cid1746, cid1747, cid1748, cid1749, cid1750, cid1751, cid1752, cid1753, cid1754, cid1755, cid1756,
				cid1757, cid1758, cid1759, cid1760, cid1761, cid1762, cid1763, cid1764, cid1765, cid1766, cid1767,
				cid1768, cid1769, cid1770, cid1771, cid1772, cid1773, cid1774, cid1775, cid1776, cid1777, cid1778,
				cid1779, cid1780, cid1781, cid1782, cid1783, cid1784, cid1785, cid1786, cid1787, cid1788, cid1789,
				cid1790, cid1791, cid1792, cid1793, cid1794, cid1795, cid1796, cid1797, cid1798, cid1799, cid1800,
				cid1801, cid1802, cid1803, cid1804, cid1805, cid1806, cid1807, cid1808, cid1809, cid1810, cid1811,
				cid1812, cid1813, cid1814, cid1815, cid1816, cid1817, cid1818, cid1819, cid1820, cid1821, cid1822,
				cid1823, cid1824, cid1825, cid1826, cid1827, cid1828, cid1829, cid1830, cid1831, cid1832, cid1833,
				cid1834, cid1835, cid1836, cid1837, cid1838, cid1839, cid1840, cid1841, cid1842, cid1843, cid1844,
				cid1845, cid1846, cid1847, cid1848, cid1849, cid1850, cid1851, cid1852, cid1853, cid1854, cid1855,
				cid1856, cid1857, cid1858, cid1859, cid1860, cid1861, cid1862, cid1863, cid1864, cid1865, cid1866,
				cid1867, cid1868, cid1869, cid1870, cid1871, cid1872, cid1873, cid1874, cid1875, cid1876, cid1877,
				cid1878, cid1879, cid1880, cid1881, cid1882, cid1883, cid1884, cid1885, cid1886, cid1887, cid1888,
				cid1889, cid1890, cid1891, cid1892, cid1893, cid1894, cid1895, cid1896, cid1897, cid1898, cid1899,
				cid1900, cid1901, cid1902, cid1903, cid1904, cid1905, cid1906, cid1907, cid1908, cid1909, cid1910,
				cid1911, cid1912, cid1913, cid1914, cid1915, cid1916, cid1917, cid1918, cid1919, cid1920, cid1921,
				cid1922, cid1923, cid1924, cid1925, cid1926, cid1927, cid1928, cid1929, cid1930, cid1931, cid1932,
				cid1933, cid1934, cid1935, cid1936, cid1937, cid1938, cid1939, cid1940, cid1941, cid1942, cid1943,
				cid1944, cid1945, cid1946, cid1947, cid1948, cid1949, cid1950, cid1951, cid1952, cid1953, cid1954,
				cid1955, cid1956, cid1957, cid1958, cid1959, cid1960, cid1961, cid1962, cid1963, cid1964, cid1965,
				cid1966, cid1967, cid1968, cid1969, cid1970, cid1971, cid1972, cid1973, cid1974, cid1975, cid1976,
				cid1977, cid1978, cid1979, cid1980, cid1981, cid1982, cid1983, cid1984, cid1985, cid1986, cid1987,
				cid1988, cid1989, cid1990, cid1991, cid1992, cid1993, cid1994, cid1995, cid1996, cid1997, cid1998,
				cid1999, cid2000, cid2001, cid2002, cid2003, cid2004, cid2005, cid2006, cid2007, cid2008, cid2009,
				cid2010, cid2011, cid2012, cid2013, cid2014, cid2015, cid2016, cid2017, cid2018, cid2019, cid2020,
				cid2021, cid2022, cid2023, cid2024, cid2025, cid2026, cid2027, cid2028, cid2029, cid2030, cid2031,
				cid2032, cid2033, cid2034, cid2035, cid2036, cid2037, cid2038, cid2039, cid2040, cid2041, cid2042,
				cid2043, cid2044, cid2045, cid2046, cid2047, cid2048, cid2049, cid2050, cid2051, cid2052, cid2053,
				cid2054, cid2055, cid2056, cid2057, cid2058, cid2059, cid2060, cid2061, cid2062, cid2063, cid2064,
				cid2065, cid2066, cid2067, cid2068, cid2069, cid2070, cid2071, cid2072, cid2073, cid2074, cid2075,
				cid2076, cid2077, cid2078, cid2079, cid2080, cid2081, cid2082, cid2083, cid2084, cid2085, cid2086,
				cid2087, cid2088, cid2089, cid2090, cid2091, cid2092, cid2093, cid2094, cid2095, cid2096, cid2097,
				cid2098, cid2099, cid2100, cid2101, cid2102, cid2103, cid2104, cid2105, cid2106, cid2107, cid2108,
				cid2109, cid2110, cid2111, cid2112, cid2113, cid2114, cid2115, cid2116, cid2117, cid2118, cid2119,
				cid2120, cid2121, cid2122, cid2123, cid2124, cid2125, cid2126, cid2127, cid2128, cid2129, cid2130,
				cid2131, cid2132, cid2133, cid2134, cid2135, cid2136, cid2137, cid2138, cid2139, cid2140, cid2141,
				cid2142, cid2143, cid2144, cid2145, cid2146, cid2147, cid2148, cid2149, cid2150, cid2151, cid2152,
				cid2153, cid2154, cid2155, cid2156, cid2157, cid2158, cid2159, cid2160, cid2161, cid2162, cid2163,
				cid2164, cid2165, cid2166, cid2167, cid2168, cid2169, cid2170, cid2171, cid2172, cid2173, cid2174,
				cid2175, cid2176, cid2177, cid2178, cid2179, cid2180, cid2181, cid2182, cid2183, cid2184, cid2185,
				cid2186, cid2187, cid2188, cid2189, cid2190, cid2191, cid2192, cid2193, cid2194, cid2195, cid2196,
				cid2197, cid2198));

		estadoRepository.saveAll(
				Arrays.asList(est11));
		cidadeRepository.saveAll(Arrays.asList(cid1346, cid1347, cid1348, cid1349,
				cid1350, cid1351, cid1352, cid1353, cid1354, cid1355, cid1356, cid1357, cid1358, cid1359, cid1360,
				cid1361, cid1362, cid1363, cid1364, cid1365, cid1366, cid1367, cid1368, cid1369, cid1370, cid1371,
				cid1372, cid1373, cid1374, cid1375, cid1376, cid1377, cid1378, cid1379, cid1380, cid1381, cid1382,
				cid1383, cid1384, cid1385, cid1386, cid1387, cid1388, cid1389, cid1390, cid1391, cid1392, cid1393,
				cid1394, cid1395, cid1396, cid1397, cid1398, cid1399, cid1400, cid1401, cid1402, cid1403, cid1404,
				cid1405, cid1406, cid1407, cid1408, cid1409, cid1410, cid1411, cid1412, cid1413, cid1414, cid1415,
				cid1416, cid1417, cid1418, cid1419, cid1420, cid1421, cid1422, cid1423, cid1424, cid1425, cid1426,
				cid1427, cid1428, cid1429, cid1430, cid1431, cid1432, cid1433, cid1434, cid1435, cid1436, cid1437,
				cid1438, cid1439, cid1440, cid1441, cid1442, cid1443, cid1444, cid1445, cid1446, cid1447, cid1448,
				cid1449, cid1450, cid1451, cid1452, cid1453, cid1454, cid1455, cid1456, cid1457, cid1458, cid1459,
				cid1460, cid1461, cid1462, cid1463, cid1464, cid1465, cid1466, cid1467, cid1468, cid1469, cid1470,
				cid1471, cid1472, cid1473, cid1474, cid1475, cid1476, cid1477, cid1478, cid1479, cid1480, cid1481,
				cid1482, cid1483, cid1484, cid1485, cid1486, cid1487, cid1488, cid1489, cid1490, cid1491, cid1492,
				cid1493, cid1494, cid1495, cid1496, cid1497, cid1498, cid1499, cid1500, cid1501, cid1502, cid1503,
				cid1504, cid1505, cid1506, cid1507, cid1508, cid1509, cid1510, cid1511, cid1512, cid1513, cid1514,
				cid1515, cid1516, cid1517, cid1518, cid1519, cid1520, cid1521, cid1522, cid1523, cid1524, cid1525,
				cid1526, cid1527, cid1528, cid1529, cid1530, cid1531, cid1532, cid1533, cid1534, cid1535, cid1536,
				cid1537, cid1538, cid1539, cid1540, cid1541, cid1542, cid1543, cid1544, cid1545, cid1546, cid1547,
				cid1548, cid1549, cid1550, cid1551, cid1552, cid1553, cid1554, cid1555, cid1556, cid1557, cid1558,
				cid1559, cid1560, cid1561, cid1562, cid1563, cid1564, cid1565, cid1566, cid1567, cid1568, cid1569,
				cid1570, cid1571, cid1572, cid1573, cid1574, cid1575, cid1576, cid1577, cid1578, cid1579, cid1580,
				cid1581, cid1582, cid1583, cid1584, cid1585, cid1586, cid1587, cid1588, cid1589, cid1590, cid1591,
				cid1592, cid1593, cid1594, cid1595, cid1596, cid1597, cid1598, cid1599, cid1600, cid1601, cid1602,
				cid1603, cid1604, cid1605, cid1606, cid1607, cid1608, cid1609, cid1610, cid1611, cid1612, cid1613,
				cid1614, cid1615, cid1616, cid1617, cid1618, cid1619, cid1620, cid1621, cid1622, cid1623, cid1624,
				cid1625, cid1626, cid1627, cid1628, cid1629, cid1630, cid1631, cid1632, cid1633, cid1634, cid1635,
				cid1636, cid1637, cid1638, cid1639, cid1640, cid1641, cid1642, cid1643, cid1644, cid1645, cid1646,
				cid1647, cid1648, cid1649, cid1650, cid1651, cid1652, cid1653, cid1654, cid1655, cid1656, cid1657,
				cid1658, cid1659, cid1660, cid1661, cid1662, cid1663, cid1664, cid1665, cid1666, cid1667, cid1668,
				cid1669, cid1670, cid1671, cid1672, cid1673, cid1674, cid1675, cid1676, cid1677, cid1678, cid1679,
				cid1680, cid1681, cid1682, cid1683, cid1684, cid1685, cid1686, cid1687, cid1688, cid1689, cid1690,
				cid1691, cid1692, cid1693, cid1694, cid1695, cid1696, cid1697, cid1698, cid1699, cid1700, cid1701,
				cid1702, cid1703, cid1704, cid1705, cid1706, cid1707, cid1708, cid1709, cid1710, cid1711, cid1712,
				cid1713, cid1714, cid1715, cid1716, cid1717, cid1718, cid1719, cid1720, cid1721, cid1722, cid1723,
				cid1724, cid1725, cid1726, cid1727, cid1728, cid1729, cid1730, cid1731, cid1732, cid1733, cid1734,
				cid1735, cid1736, cid1737, cid1738, cid1739, cid1740, cid1741, cid1742, cid1743, cid1744, cid1745,
				cid1746, cid1747, cid1748, cid1749, cid1750, cid1751, cid1752, cid1753, cid1754, cid1755, cid1756,
				cid1757, cid1758, cid1759, cid1760, cid1761, cid1762, cid1763, cid1764, cid1765, cid1766, cid1767,
				cid1768, cid1769, cid1770, cid1771, cid1772, cid1773, cid1774, cid1775, cid1776, cid1777, cid1778,
				cid1779, cid1780, cid1781, cid1782, cid1783, cid1784, cid1785, cid1786, cid1787, cid1788, cid1789,
				cid1790, cid1791, cid1792, cid1793, cid1794, cid1795, cid1796, cid1797, cid1798, cid1799, cid1800,
				cid1801, cid1802, cid1803, cid1804, cid1805, cid1806, cid1807, cid1808, cid1809, cid1810, cid1811,
				cid1812, cid1813, cid1814, cid1815, cid1816, cid1817, cid1818, cid1819, cid1820, cid1821, cid1822,
				cid1823, cid1824, cid1825, cid1826, cid1827, cid1828, cid1829, cid1830, cid1831, cid1832, cid1833,
				cid1834, cid1835, cid1836, cid1837, cid1838, cid1839, cid1840, cid1841, cid1842, cid1843, cid1844,
				cid1845, cid1846, cid1847, cid1848, cid1849, cid1850, cid1851, cid1852, cid1853, cid1854, cid1855,
				cid1856, cid1857, cid1858, cid1859, cid1860, cid1861, cid1862, cid1863, cid1864, cid1865, cid1866,
				cid1867, cid1868, cid1869, cid1870, cid1871, cid1872, cid1873, cid1874, cid1875, cid1876, cid1877,
				cid1878, cid1879, cid1880, cid1881, cid1882, cid1883, cid1884, cid1885, cid1886, cid1887, cid1888,
				cid1889, cid1890, cid1891, cid1892, cid1893, cid1894, cid1895, cid1896, cid1897, cid1898, cid1899,
				cid1900, cid1901, cid1902, cid1903, cid1904, cid1905, cid1906, cid1907, cid1908, cid1909, cid1910,
				cid1911, cid1912, cid1913, cid1914, cid1915, cid1916, cid1917, cid1918, cid1919, cid1920, cid1921,
				cid1922, cid1923, cid1924, cid1925, cid1926, cid1927, cid1928, cid1929, cid1930, cid1931, cid1932,
				cid1933, cid1934, cid1935, cid1936, cid1937, cid1938, cid1939, cid1940, cid1941, cid1942, cid1943,
				cid1944, cid1945, cid1946, cid1947, cid1948, cid1949, cid1950, cid1951, cid1952, cid1953, cid1954,
				cid1955, cid1956, cid1957, cid1958, cid1959, cid1960, cid1961, cid1962, cid1963, cid1964, cid1965,
				cid1966, cid1967, cid1968, cid1969, cid1970, cid1971, cid1972, cid1973, cid1974, cid1975, cid1976,
				cid1977, cid1978, cid1979, cid1980, cid1981, cid1982, cid1983, cid1984, cid1985, cid1986, cid1987,
				cid1988, cid1989, cid1990, cid1991, cid1992, cid1993, cid1994, cid1995, cid1996, cid1997, cid1998,
				cid1999, cid2000, cid2001, cid2002, cid2003, cid2004, cid2005, cid2006, cid2007, cid2008, cid2009,
				cid2010, cid2011, cid2012, cid2013, cid2014, cid2015, cid2016, cid2017, cid2018, cid2019, cid2020,
				cid2021, cid2022, cid2023, cid2024, cid2025, cid2026, cid2027, cid2028, cid2029, cid2030, cid2031,
				cid2032, cid2033, cid2034, cid2035, cid2036, cid2037, cid2038, cid2039, cid2040, cid2041, cid2042,
				cid2043, cid2044, cid2045, cid2046, cid2047, cid2048, cid2049, cid2050, cid2051, cid2052, cid2053,
				cid2054, cid2055, cid2056, cid2057, cid2058, cid2059, cid2060, cid2061, cid2062, cid2063, cid2064,
				cid2065, cid2066, cid2067, cid2068, cid2069, cid2070, cid2071, cid2072, cid2073, cid2074, cid2075,
				cid2076, cid2077, cid2078, cid2079, cid2080, cid2081, cid2082, cid2083, cid2084, cid2085, cid2086,
				cid2087, cid2088, cid2089, cid2090, cid2091, cid2092, cid2093, cid2094, cid2095, cid2096, cid2097,
				cid2098, cid2099, cid2100, cid2101, cid2102, cid2103, cid2104, cid2105, cid2106, cid2107, cid2108,
				cid2109, cid2110, cid2111, cid2112, cid2113, cid2114, cid2115, cid2116, cid2117, cid2118, cid2119,
				cid2120, cid2121, cid2122, cid2123, cid2124, cid2125, cid2126, cid2127, cid2128, cid2129, cid2130,
				cid2131, cid2132, cid2133, cid2134, cid2135, cid2136, cid2137, cid2138, cid2139, cid2140, cid2141,
				cid2142, cid2143, cid2144, cid2145, cid2146, cid2147, cid2148, cid2149, cid2150, cid2151, cid2152,
				cid2153, cid2154, cid2155, cid2156, cid2157, cid2158, cid2159, cid2160, cid2161, cid2162, cid2163,
				cid2164, cid2165, cid2166, cid2167, cid2168, cid2169, cid2170, cid2171, cid2172, cid2173, cid2174,
				cid2175, cid2176, cid2177, cid2178, cid2179, cid2180, cid2181, cid2182, cid2183, cid2184, cid2185,
				cid2186, cid2187, cid2188, cid2189, cid2190, cid2191, cid2192, cid2193, cid2194, cid2195, cid2196,
				cid2197, cid2198));

		Cliente cliente = new Cliente(null, "Alex Alves", "alexalvesfd@hotmail.com", "13476657688",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("12345"));
		cliente.getTelefones().addAll(Arrays.asList("37131313", "995881695"));
		cliente.addPerfil(Perfil.ADMIN);

		Cliente cliente2 = new Cliente(null, "Aline Jean", "alinejean@hotmail.com", "38990872081",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cliente.getTelefones().addAll(Arrays.asList("996622111", "9855664411"));
		cliente.addPerfil(Perfil.CLIENTE);

		Endereco endereco = new Endereco(null, "Rua x", "555", "apt 2", "Centro", "3572000", cliente, cid1808);
		Endereco endereco2 = new Endereco(null, "Rua Y", "115", "apt 25", "Represa", "3573000", cliente2, cid1808);
		Endereco endereco3 = new Endereco(null, "Rua x", "555", "apt 2", "Centro", "3572000", cliente2, cid1808);

		cliente.getEnderecos().addAll(Arrays.asList(endereco));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente, cliente2));
		enderecoRepository.saveAll(Arrays.asList(endereco, endereco2, endereco3));

		Date agora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pedido pedido = new Pedido(null, agora, null, cliente, endereco);
		Pedido pedido2 = new Pedido(null, agora, null, cliente, endereco2);
		Pedido pedido3 = new Pedido(null, agora, null, cliente2, endereco2);
		Pagamento pagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido, 6);
		pedido.setPagamento(pagamento);

		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PEDENTE, pedido2, sdf.parse("20/12/2021"),
				null);
		pedido2.setPagamento(pagamento2);

		cliente.getPedidos().addAll(Arrays.asList(pedido, pedido2));
		cliente2.getPedidos().addAll(Arrays.asList(pedido3));

		pedidoRepository.saveAll(Arrays.asList(pedido, pedido2, pedido3));
		pagamentoRepository.saveAll(Arrays.asList(pagamento, pagamento2));

		ItemPedido itemPedido = new ItemPedido(pedido, produto1, 0.00, 1, 2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido2, produto2, 50.00, 2, 4000.00);

		pedido.getItenspedido().addAll(Arrays.asList(itemPedido));
		pedido2.getItenspedido().addAll(Arrays.asList(itemPedido2));

		produto1.getItensproduto().addAll(Arrays.asList(itemPedido));
		produto2.getItensproduto().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido, itemPedido2));
	}
}
