  
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { Postagem } from '../model/Postagem';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';
import { CategoriaService } from '../service/categoria.service';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {

  nome = environment.nome
  foto = environment.foto

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]

  categoria: Categoria = new Categoria
  listaCategorias: Categoria[]
  idCategoria: number

  user: User = new User()
  idUser = environment.id
  sumir: any;
  usuarioPostagem: number;


  constructor(
    private router : Router,
    private postagemService : PostagemService,
    private categoriaService : CategoriaService,
    private auth: AuthService

  ) { }

  ngOnInit() {
    if (environment.token == '') {
      alert('Sua seção expirou, faça login novamente.')
      this.router.navigate(['/login'])
    }

    this.getAllCategorias()
    this.getAllPostagens()
  }

  getAllCategorias(){
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[]) =>{
      this.listaCategorias = resp
    })
  }

  findByIdCategoria(){
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: Categoria)=>{
      this.categoria = resp
    })
  }

  getAllPostagens(){
    this.postagemService.getAllPostagens().subscribe((resp: Postagem[])=> {
      this.listaPostagens = resp
    })
  }

  findByIdUser(){
    this.auth.getByidUser(this.idUser).subscribe((resp: User)=>{
      this.user = resp
    })
  }

  sair(){
    this.router.navigate(['/inicio'])
    environment.token =''
    environment.nome =''
    environment.id = 0
    environment.foto=''
  }


  publicar(){
    this.categoria = new Categoria();
    this.categoria.id = this.idCategoria
    this.postagem.categoria = this.categoria

    this.user = new User();
    this.user.id = this.idUser
    this.postagem.usuario = this.user
    console.log("postagem "+JSON.stringify( this.postagem))
    this.postagemService.postPostagem(this.postagem).subscribe((resp : Postagem)=>{
      this.postagem = resp
      alert('Postagem realizada com sucesso!!!')
      this.postagem = new Postagem()
      this.getAllPostagens()
    })

  }

}
