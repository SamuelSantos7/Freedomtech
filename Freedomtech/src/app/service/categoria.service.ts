import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllCategoria(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>('https://freedomtech.herokuapp.com/freedomtech/categoria/todos', this.token)
  }

  getByIdCategoria(id:number): Observable<Categoria>{
    return this.http.get<Categoria>(`https://freedomtech.herokuapp.com/freedomtech/categoria/${id}`, this.token)
  }

  /*getByCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.get<Categoria>('https://freedomtech.herokuapp.com/freedomtech/categoria/Categoria', categoria, this.token)
  }*/

  postCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.post<Categoria>('https://freedomtech.herokuapp.com/freedomtech/categoria/salvar', categoria, this.token)
  }

  putCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.put<Categoria>('https://freedomtech.herokuapp.com/freedomtech/categoria/alterar', categoria, this.token)
  }

  
  deleteCategoria(id:number) {
    return this.http.delete(`https://freedomtech.herokuapp.com/freedomtech/categoria/deletar/${id}`, this.token)
  }

}
