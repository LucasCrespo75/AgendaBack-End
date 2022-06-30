package br.com.usuario.agenda.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.usuario.agenda.model.Usuario;

@Transactional(readOnly = true)
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
	
	
	
	//@Query(value = "SELECT * FROM USUARIOS u", nativeQuery = true)
	//List<Usuario> findAll();
	
	//@Query(value = "SELECT * FROM USUARIOS u WHERE u.email = :email", nativeQuery = true)
	//Optional<Usuario> findByEmail(@Param("email") String email);
	
	//@Modifying
	//@Transactional(readOnly=false)
	//@Query(value="INSERT INTO USUARIOS (id_agenda, email, nome, telefone) VALUES (:email, :nome, :telefone", nativeQuery = true)
	//void insert(@Param("id_agenda")Long id_agenda, @Param("email") String email, @Param("nome") String nome, @Param("telefone") String telefone);
	
	//@Modifying
	//@Transactional(readOnly = false)
	//@Query(value = "UPDATE USUARIOS SET nome=:nome) WHERE email = :email and :telefone", nativeQuery = true)
	//void update(@Param("email") String email, @Param("telefone") String telefone, @Param("nome") String nome);
	
	//@Modifying
	//@Transactional(readOnly = false)
	//@Query(value= "DELETE USUARIOS WHERE id_agenda = :id_agenda", nativeQuery = true)
	//void delete (@Param("id_agenda") Long id_agenda);
}
