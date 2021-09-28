import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';



@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})  
export class CadastrarComponent implements OnInit {

user: User = new User
confirmarSenha: string
tipoUsuario: string
senha: string

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0, 0) 

  }

  confirmSenha(event:any) {
    this.confirmarSenha = event.target.value
  }

  tipoUser(event: any){
    this.tipoUsuario = event.target.value
  }

  cadastrar(){
    this.user.tipo = this.tipoUsuario

    if(this.user.senha != this.confirmarSenha){
      alert('As senhas estão incorretas.')
    } else{/*console.log(this.user.id)
      console.log(this.user.tipo)
      console.log(this.user.email)
      console.log(this.user.foto)
      console.log(this.user.nome)
      console.log(this.user.login)
      console.log(this.user.cpf)
      console.log(this.user.cnpj)
      console.log(this.user.senha)
      console.log(this.user.Linkedin)*/
      this.authService.cadastrar(this.user).subscribe((resp: User)=> {
        this.user = resp
        console.log(JSON.stringify(resp))
        this.router.navigate(['/entrar'])

        alert('Usuário cadastrado com Sucesso!')
      })
    }
  }

  
}
