import { Component, OnInit } from '@angular/core';
import { Categoria } from '../model/Categoria';
import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { CategoriaService } from '../service/categoria.service';


@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  
  categoria:Categoria = new Categoria
  listaCategorias : Categoria[];

  constructor(
  private router: Router,
  private categoriaService: CategoriaService  
  ) { }

  ngOnInit() {
    if (environment.token == '') {
      alert('Sua seção expirou, faça login novamente.')
      this.router.navigate(['/entrar'])
    }

    this.findAllCategorias()
  }


  findAllCategorias() {
    this.categoriaService.getAllCategoria().subscribe((resp: Categoria[])=> {
      this.listaCategorias = resp      
    })

  }

  cadastrar(){
    
    console.log("postagem "+JSON.stringify(this.categoria))
    this.categoriaService.postCategoria(this.categoria).subscribe((resp: Categoria)=> {
      this.categoria = resp
     alert('Categoria cadastrada com sucesso!')
     this.findAllCategorias()
     this.categoria = new Categoria
    })
  }

}
