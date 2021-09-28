import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { UserLogin } from '../model/UserLogin';
import { environment } from 'src/environments/environment.prod';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

    login(userLogin: UserLogin): Observable<UserLogin>{
      return this.http.post<UserLogin>('https://freedomtech.herokuapp.com/freedomtech/usuario/logar', userLogin)
    }

    cadastrar(user: User): Observable<User>{
      return this.http.post<User>('https://freedomtech.herokuapp.com/freedomtech/usuario/salvar', user)
    }

    getByidUser(id: number): Observable<User>{
      return this.http.get<User>(`https://freedomtech.herokuapp.com/freedomtech/usuario/${id}`)
    }

    logado(){
      let ok: boolean = false
  
      if(environment.token != ''){
        ok = true
      }
  
  
      return ok
    }
}
