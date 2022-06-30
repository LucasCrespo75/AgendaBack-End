package br.com.usuario.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	//@Bean
	//CommandLineRunner inicie(UsuarioRepositorio repository){
		//return args -> {
//			opcional
		///	repository.deleteAll();
			///LongStream.range(1, 10)
			//.mapToObj( i -> {
			//Usuario u = new Usuario();
			//	u.setNome("Nome mue usuario " + i);
			//	u.setEmail("usuario" + i + "@gmail.com");
			//	u.setTelefone(i+ i + "-" + i + i + i + i + i + "-" + i + i + i + i);

			//	return u;
			//})
			//.map(m -> repository.save(m))
			//.forEach(System.out::println);
		//};
//}

}
