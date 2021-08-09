package br.com.squad.Freedomtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column(name="usuarios")
	@NotNull
	private String nome;

	@Column
	@Size(min = 3, max = 30)
	@NotNull
	private String nomeSocial;

	@Column
	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 3, max = 30)
	@Column
	private String telefone;

	@CPF
	@NotNull
	@Size(min = 3, max = 30)
	@Column
	private String cpf;

	@Column
	private String cidade;

	
	@Column
	private String estado;

	
	@Column
	private String github;


	@Column
	private String linkedin;

	@NotBlank
	@Size(min = 3, max = 30)
	@Column
	private String nomeEmpresa;

	
	@CNPJ
	@Column
	private String cnpj;

	@NotNull
	@Column
	private String login;

	@Column
	@NotNull
	private String senha;

	// @OneToMany(mappedBy = "tb_usuario",cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("tb_usuario")
	// private List<TarefaModel> tarefa;

//	@OneToMany(mappedBy = "tb_usuario",cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("tb_usuario")
	// private List<PostagemModel> postagem;

//	public List<TarefaModel> getTarefa() {
	// return tarefa;

//	public void setTarefa(List<TarefaModel> tarefa) {
	// this.tarefa = tarefa;
//	}

	// public List<PostagemModel> getPostagem() {
	// return postagem;
	// }

//	public void setPostagem(List<PostagemModel> postagem) {
	// this.postagem = postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
