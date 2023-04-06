package com.lucasraimundo.safeway.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasraimundo.safeway.dto.UsuarioDTO;
import com.lucasraimundo.safeway.dto.UsuarioNewDTO;
import com.lucasraimundo.safeway.entities.Usuario;
import com.lucasraimundo.safeway.repositories.UsuarioRepository;
import com.lucasraimundo.safeway.services.exceptions.DataIntegrityException;

@Service
public class UsuarioService {
	
	
	
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName(), obj));
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
		}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir porque há pedidos relacionadas");
		}
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario cli = new Usuario(null, objDto.getName(), objDto.getEmail(), objDto.getCpf(), objDto.getPassword());
		
		return cli;
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		
		return obj;
	}

}
