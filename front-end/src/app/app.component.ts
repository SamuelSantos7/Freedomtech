import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontFreedom';
}

postagem: Postagem = new Postagem()
listaPostagem: Postagem[]

categoria: Categoria = new Categoria()
listaCategoria: Categoria[]

idCategoria: number

user: User = new User()
idUser = environment.id


construtor(
private router: Router,
private postagemService: PostagemService,
private categoriaService: CategoriaService,
private authService: AuthService
) {  }

ngOnInit() {
  this.getAllCategoria()
  this.getAllPostagem()
}

getAllCategoria() {
  this.categoriaService.getAllCategoria().subscribe((resp: Categoria[])	=> {
  this.listaCategoria = resp
  })
  
  }
  
  findByCategoria() {
  
  this.categoriaService.getByCategoria(this.id).subscribe((resp: Categoria) => {
  this.categoria = resp
  })
  
  }
  
  
  getAllPostagem() {
  this.postagemService.getAllPostagem().subscribe((resp: Postagem[]) => {
  this.listaPostagem = resp
  }
  }
  
  
  findByIdUser() {
  this.authService.getByUser(this.idUser).subcribe((resp: User) => {
  this.user. resp
  })
  
  }

 publicar() {
    this.categoria.id = this.idCategoria
    this.postagem.categoria = this.categoria
    
    this.user.id = this.idUser
    this.postagem.usuario = this.user
    
    this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem) => {
    this.postagem = resp
    alert('Postagem realizada com sucesso!')
    this.postagem = new Postagem()
    this.getAllPostagem()
      })
    }
      
    
    
     }